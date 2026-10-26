package net.n0vanox.abyssalextent.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.entity.custom.AnglerfishEntity;

public class ModEntities {
    public static final ResourceKey<EntityType<?>> ANGLERFISH_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, "anglerfish"));

    public static final EntityType<AnglerfishEntity> ANGLERFISH = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, "anglerfish"),
            EntityType.Builder.of(AnglerfishEntity::new, MobCategory.MONSTER).sized(0.25f, 0.25f).build(ANGLERFISH_KEY));

    public static void registerModEntities() {
        AbyssalExtent.LOGGER.info("Registering Mod Entities for " + AbyssalExtent.MOD_ID);
    }
}
