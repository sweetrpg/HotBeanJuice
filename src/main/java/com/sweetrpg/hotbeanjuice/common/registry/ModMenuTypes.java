package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.inventory.menus.CoffeeRoasterMenu;
import com.sweetrpg.hotbeanjuice.common.inventory.menus.DripCoffeeMenu;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Constants.MOD_ID);

    public static final RegistryObject<MenuType<DripCoffeeMenu>> DRIP_COFFEE_MENU = MENUS.register("drip_coffee", () -> IForgeMenuType.create(DripCoffeeMenu::new));
    public static final RegistryObject<MenuType<CoffeeRoasterMenu>> COFFEE_ROASTER_MENU = MENUS.register("coffee_roaster", () -> IForgeMenuType.create(CoffeeRoasterMenu::new));

    public static void register(IEventBus event) {
        MENUS.register(event);
    }


}
