package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.Constants;
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
        return "Hot Bean Juice - Language Strings";
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
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Roaster");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_GRINDING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_GRINDING_TITLE, "Grinding");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_ROASTING_TITLE, "Roasting");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_WHISKING_TITLE, "Whisking");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_KETTLE_HEATING_TITLE, "Kettle Heating");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_DRIP_COFFEE_TITLE, "Drip Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_FRENCHPRESS_COFFEE_TITLE, "French Press Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_PERCOLATOR_COFFEE_TITLE, "Percolator Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_POD_COFFEE_TITLE, "Pod Machine Coffee-making");

//        add(ModBlocks.CAMPFIRE_COFFEE_POT.get(), "Campfire Coffee Pot");
        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Coffee Bag (Beans)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Coffee Bag (Ground)");
        add(ModBlocks.COFFEE_CUP.get(), "Coffee Cup");
        add(ModBlocks.COFFEE_ROASTER.get(), "Coffee Roaster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica Coffea Bush");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora Coffea Bush");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa Coffea Bush");
        add(ModBlocks.DISPOSABLE_CUP.get(), "Disposable Cup");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.DRIP_COFFEE_MACHINE.get(), "Drip Coffee Machine");
//        add(ModBlocks.ESPRESSO_MACHINE.get(), "Espresso Machine");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Kiln-fired Coffee Cup");
        add(ModBlocks.FRENCH_PRESS.get(), "French Press");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Hand-crank Burr Coffee Grinder");
        add(ModBlocks.KETTLE.get(), "Kettle");
        add(ModBlocks.PERCOLATOR.get(), "Percolator");
        add(ModBlocks.PLATE.get(), "Plate");
        add(ModBlocks.PINT_MUG.get(), "Pint Mug");
        add(ModBlocks.POD_MACHINE.get(), "Pod Coffee Maker");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Powered Burr Coffee Grinder");
        add(ModBlocks.SUN_TEA_JAR.get(), "Sun Tea Jar");
        add(ModBlocks.TEACUP.get(), "Teacup");
        add(ModBlocks.TRAVEL_MUG.get(), "Travel Coffee Mug");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wild Arabica Coffea Bush");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wild Canephora Coffea Bush");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wild Racemosa Coffea Bush");

        add(ModItems.BAD_COFFEE_BEAN.get(), "Bad Coffee Bean");
        add(ModItems.BOILING_WATER.get(), "Boiling Water");
        add(ModItems.CAPPUCCINO_DRINK.get(), "Cappuccino");
        add(ModItems.CHAMOMILE_TEA_DRINK.get(), "Chamomile Tea");
        add(ModItems.CLAY_MUG.get(), "Clay Mug");
        add(ModItems.COCOA_POWDER.get(), "Cocoa Powder");
        add(ModItems.COFFEE_BEAN.get(), "Coffee Bean");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa Coffea Cherry");
        add(ModItems.COFFEE_DRINK.get(), "Coffee");
        add(ModItems.COFFEE_FILTER.get(), "Coffee Filter");
        add(ModItems.COFFEE_GROUNDS.get(), "Coffee Grounds");
        add(ModItems.DECAF_COFFEE_BEAN.get(), "Decaffeinated Coffee Bean");
        add(ModItems.DECAF_COFFEE_DRINK.get(), "Decaffeinated Coffee");
        add(ModItems.ESPRESSO_DRINK.get(), "Espresso");
        add(ModItems.FINE_COFFEE_GROUNDS.get(), "Fine Coffee Grounds");
        add(ModItems.GREEN_TEA_DRINK.get(), "Green Tea");
        add(ModItems.HOT_CHOCOLATE_DRINK.get(), "Hot Chocolate");
        add(ModItems.LATTE_DRINK.get(), "Latté");
        add(ModItems.MACCHIATO_DRINK.get(), "Macchiato");
        add(ModItems.MILK_FOAM.get(), "Milk Foam");
        add(ModItems.MOCHA_DRINK.get(), "Mocha");
        add(ModItems.STEAMED_MILK.get(), "Steamed Milk");
        add(ModItems.SUN_TEA_DRINK.get(), "Sun Tea");
        add(ModItems.TEA_BAG.get(), "Tea Bag");
        add(ModItems.TEA_LEAF.get(), "Tea Leaf");
        add(ModItems.WHISK.get(), "Whisk");
    }

    private void processENGB() {
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Roaster");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_GRINDING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_GRINDING_TITLE, "Grinding");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_KETTLE_HEATING_TITLE, "Kettle Heating");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_ROASTING_TITLE, "Roasting");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_WHISKING_TITLE, "Whisking");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_DRIP_COFFEE_TITLE, "Drip Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_FRENCHPRESS_COFFEE_TITLE, "French Press Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_PERCOLATOR_COFFEE_TITLE, "Percolator Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_POD_COFFEE_TITLE, "Pod Machine Coffee-making");

        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Coffee Bag (Beans)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Coffee Bag (Ground)");
        add(ModBlocks.COFFEE_CUP.get(), "Coffee Cup");
        add(ModBlocks.COFFEE_ROASTER.get(), "Coffee Roaster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica Coffea Bush");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora Coffea Bush");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa Coffea Bush");
        add(ModBlocks.DISPOSABLE_CUP.get(), "Disposable Cup");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Kiln-fired Coffee Cup");
        add(ModBlocks.FRENCH_PRESS.get(), "French Press");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Hand-crank Burr Coffee Grinder");
        add(ModBlocks.KETTLE.get(), "Kettle");
        add(ModBlocks.PERCOLATOR.get(), "Percolator");
        add(ModBlocks.PINT_MUG.get(), "Pint Mug");
        add(ModBlocks.POD_MACHINE.get(), "Pod Coffee Maker");
        add(ModBlocks.PLATE.get(), "Plate");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Powered Burr Coffee Grinder");
        add(ModBlocks.SUN_TEA_JAR.get(), "Sun Tea Jar");
        add(ModBlocks.TEACUP.get(), "Teacup");
        add(ModBlocks.TRAVEL_MUG.get(), "Travel Coffee Mug");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wild Arabica Coffea Bush");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wild Canephora Coffea Bush");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wild Racemosa Coffea Bush");

        add(ModItems.BAD_COFFEE_BEAN.get(), "Bad Coffee Bean");
        add(ModItems.BOILING_WATER.get(), "Boiling Water");
        add(ModItems.CAPPUCCINO_DRINK.get(), "Cappuccino");
        add(ModItems.CHAMOMILE_TEA_DRINK.get(), "Chamomile Tea");
        add(ModItems.CLAY_MUG.get(), "Clay Mug");
        add(ModItems.COCOA_POWDER.get(), "Cocoa Powder");
        add(ModItems.COFFEE_BEAN.get(), "Coffee Bean");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa Coffea Cherry");
        add(ModItems.COFFEE_DRINK.get(), "Coffee");
        add(ModItems.COFFEE_FILTER.get(), "Coffee Filter");
        add(ModItems.COFFEE_GROUNDS.get(), "Coffee Grounds");
        add(ModItems.DECAF_COFFEE_BEAN.get(), "Decaffeinated Coffee Bean");
        add(ModItems.DECAF_COFFEE_DRINK.get(), "Decaffeinated Coffee");
        add(ModItems.ESPRESSO_DRINK.get(), "Espresso");
        add(ModItems.FINE_COFFEE_GROUNDS.get(), "Fine Coffee Grounds");
        add(ModItems.GREEN_TEA_DRINK.get(), "Green Tea");
        add(ModItems.HOT_CHOCOLATE_DRINK.get(), "Hot Chocolate");
        add(ModItems.LATTE_DRINK.get(), "Latté");
        add(ModItems.MACCHIATO_DRINK.get(), "Macchiato");
        add(ModItems.MILK_FOAM.get(), "Milk Foam");
        add(ModItems.MOCHA_DRINK.get(), "Mocha");
        add(ModItems.STEAMED_MILK.get(), "Steamed Milk");
        add(ModItems.SUN_TEA_DRINK.get(), "Sun Tea");
        add(ModItems.TEA_BAG.get(), "Tea Bag");
        add(ModItems.TEA_LEAF.get(), "Tea Leaf");
        add(ModItems.WHISK.get(), "Whisk");
    }

    private void processDEDE() {
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Machen Sie Ihre erste Tasse Kaffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "Wir machen Kaffee");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Es besteht die Möglichkeit, dass Kaffeesträucher in freier Wildbahn auftauchen");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontale Ausbreitung von Kaffeebüschen");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Roaster");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_DRIP_COFFEE_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_GRINDING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_KETTLE_HEATING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_ROASTING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_TIME_TOOLTIP, "%1$d s");
        add(Constants.TRANSLATION_KEY_GUI_JEI_WHISKING_XP_TOOLTIP, "%f XP");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Heißer Bohnensaft");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_GRINDING_TITLE, "Grinding");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_KETTLE_HEATING_TITLE, "Kettle Heating");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_ROASTING_TITLE, "Roasting");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_WHISKING_TITLE, "Whisking");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_DRIP_COFFEE_TITLE, "Drip Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_FRENCHPRESS_COFFEE_TITLE, "French Press Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_PERCOLATOR_COFFEE_TITLE, "Percolator Coffee-making");
        add(Constants.TRANSLATION_KEY_RECIPETYPE_POD_COFFEE_TITLE, "Pod Machine Coffee-making");

        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Kaffeebeutel (Bohnen)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Kaffeebeutel (gemahlen)");
        add(ModBlocks.COFFEE_CUP.get(), "Kaffeetasse");
        add(ModBlocks.COFFEE_ROASTER.get(), "Kaffeeröster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica-Kaffeestrauch");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora-Kaffeestrauch");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa-Kaffeestrauch");
        add(ModBlocks.DISPOSABLE_CUP.get(), "Disposable Cup");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Ofengebrannte Kaffeetasse");
        add(ModBlocks.FRENCH_PRESS.get(), "French Press");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Kaffeemühle mit Handkurbel");
        add(ModBlocks.KETTLE.get(), "Kettle");
        add(ModBlocks.PERCOLATOR.get(), "Percolator");
        add(ModBlocks.PINT_MUG.get(), "Pint-Becher");
        add(ModBlocks.POD_MACHINE.get(), "Pod Coffee Maker");
        add(ModBlocks.PLATE.get(), "Teller");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Kaffeemühle mit elektrischem Mahlwerk");
        add(ModBlocks.SUN_TEA_JAR.get(), "Sonnenteeglas");
        add(ModBlocks.TEACUP.get(), "Teetasse");
        add(ModBlocks.TRAVEL_MUG.get(), "Reise-Kaffeetasse");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wilder Arabica-Kaffeestrauch");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wilder Canephora-Kaffeestrauch");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wilder Racemosa-Kaffeestrauch");

        add(ModItems.BAD_COFFEE_BEAN.get(), "Schlechte Kaffeebohne");
        add(ModItems.BOILING_WATER.get(), "Kochendes Wasser");
        add(ModItems.CAPPUCCINO_DRINK.get(), "Cappuccino");
        add(ModItems.CHAMOMILE_TEA_DRINK.get(), "Chamomile Tea");
        add(ModItems.CLAY_MUG.get(), "Tonbecher");
        add(ModItems.COCOA_POWDER.get(), "Kakaopulver");
        add(ModItems.COFFEE_BEAN.get(), "Kaffeebohne");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica Kaffeekirsche");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora Kaffeekirsche");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa Kaffeekirsche");
        add(ModItems.COFFEE_DRINK.get(), "Kaffee");
        add(ModItems.COFFEE_FILTER.get(), "Kaffeefilter");
        add(ModItems.COFFEE_GROUNDS.get(), "Kaffeesatz");
        add(ModItems.DECAF_COFFEE_BEAN.get(), "Decaffeinated Coffee Bean");
        add(ModItems.DECAF_COFFEE_DRINK.get(), "Decaffeinated Coffee");
        add(ModItems.ESPRESSO_DRINK.get(), "Espresso");
        add(ModItems.FINE_COFFEE_GROUNDS.get(), "Feiner Kaffeesatz");
        add(ModItems.GREEN_TEA_DRINK.get(), "Green Tea");
        add(ModItems.HOT_CHOCOLATE_DRINK.get(), "Heiße Schokolade");
        add(ModItems.LATTE_DRINK.get(), "Latté");
        add(ModItems.MACCHIATO_DRINK.get(), "Macchiato");
        add(ModItems.MILK_FOAM.get(), "Milchschaum");
        add(ModItems.MOCHA_DRINK.get(), "Mokka");
        add(ModItems.STEAMED_MILK.get(), "Gedämpfte Milch");
        add(ModItems.SUN_TEA_DRINK.get(), "Sun Tea");
        add(ModItems.TEA_BAG.get(), "Tea Bag");
        add(ModItems.TEA_LEAF.get(), "Tea Leaf");
        add(ModItems.WHISK.get(), "Schneebesen");
    }

}
