package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.AbstractCoffeeMakerBlock;
import com.sweetrpg.hotbeanjuice.common.block.AbstractPoweredCoffeeMakerBlock;
import com.sweetrpg.hotbeanjuice.common.item.crafting.AbstractBrewingRecipe;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
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
import java.util.Optional;

public abstract class AbstractPoweredCoffeeMakerBlockEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelBurnTime;
    private int maxFuelBurnTime;
    private int waterLevel;
    private int coffeeLevel;
    public static int maxFluidLevel = FluidAttributes.BUCKET_VOLUME * 4;

    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    protected FluidTank coffeeHandler = new FluidTank(maxFluidLevel);
    protected FluidTank waterHandler = new FluidTank(maxFluidLevel);
    private LazyOptional<IFluidHandler> lazyCoffeeHandler = LazyOptional.of(() -> coffeeHandler);
    private LazyOptional<IFluidHandler> lazyWaterHandler = LazyOptional.of(() -> waterHandler);
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final RecipeType<? extends AbstractBrewingRecipe> recipeType;

    public AbstractPoweredCoffeeMakerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState, RecipeType<? extends AbstractBrewingRecipe> recipeType) {
        super(type, pos, blockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> AbstractPoweredCoffeeMakerBlockEntity.this.progress;
                    case 1 -> AbstractPoweredCoffeeMakerBlockEntity.this.maxProgress;
                    case 2 -> AbstractPoweredCoffeeMakerBlockEntity.this.waterLevel;
                    case 3 -> AbstractPoweredCoffeeMakerBlockEntity.this.coffeeLevel;
                    case 4 -> maxFluidLevel;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AbstractPoweredCoffeeMakerBlockEntity.this.progress = value;
                    case 1 -> AbstractPoweredCoffeeMakerBlockEntity.this.maxProgress = value;
                    case 2 -> AbstractPoweredCoffeeMakerBlockEntity.this.waterLevel = value;
                    case 3 -> AbstractPoweredCoffeeMakerBlockEntity.this.coffeeLevel = value;
                    case 4 -> {}
                }
            }

            public int getCount() {
                return 5;
            }
        };
        this.recipeType = recipeType;
    }

    public FluidTank getCoffeeTank() {
        return coffeeHandler;
    }

    public FluidTank getWaterTank() {
        return waterHandler;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return lazyCoffeeHandler.cast(); //FIXME?
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyCoffeeHandler = LazyOptional.of(() -> coffeeHandler);
        lazyWaterHandler = LazyOptional.of(() -> waterHandler);

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyCoffeeHandler.invalidate();
        lazyWaterHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);
        tag.putInt("fuelBurnTime", fuelBurnTime);
        tag.putInt("waterLevel", waterLevel);
        tag.putInt("coffeeLevel", coffeeLevel);

        coffeeHandler.writeToNBT(tag);
        waterHandler.writeToNBT(tag);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        waterHandler.readFromNBT(nbt);
        coffeeHandler.readFromNBT(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("progress");
        fuelBurnTime = nbt.getInt("fuelBurnTime");
        waterLevel = nbt.getInt("waterLevel");
        coffeeLevel = nbt.getInt("coffeeLevel");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private boolean isLit(BlockState state) {
        return state.getValue(AbstractPoweredCoffeeMakerBlock.LIT);
//        return this.fuelBurnTime > 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AbstractPoweredCoffeeMakerBlockEntity blockEntity) {
        boolean lit = blockEntity.isLit(state);
//        boolean changed = false;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());

//        HotBeanJuice.LOGGER.debug("water handler amount: " + blockEntity.waterHandler.getFluidAmount() + ", waterLevel amount: " + blockEntity.waterLevel);

        //water slot/tank, holds 4? buckets worth
        //fuel slot for coal, etc.
        //slot for coffee filter
        //does filter need to be replaced every pot or every few pots? perhaps every 4 bucket-fulls (so 1 full pot)?
        //coffee grinds slot

        //TODO when checking for recipe, check for coffee filter as well

        //if equal to/less than 1/10 a bucket, empty the fluid (because it's not enough to be useful)
        if (blockEntity.waterHandler.getFluidAmount() <= 100) {
            blockEntity.waterHandler.drain(blockEntity.waterHandler.getFluid(), IFluidHandler.FluidAction.EXECUTE);
            blockEntity.waterLevel = 0;
        }
        if (blockEntity.coffeeHandler.getFluidAmount() <= 100) {
            blockEntity.coffeeHandler.drain(blockEntity.coffeeHandler.getFluid(), IFluidHandler.FluidAction.EXECUTE);
            blockEntity.coffeeLevel = 0;
        }

        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        //if lit, decrement fuel usage timer
        if (lit) {
            blockEntity.fuelBurnTime--;
        }

//        ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(1);
        ItemStack coffeeGrindsSlot = blockEntity.itemHandler.getStackInSlot(0);

        //if we're adding fluid (water) via bucket, this does it instantly and also returns an empty bucket
        if (coffeeGrindsSlot.getItem() instanceof BucketItem && hasRecipe(blockEntity)) {
            brew(blockEntity, state);
            blockEntity.itemHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
        }

        //lit OR has fuel & coffee grinds slot isn't empty
        if (lit && !coffeeGrindsSlot.isEmpty()) {
            Optional<AbstractBrewingRecipe> recipe = level.getRecipeManager().getRecipeFor((RecipeType<AbstractBrewingRecipe>) blockEntity.recipeType, inventory, level);
//            FluidStack fluid = new FluidStack(Fluids.WATER, 10); //recipe.get().getResultFluid();

            //not lit and has recipe
//            if (!lit && hasRecipe(blockEntity)) {
//                //get recipe for coffee
//                recipe = level.getRecipeManager().getRecipeFor((RecipeType<AbstractBrewingRecipe>) blockEntity.recipeType, inventory, level);
//
//                //recipe exists, and we have room for more fluid/fluid is same type
//                if (recipe.isPresent() && canAddFluid(blockEntity, recipe.get().getResultFluid())) {
//
//                    //set values
////                    blockEntity.fuelBurnTime = net.minecraftforge.common.ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
////                    blockEntity.maxFuelBurnTime = blockEntity.fuelBurnTime;
//
//                    //if lit by now
////                    if (blockEntity.isLit()) {
////                        changed = true;
////
////                        //use up 1 fuel item
////                        if (fuelItem.hasContainerItem())
////                            blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
////                        else if (!fuelItem.isEmpty()) {
////                            fuelItem.shrink(1);
////                            if (fuelItem.isEmpty()) {
////                                blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
////                            }
////                        }
////                    }
//                }
//            }
            //lit and has recipe
            if (lit && hasRecipe(blockEntity)) {
                //get recipe
                recipe = level.getRecipeManager().getRecipeFor((RecipeType<AbstractBrewingRecipe>) blockEntity.recipeType, inventory, level);
                FluidStack coffee = new FluidStack(Fluids.LAVA, recipe.get().getMillibuckets()); //FIXME set to coffee fluid

                //if recipe is present and fluid checks pass
                if (recipe.isPresent() && canAddCoffee(blockEntity, coffee) && hasEnoughWater(blockEntity, recipe.get())) {

                    //get how long it will take to brew
                    blockEntity.maxProgress = recipe.get().getBrewingTime();

                    //increment progress
                    blockEntity.progress++;

                    //if completed
                    if (blockEntity.progress == blockEntity.maxProgress) {

                        //brew coffee
                        brew(blockEntity, state);

                        //reset
                        blockEntity.progress = 0;
                        blockEntity.maxProgress = recipe.get().getBrewingTime();
                    }
                }
            } else { //not lit, no recipe
                blockEntity.progress = 0;
            }

            //not lit, but we made progress on recipe
        } else if (!lit && blockEntity.progress > 0) {
            blockEntity.progress = Mth.clamp(blockEntity.progress - 2, 0, blockEntity.maxProgress);
        }
    }

    private static boolean hasRecipe(AbstractPoweredCoffeeMakerBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<AbstractBrewingRecipe> recipe = level.getRecipeManager().getRecipeFor((RecipeType<AbstractBrewingRecipe>) blockEntity.recipeType, inventory, level);

        return recipe.isPresent();
    }

    private static void brew(AbstractPoweredCoffeeMakerBlockEntity blockEntity, BlockState state) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<AbstractBrewingRecipe> recipe = level.getRecipeManager().getRecipeFor((RecipeType<AbstractBrewingRecipe>) blockEntity.recipeType, inventory, level);
        if (recipe.isPresent()) {
            blockEntity.itemHandler.extractItem(0, 1, false);
            //TODO if coffee filter config true, damage coffee filter?

            FluidStack water = new FluidStack(Fluids.WATER, recipe.get().getMillibuckets());
            FluidStack coffee = new FluidStack(Fluids.LAVA, recipe.get().getMillibuckets()); //FIXME set to coffee fluid

            //update fluids
            blockEntity.coffeeHandler.fill(coffee, IFluidHandler.FluidAction.EXECUTE);
            blockEntity.waterHandler.drain(water, IFluidHandler.FluidAction.EXECUTE);

            blockEntity.coffeeLevel = blockEntity.coffeeHandler.getFluidAmount();
            blockEntity.waterLevel = blockEntity.waterHandler.getFluidAmount();

            //update fullness on block
            state = state.setValue(AbstractCoffeeMakerBlock.FULLNESS, blockEntity.coffeeLevel / FluidAttributes.BUCKET_VOLUME);
            level.setBlock(blockEntity.getBlockPos(), state, 3);
            setChanged(level, blockEntity.getBlockPos(), state);
        }
    }

    private static boolean canAddCoffee(AbstractPoweredCoffeeMakerBlockEntity blockEntity, FluidStack coffee) {
        if (!blockEntity.coffeeHandler.isFluidValid(coffee)) {
            return false;
        } else {
            return blockEntity.coffeeHandler.getSpace() != 0;
        }
    }

    private static boolean hasRoomForCoffee(AbstractPoweredCoffeeMakerBlockEntity blockEntity, AbstractBrewingRecipe recipe) {
        return blockEntity.coffeeHandler.getSpace() >= recipe.getMillibuckets();
    }

    public static boolean hasRoomForWater(AbstractPoweredCoffeeMakerBlockEntity blockEntity) {
        return blockEntity.waterHandler.getSpace() > 0;
    }

    private static boolean hasEnoughWater(AbstractPoweredCoffeeMakerBlockEntity blockEntity, AbstractBrewingRecipe recipe) {
        return blockEntity.waterHandler.getFluidAmount() >= recipe.getMillibuckets();
    }

    public void addWater(int numMillibuckets) {
        FluidStack water = new FluidStack(Fluids.WATER, numMillibuckets);

        this.waterHandler.fill(water, IFluidHandler.FluidAction.EXECUTE);
        this.waterLevel = this.waterHandler.getFluidAmount();
    }

    public void emptyCoffee() {
        this.coffeeLevel = 0;
        this.coffeeHandler.drain(this.coffeeHandler.getCapacity(), IFluidHandler.FluidAction.EXECUTE);
        HotBeanJuice.LOGGER.debug("coffee: " + this.coffeeHandler.getFluidAmount() + " " + this.coffeeLevel);
    }
}