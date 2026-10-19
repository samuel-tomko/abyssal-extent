package net.n0vanox.abyssalextent.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.n0vanox.abyssalextent.block.ModBlocks;
import net.n0vanox.abyssalextent.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.PRISMALLOY_BLOCK);
        dropSelf(ModBlocks.CHROMIUM_BLOCK);
        dropSelf(ModBlocks.NAUTILUS_BLOCK);
        dropSelf(ModBlocks.TRIDENT_HEAD);

        add(ModBlocks.ANCIENT_MACHINERY, createOreDrop(ModBlocks.ANCIENT_MACHINERY, ModItems.MACHINED_SCRAP));
    }
}
