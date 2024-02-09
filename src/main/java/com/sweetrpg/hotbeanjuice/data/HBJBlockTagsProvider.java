package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class HBJBlockTagsProvider extends BlockTagsProvider {

    public HBJBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Hot Bean Juice Block Tags";
    }

    @Override
    protected void addTags() {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerForgeTags();

        this.registerBlockMineables();
    }

    protected void registerBlockMineables() {

    }

    protected void registerMinecraftTags() {
//        tag(net.minecraft.tags.BlockTags.SMALL_FLOWERS)
//                .add(ModBlocks.WILD_CATNIP.get());
        tag(net.minecraft.tags.BlockTags.CROPS)
                .add(ModBlocks.CROP_COFFEE_ARABICA.get())
                .add(ModBlocks.CROP_COFFEE_CANEPHORA.get())
                .add(ModBlocks.CROP_COFFEE_RACEMOSA.get());
    }

    protected void registerForgeTags() {

    }

    protected void registerModTags() {
        tag(ModTags.WILD_CROPS)
                .add(ModBlocks.WILD_COFFEA_ARABICA.get())
                .add(ModBlocks.WILD_COFFEA_CANEPHORA.get())
                .add(ModBlocks.WILD_COFFEA_RACEMOSA.get());
        tag(ModTags.COFFEE_CUPS)
                .add(ModBlocks.COFFEE_CUP.get())
                /*.add(ModBlocks.TRAVEL_CUP.get())
                .add(ModBlocks.DISPOSABLE_CUP.get())*/;
//        tag(ModTags.WILD_CROPS)
//                .add(ModBlocks.WILD_CATNIP.get());
        tag(ModTags.BAGS_OF_COFFEE)
                .add(ModBlocks.COFFEE_BAG_BEANS.get())
                .add(ModBlocks.COFFEE_BAG_GROUND.get());
        tag(ModTags.COFFEE_GRINDERS)
                .add(ModBlocks.HAND_COFFEE_GRINDER.get());
    }

}
