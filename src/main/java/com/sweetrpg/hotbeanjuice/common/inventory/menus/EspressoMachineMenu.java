//package com.sweetrpg.hotbeanjuice.common.inventory.menus;
//
//import com.sweetrpg.hotbeanjuice.common.block.entity.EspressoMachineBlockEntity;
//import com.sweetrpg.hotbeanjuice.common.item.crafting.EspressoRecipe;
//import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.inventory.SimpleContainerData;
//
//public class EspressoMachineMenu extends AbstractCoffeeMakerMenu {
//
//    public EspressoMachineMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
//        super(ModMenuTypes.ESPRESSO_MACHINE_MENU.get(), EspressoRecipe.Type.INSTANCE, containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
//    }
//
//    public EspressoMachineMenu(int containerId, Inventory inv, EspressoMachineBlockEntity blockEntity, ContainerData data) {
//        super(ModMenuTypes.ESPRESSO_MACHINE_MENU.get(), EspressoRecipe.Type.INSTANCE, containerId, inv, blockEntity, data);
//    }
//}
