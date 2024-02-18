package com.sweetrpg.hotbeanjuice.common.inventory.menus;

import com.sweetrpg.hotbeanjuice.common.block.entity.DripCoffeeBlockEntity;
import com.sweetrpg.hotbeanjuice.common.item.crafting.DripCoffeeRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;

public class DripCoffeeMachineMenu extends AbstractCoffeeMakerMenu {

    public DripCoffeeMachineMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.DRIP_COFFEE_MACHINE_MENU.get(), DripCoffeeRecipe.Type.INSTANCE, containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public DripCoffeeMachineMenu(int containerId, Inventory inv, DripCoffeeBlockEntity blockEntity, ContainerData data) {
        super(ModMenuTypes.DRIP_COFFEE_MACHINE_MENU.get(), DripCoffeeRecipe.Type.INSTANCE, containerId, inv, blockEntity, data);
    }
}
