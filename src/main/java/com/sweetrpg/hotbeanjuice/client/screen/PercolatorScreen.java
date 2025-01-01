package com.sweetrpg.hotbeanjuice.client.screen;


import com.sweetrpg.hotbeanjuice.common.Constants;
import com.sweetrpg.hotbeanjuice.common.inventory.menus.PercolatorMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PercolatorScreen extends AbstractCoffeeMakerScreen<PercolatorMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/gui/percolator.png");

    public PercolatorScreen(PercolatorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, TEXTURE);
    }
}
