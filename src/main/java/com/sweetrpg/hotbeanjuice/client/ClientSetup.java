package com.sweetrpg.hotbeanjuice.client;

import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void setupScreenManagers(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_COFFEE_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COFFEE_BUSH_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HAND_COFFEE_GRINDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POWERED_COFFEE_GRINDER.get(), RenderType.cutout());

//        MenuScreens.register(ModContainerTypes.CAT_BOWL.get(), CatBowlScreen::new);
    }

    public static void setupEntityRenderers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
    }

    public static void setupTileEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }

    public static void addClientReloadListeners(final RegisterClientReloadListenersEvent event) {
//        event.registerReloadListener(CatTextureManager.INSTANCE);
    }
}
