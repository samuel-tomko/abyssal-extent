package net.n0vanox.abyssalextent.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.n0vanox.abyssalextent.block.ModBlocks;
import net.n0vanox.abyssalextent.item.ModItems;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.PRISMALLOY_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.CHROMIUM_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.ANCIENT_MACHINERY);

        blockModelGenerators.createTrivialCube(ModBlocks.TRIDENT_HEAD);
        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.NAUTILUS_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.PRISMALLOY_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHROMIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MACHINED_SCRAP, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ANGLERFISH_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
    }
}
