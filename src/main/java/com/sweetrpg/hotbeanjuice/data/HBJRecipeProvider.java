package com.sweetrpg.hotbeanjuice.data;

import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import com.sweetrpg.hotbeanjuice.common.registry.ModTags;
import com.sweetrpg.hotbeanjuice.data.builders.CoffeeRoastingRecipeBuilder;
import com.sweetrpg.hotbeanjuice.data.builders.GrindingRecipeBuilder;
import com.sweetrpg.hotbeanjuice.data.builders.KettleHeatingRecipeBuilder;
import com.sweetrpg.hotbeanjuice.data.builders.WhiskingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

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

        // ----------------------------------------------------------------------------------------------------------------
        // Coffee ingredients

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModTags.COFFEE_CHERRIES), ModItems.COFFEE_BEAN.get(), 1, 180)
                .unlockedBy("has_coffee_cherry", has(ModTags.COFFEE_CHERRIES))
                .save(consumer);
        CoffeeRoastingRecipeBuilder.roasting(Ingredient.of(ModTags.COFFEE_CHERRIES), new ItemStack(ModItems.COFFEE_BEAN.get()), 1, 180)
                .unlockedBy("has_coffee_cherry", has(ModTags.COFFEE_CHERRIES))
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Coffee beans

        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_BAG_BEANS.get())
                .pattern("PBP")
                .pattern("PBP")
                .pattern("PLP")
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
                .pattern("PLP")
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
        ShapelessRecipeBuilder.shapeless(ModItems.DECAF_COFFEE_BEAN.get())
                .requires(ModItems.COFFEE_BEAN.get())
                .requires(Items.CHARCOAL)
                .requires(Items.WATER_BUCKET, 2)
                .unlockedBy("has_coffee_bean", has(ModItems.COFFEE_BEAN.get()))
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Coffee-making paraphernalia

        ShapedRecipeBuilder.shaped(ModItems.COFFEE_FILTER.get())
                .pattern("P P")
                .pattern(" P ")
                .define('P', Items.PAPER)
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.WHISK.get())
                .pattern("I")
                .pattern("S")
                .define('I', Items.IRON_BARS)
                .define('S', Items.STICK)
                .unlockedBy("has_iron_bars", has(Items.IRON_BARS))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Tea-making paraphernalia

        ShapedRecipeBuilder.shaped(ModBlocks.KETTLE.get(), 1)
                .pattern(" C ")
                .pattern("C C")
                .pattern("CCC")
                .define('C', Tags.Items.INGOTS_COPPER)
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.SUN_TEA_JAR.get(), 1)
//                .pattern(" _ ")
//                .pattern("G G")
//                .pattern("GGG")
//                .define('_', ItemTags.SLABS)
//                .define('G', Tags.Items.GLASS)
//                .unlockedBy("has_glass", has(Tags.Items.GLASS))
//                .unlockedBy("has_slabs", has(ItemTags.SLABS))
//                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Kitchenware

        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_CUP.get())
                .pattern("X X")
                .pattern("X X")
                .pattern("___")
                .define('X', ItemTags.PLANKS)
                .define('_', ItemTags.WOODEN_SLABS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .unlockedBy("has_slabs", has(ItemTags.WOODEN_SLABS))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.TEACUP.get(), 1)
                .pattern("C C")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PLATE.get(), 1)
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PINT_MUG.get(), 1)
                .pattern("SSS")
                .pattern("SPI")
                .pattern("SSS")
                .define('S', ModTags.STRIPPED_WOOD)
                .define('P', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_stripped_wood", has(ModTags.STRIPPED_WOOD))
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.TRAVEL_MUG.get(), 1)
                .pattern("IGI")
                .pattern("I I")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('G', Tags.Items.GLASS)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_glass", has(Tags.Items.GLASS))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.DISPOSABLE_CUP.get(), 1)
                .pattern("IGI")
                .pattern("I I")
                .pattern("III")
                .define('I', Items.PAPER)
                .define('G', ItemTags.WOODEN_SLABS)
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_wooden_slab", has(ItemTags.WOODEN_SLABS))
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Tea ingredients

        ShapedRecipeBuilder.shaped(ModItems.TEA_BAG.get(), 1)
                .pattern(" S ")
                .pattern("PTP")
                .pattern("PPP")
                .define('S', Items.STRING)
                .define('P', Items.PAPER)
                .define('T', ModItems.TEA_LEAF.get())
                .unlockedBy("has_string", has(Items.STRING))
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_tea_leaf", has(ModItems.TEA_LEAF.get()))
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
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
//        CoffeeMakerRecipeBuilder.drip(ModItems.COFFEE_DRINK.get(), 0.1f, 300)
//                .requires(Ingredient.of(Items.WATER_BUCKET))
//                .requires(Ingredient.of(ModItems.COFFEE_FILTER.get()))
//                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
//                .unlockedBy("has_water", has(Items.WATER_BUCKET))
//                .unlockedBy("has_filter", has(ModItems.COFFEE_FILTER.get()))
//                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
//                .save(consumer);
//        CoffeeMakerRecipeBuilder.frenchPress(ModItems.COFFEE_DRINK.get(), 0.1f, 300)
//                .requires(Ingredient.of(ModItems.BOILING_WATER.get()))
//                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
//                .unlockedBy("has_hot_water", has(ModItems.BOILING_WATER.get()))
//                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
//                .save(consumer);
//        CoffeeMakerRecipeBuilder.campfire(ModItems.COFFEE_DRINK.get(), 0.2f, 600)
//                .requires(Ingredient.of(ModItems.BOILING_WATER.get()))
//                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
//                .unlockedBy("has_hot_water", has(ModItems.BOILING_WATER.get()))
//                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
//                .save(consumer);
//        CoffeeMakerRecipeBuilder.percolated(ModItems.COFFEE_DRINK.get(), 0.1f, 450)
//                .requires(Ingredient.of(Items.WATER_BUCKET))
//                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
//                .unlockedBy("has_water", has(Items.WATER_BUCKET))
//                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
//                .save(consumer);
//        CoffeeMakerRecipeBuilder.pod(ModItems.COFFEE_DRINK.get(), 0.1f, 180)
//                .requires(Ingredient.of(Items.WATER_BUCKET))
//                .requires(Ingredient.of(ModItems.COFFEE_GROUNDS.get()))
//                .unlockedBy("has_water", has(Items.WATER_BUCKET))
//                .unlockedBy("has_coffee_grounds", has(ModItems.COFFEE_GROUNDS.get()))
//                .save(consumer);
//        CoffeeMakerRecipeBuilder.espresso(ModItems.ESPRESSO_DRINK.get(), 0.3f, 300)
//                .requires(Ingredient.of(Items.WATER_BUCKET))
//                .requires(Ingredient.of(ModItems.FINE_COFFEE_GROUNDS.get()))
//                .unlockedBy("has_water", has(Items.WATER_BUCKET))
//                .unlockedBy("has_fine_coffee_grounds", has(ModItems.FINE_COFFEE_GROUNDS.get()))
//                .save(consumer);
////        TeaRecipeBuilder.seeped(ModItems.CHAMOMILE_TEA_DRINK.get(), 0.1f, 300)
////                // TODO
////                .save(consumer);
////        TeaRecipeBuilder.brewed(ModItems.SUN_TEA_DRINK.get(), 0.1f, 300)
////                // TODO
////                .save(consumer);
////        TeaRecipeBuilder.brewed(ModItems.GREEN_TEA_DRINK.get(), 0.1f, 300)
////                // TODO
////                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Miscellaneous ingredients

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), ModItems.STEAMED_MILK.get(), 0.1f, 240)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.WATER_BUCKET), ModItems.BOILING_WATER.get(), 0.1f, 240)
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
                .save(consumer);
        KettleHeatingRecipeBuilder.heating(Ingredient.of(Items.WATER_BUCKET), ModItems.BOILING_WATER.get(), 0.1f, 240)
                .unlockedBy("has_water", has(Items.WATER_BUCKET))
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
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Coffee-processing devices

        ShapedRecipeBuilder.shaped(ModBlocks.HAND_COFFEE_GRINDER.get(), 1)
                .pattern("LI ")
                .pattern("GFG")
                .pattern(" G ")
                .define('G', Tags.Items.GLASS)
                .define('I', Items.IRON_INGOT)
                .define('F', Items.FLINT)
                .define('L', Items.LEVER)
                .unlockedBy("has_glass", has(Tags.Items.GLASS))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_flint", has(Items.FLINT))
                .unlockedBy("has_lever", has(Items.LEVER))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POWERED_COFFEE_GRINDER.get(), 1)
                .pattern(" G ")
                .pattern("IFI")
                .pattern("IRI")
                .define('G', Tags.Items.GLASS)
                .define('I', Items.IRON_INGOT)
                .define('F', Items.FLINT)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_glass", has(Tags.Items.GLASS))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_flint", has(Items.FLINT))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.COFFEE_ROASTER.get(), 1)
                .pattern("  H")
                .pattern("IFD")
                .pattern("IRB")
                .define('H', Items.HOPPER)
                .define('D', Items.DISPENSER)
                .define('F', Items.FURNACE)
                .define('I', Items.IRON_INGOT)
                .define('B', Items.BUCKET)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_hopper", has(Items.HOPPER))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(consumer);

        // ----------------------------------------------------------------------------------------------------------------
        // Coffee-making devices

//        ShapedRecipeBuilder.shaped(ModBlocks.PERCOLATOR.get(), 1)
//                .pattern(" G ")
//                .pattern("IBI")
//                .pattern("IRI")
//                .define('G', Tags.Items.GLASS)
//                .define('B', ModItems.BOILING_WATER.get())
//                .define('I', Items.IRON_INGOT)
//                .define('R', Items.REDSTONE)
//                .unlockedBy("has_glass", has(Tags.Items.GLASS))
//                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
//                .unlockedBy("has_boiling_water", has(ModItems.BOILING_WATER.get()))
//                .unlockedBy("has_redstone", has(Items.REDSTONE))
//                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.POD_MACHINE.get(), 1)
//                .pattern("bL ")
//                .pattern("CBC")
//                .pattern("CRC")
//                .define('b', ItemTags.BUTTONS)
//                .define('L', Items.LEVER)
//                .define('C', Tags.Items.INGOTS_COPPER)
//                .define('B', ModItems.BOILING_WATER.get())
//                .define('R', Items.REDSTONE)
//                .unlockedBy("has_button", has(ItemTags.BUTTONS))
//                .unlockedBy("has_lever", has(Items.LEVER))
//                .unlockedBy("has_copper_ingot", has(Tags.Items.INGOTS_COPPER))
//                .unlockedBy("has_boiling_water", has(ModItems.BOILING_WATER.get()))
//                .unlockedBy("has_redstone", has(Items.REDSTONE))
//                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.ESPRESSO_MACHINE.get(), 1)
//                .pattern(" H ")
//                .pattern("ILI")
//                .pattern("IRI")
//                .define('H', Items.HOPPER)
//                .define('I', Items.IRON_INGOT)
//                .define('L', Items.LEVER)
//                .define('R', Items.REDSTONE)
//                .unlockedBy("has_hopper", has(Items.HOPPER))
//                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
//                .unlockedBy("has_lever", has(Items.LEVER))
//                .unlockedBy("has_redstone", has(Items.REDSTONE))
//                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.CAMPFIRE_COFFEE_POT.get(), 1)
//                .pattern("CSC")
//                .pattern("CPC")
//                .pattern("CCC")
//                .define('C', Tags.Items.INGOTS_COPPER)
//                .define('S', Items.STICK)
//                .define('P', Items.LIGHT_WEIGHTED_PRESSURE_PLATE)
//                .unlockedBy("has_copper_ingot", has(Tags.Items.INGOTS_COPPER))
//                .unlockedBy("has_stick", has(Items.STICK))
//                .unlockedBy("has_light_pressure_plate", has(Items.LIGHT_WEIGHTED_PRESSURE_PLATE))
//                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.FRENCH_PRESS.get(), 1)
//                .pattern("GSG")
//                .pattern("GPG")
//                .pattern("GGG")
//                .define('G', Tags.Items.GLASS)
//                .define('S', Items.STICK)
//                .define('P', Items.LIGHT_WEIGHTED_PRESSURE_PLATE)
//                .unlockedBy("has_glass", has(Tags.Items.GLASS))
//                .unlockedBy("has_stick", has(Items.STICK))
//                .unlockedBy("has_light_pressure_plate", has(Items.LIGHT_WEIGHTED_PRESSURE_PLATE))
//                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.DRIP_COFFEE_CARAFE.get(), 1)
//                .pattern("GHG")
//                .pattern("III")
//                .pattern("GGG")
//                .define('G', Items.GLASS)
//                .define('H', Items.HOPPER)
//                .define('I', Items.IRON_INGOT)
//                .unlockedBy("has_hopper", has(Items.HOPPER))
//                .unlockedBy("has_iron", has(Items.IRON_INGOT))
//                .unlockedBy("has_glass", has(Items.GLASS))
//                .save(consumer);
//        ShapedRecipeBuilder.shaped(ModBlocks.DRIP_COFFEE_MACHINE.get(), 1)
//                .pattern("KHB")
//                .pattern(" CF")
//                .pattern("IRI")
//                .define('B', Items.BUCKET)
//                .define('H', Items.HOPPER)
//                .define('I', Items.IRON_INGOT)
//                .define('R', Items.REDSTONE)
//                .define('K', Items.CLOCK)
//                .define('F', Items.FURNACE)
//                .define('C', ModBlocks.DRIP_COFFEE_CARAFE.get())
//                .unlockedBy("has_hopper", has(Items.HOPPER))
//                .unlockedBy("has_iron", has(Items.IRON_INGOT))
//                .unlockedBy("has_bucket", has(Items.BUCKET))
//                .unlockedBy("has_clock", has(Items.CLOCK))
//                .unlockedBy("has_redstone", has(Items.REDSTONE))
//                .unlockedBy("has_furnace", has(Items.FURNACE))
//                .unlockedBy("has_carafe", has(ModBlocks.DRIP_COFFEE_CARAFE.get()))
//                .save(consumer);
    }

    @Override
    protected void saveAdvancement(HashCache cache, JsonObject advancementJson, Path pathIn) {
    }

}
