package net.n0vanox.abyssalextent.worldgen.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.n0vanox.abyssalextent.worldgen.ModPlacedFeatures;
import net.n0vanox.abyssalextent.worldgen.biome.ModBiomes;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_COLD_OCEAN,
                Biomes.DEEP_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN),
                GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.SEA_MINE_PLACED_SMALL_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ABYSSAL_PLAINS, ModBiomes.EERIE_ABYSS),
                GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.SEA_MINE_PLACED_LARGE_KEY);
    }
}
