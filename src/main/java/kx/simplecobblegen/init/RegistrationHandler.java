package kx.simplecobblegen.init;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import kx.simplecobblegen.SimpleCobblestoneGenerator;
import kx.simplecobblegen.tiles.TileEntityBlockGenerator;
import kx.simplecobblegen.tiles.TileEntityPushBlockGenerator;
import kx.simplecobblegen.util.Log;

/**
 * The Handler for the registration of this mod's Blocks, Items and Recipes.
 */
@Mod.EventBusSubscriber(modid = SimpleCobblestoneGenerator.MODID)
public final class RegistrationHandler {
	// ### variables ###
	/**
	 * List of the initialized blocks. 
	 */
	public static final List<Block>		blockList	= BlockInitialization.initializeBlocks();
	/**
	 * List of the items including the the ItemBlocks. 
	 */
	public static final List<ItemBlock>	itemList	= new ArrayList<ItemBlock>();
	/**
	 * List of the compiled recipes. 
	 */
	public static List<IRecipe> recipeList;

	/**
	 * Event subscriber to register this mod's blocks.
	 * @param event The {@link Register}{@code<}{@link Block}{@code>} event
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		Log.debug("REGISTER-BLOCKS START");
		// get registry
		final IForgeRegistry<Block> registry = event.getRegistry();
		// save registry count (before registering) for logging
		final int registryCountBefore = registry.getValuesCollection().size();
		// loop through blocks and register if it is missing a registry name skip it and log an error
		for (final Iterator<Block> iterator = RegistrationHandler.blockList.iterator(); iterator.hasNext();) {
			final Block block = iterator.next();
			if (block.getRegistryName() != null) {
				registry.register(block);
			}
			else {
				iterator.remove();
				Log.error("Can't use a null-name for the registry, Block: %s.", block.getUnlocalizedName());
			}
		}
		// log the amount of blocks registered
		Log.info("Added %d block entries to Registry.", registry.getValuesCollection().size() - registryCountBefore);
		Log.debug("REGISTER-BLOCKS END");
	}

	/**
	 * Event subscriber to register this mod's items.
	 * @param event The {@link Register}{@code<}{@link Item}{@code>} event
	 */
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
		Log.debug("REGISTER-ITEMBLOCKS START");
		// get registry
		final IForgeRegistry<Item> registry = event.getRegistry();
		// save registry count (before registering) for logging
		final int registryCountBefore = registry.getValuesCollection().size();
		// loop through blockList and register for each block the corresponding item if the block is missing a registry name skip it and log an error
		for (final Block block : RegistrationHandler.blockList) {
			final ItemBlock item = new ItemBlock(block);
			final ResourceLocation registryName = block.getRegistryName();
			if (registryName != null) {
				registry.register(item.setRegistryName(registryName));
				RegistrationHandler.itemList.add(item);
			}
			else {
				Log.error("Can't use a null-name for the registry, Block: %s.", block.getUnlocalizedName());
			}
		}
		// log the amount of blocks registered
		Log.info("Added %d item entries to Registry.", registry.getValuesCollection().size() - registryCountBefore);
		Log.debug("REGISTER-ITEMBLOCKS END");
		// ### register tile entities ###
		RegistrationHandler.registerTileEntities();
	}

	/**
	 * Event subscriber to register this mod's recipes.
	 * @param event The {@link Register}{@code<}{@link IRecipe}{@code>} event
	 */
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		Log.debug("REGISTER-RECIPES START");
		// compile recipe list
		recipeList = RecipeInitialization.compileRecipes();
		// get registry
		final IForgeRegistry<IRecipe> registry = event.getRegistry();
		// save registry count (before registering) for logging
		final int registryCountBefore = registry.getValuesCollection().size();		
		// loop through recipeList and register each one if it is missing a registry name skip it and log an error
		for (final IRecipe recipe : recipeList) {
			if (recipe.getRegistryName() != null) {
				registry.register(recipe);
			}
			else {
				Log.error("Can't use a null-name for the registry.");
			}
		}
		// log the amount of blocks registered
		Log.info("Added %d recipe entries to Registry.", registry.getValuesCollection().size() - registryCountBefore);
		Log.debug("REGISTER-RECIPES END");
	}

	/**
	 * Method to register this mod's tile entities. 
	 */
	private static void registerTileEntities() {
		Log.debug("REGISTER-TILEENTITIES START");
		int counter = 0;
		if (	   BlockInitialization.GEN_COBBLE_TIER1 != null 
				|| BlockInitialization.GEN_COBBLE_TIER2 != null 
				|| BlockInitialization.GEN_COBBLE_TIER3 != null 
				|| BlockInitialization.GEN_COBBLE_TIER4 != null
				|| BlockInitialization.GEN_STONE_TIER1 != null 
				|| BlockInitialization.GEN_STONE_TIER2 != null 
				|| BlockInitialization.GEN_STONE_TIER3 != null
				|| BlockInitialization.GEN_STONE_TIER4 != null) {
			GameRegistry.registerTileEntity(TileEntityBlockGenerator.class, SimpleCobblestoneGenerator.MODID + ":tile_entity_generator");
			counter++;
		}
		if (	   BlockInitialization.GEN_COBBLE_PUSH_TIER2 != null 
				|| BlockInitialization.GEN_COBBLE_PUSH_TIER2 != null 
				|| BlockInitialization.GEN_COBBLE_PUSH_TIER2 != null
				|| BlockInitialization.GEN_COBBLE_PUSH_TIER2 != null 
				|| BlockInitialization.GEN_STONE_PUSH_TIER2 != null 
				|| BlockInitialization.GEN_STONE_PUSH_TIER2 != null
				|| BlockInitialization.GEN_STONE_PUSH_TIER2 != null 
				|| BlockInitialization.GEN_STONE_PUSH_TIER2 != null) {
			GameRegistry.registerTileEntity(TileEntityPushBlockGenerator.class, SimpleCobblestoneGenerator.MODID + ":tile_entity_push_generator");
			counter++;
		}
		// log the amount of blocks registered
		Log.info("Added %d tile entity entries to Registry.", counter);
		Log.debug("REGISTER-TILEENTITIES END");
	}
}
