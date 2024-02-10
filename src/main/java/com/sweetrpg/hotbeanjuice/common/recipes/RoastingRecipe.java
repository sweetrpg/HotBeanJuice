package com.sweetrpg.hotbeanjuice.common.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class RoastingRecipe implements Recipe<SimpleContainer> {

    public static final String RECIPE_TYPE_NAME = "roasting";

    private final ResourceLocation id;
    private final ItemStack result;
    private final Ingredient ingredient;
    private final float experience;
    private final int processingTime;

    public RoastingRecipe(ResourceLocation id, ItemStack result, Ingredient ingredient, float experience, int processingTime) {
        this.id = id;
        this.result = result;
        this.ingredient = ingredient;
        this.experience = experience;
        this.processingTime = processingTime;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return ingredient.test(container.getItem(0));
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
        return result;
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
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RoastingRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RoastingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<RoastingRecipe> {
        private Type() { }
        public static final RoastingRecipe.Type INSTANCE = new RoastingRecipe.Type();
        public static final String ID = Constants.MOD_ID + ":" + RECIPE_TYPE_NAME;
    }

    public static class Serializer implements RecipeSerializer<RoastingRecipe> {
        public static final RoastingRecipe.Serializer INSTANCE = new RoastingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Constants.MOD_ID,RECIPE_TYPE_NAME);

        @Override
        public RoastingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = new ItemStack(GsonHelper.getAsItem(json, "result"));

            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement);

            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(json, "roasting_time", 100);
            return new RoastingRecipe(id, result, ingredient, experience, cookingTime);
        }

        @Override
        public RoastingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.fromNetwork(buf);

            ItemStack result = buf.readItem();
            float experience = buf.readFloat();
            int cookingTime = buf.readVarInt();
            return new RoastingRecipe(id, result, ingredient, experience, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, RoastingRecipe recipe) {
            recipe.ingredient.toNetwork(buf);

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
            return RoastingRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
