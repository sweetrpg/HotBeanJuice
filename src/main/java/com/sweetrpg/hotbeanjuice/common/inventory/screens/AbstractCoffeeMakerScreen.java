package com.sweetrpg.hotbeanjuice.common.inventory.screens;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.sweetrpg.hotbeanjuice.common.inventory.menus.AbstractCoffeeMakerMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class AbstractCoffeeMakerScreen<T extends AbstractCoffeeMakerMenu> extends AbstractContainerScreen<T> {
    private final ResourceLocation texture;
    private List<Component> tooltip = Lists.newArrayList();
    int animationTick = 0;
    int animationLoc = 0;

    public AbstractCoffeeMakerScreen(T pMenu, Inventory pPlayerInventory, Component pTitle, ResourceLocation texture) {
        super(pMenu, pPlayerInventory, pTitle);
        this.texture = texture;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, texture);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        int i = this.leftPos;
        int j = this.topPos;

        //TODO change placement
        blit(pPoseStack, x + 96, y + 36, 177, 14, menu.getScaledProgress(), 14); //PROGRESS ARROW

        renderFluidSlot(pPoseStack, pMouseX, pMouseY, x + 19, y + 17, 52, 9, this.menu.getWater(), this.menu.getMaxFluid());

        renderFluidSlot(pPoseStack, pMouseX, pMouseY, x + 146, y + 17, 52, 9, this.menu.getCoffee(), this.menu.getMaxFluid());

    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);
    }

    public void renderFluidSlot(PoseStack poseStack, int mouseX, int mouseY, int positionX, int positionY, int height, int width, FluidStack fluid, int maxCapacity) {
        //Render fluid
        if (!fluid.isEmpty()) {
            RenderSystem.resetTextureMatrix();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            poseStack.pushPose();

            int fluidLevel = this.menu.getWaterLevel(fluid.getAmount());

            ResourceLocation tex = new ResourceLocation(fluid.getFluid().getAttributes().getStillTexture().getNamespace(),
                    "textures/" + fluid.getFluid().getAttributes().getStillTexture().getPath() + ".png");
            int color = fluid.getFluid().getAttributes().getColor();
            setGLColorFromInt(color, 1.0F);

            RenderSystem.setShaderTexture(0, tex);
            if (animationTick % 16 == 0) animationLoc += 16;
            int texLength = 512;
            blit(poseStack, positionX, positionY + height - fluidLevel, 0, animationLoc, width, fluidLevel, 16, texLength); //FLUID LEVEL

            poseStack.popPose();
            animationTick++;
            if (animationTick > (texLength)) {
                animationTick = 0;
                animationLoc = 0;
            }
        }

        //Render highlight and tooltip
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (isHovering(positionX - this.leftPos, positionY - this.topPos, width, height, mouseX, mouseY)) {
            renderFluidSlotHighlight(poseStack, positionX, positionY, width, height, 400, slotColor, slotColor);
            if (!fluid.isEmpty()) {
                tooltip = Lists.newArrayList();
                this.tooltip.add(fluid.getDisplayName());
                this.tooltip.add(new TranslatableComponent(fluid.getAmount() + " / " + maxCapacity + " mb"));
                this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
            }
        }
    }

    //credit JEI
    private static void setGLColorFromInt(int color, float alpha) {
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        RenderSystem.setShaderColor(red, green, blue, alpha);
    }

    public static void renderFluidSlotHighlight(PoseStack poseStack, int pX, int pY, int width, int height, int pBlitOffset, int slotColor, int slotColor2) {
        RenderSystem.disableDepthTest();
        RenderSystem.colorMask(true, true, true, false);
        fillGradient(poseStack, pX, pY, pX + width, pY + height, slotColor, slotColor2, pBlitOffset);
        RenderSystem.colorMask(true, true, true, true);
        RenderSystem.enableDepthTest();
    }

}
