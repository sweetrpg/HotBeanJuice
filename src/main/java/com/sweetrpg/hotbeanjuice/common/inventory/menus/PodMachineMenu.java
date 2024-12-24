//package com.sweetrpg.hotbeanjuice.common.inventory.menus;
//
//import com.sweetrpg.hotbeanjuice.common.block.entity.PodMachineBlockEntity;
//import com.sweetrpg.hotbeanjuice.common.item.crafting.PodCoffeeRecipe;
//import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.inventory.SimpleContainerData;
//
//public class PodMachineMenu extends AbstractCoffeeMakerMenu {
//
//    public PodMachineMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
//        super(ModMenuTypes.POD_MACHINE_MENU.get(), PodCoffeeRecipe.Type.INSTANCE, containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
//    }
//
//    public PodMachineMenu(int containerId, Inventory inv, PodMachineBlockEntity blockEntity, ContainerData data) {
//        super(ModMenuTypes.POD_MACHINE_MENU.get(), PodCoffeeRecipe.Type.INSTANCE, containerId, inv, blockEntity, data);
//    }
//}
