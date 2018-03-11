package kx.simplecobblegen.tiles;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

import kx.simplecobblegen.config.ConfigClient;
import kx.simplecobblegen.inventory.GeneratorItemStackHandler;

/**
 * The Block-Generator Tile Entity class, extends {@link TileEntity} and implements {@link ITickable}.
 */
public class TileEntityBlockGenerator extends TileEntity implements ITickable {
	/** 
	 * The inventory. 
	 */
	protected GeneratorItemStackHandler	inventory;
	/**
	 * The archetype of the ItemStack which gets inserted every time the processCounter hits zero.
	 */
	private ItemStack					archetypeItemStack;
	/** 
	 * The amount of ticks between insert tries. 
	 */
	protected int						processTime;
	/**
	 * Internal counter to keep track of ticks until next inserting try. 
	 */
	private int							processCounter = 0;

	/**
	 * Constructor.
	 */
	public TileEntityBlockGenerator() {
		super();
	}

	/**
	 * Method to set the appropriate process parameter if the Tile Entity is first created. 
	 * Otherwise these will be loaded from the NBT-Data.
	 * @param pTier The Tier
	 * @param pMaterial The Material
	 * @return this (for chaining)
	 */
	public TileEntityBlockGenerator setTierAndMaterial(final int pTier, final Block pMaterial) {
		this.processTime = ConfigClient.getTier(pTier).processTime;
		this.archetypeItemStack = new ItemStack(pMaterial, ConfigClient.getTier(pTier).productCount);
		this.inventory = new GeneratorItemStackHandler(ConfigClient.getTier(pTier).slotNumber, ConfigClient.getTier(pTier).slotLimit);
		return this;
	}

	@Override
	public <T> T getCapability(final Capability<T> capability, @Nullable final EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this.inventory);
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public boolean hasCapability(final Capability<?> capability, @Nullable final EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@Override
	public void update() {
		if (this.world.isRemote) {
			return;
		}
		if(this.processCounter > 0) {
			this.processCounter--;
		}
		else {
			this.processCounter = this.processTime;
			if (!this.inventory.isInventoryFull()) {
				this.inventory.addToInventory(this.archetypeItemStack.copy());
				markDirty();
			}
		}
	}

	@Override
	public void readFromNBT(final NBTTagCompound compound) {
		super.readFromNBT(compound);
		loadDataFromNBT(compound);
	}

	/**
	 * Method to load the values for the custom variables.
	 * @param compound The {@link NBTTagCompound}
	 */
	private void loadDataFromNBT(final NBTTagCompound compound) {
		this.archetypeItemStack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("ArchetypeItemStack"));
		this.inventory = new GeneratorItemStackHandler(compound.getCompoundTag("GeneratorItemStackHandler"));
		this.processTime = compound.getByte("ProcessTime");
	}

	@Override
	public NBTTagCompound writeToNBT(final NBTTagCompound compound) {
		return saveDataToNBT(super.writeToNBT(compound));
	}

	/**
	 * Method to save the values of the custom variables.
	 * @param compound The {@link NBTTagCompound}
	 * @return The {@link NBTTagCompound}
	 */
	private NBTTagCompound saveDataToNBT(final NBTTagCompound compound) {
		compound.setTag("GeneratorItemStackHandler", this.inventory.serializeNBT());
		compound.setTag("ArchetypeItemStack", this.archetypeItemStack.writeToNBT(new NBTTagCompound()));
		compound.setByte("ProcessTime", (byte) this.processTime);
		return compound;
	}
}
