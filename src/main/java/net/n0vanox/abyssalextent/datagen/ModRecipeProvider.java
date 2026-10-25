package net.n0vanox.abyssalextent.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.references.ItemIds;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.n0vanox.abyssalextent.block.ModBlocks;
import net.n0vanox.abyssalextent.item.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                List<ItemLike> CHROMIUM_SMELTABLES = List.of(ModItems.MACHINED_SCRAP, ModBlocks.ANCIENT_MACHINERY);
                oreBlasting(CHROMIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.CHROMIUM, 0.85f, 100, "chromium");
                oreSmelting(CHROMIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.CHROMIUM, 0.85f, 200, "chromium");

                shapeless(RecipeCategory.MISC, ModItems.PRISMALLOY_INGOT)
                        .requires(ModItems.CHROMIUM, 4)
                        .requires(Items.PRISMARINE_CRYSTALS, 4)
                        .unlockedBy(getHasName(ModItems.CHROMIUM), has(ModItems.CHROMIUM))
                        .group("prismalloy")
                        .save(output, "prismalloy_ingot_from_chromium");
                shaped(RecipeCategory.DECORATIONS, ModBlocks.NAUTILUS_BLOCK)
                        .pattern("SS")
                        .pattern("SS")
                        .define('S', Items.NAUTILUS_SHELL)
                        .unlockedBy(getHasName(Items.NAUTILUS_SHELL), has(Items.NAUTILUS_SHELL))
                        .save(output);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.CHROMIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHROMIUM_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.PRISMALLOY_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRISMALLOY_BLOCK);
                shaped(RecipeCategory.COMBAT, ModBlocks.TRIDENT_HEAD)
                        .pattern("SSS")
                        .pattern("PPP")
                        .define('S', Items.PRISMARINE_SHARD)
                        .define('P', ModItems.PRISMALLOY_INGOT)
                        .unlockedBy(getHasName(ModItems.PRISMALLOY_INGOT), has(ModItems.PRISMALLOY_INGOT))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Abyssal Extent Recipes";
    }
}
