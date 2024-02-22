package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.inventory.menus.DripCoffeeMachineMenu;
import com.sweetrpg.hotbeanjuice.common.item.crafting.DripCoffeeRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DripCoffeeMachineBlockEntity extends AbstractPoweredCoffeeMakerBlockEntity {
    public DripCoffeeMachineBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.DRIP_COFFEE_MACHINE_BLOCK_ENTITY.get(), pos, blockState, DripCoffeeRecipe.Type.INSTANCE);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.DRIP_COFFEE_MACHINE.get().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new DripCoffeeMachineMenu(containerId, inventory, this, this.data);
    }
}
