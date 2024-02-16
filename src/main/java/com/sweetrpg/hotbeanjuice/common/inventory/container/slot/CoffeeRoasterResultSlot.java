package com.sweetrpg.hotbeanjuice.common.inventory.container.slot;

import com.sweetrpg.hotbeanjuice.common.inventory.container.CoffeeRoastingContainer;
import com.sweetrpg.hotbeanjuice.common.recipes.CoffeeMakerRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class CoffeeRoasterResultSlot extends Slot {
    private final CoffeeRoastingContainer craftSlots;
    private final Player player;
    private int removeCount;

    public CoffeeRoasterResultSlot(Player player, CoffeeRoastingContainer roastingContainer, Container container, int slot, int x, int y) {
        super(container, slot, x, y);
        this.player = player;
        this.craftSlots = roastingContainer;
    }


    public boolean mayPlace(ItemStack itemStack) {
        return false;
    }

    public ItemStack remove(int slot) {
        if (this.hasItem()) {
            this.removeCount += Math.min(slot, this.getItem().getCount());
        }

        return super.remove(slot);
    }

    protected void onQuickCraft(ItemStack itemStack, int count) {
        this.removeCount += count;
        this.checkTakeAchievements(itemStack);
    }

    protected void onSwapCraft(int count) {
        this.removeCount += count;
    }

    protected void checkTakeAchievements(ItemStack itemStack) {
        if (this.removeCount > 0) {
            itemStack.onCraftedBy(this.player.level, this.player, this.removeCount);
            net.minecraftforge.event.ForgeEventFactory.firePlayerCraftingEvent(this.player, itemStack, this.craftSlots);
        }

        if (this.container instanceof RecipeHolder) {
            ((RecipeHolder)this.container).awardUsedRecipes(this.player);
        }

        this.removeCount = 0;
    }

    public void onTake(Player player, ItemStack itemStack) {
        this.checkTakeAchievements(itemStack);
        ForgeHooks.setCraftingPlayer(player);

        // TODO
//        NonNullList<ItemStack> nonnulllist = player.level.getRecipeManager().getRemainingItemsFor(CoffeeRoasterRecipe.Type.INSTANCE, this.craftSlots, player.level);
//        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);
//
//        Optional<CoffeeRoasterRecipe> recipe = player.level.getRecipeManager().getRecipeFor(CoffeeRoasterRecipe.Type.INSTANCE, this.craftSlots, player.level);
//
//        if (recipe.isPresent()) {
//            for (int i = 0; i < nonnulllist.size(); ++i) {
//                ItemStack itemstack = this.craftSlots.getItem(i);
//                ItemStack itemstack1 = nonnulllist.get(i);
//                if (!itemstack.isEmpty()) {
//
//                    this.craftSlots.removeItem(i, 1);
//                    itemstack = this.craftSlots.getItem(i);
//
////                    if (itemstack.getItem() instanceof IngotMoldItem) {
////                        this.craftSlots.setItem(i, new ItemStack(ItemRegistry.INGOT_MOLD.get(), 1));
////                    }
//
////                    if (itemstack.getItem() instanceof BlockMoldItem) {
////                        this.craftSlots.setItem(i, new ItemStack(ItemRegistry.BLOCK_MOLD.get(), 1));
////                    }
//                }
//
//                if (!itemstack1.isEmpty()) {
//                    if (itemstack.isEmpty()) {
//                        this.craftSlots.setItem(i, itemstack1);
//                    } else if (ItemStack.isSame(itemstack, itemstack1) && ItemStack.tagMatches(itemstack, itemstack1)) {
//                        itemstack1.grow(itemstack.getCount());
//                        this.craftSlots.setItem(i, itemstack1);
//                    } else if (!this.player.getInventory().add(itemstack1)) {
//                        this.player.drop(itemstack1, false);
//                    }
//                }
//            }
//        }
    }
}
