package net.n0vanox.abyssalextent.worldgen.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.n0vanox.abyssalextent.worldgen.ModPlacedFeatures;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_COLD_OCEAN), GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.SEA_MINE_PLACED_KEY);
    }
}
