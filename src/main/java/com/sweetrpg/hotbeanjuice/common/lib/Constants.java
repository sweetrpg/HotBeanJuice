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
    public static final String TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE = "itemGroup.hotbeanjuice";
    public static final String TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE = "block.hotbeanjuice.coffee_bush";
    public static final String TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE = "block.hotbeanjuice.wild_coffee_bush";
    public static final String TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE = "item.hotbeanjuice.coffee_bush";
    public static final String TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE = "item.hotbeanjuice.coffee_cherry";
    public static final String TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE = "item.hotbeanjuice.coffee_bean";
    public static final String TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE = "item.hotbeanjuice.coffee_seeds";
    public static final String TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE = "item.hotbeanjuice.coffee_grounds";
    public static final String TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE = "item.hotbeanjuice.coffee_filter";
    public static final String TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH = "config.chance_coffee_bush.description";
    public static final String TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD = "config.coffee_bush_spread.description";

    // Advancements
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_LIST_TITLE = "advancements.hotbeanjuice.main.make_list.title";
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_LIST_DESCRIPTION = "advancements.hotbeanjuice.main.make_list.description";

}
