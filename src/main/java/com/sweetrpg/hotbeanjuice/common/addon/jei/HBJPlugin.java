package com.sweetrpg.hotbeanjuice.common.addon.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class HBJPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ModIds.JEI_ID, "hotbeanjuice");
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
    public void registerRecipes(IRecipeRegistration registration) {
//        registration.addRecipes(ModRecipeTypes.BREWING.get(), List.of());
    }
}
