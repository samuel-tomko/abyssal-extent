package net.n0vanox.abyssalextent.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.SpawnEggItem;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.n0vanox.abyssalextent.entity.ModEntities;

import java.util.function.Function;

public class ModItems {
    public static final Item PRISMALLOY_INGOT = registerItem("prismalloy_ingot", Item::new);
    public static final Item CHROMIUM = registerItem("chromium", Item::new);
    public static final Item MACHINED_SCRAP =  registerItem("machined_scrap", Item::new);

    public static final Item ANGLERFISH_SPAWN_EGG = registerItem("anglerfish_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.ANGLERFISH)));

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
        });
    }
}
