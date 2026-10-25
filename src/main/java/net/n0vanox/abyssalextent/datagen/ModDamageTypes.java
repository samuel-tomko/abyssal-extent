package net.n0vanox.abyssalextent.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.n0vanox.abyssalextent.AbyssalExtent;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> SPIKES = ResourceKey.create(Registries.DAMAGE_TYPE,
            Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, "spikes"));

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(SPIKES, new DamageType("spikes", 0.1f, DamageEffects.HURT));
    }

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(key));
    }
}
