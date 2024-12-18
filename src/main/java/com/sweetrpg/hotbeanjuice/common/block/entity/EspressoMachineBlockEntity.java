package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.inventory.menus.EspressoMachineMenu;
import com.sweetrpg.hotbeanjuice.common.item.crafting.EspressoRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class EspressoMachineBlockEntity extends AbstractPoweredCoffeeMakerBlockEntity {
    public EspressoMachineBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.ESPRESSO_MACHINE_BLOCK_ENTITY.get(), pos, blockState, EspressoRecipe.Type.INSTANCE);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.ESPRESSO_MACHINE.get().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new EspressoMachineMenu(containerId, inventory, this, this.data);
    }
}
