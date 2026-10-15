package net.n0vanox.abyssalextent.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.n0vanox.abyssalextent.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.PRISMALLOY_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CHROMIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.NAUTILUS_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.ANCIENT_MACHINERY));

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.PRISMALLOY_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CHROMIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.ANCIENT_MACHINERY));
    }
}
