package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
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
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Wild Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Coffea Seeds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Coffea Cherry");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Coffee Bean");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Coffee Grounds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE, "Coffee Filter");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
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

        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Roaster");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIPCOFFEE_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIPCOFFEE_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_GRINDING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_GRINDING_TITLE, "Grinding");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_ROASTING_TITLE, "Roasting");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_WHISKING_TITLE, "Whisking");

        add(ModBlocks.DRIP_COFFEE_MAKER.get(), "Drip Coffee Maker");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Coffee Bag (Beans)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Coffee Bag (Ground)");
        add(ModBlocks.COFFEE_ROASTER.get(), "Coffee Roaster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica Coffea Bush");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora Coffea Bush");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa Coffea Bush");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.DRIP_COFFEE_MACHINE.get(), "Drip Coffee Machine");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Kiln-fired Coffee Cup");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Hand-crank Burr Coffee Grinder");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Powered Burr Coffee Grinder");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wild Arabica Coffea Bush");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wild Canephora Coffea Bush");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wild Racemosa Coffea Bush");

        add(ModItems.BAD_COFFEE_BEAN.get(), "Bad Coffee Bean");
        add(ModItems.BOILING_WATER.get(), "Boiling Water");
        add(ModItems.CAPPUCCINO_DRINK.get(), "Cappuccino");
        add(ModItems.CLAY_MUG.get(), "Clay Mug");
        add(ModItems.COCOA_POWDER.get(), "Cocoa Powder");
        add(ModItems.COFFEE_BEAN.get(), "Coffee Bean");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa Coffea Cherry");
        add(ModItems.COFFEE_DRINK.get(), "Coffee");
        add(ModItems.COFFEE_FILTER.get(), "Coffee Filter");
        add(ModItems.COFFEE_GROUNDS.get(), "Coffee Grounds");
        add(ModItems.ESPRESSO_DRINK.get(), "Espresso");
        add(ModItems.FINE_COFFEE_GROUNDS.get(), "Fine Coffee Grounds");
        add(ModItems.HOT_CHOCOLATE_DRINK.get(), "Hot Chocolate");
        add(ModItems.LATTE_DRINK.get(), "Latté");
        add(ModItems.MACCHIATO_DRINK.get(), "Macchiato");
        add(ModItems.MILK_FOAM.get(), "Milk Foam");
        add(ModItems.MOCHA_DRINK.get(), "Mocha");
        add(ModItems.STEAMED_MILK.get(), "Steamed Milk");
        add(ModItems.WHISK.get(), "Whisk");
    }

    private void processENGB() {
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Wild Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Coffea Bush");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Coffea Seeds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Coffea Cherry");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Coffee Bean");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Coffee Grounds");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE, "Coffee Filter");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
    }

    private void processDEDE() {
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Heißer Bohnensaft");
        add(Constants.TRANSLATION_KEY_BLOCK_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_SEEDS_TITLE, "Kaffeesamen");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_CHERRY_TITLE, "Kaffeekirsche");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_BEAN_TITLE, "Kaffeebohne");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_GROUNDS_TITLE, "Kaffeesatz");
        add(Constants.TRANSLATION_KEY_ITEM_COFFEE_FILTER_TITLE, "Kaffeefilter");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Es besteht die Möglichkeit, dass Kaffeesträucher in freier Wildbahn auftauchen");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontale Ausbreitung von Kaffeebüschen");
    }

}
