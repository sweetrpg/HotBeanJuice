package com.sweetrpg.hotbeanjuice.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoffeeCupBlock extends AbstractCoffeeCup {

    protected static final VoxelShape NORTH_SHAPE = Block.box(5.5D, 0.0D, 3.5D, 10.5D, 6.0D, 10.5D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 6.0D, 12.5D);
    protected static final VoxelShape EAST_SHAPE = Block.box(5.5D, 0.0D, 5.5D, 12.5D, 6.0D, 10.5D);
    protected static final VoxelShape WEST_SHAPE = Block.box(3.5D, 0.0D, 5.5D, 10.5D, 6.0D, 10.5D);

    public CoffeeCupBlock() {
        super(Block.Properties.of(Material.CLAY).strength(1.0F, 5.0F).sound(SoundType.STONE));

    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return switch(state.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case UP, DOWN, NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
        };
    }

    @SuppressWarnings("deprecation")
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, rot.rotate(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }


}
