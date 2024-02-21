package com.sweetrpg.hotbeanjuice.integration.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.item.crafting.DripCoffeeRecipe;
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

public class DripCoffeeRecipeCategory implements IRecipeCategory<DripCoffeeRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Constants.MOD_ID, DripCoffeeRecipe.RECIPE_TYPE_NAME);

    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;
    protected final IDrawable xpIcon;
    private final IDrawable slot;
    private final IDrawable slotChance;
    protected final IDrawableAnimated heat;

    public DripCoffeeRecipeCategory(IGuiHelper helper) {
        title = TextUtils.getTranslation("jei." + DripCoffeeRecipe.RECIPE_TYPE_NAME);
        ResourceLocation backgroundImage = new ResourceLocation(Constants.MOD_ID, "textures/gui/jei/drip_coffee.png");
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.DRIP_COFFEE_MACHINE.get()));
        heat = helper.drawableBuilder(backgroundImage, 36, 58, 14, 14)
                .buildAnimated(200, IDrawableAnimated.StartDirection.BOTTOM, false);
        slot = helper.createDrawable(backgroundImage, 0, 58, 18, 18);
        slotChance = helper.createDrawable(backgroundImage, 18, 58, 18, 18);
        background = helper.createDrawable(backgroundImage, 0, 0, 117, 57);
        xpIcon = helper.createDrawable(backgroundImage, 50, 58, 9, 9);
    }

    @Override
    public void setIngredients(DripCoffeeRecipe dripCoffeeRecipe, IIngredients ingredients) {
        ingredients.setInputIngredients(dripCoffeeRecipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, dripCoffeeRecipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DripCoffeeRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
//        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();

        // Draw grinder
//        itemStacks.init(0, true, 15, 30);
//        itemStacks.set(0, List.of(new ItemStack(ModBlocks.COFFEE_ROASTER.get())));

        // Draw input
        itemStacks.init(0, true, 15, 8);
        itemStacks.set(0, Arrays.asList(recipe.getIngredients().get(0).getItems()));

        itemStacks.init(1, false, 84, 20);
        itemStacks.set(1, recipe.getResultItem());

        // TODO: for rollable result chance items
//        itemStacks.addTooltipCallback((slotIndex, input, ingredient, tooltip) -> {
//            if (input || slotIndex < 2) {
//                return;
//            }
//            ChanceResult output = recipeOutputs.get(slotIndex - 2);
//            float chance = output.getChance();
//            if (chance != 1)
//                tooltip.add(1, TextUtils.getTranslation("jei.chance", chance < 0.01 ? "<1" : (int) (chance * 100))
//                        .withStyle(ChatFormatting.GOLD));
//        });
    }

    @Override
    public void draw(DripCoffeeRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack poseStack, double mouseX, double mouseY) {
        heat.draw(poseStack, 18, 33);
//        xpIcon.draw(poseStack, 86, 7);

//        NonNullList<ChanceResult> recipeOutputs = recipe.getRollableResults();
//
//        int size = recipe.getResults().size();
//        int centerX = size > 1 ? 0 : 9;
//        int centerY = size > 2 ? 0 : 9;
//
//        for (int i = 0; i < size; i++) {
//            int xOffset = centerX + (i % 2 == 0 ? 0 : 19);
//            int yOffset = centerY + ((i / 2) * 19);
//
//            if (recipeOutputs.get(i).getChance() != 1) {
//                slotChance.draw(matrixStack, OUTPUT_GRID_X + xOffset, OUTPUT_GRID_Y + yOffset);
//            } else {
//                slot.draw(poseStack, OUTPUT_GRID_X + xOffset, OUTPUT_GRID_Y + yOffset);
        slot.draw(poseStack, 84, 20);
//            }
//        }
    }

    @Override
    public List<Component> getTooltipStrings(DripCoffeeRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        List<Component> tooltipStrings = new ArrayList<>();

        if(ClientRenderUtil.isCursorInsideBounds(86, 7, 9, 9, mouseX, mouseY)) {
            float experience = recipe.getExperience();
            if(experience > 0) {
                tooltipStrings.add(new TranslatableComponent(Constants.TRANSLATION_KEY_GUI_JEI_DRIPCOFFEE_XP_TOOLTIP, experience));
            }
        }
        else if(ClientRenderUtil.isCursorInsideBounds(51, 15, 22, 38, mouseX, mouseY)) {
            int processingTime = recipe.getBrewingTime();
            if(processingTime > 0) {
                int processingTimeSeconds = processingTime / 20;
                tooltipStrings.add(new TranslatableComponent(Constants.TRANSLATION_KEY_GUI_JEI_DRIPCOFFEE_TIME_TOOLTIP, processingTimeSeconds));
            }
        }

        return tooltipStrings;
    }


    @Override
    public ResourceLocation getUid() {
        return this.getRecipeType().getUid();
    }

    @Override
    public Class<? extends DripCoffeeRecipe> getRecipeClass() {
        return this.getRecipeType().getRecipeClass();
    }

    @Override
    public RecipeType<DripCoffeeRecipe> getRecipeType() {
        return RecipeTypes.DRIP_COFFEE;
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
