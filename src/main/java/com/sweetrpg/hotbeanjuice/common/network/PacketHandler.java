package com.sweetrpg.hotbeanjuice.common.network;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import net.minecraftforge.network.PacketDistributor;

public final class PacketHandler {

    private static int idx = 0;

    public static void init() {
    }

    public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message) {
        HotBeanJuice.HANDLER.send(target, message);
    }

    public static <D> void registerPacket(IPacket<D> packet, Class<D> dataClass) {
        HotBeanJuice.HANDLER.registerMessage(PacketHandler.idx++, dataClass, packet::encode, packet::decode, packet::handle);
    }

}
