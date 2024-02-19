package com.sweetrpg.hotbeanjuice.common.lib;

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
    public static final String TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE = "itemGroup.hotbeanjuice";
    public static final String TRANSLATION_KEY_RECIPE_TYPE_GRINDING_TITLE = "grinding";

    // Advancements
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE = "advancements.hotbeanjuice.main.make_coffee.title";
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION = "advancements.hotbeanjuice.main.make_coffee.description";

}
