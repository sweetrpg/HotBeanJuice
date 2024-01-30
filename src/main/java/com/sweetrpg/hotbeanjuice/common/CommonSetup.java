package com.sweetrpg.hotbeanjuice.common;

import com.sweetrpg.hotbeanjuice.common.network.PacketHandler;
import com.sweetrpg.hotbeanjuice.common.world.gen.WildCropGeneration;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.init();
            //TODO CriteriaTriggers.register(criterion)

//            CatRespawnCommand.registerSerilizers();

            WildCropGeneration.registerWildCatnipGeneration();

        });
    }

//    public static void registerDispenserBehaviors() {
//
//    }


}
