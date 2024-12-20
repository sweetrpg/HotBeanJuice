package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class KettleBlockEntity extends PlacedBlockEntity {

    public KettleBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.KETTLE_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, KettleBlockEntity blockEntity) {
        HotBeanJuice.LOGGER.debug("kettle tick: {}, pos {}, state {}, blockEntity {}", level, pos, state, blockEntity);

        // TODO
    }

}
