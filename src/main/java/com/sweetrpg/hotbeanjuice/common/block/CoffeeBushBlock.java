package com.sweetrpg.hotbeanjuice.common.block;

import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import com.sweetrpg.hotbeanjuice.data.CoffeeType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoffeeBushBlock extends CropBlock {

    private final CoffeeType coffeeType;

    public static final IntegerProperty COFFEE_BUSH_AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
    };

    public CoffeeBushBlock(CoffeeType coffeeType, Properties properties) {
        super(properties);
        this.coffeeType = coffeeType;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return COFFEE_BUSH_AGE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return switch(this.coffeeType) {
            case ARABICA -> ModItems.COFFEE_CHERRY_ARABICA.get();
            case CANEPHORA -> ModItems.COFFEE_CHERRY_CANEPHORA.get();
            case RACEMOSA -> ModItems.COFFEE_CHERRY_RACEMOSA.get();
        };
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COFFEE_BUSH_AGE);
    }

    @Override
    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        return true;
    }

    @Override
    public boolean canBeReplaced(BlockState pState, Fluid pFluid) {
        return true;
    }
}
