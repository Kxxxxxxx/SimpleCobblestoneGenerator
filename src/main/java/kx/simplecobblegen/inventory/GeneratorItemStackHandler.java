package kx.simplecobblegen.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import kx.simplecobblegen.config.ConfigClient;
import kx.simplecobblegen.util.Log;

/**
 * Handler for the ItemStacks of the generator. It extends {@link ItemStackHandler}.
 */
public class GeneratorItemStackHandler extends ItemStackHandler {
	/**
	 * The maximum stack size for slots in this inventory.
	 */
	private int slotLimit;

	/**
	 * Constructs an empty Item-Handler with the specified number of slots and slot Limit.
	 *
	 * @param pSlotLimit The slot Limit.
	 * @param pSlots The number of slots
	 *
	 */
	public GeneratorItemStackHandler(final int pSlots, final int pSlotLimit) {
		super(pSlots);
		this.slotLimit = pSlotLimit;
	}

	/**
	 * Constructs the Item-Handler from a {@link NBTTagCompound}, setting the number of slots, slot Limit and the containing
	 * Items accordingly.
	 *
	 * @param compound The {@link NBTTagCompound}.
	 *
	 */
	public GeneratorItemStackHandler(final NBTTagCompound compound) {
		super();
		deserializeNBT(compound);
	}

	/**
	 * Method to add {@link ItemStack} to the inventory.
	 *
	 * @param pStack ItemStack to insert.
	 * @return The remaining ItemStack that was not inserted (if the entire stack is accepted, then return an empty
	 *         ItemStack). May be the same as the input ItemStack if unchanged, otherwise a new ItemStack. The returned
	 *         ItemStack can be safely modified after.
	 */
	public ItemStack addToInventory(ItemStack pStack) {
		if (pStack == null) {
			return pStack;
		}
		for (int i = 0; i < this.stacks.length; i++) {
			pStack = addToSlot(i, pStack);
			if (pStack == null || pStack.stackSize <= 0) {
				return null;
			}
		}
		return pStack;
	}

	@Override
	public void deserializeNBT(final NBTTagCompound nbt) {
		if (nbt.hasKey("SlotLimit")) {
			this.slotLimit = nbt.getInteger("SlotLimit");
		}
		else {
			Log.error("Encountered invalid value for slot limit of generator inventory! Fallback to Tier 1 slot limit.");
			this.slotLimit = ConfigClient.getTier(1).slotLimit;
		}
		super.deserializeNBT(nbt);
	}

	/**
	 * Convenient helper method that tries to extract an {@link ItemStack} from every Slot of the Inventory until the
	 * extracted ItemStack is not empty. The returned value must be empty if nothing is extracted, otherwise it's stack size
	 * must less be than amount and {@link ItemStack#getMaxStackSize()}.
	 *
	 * @param amount Amount to extract (may be greater than the current stacks max limit)
	 *
	 * @return ItemStack extracted from the slot, must be empty if nothing can be extracted. The returned ItemStack can be
	 *         safely modified after, so item handlers should return a new or copied stack.
	 */
	public ItemStack extractFirstItemStack(final int amount) {
		for (int i = 0; i < this.stacks.length; i++) {
			final ItemStack extracted = extractItem(i, amount, false);
			if (extracted != null && extracted.stackSize > 0) {
				return extracted;
			}
		}
		return null;
	}

	/**
	 * Convenient helper method that tries to extract an {@link ItemStack} from every Slot of the Inventory until the
	 * extracted ItemStack size is equal to desiredAmount or {@link ItemStack#getMaxStackSize()}. The returned value must be
	 * empty if nothing is extracted.
	 *
	 * @param desiredAmount Amount to extract (may be greater than the current stacks max limit)
	 *
	 * @return ItemStack extracted from the slot, must be empty if nothing can be extracted. The returned ItemStack can be
	 *         safely modified after, so item handlers should return a new or copied stack.
	 */
	public ItemStack extractFullItemStack(final int desiredAmount) {
		final int slots = this.stacks.length;
		int index = 0;
		ItemStack extractedStack = null;
		while (index < slots && (extractedStack == null || extractedStack.stackSize <= 0)) {
			extractedStack = extractItem(index, desiredAmount, false);
			index++;
		}
		if(extractedStack == null || extractedStack.stackSize <= 0) {
			return null;
		}
		final int maxAmount = Math.min(extractedStack.getMaxStackSize(), desiredAmount);
		int missingAmount = maxAmount - extractedStack.stackSize;
		while (index < slots && missingAmount > 0) {
			final ItemStack buf = extractItem(index, missingAmount, false);
			if (buf != null && buf.stackSize > 0) {
				extractedStack.stackSize += buf.stackSize;
				missingAmount = maxAmount - extractedStack.stackSize;
			}
			index++;
		}
		return extractedStack;
	}

	/**
	 * Method to count the stack sizes of every Inventory slot.
	 *
	 * @return Returns the sum of all stack sizes.
	 */
	public int getInventoryCount() {
		int buf = 0;
		for (final ItemStack stack : this.stacks) {
			if (stack != null && stack.stackSize > 0) {
				buf += stack.stackSize;
			}
		}
		return buf;
	}

	public int getSlotLimit(final int slot) {
		return this.slotLimit;
	}

	@Override
	public ItemStack insertItem(final int slot, final ItemStack stack, final boolean simulate) {
		return stack;
	}

	/**
	 * Convenient helper method to check if the Inventory is empty.
	 *
	 * @return True if Inventory is empty, false if not.
	 */
	public boolean isInventoryEmpty() {
		for (int index = 0; index < this.stacks.length; index++) {
			if (!isSlotEmpty(index)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Convenient helper method to check if the Inventory is full.
	 *
	 * @return True if Inventory is full, false if not.
	 */
	public boolean isInventoryFull() {
		for (int index = 0; index < this.stacks.length; index++) {
			if (!isSlotFull(index)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		final NBTTagCompound tagCompound = super.serializeNBT();
		tagCompound.setInteger("SlotLimit", this.slotLimit);
		return tagCompound;
	}

	/**
	 * An alternative to {@link ItemStackHandler#insertItem(int, ItemStack, boolean)}, as that method does nothing as means
	 * to disable Item inserting. Meant for internal use.
	 *
	 * @param pSlot Slot the ItemStack shall be inserted into.
	 * @param pStack ItemStack to insert. This must not be modified by the item handler.
	 * @return The remaining ItemStack that was not inserted (if the entire stack is accepted, then return an empty
	 *         ItemStack). May be the same as the input ItemStack if unchanged, otherwise a new ItemStack. The returned
	 *         ItemStack can be safely modified after.
	 */
	private ItemStack addToSlot(final int pSlot, final ItemStack pStack) {
		if (pStack == null || pStack.stackSize <= 0) {
			return null;
		}
		if (pSlot >= this.stacks.length) {
			return pStack;
		}

		final ItemStack existing = this.stacks[pSlot];

		int limit = Math.min(this.slotLimit, pStack.getMaxStackSize());

		if (existing != null && existing.stackSize > 0) {
			if (!ItemHandlerHelper.canItemStacksStack(pStack, existing)) {
				return pStack;
			}
			limit -= existing.stackSize;
		}
		if (limit <= 0) {
			return pStack;
		}
		final boolean reachedLimit = pStack.stackSize > limit;
		if (existing == null) {
			this.stacks[pSlot] = reachedLimit ? ItemHandlerHelper.copyStackWithSize(pStack, limit) : pStack;
		}
		else {
			existing.stackSize += reachedLimit ? limit : pStack.stackSize;
		}
		onContentsChanged(pSlot);

		return reachedLimit ? ItemHandlerHelper.copyStackWithSize(pStack, pStack.stackSize - limit) : null;
	}

	private boolean isSlotEmpty(final int pSlot) {
		return this.stacks[pSlot] == null;
	}

	private boolean isSlotFull(final int pSlot) {
		if(this.stacks[pSlot] == null) {
			return false;
		}
		return this.stacks[pSlot].stackSize >= Math.min(this.slotLimit, this.stacks[pSlot].getMaxStackSize());
	}

	@Override
	protected int getStackLimit(final int slot, final ItemStack stack) {
		return Math.min(this.slotLimit, stack.getMaxStackSize());
	}
}
