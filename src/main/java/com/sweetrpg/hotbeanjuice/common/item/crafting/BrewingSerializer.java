package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BrewingSerializer<T extends AbstractBrewingRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<T> {
    private final int defaultBrewingTime;
    public final BrewingSerializer.Brewer<T> factory;

    public BrewingSerializer(BrewingSerializer.Brewer<T> pFactory, int defaultBrewingTime) {
        this.defaultBrewingTime = defaultBrewingTime;
        this.factory = pFactory;
    }

    @Override
    public T fromJson(ResourceLocation id, JsonObject json) {
        String group = GsonHelper.getAsString(json, "group", "");

        JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(jsonelement);

        float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
        int brewingTime = GsonHelper.getAsInt(json, "brewingTime", defaultBrewingTime);
        int millibuckets = GsonHelper.getAsInt(json, "millibuckets", 1000);

        return this.factory.create(id, group, ingredient, experience, brewingTime, millibuckets);
    }

    @Override
    public T fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        Ingredient ingredient = Ingredient.fromNetwork(buf);
        String group = buf.readUtf();

        float experience = buf.readFloat();
        int brewingTime = buf.readVarInt();
        int millibuckets = buf.readVarInt();

        return this.factory.create(id, group, ingredient, experience, brewingTime, millibuckets);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, AbstractBrewingRecipe recipe) {
        recipe.ingredient.toNetwork(buf);
        buf.writeUtf(recipe.group);

        buf.writeFloat(recipe.experience);
        buf.writeVarInt(recipe.brewingTime);
        buf.writeInt(recipe.millibuckets);
    }

    public interface Brewer<T extends AbstractBrewingRecipe> {
        T create(ResourceLocation id, String group, Ingredient ingredient, float experience, int brewingTime, int millibuckets);
    }
}
