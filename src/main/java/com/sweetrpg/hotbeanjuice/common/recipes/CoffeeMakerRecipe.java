package com.sweetrpg.hotbeanjuice.common.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMakerRecipe implements Recipe<SimpleContainer> {
    public static final String RECIPE_TYPE_NAME = "coffee_making";

    private final ResourceLocation id;
    private final Item result;
    private final List<Ingredient> ingredients;
    private final float experience;
    private final int processingTime;

    public CoffeeMakerRecipe(ResourceLocation id, Item result, List<Ingredient> ingredients, float experience, int processingTime) {
        this.id = id;
        this.result = result;
        this.ingredients = ingredients;
        this.experience = experience;
        this.processingTime = processingTime;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return TODO ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer container) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return new ItemStack(result);
    }


    public int getProcessingTime() {
        return processingTime;
    }

    public float getExperience() {
        return experience;
    }


    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.addAll(this.ingredients);
        return nonnulllist;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return CoffeeMakerRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return CoffeeMakerRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<CoffeeMakerRecipe> {
        private Type() {
        }

        public static final CoffeeMakerRecipe.Type INSTANCE = new CoffeeMakerRecipe.Type();
        public static final String ID = Constants.MOD_ID + ":" + RECIPE_TYPE_NAME;
    }

    public static class Serializer implements RecipeSerializer<CoffeeMakerRecipe> {
        public static final CoffeeMakerRecipe.Serializer INSTANCE = new CoffeeMakerRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Constants.MOD_ID, RECIPE_TYPE_NAME);

        @Override
        public CoffeeMakerRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = new ItemStack(GsonHelper.getAsItem(json, "result"));

            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredients") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            List<Ingredient> ingredients = new ArrayList<>();
            GsonHelper.getAsJsonArray(json, "ingredients").forEach((element) -> {
                Ingredient ingredient = Ingredient.fromJson(element);
                ingredients.add(ingredient);
            });

            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int processingTime = GsonHelper.getAsInt(json, "processing_time", 100);
            return new CoffeeMakerRecipe(id, result.getItem(), ingredients, experience, processingTime);
        }

        @Override
        public CoffeeMakerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            int ingredientCount = buf.readInt();
            List<Ingredient> ingredients = new ArrayList<>();
            for(int i = 0; i < ingredientCount; i++) {
                Ingredient ingredient = Ingredient.fromNetwork(buf);
                ingredients.add(ingredient);
            }

            ItemStack result = buf.readItem();
            float experience = buf.readFloat();
            int cookingTime = buf.readVarInt();
            return new CoffeeMakerRecipe(id, result.getItem(), ingredients, experience, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CoffeeMakerRecipe recipe) {
            recipe.ingredients.forEach((ingredient) -> ingredient.toNetwork(buf));

            buf.writeItem(recipe.getResultItem());
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.processingTime);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return CoffeeMakerRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }
    }
}
