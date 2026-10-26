package net.n0vanox.abyssalextent;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.resources.Identifier;

import net.n0vanox.abyssalextent.block.ModBlocks;
import net.n0vanox.abyssalextent.entity.ModEntities;
import net.n0vanox.abyssalextent.entity.client.AnglerfishModel;
import net.n0vanox.abyssalextent.entity.custom.AnglerfishEntity;
import net.n0vanox.abyssalextent.item.ModItems;
import net.n0vanox.creativemodetab.ModCreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbyssalExtent implements ModInitializer {
	public static final String MOD_ID = "abyssal-extent";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FabricDefaultAttributeRegistry.register(ModEntities.ANGLERFISH, AnglerfishEntity.createAttributes());
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
