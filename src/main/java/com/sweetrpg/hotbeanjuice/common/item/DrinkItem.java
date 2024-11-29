package com.sweetrpg.hotbeanjuice.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class DrinkItem extends Item {

    public DrinkItem(Properties pProperties) {
        super(pProperties);
    }

    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

}
