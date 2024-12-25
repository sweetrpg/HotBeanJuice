package com.sweetrpg.hotbeanjuice.integration.jei;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeTypes;
import com.sweetrpg.hotbeanjuice.integration.jei.category.GrindingRecipeCategory;
import com.sweetrpg.hotbeanjuice.integration.jei.category.KettleHeatingRecipeCategory;
import com.sweetrpg.hotbeanjuice.integration.jei.category.RoastingRecipeCategory;
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
        registration.addRecipeCategories(new GrindingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new RoastingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        //        registration.addRecipeCategories(new WhiskingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        //        registration.addRecipeCategories(new DripCoffeeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new KettleHeatingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(findRecipesByType(ModRecipeTypes.GRINDING.get()), GrindingRecipeCategory.UID);
        registration.addRecipes(findRecipesByType(ModRecipeTypes.ROASTING.get()), RoastingRecipeCategory.UID);
        //        registration.addRecipes(findRecipesByType(ModRecipeTypes.WHISKING.get()), WhiskingRecipeCategory.UID);
        registration.addRecipes(findRecipesByType(ModRecipeTypes.KETTLE_HEATING.get()), KettleHeatingRecipeCategory.UID);
        //        registration.addRecipes(findRecipesByType(ModRecipeTypes.DRIP_COFFEE.get()), DripCoffeeRecipeCategory.UID);
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
