package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.block.entity.DripCoffeeBlockEntity;
import com.sweetrpg.hotbeanjuice.common.block.entity.HandCoffeeGrinderBlockEntity;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, Constants.MOD_ID);

    public static final RegistryObject<BlockEntityType<HandCoffeeGrinderBlockEntity>> HAND_COFFEE_GRINDER = register("hand_coffee_grinder", HandCoffeeGrinderBlockEntity::new, ModBlocks.HAND_COFFEE_GRINDER);

    public static final RegistryObject<BlockEntityType<DripCoffeeBlockEntity>> DRIP_COFFEE_BLOCK_ENTITY = register("drip_coffee",
            () -> BlockEntityType.Builder.of(DripCoffeeBlockEntity::new, ModBlocks.DRIP_COFFEE_MAKER.get()).build(null));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(final String name, final BlockEntityType.BlockEntitySupplier<T> sup, Supplier<? extends Block> validBlock) {
        return register(name, () -> BlockEntityType.Builder.of(sup, validBlock.get()).build(null));
    }

    private static <T extends BlockEntityType<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return ENTITIES.register(name, sup);
    }

}
