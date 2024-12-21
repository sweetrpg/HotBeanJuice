package com.sweetrpg.hotbeanjuice.common.block;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.entity.KettleBlockEntity;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class KettleBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 4); // holds 4 buckets of water
    public static final BooleanProperty HOT = BooleanProperty.create("is_hot");

    public KettleBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(FULLNESS, 0)
                .setValue(HOT, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FULLNESS, HOT);
    }

    @Override
    public VoxelShape getVisualShape(BlockState pState, BlockGetter pReader, BlockPos pPos, CollisionContext pContext) {
        return this.getShape(pState, pReader, pPos, pContext);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        HotBeanJuice.LOGGER.debug("use kettle: {}, level {}, pos {}, player {}, hand {}, hit {}", state, level, pos, player, hand, hit);

        ItemStack stack = player.getItemInHand(hand);

        // with an empty bucket, get boiling water
        if(hand == InteractionHand.MAIN_HAND &&
                stack.is(Items.BUCKET) &&
                state.getValue(FULLNESS) > 0 &&
                state.getValue(HOT) &&
                !level.isClientSide) {
            var fullness = state.getValue(FULLNESS) - 1;
            state = state.setValue(FULLNESS, fullness);
            if(fullness <= 0) {
                state = state.setValue(HOT, false);
            }
            level.setBlock(pos, state, 3);
            player.setItemInHand(hand, new ItemStack(ModItems.BOILING_WATER.get()));
            return InteractionResult.SUCCESS;
        }
        // with a water bucket, fill kettle
        if(hand == InteractionHand.MAIN_HAND &&
                stack.is(Items.WATER_BUCKET) &&
                !level.isClientSide) {
            var fullness = state.getValue(FULLNESS) + 1;
            if(KettleBlock.FULLNESS.getPossibleValues().contains(fullness)) {
                state = state.setValue(FULLNESS, fullness);
                level.setBlock(pos, state, 3);
                player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    // TODO: can be placed over a fire or other heat source to heat the water

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KettleBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntityTypes.KETTLE_BLOCK_ENTITY.get(), KettleBlockEntity::tick);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        if(level == null) return;

        // add tooltip text for fullness

        var text = I18n.get(Constants.TRANSLATION_KEY_GUI_KETTLE_FULLNESS, 0);
//        tooltip.add(new TranslatableComponent(Constants.TRANSLATION_KEY_GUI_KETTLE_FULLNESS, )

        // add tooltip text if the kettle is hot
    }


}
