package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class HBJLangProvider extends LanguageProvider {
    private final String locale;

    public HBJLangProvider(DataGenerator gen, String locale) {
        super(gen, Constants.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    public String getName() {
        return "Hot Bean Juice Language Provider";
    }

    @Override
    protected void addTranslations() {
        switch(this.locale) {
            case Constants.LOCALE_EN_US -> processENUS();
            case Constants.LOCALE_EN_GB -> processENGB();
            case Constants.LOCALE_DE_DE -> processDEDE();
        }
    }

    private void processENUS() {
        add(Constants.TRANSLATION_KEY_GUI_CRAFTLIST_TITLE, "Craft List");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Coffee Cup");
        add(Constants.TRANSLATION_KEY_CLAY_MUG_ITEM_TITLE, "Clay Mug");
    }

    private void processENGB() {
        add(Constants.TRANSLATION_KEY_GUI_CRAFTLIST_TITLE, "Craft List");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Coffee Cup");
        add(Constants.TRANSLATION_KEY_CLAY_MUG_ITEM_TITLE, "Clay Mug");
    }

    private void processDEDE() {
        add(Constants.TRANSLATION_KEY_GUI_CRAFTLIST_TITLE, "Craft List");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Kaffeetasse");
        add(Constants.TRANSLATION_KEY_CLAY_MUG_ITEM_TITLE, "Tonbecher");
    }

}
