package net.n0vanox.abyssalextent.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Directional;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeatureTypes;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.SingleBlockPillarFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.OffsetPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.block.ModBlocks;

import java.util.List;
import java.util.Optional;

public class ModFeatures {
    public static final ResourceKey<Feature> SEA_MINE_KEY = registerKey("sea_mine");

    public static void bootstrap(BootstrapContext<Feature> context) {
        BlockState chain = Blocks.IRON_CHAIN.defaultBlockState()
                .setValue(BlockStateProperties.WATERLOGGED, true);

        context.register(SEA_MINE_KEY, new SingleBlockPillarFeature(Holder.direct(new SimpleStateProvider(chain)),
                BlockPredicate.matchesFluids(Fluids.WATER), Direction.UP, 0.8F, //min 6 blocks, then 80% after - make new class
                Optional.of(Holder.direct(new PlacedFeature(Holder.direct(new SimpleBlockFeature(
                        Holder.direct(new SimpleStateProvider(ModBlocks.SEA_MINE.defaultBlockState())))),
                        List.of(OffsetPlacement.vertical(ConstantInt.of(1))))))));
    }

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, AbyssalExtent.id(name));
    }


}
