package com.sweetrpg.hotbeanjuice.integration.jei;

import com.sweetrpg.hotbeanjuice.integration.jei.category.GrindingRecipeCategory;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class HBJPlugin implements IModPlugin {

    private static final ResourceLocation ID = new ResourceLocation(Constants.MOD_ID, "jei_plugin");
    private static final Minecraft MC = Minecraft.getInstance();

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
//        registration.addRecipeCategories(new CofeeBrewingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new GrindingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//        registration.addRecipeCategories(new RoastingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//        registration.addRecipeCategories(new WhiskingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalyst(new ItemStack(ModItems.COOKING_POT.get()), FDRecipeTypes.COOKING);
//        registration.addRecipeCatalyst(new ItemStack(ModItems.CUTTING_BOARD.get()), FDRecipeTypes.CUTTING);
//        registration.addRecipeCatalyst(new ItemStack(ModItems.STOVE.get()), RecipeTypes.CAMPFIRE_COOKING);
//        registration.addRecipeCatalyst(new ItemStack(ModItems.SKILLET.get()), RecipeTypes.CAMPFIRE_COOKING);
//        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ORGANIC_COMPOST.get()), FDRecipeTypes.DECOMPOSITION);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(findRecipesByType(ModRecipeTypes.GRINDING.get()), GrindingRecipeCategory.UID);

    }

    private static List<Recipe<?>> findRecipesByType(RecipeType<?> type) {
        return MC.level
                .getRecipeManager()
                .getRecipes()
                .stream()
                .filter(r -> r.getType() == type)
                .collect(Collectors.toList());
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

}
