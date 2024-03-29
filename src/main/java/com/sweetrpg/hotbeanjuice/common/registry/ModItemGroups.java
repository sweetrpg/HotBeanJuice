package com.sweetrpg.hotbeanjuice.common.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class ModItemGroups {

    public static final CreativeModeTab GENERAL = new CustomItemGroup("hotbeanjuice", () -> new ItemStack(ModBlocks.COFFEE_CUP.get()));

    public static class CustomItemGroup extends CreativeModeTab {

        private Supplier<ItemStack> icon;

        public CustomItemGroup(String label, Supplier<ItemStack> iconIn) {
            super(label);
            this.icon = iconIn;
        }

        @Override
        public ItemStack makeIcon() {
            return this.icon.get();
        }
    }
}
