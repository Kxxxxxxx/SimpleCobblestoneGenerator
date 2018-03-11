package kx.simplecobblegen.tiles;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * The push variant of {@link TileEntityBlockGenerator}. Adds the push feature to {@link ITickable#update()}.
 */
public class TileEntityPushBlockGenerator extends TileEntityBlockGenerator {
	/**
	 * The amount of Items to be moved at once.
	 */
	protected final int	moveQuantity	= 32;
	/** 
	 * The amount of ticks between moves. 
	 */
	protected int		moveTime;
	/**
	 * Internal counter to keep track of ticks until next move try. 
	 */
	private int			moveCounter		= 0;

	/**
	 * Constructor.
	 */
	public TileEntityPushBlockGenerator() {
		super();
	}

	@Override
	public TileEntityBlockGenerator setTierAndMaterial(final int pTier, final Block pMaterial) {
		super.setTierAndMaterial(pTier, pMaterial);
		this.moveTime = this.processTime > 10 ? this.processTime : 10;
		return this;
	}

	@Override
	public void update() {
		super.update();
		if(this.moveCounter > 0) {
			this.moveCounter--;
		}
		else {
			this.moveCounter = this.moveTime;
			if (!this.inventory.isInventoryEmpty() && moveItemToInventoryAbove()) {
				markDirty();
			}
		}
	}

	/**
	 * Method that moves Items from the generator to the Inventory of the Block above if there is a valid Inventory
	 * @return True if Inventory of the generator changed, false if not
	 */
	protected boolean moveItemToInventoryAbove() {
		final TileEntity tile = this.world.getTileEntity(this.pos.offset(EnumFacing.UP));
		if (tile != null) {
			final IItemHandler tileItemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
			if (tileItemHandler != null) {
				final ItemStack stack = ItemHandlerHelper.insertItem(tileItemHandler, this.inventory.extractFirstItemStack(this.moveQuantity), false);
				if (stack != null && stack.stackSize > 0) {
					this.inventory.addToInventory(stack);
				}
				return true;
			}
		}
		return false;
	}
}
