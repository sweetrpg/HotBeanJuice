package com.sweetrpg.hotbeanjuice.common.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.util.ModJsonHelper;
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
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

public abstract class AbstractBrewingRecipe implements Recipe<SimpleContainer> {
    protected final RecipeType<?> type;
    protected final String group;
    protected final ResourceLocation id;
    protected final FluidStack fluidResult;
    protected final Ingredient ingredient;
    protected final float experience;
    protected final int brewingTime;
    protected final float buckets;

    //TODO add a required amount of water, not just end result fluid
    public AbstractBrewingRecipe(RecipeType<?> type, String group, ResourceLocation id, FluidStack fluidResult, Ingredient ingredient, float experience, int brewingTime, float buckets) {
        this.type = type;
        this.group = group;
        this.id = id;
        this.fluidResult = fluidResult;
        this.ingredient = ingredient;
        this.experience = experience;
        this.brewingTime = brewingTime;
        this.buckets = buckets;
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
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY.copy();
    }

    public FluidStack getResultFluid() {
        return fluidResult.copy();
    }

    public int getBrewingTime() {
        return brewingTime;
    }

    public float getExperience() {
        return experience;
    }

    public float getBuckets() {
        return buckets;
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
    public @NotNull RecipeType<?> getType() {
        return type;
    }

}