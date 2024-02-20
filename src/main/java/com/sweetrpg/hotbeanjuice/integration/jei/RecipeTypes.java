package com.sweetrpg.hotbeanjuice.integration.jei;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.RoastingRecipe;
import com.sweetrpg.hotbeanjuice.common.recipes.WhiskingRecipe;
import mezz.jei.api.recipe.RecipeType;

public final class RecipeTypes {

    public static final RecipeType<GrindingRecipe> GRINDING = RecipeType.create(Constants.MOD_ID, GrindingRecipe.RECIPE_TYPE_NAME, GrindingRecipe.class);
    public static final RecipeType<RoastingRecipe> ROASTING = RecipeType.create(Constants.MOD_ID, RoastingRecipe.RECIPE_TYPE_NAME, RoastingRecipe.class);
    public static final RecipeType<WhiskingRecipe> WHISKING = RecipeType.create(Constants.MOD_ID, WhiskingRecipe.RECIPE_TYPE_NAME, WhiskingRecipe.class);

}
