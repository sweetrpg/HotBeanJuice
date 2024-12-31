package com.sweetrpg.hotbeanjuice.common.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static JsonArray arrayFrom(JsonElement... elements) {
        JsonArray array = new JsonArray();

        for(var element : elements) {
            array.add(element);
        }

        return array;
    }

    public static JsonArray arrayFrom(Ingredient... ingredients) {
        JsonArray array = new JsonArray();

        for(var ingredient : ingredients) {
            array.add(ingredient.toJson());
        }

        return array;
    }

    public static JsonArray arrayFrom(List<Ingredient> ingredients) {
        JsonArray array = new JsonArray();

        for(var ingredient : ingredients) {
            array.add(ingredient.toJson());
        }

        return array;
    }

    public static List<Ingredient> ingredientsFrom(JsonArray array) {
        List<Ingredient> ingredients = new ArrayList<>();

        for(var element : array) {
            Ingredient ingredient = Ingredient.fromJson(element);
            ingredients.add(ingredient);
        }

        return ingredients;
    }

}
