package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.CoffeeMakerRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.RoastingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.WhiskingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModRecipeSerializers {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Constants.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING_SERIALIZER = SERIALIZERS.register("grinding", () -> GrindingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<RoastingRecipe>> ROASTING_SERIALIZER = SERIALIZERS.register("roasting", () -> RoastingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<WhiskingRecipe>> WHISKING_SERIALIZER = SERIALIZERS.register("whisking", () -> WhiskingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CoffeeMakerRecipe>> COFFEE_MAKING_SERIALIZER = SERIALIZERS.register("coffee_making", () -> CoffeeMakerRecipe.Serializer.INSTANCE);

    private static <R extends Recipe<?>, T extends RecipeSerializer<R>> RegistryObject<SimpleRecipeSerializer<R>> register(final String name, Function<ResourceLocation, R> factory) {
        return register(name, () -> new SimpleRecipeSerializer<>(factory));
    }

    private static <T extends RecipeSerializer<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return SERIALIZERS.register(name, sup);
    }
}
