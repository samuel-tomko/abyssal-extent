package net.n0vanox.abyssalextent.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CanyonWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.n0vanox.abyssalextent.AbyssalExtent;

public class ModCarvers {
    public static final ResourceKey<WorldCarver> ABYSS_CANYON =
            ResourceKey.create(Registries.CARVER,
                    AbyssalExtent.id("abyss_canyon"));

    public static void bootstrap(BootstrapContext<WorldCarver> context) {
        context.register(ABYSS_CANYON, new CanyonWorldCarver(
                0.99F, //probability of canyon spawning
                UniformHeight.of(VerticalAnchor.absolute(20),
                        VerticalAnchor.absolute(40)), //start y
                UniformFloat.of(-0.125F, 0.125F), //vertical rotation
                new CanyonWorldCarver.Shape(
                        UniformFloat.of(0.75F, 1.0F), //distance factor
                        TrapezoidFloat.of(15.0F, 30.0F, 2.0F), //thickness
                        3, //width_smoothness
                        UniformFloat.of(1.0F, 2.0F), //horizontal_radius_factor
                        1.0F, 2.0F, //vertical radius default and center values - VF = d + c * m where m is middleness
                        ConstantFloat.of(4.5F) //y scale
                )));
    }
}
