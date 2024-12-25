package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.block.entity.CoffeeRoasterBlockEntity;
import com.sweetrpg.hotbeanjuice.common.block.entity.KettleBlockEntity;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, Constants.MOD_ID);

    //    public static final RegistryObject<BlockEntityType<HandCoffeeGrinderBlockEntity>> HAND_COFFEE_GRINDER = register("hand_coffee_grinder", HandCoffeeGrinderBlockEntity::new, ModBlocks.HAND_COFFEE_GRINDER);
    //    public static final RegistryObject<BlockEntityType<PoweredCoffeeGrinderBlockEntity>> POWERED_COFFEE_GRINDER = register("powered_coffee_grinder", PoweredCoffeeGrinderBlockEntity::new, ModBlocks.POWERED_COFFEE_GRINDER);
    public static final RegistryObject<BlockEntityType<CoffeeRoasterBlockEntity>> COFFEE_ROASTER = register("coffee_roaster", CoffeeRoasterBlockEntity::new, ModBlocks.COFFEE_ROASTER);

public static final RegistryObject<BlockEntityType<KettleBlockEntity>> KETTLE_BLOCK_ENTITY = register("kettle",
        () -> BlockEntityType.Builder.of(KettleBlockEntity::new, ModBlocks.KETTLE.get()).build(null));

    //    public static final RegistryObject<BlockEntityType<FrenchPressBlockEntity>> FRENCH_PRESS_BLOCK_ENTITY = register("french_press",
    //            () -> BlockEntityType.Builder.of(FrenchPressBlockEntity::new, ModBlocks.FRENCH_PRESS.get()).build(null));
    //    public static final RegistryObject<BlockEntityType<CampfirePotBlockEntity>> CAMPFIRE_POT_BLOCK_ENTITY = register("campfire_pot",
    //            () -> BlockEntityType.Builder.of(CampfirePotBlockEntity::new, ModBlocks.CAMPFIRE_COFFEE_POT.get()).build(null));
    //    public static final RegistryObject<BlockEntityType<DripCoffeeMachineBlockEntity>> DRIP_COFFEE_MACHINE_BLOCK_ENTITY = register("drip_coffee_machine",
    //            () -> BlockEntityType.Builder.of(DripCoffeeMachineBlockEntity::new, ModBlocks.DRIP_COFFEE_MACHINE.get()).build(null));
    //    public static final RegistryObject<BlockEntityType<PercolatorBlockEntity>> PERCOLATOR_BLOCK_ENTITY = register("percolator",
    //            () -> BlockEntityType.Builder.of(PercolatorBlockEntity::new, ModBlocks.PERCOLATOR.get()).build(null));
    //    public static final RegistryObject<BlockEntityType<PodMachineBlockEntity>> POD_MACHINE_BLOCK_ENTITY = register("pod_machine",
    //            () -> BlockEntityType.Builder.of(PodMachineBlockEntity::new, ModBlocks.POD_MACHINE.get()).build(null));
    //    public static final RegistryObject<BlockEntityType<EspressoMachineBlockEntity>> ESPRESSO_MACHINE_BLOCK_ENTITY = register("espresso_machine",
    //            () -> BlockEntityType.Builder.of(EspressoMachineBlockEntity::new, ModBlocks.ESPRESSO_MACHINE.get()).build(null));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(final String name, final BlockEntityType.BlockEntitySupplier<T> sup, Supplier<? extends Block> validBlock) {
        return register(name, () -> BlockEntityType.Builder.of(sup, validBlock.get()).build(null));
    }

    private static <T extends BlockEntityType<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return BLOCK_ENTITY_TYPES.register(name, sup);
    }

}
