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
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class GrindingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;

    public GrindingRecipe(ResourceLocation id, ItemStack result, Ingredient ingredient, float experience, int cookingTime) {
        this.id = id;
        this.result = result;
        this.ingredient = ingredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
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
        return ItemStack.EMPTY.copy();
    }


    public int getCookingTime() {
        return cookingTime;
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
        return GrindingRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return GrindingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<GrindingRecipe> {
        private Type() { }
        public static final GrindingRecipe.Type INSTANCE = new GrindingRecipe.Type();
        public static final String ID = Constants.MOD_ID + ":workbench_smelting";
    }

    public static class Serializer implements RecipeSerializer<GrindingRecipe> {
        public static final GrindingRecipe.Serializer INSTANCE = new GrindingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Constants.MOD_ID,"grinding");

        @Override
        public GrindingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = new ItemStack(GsonHelper.getAsItem(json, "result"));

            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement);

            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(json, "cookingtime", 100);
            float buckets = GsonHelper.getAsFloat(json, "buckets", 0.0F);
            return new GrindingRecipe(id, result, ingredient, experience, cookingTime);
        }

        @Override
        public GrindingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.fromNetwork(buf);

            ItemStack result = buf.readItem();
            float experience = buf.readFloat();
            int cookingTime = buf.readVarInt();
            float buckets = buf.readFloat();
            return new GrindingRecipe(id, result, ingredient, experience, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, GrindingRecipe recipe) {
            recipe.ingredient.toNetwork(buf);

            buf.writeItem(recipe.getResultItem());
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.cookingTime);
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
            return GrindingRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
