package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.CoffeeMakerRecipe;
import com.sweetrpg.hotbeanjuice.common.item.crafting.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.item.crafting.RoastingRecipe;
import com.sweetrpg.hotbeanjuice.common.item.crafting.WhiskingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, Constants.MOD_ID);

    public static final RegistryObject<RecipeType<?>> GRINDING = register(GrindingRecipe.RECIPE_TYPE_NAME, () -> GrindingRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> WHISKING = register("whisking", () -> WhiskingRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> BREWING = register("brewing", () -> CoffeeMakerRecipe.Type.INSTANCE);
    public static final RegistryObject<RecipeType<?>> ROASTING = register("roasting", () -> RoastingRecipe.Type.INSTANCE);

    private static <T extends RecipeType> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return RECIPE_TYPES.register(name, sup);
    }
}
