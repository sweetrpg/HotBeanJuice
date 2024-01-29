package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.block.AbstractCoffeePotBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public abstract class AbstractCoffeePotBlockEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelBurnTime;
    private int maxFuelBurnTime;
    private int fluidLevel;
    public static int maxFluidLevel = FluidAttributes.BUCKET_VOLUME * 4;

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    protected FluidTank fluidHandler = new FluidTank(maxFluidLevel);
    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.of(() -> fluidHandler);
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public AbstractCoffeePotBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> AbstractCoffeePotBlockEntity.this.progress;
                    case 1 -> AbstractCoffeePotBlockEntity.this.maxProgress;
                    case 2 -> AbstractCoffeePotBlockEntity.this.fuelBurnTime;
                    case 3 -> AbstractCoffeePotBlockEntity.this.maxFuelBurnTime;
                    case 4 -> AbstractCoffeePotBlockEntity.this.fluidLevel;
                    case 5 -> maxFluidLevel;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AbstractCoffeePotBlockEntity.this.progress = value;
                    case 1 -> AbstractCoffeePotBlockEntity.this.maxProgress = value;
                    case 2 -> AbstractCoffeePotBlockEntity.this.fuelBurnTime = value;
                    case 3 -> AbstractCoffeePotBlockEntity.this.maxFuelBurnTime = value;
                    case 4 -> AbstractCoffeePotBlockEntity.this.fluidLevel = value;
                    case 5 -> maxFluidLevel = value;
                }
            }

            public int getCount() {
                return 7;
            }
        };
    }

    public FluidTank getFluidTank() {
        return fluidHandler;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return lazyFluidHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyFluidHandler = LazyOptional.of(() -> fluidHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyFluidHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);
        tag.putInt("fuelBurnTime", fuelBurnTime);
        tag.putInt("fluidLevel", fluidLevel);

        fluidHandler.writeToNBT(tag);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        fluidHandler.readFromNBT(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("progress");
        fuelBurnTime = nbt.getInt("fuelBurnTime");
        fluidLevel = nbt.getInt("fluidLevel");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private boolean isLit() {
        return this.fuelBurnTime > 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AbstractCoffeePotBlockEntity blockEntity) {
        boolean lit = blockEntity.isLit();
        boolean changed = false;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());

        //water slot/tank, holds 4? buckets worth
        //fuel slot for coal, etc.
        //slot for coffee filter
        //does filter need to be replaced every pot or every few pots? perhaps every 4 bucket-fulls (so 1 full pot)?
        //coffee grinds slot

        //TODO when checking for recipe, check for coffee filter as well

        //if equal to/less than 1/10 a bucket, empty the fluid (because it's not enough to be useful)
        if (blockEntity.fluidHandler.getFluidAmount() <= 100) {
            blockEntity.fluidHandler.drain(blockEntity.fluidHandler.getFluid(), IFluidHandler.FluidAction.EXECUTE);
            blockEntity.fluidLevel = 0;
        }

        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        //if lit, decrement fuel usage timer
        if (lit) {
            blockEntity.fuelBurnTime--;
        }

        ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(1);
        ItemStack coffeeGrindsSlot = blockEntity.itemHandler.getStackInSlot(0);

        //if we're adding fluid (water) via bucket, this does it instantly and also returns an empty bucket
        if (coffeeGrindsSlot.getItem() instanceof BucketItem && hasRecipe(blockEntity)) {
            percolate(blockEntity);
            blockEntity.itemHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
        }

        //lit OR has fuel & coffee grinds slot isn't empty
        if (blockEntity.isLit() || (!fuelItem.isEmpty() && !coffeeGrindsSlot.isEmpty())) {
//           Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
//           FluidStack fluid = recipe.get().getResultFluid();

            //not lit and has recipe
            if (!blockEntity.isLit() && hasRecipe(blockEntity)) {
                //get recipe for coffee TODO
                //Optional<AbstractCoffeeRecipe> recipe = level.getRecipeManager().getRecipeFor(AbstractCoffeeRecipe.Type.INSTANCE, inventory, level);

                //recipe exists and we have room for more fluid/fluid is same type TODO
                //if (recipe.isPresent() && canAddFluid(blockEntity, recipe.get().getResultFluid())) {

                    //set values
                    blockEntity.fuelBurnTime = net.minecraftforge.common.ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
                    blockEntity.maxFuelBurnTime = blockEntity.fuelBurnTime;

                    //if lit by now
                    if (blockEntity.isLit()) {
                        changed = true;

                        //use up 1 fuel item
                        if (fuelItem.hasContainerItem())
                            blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
                        else if (!fuelItem.isEmpty()) {
                            fuelItem.shrink(1);
                            if (fuelItem.isEmpty()) {
                                blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
                            }
                        }
                    }
                //}
            }
            //lit and has recipe
            if (blockEntity.isLit() && hasRecipe(blockEntity)) {
                //get recipe TODO
//                Optional<AbstractCoffeeRecipe> recipe = level.getRecipeManager().getRecipeFor(AbstractCoffeeRecipe.Type.INSTANCE, inventory, level);

                //if recipe is present and fluid checks pass TODO
//                if (recipe.isPresent() && canAddFluid(blockEntity, recipe.get().getResultFluid()) && hasRoomForFluid(blockEntity, recipe.get())) {

                    //get how long it will take to brew TODO
                    blockEntity.maxProgress = 100; //recipe.get().getCookingTime();

                    //increment progress
                    blockEntity.progress++;

                    //if completed
                    if (blockEntity.progress == blockEntity.maxProgress) {

                        //reset
                        blockEntity.progress = 0;
                        blockEntity.maxProgress = 100; //recipe.get().getCookingTime(); FIXME

                        //create coffee
                        percolate(blockEntity);

                        //TODO reward XP?
                        changed = true;
                    }
                //}
            } else { //not lit, no recipe
                blockEntity.progress = 0;
            }

        //not lit, but we made progress on recipe
        } else if (!blockEntity.isLit() && blockEntity.progress > 0) {
            blockEntity.progress = Mth.clamp(blockEntity.progress - 2, 0, blockEntity.maxProgress);
        }

        if (lit != blockEntity.isLit()) {
            //update block state
            changed = true;
            state = state.setValue(AbstractCoffeePotBlock.LIT, blockEntity.isLit());
            level.setBlock(pos, state, 3);
        }

        if (changed) {
            setChanged(level, pos, state);
        }
    }

    private static boolean hasRecipe(AbstractCoffeePotBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        //TODO
//        Optional<AbstractCoffeeRecipe> match = level.getRecipeManager().getRecipeFor(AbstractCoffeeRecipe.Type.INSTANCE, inventory, level);

//        return match.isPresent();
        return false; //FIXME
    }


    private static void percolate(AbstractCoffeePotBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        //TODO
//        Optional<AbstractCoffeeRecipe> recipe = level.getRecipeManager().getRecipeFor(AbstractCoffeeRecipe.Type.INSTANCE, inventory, level);
//        if (recipe.isPresent()) {
//            blockEntity.itemHandler.extractItem(0, 1, false);
//
//            FluidStack fluid = recipe.get().getResultFluid();
//
//              //update fluid amount with appropriate fluid
//            fluid.setAmount((int) ((float) FluidAttributes.BUCKET_VOLUME * recipe.get().getBuckets()));
//            blockEntity.fluidHandler.fill(fluid, IFluidHandler.FluidAction.EXECUTE);
//            blockEntity.fluidLevel = blockEntity.fluidHandler.getFluidAmount();
//            setFluidType(blockEntity);
//
//        }
    }

    private static boolean canAddFluid(AbstractCoffeePotBlockEntity blockEntity, FluidStack result) {
        if (!blockEntity.fluidHandler.isFluidValid(result)) {
            return false;
        } else return blockEntity.fluidHandler.getSpace() != 0;
    }

    //TODO
//    private static boolean hasRoomForFluid(AbstractCoffeePotBlockEntity blockEntity, AbstractCoffeeRecipe recipe) {
//        return blockEntity.fluidHandler.getSpace() >= (int) (recipe.getBuckets() * (float) FluidAttributes.BUCKET_VOLUME);
//    }

}
