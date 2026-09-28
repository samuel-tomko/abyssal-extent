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
import net.minecraft.world.item.crafting.Recipe;
import net.n0vanox.abyssalextent.item.ModItems;

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
                shapeless(RecipeCategory.MISC, ModItems.PRISMALLOY_INGOT)
                        .requires(ModItems.CHROMIUM, 4)
                        .requires(Items.PRISMARINE_CRYSTALS, 4)
                        .unlockedBy(getHasName(ModItems.CHROMIUM), has(ModItems.CHROMIUM))
                        .group("prismalloy")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Abyssal Extent Recipes";
    }
}
