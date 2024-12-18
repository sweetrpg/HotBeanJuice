package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.*;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.Keys.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ModItems.ITEMS;

    // ----------------------------------------------------------------------------------------------------------------
    // Crops

    //    public static final RegistryObject<WildCoffeeBushBlock> WILD_COFFEE_BUSH = BLOCKS.register("wild_coffee_bush",
//            () -> new WildCoffeeBushBlock(MobEffects.DIG_SLOWDOWN, 6, Block.Properties.copy(Blocks.ROSE_BUSH)));
//    public static final RegistryObject<CoffeeBushBlock> COFFEE_BUSH_CROP = BLOCKS.register("coffee_bush",
//            () -> new CoffeeBushBlock(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<WildCoffeeBushBlock> WILD_COFFEA_ARABICA = BLOCKS.register("wild_coffea_arabica",
            () -> new WildCoffeeBushBlock(MobEffects.DIG_SLOWDOWN, 6, Block.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<WildCoffeeBushBlock> WILD_COFFEA_RACEMOSA = BLOCKS.register("wild_coffea_racemosa",
            () -> new WildCoffeeBushBlock(MobEffects.DIG_SLOWDOWN, 6, Block.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<WildCoffeeBushBlock> WILD_COFFEA_CANEPHORA = BLOCKS.register("wild_coffea_canephora",
            () -> new WildCoffeeBushBlock(MobEffects.DIG_SLOWDOWN, 6, Block.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<CoffeeBushBlock> CROP_COFFEE_ARABICA = BLOCKS.register("crop_coffee_arabica",
            () -> new CoffeeBushBlock(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<CoffeeBushBlock> CROP_COFFEE_RACEMOSA = BLOCKS.register("crop_coffee_racemosa",
            () -> new CoffeeBushBlock(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<CoffeeBushBlock> CROP_COFFEE_CANEPHORA = BLOCKS.register("crop_coffee_canephora",
            () -> new CoffeeBushBlock(Block.Properties.copy(Blocks.WHEAT)));

    // ----------------------------------------------------------------------------------------------------------------
    // Miscellaneous coffee items

    public static final RegistryObject<CoffeeBagBlock> COFFEE_BAG_BEANS = registerWithItem("coffee_bag_beans",
            () -> new CoffeeBagBlock(true));
    public static final RegistryObject<CoffeeBagBlock> COFFEE_BAG_GROUND = registerWithItem("coffee_bag_ground",
            () -> new CoffeeBagBlock(false));
    public static final RegistryObject<Block> DRIP_COFFEE_CARAFE = BLOCKS.register("drip_coffee_carafe",
            () -> new CarafeBlock(Block.Properties.of(Material.GLASS).strength(0.5F).noOcclusion())); //?

    // ----------------------------------------------------------------------------------------------------------------
    // Tea-making devices

    public static final RegistryObject<TeaKettleBlock> TEA_KETTLE = registerWithItem("tea_kettle",
            () -> new TeaKettleBlock(Block.Properties.of(Material.METAL).strength(0.5F).noOcclusion())); //?
    public static final RegistryObject<SunTeaJarBlock> SUN_TEA_JAR = registerWithItem("sun_tea_jar",
            () -> new SunTeaJarBlock(Block.Properties.of(Material.GLASS).strength(0.5F).noOcclusion())); //?

    // ----------------------------------------------------------------------------------------------------------------
    // Coffee-making devices

    public static final RegistryObject<Block> DRIP_COFFEE_MACHINE = registerWithItem("drip_coffee_machine",
            () -> new DripCoffeeMakerBlock(Block.Properties.of(Material.WOOD).strength(0.5F).noOcclusion())); //?
    public static final RegistryObject<Block> PERCOLATOR = registerWithItem("percolator",
            () -> new PercolatorBlock(Block.Properties.of(Material.METAL).strength(0.5F).noOcclusion())); //?
    public static final RegistryObject<Block> POD_MACHINE = registerWithItem("pod_machine",
            () -> new PodMachineBlock(Block.Properties.of(Material.METAL).strength(0.5F).noOcclusion())); //?
    public static final RegistryObject<Block> ESPRESSO_MACHINE = registerWithItem("espresso_machine",
            () -> new EspressoMachineBlock(Block.Properties.of(Material.METAL).strength(0.5F).noOcclusion())); //?
    public static final RegistryObject<Block> CAMPFIRE_COFFEE_POT = registerWithItem("campfire_coffee_pot",
            () -> new CampfirePotBlock(Block.Properties.of(Material.GLASS).strength(0.5F).noOcclusion())); //?
    public static final RegistryObject<Block> FRENCH_PRESS = registerWithItem("french_press",
            () -> new FrenchPressBlock(Block.Properties.of(Material.GLASS).strength(0.5F).noOcclusion())); //?

    // ----------------------------------------------------------------------------------------------------------------
    // Coffee-processing devices

    public static final RegistryObject<HandCoffeeGrinderBlock> HAND_COFFEE_GRINDER = registerWithItem("hand_coffee_grinder",
            HandCoffeeGrinderBlock::new);
    public static final RegistryObject<PoweredCoffeeGrinderBlock> POWERED_COFFEE_GRINDER = registerWithItem("powered_coffee_grinder",
            PoweredCoffeeGrinderBlock::new);
    public static final RegistryObject<CoffeeRoasterBlock> COFFEE_ROASTER = registerWithItem("coffee_roaster", CoffeeRoasterBlock::new);

    // ----------------------------------------------------------------------------------------------------------------
    // Kitchenware

    public static final RegistryObject<CoffeeCupBlock> COFFEE_CUP = registerWithItem("coffee_cup", CoffeeCupBlock::new);
    public static final RegistryObject<CoffeeCupBlock> FIRED_COFFEE_CUP = registerWithItem("fired_coffee_cup", CoffeeCupBlock::new);
    public static final RegistryObject<DisposableCupBlock> DISPOSABLE_CUP = registerWithItem("disposable_cup", DisposableCupBlock::new);
    public static final RegistryObject<TravelCupBlock> TRAVEL_MUG = registerWithItem("travel_cup", TravelCupBlock::new);
    public static final RegistryObject<TeacupBlock> TEACUP = registerWithItem("teacup", TeacupBlock::new);
    public static final RegistryObject<PlateBlock> PLATE = registerWithItem("plate", PlateBlock::new);

    // ----------------------------------------------------------------------------------------------------------------

    private static Item.Properties createInitialProp() {
        return new Item.Properties().tab(ModItemGroups.GENERAL);
    }

    private static BlockItem makeItemBlock(Block block) {
        return makeItemBlock(block, null);
    }

    private static BlockItem makeItemBlock(Block block, @Nullable Function<Item.Properties, Item.Properties> extraPropFunc) {
        Item.Properties prop = createInitialProp();
        return new BlockItem(block, extraPropFunc != null ? extraPropFunc.apply(prop) : prop);
    }

    private static <T extends Block> RegistryObject<T> registerWithItem(final String name, final Supplier<T> blockSupplier, @Nullable Function<Item.Properties, Item.Properties> extraPropFunc) {
        return register(name, blockSupplier, (b) -> makeItemBlock(b.get(), extraPropFunc));
    }

    private static <T extends Block> RegistryObject<T> registerWithItem(final String name, final Supplier<T> blockSupplier) {
        return register(name, blockSupplier, (b) -> makeItemBlock(b.get()));
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<T> blockSupplier, final Function<RegistryObject<T>, Item> itemFunction) {
        RegistryObject<T> blockObj = register(name, blockSupplier);
        ITEMS.register(name, () -> itemFunction.apply(blockObj));
        return blockObj;
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    public static void registerBlockColors(final ColorHandlerEvent.Block event) {
        BlockColors blockColors = event.getBlockColors();

//        Util.acceptOrElse(CatBlocks.CAT_BATH, (block) -> {
//            blockColors.register((state, world, pos, tintIndex) -> {
//                return world != null && pos != null ? BiomeColors.getAverageWaterColor(world, pos) : -1;
//             }, block);
//        }, CatBlocks::logError);
    }

    public static void logError() {
        // Only try to register if blocks were successfully registered
        // Trying to avoid as reports like HotBeanJuice#242, where it says
        // HotBeanJuice crashed but is not the CAUSE of the crash

        HotBeanJuice.LOGGER.info("Items/Blocks were not registered for some reason... probably because we are c...r..a..s.hing");
    }
}
