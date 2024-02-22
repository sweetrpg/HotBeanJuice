package com.sweetrpg.hotbeanjuice.common.registry;

import com.sweetrpg.hotbeanjuice.common.inventory.menus.CoffeeRoasterMenu;
import com.sweetrpg.hotbeanjuice.common.inventory.menus.DripCoffeeMachineMenu;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Constants.MOD_ID);

    public static final RegistryObject<MenuType<DripCoffeeMachineMenu>> DRIP_COFFEE_MACHINE_MENU = MENU_TYPES.register("drip_coffee_machine", () -> IForgeMenuType.create(DripCoffeeMachineMenu::new));
    public static final RegistryObject<MenuType<CoffeeRoasterMenu>> COFFEE_ROASTER_MENU = MENU_TYPES.register("coffee_roaster", () -> IForgeMenuType.create(CoffeeRoasterMenu::new));

    public static void register(IEventBus event) {
        MENU_TYPES.register(event);
    }


}
