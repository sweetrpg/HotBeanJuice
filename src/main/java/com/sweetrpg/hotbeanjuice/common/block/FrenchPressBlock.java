package com.sweetrpg.hotbeanjuice.common.block;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.entity.FrenchPressBlockEntity;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
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

public class FrenchPressBlock extends AbstractCoffeeMakerBlock {
    public static final BooleanProperty HAS_GROUNDS = BooleanProperty.create("has_grounds");
    public static final BooleanProperty HAS_WATER = BooleanProperty.create("has_water");
    public static final IntegerProperty STRENGTH = IntegerProperty.create("strength", 0, 50);

    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);

    public FrenchPressBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if(hand == InteractionHand.MAIN_HAND) {
            return InteractionResult.PASS;
        }

        ItemStack itemStack = player.getItemInHand(hand);
        BlockEntity blockEntity = level.getBlockEntity(pos);

        // TODO: if the player's hand is empty, press the coffee; the strength of the coffee depends on the amount of time seeping
        if(itemStack.isEmpty()) {
            HotBeanJuice.LOGGER.debug("empty hand to french press");

        }
        // TODO: if the player is holding hot water, fill the press
        else if(itemStack.getItem().equals(ModItems.BOILING_WATER.get())) {
            HotBeanJuice.LOGGER.debug("adding boiling water to french press");

        }
        // TODO: if the player is holding coffee grounds, add them to the press
        else if(itemStack.getItem().equals(ModItems.COFFEE_GROUNDS.get())) {
            HotBeanJuice.LOGGER.debug("adding coffee grounds to french press");

        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        // TODO: store the contents, water level, and seep time
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FrenchPressBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntityTypes.FRENCH_PRESS_BLOCK_ENTITY.get(), FrenchPressBlockEntity::tick);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
//        builder.add(BlockStateProperties.HORIZONTAL_FACING);
        builder.add(HAS_GROUNDS);
        builder.add(HAS_WATER);
        builder.add(STRENGTH);
    }
}
