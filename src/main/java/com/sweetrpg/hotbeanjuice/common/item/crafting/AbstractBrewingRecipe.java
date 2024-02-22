package com.sweetrpg.hotbeanjuice.common.item.crafting;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBrewingRecipe implements Recipe<SimpleContainer> {
    protected final RecipeType<?> type;
    protected final String group;
    protected final ResourceLocation id;
//    protected final FluidStack fluidResult;
    protected final List<Ingredient> ingredients;
    protected final float experience;
    protected final int brewingTime;
    protected final int millibuckets;

    public AbstractBrewingRecipe(RecipeType<?> type, String group, ResourceLocation id, List<Ingredient> ingredients, float experience, int brewingTime, int millibuckets) {
        this.type = type;
        this.group = group;
        this.id = id;

//        this.fluidResult = fluidResult;
        this.ingredients = ingredients;
        this.experience = experience;
        this.brewingTime = brewingTime;
        this.millibuckets = millibuckets;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return false; /* TODO ingredients.test(container.getItem(0)); */
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

//    public FluidStack getResultFluid() {
//        return fluidResult.copy();
//    }

    public int getBrewingTime() {
        return brewingTime;
    }

    public float getExperience() {
        return experience;
    }

    public int getMillibuckets() {
        return millibuckets;
    }


    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullList = NonNullList.create();
        nonNullList.addAll(this.ingredients);
        return nonNullList;
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
