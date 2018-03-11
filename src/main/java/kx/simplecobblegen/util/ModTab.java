package kx.simplecobblegen.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import kx.simplecobblegen.init.BlockInitialization;

public class ModTab extends CreativeTabs {
	public ModTab(final String label) {
		super(label);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		if (BlockInitialization.GEN_COBBLE_TIER1 != null) {
			return new ItemStack(BlockInitialization.GEN_COBBLE_TIER1);
		}
		return new ItemStack(Items.LAVA_BUCKET); /** Fallback position */
	}
}
