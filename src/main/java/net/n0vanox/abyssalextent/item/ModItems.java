package net.n0vanox.abyssalextent.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.fish.AbstractFish;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.n0vanox.abyssalextent.block.custom.TridentHead;
import net.n0vanox.abyssalextent.entity.ModEntities;
import net.n0vanox.abyssalextent.entity.custom.AnglerfishEntity;
import net.n0vanox.abyssalextent.item.custom.ModSmithingTemplates;

import java.util.function.Function;

public class ModItems {
    public static final Item PRISMALLOY_INGOT = registerItem("prismalloy_ingot", Item::new);
    public static final Item CHROMIUM = registerItem("chromium", Item::new);
    public static final Item MACHINED_SCRAP =  registerItem("machined_scrap", Item::new);

    public static final Item ANGLERFISH_SPAWN_EGG = registerItem("anglerfish_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.ANGLERFISH)));

    public static final Item ANGLERFISH_BUCKET = registerItem("anglerfish_bucket",
            properties -> new MobBucketItem(ModEntities.ANGLERFISH,
                    Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));

    public static final Item PRISMALLOY_SWORD = registerItem("prismalloy_sword",
            properties -> new Item(properties.sword(ModToolMaterials.PRISMALLOY, 3, -2.4F)));
    public static final Item PRISMALLOY_PICKAXE = registerItem("prismalloy_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.PRISMALLOY, 1, -2.8F)));
    public static final Item PRISMALLOY_SHOVEL = registerItem("prismalloy_shovel",
            properties -> new Item(properties.shovel(ModToolMaterials.PRISMALLOY, 1.5F, -3.0F)));
    public static final Item PRISMALLOY_AXE = registerItem("prismalloy_axe",
            properties -> new Item(properties.axe(ModToolMaterials.PRISMALLOY, 5.0F, -3.0F)));
    public static final Item PRISMALLOY_HOE = registerItem("prismalloy_hoe",
            properties -> new Item(properties.hoe(ModToolMaterials.PRISMALLOY, -4.0F, 0.0F)));
    public static final Item PRISMALLOY_SPEAR = registerItem("prismalloy_spear",
            properties -> new Item(properties.spear(ModToolMaterials.PRISMALLOY, 1.15F, 1.2F, 0.4F,
                    2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));

    public static final Item PRISMALLOY_UPGRADE = registerItem("prismalloy_upgrade_smithing_template", ModSmithingTemplates::createPrismalloyUpgrade);


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, name)))));
    }

    public static void registerModItems() {
        AbyssalExtent.LOGGER.info("Registering ModItems for " + AbyssalExtent.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(PRISMALLOY_INGOT);
            output.accept(CHROMIUM);
            output.accept(MACHINED_SCRAP);
            output.accept(PRISMALLOY_UPGRADE);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output -> {
            output.accept(ANGLERFISH_SPAWN_EGG);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(PRISMALLOY_SWORD);
            output.accept(PRISMALLOY_SPEAR);
            output.accept(PRISMALLOY_AXE);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(PRISMALLOY_SHOVEL);
            output.accept(PRISMALLOY_PICKAXE);
            output.accept(PRISMALLOY_AXE);
            output.accept(PRISMALLOY_HOE);
            output.accept(ANGLERFISH_BUCKET);
        });
    }
}
