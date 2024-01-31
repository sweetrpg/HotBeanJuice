package com.sweetrpg.hotbeanjuice.common.config;

import com.sweetrpg.hotbeanjuice.HotBeanJuice;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class ConfigHandler {

    public static ClientConfig CLIENT;
    public static ServerConfig SERVER;
    private static ForgeConfigSpec CONFIG_SERVER_SPEC;
    private static ForgeConfigSpec CONFIG_CLIENT_SPEC;


    public static void init(IEventBus modEventBus) {
        Pair<ServerConfig, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        CONFIG_SERVER_SPEC = commonPair.getRight();
        SERVER = commonPair.getLeft();
        Pair<ClientConfig, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CONFIG_CLIENT_SPEC = clientPair.getRight();
        CLIENT = clientPair.getLeft();
        HotBeanJuice.LOGGER.debug("Register configs");

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CONFIG_SERVER_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CONFIG_CLIENT_SPEC);
    }

    public static class ClientConfig {

        public ClientConfig(ForgeConfigSpec.Builder builder) {
            {
                builder.push("General");


                builder.pop();
            }

        }
    }

    public static class ServerConfig {

        public ForgeConfigSpec.IntValue CHANCE_COFFEE_BUSH;
        public ForgeConfigSpec.IntValue COFFEE_BUSH_SPREAD;

        public ServerConfig(ForgeConfigSpec.Builder builder) {
            {
                builder.push("General");

                builder.pop();
            }

            {
                builder.push("Crops");

                CHANCE_COFFEE_BUSH = builder.comment("Chance that coffee bushes appear in the wild").translation(Constants.TRANSLATION_KEY_CONFIG_CHANCE_COFFEE_BUSH).defineInRange("chance_coffee_bush", 50, 1, 100);
                COFFEE_BUSH_SPREAD = builder.comment("Horizontal spread of patches of coffee bushes").translation(Constants.TRANSLATION_KEY_CONFIG_COFFEE_BUSH_SPREAD).defineInRange("coffee_bush_spread", 6, 1, 20);

                builder.pop();
            }

        }
    }

}
