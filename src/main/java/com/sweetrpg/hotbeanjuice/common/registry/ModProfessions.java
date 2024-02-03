package com.sweetrpg.hotbeanjuice.common.registry;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.registries.ForgeRegistries;

public class ModProfessions {

    public static final PoiType BARISTA_POI = ForgeRegistries.POI_TYPES.register(new PoiType("barista", ModBlocks.DRIP_COFFEE_MAKER.getStateDefinition().getPossibleStates(), 1, 1));
    public static final VillagerProfession BARISTA = new VillagerProfession("barista", BARISTA_POI, ImmutableSet.of(), ImmutableSet.of(), (SoundEvent) null /* TODO */);

    public static void init() {
        ForgeRegistries.PROFESSIONS.register(BARISTA);
    }
}
