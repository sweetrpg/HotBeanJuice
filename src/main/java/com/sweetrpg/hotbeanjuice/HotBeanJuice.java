package com.sweetrpg.crafttracker;

import com.sweetrpg.hotbeanjuice.client.ClientSetup;
import com.sweetrpg.hotbeanjuice.client.event.ClientEventHandler;
import com.sweetrpg.hotbeanjuice.common.CommonSetup;
import com.sweetrpg.hotbeanjuice.common.addon.AddonManager;
import com.sweetrpg.hotbeanjuice.common.config.ConfigHandler;
import com.sweetrpg.hotbeanjuice.common.event.EventHandler;
import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.registry.*;
import com.sweetrpg.hotbeanjuice.data.CTAdvancementProvider;
import com.sweetrpg.hotbeanjuice.data.CTLangProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Paulyhedral, ProPercivalalb
 */
@Mod(Constants.MOD_ID)
public class CraftTracker {

    public static final Logger LOGGER = LogManager.getLogger(Constants.MOD_ID);

    public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder.named(com.sweetrpg.hotbeanjuice.common.lib.Constants.CHANNEL_NAME)
            .clientAcceptedVersions(Constants.PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(Constants.PROTOCOL_VERSION::equals)
            .networkProtocolVersion(com.sweetrpg.hotbeanjuice.common.lib.Constants.PROTOCOL_VERSION::toString)
            .simpleChannel();

    public CraftTracker() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Mod lifecycle
        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(CommonSetup::init);
        modEventBus.addListener(this::interModProcess);

        // Registries
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntityTypes.TILE_ENTITIES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
//        ModEntityTypes.ENTITIES.register(modEventBus);
        ModContainerTypes.CONTAINERS.register(modEventBus);
        ModSerializers.SERIALIZERS.register(modEventBus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);

        modEventBus.addListener(ModRegistries::newRegistry);
//        modEventBus.addListener(ModEntityTypes::addEntityAttributes);
//        modEventBus.addListener(Capabilities::registerCaps);

        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        forgeEventBus.addListener(this::serverStarting);
        forgeEventBus.addListener(this::registerCommands);

        forgeEventBus.register(new EventHandler());
//        forgeEventBus.register(new BackwardsComp());

        // Client Events
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(this::clientSetup);
            modEventBus.addListener(ModBlocks::registerBlockColours);
            modEventBus.addListener(ClientEventHandler::onModelBakeEvent);
            modEventBus.addListener(ClientSetup::setupTileEntityRenderers);
            modEventBus.addListener(ClientSetup::setupEntityRenderers);
            modEventBus.addListener(ClientSetup::addClientReloadListeners);

            forgeEventBus.register(new ClientEventHandler());
        });

        ConfigHandler.init(modEventBus);

        AddonManager.init();
    }

//    public void commonSetup(final FMLCommonSetupEvent event) {
//    }

    public void serverStarting(final ServerStartingEvent event) {
        LOGGER.debug("Server starting");
    }

    public void registerCommands(final RegisterCommandsEvent event) {
        LOGGER.debug("Register commands");
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.debug("Client startup");

        ClientSetup.setupScreenManagers(event);

    }

    protected void interModProcess(final InterModProcessEvent event) {
        LOGGER.debug("event {}", event);

        //        BackwardsComp.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AddonManager.init();
    }

    private void gatherData(final GatherDataEvent event) {
        LOGGER.debug("Gather data: {}", event);

        DataGenerator gen = event.getGenerator();

        if(event.includeClient()) {
//            BlockstateProvider blockstates = new BlockstateProvider(gen, event.getExistingFileHelper());
//            gen.addProvider(blockstates);
//            gen.addProvider(new ItemModelProvider(gen, blockstates.getExistingHelper()));
            gen.addProvider(new CTLangProvider(gen, Constants.LOCALE_EN_US));
            gen.addProvider(new CTLangProvider(gen, Constants.LOCALE_EN_GB));
            gen.addProvider(new CTLangProvider(gen, Constants.LOCALE_DE_DE));
        }

        if(event.includeServer()) {
            // gen.addProvider(new DTBlockTagsProvider(gen));
            gen.addProvider(new CTAdvancementProvider(gen));
//            BlockTagsProvider blockTagProvider = new CHBlockTagsProvider(gen, event.getExistingFileHelper());
//            gen.addProvider(blockTagProvider);
//            gen.addProvider(new ItemTagsProvider(gen, blockTagProvider, event.getExistingFileHelper()));
//            gen.addProvider(new RecipeProvider(gen));
//            gen.addProvider(new LootTableProvider(gen));
        }
    }
}
