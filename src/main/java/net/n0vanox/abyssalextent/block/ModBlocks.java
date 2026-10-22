package net.n0vanox.abyssalextent.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.minecraft.world.level.block.Block;
import net.n0vanox.abyssalextent.block.custom.NautilusBlock;
import net.n0vanox.abyssalextent.block.custom.TridentHead;

import java.util.function.Function;

public class ModBlocks {
    public static final Block NAUTILUS_BLOCK = registerBlock("nautilus_block", properties -> new NautilusBlock(properties.strength(2.0F)
            .requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK).instrument(NoteBlockInstrument.XYLOPHONE).mapColor(MapColor.TERRACOTTA_ORANGE)
    ));
    public static final Block PRISMALLOY_BLOCK = registerBlock("prismalloy_block", properties -> new Block(properties.strength(6.0F)
            .requiresCorrectToolForDrops().sound(SoundType.METAL).instrument(NoteBlockInstrument.CHIME).mapColor(MapColor.ICE)
    ));
    public static final Block CHROMIUM_BLOCK = registerBlock("chromium_block", properties -> new Block(properties.strength(6.0F)
            .requiresCorrectToolForDrops().sound(SoundType.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).mapColor(MapColor.METAL)
    ));
    public static final Block ANCIENT_MACHINERY = registerBlock("ancient_machinery", properties -> new Block(properties.strength(8.0F)
            .requiresCorrectToolForDrops().sound(SoundType.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).mapColor(MapColor.METAL)
    ));
    public static final Block TRIDENT_HEAD = registerBlock("trident_head", properties -> new TridentHead(properties.strength(1.0F)
            .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_WART_BLOCK)
    ));
    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        AbyssalExtent.LOGGER.info("Registering Mod Blocks for " + AbyssalExtent.MOD_ID);
    }
}
