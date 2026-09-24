package net.n0vanox.abyssalextent;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.n0vanox.abyssalextent.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbyssalExtent implements ModInitializer {
	public static final String MOD_ID = "abyssal-extent";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
