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
                .add(ModBlocks.COFFEE_BUSH_CROP.get());
    }

    protected void registerForgeTags() {

    }

    protected void registerModTags() {
        tag(ModTags.WILD_CROPS)
                .add(ModBlocks.WILD_COFFEE_BUSH.get());
        tag(ModTags.COFFEE_CUPS)
                .add(ModBlocks.COFFEE_CUP.get())
                .add(ModBlocks.TRAVEL_CUP.get())
                .add(ModBlocks.DISPOSABLE_CUP.get());
    }

}
