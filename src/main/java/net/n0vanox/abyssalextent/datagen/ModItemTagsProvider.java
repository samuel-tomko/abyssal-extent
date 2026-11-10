package net.n0vanox.abyssalextent.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.n0vanox.abyssalextent.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS).add(ModItems.getRK(ModItems.PRISMALLOY_SWORD));
        tag(ItemTags.PICKAXES).add(ModItems.getRK(ModItems.PRISMALLOY_PICKAXE));
        tag(ItemTags.SHOVELS).add(ModItems.getRK(ModItems.PRISMALLOY_SHOVEL));
        tag(ItemTags.AXES).add(ModItems.getRK(ModItems.PRISMALLOY_AXE));
        tag(ItemTags.HOES).add(ModItems.getRK(ModItems.PRISMALLOY_HOE));
        tag(ItemTags.SPEARS).add(ModItems.getRK(ModItems.PRISMALLOY_SPEAR));
    }
}
