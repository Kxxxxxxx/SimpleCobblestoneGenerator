package kx.simplecobblegen.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Handler to compile the Recipe Ingredients depending on availability.
 */
public class IngredientHandler {
	@ObjectHolder("thermalfoundation:material")
	public static final Item	thermalFoundationItemMaterial	= null;

	/**
	 * Constructor.
	 */
	public IngredientHandler() {
		this.redstoneServo	= putThermalFoundationItemMaterial("",				512,	new ItemStack(Blocks.PISTON));
		this.gearIron		= putThermalFoundationItemMaterial("gearIron",		24,		new ItemStack(Blocks.IRON_BLOCK));
		this.gearElectrum	= putThermalFoundationItemMaterial("gearElectrum",	289,	new ItemStack(Blocks.DIAMOND_BLOCK));
		this.gearSignalum	= putThermalFoundationItemMaterial("gearSignalum",	293,	new ItemStack(Blocks.EMERALD_BLOCK));
		this.dustPyrotheum	= putThermalFoundationItemMaterial("dustPyrotheum",	1024,	new ItemStack(Items.BLAZE_ROD));

		this.cobblestone	= putVanillaItem("cobblestone",	new ItemStack(Blocks.COBBLESTONE));
		this.obsidian		= putVanillaItem("obsidian",	new ItemStack(Blocks.OBSIDIAN));
		this.blockGlass		= putVanillaItem("blockGlass",	new ItemStack(Blocks.GLASS));
		this.water			= putVanillaItem("bucketWater",	new ItemStack(Items.WATER_BUCKET));
		this.lava			= putVanillaItem("bucketLava",	new ItemStack(Items.LAVA_BUCKET));
		this.piston			= putVanillaItem("",			new ItemStack(Blocks.PISTON));
		this.blockIron		= putVanillaItem("blockIron",	new ItemStack(Blocks.IRON_BLOCK));
	}

	private Object putThermalFoundationItemMaterial(final String pOreName, final int pMeta, final ItemStack pAlternative) {
		if (OreDictionary.doesOreNameExist(pOreName)) {
			return pOreName;
		}
		else if (IngredientHandler.thermalFoundationItemMaterial != null) {
			return new ItemStack(IngredientHandler.thermalFoundationItemMaterial, 1, pMeta);
		}
		else {
			return pAlternative;
		}
	}

	private Object putVanillaItem(final String pOreName, final ItemStack pItemStack) {
		if (OreDictionary.doesOreNameExist(pOreName)) {
			return pOreName;
		}
		else {
			return pItemStack;
		}
	}
	/**
	 * Ingredient <b>redstoneServo</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object redstoneServo;

	/**
	 * Ingredient <b>gearIron</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object gearIron;

	/**
	 * Ingredient <b>gearElectrum</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object gearElectrum;

	/**
	 * Ingredient <b>gearSignalum</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object gearSignalum;

	/**
	 * Ingredient <b>dustPyrotheum</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	dustPyrotheum;
	/**
	 * Ingredient <b>cobblestone</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	cobblestone;
	/**
	 * Ingredient <b>obsidian</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	obsidian;
	/**
	 * Ingredient <b>blockGlass</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	blockGlass;
	/**
	 * Ingredient <b>water</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	water;
	/**
	 * Ingredient <b>lava</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	lava;
	/**
	 * Ingredient <b>piston</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	piston;
	/**
	 * Ingredient <b>blockIron</b>. Type is either String If a OreDictionary Name exists or {@link ItemStack}.
	 */
	public final Object	blockIron;
}
