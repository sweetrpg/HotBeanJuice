package com.sweetrpg.hotbeanjuice.data;

import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import com.sweetrpg.hotbeanjuice.common.registry.ModTags;
import com.sweetrpg.hotbeanjuice.data.builders.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.*;
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
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModTags.COFFEE_CHERRIES), ModItems.COFFEE_BEAN.get(), 1, 180)
                .unlockedBy("has_coffee_cherry", has(ModTags.COFFEE_CHERRIES))
                .save(consumer);
        CoffeeRoastingRecipeBuilder.roasting(Ingredient.of(ModTags.COFFEE_CHERRIES), new ItemStack(ModItems.COFFEE_BEAN.get()), 1, 180)
                .unlockedBy("has_coffee_cherry", has(ModTags.COFFEE_CHERRIES));

        // Coffee beans
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
        WhiskingRecipeBuilder.whisking(Ingredient.of(ModItems.STEAMED_MILK.get()), new ItemStack(ModItems.MILK_FOAM.get()), 1, 180)
                .unlockedBy("has_steamed_milk", has(ModItems.STEAMED_MILK.get()))
                .save(consumer);

        // Coffee-making paraphernalia
        ShapedRecipeBuilder.shaped(ModItems.COFFEE_FILTER.get())
                .group("coffee_paraphernalia")
                .pattern("P P")
                .pattern(" P ")
                .define('P', Items.PAPER)
                .unlockedBy("has_paper", has(Items.PAPER))
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
                .define('C', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
//                .group()
                .save(consumer);

        // Tea ingredients

        // Coffee pots

        // Drinks
        ShapelessRecipeBuilder.shapeless(ModItems.MACCHIATO_DRINK.get())
                .requires(ModItems.ESPRESSO_DRINK.get())
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_espresso", has(ModItems.ESPRESSO_DRINK.get()))
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.LATTE_DRINK.get())
                .requires(ModItems.ESPRESSO_DRINK.get())
                .requires(ModItems.STEAMED_MILK.get())
                .unlockedBy("has_espresso", has(ModItems.ESPRESSO_DRINK.get()))
                .unlockedBy("has_steamed_milk", has(ModItems.STEAMED_MILK.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.CAPPUCCINO_DRINK.get())
                .requires(ModItems.ESPRESSO_DRINK.get())
                .requires(ModItems.STEAMED_MILK.get())
                .requires(ModItems.MILK_FOAM.get())
                .unlockedBy("has_espresso", has(ModItems.ESPRESSO_DRINK.get()))
                .unlockedBy("has_steamed_milk", has(ModItems.STEAMED_MILK.get()))
                .unlockedBy("has_milk_foam", has(ModItems.MILK_FOAM.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.MOCHA_DRINK.get())
                .requires(ModItems.ESPRESSO_DRINK.get())
                .requires(ModItems.STEAMED_MILK.get())
                .requires(ModItems.COCOA_POWDER.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_espresso", has(ModItems.ESPRESSO_DRINK.get()))
                .unlockedBy("has_steamed_milk", has(ModItems.STEAMED_MILK.get()))
                .unlockedBy("has_cocoa_powder", has(ModItems.COCOA_POWDER.get()))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(consumer);
//        CoffeeMakerRecipeBuilder.drip(ModItems.COFFEE_DRINK.get())
        CoffeeMakerRecipeBuilder.frenchPress(ModItems.COFFEE_DRINK.get(), 0.1f, 300)
                .requires(Ingredient.of(ModItems.BOILING_WATER.get()))
                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
                .unlockedBy("has_hot_water", has(ModItems.BOILING_WATER.get()))
                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
                .save(consumer);
        CoffeeMakerRecipeBuilder.campfire(ModItems.COFFEE_DRINK.get(), 0.2f, 600)
                .requires(Ingredient.of(ModItems.BOILING_WATER.get()))
                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
                .unlockedBy("has_hot_water", has(ModItems.BOILING_WATER.get()))
                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
                .save(consumer);
        CoffeeMakerRecipeBuilder.percolated(ModItems.COFFEE_DRINK.get(), 0.1f, 450)
                .requires(Ingredient.of(Items.WATER_BUCKET))
                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
                .save(consumer);
        CoffeeMakerRecipeBuilder.pod(ModItems.COFFEE_DRINK.get(), 0.1f, 180)
                .requires(Ingredient.of(Items.WATER_BUCKET))
                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
                .save(consumer);
        CoffeeMakerRecipeBuilder.espresso(ModItems.ESPRESSO_DRINK.get(), 0.3f, 300)
                .requires(Ingredient.of(Items.WATER_BUCKET))
                .requires(Ingredient.of(ModItems.FINE_COFFEE_GROUNDS.get()))
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .unlockedBy("has_fine_coffee_grounds", has(ModItems.FINE_COFFEE_GROUNDS.get()))
                .save(consumer);

        // Miscellaneous ingredients
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), ModItems.STEAMED_MILK.get(), 0.1f, 240)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.WATER_BUCKET), ModItems.BOILING_WATER.get(), 0.1f, 240)
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .save(consumer);

        // Coffee-processing devices
        ShapedRecipeBuilder.shaped(ModBlocks.HAND_COFFEE_GRINDER.get(), 1)
                .pattern(" G ")
                .pattern("IFI")
                .pattern(" I ")
                .define('G', Items.GLASS)
                .define('I', Items.IRON_INGOT)
                .define('F', Items.FLINT)
                .unlockedBy("has_glass", has(Items.GLASS))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POWERED_COFFEE_GRINDER.get(), 1)
                .pattern(" G ")
                .pattern("IFI")
                .pattern("IRI")
                .define('G', Items.GLASS)
                .define('I', Items.IRON_INGOT)
                .define('F', Items.FLINT)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_glass", has(Items.GLASS))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_flint", has(Items.FLINT))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_ROASTER.get(), 1)
                .pattern("  H")
                .pattern("III")
                .pattern("IRB")
                .define('H', Items.HOPPER)
                .define('I', Items.IRON_INGOT)
                .define('B', Items.BUCKET)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_hopper", has(Items.HOPPER))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(consumer);

        // Coffee-making devices
    }

    @Override
    protected void saveAdvancement(HashCache cache, JsonObject advancementJson, Path pathIn) {
        // NOOP - We don't replace any of the advancement things yet...
    }
}
