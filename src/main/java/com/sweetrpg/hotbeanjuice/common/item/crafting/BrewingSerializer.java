package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.common.util.ModJsonHelper;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.fluids.FluidStack;

public class BrewingSerializer<T extends AbstractBrewingRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<T> {
    private final int defaultCookingTime;
    public final BrewingSerializer.Brewer<T> factory;

    public BrewingSerializer(BrewingSerializer.Brewer<T> pFactory, int pDefaultCookingTime) {
        this.defaultCookingTime = pDefaultCookingTime;
        this.factory = pFactory;
    }

    @Override
    public T fromJson(ResourceLocation id, JsonObject json) {
        FluidStack fluidResult = ModJsonHelper.getFluidStackFromJson(json, true, true, "result");
        String group = GsonHelper.getAsString(json, "group", "");

        JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(jsonelement);

        float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
        int cookingTime = GsonHelper.getAsInt(json, "cookingtime", defaultCookingTime);
        float buckets = GsonHelper.getAsFloat(json, "buckets", 0.0F);
        return this.factory.create(id, group, fluidResult, ingredient, experience, cookingTime, buckets);
    }

    @Override
    public T fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        Ingredient ingredient = Ingredient.fromNetwork(buf);
        String group = buf.readUtf();

        FluidStack fluidResult = buf.readFluidStack();
        float experience = buf.readFloat();
        int cookingTime = buf.readVarInt();
        float buckets = buf.readFloat();
        return this.factory.create(id, group, fluidResult, ingredient, experience, cookingTime, buckets);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, AbstractBrewingRecipe recipe) {
        recipe.ingredient.toNetwork(buf);
        buf.writeUtf(recipe.group);

        buf.writeFluidStack(recipe.getResultFluid());
        buf.writeFloat(recipe.experience);
        buf.writeVarInt(recipe.brewingTime);
        buf.writeFloat(recipe.buckets);
    }

    public interface Brewer<T extends AbstractBrewingRecipe> {
        T create(ResourceLocation id, String group, FluidStack fluidResult, Ingredient ingredient, float experience, int cookingTime, float buckets);
    }
}
