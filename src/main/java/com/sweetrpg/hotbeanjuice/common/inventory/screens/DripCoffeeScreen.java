package com.sweetrpg.hotbeanjuice.common.inventory.screens;

import com.sweetrpg.hotbeanjuice.common.inventory.menus.DripCoffeeMenu;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DripCoffeeScreen extends AbstractCoffeeMakerScreen<DripCoffeeMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/gui/drip_coffee.png");

    public DripCoffeeScreen(DripCoffeeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, TEXTURE);
    }
}