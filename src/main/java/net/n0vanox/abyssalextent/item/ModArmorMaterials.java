package net.n0vanox.abyssalextent.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.tags.ModTags;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> PRISMALLOY_KEY = ResourceKey.create(REGISTRY_KEY, AbyssalExtent.id("prismalloy"));

    public static final ArmorMaterial PRISMALLOY_ARMOR_MATERIAL = new ArmorMaterial(67,
            ArmorMaterials.makeDefense(3, 6, 8, 3, 18),
            21, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.7F, 0, ModTags.Items.PRISMALLOY_REPAIR, PRISMALLOY_KEY);
}
