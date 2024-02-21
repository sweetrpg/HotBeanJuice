package com.sweetrpg.hotbeanjuice.data.builders;

import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.item.crafting.GrindingRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeSerializers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;

public class GrindingRecipeBuilder implements RecipeBuilder {

    private final ItemStack result;
    private final Ingredient ingredient;
    private final float experience;
    private final int grindingTime;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final GrindingRecipe.Serializer serializer;

    private GrindingRecipeBuilder(Ingredient ingredient, ItemStack item, float experience, int grindingTime, GrindingRecipe.Serializer serializer) {
        this.result = item;
        this.ingredient = ingredient;
        this.experience = experience;
        this.grindingTime = grindingTime;
        this.serializer = serializer;
    }

    public static GrindingRecipeBuilder grinding(Ingredient ingredient, ItemStack item, float experience, int grindingTime) {
        return new GrindingRecipeBuilder(ingredient, item, experience, grindingTime, (GrindingRecipe.Serializer) ModRecipeSerializers.GRINDING_SERIALIZER.get());
    }

    @Override
    public RecipeBuilder unlockedBy(String key, CriterionTriggerInstance criterion) {
        this.advancement.addCriterion(key, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
                .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
                .requirements(RequirementsStrategy.OR);
        consumer.accept(new GrindingRecipeBuilder.Result(resourceLocation,
                this.group == null ? "" : this.group, this.ingredient, this.result, this.experience, this.grindingTime, this.advancement, new ResourceLocation(Constants.MOD_ID, "recipes/" + resourceLocation.getPath() + "_grinding"), this.serializer));
    }

    private void ensureValid(ResourceLocation p_126266_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126266_);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient ingredient;
        private final ItemStack result;
        private final float experience;
        private final int grindingTime;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final GrindingRecipe.Serializer serializer;

        public Result(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int grindingTime, Advancement.Builder builder, ResourceLocation advancementId, GrindingRecipe.Serializer serializer) {
            this.id = id;
            this.group = group;
            this.ingredient = ingredient;
            this.result = result;
            this.experience = experience;
            this.grindingTime = grindingTime;
            this.advancement = builder;
            this.advancementId = advancementId;
            this.serializer = serializer;
        }

        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            json.add("ingredient", this.ingredient.toJson());
            json.addProperty("result", ForgeRegistries.ITEMS.getKey(this.result.getItem()).toString());
            json.addProperty("experience", this.experience);
            json.addProperty("grinding_time", this.grindingTime);

        }

        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        public ResourceLocation getId() {
            return this.id;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
