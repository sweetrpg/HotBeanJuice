package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class HBJItemModelProvider extends ItemModelProvider {

    public HBJItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Hot Bean Juice - Item Models";
    }

    @Override
    protected void registerModels() {
        // Blocks
        blockItem(ModBlocks.WILD_COFFEA_ARABICA);
        blockItem(ModBlocks.WILD_COFFEA_CANEPHORA);
        blockItem(ModBlocks.WILD_COFFEA_RACEMOSA);

        blockItem(ModBlocks.COFFEE_BAG_BEANS);
        blockItem(ModBlocks.COFFEE_BAG_GROUND);
        blockItem(ModBlocks.DRIP_COFFEE_CARAFE);
        blockItem(ModBlocks.KETTLE);
        blockItem(ModBlocks.SUN_TEA_JAR);
        blockItem(ModBlocks.DRIP_COFFEE_MACHINE);
        blockItem(ModBlocks.PERCOLATOR);
        blockItem(ModBlocks.POD_MACHINE);
        blockItem(ModBlocks.FRENCH_PRESS);
        blockItem(ModBlocks.HAND_COFFEE_GRINDER);
        blockItem(ModBlocks.POWERED_COFFEE_GRINDER);
        blockItem(ModBlocks.COFFEE_ROASTER);
        blockItem(ModBlocks.COFFEE_CUP);
        blockItem(ModBlocks.FIRED_COFFEE_CUP);
        blockItem(ModBlocks.DISPOSABLE_CUP);
        blockItem(ModBlocks.TRAVEL_MUG);
        blockItem(ModBlocks.TEACUP);
        generated(ModBlocks.PLATE);
        blockItem(ModBlocks.PINT_MUG);

        // Items
        generated(ModItems.COFFEE_CHERRY_ARABICA);
        generated(ModItems.COFFEE_CHERRY_CANEPHORA);
        generated(ModItems.COFFEE_CHERRY_RACEMOSA);
        generated(ModItems.COFFEE_BEAN);
        generated(ModItems.BAD_COFFEE_BEAN);
        generated(ModItems.DECAF_COFFEE_BEAN);
        generated(ModItems.COFFEE_GROUNDS);
        generated(ModItems.FINE_COFFEE_GROUNDS);
        generated(ModItems.TEA_LEAF);
        generated(ModItems.COFFEE_DRINK);
        generated(ModItems.DECAF_COFFEE_DRINK);
        generated(ModItems.ESPRESSO_DRINK);
        generated(ModItems.CAPPUCCINO_DRINK);
        generated(ModItems.MOCHA_DRINK);
        generated(ModItems.LATTE_DRINK);
        generated(ModItems.MACCHIATO_DRINK);
        generated(ModItems.CHAMOMILE_TEA_DRINK);
        generated(ModItems.GREEN_TEA_DRINK);
        generated(ModItems.SUN_TEA_DRINK);
        generated(ModItems.HOT_CHOCOLATE_DRINK);
        generated(ModItems.TEA_BAG);
        generated(ModItems.COFFEE_FILTER);
        generated(ModItems.CLAY_MUG);
        generated(ModItems.WHISK);
        generated(ModItems.COCOA_POWDER);
        generated(ModItems.STEAMED_MILK);
        generated(ModItems.BOILING_WATER);
        generated(ModItems.MILK_FOAM);
    }

    private ResourceLocation itemTexture(Supplier<? extends ItemLike> item) {
        return modLoc(ModelProvider.ITEM_FOLDER + "/" + name(item));
    }

    private String name(Supplier<? extends ItemLike> item) {
        return item.get().asItem().getRegistryName().getPath();
    }

    private ItemModelBuilder blockItem(Supplier<? extends Block> block) {
        return blockItem(block, "");
    }

    private ItemModelBuilder generated(Supplier<? extends ItemLike> item) {
        return generated(item, itemTexture(item));
    }

    private ItemModelBuilder generated(Supplier<? extends ItemLike> item, ResourceLocation texture) {
        return getBuilder(name(item)).parent(new UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated")).texture("layer0", texture);
    }

    private ItemModelBuilder handheld(Supplier<? extends ItemLike> item) {
        return handheld(item, itemTexture(item));
    }

    private ItemModelBuilder handheld(Supplier<? extends ItemLike> item, ResourceLocation texture) {
        return getBuilder(name(item)).parent(new UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/handheld")).texture("layer0", texture);
    }

    private ItemModelBuilder blockItem(Supplier<? extends Block> block, String suffix) {
        return withExistingParent(name(block), modLoc(ModelProvider.BLOCK_FOLDER + "/" + name(block) + suffix));
    }
}
