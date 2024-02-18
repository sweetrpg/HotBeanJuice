package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class EspressoRecipe extends AbstractBrewingRecipe {

    public EspressoRecipe(ResourceLocation id, String group, Ingredient ingredient, float experience, int brewingTime, int millibuckets) {
        super(Type.INSTANCE, group, id, ingredient, experience, brewingTime, millibuckets);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.ESPRESSO_RECIPE.get();
    }

    public static class Type implements RecipeType<EspressoRecipe> {
        private Type() { }
        public static final EspressoRecipe.Type INSTANCE = new EspressoRecipe.Type();
        public static final String ID = Constants.MOD_ID + ":espresso_coffee";
    }
}
