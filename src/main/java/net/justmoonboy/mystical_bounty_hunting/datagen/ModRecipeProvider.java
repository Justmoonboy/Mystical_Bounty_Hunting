package net.justmoonboy.mystical_bounty_hunting.datagen;

import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.justmoonboy.mystical_bounty_hunting.block.ModBlocks;
import net.justmoonboy.mystical_bounty_hunting.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> CELLESTIUM_SMELTABLES = List.of(ModItems.RAW_CELLESTIUM, ModBlocks.CELLESTIUM_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELLESTIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CELLESTIUM_INGOT.get())
                .unlockedBy("has_cellestium", has(ModItems.CELLESTIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CELLESTIUM_INGOT.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.CELLESTIUM_NUGGET.get())
                .unlockedBy("has_cellestium_nugget", has(ModItems.CELLESTIUM_NUGGET))
                .save(recipeOutput, "mysticalbountyhunting:cellestium_from_nugget");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CELLESTIUM_INGOT.get(), 9)
                .requires(ModBlocks.CELLESTIUM_BLOCK)
                .unlockedBy("has_cellestium_block", has(ModBlocks.CELLESTIUM_BLOCK.get()))
                .save(recipeOutput, "mysticalbountyhunting:cellestium_from_block");

        oreSmelting(recipeOutput, CELLESTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CELLESTIUM_INGOT.get(), 0.25f, 200, "cellestium");
        oreBlasting(recipeOutput, CELLESTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CELLESTIUM_INGOT.get(), 0.25f, 100, "cellestium");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MysticalBountyHunting.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
