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
    public static final String TRANSLATION_KEY_GUI_CRAFTLIST_TITLE = "hotbeanjuice.screen.list.title";
    // Advancements
    public static final String TRANSLATION_KEY_ADVANCEMENT_MAKE_LIST_TITLE = "advancements.hotbeanjuice.main.make_list.title";
    public static final String TRANSLATION_KEY_ADVANCEMENT_TRAIN_CAT_DESCRIPTION = "advancements.hotbeanjuice.main.make_list.description";

}
