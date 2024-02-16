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
import net.minecraft.world.level.block.state.BlockBehaviour;
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
            () -> new CoffeeBagBlock(true, BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK)));
    public static final RegistryObject<CoffeeBagBlock> COFFEE_BAG_GROUND = registerWithItem("coffee_bag_ground",
            () -> new CoffeeBagBlock(false, BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK)));

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee-making devices

    public static final RegistryObject<HandCoffeeGrinderBlock> HAND_COFFEE_GRINDER = registerWithItem("hand_coffee_grinder",
            HandCoffeeGrinderBlock::new);
    public static final RegistryObject<PoweredCoffeeGrinderBlock> POWERED_COFFEE_GRINDER = registerWithItem("powered_coffee_grinder",
            PoweredCoffeeGrinderBlock::new);

    // ----------------------------------------------------------------------------------------------------------------

    // Kitchenware
    public static final RegistryObject<CoffeeCupBlock> COFFEE_CUP = registerWithItem("coffee_cup", CoffeeCupBlock::new);
    public static final RegistryObject<CoffeeCupBlock> FIRED_COFFEE_CUP = registerWithItem("fired_coffee_cup", CoffeeCupBlock::new);
//    public static final RegistryObject<DisposableCupBlock> DISPOSABLE_CUP = registerWithItem("disposable_cup", DisposableCupBlock::new);
//    public static final RegistryObject<TravelCupBlock> TRAVEL_CUP = registerWithItem("travel_cup", TravelCupBlock::new);

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee-processing devices
    public static final RegistryObject<CoffeeRoasterBlock> COFFEE_ROASTER = registerWithItem("coffee_roaster", CoffeeRoasterBlock::new);

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
        HotBeanJuice.LOGGER.info("Items/Blocks were not registered for some reason... probably because we are c...r..a..s.hing");
    }
}
