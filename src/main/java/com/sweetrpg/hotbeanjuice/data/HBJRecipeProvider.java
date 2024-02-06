package com.sweetrpg.hotbeanjuice.data;

import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import com.sweetrpg.hotbeanjuice.data.builders.GrindingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.nio.file.Path;
import java.util.function.Consumer;

public class HBJRecipeProvider extends RecipeProvider {

    public HBJRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public String getName() {
        return "Hot Bean Juice Recipes";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        HotBeanJuice.LOGGER.debug("Build crafting recipes: {}", consumer);

        // Coffee ingredients
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COFFEE_CHERRY.get()), ModItems.COFFEE_BEAN.get(), 1, 180)
                .unlockedBy("has_coffee_cherry", has(ModItems.COFFEE_CHERRY.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_BAG_BEANS.get())
                .pattern("PBP")
                .pattern("PBP")
                .pattern("LLL")
                .define('P', Items.PAPER)
                .define('B', ModItems.COFFEE_BEAN.get())
                .define('L', Items.LEATHER)
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_beans", has(ModItems.COFFEE_BEAN.get()))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_BAG_GROUND.get())
                .pattern("PGP")
                .pattern("PGP")
                .pattern("LLL")
                .define('P', Items.PAPER)
                .define('G', ModItems.COFFEE_GROUNDS.get())
                .define('L', Items.LEATHER)
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_grounds", has(ModItems.COFFEE_GROUNDS.get()))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(consumer);
        GrindingRecipeBuilder.grinding(Ingredient.of(ModItems.COFFEE_BEAN.get()), new ItemStack(ModItems.COFFEE_GROUNDS.get()), 1, 180)
                .unlockedBy("has_coffee_bean", has(ModItems.COFFEE_BEAN.get()))
                .save(consumer);
        GrindingRecipeBuilder.grinding(Ingredient.of(ModItems.COFFEE_GROUNDS.get()), new ItemStack(ModItems.FINE_COFFEE_GROUNDS.get()), 1, 180)
                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
                .save(consumer);
        GrindingRecipeBuilder.grinding(Ingredient.of(Items.COCOA_BEANS), new ItemStack(ModItems.COCOA_POWDER.get()), 1, 180)
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        // Kitchenware
        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_CUP.get())
                .pattern("X X")
                .pattern("X X")
                .pattern("XXX")
                .define('X', Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE))
                .save(consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CLAY_MUG.get()), ModBlocks.FIRED_COFFEE_CUP.get(), 0.1f, 240)
                .unlockedBy("has_clay_mug", has(ModItems.CLAY_MUG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.CLAY_MUG.get(), 1)
                .pattern("C C")
                .pattern("C C")
                .pattern("CCC")
                .define('C', Items.CLAY)
                .unlockedBy("has_clay", has(Items.CLAY))
//                .group()
                .save(consumer);

        // Tea ingredients

        // Coffee pots

        // Drinks

        // Miscellaneous ingredients
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), ModItems.STEAMED_MILK.get(), 0.1f, 240)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.WATER_BUCKET), ModItems.BOILING_WATER.get(), 0.1f, 240)
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .save(consumer);

    }

    @Override
    protected void saveAdvancement(HashCache cache, JsonObject advancementJson, Path pathIn) {
        // NOOP - We don't replace any of the advancement things yet...
    }
}
