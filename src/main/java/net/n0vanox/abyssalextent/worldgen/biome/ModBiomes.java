package net.n0vanox.abyssalextent.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.worldgen.biome.region.OverworldRegion;
import terrablender.api.Regions;

public class ModBiomes {
    public static final ResourceKey<Biome> ABYSSAL_PLAINS  = registerBiomeKey("abyssal_plains");
    public static final ResourceKey<Biome> GLOWING_ABYSS  = registerBiomeKey("glowing_abyss");
    public static final ResourceKey<Biome> EERIE_ABYSS  = registerBiomeKey("eerie_abyss");

    public static void registerBiomes() {
        Regions.register(new OverworldRegion(AbyssalExtent.id("abyssal_extent_overworld"), 20));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        var carvers = context.lookup(Registries.CARVER);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, ABYSSAL_PLAINS, ModOverworldBiomes.abyssalPlains(placedFeatures, carvers));
    }

    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    private static ResourceKey<Biome> registerBiomeKey(String name) {
    return ResourceKey.create(Registries.BIOME, AbyssalExtent.id(name));
    }
}
