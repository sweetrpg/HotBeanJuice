package com.sweetrpg.hotbeanjuice.common.addon.jei;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.recipes.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.util.Util;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@JeiPlugin
public class HBJPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ModIds.JEI_ID, Constants.MOD_ID);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
//        registration.registerSubtypeInterpreter(ModBlocks.CAT_TREE.get().asItem(), (stack, ctx) -> {
//            IColorMaterial colorMaterial = CatTreeUtil.getColorMaterial(stack);
//
//            String colorKey = colorMaterial != null ? colorMaterial.getRegistryName().toString()
//                    : "HotBeanJuice:casing_missing";
//
//            return colorKey;
//        });
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                (IRecipeCategory<?>) List.of(
                        new HBJRecipeCategory<GrindingRecipe>() {
                            @Override
                            public Component getTitle() {
                                return new TranslatableComponent(Constants.TRANSLATION_KEY_RECIPE_TYPE_GRINDING_TITLE);
                            }

                            @Override
                            public IDrawable getBackground() {
                                return null;
                            }

                            @Override
                            public IDrawable getIcon() {
                                return null;
                            }

                            @Override
                            public ResourceLocation getUid() {
                                return Util.modLoc("grinding");
                            }

                            @Override
                            public Class<? extends GrindingRecipe> getRecipeClass() {
                                return GrindingRecipe.class;
                            }
                        }
                )
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
//        registration.addRecipes(ModRecipeTypes.BREWING.get(), (Collection<?>) List.of());
    }
}
