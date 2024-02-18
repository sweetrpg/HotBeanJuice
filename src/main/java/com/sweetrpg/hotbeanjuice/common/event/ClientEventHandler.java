package com.sweetrpg.hotbeanjuice.common.event;

import com.sweetrpg.hotbeanjuice.common.inventory.screens.DripCoffeeScreen;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        //SCREENS
        MenuScreens.register(ModMenuTypes.DRIP_COFFEE_MENU.get(), DripCoffeeScreen::new);

        //RENDER LAYERS
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRIP_COFFEE_MACHINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRIP_COFFEE_CARAFE.get(), RenderType.cutout());

    }
}
