package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.common.Constants;
import com.sweetrpg.hotbeanjuice.common.util.JsonUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.ArrayList;
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
        String group = GsonHelper.getAsString(json, Constants.RECIPE_SERIALIZER_DATA_GROUP, "");

//        JsonElement jsonElement = GsonHelper.isArrayNode(json, "ingredients") ? GsonHelper.getAsJsonArray(json, "ingredients") : GsonHelper.getAsJsonObject(json, "ingredients");
        JsonArray jsonArray = GsonHelper.getAsJsonArray(json, Constants.RECIPE_SERIALIZER_DATA_INGREDIENTS);
        List<Ingredient> ingredients = JsonUtil.ingredientsFrom(jsonArray);

        float experience = GsonHelper.getAsFloat(json, Constants.RECIPE_SERIALIZER_DATA_EXPERIENCE, 0.0F);
        int brewingTime = GsonHelper.getAsInt(json, Constants.RECIPE_SERIALIZER_DATA_PROCESSING_TIME, defaultBrewingTime);
        int millibuckets = GsonHelper.getAsInt(json, Constants.RECIPE_SERIALIZER_DATA_MILLIBUCKETS, 1000);

        return this.factory.create(id, group, ingredients, experience, brewingTime, millibuckets);
    }

    @Override
    public T fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        String group = buf.readUtf();

        int ingredientCount = buf.readInt();
        List<Ingredient> ingredients = new ArrayList<>();
        for(int i = 0; i < ingredientCount; i++) {
            Ingredient ingredient = Ingredient.fromNetwork(buf);
            ingredients.add(ingredient);
        }

        float experience = buf.readFloat();
        int brewingTime = buf.readInt();
        int millibuckets = buf.readInt();

        return this.factory.create(id, group, ingredients, experience, brewingTime, millibuckets);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, AbstractBrewingRecipe recipe) {
        buf.writeUtf(recipe.group);

        buf.writeInt(recipe.ingredients.size());
        recipe.ingredients.forEach(i -> i.toNetwork(buf));

        buf.writeFloat(recipe.experience);
        buf.writeInt(recipe.brewingTime);
        buf.writeInt(recipe.millibuckets);
    }

    public interface Brewer<T extends AbstractBrewingRecipe> {
        T create(ResourceLocation id, String group, List<Ingredient> ingredients, float experience, int brewingTime, int millibuckets);
    }
}
