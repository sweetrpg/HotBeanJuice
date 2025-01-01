package com.sweetrpg.hotbeanjuice.common;

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

    // Recipe serialization
    public static final String RECIPE_SERIALIZER_DATA_GROUP = "group";
    public static final String RECIPE_SERIALIZER_DATA_INGREDIENTS = "ingredients";
    public static final String RECIPE_SERIALIZER_DATA_RESULT = "result";
    public static final String RECIPE_SERIALIZER_DATA_EXPERIENCE = "experience";
    public static final String RECIPE_SERIALIZER_DATA_PROCESSING_TIME = "processing_time";
    public static final String RECIPE_SERIALIZER_DATA_MILLIBUCKETS = "millibuckets";
    public static final String RECIPE_SERIALIZER_CRITERION_HAS_RECIPE = "has_the_recipe";

    // Translation keys
    public static final String TRANSLATION_KEY_GUI_KETTLE_FULLNESS = "gui." + MOD_ID + ".kettle.fullness";
    public static final String TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH = "config.chance_coffee_bush.description";
    public static final String TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD = "config.coffee_bush_spread.description";
    public static final String TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE = "gui." + Constants.MOD_ID + ".coffee_roaster";
    public static final String TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_TIME_TOOLTIP = "jei.category.drip_coffee.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_XP_TOOLTIP = "jei.category.drip_coffee.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_GRINDING_TIME_TOOLTIP = "jei.category.grinding.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_ROASTING_TIME_TOOLTIP = "jei.category.roasting.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_ROASTING_XP_TOOLTIP = "jei.category.roasting.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_WHISKING_TIME_TOOLTIP = "jei.category.whisking.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_WHISKING_XP_TOOLTIP = "jei.category.whisking.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_TIME_TOOLTIP = "jei.category.kettle_heating.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_XP_TOOLTIP = "jei.category.kettle_heating.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_FRENCH_PRESS_COFFEE_XP_TOOLTIP = "jei.category.french_press_coffee.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_FRENCH_PRESS_COFFEE_TIME_TOOLTIP = "jei.category.french_press_coffee.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_PERCOLATOR_COFFEE_XP_TOOLTIP = "jei.category.percolator_coffee.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_PERCOLATOR_COFFEE_TIME_TOOLTIP = "jei.category.percolator_coffee.xp";
    public static final String TRANSLATION_KEY_GUI_JEI_POD_COFFEE_XP_TOOLTIP = "jei.category.pod_coffee.time.seconds";
    public static final String TRANSLATION_KEY_GUI_JEI_POD_COFFEE_TIME_TOOLTIP = "jei.category.pod_coffee.xp";
    public static final String TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE = "itemGroup.hotbeanjuice";
    //    public static final String TRANSLATION_KEY_RECIPETYPE_CAMPFIRE_COFFEE_TITLE = "jei." + Constants.MOD_ID+ "." +  CampfireCoffeeRecipe.RECIPE_TYPE_NAME ;
    public static final String TRANSLATION_KEY_RECIPETYPE_DRIP_COFFEE_TITLE = "jei." + Constants.MOD_ID + "." + DripCoffeeRecipe.RECIPE_TYPE_NAME;
    //    public static final String TRANSLATION_KEY_RECIPETYPE_ESPRESSO_TITLE = "jei." + Constants.MOD_ID+ "." + EspressoRecipe.RECIPE_TYPE_NAME  ;
    public static final String TRANSLATION_KEY_RECIPETYPE_FRENCHPRESS_COFFEE_TITLE = "jei." + Constants.MOD_ID + "." + FrenchPressCoffeeRecipe.RECIPE_TYPE_NAME;
    public static final String TRANSLATION_KEY_RECIPETYPE_GRINDING_TITLE = "jei." + Constants.MOD_ID + "." + GrindingRecipe.RECIPE_TYPE_NAME;
    public static final String TRANSLATION_KEY_RECIPETYPE_PERCOLATOR_COFFEE_TITLE = "jei." + Constants.MOD_ID + "." + PercolatorCoffeeRecipe.RECIPE_TYPE_NAME;
    public static final String TRANSLATION_KEY_RECIPETYPE_POD_COFFEE_TITLE = "jei." + Constants.MOD_ID + "." + PodCoffeeRecipe.RECIPE_TYPE_NAME;
    public static final String TRANSLATION_KEY_RECIPETYPE_ROASTING_TITLE = "jei." + Constants.MOD_ID + "." + RoastingRecipe.RECIPE_TYPE_NAME;
    public static final String TRANSLATION_KEY_RECIPETYPE_WHISKING_TITLE = "jei." + Constants.MOD_ID + "." + WhiskingRecipe.RECIPE_TYPE_NAME;
    public static final String TRANSLATION_KEY_RECIPETYPE_KETTLE_HEATING_TITLE = "jei." + Constants.MOD_ID + "." + KettleHeatingRecipe.RECIPE_TYPE_NAME;

    // Advancements
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE = "advancements." + Constants.MOD_ID + ".main.make_coffee.title";
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION = "advancements." + Constants.MOD_ID + ".main.make_coffee.description";

}
