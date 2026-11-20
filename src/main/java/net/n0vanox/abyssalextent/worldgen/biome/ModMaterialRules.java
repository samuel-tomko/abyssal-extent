package net.n0vanox.abyssalextent.worldgen.biome;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class ModMaterialRules {
    private static final MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);

    private static final MaterialCondition ON_FLOOR = MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR);
    private static final MaterialCondition UNDER_FLOOR = MaterialRules.stoneDepthCheck(0, true, CaveSurface.FLOOR);


    public static MaterialRule makeModOverworldRules(RegistryAccess registryAccess) {
        return MaterialRules.sequence(
                MaterialRules.ifTrue(MaterialRules.isBiome(registryAccess.lookupOrThrow(Registries.BIOME), ModBiomes.ABYSSAL_PLAINS),
                        MaterialRules.sequence(MaterialRules.ifTrue(UNDER_FLOOR, GRAVEL), DEEPSLATE)),
                // Default to deepslate
                MaterialRules.ifTrue(ON_FLOOR, DEEPSLATE)
        );
    }


    private static MaterialRule makeStateRule(Block block) {
        return MaterialRules.state(block.defaultBlockState());
    }
}
