package com.sweetrpg.hotbeanjuice.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import com.sweetrpg.hotbeanjuice.common.registry.ModEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.common.Tags;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HBJLootTableProvider extends LootTableProvider {

    public HBJLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    public String getName() {
        return "Hot Bean Juice Loot Tables";
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(Pair.of(Blocks::new, LootContextParamSets.BLOCK), Pair.of(Entities::new, LootContextParamSets.ENTITY));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
    }

    private static class Blocks extends BlockLoot {

        @Override
        protected void addTables() {
            dropWildCoffeeBush();
            dropCoffeeCrop();
            dropsSelf(ModBlocks.COFFEE_BAG_BEANS);
            dropsSelf(ModBlocks.COFFEE_BAG_GROUND);
            dropsSelf(ModBlocks.COFFEE_CUP);
            dropsSelf(ModBlocks.FIRED_COFFEE_CUP);
//            dropsSelf(ModBlocks.DISPOSABLE_CUP);
//            dropsSelf(ModBlocks.TRAVEL_CUP);
            dropsSelf(ModBlocks.HAND_COFFEE_GRINDER);
            dropsSelf(ModBlocks.POWERED_COFFEE_GRINDER);
        }


        private void dropsSelf(Supplier<? extends Block> block) {
            dropSelf(block.get());
        }

        private void dropWildCoffeeBush() {
            LootTable.Builder builder = LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .name("pool1")
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(ModItems.COFFEE_CHERRY.get())
                                    .when(() -> {
                                        return LootItemRandomChanceCondition.randomChance(0.5f).build();
                                    })
                                    .when(() -> {
                                        return MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)).invert().build();
                                    })
                            )
                            .add(LootItem.lootTableItem(ModItems.COFFEE_SEEDS.get())
                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))
                                    .apply(ApplyExplosionDecay.explosionDecay())
                            ))
                    .withPool(LootPool.lootPool()
                            .name("pool2")
                            .setRolls(ConstantValue.exactly(1))
                            .add(AlternativesEntry.alternatives(
                                    LootItem.lootTableItem(ModItems.WILD_COFFEE_BUSH.get())
                                            .when(() -> {
                                                return MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)).build();
                                            })
                                    ,
                                    LootItem.lootTableItem(ModItems.COFFEE_SEEDS.get())
                                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))
                                            .apply(ApplyExplosionDecay.explosionDecay())
                            )));

            this.add(ModBlocks.WILD_COFFEE_BUSH.get(), builder);
        }

        private void dropCoffeeCrop() {
            LootTable.Builder builder = LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .name("pool1")
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(ModItems.COFFEE_CHERRY.get())
                                    .when(() -> {
                                        return LootItemRandomChanceCondition.randomChance(0.5f).build();
                                    })
                                    .when(() -> {
                                        return MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)).invert().build();
                                    })
                            )                     )
                    .withPool(LootPool.lootPool()
                            .name("pool2")
                            .setRolls(ConstantValue.exactly(1))
                            .add(AlternativesEntry.alternatives(
                                    LootItem.lootTableItem(ModItems.COFFEE_CHERRY.get())
                                            .when(() -> {
                                                return MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)).build();
                                            })
                                    ,
                                    LootItem.lootTableItem(ModItems.COFFEE_SEEDS.get())
                                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))
                                            .apply(ApplyExplosionDecay.explosionDecay())
                            )));

            this.add(ModBlocks.COFFEE_BUSH_CROP.get(), builder);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }

    private static class Entities extends EntityLoot {

        @Override
        protected void addTables() {

        }

        protected void registerNoLoot(Supplier<? extends EntityType<?>> type) {
            this.add(type.get(), LootTable.lootTable());
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities() {
            return ModEntityTypes.ENTITIES.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }
}
