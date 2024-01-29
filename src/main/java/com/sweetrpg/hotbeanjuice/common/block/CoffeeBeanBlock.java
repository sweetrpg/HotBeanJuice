package com.sweetrpg.hotbeanjuice.common.block;

import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoffeeBeanBlock extends CropBlock {

    public static final IntegerProperty COFFEE_BEAN_AGE = BlockStateProperties.AGE_5;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
//			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
//			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D)
    };

    public CoffeeBeanBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return COFFEE_BEAN_AGE;
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

//	@Override
//	public BlockState getPlant(BlockGetter world, BlockPos pos) {
//		return ModBlocks.CATNIP_CROP.get().defaultBlockState();
//	}

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.COFFEE_SEEDS.get();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COFFEE_BEAN_AGE);
    }

}
