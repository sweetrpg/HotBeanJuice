package com.sweetrpg.hotbeanjuice.common.inventory.menus;

import com.sweetrpg.hotbeanjuice.common.block.entity.PercolatorBlockEntity;
import com.sweetrpg.hotbeanjuice.common.item.crafting.PercolatorCoffeeRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;

public class PercolatorMenu extends AbstractCoffeeMakerMenu {

    public PercolatorMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.PERCOLATOR_MENU.get(), PercolatorCoffeeRecipe.Type.INSTANCE, containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public PercolatorMenu(int containerId, Inventory inv, PercolatorBlockEntity blockEntity, ContainerData data) {
        super(ModMenuTypes.PERCOLATOR_MENU.get(), PercolatorCoffeeRecipe.Type.INSTANCE, containerId, inv, blockEntity, data);
    }
}
