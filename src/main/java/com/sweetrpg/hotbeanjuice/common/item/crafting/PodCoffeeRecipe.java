package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

public class PodCoffeeRecipe extends AbstractBrewingRecipe {

    public static final String RECIPE_TYPE_NAME = "pod_coffee";

    public PodCoffeeRecipe(ResourceLocation id, String group, List<Ingredient> ingredients, float experience, int brewingTime, int millibuckets) {
        super(Type.INSTANCE, group, id, ingredients, experience, brewingTime, millibuckets);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.POD_COFFEE_RECIPE.get();
    }

    public static class Type implements RecipeType<PodCoffeeRecipe> {
        private Type() { }

        public static final PodCoffeeRecipe.Type INSTANCE = new PodCoffeeRecipe.Type();

        public static final String ID = Constants.MOD_ID + ":" + RECIPE_TYPE_NAME;
    }
}
