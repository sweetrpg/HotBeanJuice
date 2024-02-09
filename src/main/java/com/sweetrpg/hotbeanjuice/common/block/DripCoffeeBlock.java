package com.sweetrpg.hotbeanjuice.common.block;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.block.entity.AbstractPoweredCoffeeMakerBlockEntity;
import com.sweetrpg.hotbeanjuice.common.block.entity.DripCoffeeBlockEntity;
import com.sweetrpg.hotbeanjuice.common.item.CarafeItem;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class DripCoffeeBlock extends AbstractPoweredCoffeeMakerBlock {
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED; //by carafe

    public DripCoffeeBlock(Properties properties) {
        super(properties);
    }

    //TODO update block hitbox?
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (player.isSecondaryUseActive()) {
            HotBeanJuice.LOGGER.debug("Occupied: " + state.getValue(OCCUPIED));
            if (state.getValue(OCCUPIED)) {
                state = state.setValue(OCCUPIED, false).setValue(FULLNESS, 0);
                if (blockEntity instanceof DripCoffeeBlockEntity dripCoffeeBlockEntity) {
                    dripCoffeeBlockEntity.emptyCoffee();
                }
                //TODO transfer fluid capability/contents to carafe item
                player.addItem(new ItemStack(ModItems.DRIP_COFFEE_CARAFE.get(), 1));
                level.setBlock(pos, state, 3);
            }
        } else if (itemStack.is(ModItems.DRIP_COFFEE_CARAFE.get()) && !state.getValue(OCCUPIED)) {
            if (itemStack.is(ModItems.DRIP_COFFEE_CARAFE.get())) {
                itemStack.shrink(1);
                state = state.setValue(OCCUPIED, true);
                level.setBlock(pos, state, 3);
                //TODO transfer contents of carafe item to pot
            }
        } else if (itemStack.is(Items.WATER_BUCKET) && blockEntity instanceof DripCoffeeBlockEntity dripCoffeeBlockEntity) {
            if (AbstractPoweredCoffeeMakerBlockEntity.hasRoomForWater(dripCoffeeBlockEntity)) {
                dripCoffeeBlockEntity.addWater(1000);
                itemStack.shrink(1);
                player.addItem(new ItemStack(Items.BUCKET, 1));
            }
        } else {
                if (!level.isClientSide()) {
                    BlockEntity entity = level.getBlockEntity(pos);
                    if (entity instanceof DripCoffeeBlockEntity) {
                        NetworkHooks.openGui(((ServerPlayer) player), (DripCoffeeBlockEntity) entity, pos);
                    } else {
                        throw new IllegalStateException("Our Container provider is missing!");
                    }
                }

        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(OCCUPIED)) {
            state.setValue(OCCUPIED, false);
            state.setValue(FULLNESS, 0);
            //TODO transfer fluid capability/contents to carafe item
            ItemStack itemStack = new ItemStack(ModItems.DRIP_COFFEE_CARAFE.get(), 1);
            ItemEntity itemEntity = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, itemStack);
            itemEntity.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity);
        }
    }

    @javax.annotation.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DripCoffeeBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntityTypes.DRIP_COFFEE_BLOCK_ENTITY.get(), DripCoffeeBlockEntity::tick);
    }
}
