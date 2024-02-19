package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
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
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BAG_BEANS_TITLE, "Coffee Bag (Beans)");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BAG_GROUND_TITLE, "Coffee Bag (Ground)");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_BLOCK_DISPOSABLE_CUP_TITLE, "Disposable Cup");
        add(Constants.TRANSLATION_KEY_BLOCK_FIRED_COFFEE_CUP_TITLE, "Kiln-fired Coffee Cup");
        add(Constants.TRANSLATION_KEY_BLOCK_HAND_COFFEE_GRINDER_TITLE, "Hand-crank Burr Coffee Grinder");
        add(Constants.TRANSLATION_KEY_BLOCK_POWERED_COFFEE_GRINDER_TITLE, "Powered Burr Coffee Grinder");
        add(Constants.TRANSLATION_KEY_BLOCK_TRAVEL_CUP_TITLE, "Travel Cup");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Wild Coffea Bush");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Coffee Cup");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_ITEM_CLAY_MUG_TITLE, "Clay Mug");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Coffee Bean");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Coffea Cherry");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Coffee Grounds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE, "Coffee Filter");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");

        add(ModBlocks.DRIP_COFFEE_MAKER.get(), "Drip Coffee Maker");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");

    }

    private void processENGB() {
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Coffea Seeds");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BAG_BEANS_TITLE, "Coffee Bag (Beans)");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BAG_GROUND_TITLE, "Coffee Bag (Ground)");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_BLOCK_DISPOSABLE_CUP_TITLE, "Disposable Cup");
        add(Constants.TRANSLATION_KEY_BLOCK_FIRED_COFFEE_CUP_TITLE, "Kiln-fired Coffee Cup");
        add(Constants.TRANSLATION_KEY_BLOCK_HAND_COFFEE_GRINDER_TITLE, "Hand-crank Burr Coffee Grinder");
        add(Constants.TRANSLATION_KEY_BLOCK_POWERED_COFFEE_GRINDER_TITLE, "Powered Burr Coffee Grinder");
        add(Constants.TRANSLATION_KEY_BLOCK_TRAVEL_CUP_TITLE, "Travel Cup");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Wild Coffea Bush");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Coffee Cup");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_ITEM_CLAY_MUG_TITLE, "Clay Mug");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Coffee Bean");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Coffea Cherry");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Coffee Grounds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE, "Coffee Filter");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
    }

    private void processDEDE() {
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Heißer Bohnensaft");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Coffea Seeds");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Machen Sie Ihre erste Tasse Kaffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "Wir machen Kaffee");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BAG_BEANS_TITLE, "Kaffeebeutel (Bohnen)");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BAG_GROUND_TITLE, "Kaffeebeutel (gemahlen)");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_BLOCK_DISPOSABLE_CUP_TITLE, "Einwegbecher");
        add(Constants.TRANSLATION_KEY_BLOCK_FIRED_COFFEE_CUP_TITLE, "Im Ofen gebrannte Kaffeetasse");
        add(Constants.TRANSLATION_KEY_BLOCK_HAND_COFFEE_GRINDER_TITLE, "Kaffeemühle mit Handkurbel");
        add(Constants.TRANSLATION_KEY_BLOCK_POWERED_COFFEE_GRINDER_TITLE, "Angetriebene Kaffeemühle mit Mahlwerk");
        add(Constants.TRANSLATION_KEY_BLOCK_TRAVEL_CUP_TITLE, "Reisebecher");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Kaffeetasse");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Es besteht die Möglichkeit, dass Kaffeesträucher in freier Wildbahn auftauchen");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontale Ausbreitung von Kaffeebüschen");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Heißer Bohnensaft");
        add(Constants.TRANSLATION_KEY_ITEM_CLAY_MUG_TITLE, "Tonbecher");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Kaffeebohne");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Kaffeekirsche");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Kaffeesatz");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE, "Kaffeefilter");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Es besteht die Möglichkeit, dass Kaffeesträucher in freier Wildbahn auftauchen");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontale Ausbreitung von Kaffeebüschen");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Kaffeesamen");
    }

}
