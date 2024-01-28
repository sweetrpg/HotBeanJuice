package com.sweetrpg.hotbeanjuice.common;

import com.sweetrpg.hotbeanjuice.common.network.PacketHandler;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.init();
            //TODO CriteriaTriggers.register(criterion)

//            CatRespawnCommand.registerSerilizers();

        });
    }

//    public static void registerDispenserBehaviors() {
//
//    }


}
