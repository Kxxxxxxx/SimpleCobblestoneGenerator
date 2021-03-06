package kx.simplecobblegen.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import kx.simplecobblegen.util.Log;

/**
 * Recipe Handler.
 */
public class RecipeHandler {
	/** List of Recipes */
	private final List<IRecipe>		recipeList	= new ArrayList<IRecipe>();
	/** The Ingredient Handler. */
	private final IngredientHandler	ingredientHandler;

	/**
	 * Constructor.
	 */
	public RecipeHandler() {
		this.ingredientHandler = new IngredientHandler();
	}

	/**
	 * Generates and adds Recipe for the basic Generator.
	 *
	 * @param pGroup The group the recipe should belong to
	 * @param pBlock The crafting result
	 */
	public void addBasicRecipe(final ResourceLocation pGroup, final Block pOutput) {
		if (pOutput == null) {
			return;
		}
		final ResourceLocation baseBlockRegistryName = pOutput.getRegistryName();
		if (baseBlockRegistryName == null) {
			Log.warn("Failed to set recipe registry name for block %s.", pOutput.getUnlocalizedName());
			return;
		}
		final Object[] recipe = createBasicRecipe();
		if (recipe.length != 0) {
			this.recipeList.add(new ShapedOreRecipe(pGroup, pOutput, recipe).setRegistryName(baseBlockRegistryName));
		}
	}

	/**
	 * Generates and adds Recipe for the push variant of the Generator.
	 *
	 * @param pGroup The group the recipe should belong to
	 * @param pOutput The crafting result
	 * @param pInput The crafting input
	 */
	public void addPushVariantRecipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput) {
		addShapedRecipe(pGroup, pOutput, pInput, createPushVariantRecipe(pInput));
	}

	/**
	 * Generates and adds a reserve Recipe for the push variant of the Generator.
	 * 
	 * @param pGroup The group the recipe should belong to
	 * @param pOutput The crafting result
	 * @param pInput The crafting input
	 */
	public void addPushVariantReverseRecipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput) {
		final ResourceLocation registryName = compileRegistryName(pOutput, pInput);
		if (registryName == null) {
			return;
		}
		this.recipeList.add(new ShapelessOreRecipe(pGroup, new ItemStack(pOutput), new Object[] { new ItemStack(pInput) }).setRegistryName(registryName));
	}

	/**
	 * Generates and adds Recipe for the stone variant of the Generator.
	 *
	 * @param pGroup The group the recipe should belong to
	 * @param pOutput The crafting result
	 * @param pInput The crafting input
	 */
	public void addStoneVariantRecipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput) {
		addShapedRecipe(pGroup, pOutput, pInput, createStoneVariantRecipe(pInput));
	}

	/**
	 * Generates and adds Recipe for the tier 2 upgrade of the Generator.
	 *
	 * @param pGroup The group the recipe should belong to
	 * @param pOutput The crafting result
	 * @param pInput The crafting input
	 */
	public void addUpgradeToTier2Recipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput) {
		addShapedRecipe(pGroup, pOutput, pInput, createUpgradeToTier2Recipe(pInput));
	}

	/**
	 * Generates and adds Recipe for the tier 3 upgrade of the Generator.
	 *
	 * @param pGroup The group the recipe should belong to
	 * @param pOutput The crafting result
	 * @param pInput The crafting input
	 */
	public void addUpgradeToTier3Recipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput) {
		addShapedRecipe(pGroup, pOutput, pInput, createUpgradeToTier3Recipe(pInput));
	}

	/**
	 * Generates and adds Recipe for the tier 4 upgrade of the Generator.
	 *
	 * @param pGroup The group the recipe should belong to
	 * @param pOutput The crafting result
	 * @param pInput The crafting input
	 */
	public void addUpgradeToTier4Recipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput) {
		addShapedRecipe(pGroup, pOutput, pInput, createUpgradeToTier4Recipe(pInput));
	}

	/**
	 * Method to get the size of the underlying {@link List}.
	 * 
	 * @return Returns the size of the underlying {@link List}
	 */
	public int getRecipeCount() {
		return this.recipeList.size();
	}

	/**
	 * Method to get the underlying {@link List}.
	 * 
	 * @return Returns the underlying {@link List}
	 */
	public List<IRecipe> getRecipeList() {
		return this.recipeList;
	}

	private void addShapedRecipe(final ResourceLocation pGroup, final Block pOutput, final Block pInput, final Object[] pRecipe) {
		if (pRecipe.length == 0) {
			Log.warn("Failed to create recipe for block %s.", pOutput.getUnlocalizedName());
			return;
		}
		final ResourceLocation registryName = compileRegistryName(pOutput, pInput);
		if (registryName == null) {
			return;
		}
		this.recipeList.add(new ShapedOreRecipe(pGroup, pOutput, pRecipe).setRegistryName(registryName));
	}

	private ResourceLocation compileRegistryName(final Block pOutput, final Block pInput) {
		if (pOutput == null || pInput == null) {
			return null;
		}
		final ResourceLocation outputBlockRegistryName = pOutput.getRegistryName();
		final ResourceLocation inputBlockRegistryName = pInput.getRegistryName();
		if (outputBlockRegistryName == null || inputBlockRegistryName == null) {
			final String blockName = outputBlockRegistryName != null ? pOutput.getUnlocalizedName() : pInput.getUnlocalizedName();
			Log.warn("Failed to set recipe registry name for block %s.", blockName);
			return null;
		}
		final String path = outputBlockRegistryName.getResourcePath() + "_from_" + inputBlockRegistryName.getResourcePath();
		return new ResourceLocation(pOutput.getRegistryName().getResourceDomain(), path);
	}

	private Object[] createBasicRecipe() {
		return new Object[] {
			"OCO",
			"WGL",
			"OCO",
			'O', this.ingredientHandler.obsidian,
			'C', this.ingredientHandler.cobblestone,
			'W', this.ingredientHandler.water,
			'L', this.ingredientHandler.lava,
			'G', this.ingredientHandler.blockGlass
		};
	}

	private Object[] createStoneVariantRecipe(final Block pInput) {
		return new Object[] {
			"gpg",
			"pGp",
			"gpg",
			'p', this.ingredientHandler.dustPyrotheum,
			'g', this.ingredientHandler.gearIron,
			'G', new ItemStack(pInput) };
	}

	private Object[] createPushVariantRecipe(final Block pInput) {
		return new Object[] {
			"sps",
			"gGg",
			"IgI",
			's', this.ingredientHandler.redstoneServo,
			'p', this.ingredientHandler.piston,
			'g', this.ingredientHandler.gearIron,
			'I', this.ingredientHandler.blockIron,
			'G', new ItemStack(pInput)
		};
	}

	private Object[] createUpgradeToTier2Recipe(final Block pInput) {
		return new Object[] {
			"gsg",
			"sGs",
			"gsg",
			'g', this.ingredientHandler.gearIron,
			's', this.ingredientHandler.redstoneServo,
			'G', new ItemStack(pInput)
		};
	}

	private Object[] createUpgradeToTier3Recipe(final Block pInput) {
		return new Object[] {
			"gsg",
			"sGs",
			"gsg",
			'g', this.ingredientHandler.gearElectrum,
			's', this.ingredientHandler.redstoneServo,
			'G', new ItemStack(pInput)
		};
	}

	private Object[] createUpgradeToTier4Recipe(final Block pInput) {
		return new Object[] {
			"gsg",
			"sGs",
			"gsg",
			'g', this.ingredientHandler.gearSignalum,
			's', this.ingredientHandler.redstoneServo,
			'G', new ItemStack(pInput)
		};
	}
}
