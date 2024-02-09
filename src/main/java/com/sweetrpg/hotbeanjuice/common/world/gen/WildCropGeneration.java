package com.sweetrpg.hotbeanjuice.common.world.gen;

import com.sweetrpg.hotbeanjuice.common.config.ConfigHandler;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.Arrays;
import java.util.List;

public class WildCropGeneration {

    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_PATCH_WILD_COFFEA_ARABICA;
    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_PATCH_WILD_COFFEA_CANEPHORA;
    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_PATCH_WILD_COFFEA_RACEMOSA;
    public static Holder<PlacedFeature> PATCH_WILD_COFFEA_ARABICA;
    public static Holder<PlacedFeature> PATCH_WILD_COFFEA_CANEPHORA;
    public static Holder<PlacedFeature> PATCH_WILD_COFFEA_RACEMOSA;

    public static RandomPatchConfiguration getWildCropConfiguration(Block block, int tries, int xzSpread, int ySpread, BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn)));
    }

    static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
    }

    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(ResourceLocation id, F feature, FC featureConfig) {
        return register(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, featureConfig));
    }

    private static <V extends T, T> Holder<V> register(Registry<T> registry, ResourceLocation id, V value) {
        return (Holder<V>) BuiltinRegistries.<T>register(registry, id, value);
    }

    public static void registerWildCropGeneration() {
        // Arabica
        FEATURE_PATCH_WILD_COFFEA_ARABICA = register(Util.modLoc("patch_wild_coffea_arabica"),
                Feature.RANDOM_PATCH,
                getWildCropConfiguration(ModBlocks.WILD_COFFEA_ARABICA.get(),
                        64, ConfigHandler.SERVER.COFFEE_BUSH_SPREAD.get(), 3,
                        BlockPredicate.matchesBlocks(Arrays.asList(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL), BLOCK_BELOW)));

        PATCH_WILD_COFFEA_ARABICA = registerPlacement(Util.modLoc("patch_wild_coffea_arabica"),
                FEATURE_PATCH_WILD_COFFEA_ARABICA,
                RarityFilter.onAverageOnceEvery(ConfigHandler.SERVER.CHANCE_COFFEE_BUSH.get()),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());

        // Canephora
        FEATURE_PATCH_WILD_COFFEA_CANEPHORA = register(Util.modLoc("patch_wild_coffea_canephora"),
                Feature.RANDOM_PATCH,
                getWildCropConfiguration(ModBlocks.WILD_COFFEA_CANEPHORA.get(),
                        64, ConfigHandler.SERVER.COFFEE_BUSH_SPREAD.get(), 3,
                        BlockPredicate.matchesBlocks(Arrays.asList(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL), BLOCK_BELOW)));

        PATCH_WILD_COFFEA_CANEPHORA = registerPlacement(Util.modLoc("patch_wild_coffea_canephora"),
                FEATURE_PATCH_WILD_COFFEA_CANEPHORA,
                RarityFilter.onAverageOnceEvery(ConfigHandler.SERVER.CHANCE_COFFEE_BUSH.get()),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());

        // Racemosa
        FEATURE_PATCH_WILD_COFFEA_RACEMOSA = register(Util.modLoc("patch_wild_coffea_racemosa"),
                Feature.RANDOM_PATCH,
                getWildCropConfiguration(ModBlocks.WILD_COFFEA_RACEMOSA.get(),
                        64, ConfigHandler.SERVER.COFFEE_BUSH_SPREAD.get(), 3,
                        BlockPredicate.matchesBlocks(Arrays.asList(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL), BLOCK_BELOW)));

        PATCH_WILD_COFFEA_RACEMOSA = registerPlacement(Util.modLoc("patch_wild_coffea_racemosa"),
                FEATURE_PATCH_WILD_COFFEA_RACEMOSA,
                RarityFilter.onAverageOnceEvery(ConfigHandler.SERVER.CHANCE_COFFEE_BUSH.get()),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());
    }

}
