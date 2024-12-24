package com.sweetrpg.hotbeanjuice.common;

import com.sweetrpg.hotbeanjuice.common.network.PacketHandler;
import com.sweetrpg.hotbeanjuice.common.world.gen.WildCropGeneration;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.init();

            WildCropGeneration.registerWildCropGeneration();

            registerCompostables();
        });
    }

    public static void registerCompostables() {
//        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_COFFEA_ARABICA.get(), 0.65F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_COFFEA_CANEPHORA.get(), 0.65F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_COFFEA_RACEMOSA.get(), 0.65F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_CHERRY_ARABICA.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_CHERRY_CANEPHORA.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_CHERRY_RACEMOSA.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_GROUNDS.get(), 1.5F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.FINE_COFFEE_GROUNDS.get(), 1.5F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_BEAN.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.BAD_COFFEE_BEAN.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.TEA_LEAF.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModItems.TEA_BAG.get(), 1.0F);
//        ComposterBlock.COMPOSTABLES.put(ModBlocks.DISPOSABLE_CUP.get(), 1.0F);
    }
}
