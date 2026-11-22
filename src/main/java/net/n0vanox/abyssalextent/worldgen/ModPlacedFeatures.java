package net.n0vanox.abyssalextent.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.n0vanox.abyssalextent.AbyssalExtent;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SEA_MINE_PLACED_SMALL_KEY = registerKey("sea_mine_placed_small");
    public static final ResourceKey<PlacedFeature> SEA_MINE_PLACED_LARGE_KEY = registerKey("sea_mine_placed_large");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.FEATURE);
        register(context, SEA_MINE_PLACED_SMALL_KEY, configuredFeatures.getOrThrow(ModFeatures.SEA_MINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(), CountPlacement.of(UniformInt.of(3, 6)),
                        OffsetPlacement.of(UniformInt.of(-4, 4), ConstantInt.of(0)),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(
                                BlockPredicate.matchesFluids(new Vec3i(0, 3, 0), List.of(Fluids.WATER))),//fix them reaching above water
                        BiomeFilter.biome()));
        register(context, SEA_MINE_PLACED_LARGE_KEY, configuredFeatures.getOrThrow(ModFeatures.SEA_MINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(), CountPlacement.of(UniformInt.of(4, 10)),
                        OffsetPlacement.of(UniformInt.of(-4, 4), ConstantInt.of(0)),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(
                                BlockPredicate.matchesFluids(new Vec3i(0, 3, 0), List.of(Fluids.WATER))),
                        BiomeFilter.biome()));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, AbyssalExtent.id(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<Feature> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
