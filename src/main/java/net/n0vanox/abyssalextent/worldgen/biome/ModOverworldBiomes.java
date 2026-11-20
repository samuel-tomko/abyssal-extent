package net.n0vanox.abyssalextent.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.n0vanox.abyssalextent.datagen.ModCarvers;
import net.n0vanox.abyssalextent.entity.ModEntities;
import net.n0vanox.abyssalextent.worldgen.ModPlacedFeatures;

public class ModOverworldBiomes {
    public static Biome abyssalPlains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<WorldCarver> carverGetter) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.oceanSpawns(spawnBuilder, 3, 4, 9);
        spawnBuilder.addSpawn(ModEntities.ANGLERFISH, 50, UniformInt.of(1,2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_DEEP_COLD);

        // Custom Placed Feature
        biomeBuilder.addCarver(carverGetter.getOrThrow(ModCarvers.ABYSS_CANYON));
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.SEA_MINE_PLACED_LARGE_KEY);

//get darker fog, increase anglerfish, add glowing and eerie abysses
        return OverworldBiomes.baseOcean().specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x19328d).build())
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

}
