package com.sweetrpg.hotbeanjuice.common.inventory.menus;

import com.sweetrpg.hotbeanjuice.common.item.crafting.PercolatorCoffeeRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.SimpleContainerData;

public class KettleMenu extends AbstractCoffeeMakerMenu {

    public KettleMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.KETTLE_MENU.get(), PercolatorCoffeeRecipe.Type.INSTANCE, containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

}
