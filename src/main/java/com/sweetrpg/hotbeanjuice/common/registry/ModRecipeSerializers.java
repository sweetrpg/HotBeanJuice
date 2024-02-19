package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.item.crafting.*;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.RoastingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.WhiskingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModRecipeSerializers {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Constants.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING_SERIALIZER = RECIPE_SERIALIZERS.register(GrindingRecipe.RECIPE_TYPE_NAME, () -> GrindingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<RoastingRecipe>> ROASTING_SERIALIZER = RECIPE_SERIALIZERS.register("roasting", () -> RoastingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<WhiskingRecipe>> WHISKING_SERIALIZER = RECIPE_SERIALIZERS.register("whisking", () -> WhiskingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<BrewingSerializer<DripCoffeeRecipe>> DRIP_COFFEE_RECIPE = register("drip_coffee", () -> new BrewingSerializer<>(DripCoffeeRecipe::new, 200, "drip"));
    public static final RegistryObject<BrewingSerializer<PercolatorCoffeeRecipe>> PERCOLATOR_COFFEE_RECIPE = register("percolator_coffee", () -> new BrewingSerializer<>(PercolatorCoffeeRecipe::new, 600, "percolator"));
    public static final RegistryObject<BrewingSerializer<CampfireCoffeeRecipe>> CAMPFIRE_COFFEE_RECIPE = register("campfire_coffee", () -> new BrewingSerializer<>(CampfireCoffeeRecipe::new, 300, "campfire"));
    public static final RegistryObject<BrewingSerializer<FrenchPressCoffeeRecipe>> FRENCH_PRESS_COFFEE_RECIPE = register("french_press_coffee", () -> new BrewingSerializer<>(FrenchPressCoffeeRecipe::new, 500, "french_press"));
    public static final RegistryObject<BrewingSerializer<PodCoffeeRecipe>> POD_COFFEE_RECIPE = register("pod_coffee", () -> new BrewingSerializer<>(PodCoffeeRecipe::new, 100, "pod"));
    public static final RegistryObject<BrewingSerializer<EspressoRecipe>> ESPRESSO_RECIPE = register("espresso", () -> new BrewingSerializer<>(EspressoRecipe::new, 150, ""));

    private static <R extends Recipe<?>, T extends RecipeSerializer<R>> RegistryObject<SimpleRecipeSerializer<R>> register(final String name, Function<ResourceLocation, R> factory) {
        return register(name, () -> new SimpleRecipeSerializer<>(factory));
    }

    private static <T extends RecipeSerializer<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return RECIPE_SERIALIZERS.register(name, sup);
    }
}
