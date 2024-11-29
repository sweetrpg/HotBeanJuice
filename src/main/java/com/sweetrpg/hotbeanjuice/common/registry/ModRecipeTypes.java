package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.item.crafting.*;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, Constants.MOD_ID);

    public static final RegistryObject<RecipeType<?>> CAMPFIRE_COFFEE = register(CampfireCoffeeRecipe.RECIPE_TYPE_NAME, () -> CampfireCoffeeRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> DRIP_COFFEE = register(DripCoffeeRecipe.RECIPE_TYPE_NAME, () -> DripCoffeeRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> ESPRESSO = register(EspressoRecipe.RECIPE_TYPE_NAME, () -> EspressoRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> FRENCH_PRESS_COFFEE = register(FrenchPressCoffeeRecipe.RECIPE_TYPE_NAME, () -> FrenchPressCoffeeRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> GRINDING = register(GrindingRecipe.RECIPE_TYPE_NAME, () -> GrindingRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> PERCOLATOR_COFFEE = register(PercolatorCoffeeRecipe.RECIPE_TYPE_NAME, () -> PercolatorCoffeeRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> POD_COFFEE = register(PodCoffeeRecipe.RECIPE_TYPE_NAME, () -> PodCoffeeRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> ROASTING = register(RoastingRecipe.RECIPE_TYPE_NAME, () -> RoastingRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> WHISKING = register(WhiskingRecipe.RECIPE_TYPE_NAME, () -> WhiskingRecipe.Type.INSTANCE);

    private static <T extends RecipeType> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return RECIPE_TYPES.register(name, sup);
    }
}
