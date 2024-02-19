package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_TYPES, Constants.MOD_ID);

    private static <E extends Entity, T extends EntityType<E>> RegistryObject<EntityType<E>> register(final String name, final EntityType.EntityFactory<E> sup, final MobCategory classification, final Function<EntityType.Builder<E>, EntityType.Builder<E>> builder) {
         return register(name, () -> builder.apply(EntityType.Builder.of(sup, classification)).build(Util.getResourcePath(name)));
    }

    private static <E extends Entity, T extends EntityType<E>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return ENTITY_TYPES.register(name, sup);
    }

    public static void addEntityAttributes(EntityAttributeCreationEvent e) {
     }
}
