package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.util.Util;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    // ----------------------------------------------------------------------------------------------------------------
    // Block tags

    public static final TagKey<Block> WILD_CROPS = modBlockTag("wild_crops");
    public static final TagKey<Block> COFFEE_CUPS = modBlockTag("coffee_cups");
    public static final TagKey<Block> BAGS_OF_COFFEE = modBlockTag("bags_of_coffee");
    public static final TagKey<Block> COFFEE_GRINDERS = modBlockTag("coffee_grinders");
    public static final TagKey<Block> COFFEE_ITEMS = modBlockTag("coffee_items");
    public static final TagKey<Block> TEA_MAKING_DEVICES = modBlockTag("tea_making_devices");
    public static final TagKey<Block> COFFEE_MAKING_DEVICES = modBlockTag("coffee_making_devices");
    public static final TagKey<Block> COFFEE_PROCESSING_DEVICES = modBlockTag("coffee_processing_devices");
    public static final TagKey<Block> MISCELLANEOUS_INGREDIENTS = modBlockTag("miscellaneous_ingredients");

    public static final TagKey<Block> KITCHENWARE = modBlockTag("kitchenware");

    // ----------------------------------------------------------------------------------------------------------------
    // Item tags

    public static final TagKey<Item> COFFEE_CHERRIES = modItemTag("coffee_cherries");
    public static final TagKey<Item> STRIPPED_WOOD = modItemTag("stripped_wood");
    public static final TagKey<Item> KITCHEN_UTENSILS = modItemTag("kitchen_utensils");
    public static final TagKey<Item> COFFEE_DRINKS = modItemTag("coffee_drinks");
    public static final TagKey<Item> TEA_DRINKS = modItemTag("tea_drinks");
    public static final TagKey<Item> COCOA_DRINKS = modItemTag("cocoa_drinks");

    // ----------------------------------------------------------------------------------------------------------------

    private static TagKey<Item> modItemTag(String name) {
        return ItemTags.create(Util.getResource(name));
    }

    private static TagKey<Block> modBlockTag(String name) {
        return BlockTags.create(Util.getResource(name));
    }

}
