package com.sweetrpg.hotbeanjuice.data;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Arrays;
import java.util.function.Supplier;

public class HBJItemTagsProvider extends ItemTagsProvider {

    public HBJItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagProvider, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Hot Bean Juice Item Tags";
    }

    @Override
    public void addTags() {
//        tag(ModTags.COFFEE_CHERRIES)
//                .add(ModItems.COFFEE_CHERRY_ARABICA.get())
//                .add(ModItems.COFFEE_CHERRY_CANEPHORA.get())
//                .add(ModItems.COFFEE_CHERRY_RACEMOSA.get());
//        tag(ModTags.STRIPPED_WOOD)
//                .add(Items.STRIPPED_OAK_WOOD)
//                .add(Items.STRIPPED_ACACIA_WOOD)
//                .add(Items.STRIPPED_BIRCH_WOOD)
//                .add(Items.STRIPPED_DARK_OAK_WOOD)
//                .add(Items.STRIPPED_JUNGLE_WOOD)
//                .add(Items.STRIPPED_SPRUCE_WOOD);
    }

    @SafeVarargs
    private final void createTag(TagKey<Item> tag, Supplier<? extends ItemLike>... items) {
        tag(tag).add(Arrays.stream(items).map(Supplier::get).map(ItemLike::asItem).toArray(Item[]::new));
    }

    @SafeVarargs
    private final void appendToTag(TagKey<Item> tag, TagKey<Item>... toAppend) {
        tag(tag).addTags(toAppend);
    }
}
