package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.KettleBlock;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class KettleBlockEntity extends PlacedBlockEntity {
    private int progress = 0;
    private int maxProgress = 100;

    public KettleBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.KETTLE_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, KettleBlockEntity blockEntity) {
        HotBeanJuice.LOGGER.debug("kettle tick: {}, pos {}, state {}, blockEntity {}", level, pos, state, blockEntity);

        if(level.isClientSide) return;

        if(state.getValue(KettleBlock.HOT)) {
            HotBeanJuice.LOGGER.debug("kettle is already hot");
            return;
        }
        if(state.getValue(KettleBlock.FULLNESS) == 0) {
            HotBeanJuice.LOGGER.debug("kettle has no water");
            blockEntity.progress = 0;
            return;
        }

        if(isOverHeatSource(level, pos)) {
            HotBeanJuice.LOGGER.trace("block below is a heat source");

            // increment progress
            blockEntity.progress++;
            HotBeanJuice.LOGGER.debug("progress: {}", blockEntity.progress);

            // are we hot yet?
            if(blockEntity.progress >= blockEntity.maxProgress) {
                HotBeanJuice.LOGGER.debug("kettle is now hot!");

                state = state.setValue(KettleBlock.HOT, true);
                level.setBlock(pos, state, 3);
            }

            // TODO
        }
    }

    private static boolean isOverHeatSource(Level level, BlockPos pos) {
        HotBeanJuice.LOGGER.debug("#isOverHeatSource: level {}, pos {}", level, pos);

        // check immediately below
        BlockEntity blockBelow = level.getBlockEntity(pos.below());
        HotBeanJuice.LOGGER.trace("blockBelow (1): {}", blockBelow);
        if(blockBelow != null) {
            BlockState blockBelowState = blockBelow.getBlockState();
            HotBeanJuice.LOGGER.trace("blockBelowState: {}", blockBelowState);

            var isCampfire = blockBelowState.getTags()
                    .anyMatch(t -> t.equals(BlockTags.CAMPFIRES));
            if(isCampfire) {
                return blockBelowState.getValue(BlockStateProperties.LIT);
            }

            // check for Farmer's Delight stove
            if(blockBelowState.getBlock().getRegistryName().equals(new ResourceLocation("farmersdelight", "stove"))) {
                return true;
            }

            // check for magma block
            if(blockBelowState.getBlock() instanceof MagmaBlock) {
                return true;
            }

            // check if the block below is a fire source
            if(blockBelowState.isFireSource(level, pos.below(), Direction.UP)) {
                return true;
            }
        }

//        // check two blocks below, e.g., lit netherack
//        blockBelow = level.getBlockEntity(pos.below(2));
//        HotBeanJuice.LOGGER.trace("blockBelow (2): {}", blockBelow);
//        if(blockBelow != null) {
//            BlockState blockBelowState = blockBelow.getBlockState();
//            HotBeanJuice.LOGGER.trace("blockBelowState: {}", blockBelowState);
//
//            var isNetherack = blockBelowState.getTags()
//                    .anyMatch(t -> t.equals(BlockTags.INFINIBURN_NETHER));
//            if(isNetherack) {
//                return blockBelowState.getValue(BlockStateProperties.LIT);
//            }
//        }

        return false;
    }

}
