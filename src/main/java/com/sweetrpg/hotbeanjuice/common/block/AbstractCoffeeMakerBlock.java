package com.sweetrpg.hotbeanjuice.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public abstract class AbstractCoffeeMakerBlock extends BaseEntityBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 4);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED; //by carafe
    public static final BooleanProperty HOT = BooleanProperty.create("is_hot");

    protected AbstractCoffeeMakerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HORIZONTAL_FACING, Direction.NORTH)
                .setValue(HOT, Boolean.FALSE)
                .setValue(LIT, Boolean.FALSE)
                .setValue(OCCUPIED, Boolean.TRUE)
                .setValue(FULLNESS, 0));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, HOT, LIT, OCCUPIED, FULLNESS);
    }

//    @Override
//    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
//        if (state.getBlock() != newState.getBlock()) {
//            BlockEntity blockEntity = level.getBlockEntity(pos);
//            if (blockEntity instanceof AbstractCoffeeMakerBlockEntity) {
//                ((AbstractCoffeeMakerBlockEntity) blockEntity).drops();
//            }
//        }
//        super.onRemove(state, level, pos, newState, isMoving);
//    }

//    public abstract @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit);

//    public abstract void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player);

}
