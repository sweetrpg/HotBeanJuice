//package com.sweetrpg.hotbeanjuice.data.builders;
//
//import com.google.common.collect.Lists;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.sweetrpg.hotbeanjuice.common.item.crafting.BrewingSerializer;
//import com.sweetrpg.hotbeanjuice.common.lib.Constants;
//import com.sweetrpg.hotbeanjuice.common.registry.ModRecipeSerializers;
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.AdvancementRewards;
//import net.minecraft.advancements.CriterionTriggerInstance;
//import net.minecraft.advancements.RequirementsStrategy;
//import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
//import net.minecraft.data.recipes.FinishedRecipe;
//import net.minecraft.data.recipes.RecipeBuilder;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import javax.annotation.Nullable;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class TeaRecipeBuilder implements RecipeBuilder {
//
//    private final Item result;
//    private final float experience;
//    private final List<Ingredient> ingredients = Lists.newArrayList();
//    private final int processingTime;
//    private final Advancement.Builder advancement = Advancement.Builder.advancement();
//    @Nullable
//    private String group;
//    private final BrewingSerializer<?> serializer;
//
//    private TeaRecipeBuilder(Item result, float experience, int processingTime, BrewingSerializer<?> serializer) {
//        this.result = result;
//        this.experience = experience;
//        this.processingTime = processingTime;
//        this.serializer = serializer;
//    }
//
//    public static TeaRecipeBuilder brewed(Item item, float experience, int brewingTime) {
//        return new TeaRecipeBuilder(item, experience, brewingTime, ModRecipeSerializers.BREWED_TEA_RECIPE.get());
//    }
//
//    public static TeaRecipeBuilder seeped(Item item, float experience, int brewingTime) {
//        return new TeaRecipeBuilder(item, experience, brewingTime, ModRecipeSerializers.SEEPED_TEA_RECIPE.get());
//    }
//
//    public TeaRecipeBuilder requires(Ingredient pIngredient) {
//        return this.requires(pIngredient, 1);
//    }
//
//    /**
//     * Adds an ingredient multiple times.
//     */
//    public TeaRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
//        for(int i = 0; i < pQuantity; ++i) {
//            this.ingredients.add(pIngredient);
//        }
//
//        return this;
//    }
//
//    @Override
//    public TeaRecipeBuilder unlockedBy(String key, CriterionTriggerInstance criterion) {
//        this.advancement.addCriterion(key, criterion);
//        return this;
//    }
//
//    @Override
//    public TeaRecipeBuilder group(@Nullable String group) {
//        this.group = group;
//        return this;
//    }
//
//    @Override
//    public Item getResult() {
//        return result;
//    }
//
//    @Override
//    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
//        this.ensureValid(resourceLocation);
//
//        this.advancement.parent(new ResourceLocation("recipes/root"))
//                .addCriterion(Constants.RECIPE_SERIALIZER_CRITERION_HAS_RECIPE, RecipeUnlockedTrigger.unlocked(resourceLocation))
//                .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
//                .requirements(RequirementsStrategy.OR);
//
//        String newPath = resourceLocation.getPath();
//        if(!this.serializer.suffix.isEmpty()) {
//            newPath += "_" + this.serializer.suffix + "_brewed";
//        }
//        ResourceLocation resLoc = new ResourceLocation(resourceLocation.getNamespace(), newPath);
//        consumer.accept(new CoffeeMakerRecipeBuilder.Result(resLoc,
//                this.group == null ? "" : this.group,
//                this.ingredients,
//                this.result,
//                this.experience,
//                this.processingTime,
//                this.advancement,
//                new ResourceLocation(Constants.MOD_ID, "recipes/" + newPath),
//                this.serializer));
//    }
//
//    private void ensureValid(ResourceLocation resourceLocation) {
//        if(this.advancement.getCriteria().isEmpty()) {
//            throw new IllegalStateException("No way of obtaining recipe " + resourceLocation);
//        }
//    }
//
//    public static class Result implements FinishedRecipe {
//        private final ResourceLocation id;
//        private final String group;
//        private final Item result;
//        private final List<Ingredient> ingredients;
//        private final float experience;
//        private final int processingTime;
//        private final Advancement.Builder advancement;
//        private final ResourceLocation advancementId;
//        private final BrewingSerializer<?> serializer;
//
//        public Result(ResourceLocation id, String group, List<Ingredient> ingredients, Item result, float experience, int processingTime, Advancement.Builder builder, ResourceLocation advancementId, BrewingSerializer<?> serializer) {
//            this.id = id;
//            this.group = group;
//            this.result = result;
//            this.ingredients = ingredients;
//            this.experience = experience;
//            this.processingTime = processingTime;
//            this.advancement = builder;
//            this.advancementId = advancementId;
//            this.serializer = serializer;
//        }
//
//        public void serializeRecipeData(JsonObject json) {
//            if(!this.group.isEmpty()) {
//                json.addProperty(Constants.RECIPE_SERIALIZER_DATA_GROUP, this.group);
//            }
//
//            json.add(Constants.RECIPE_SERIALIZER_DATA_INGREDIENTS, JsonUtil.arrayFrom(this.ingredients));
//
//            json.addProperty(Constants.RECIPE_SERIALIZER_DATA_RESULT, ForgeRegistries.ITEMS.getKey(this.result).toString());
//            json.addProperty(Constants.RECIPE_SERIALIZER_DATA_EXPERIENCE, this.experience);
//            json.addProperty(Constants.RECIPE_SERIALIZER_DATA_PROCESSING_TIME, this.processingTime);
//        }
//
//        public RecipeSerializer<?> getType() {
//            return this.serializer;
//        }
//
//        public ResourceLocation getId() {
//            return this.id;
//        }
//
//        @Nullable
//        public JsonObject serializeAdvancement() {
//            return this.advancement.serializeToJson();
//        }
//
//        @Nullable
//        public ResourceLocation getAdvancementId() {
//            return this.advancementId;
//        }
//    }
//}
