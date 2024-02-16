package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.inventory.menu.CoffeeRoasterMenu;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CoffeeRoasterBlockEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelBurnTime = 0;
    private int maxFuelBurnTime;

    private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public CoffeeRoasterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntityTypes.COFFEE_ROASTER.get(), pPos, pBlockState);

        this.data = new ContainerData() {
            public int get(int index) {
                return switch(index) {
                    case 0 -> CoffeeRoasterBlockEntity.this.progress;
                    case 1 -> CoffeeRoasterBlockEntity.this.maxProgress;
                    case 2 -> CoffeeRoasterBlockEntity.this.fuelBurnTime;
                    case 3 -> CoffeeRoasterBlockEntity.this.maxFuelBurnTime;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0 -> CoffeeRoasterBlockEntity.this.progress = value;
                    case 1 -> CoffeeRoasterBlockEntity.this.maxProgress = value;
                    case 2 -> CoffeeRoasterBlockEntity.this.fuelBurnTime = value;
                    case 3 -> CoffeeRoasterBlockEntity.this.maxFuelBurnTime = value;
                }
            }

            public int getCount() {
                return 7;
            }
        };

    }

    public static void tick(Level level, BlockPos pos, BlockState state, CoffeeRoasterBlockEntity blockEntity) {
        // TODO
    }

    @Override
    public @NotNull Component getDisplayName() {
        return new TranslatableComponent(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new CoffeeRoasterMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(player.getLevel(), this.getBlockPos()));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("coffee_roaster_smelting.progress", progress);
        tag.putInt("coffee_roaster_smelting.fuelBurnTime", fuelBurnTime);

        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("coffee_roaster_smelting.progress");
        fuelBurnTime = nbt.getInt("coffee_roaster_smelting.fuelBurnTime");
    }

}
