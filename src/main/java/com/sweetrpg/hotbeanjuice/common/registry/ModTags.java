package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.util.Util;
import net.minecraft.tags.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final TagKey<Block> WILD_CROPS = modBlockTag("wild_crops");

    private static TagKey<Item> modItemTag(String name) {
        return ItemTags.create(Util.getResource(name));
    }

    private static TagKey<Block> modBlockTag(String name) {
        return BlockTags.create(Util.getResource(name));
    }

//    private static TagKey<EntityType<?>> tag(String path) {
//        return EntityTypeTags.bind(Util.getResourcePath(path));
//    }
}
