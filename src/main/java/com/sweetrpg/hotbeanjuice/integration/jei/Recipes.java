//package com.sweetrpg.hotbeanjuice.common.integration.jei;
//
//import com.sweetrpg.hotbeanjuice.common.item.crafting.GrindingRecipe;
//import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeTypes;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.world.item.crafting.RecipeManager;
//
//import java.util.List;
//
//public class Recipes {
//
//    private final RecipeManager recipeManager;
//
//    public Recipes() {
//        Minecraft minecraft = Minecraft.getInstance();
//        ClientLevel level = minecraft.level;
//
//        if(level != null) {
//            this.recipeManager = level.getRecipeManager();
//        }
//        else {
//            throw new NullPointerException("Minecraft world must not be null!");
//        }
//    }
//
//    public List<GrindingRecipe> getGrindingRecipes() {
//        return recipeManager.getAllRecipesFor(ModRecipeTypes.GRINDING.get()).stream().toList();
//    }
//
//}
