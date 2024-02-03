package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.item.CoffeeBeanItem;
import com.sweetrpg.hotbeanjuice.common.item.CoffeeCherryItem;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, Constants.MOD_ID);

    // ----------------------------------------------------------------------------------------------------------------

    // Coffee
    public static final RegistryObject<Item> WILD_COFFEE_BUSH = register("wild_coffee_bush", () -> new BlockItem(ModBlocks.WILD_COFFEE_BUSH.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_CHERRY = ITEMS.register("coffee_cherry", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_BEAN = ITEMS.register("coffee_bean", () -> new Item(new Item.Properties()./*food(FoodValues.CATNIP).*/tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_SEEDS = ITEMS.register("coffee_seeds", () -> new ItemNameBlockItem(ModBlocks.COFFEE_BUSH_CROP.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> COFFEE_GROUNDS = ITEMS.register("coffee_grounds", () -> new Item(new Item.Properties().tab(ModItemGroups.GENERAL)));

    // ----------------------------------------------------------------------------------------------------------------

    // Tea

    // ----------------------------------------------------------------------------------------------------------------

    // Kitchenware

//    public static final RegistryObject<Item> COFFEE_CUP = ITEMS.register("coffee_cup", () -> new ItemNameBlockItem(ModBlocks.COFFEE_CUP.get(), new Item.Properties().tab(ModItemGroups.GENERAL)));
    public static final RegistryObject<Item> CLAY_MUG = register("clay_mug");

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
