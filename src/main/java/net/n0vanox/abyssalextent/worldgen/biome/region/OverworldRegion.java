package net.n0vanox.abyssalextent.worldgen.biome.region;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.n0vanox.abyssalextent.worldgen.biome.ModBiomes;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class OverworldRegion extends Region {
    public OverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterUtils.ParameterPointListBuilder() //ABYSSAL PLAINS
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.WARM))
                .humidity(ParameterUtils.Humidity.FULL_RANGE)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS)
                .erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_2, ParameterUtils.Erosion.EROSION_4)) //higher erosion = more flat, more water underground
                .depth(ParameterUtils.Depth.FULL_RANGE)
                .weirdness(ParameterUtils.Weirdness.VALLEY)
                .offset(0.0F)
                .build().forEach(parameterPoint -> builder.add(parameterPoint, ModBiomes.ABYSSAL_PLAINS));

        new ParameterUtils.ParameterPointListBuilder() //EERIE ABYSS
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.WARM))
                .humidity(ParameterUtils.Humidity.FULL_RANGE)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS)
                .erosion(ParameterUtils.Erosion.EROSION_0)
                .depth(ParameterUtils.Depth.span(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.UNDERGROUND))
                .weirdness(ParameterUtils.Weirdness.PEAK_VARIANT)
                .offset(0.0F)
                .build().forEach(parameterPoint -> builder.add(parameterPoint, ModBiomes.EERIE_ABYSS));

        builder.build().forEach(mapper);
    }
}
