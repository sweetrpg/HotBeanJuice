package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.UUID;

public class HandCoffeeGrinderBlockEntity extends BlockEntity {

    public HandCoffeeGrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntityTypes.HAND_COFFEE_GRINDER.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState blockState, BlockEntity blockEntity) {
        if(!(blockEntity instanceof HandCoffeeGrinderBlockEntity box)) {
            return;
        }
//
//        // Only run update code every 5 ticks (0.25s)
//        if(++box.timeoutCounter < 5) { return; }
//
//        List<CatEntity> catList = box.level.getEntitiesOfClass(CatEntity.class, new AABB(pos).inflate(15, 15, 15));
//
//        for(CatEntity cat : catList) {
//            // TODO: make litterbox remember who placed and only their cats can attach to it
//            UUID placerId = box.getPlacerId();
//            if(placerId != null && placerId.equals(cat.getOwnerUUID()) /* && !cat.getLitterboxPos().isPresent() */) {
//                cat.setLitterboxPos(box.worldPosition);
//            }
//        }
//
//        box.timeoutCounter = 0;
    }
}
