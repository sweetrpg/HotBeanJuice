package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.lib.FoodValues;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.sweetrpg.hotbeanjuice.common.item.CarafeItem;
import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, Constants.MOD_ID);

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee resources
    public static final RegistryObject<Item> WILD_COFFEA_ARABICA = register("wild_coffea_arabica", () -> new BlockItem(ModBlocks.WILD_COFFEA_ARABICA.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> WILD_COFFEA_CANEPHORA = register("wild_coffea_canephora", () -> new BlockItem(ModBlocks.WILD_COFFEA_CANEPHORA.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> WILD_COFFEA_RACEMOSA = register("wild_coffea_racemosa", () -> new BlockItem(ModBlocks.WILD_COFFEA_RACEMOSA.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_CHERRY_ARABICA = ITEMS.register("coffee_cherry_arabica", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_CHERRY_CANEPHORA = ITEMS.register("coffee_cherry_canephora", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_CHERRY_RACEMOSA = ITEMS.register("coffee_cherry_racemosa", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_BEAN = ITEMS.register("coffee_bean", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> BAD_COFFEE_BEAN = ITEMS.register("bad_coffee_bean", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
//    public static final RegistryObject<Item> COFFEE_SEEDS = ITEMS.register("coffee_seeds", () -> new ItemNameBlockItem(ModBlocks.COFFEE_BUSH_CROP.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_GROUNDS = ITEMS.register("coffee_grounds", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> FINE_COFFEE_GROUNDS = ITEMS.register("fine_coffee_grounds", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee drinks
    public static final RegistryObject<Item> COFFEE_DRINK = ITEMS.register("coffee_drink", () -> new Item(new Item.Properties().food(FoodValues.ESPRESSO).tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> ESPRESSO_DRINK = ITEMS.register("espresso_drink", () -> new Item(new Item.Properties().food(FoodValues.ESPRESSO).tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> CAPPUCCINO_DRINK = ITEMS.register("cappuccino_drink", () -> new Item(new Item.Properties().food(FoodValues.CAPPUCCINO).tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> MOCHA_DRINK = ITEMS.register("mocha_drink", () -> new Item(new Item.Properties().food(FoodValues.MOCHA).tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> LATTE_DRINK = ITEMS.register("latte_drink", () -> new Item(new Item.Properties().food(FoodValues.LATTE).tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> MACCHIATO_DRINK = ITEMS.register("macchiato_drink", () -> new Item(new Item.Properties().food(FoodValues.MACCHIATO).tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> HOT_CHOCOLATE_DRINK = ITEMS.register("hot_chocolate_drink", () -> new Item(new Item.Properties().food(FoodValues.HOT_CHOCOLATE).tab(ModItemGroups.GENERAL)));

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee-making paraphernalia
    public static final RegistryObject<Item> COFFEE_FILTER = register("coffee_filter");
    public static final RegistryObject<Item> DRIP_COFFEE_CARAFE = ITEMS.register("drip_coffee_carafe", () -> new CarafeItem(ModBlocks.DRIP_COFFEE_CARAFE.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));

    // ----------------------------------------------------------------------------------------------------------------

    // Kitchenware
    public static final RegistryObject<Item> CLAY_MUG = register("clay_mug");
    public static final RegistryObject<Item> WHISK = register("whisk");

    // ----------------------------------------------------------------------------------------------------------------

    // Tea

    // ----------------------------------------------------------------------------------------------------------------

    // Miscellaneous ingredients
    public static final RegistryObject<Item> COCOA_POWDER = ITEMS.register("cocoa_powder", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> STEAMED_MILK = ITEMS.register("steamed_milk", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> BOILING_WATER = ITEMS.register("boiling_water", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> MILK_FOAM = ITEMS.register("milk_foam", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));

    // ----------------------------------------------------------------------------------------------------------------

    private static Item.Properties createInitialProp() {
        return new Item.Properties().tab(ModItemGroups.GENERAL);
    }

    private static <T extends Item> RegistryObject<T> registerWith(final String name, Function<Item.Properties, T> itemConstructor, int maxStackSize) {
        return register(name, () -> itemConstructor.apply(createInitialProp().stacksTo(maxStackSize)));
    }

    private static <T extends Item> RegistryObject<T> register(final String name, Function<Item.Properties, T> itemConstructor) {
        return register(name, () -> itemConstructor.apply(createInitialProp()));
    }

    private static RegistryObject<Item> register(final String name) {
        return registerWith(name, null);
    }

    private static RegistryObject<Item> registerWith(final String name, @Nullable Function<Item.Properties, Item.Properties> extraPropFunc) {
        Item.Properties prop = createInitialProp();
        return register(name, () -> new Item(extraPropFunc != null ? extraPropFunc.apply(prop) : prop));
    }

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return ITEMS.register(name, sup);
    }

}
