package com.sweetrpg.hotbeanjuice.common.lib;

import com.sweetrpg.hotbeanjuice.common.item.crafting.*;
import com.sweetrpg.hotbeanjuice.common.util.Util;
import net.minecraft.resources.ResourceLocation;

public class Constants {

    public static final String MOD_ID = "hotbeanjuice";
    public static final String MOD_NAME = "Hot Bean Juice";

    public static final String VANILLA_ID = "minecraft";
    public static final String VANILLA_NAME = "Minecraft";

    // Network
    public static final ResourceLocation CHANNEL_NAME = Util.getResource("channel");
    public static final String PROTOCOL_VERSION = Integer.toString(1);

    // Language
    public static final String LOCALE_EN_US = "en_us";
    public static final String LOCALE_EN_GB = "en_gb";
    public static final String LOCALE_DE_DE = "de_de";

    // Translation keys
    public static final String TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE = "block.hotbeanjuice.wild_coffee_bush";
    public static final String TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE = "block.hotbeanjuice.coffee_cup";
    public static final String TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH = "config.chance_coffee_bush.description";
    public static final String TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD = "config.coffee_bush_spread.description";
    public static final String TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE = "gui.hotbeanjuice.coffee_roaster";
    public static final String TRANSLATION_KEY_GUI_JEI_DRIPCOFFEE_TIME_TOOLTIP = "jei.category.drip_coffee.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_DRIPCOFFEE_XP_TOOLTIP = "jei.category.drip_coffee.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_GRINDING_TIME_TOOLTIP = "jei.category.grinding.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_ROASTING_TIME_TOOLTIP = "jei.category.roasting.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_ROASTING_XP_TOOLTIP = "jei.category.roasting.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_WHISKING_TIME_TOOLTIP = "jei.category.whisking.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_WHISKING_XP_TOOLTIP = "jei.category.whisking.time.seconds";
    public static final String TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE = "itemGroup.hotbeanjuice";
    public static final String TRANSLATION_KEY_RECIPETYPE_CAMPFIRECOFFEE_TITLE = "jei." + CampfireCoffeeRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_DRIPCOFFEE_TITLE = "jei." + DripCoffeeRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_ESPRESSO_TITLE = "jei." + EspressoRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_FRENCHPRESSCOFFEE_TITLE = "jei." + FrenchPressCoffeeRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_GRINDING_TITLE = "jei." + GrindingRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_PERCOLATORCOFFEE_TITLE = "jei." + PercolatorCoffeeRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_PODCOFFEE_TITLE = "jei." + PodCoffeeRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_ROASTING_TITLE = "jei." + RoastingRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;
    public static final String TRANSLATION_KEY_RECIPETYPE_WHISKING_TITLE = "jei." + WhiskingRecipe.RECIPE_TYPE_NAME + "." + Constants.MOD_ID;

    // Advancements
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE = "advancements.hotbeanjuice.main.make_coffee.title";
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION = "advancements.hotbeanjuice.main.make_coffee.description";

}
