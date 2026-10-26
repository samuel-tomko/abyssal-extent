package net.n0vanox.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.block.ModBlocks;
import net.n0vanox.abyssalextent.item.ModItems;

public class ModCreativeModeTabs {
    public static final CreativeModeTab PRISMALLOY_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, "prismalloy_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PRISMALLOY_INGOT))
                    .title(Component.translatable("creativemodetab.abyssal-extent.prismalloy_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PRISMALLOY_INGOT);
                        output.accept(ModItems.CHROMIUM);
                        output.accept(ModItems.MACHINED_SCRAP);
                        output.accept(ModBlocks.NAUTILUS_BLOCK);
                        output.accept(ModBlocks.PRISMALLOY_BLOCK);
                        output.accept(ModBlocks.CHROMIUM_BLOCK);
                        output.accept(ModBlocks.ANCIENT_MACHINERY);
                        output.accept(ModBlocks.TRIDENT_HEAD);
                        output.accept(ModItems.ANGLERFISH_SPAWN_EGG);
                    })
                    .build());

    public static void registerModCreativeModeTabs() {
        AbyssalExtent.LOGGER.info("Registering Creative Mode Tabs for " + AbyssalExtent.MOD_ID);
    }
}
