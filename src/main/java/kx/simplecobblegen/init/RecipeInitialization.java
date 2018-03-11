package kx.simplecobblegen.init;

import java.util.List;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

import kx.simplecobblegen.recipe.RecipeHandler;
import kx.simplecobblegen.util.Log;

/**
 * Class to handle the Recipe initialization.
 */
public class RecipeInitialization {
	/**
	 * List of the compiled recipes. 
	 */
	public static List<IRecipe> recipeList;
	/**
	 * Method to register this mod's recipes.
	 */
	public static void registerRecipes() {
		Log.debug("REGISTER-RECIPES START");
		// compile recipe list
		recipeList = RecipeInitialization.compileRecipes();
		// save registry count (before registering) for logging
		final int registryCountBefore = CraftingManager.getInstance().getRecipeList().size();
		// loop through recipeList and register each one if it is missing a registry name skip it and log an error
		for (final IRecipe recipe : recipeList) {
			 GameRegistry.addRecipe(recipe);
		}
		// log the amount of blocks registered
		Log.info("Added %d recipe entries to Registry.", CraftingManager.getInstance().getRecipeList().size() - registryCountBefore);
		Log.debug("REGISTER-RECIPES END");
	}

	/**
	 * Method to initialize the Recipes.
	 *
	 * @return Returns a {@link List}{@code <}{@link IRecipe}{@code>} of the initialized Recipes.
	 */
	private static List<IRecipe> compileRecipes() {
		final RecipeHandler recipeHandler = new RecipeHandler();
		// ### TIER 1 ###
		// ### GEN_COBBLE_TIER1 ###
		recipeHandler.addBasicRecipe(BlockInitialization.GEN_COBBLE_TIER1);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_COBBLE_TIER1, BlockInitialization.GEN_COBBLE_PUSH_TIER1);

		// ### GEN_STONE_TIER1 ###
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_TIER1, BlockInitialization.GEN_COBBLE_TIER1);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_STONE_TIER1, BlockInitialization.GEN_STONE_PUSH_TIER1);

		// ### GEN_COBBLE_PUSH_TIER1 ###
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_COBBLE_PUSH_TIER1, BlockInitialization.GEN_COBBLE_TIER1);

		// ### GEN_STONE_PUSH_TIER1 ###
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER1, BlockInitialization.GEN_COBBLE_PUSH_TIER1);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER1, BlockInitialization.GEN_STONE_TIER1);

		// ### TIER 2 ###
		// ### GEN_COBBLE_TIER2 ###
		recipeHandler.addUpgradeToTier2Recipe(BlockInitialization.GEN_COBBLE_TIER2, BlockInitialization.GEN_COBBLE_TIER1);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_COBBLE_TIER2, BlockInitialization.GEN_COBBLE_PUSH_TIER2);

		// ### GEN_STONE_TIER2 ###
		recipeHandler.addUpgradeToTier2Recipe(BlockInitialization.GEN_STONE_TIER2, BlockInitialization.GEN_STONE_TIER1);
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_TIER2, BlockInitialization.GEN_COBBLE_TIER2);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_STONE_TIER2, BlockInitialization.GEN_STONE_PUSH_TIER2);

		// ### GEN_COBBLE_PUSH_TIER2 ###
		recipeHandler.addUpgradeToTier2Recipe(BlockInitialization.GEN_COBBLE_PUSH_TIER2, BlockInitialization.GEN_COBBLE_PUSH_TIER1);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_COBBLE_PUSH_TIER2, BlockInitialization.GEN_COBBLE_TIER2);

		// ### GEN_STONE_PUSH_TIER2 ###
		recipeHandler.addUpgradeToTier2Recipe(BlockInitialization.GEN_STONE_PUSH_TIER2, BlockInitialization.GEN_STONE_PUSH_TIER1);
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER2, BlockInitialization.GEN_COBBLE_PUSH_TIER2);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER2, BlockInitialization.GEN_STONE_TIER2);

		// ### TIER 3 ###
		// ### GEN_COBBLE_TIER3 ###
		recipeHandler.addUpgradeToTier3Recipe(BlockInitialization.GEN_COBBLE_TIER3, BlockInitialization.GEN_COBBLE_TIER2);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_COBBLE_TIER3, BlockInitialization.GEN_COBBLE_PUSH_TIER3);

		// ### GEN_STONE_TIER3 ###
		recipeHandler.addUpgradeToTier3Recipe(BlockInitialization.GEN_STONE_TIER3, BlockInitialization.GEN_STONE_TIER2);
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_TIER3, BlockInitialization.GEN_COBBLE_TIER3);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_STONE_TIER3, BlockInitialization.GEN_STONE_PUSH_TIER3);

		// ### GEN_COBBLE_PUSH_TIER3 ###
		recipeHandler.addUpgradeToTier3Recipe(BlockInitialization.GEN_COBBLE_PUSH_TIER3, BlockInitialization.GEN_COBBLE_PUSH_TIER2);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_COBBLE_PUSH_TIER3, BlockInitialization.GEN_COBBLE_TIER3);

		// ### GEN_STONE_PUSH_TIER3 ###
		recipeHandler.addUpgradeToTier3Recipe(BlockInitialization.GEN_STONE_PUSH_TIER3, BlockInitialization.GEN_STONE_PUSH_TIER2);
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER3, BlockInitialization.GEN_COBBLE_PUSH_TIER3);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER3, BlockInitialization.GEN_STONE_TIER3);

		// ### TIER 4 ###
		// ### GEN_COBBLE_TIER4 ###
		recipeHandler.addUpgradeToTier4Recipe(BlockInitialization.GEN_COBBLE_TIER4, BlockInitialization.GEN_COBBLE_TIER3);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_COBBLE_TIER4, BlockInitialization.GEN_COBBLE_PUSH_TIER4);

		// ### GEN_STONE_TIER4 ###
		recipeHandler.addUpgradeToTier4Recipe(BlockInitialization.GEN_STONE_TIER4, BlockInitialization.GEN_STONE_TIER3);
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_TIER4, BlockInitialization.GEN_COBBLE_TIER4);
		recipeHandler.addPushVariantReverseRecipe(BlockInitialization.GEN_STONE_TIER4, BlockInitialization.GEN_STONE_PUSH_TIER4);

		// ### GEN_COBBLE_PUSH_TIER4 ###
		recipeHandler.addUpgradeToTier4Recipe(BlockInitialization.GEN_COBBLE_PUSH_TIER4, BlockInitialization.GEN_COBBLE_PUSH_TIER3);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_COBBLE_PUSH_TIER4, BlockInitialization.GEN_COBBLE_TIER4);

		// ### GEN_STONE_PUSH_TIER4 ###
		recipeHandler.addUpgradeToTier4Recipe(BlockInitialization.GEN_STONE_PUSH_TIER4, BlockInitialization.GEN_STONE_PUSH_TIER3);
		recipeHandler.addStoneVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER4, BlockInitialization.GEN_COBBLE_PUSH_TIER4);
		recipeHandler.addPushVariantRecipe(BlockInitialization.GEN_STONE_PUSH_TIER4, BlockInitialization.GEN_STONE_TIER4);

		Log.info("%d recipes compiled.", recipeHandler.getRecipeCount());

		return recipeHandler.getRecipeList();
	}
}