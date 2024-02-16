package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.inventory.menu.CoffeeRoasterMenu;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModContainerTypes {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.Keys.CONTAINER_TYPES, Constants.MOD_ID);

    public static final RegistryObject<MenuType<CoffeeRoasterMenu>> COFFEE_ROASTER_MENU = CONTAINERS.register("coffee_roaster", () -> IForgeMenuType.create(CoffeeRoasterMenu::new));

    private static <X extends AbstractContainerMenu, T extends MenuType<X>> RegistryObject<MenuType<X>> register(final String name, final IContainerFactory<X> factory) {
        return register(name, () -> IForgeMenuType.create(factory));
    }

    private static <T extends MenuType<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return CONTAINERS.register(name, sup);
    }
}
