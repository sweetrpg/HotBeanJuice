package com.sweetrpg.hotbeanjuice.integration.jei.resource;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sweetrpg.hotbeanjuice.common.util.ClientRenderUtil;
import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GrinderDrawable implements IDrawable {
    private final Supplier<ItemStack> supplier;
    private ItemStack stack;

    public GrinderDrawable(Supplier<ItemStack> supplier) {
        this.supplier = supplier;
    }

    @Override
    public int getWidth() {
        return 48;
    }

    @Override
    public int getHeight() {
        return 48;
    }

    @Override
    public void draw(PoseStack matrixStack, int xOffset, int yOffset) {
        if(stack == null) {
            stack = supplier.get();
        }

        Minecraft minecraft = Minecraft.getInstance();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        itemRenderer.blitOffset += 50.0F;
        BakedModel bakedmodel = itemRenderer.getModel(stack, null, null, 0);
        TextureManager textureManager = Minecraft.getInstance().textureManager;
        ClientRenderUtil.renderItemIntoGUIScalable(stack, 48.0F, 48.0F, bakedmodel, itemRenderer, textureManager);
        itemRenderer.blitOffset -= 50.0F;
    }
}
