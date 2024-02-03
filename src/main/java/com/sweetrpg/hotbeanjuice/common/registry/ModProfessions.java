package com.sweetrpg.hotbeanjuice.common.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModProfessions {

    public static final PoiType BARISTA_POI = ForgeRegistries.POI_TYPES.register(new PoiType("barista", ModBlocks.BARISTA_BLOCK.getStateDefinition().getPossibleStates(), 1, 1));
    public static final VillagerProfession BARISTA = ForgeRegistries.PROFESSIONS.register(new VillagerProfession("barista", , , (SoundEvent)null /* TODO */));

    register("weaponsmith",PoiType.WEAPONSMITH, SoundEvents.VILLAGER_WORK_WEAPONSMITH);

}
