package com.sweetrpg.hotbeanjuice.common.event;

import com.sweetrpg.hotbeanjuice.common.lib.Constants;
import com.sweetrpg.hotbeanjuice.common.world.gen.WildCropGeneration;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public void rightClickEntity(final PlayerInteractEvent.EntityInteract event) {
        Level world = event.getWorld();

        ItemStack stack = event.getItemStack();
        Entity target = event.getTarget();

    }

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        Biome.ClimateSettings climate = event.getClimate();

        if((event.getCategory().equals(Biome.BiomeCategory.PLAINS) ||
                event.getCategory().equals(Biome.BiomeCategory.EXTREME_HILLS) ||
                event.getCategory().equals(Biome.BiomeCategory.FOREST) ||
                event.getCategory().equals(Biome.BiomeCategory.SAVANNA) ||
                event.getCategory().equals(Biome.BiomeCategory.MUSHROOM) ||
                event.getCategory().equals(Biome.BiomeCategory.TAIGA) ||
                event.getCategory().equals(Biome.BiomeCategory.MOUNTAIN)) &&
                (climate.temperature >= 0.2F && climate.temperature < 1.5F)) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildCropGeneration.PATCH_WILD_COFFEA_ARABICA);
        }
        else if((event.getCategory().equals(Biome.BiomeCategory.DESERT) ||
                event.getCategory().equals(Biome.BiomeCategory.SAVANNA)) &&
                (climate.temperature >= 0.2F && climate.temperature < 1.5F)) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildCropGeneration.PATCH_WILD_COFFEA_CANEPHORA);
        }
        else if((event.getCategory().equals(Biome.BiomeCategory.PLAINS) ||
                event.getCategory().equals(Biome.BiomeCategory.EXTREME_HILLS) ||
                event.getCategory().equals(Biome.BiomeCategory.TAIGA)) &&
                (climate.temperature >= 0.2F && climate.temperature < 1.5F)) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildCropGeneration.PATCH_WILD_COFFEA_RACEMOSA);
        }
    }

    @SubscribeEvent
    public void onEntitySpawn(final EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();


    }

    @SubscribeEvent
    public void playerLoggedIn(final PlayerLoggedInEvent event) {

    }

    @SubscribeEvent
    public void onLootDrop(final LootingLevelEvent event) {

    }
}
