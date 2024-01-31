package com.sweetrpg.hotbeanjuice.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoffeeCupBlock extends Block {

    public static final BooleanProperty EMPTY = BooleanProperty.create("empty");

    protected static final VoxelShape NORTH_SOUTH_SHAPE = Block.box(5.0D, 0.0D, 3.0D, 5.0D, 6.0D, 7.0D);
    protected static final VoxelShape EAST_WEST_SHAPE = Block.box(3.0D, 0.0D, 5.0D, 7.0D, 6.0D, 5.0D);

    public CoffeeCupBlock() {
        super(Block.Properties.of(Material.CLAY).strength(1.0F, 5.0F).sound(SoundType.STONE));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(EMPTY, true)
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return switch(state.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case UP, DOWN, NORTH, SOUTH -> NORTH_SOUTH_SHAPE;
            case WEST, EAST -> EAST_WEST_SHAPE;
        };
    }

    @SuppressWarnings("deprecation")
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(handIn);

        if(stack.isEmpty()) {
            return InteractionResult.SUCCESS;
        }

        // TODO: drink the coffee

        return InteractionResult.SUCCESS;
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

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(EMPTY, true)
                .setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING, EMPTY);
    }
}
