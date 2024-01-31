package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.CoffeeBeanBlock;
import com.sweetrpg.hotbeanjuice.common.block.CoffeeBushBlock;
import com.sweetrpg.hotbeanjuice.common.block.DripCoffeeBlock;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
    public static final RegistryObject<CoffeeBushBlock> COFFEE_BUSH = BLOCKS.register("coffee_bush",
            () -> new CoffeeBushBlock(MobEffects.DIG_SLOWDOWN, 6, Block.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<CoffeeBeanBlock> COFFEE_BEAN_CROP = BLOCKS.register("coffee_bean",
            () -> new CoffeeBeanBlock(Block.Properties.copy(Blocks.WHEAT)));

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee Makers

    public static final RegistryObject<Block> DRIP_COFFEE_MAKER = registerWithItem("drip_coffee",
            () -> new DripCoffeeBlock(Block.Properties.of(Material.WOOD).strength(0.5F).noOcclusion())); //?

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

    public static void registerBlockColours(final ColorHandlerEvent.Block event) {
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
