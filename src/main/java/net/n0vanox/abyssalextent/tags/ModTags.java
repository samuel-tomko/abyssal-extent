package net.n0vanox.abyssalextent.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.n0vanox.abyssalextent.AbyssalExtent;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PRISMALLOY_TOOL = createTag("needs_prismalloy_tool");
        public static final TagKey<Block> INCORRECT_FOR_PRISMALLOY_TOOL = createTag("incorrect_for_prismalloy_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, AbyssalExtent.id(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PRISMALLOY_REPAIR =createTag("prismalloy_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, AbyssalExtent.id(name));
        }
    }
}
