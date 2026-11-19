package net.n0vanox.abyssalextent.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.n0vanox.abyssalextent.AbyssalExtent;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SEA_MINE_PLACED_KEY = registerKey("sea_mine_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.FEATURE);
        //SurfaceWaterDepthFilter.forMaxDepth(#) -> find how to make it need a min depth
        register(context, SEA_MINE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.SEA_MINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), //lower 32? figure out how to cluster them closer
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, AbyssalExtent.id(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<Feature> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
