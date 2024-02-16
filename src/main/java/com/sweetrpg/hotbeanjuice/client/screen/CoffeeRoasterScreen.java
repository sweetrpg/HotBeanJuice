package com.sweetrpg.hotbeanjuice.client.screen;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.sweetrpg.hotbeanjuice.common.inventory.menu.CoffeeRoasterMenu;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collections;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class CoffeeRoasterScreen extends AbstractContainerScreen<CoffeeRoasterMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/gui/coffee_roaster.png");
    private List<Component> tooltip = Lists.newArrayList();

    public CoffeeRoasterScreen(CoffeeRoasterMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);

        int i = this.leftPos;
        int j = this.topPos;

//        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
//        int k = this.menu.getFluidLevel();
//        int l = this.menu.getFluidType();
////        blit(poseStack, x + 52, y + 17 + 52, 176 - 9 + (l * 9), 29, 9, ); //FLUID LEVEL
//        blit(poseStack, x + 52, y + 17 + 52 - k, 176 - 9 + (l * 9), 29, 9, k); //FLUID LEVEL
//
//        blit(poseStack, x + 31, y + 36, 177, 14, menu.getScaledProgress(), 14); //SMELTING ARROW
//
//        int m = this.menu.getLitProgress();
//        if(menu.isLit()) {
//            blit(poseStack, x + 14, y + 36 + 12 - m, 176, 12 - m, 14, m + 1); //FLAME
//        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int i = this.leftPos;
        int j = this.topPos;

//        if (isHovering(x - i + 52, y - j + 17, 9, 52, mouseX, mouseY)) {
//            tooltip = Lists.newArrayList();
//            this.tooltip.add(new TranslatableComponent(String.valueOf(menu.getFluidTypeString())));
//            this.tooltip.add(new TranslatableComponent(menu.getFluidQuantity() + " / 4000 mb"));
//            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
//        }
    }

}