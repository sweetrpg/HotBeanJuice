package com.sweetrpg.hotbeanjuice.common.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class CoffeeBagBlock extends Block {

    protected static final VoxelShape NORTH_SOUTH_SHAPE = Block.box(4.0D, 0.0D, 5.0D, 12.0D, 13.0D, 11.0D);
    protected static final VoxelShape EAST_WEST_SHAPE = Block.box(5.0D, 0.0D, 4.0D, 11.0D, 13.0D, 12.0D);
    protected static final VoxelShape NORTH_SOUTH_SHORT_SHAPE = Block.box(4.0D, 0.0D, 5.0D, 12.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_WEST_SHORT_SHAPE = Block.box(5.0D, 0.0D, 4.0D, 11.0D, 11.0D, 12.0D);

    private final boolean shortBag;

    public CoffeeBagBlock(boolean shortBag, Properties props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
        this.shortBag = shortBag;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return switch(state.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case UP, DOWN, NORTH, SOUTH -> shortBag ? NORTH_SOUTH_SHORT_SHAPE : NORTH_SOUTH_SHAPE;
            case WEST, EAST -> shortBag ? EAST_WEST_SHORT_SHAPE : EAST_WEST_SHAPE;
        };
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, rot.rotate(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }
}
