package kx.simplecobblegen.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import kx.simplecobblegen.blocks.BlockGenerator;
import kx.simplecobblegen.blocks.PushBlockGenerator;
import kx.simplecobblegen.util.BlockNames;
import kx.simplecobblegen.util.Log;

/**
 * Class to initialize and hold this mod's Blocks.
 */
public class BlockInitialization {
	/**
	 * Holder for the Block "{@code GEN_COBBLE_TIER1}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_TIER1)
	public static final Block	GEN_COBBLE_TIER1	= null;
	/**
	 * Holder for the Block "{@code GEN_COBBLE_TIER2}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_TIER2)
	public static final Block	GEN_COBBLE_TIER2	= null;
	/**
	 * Holder for the Block "{@code GEN_COBBLE_TIER3}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_TIER3)
	public static final Block	GEN_COBBLE_TIER3	= null;
	/**
	 * Holder for the Block "{@code GEN_COBBLE_TIER4}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_TIER4)
	public static final Block	GEN_COBBLE_TIER4	= null;

	/**
	 * Holder for the Block "{@code GEN_STONE_TIER1}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_TIER1)
	public static final Block	GEN_STONE_TIER1	= null;
	/**
	 * Holder for the Block "{@code GEN_STONE_TIER2}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_TIER2)
	public static final Block	GEN_STONE_TIER2	= null;
	/**
	 * Holder for the Block "{@code GEN_STONE_TIER3}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_TIER3)
	public static final Block	GEN_STONE_TIER3	= null;
	/**
	 * Holder for the Block "{@code GEN_STONE_TIER4}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_TIER4)
	public static final Block	GEN_STONE_TIER4	= null;

	/**
	 * Holder for the Block "{@code GEN_COBBLE_PUSH_TIER1}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_PUSH_TIER1)
	public static final Block	GEN_COBBLE_PUSH_TIER1	= null;
	/**
	 * Holder for the Block "{@code GEN_COBBLE_PUSH_TIER2}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_PUSH_TIER2)
	public static final Block	GEN_COBBLE_PUSH_TIER2	= null;
	/**
	 * Holder for the Block "{@code GEN_COBBLE_PUSH_TIER3}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_PUSH_TIER3)
	public static final Block	GEN_COBBLE_PUSH_TIER3	= null;
	/**
	 * Holder for the Block "{@code GEN_COBBLE_PUSH_TIER4}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_COBBLE_PUSH_TIER4)
	public static final Block	GEN_COBBLE_PUSH_TIER4	= null;

	/**
	 * Holder for the Block "{@code GEN_STONE_PUSH_TIER1}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_PUSH_TIER1)
	public static final Block	GEN_STONE_PUSH_TIER1	= null;
	/**
	 * Holder for the Block "{@code GEN_STONE_PUSH_TIER2}".
	 * Forge will injected the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_PUSH_TIER2)
	public static final Block	GEN_STONE_PUSH_TIER2	= null;
	/**
	 * Holder for the Block "{@code GEN_STONE_PUSH_TIER3}".
	 * Forge will inject the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_PUSH_TIER3)
	public static final Block	GEN_STONE_PUSH_TIER3	= null;
	/**
	 * Holder for the Block "{@code GEN_STONE_PUSH_TIER4}".
	 * Forge will inject the value automatically from the registry after the the {@code Register<Block>} event has fired.
	 * The value will also be refreshed after {@code Register<Item>} has fired.
	 * The value will be refreshed for a third time after all of the other {@code Register} events have fired.
	 */
	@ObjectHolder(BlockNames.GEN_STONE_PUSH_TIER4)
	public static final Block	GEN_STONE_PUSH_TIER4	= null;

	/**
	 * Method to actually initialize the Blocks.
	 * @return Returns a {@link List}{@code <}{@link Block}{@code>} of the initialized Blocks.
	 */
	public static List<Block> initializeBlocks() {
		final List<Block> blockList = new ArrayList<Block>();
		// ### tier 1 ###
		blockList.add(new BlockGenerator(BlockNames.GEN_COBBLE_TIER1, 1, Blocks.COBBLESTONE));
		blockList.add(new BlockGenerator(BlockNames.GEN_STONE_TIER1, 1, Blocks.STONE));
		
		blockList.add(new PushBlockGenerator(BlockNames.GEN_COBBLE_PUSH_TIER1, 1, Blocks.COBBLESTONE));
		blockList.add(new PushBlockGenerator(BlockNames.GEN_STONE_PUSH_TIER1, 1, Blocks.STONE));
		// ### tier 2 ###
		blockList.add(new BlockGenerator(BlockNames.GEN_COBBLE_TIER2, 2, Blocks.COBBLESTONE));
		blockList.add(new BlockGenerator(BlockNames.GEN_STONE_TIER2, 2, Blocks.STONE));
		
		blockList.add(new PushBlockGenerator(BlockNames.GEN_COBBLE_PUSH_TIER2, 2, Blocks.COBBLESTONE));
		blockList.add(new PushBlockGenerator(BlockNames.GEN_STONE_PUSH_TIER2, 2, Blocks.STONE));
		// ### tier 3 ###
		blockList.add(new BlockGenerator(BlockNames.GEN_COBBLE_TIER3, 3, Blocks.COBBLESTONE));
		blockList.add(new BlockGenerator(BlockNames.GEN_STONE_TIER3, 3, Blocks.STONE));
		
		blockList.add(new PushBlockGenerator(BlockNames.GEN_COBBLE_PUSH_TIER3, 3, Blocks.COBBLESTONE));
		blockList.add(new PushBlockGenerator(BlockNames.GEN_STONE_PUSH_TIER3, 3, Blocks.STONE));
		// ### tier 4 ###
		blockList.add(new BlockGenerator(BlockNames.GEN_COBBLE_TIER4, 4, Blocks.COBBLESTONE));
		blockList.add(new BlockGenerator(BlockNames.GEN_STONE_TIER4, 4, Blocks.STONE));
		
		blockList.add(new PushBlockGenerator(BlockNames.GEN_COBBLE_PUSH_TIER4, 4, Blocks.COBBLESTONE));
		blockList.add(new PushBlockGenerator(BlockNames.GEN_STONE_PUSH_TIER4, 4, Blocks.STONE));

		Log.info("%d blocks initialized.", blockList.size());
		return blockList;
	}
}
