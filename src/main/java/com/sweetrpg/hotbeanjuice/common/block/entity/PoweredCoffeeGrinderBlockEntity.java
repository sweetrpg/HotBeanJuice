package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class PoweredCoffeeGrinderBlockEntity extends AbstractCoffeeGrinderBlockEntity {

    public PoweredCoffeeGrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntityTypes.POWERED_COFFEE_GRINDER.get(), pPos, pBlockState);
    }

}
