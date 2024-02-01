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
        return "HotBeanJuice Language Provider";
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
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Coffee Cup");
        add(Constants.TRANSLATION_KEY_TRAVEL_CUP_BLOCK_TITLE, "Travel Cup");
        add(Constants.TRANSLATION_KEY_DISPOSABLE_CUP_BLOCK_TITLE, "Disposable Cup");
        add(Constants.TRANSLATION_KEY_CLAY_MUG_ITEM_TITLE, "Clay Mug");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Wild Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Coffea Seeds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Coffea Cherry");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Coffee Bean");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Coffee Grounds");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
    }

    private void processENGB() {
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Coffee Cup");
        add(Constants.TRANSLATION_KEY_TRAVEL_CUP_BLOCK_TITLE, "Travel Cup");
        add(Constants.TRANSLATION_KEY_DISPOSABLE_CUP_BLOCK_TITLE, "Disposable Cup");
        add(Constants.TRANSLATION_KEY_CLAY_MUG_ITEM_TITLE, "Clay Mug");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Wild Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Coffea Seeds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Coffea Cherry");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Coffee Bean");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Coffee Grounds");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
    }

    private void processDEDE() {
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Kaffeetasse");
        add(Constants.TRANSLATION_KEY_TRAVEL_CUP_BLOCK_TITLE, "Reisebecher");
        add(Constants.TRANSLATION_KEY_DISPOSABLE_CUP_BLOCK_TITLE, "Einwegbecher");
        add(Constants.TRANSLATION_KEY_CLAY_MUG_ITEM_TITLE, "Tonbecher");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Heißer Bohnensaft");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Kaffeesamen");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Kaffeekirsche");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Kaffeebohne");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Kaffeesatz");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Es besteht die Möglichkeit, dass Kaffeesträucher in freier Wildbahn auftauchen");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontale Ausbreitung von Kaffeebüschen");
    }

}
