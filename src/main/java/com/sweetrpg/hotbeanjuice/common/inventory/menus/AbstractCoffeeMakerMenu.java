package com.sweetrpg.hotbeanjuice.common.inventory.menus;

import com.sweetrpg.hotbeanjuice.common.block.entity.DripCoffeeBlockEntity;
import com.sweetrpg.hotbeanjuice.common.item.crafting.AbstractBrewingRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public abstract class AbstractCoffeeMakerMenu extends AbstractContainerMenu {
    private final DripCoffeeBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;
    RecipeType<? extends AbstractBrewingRecipe> recipeType;

    public AbstractCoffeeMakerMenu(MenuType<?> menuType, RecipeType<? extends AbstractBrewingRecipe> recipeType, int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(menuType, recipeType, containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public AbstractCoffeeMakerMenu(MenuType<?> menuType, RecipeType<? extends AbstractBrewingRecipe> recipeType, int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(menuType, containerId);
        this.recipeType = recipeType;

        checkContainerSize(inv, 5);
        blockEntity = ((DripCoffeeBlockEntity) entity);
        this.level = inv.player.level;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 61, 35));
//            this.addSlot(new SlotItemHandler(handler, 1, 31, 51));
        });

        addDataSlots(data);
    }

    /* Credit to diesieben07 | https://github.com/diesieben07/SevenCommons */
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 1;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, ModBlocks.DRIP_COFFEE_MAKER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public int getScaledProgress() {
        int progress = this.data.get(0); //Current progress
        int maxProgress = this.data.get(1);  // Total possible progress
        int progressArrowSize = 19;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public FluidStack getWater() {
        return new FluidStack(Fluids.WATER, this.data.get(2));
    }

    public int getWaterLevel(int progress) {
//        int progress = this.getWater().getAmount(); //this.data.get(4);
        int maxProgress = this.data.get(4); //
        int progressSize = 52;

        return maxProgress != 0 && progress != 0 ? progress * progressSize / maxProgress : 0;
    }

    public FluidStack getCoffee() {
        //TODO change to coffee fluid
        return new FluidStack(Fluids.LAVA, this.data.get(3));
    }

    public int getMaxFluid() {
        return this.data.get(4);
    }
}