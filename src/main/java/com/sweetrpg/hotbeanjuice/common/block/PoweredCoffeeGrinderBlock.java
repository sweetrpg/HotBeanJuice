package com.sweetrpg.hotbeanjuice.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class PoweredCoffeeGrinderBlock extends Block {

    protected static final VoxelShape SHAPE = Block.box(4D, 0.0D, 4D, 12D, 14.0D, 12D);

    public PoweredCoffeeGrinderBlock() {
        super(Properties.of(Material.BUILDABLE_GLASS).strength(1, 5).sound(SoundType.GLASS));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

//    @Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
//        return new HandCoffeeGrinderBlockEntity(pPos, pState);
//    }
//
//    @Nullable
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
//        return null; // createTickerHelper(blockEntityType, ModBlockEntityTypes.HAND_COFFEE_GRINDER.get(), HandCoffeeGrinderBlockEntity::tick);
//    }

//    @SuppressWarnings("deprecation")
//    @Override
//    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
//        ItemStack stack = player.getItemInHand(handIn);
//
//        if(stack.isEmpty()) {
//            return InteractionResult.PASS;
//        }
//
//        // check if other hand contains coffee beans
//        if(handIn == InteractionHand.MAIN_HAND) {
//            if(!player.getItemInHand(InteractionHand.OFF_HAND).is(ModItems.COFFEE_BEAN.get())) {
//                return InteractionResult.FAIL;
//            }
//        }
//        else if(handIn == InteractionHand.OFF_HAND) {
//            if(!player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.COFFEE_BEAN.get())) {
//                return InteractionResult.FAIL;
//            }
//        }
//
//        // TODO: grind the coffee
//
//        return InteractionResult.SUCCESS;
//    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
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

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRand) {
    }

//    @Override
//    public SoundEvent getEatingSound() {
//        return AllSoundEvents.SANDING_SHORT.getMainEvent();
//    }
//
//    @Override
//    public UseAnim getUseAnimation(ItemStack stack) {
//        return UseAnim.EAT;
//    }
//
//    @Override
//    public int getUseDuration(ItemStack stack) {
//        return 32;
//    }
//
//    @Override
//    public int getEnchantmentValue() {
//        return 1;
//    }

}
