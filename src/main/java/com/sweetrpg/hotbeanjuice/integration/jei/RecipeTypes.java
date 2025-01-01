package com.sweetrpg.hotbeanjuice.integration.jei;

import com.sweetrpg.hotbeanjuice.common.Constants;
import com.sweetrpg.hotbeanjuice.common.item.crafting.*;
import mezz.jei.api.recipe.RecipeType;

public final class RecipeTypes {

    public static final RecipeType<GrindingRecipe> GRINDING = RecipeType.create(Constants.MOD_ID, GrindingRecipe.RECIPE_TYPE_NAME, GrindingRecipe.class);
    public static final RecipeType<RoastingRecipe> ROASTING = RecipeType.create(Constants.MOD_ID, RoastingRecipe.RECIPE_TYPE_NAME, RoastingRecipe.class);
    public static final RecipeType<WhiskingRecipe> WHISKING = RecipeType.create(Constants.MOD_ID, WhiskingRecipe.RECIPE_TYPE_NAME, WhiskingRecipe.class);
    public static final RecipeType<KettleHeatingRecipe> KETTLE_HEATING = RecipeType.create(Constants.MOD_ID, KettleHeatingRecipe.RECIPE_TYPE_NAME, KettleHeatingRecipe.class);
    public static final RecipeType<DripCoffeeRecipe> DRIP_COFFEE = RecipeType.create(Constants.MOD_ID, DripCoffeeRecipe.RECIPE_TYPE_NAME, DripCoffeeRecipe.class);
    public static final RecipeType<FrenchPressCoffeeRecipe> FRENCH_PRESS_COFFEE = RecipeType.create(Constants.MOD_ID, FrenchPressCoffeeRecipe.RECIPE_TYPE_NAME, FrenchPressCoffeeRecipe.class);
    public static final RecipeType<PercolatorCoffeeRecipe> PERCOLATOR_COFFEE = RecipeType.create(Constants.MOD_ID, PercolatorCoffeeRecipe.RECIPE_TYPE_NAME, PercolatorCoffeeRecipe.class);
    public static final RecipeType<PodCoffeeRecipe> POD_COFFEE = RecipeType.create(Constants.MOD_ID, PodCoffeeRecipe.RECIPE_TYPE_NAME, PodCoffeeRecipe.class);

}
