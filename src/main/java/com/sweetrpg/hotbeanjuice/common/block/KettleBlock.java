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
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class KettleBlock extends BaseEntityBlock {

    protected static final VoxelShape WEST_SHAPE = Block.box(5.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
    protected static final VoxelShape NORTH_SHAPE = Block.box(4.0D, 0.0D, 5.0D, 12.0D, 8.0D, 12.0D);
    protected static final VoxelShape EAST_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 11.0D, 8.0D, 12.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 11.0D);

    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 4); // holds 4 buckets of water
    public static final BooleanProperty HOT = BooleanProperty.create("is_hot");

    public KettleBlock(Properties properties) {
        super(properties
                .sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HORIZONTAL_FACING, Direction.NORTH)
                .setValue(FULLNESS, 0)
                .setValue(HOT, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, FULLNESS, HOT);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return switch(state.getValue(HORIZONTAL_FACING)) {
            case UP, DOWN, NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
        };
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

                if(!player.getAbilities().instabuild) {
                    player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                }

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

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
