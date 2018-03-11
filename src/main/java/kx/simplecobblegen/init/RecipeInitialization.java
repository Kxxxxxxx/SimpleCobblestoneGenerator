package kx.simplecobblegen.init;

import java.util.List;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

import kx.simplecobblegen.recipe.RecipeHandler;
import kx.simplecobblegen.util.BlockNames;
import kx.simplecobblegen.util.Log;

/**
 * Class to handle the Recipe initialization.
 */
public class RecipeInitialization {
	/**
	 * Method to initialize the Recipes.
	 *
	 * @return Returns a {@link List}{@code <}{@link IRecipe}{@code>} of the initialized Recipes.
	 */
	public static List<IRecipe> compileRecipes() {
		final RecipeHandler recipeHandler = new RecipeHandler();
		// ### TIER 1 ###
		// ### GEN_COBBLE_TIER1 ###
		final ResourceLocation groupCobbleT1 = new ResourceLocation(BlockNames.GEN_COBBLE_TIER1);
		recipeHandler.addBasicRecipe(groupCobbleT1, BlockInitialization.GEN_COBBLE_TIER1);
		recipeHandler.addPushVariantReverseRecipe(groupCobbleT1, BlockInitialization.GEN_COBBLE_TIER1, BlockInitialization.GEN_COBBLE_PUSH_TIER1);

		// ### GEN_STONE_TIER1 ###
		final ResourceLocation groupStoneT1 = new ResourceLocation(BlockNames.GEN_STONE_TIER1);
		recipeHandler.addStoneVariantRecipe(groupStoneT1, BlockInitialization.GEN_STONE_TIER1, BlockInitialization.GEN_COBBLE_TIER1);
		recipeHandler.addPushVariantReverseRecipe(groupStoneT1, BlockInitialization.GEN_STONE_TIER1, BlockInitialization.GEN_STONE_PUSH_TIER1);

		// ### GEN_COBBLE_PUSH_TIER1 ###
		final ResourceLocation groupCobblePushT1 = new ResourceLocation(BlockNames.GEN_COBBLE_PUSH_TIER1);
		recipeHandler.addPushVariantRecipe(groupCobblePushT1, BlockInitialization.GEN_COBBLE_PUSH_TIER1, BlockInitialization.GEN_COBBLE_TIER1);

		// ### GEN_STONE_PUSH_TIER1 ###
		final ResourceLocation groupStonePushT1 = new ResourceLocation(BlockNames.GEN_STONE_PUSH_TIER1);
		recipeHandler.addStoneVariantRecipe(groupStonePushT1, BlockInitialization.GEN_STONE_PUSH_TIER1, BlockInitialization.GEN_COBBLE_PUSH_TIER1);
		recipeHandler.addPushVariantRecipe(groupStonePushT1, BlockInitialization.GEN_STONE_PUSH_TIER1, BlockInitialization.GEN_STONE_TIER1);

		// ### TIER 2 ###
		// ### GEN_COBBLE_TIER2 ###
		final ResourceLocation groupCobbleT2 = new ResourceLocation(BlockNames.GEN_COBBLE_TIER2);
		recipeHandler.addUpgradeToTier2Recipe(groupCobbleT2, BlockInitialization.GEN_COBBLE_TIER2, BlockInitialization.GEN_COBBLE_TIER1);
		recipeHandler.addPushVariantReverseRecipe(groupCobbleT2, BlockInitialization.GEN_COBBLE_TIER2, BlockInitialization.GEN_COBBLE_PUSH_TIER2);

		// ### GEN_STONE_TIER2 ###
		final ResourceLocation groupStoneT2 = new ResourceLocation(BlockNames.GEN_STONE_TIER2);
		recipeHandler.addUpgradeToTier2Recipe(groupStoneT2, BlockInitialization.GEN_STONE_TIER2, BlockInitialization.GEN_STONE_TIER1);
		recipeHandler.addStoneVariantRecipe(groupStoneT2, BlockInitialization.GEN_STONE_TIER2, BlockInitialization.GEN_COBBLE_TIER2);
		recipeHandler.addPushVariantReverseRecipe(groupStoneT2, BlockInitialization.GEN_STONE_TIER2, BlockInitialization.GEN_STONE_PUSH_TIER2);

		// ### GEN_COBBLE_PUSH_TIER2 ###
		final ResourceLocation groupCobblePushT2 = new ResourceLocation(BlockNames.GEN_COBBLE_PUSH_TIER2);
		recipeHandler.addUpgradeToTier2Recipe(groupCobblePushT2, BlockInitialization.GEN_COBBLE_PUSH_TIER2, BlockInitialization.GEN_COBBLE_PUSH_TIER1);
		recipeHandler.addPushVariantRecipe(groupCobblePushT2, BlockInitialization.GEN_COBBLE_PUSH_TIER2, BlockInitialization.GEN_COBBLE_TIER2);

		// ### GEN_STONE_PUSH_TIER2 ###
		final ResourceLocation groupStonePushT2 = new ResourceLocation(BlockNames.GEN_STONE_PUSH_TIER2);
		recipeHandler.addUpgradeToTier2Recipe(groupStonePushT2, BlockInitialization.GEN_STONE_PUSH_TIER2, BlockInitialization.GEN_STONE_PUSH_TIER1);
		recipeHandler.addStoneVariantRecipe(groupStonePushT2, BlockInitialization.GEN_STONE_PUSH_TIER2, BlockInitialization.GEN_COBBLE_PUSH_TIER2);
		recipeHandler.addPushVariantRecipe(groupStonePushT2, BlockInitialization.GEN_STONE_PUSH_TIER2, BlockInitialization.GEN_STONE_TIER2);

		// ### TIER 3 ###
		// ### GEN_COBBLE_TIER3 ###
		final ResourceLocation groupCobbleT3 = new ResourceLocation(BlockNames.GEN_COBBLE_TIER3);
		recipeHandler.addUpgradeToTier3Recipe(groupCobbleT3, BlockInitialization.GEN_COBBLE_TIER3, BlockInitialization.GEN_COBBLE_TIER2);
		recipeHandler.addPushVariantReverseRecipe(groupCobbleT3, BlockInitialization.GEN_COBBLE_TIER3, BlockInitialization.GEN_COBBLE_PUSH_TIER3);

		// ### GEN_STONE_TIER3 ###
		final ResourceLocation groupStoneT3 = new ResourceLocation(BlockNames.GEN_STONE_TIER3);
		recipeHandler.addUpgradeToTier3Recipe(groupStoneT3, BlockInitialization.GEN_STONE_TIER3, BlockInitialization.GEN_STONE_TIER2);
		recipeHandler.addStoneVariantRecipe(groupStoneT3, BlockInitialization.GEN_STONE_TIER3, BlockInitialization.GEN_COBBLE_TIER3);
		recipeHandler.addPushVariantReverseRecipe(groupStoneT3, BlockInitialization.GEN_STONE_TIER3, BlockInitialization.GEN_STONE_PUSH_TIER3);

		// ### GEN_COBBLE_PUSH_TIER3 ###
		final ResourceLocation groupCobblePushT3 = new ResourceLocation(BlockNames.GEN_COBBLE_PUSH_TIER3);
		recipeHandler.addUpgradeToTier3Recipe(groupCobblePushT3, BlockInitialization.GEN_COBBLE_PUSH_TIER3, BlockInitialization.GEN_COBBLE_PUSH_TIER2);
		recipeHandler.addPushVariantRecipe(groupCobblePushT3, BlockInitialization.GEN_COBBLE_PUSH_TIER3, BlockInitialization.GEN_COBBLE_TIER3);

		// ### GEN_STONE_PUSH_TIER3 ###
		final ResourceLocation groupStonePushT3 = new ResourceLocation(BlockNames.GEN_STONE_PUSH_TIER3);
		recipeHandler.addUpgradeToTier3Recipe(groupStonePushT3, BlockInitialization.GEN_STONE_PUSH_TIER3, BlockInitialization.GEN_STONE_PUSH_TIER2);
		recipeHandler.addStoneVariantRecipe(groupStonePushT3, BlockInitialization.GEN_STONE_PUSH_TIER3, BlockInitialization.GEN_COBBLE_PUSH_TIER3);
		recipeHandler.addPushVariantRecipe(groupStonePushT3, BlockInitialization.GEN_STONE_PUSH_TIER3, BlockInitialization.GEN_STONE_TIER3);

		// ### TIER 4 ###
		// ### GEN_COBBLE_TIER4 ###
		final ResourceLocation groupCobbleT4 = new ResourceLocation(BlockNames.GEN_COBBLE_TIER4);
		recipeHandler.addUpgradeToTier4Recipe(groupCobbleT4, BlockInitialization.GEN_COBBLE_TIER4, BlockInitialization.GEN_COBBLE_TIER3);
		recipeHandler.addPushVariantReverseRecipe(groupCobbleT4, BlockInitialization.GEN_COBBLE_TIER4, BlockInitialization.GEN_COBBLE_PUSH_TIER4);

		// ### GEN_STONE_TIER4 ###
		final ResourceLocation groupStoneT4 = new ResourceLocation(BlockNames.GEN_STONE_TIER4);
		recipeHandler.addUpgradeToTier4Recipe(groupStoneT4, BlockInitialization.GEN_STONE_TIER4, BlockInitialization.GEN_STONE_TIER3);
		recipeHandler.addStoneVariantRecipe(groupStoneT4, BlockInitialization.GEN_STONE_TIER4, BlockInitialization.GEN_COBBLE_TIER4);
		recipeHandler.addPushVariantReverseRecipe(groupStoneT4, BlockInitialization.GEN_STONE_TIER4, BlockInitialization.GEN_STONE_PUSH_TIER4);

		// ### GEN_COBBLE_PUSH_TIER4 ###
		final ResourceLocation groupCobblePushT4 = new ResourceLocation(BlockNames.GEN_COBBLE_PUSH_TIER4);
		recipeHandler.addUpgradeToTier4Recipe(groupCobblePushT4, BlockInitialization.GEN_COBBLE_PUSH_TIER4, BlockInitialization.GEN_COBBLE_PUSH_TIER3);
		recipeHandler.addPushVariantRecipe(groupCobblePushT4, BlockInitialization.GEN_COBBLE_PUSH_TIER4, BlockInitialization.GEN_COBBLE_TIER4);

		// ### GEN_STONE_PUSH_TIER4 ###
		final ResourceLocation groupStonePushT4 = new ResourceLocation(BlockNames.GEN_STONE_PUSH_TIER4);
		recipeHandler.addUpgradeToTier4Recipe(groupStonePushT4, BlockInitialization.GEN_STONE_PUSH_TIER4, BlockInitialization.GEN_STONE_PUSH_TIER3);
		recipeHandler.addStoneVariantRecipe(groupStonePushT4, BlockInitialization.GEN_STONE_PUSH_TIER4, BlockInitialization.GEN_COBBLE_PUSH_TIER4);
		recipeHandler.addPushVariantRecipe(groupStonePushT4, BlockInitialization.GEN_STONE_PUSH_TIER4, BlockInitialization.GEN_STONE_TIER4);

		Log.info("%d recipes compiled.", recipeHandler.getRecipeCount());

		return recipeHandler.getRecipeList();
	}
}