package com.sweetrpg.hotbeanjuice.integration.jei;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.RoastingRecipe;
import mezz.jei.api.recipe.RecipeType;

public final class RecipeTypes {

    public static final RecipeType<GrindingRecipe> GRINDING = RecipeType.create(Constants.MOD_ID, GrindingRecipe.RECIPE_TYPE_NAME, GrindingRecipe.class);
    public static final RecipeType<RoastingRecipe> ROASTING = RecipeType.create(Constants.MOD_ID, RoastingRecipe.RECIPE_TYPE_NAME, RoastingRecipe.class);

}
