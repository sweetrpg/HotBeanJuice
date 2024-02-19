package com.sweetrpg.hotbeanjuice.integration.jei;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.GrindingRecipe;
import mezz.jei.api.recipe.RecipeType;

public final class RecipeTypes {

    public static final RecipeType<GrindingRecipe> GRINDING = RecipeType.create(Constants.MOD_ID, GrindingRecipe.RECIPE_TYPE_NAME, GrindingRecipe.class);

}
