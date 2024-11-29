package com.sweetrpg.hotbeanjuice.client;

import com.sweetrpg.hotbeanjuice.client.screen.CoffeeRoasterScreen;
import com.sweetrpg.hotbeanjuice.common.inventory.screens.DripCoffeeScreen;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void setupScreenManagers(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_COFFEA_ARABICA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_COFFEA_CANEPHORA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_COFFEA_RACEMOSA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CROP_COFFEE_ARABICA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CROP_COFFEE_CANEPHORA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CROP_COFFEE_RACEMOSA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HAND_COFFEE_GRINDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POWERED_COFFEE_GRINDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRIP_COFFEE_MACHINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRIP_COFFEE_CARAFE.get(), RenderType.cutout());

        MenuScreens.register(ModMenuTypes.COFFEE_ROASTER_MENU.get(), CoffeeRoasterScreen::new);
        MenuScreens.register(ModMenuTypes.DRIP_COFFEE_MACHINE_MENU.get(), DripCoffeeScreen::new);
    }

    public static void setupEntityRenderers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
    }

    public static void setupTileEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }

    public static void addClientReloadListeners(final RegisterClientReloadListenersEvent event) {
//        event.registerReloadListener(CatTextureManager.INSTANCE);
    }
}
