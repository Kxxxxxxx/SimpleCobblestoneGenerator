package kx.simplecobblegen;

import java.util.Map;

import javax.annotation.Nonnull;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;

import kx.simplecobblegen.init.RecipeInitialization;
import kx.simplecobblegen.network.NetworkWrapper;
import kx.simplecobblegen.util.Log;
import kx.simplecobblegen.util.ModTab;

@Mod(modid = SimpleCobblestoneGenerator.MODID, name = SimpleCobblestoneGenerator.MODNAME, version = SimpleCobblestoneGenerator.VERSION, acceptedMinecraftVersions = SimpleCobblestoneGenerator.MCVERSION)
public class SimpleCobblestoneGenerator {
	/**
	 * The ID of the mod.
	 */
	public static final @Nonnull String	MODID		= "simplecobblegen";
	/**
	 * The Name of the mod.
	 */
	public static final @Nonnull String	MODNAME		= "Simple Cobblestone Generator";
	/**
	 * The Version of this mod.
	 */
	public static final @Nonnull String	VERSION		= "@VERSION@";
	/**
	 * The range of Minecraft versions this mod will load and run with.
	 */
	public static final @Nonnull String	MCVERSION	= "@MCVERSION@";

	@Instance(SimpleCobblestoneGenerator.MODID)
	public static SimpleCobblestoneGenerator instance;

	public static final CreativeTabs modTab = new ModTab(SimpleCobblestoneGenerator.MODID);

	// pre PreInit
	static {
		Log.debug("PRE-PRE-INIT START");
		FluidRegistry.enableUniversalBucket();
		Log.debug("PRE-PRE-INIT END");
	}

	@NetworkCheckHandler
	public boolean checkRemote(final Map<String, String> mods, final Side remoteParty) {
		if (mods.containsKey(SimpleCobblestoneGenerator.MODID)) {
			String remoteVersion = mods.get(SimpleCobblestoneGenerator.MODID);
			if (remoteVersion != null) {
				String internalVersion = FMLCommonHandler.instance().findContainerFor(this).getVersion();
				if (remoteVersion.equals(internalVersion)) {
					return true;
				}
				else {
					internalVersion = internalVersion.substring(0, internalVersion.lastIndexOf("."));
					remoteVersion = remoteVersion.substring(0, remoteVersion.lastIndexOf("."));
					return remoteVersion.equals(internalVersion);
				}
			}
		}
		return false;
	}

	@Mod.EventHandler
	public void init(final FMLInitializationEvent event) {
		Log.debug("INIT START");
		RecipeInitialization.registerRecipes();
		Log.debug("INIT END");
	}

	@Mod.EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		Log.debug("POST-INIT START");
		NetworkWrapper.registerMessages();
		Log.debug("POST-INIT END");
	}

	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) {}
}