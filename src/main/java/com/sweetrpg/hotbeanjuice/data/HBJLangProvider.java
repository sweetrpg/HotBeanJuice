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
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Roaster");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Coffee Bag (Beans)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Coffee Bag (Ground)");
        add(ModBlocks.COFFEE_ROASTER.get(), "Coffee Roaster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica Coffea Bush");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora Coffea Bush");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa Coffea Bush");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.DRIP_COFFEE_MACHINE.get(), "Drip Coffee Maker");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Kiln-fired Coffee Cup");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Hand-crank Burr Coffee Grinder");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Powered Burr Coffee Grinder");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wild Arabica Coffea Bush");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wild Canephora Coffea Bush");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wild Racemosa Coffea Bush");
        add(ModItems.BAD_COFFEE_BEAN.get(), "Bad Coffee Bean");
        add(ModItems.CLAY_MUG.get(), "Clay Mug");
        add(ModItems.COFFEE_BEAN.get(), "Coffee Bean");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa Coffea Cherry");
        add(ModItems.COFFEE_FILTER.get(), "Coffee Filter");
        add(ModItems.COFFEE_GROUNDS.get(), "Coffee Grounds");
//        add(ModBlocks.DISPOSABLE_CUP.get(), "Disposable Cup");
//        add(ModBlocks.TRAVEL_CUP.get(), "Travel Cup");
    }

    private void processENGB() {
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Make your first cup of coffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "We're Makin' Coffee");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Chance that coffee bushes appear in the wild");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontal spread of patches of coffee bushes");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Roaster");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Hot Bean Juice");
        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Coffee Bag (Beans)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Coffee Bag (Ground)");
        add(ModBlocks.COFFEE_ROASTER.get(), "Coffee Roaster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica Coffea Bush");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora Coffea Bush");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa Coffea Bush");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Drip Coffee Carafe");
        add(ModBlocks.DRIP_COFFEE_MACHINE.get(), "Drip Coffee Maker");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Kiln-fired Coffee Cup");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Hand-crank Burr Coffee Grinder");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Powered Burr Coffee Grinder");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wild Arabica Coffea Bush");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wild Canephora Coffea Bush");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wild Racemosa Coffea Bush");
        add(ModItems.BAD_COFFEE_BEAN.get(), "Bad Coffee Bean");
        add(ModItems.CLAY_MUG.get(), "Clay Mug");
        add(ModItems.COFFEE_BEAN.get(), "Coffee Bean");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora Coffea Cherry");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa Coffea Cherry");
        add(ModItems.COFFEE_FILTER.get(), "Coffee Filter");
        add(ModItems.COFFEE_GROUNDS.get(), "Coffee Grounds");
//        add(ModBlocks.DISPOSABLE_CUP.get(), "Disposable Cup");
//        add(ModBlocks.TRAVEL_CUP.get(), "Travel Cup");
    }

    private void processDEDE() {
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_DESCRIPTION, "Machen Sie Ihre erste Tasse Kaffee");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_MAKE_COFFEE_TITLE, "Wir machen Kaffee");
        add(Constants.TRANSLATION_KEY_BLOCK_WILD_COFFEE_BUSH_TITLE, "Kaffeebusch");
        add(Constants.TRANSLATION_KEY_COFFEE_CUP_BLOCK_TITLE, "Kaffeetasse");
        add(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH, "Es besteht die Möglichkeit, dass Kaffeesträucher in freier Wildbahn auftauchen");
        add(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD, "Horizontale Ausbreitung von Kaffeebüschen");
        add(Constants.TRANSLATION_KEY_GUI_COFFEE_ROASTER_TITLE, "Röster");
        add(Constants.TRANSLATION_KEY_ITEMGROUP_GENERAL_TITLE, "Heißer Bohnensaft");
        add(ModBlocks.COFFEE_BAG_BEANS.get(), "Kaffeebeutel (Bohnen)");
        add(ModBlocks.COFFEE_BAG_GROUND.get(), "Kaffeebeutel (gemahlen)");
        add(ModBlocks.COFFEE_ROASTER.get(), "Kaffeeröster");
        add(ModBlocks.CROP_COFFEE_ARABICA.get(), "Arabica-Kaffeestrauch");
        add(ModBlocks.CROP_COFFEE_CANEPHORA.get(), "Canephora-Kaffeestrauch");
        add(ModBlocks.CROP_COFFEE_RACEMOSA.get(), "Racemosa-Kaffeestrauch");
        add(ModBlocks.DRIP_COFFEE_CARAFE.get(), "Tropfkaffeekaraffe");
        add(ModBlocks.DRIP_COFFEE_MACHINE.get(), "Filterkaffeemaschine");
        add(ModBlocks.FIRED_COFFEE_CUP.get(), "Im Ofen gebrannte Kaffeetasse");
        add(ModBlocks.HAND_COFFEE_GRINDER.get(), "Kaffeemühle mit Handkurbel");
        add(ModBlocks.POWERED_COFFEE_GRINDER.get(), "Angetriebene Kaffeemühle mit Mahlwerk");
        add(ModBlocks.WILD_COFFEA_ARABICA.get(), "Wilder Arabica-Kaffeestrauch");
        add(ModBlocks.WILD_COFFEA_CANEPHORA.get(), "Wilder Canephora-Kaffeestrauch");
        add(ModBlocks.WILD_COFFEA_RACEMOSA.get(), "Wilder Racemosa-Kaffeestrauch");
        add(ModItems.CLAY_MUG.get(), "Tonbecher");
        add(ModItems.COFFEE_BEAN.get(), "Kaffeebohne");
        add(ModItems.COFFEE_CHERRY_ARABICA.get(), "Arabica-Kaffeekirsche");
        add(ModItems.COFFEE_CHERRY_CANEPHORA.get(), "Canephora-Kaffeekirsche");
        add(ModItems.COFFEE_CHERRY_RACEMOSA.get(), "Racemosa-Kaffeekirsche");
        add(ModItems.COFFEE_FILTER.get(), "Kaffeefilter");
        add(ModItems.COFFEE_GROUNDS.get(), "Kaffeesatz");
        add(ModItems.BAD_COFFEE_BEAN.get(), "Schlechte Kaffeebohne");
//        add(ModBlocks.DISPOSABLE_CUP.get(),"Einwegbecher");
//        add(ModBlocks.TRAVEL_CUP.get(), "Reisebecher");
    }

}
