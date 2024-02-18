package com.sweetrpg.hotbeanjuice.common.inventory.menus;

import com.sweetrpg.hotbeanjuice.common.block.entity.CoffeeRoasterBlockEntity;
import com.sweetrpg.hotbeanjuice.common.inventory.container.CoffeeRoastingContainer;
import com.sweetrpg.hotbeanjuice.common.inventory.container.slot.CoffeeRoasterResultSlot;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModContainerTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CoffeeRoasterMenu extends RecipeBookMenu<CoffeeRoastingContainer> {
    private final CoffeeRoasterBlockEntity blockEntity;
    private final ContainerData data;
    private final CoffeeRoastingContainer craftSlots;
    private final ResultContainer resultSlots = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;

    private static final int FUEL_X = 27;
    private static final int FUEL_Y = 29;
    private static final int GAP = 3;
    private static final int WELL_WIDTH = 16;
    private static final int START_X = 64;
    private static final int COMPONENT_Y = 60;
    private static final int RESULT_Y = 8;

    public CoffeeRoasterMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7), ContainerLevelAccess.NULL);
    }

    public CoffeeRoasterMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data, ContainerLevelAccess access) {
        super(ModContainerTypes.COFFEE_ROASTER_MENU.get(), containerId);

        checkContainerSize(inv, 11);
        this.blockEntity = (CoffeeRoasterBlockEntity) entity;
        this.data = data;
        this.access = access;
        this.player = inv.player;
        this.craftSlots = new CoffeeRoastingContainer(this, 5, 1);

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, FUEL_X, FUEL_Y)); //smelting slot
            this.addSlot(new Slot(this.craftSlots, 0, START_X + (0 * (WELL_WIDTH + GAP)), COMPONENT_Y)); //component slot 1
            this.addSlot(new Slot(this.craftSlots, 1, START_X + (1 * (WELL_WIDTH + GAP)), COMPONENT_Y)); //component slot 2
            this.addSlot(new Slot(this.craftSlots, 2, START_X + (2 * (WELL_WIDTH + GAP)), COMPONENT_Y)); //component slot 3
            this.addSlot(new Slot(this.craftSlots, 3, START_X + (3 * (WELL_WIDTH + GAP)), COMPONENT_Y)); //component slot 4
            this.addSlot(new Slot(this.craftSlots, 4, START_X + (4 * (WELL_WIDTH + GAP)), COMPONENT_Y)); //component slot 5
            this.addSlot(new CoffeeRoasterResultSlot(inv.player, this.craftSlots, this.resultSlots, 5, START_X + (0 * (WELL_WIDTH + GAP)), RESULT_Y)); //result slot 1
            this.addSlot(new CoffeeRoasterResultSlot(inv.player, this.craftSlots, this.resultSlots, 6, START_X + (1 * (WELL_WIDTH + GAP)), RESULT_Y)); //result slot 2
            this.addSlot(new CoffeeRoasterResultSlot(inv.player, this.craftSlots, this.resultSlots, 7, START_X + (2 * (WELL_WIDTH + GAP)), RESULT_Y)); //result slot 3
            this.addSlot(new CoffeeRoasterResultSlot(inv.player, this.craftSlots, this.resultSlots, 8, START_X + (3 * (WELL_WIDTH + GAP)), RESULT_Y)); //result slot 4
            this.addSlot(new CoffeeRoasterResultSlot(inv.player, this.craftSlots, this.resultSlots, 9, START_X + (4 * (WELL_WIDTH + GAP)), RESULT_Y)); //result slot 5
        });

        addDataSlots(data);
    }

    public boolean isSmelting() {
        return data.get(0) > 0;
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedContents itemHelper) {
        this.craftSlots.fillStackedContents(itemHelper);
    }

    @Override
    public void clearCraftingContent() {
        this.craftSlots.clearContent();
        this.resultSlots.clearContent();
    }

    @Override
    public boolean recipeMatches(Recipe<? super CoffeeRoastingContainer> recipe) {
        return recipe.matches(this.craftSlots, this.player.level);
    }

    @Override
    public int getResultSlotIndex() {
        return 0;
    }

    @Override
    public int getGridWidth() {
        return 5;
    }

    @Override
    public int getGridHeight() {
        return 1;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }

    @Override
    public boolean shouldMoveToInventory(int slotIndex) {
        return slotIndex != this.getResultSlotIndex();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(player.level, blockEntity.getBlockPos()), player, ModBlocks.COFFEE_ROASTER.get());

    }

    private void addPlayerInventory(Inventory playerInventory) {
        for(int row = 0; row < 3; ++row) {
            for(int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18)); //8 + l * 18, 86 + l * 18
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for(int slot = 0; slot < 9; ++slot) {
            this.addSlot(new Slot(playerInventory, slot, 8 + slot * 18, 142)); //144
        }
    }

}
