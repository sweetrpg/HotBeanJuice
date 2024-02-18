package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

public class FrenchPressCoffeeRecipe extends AbstractBrewingRecipe {

    public FrenchPressCoffeeRecipe(ResourceLocation id, String group, List<Ingredient> ingredients, float experience, int brewingTime, int millibuckets) {
        super(Type.INSTANCE, group, id, ingredients, experience, brewingTime, millibuckets);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.FRENCH_PRESS_COFFEE_RECIPE.get();
    }

    public static class Type implements RecipeType<FrenchPressCoffeeRecipe> {
        private Type() { }
        public static final FrenchPressCoffeeRecipe.Type INSTANCE = new FrenchPressCoffeeRecipe.Type();
        public static final String ID = Constants.MOD_ID + ":french_press_coffee";
    }
}
