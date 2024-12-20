package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class KettleBlockEntity extends PlacedBlockEntity {

    public KettleBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.KETTLE_BLOCK_ENTITY.get(), pos, blockState);
    }

}
