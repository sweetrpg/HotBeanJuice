package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrewingSerializer<T extends AbstractBrewingRecipe> extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<T> {
    private final int defaultBrewingTime;
    public final BrewingSerializer.Brewer<T> factory;
    public final String suffix;

    public BrewingSerializer(BrewingSerializer.Brewer<T> pFactory, int defaultBrewingTime, String suffix) {
        this.defaultBrewingTime = defaultBrewingTime;
        this.factory = pFactory;
        this.suffix = suffix;
    }

    @Override
    public T fromJson(ResourceLocation id, JsonObject json) {
        String group = GsonHelper.getAsString(json, "group", "");

        JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredients") ? GsonHelper.getAsJsonArray(json, "ingredients") : GsonHelper.getAsJsonObject(json, "ingredients");
        List<Ingredient> ingredients = new ArrayList<>();
        // TODO
        Ingredient ingredient = Ingredient.fromJson(jsonelement);

        float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
        int brewingTime = GsonHelper.getAsInt(json, "brewingTime", defaultBrewingTime);
        int millibuckets = GsonHelper.getAsInt(json, "millibuckets", 1000);

        return this.factory.create(id, group, ingredients, experience, brewingTime, millibuckets);
    }

    @Override
    public T fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        int ingredientCount= buf.readInt();
        List<Ingredient> ingredients = new ArrayList<>();
        for(int i=0; i<ingredientCount; i++) {
            Ingredient ingredient = Ingredient.fromNetwork(buf);
            ingredients.add(ingredient);
        }
        String group = buf.readUtf();

        float experience = buf.readFloat();
        int brewingTime = buf.readVarInt();
        int millibuckets = buf.readVarInt();

        return this.factory.create(id, group, ingredients, experience, brewingTime, millibuckets);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, AbstractBrewingRecipe recipe) {
        buf.writeInt(recipe.ingredients.size());
        recipe.ingredients.forEach((i) -> i.toNetwork(buf));
        buf.writeUtf(recipe.group);

        buf.writeFloat(recipe.experience);
        buf.writeVarInt(recipe.brewingTime);
        buf.writeInt(recipe.millibuckets);
    }

    public interface Brewer<T extends AbstractBrewingRecipe> {
        T create(ResourceLocation id, String group, List<Ingredient> ingredients, float experience, int brewingTime, int millibuckets);
    }
}
