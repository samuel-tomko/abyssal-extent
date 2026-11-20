package net.n0vanox.abyssalextent;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.resources.Identifier;

import net.n0vanox.abyssalextent.block.ModBlocks;
import net.n0vanox.abyssalextent.datagen.ModCarvers;
import net.n0vanox.abyssalextent.entity.ModEntities;
import net.n0vanox.abyssalextent.entity.client.AnglerfishModel;
import net.n0vanox.abyssalextent.entity.custom.AnglerfishEntity;
import net.n0vanox.abyssalextent.item.ModItems;
import net.n0vanox.abyssalextent.worldgen.biome.ModBiomes;
import net.n0vanox.abyssalextent.worldgen.biome.ModMaterialRules;
import net.n0vanox.abyssalextent.worldgen.gen.ModWorldGeneration;
import net.n0vanox.creativemodetab.ModCreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.MaterialRuleManager;
import terrablender.api.TerraBlenderApi;

public class AbyssalExtent implements ModInitializer, TerraBlenderApi {
	public static final String MOD_ID = "abyssal-extent";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.ANGLERFISH, AnglerfishEntity.createAttributes());
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onTerraBlenderInitialized() {
		ModBiomes.registerBiomes();
		MaterialRuleManager.addRules(MaterialRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModMaterialRules::makeModOverworldRules);
	}
}
