package com.sweetrpg.hotbeanjuice.integration.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sweetrpg.hotbeanjuice.common.item.crafting.KettleHeatingRecipe;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.util.ClientRenderUtil;
import com.sweetrpg.hotbeanjuice.common.util.TextUtils;
import com.sweetrpg.hotbeanjuice.integration.jei.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KettleHeatingRecipeCategory implements IRecipeCategory<KettleHeatingRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Constants.MOD_ID, KettleHeatingRecipe.RECIPE_TYPE_NAME);

    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawable slot;
    protected final IDrawableAnimated heat;

    public KettleHeatingRecipeCategory(IGuiHelper helper) {
        title = TextUtils.getTranslation("jei." + KettleHeatingRecipe.RECIPE_TYPE_NAME);
        ResourceLocation backgroundImage = new ResourceLocation(Constants.MOD_ID, "textures/gui/jei/kettle_heating.png");
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.KETTLE.get()));
        heat = helper.drawableBuilder(backgroundImage, 36, 58, 24, 14)
                .buildAnimated(200, IDrawableAnimated.StartDirection.BOTTOM, false);
        slot = helper.createDrawable(backgroundImage, 0, 58, 18, 18);
        background = helper.createDrawable(backgroundImage, 0, 0, 117, 57);
    }

    @Override
    public void setIngredients(KettleHeatingRecipe kettleHeatingRecipe, IIngredients ingredients) {
        ingredients.setInputIngredients(kettleHeatingRecipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, kettleHeatingRecipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, KettleHeatingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
//        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();

        // Draw kettle
        itemStacks.init(0, true, 53, 22);
        itemStacks.set(0, List.of(new ItemStack(ModBlocks.KETTLE.get())));

        // Draw input
        itemStacks.init(1, true, 19, 5);
        itemStacks.set(1, Arrays.asList(recipe.getIngredients().get(0).getItems()));

        // Draw result
        itemStacks.init(2, false, 94, 22);
        itemStacks.set(2, recipe.getResultItem());

    }

    @Override
    public void draw(KettleHeatingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack poseStack, double mouseX, double mouseY) {
        heat.draw(poseStack, 55, 42);
        slot.draw(poseStack, 94, 22);
        slot.draw(poseStack, 53, 22);
    }

    @Override
    public List<Component> getTooltipStrings(KettleHeatingRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        List<Component> tooltipStrings = new ArrayList<>();

        if(ClientRenderUtil.isCursorInsideBounds(94, 7, 9, 9, mouseX, mouseY)) {
            float experience = recipe.getExperience();
            if(experience > 0) {
                tooltipStrings.add(new TranslatableComponent(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_XP_TOOLTIP, experience));
            }
        }
        else if(ClientRenderUtil.isCursorInsideBounds(70, 20, 22, 28, mouseX, mouseY)) {
            int processingTime = recipe.getHeatingTime();
            if(processingTime > 0) {
                int processingTimeSeconds = processingTime / 20;
                tooltipStrings.add(new TranslatableComponent(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_TIME_TOOLTIP, processingTimeSeconds));
            }
        }

        return tooltipStrings;
    }


    @Override
    public ResourceLocation getUid() {
        return this.getRecipeType().getUid();
    }

    @Override
    public Class<? extends KettleHeatingRecipe> getRecipeClass() {
        return this.getRecipeType().getRecipeClass();
    }

    @Override
    public RecipeType<KettleHeatingRecipe> getRecipeType() {
        return RecipeTypes.KETTLE_HEATING;
    }

    @Override
    public Component getTitle() {
        return this.title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

}
