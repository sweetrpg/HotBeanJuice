package com.sweetrpg.hotbeanjuice.common.inventory.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;

public class GrindingContainer implements Container, StackedContentsCompatible {
    private final NonNullList<ItemStack> items;
    private final int width;
    private final int height;
    private final AbstractContainerMenu menu;

    public GrindingContainer(AbstractContainerMenu menu, int width, int height) {
        this.items = NonNullList.withSize(width * height, ItemStack.EMPTY);
        this.menu = menu;
        this.width = width;
        this.height = height;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if(!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getItem(int index) {
        return index >= this.getContainerSize() ? ItemStack.EMPTY : this.items.get(index);
    }

    public ItemStack removeItemNoUpdate(int item) {
        return ContainerHelper.takeItem(this.items, item);
    }

    public ItemStack removeItem(int startIndex, int endIndex) {
        ItemStack itemstack = ContainerHelper.removeItem(this.items, startIndex, endIndex);
        if(!itemstack.isEmpty()) {
            this.menu.slotsChanged(this);
        }

        return itemstack;
    }

    public void setItem(int index, ItemStack itemStack) {
        this.items.set(index, itemStack);
        this.menu.slotsChanged(this);
    }

    public void setChanged() {
    }

    public boolean stillValid(Player player) {
        return true;
    }

    public void clearContent() {
        this.items.clear();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void fillStackedContents(StackedContents contents) {
        for(ItemStack itemstack : this.items) {
            contents.accountSimpleStack(itemstack);
        }

    }
}
