package com.sweetrpg.hotbeanjuice.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoffeeBushBlock extends FlowerBlock {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    private final boolean renderOffset;

    public CoffeeBushBlock(MobEffect suspiciousStewEffect, int effectDuration, Properties properties) {
        super(suspiciousStewEffect, effectDuration, properties);
        this.renderOffset = true;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.is(BlockTags.SAND);
    }

    @Override
    public OffsetType getOffsetType() {
        return renderOffset ? OffsetType.XZ : OffsetType.NONE;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return false;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

}
