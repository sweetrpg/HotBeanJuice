package com.sweetrpg.hotbeanjuice.data;

import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
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

        // coffee beans
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COFFEE_CHERRY.get()), ModItems.COFFEE_BEAN.get(), 1, 180)
                .unlockedBy("has_coffee_bean", has(ModItems.COFFEE_BEAN.get()))
                .save(consumer);
//        ShapelessRecipeBuilder.shapeless(ModItems.SUPER_TREAT.get(), 5)
//                .requires(ModItems.TRAINING_TREAT.get(), 5)
//                .requires(Items.GOLDEN_APPLE, 1)
//                .unlockedBy("has_golden_apple", has(Items.GOLDEN_APPLE))
//                .save(consumer);
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
    }

    @Override
    protected void saveAdvancement(HashCache cache, JsonObject advancementJson, Path pathIn) {
        // NOOP - We don't replace any of the advancement things yet...
    }
}
