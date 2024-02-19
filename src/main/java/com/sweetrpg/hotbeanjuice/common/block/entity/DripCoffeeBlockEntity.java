package com.sweetrpg.hotbeanjuice.common.block.entity;

import com.sweetrpg.hotbeanjuice.common.inventory.menus.DripCoffeeMenu;
import com.sweetrpg.hotbeanjuice.common.item.crafting.DripCoffeeRecipe;
import com.sweetrpg.hotbeanjuice.common.registry.ModBlockEntityTypes;
import com.sweetrpg.hotbeanjuice.common.registry.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DripCoffeeBlockEntity extends AbstractPoweredCoffeeMakerBlockEntity {
    public DripCoffeeBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.DRIP_COFFEE_BLOCK_ENTITY.get(), pos, blockState, DripCoffeeRecipe.Type.INSTANCE);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Drip Coffee Maker");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new DripCoffeeMenu(pContainerId, pPlayerInventory, this, this.data);
    }
}
