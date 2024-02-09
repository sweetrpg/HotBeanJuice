package com.sweetrpg.hotbeanjuice.common;

import com.sweetrpg.hotbeanjuice.common.network.PacketHandler;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import com.sweetrpg.hotbeanjuice.common.world.gen.WildCropGeneration;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.init();
            //TODO CriteriaTriggers.register(criterion)

//            CatRespawnCommand.registerSerilizers();

            WildCropGeneration.registerWildCropGeneration();

            registerCompostables();
        });
    }

//    public static void registerDispenserBehaviors() {
//
//    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_COFFEE_BUSH.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_SEEDS.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_CHERRY.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_GROUNDS.get(), 1.5F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COFFEE_BEAN.get(), 1.0F);
    }
}
