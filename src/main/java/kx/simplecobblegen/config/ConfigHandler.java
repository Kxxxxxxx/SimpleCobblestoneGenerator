package kx.simplecobblegen.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import kx.simplecobblegen.SimpleCobblestoneGenerator;

/**
 * Configuration Handler
 */
@Config(modid = SimpleCobblestoneGenerator.MODID)
public class ConfigHandler {
	/**
	 * Container for the Process parameter.
	 */
	public static final ProcessParameter	parameter	= new ProcessParameter();

	/**
	 * Container for the Process parameter of all tiers.
	 */
	public static class ProcessParameter {
		@Config.LangKey("simplecobblegen.config.tier1")
		public final ProcessParameterTier	tier1	= new ProcessParameterTier(8, 1, 40, 1);
		@Config.LangKey("simplecobblegen.config.tier2")
		public final ProcessParameterTier	tier2	= new ProcessParameterTier(64, 1, 20, 1);
		@Config.LangKey("simplecobblegen.config.tier3")
		public final ProcessParameterTier	tier3	= new ProcessParameterTier(64, 2, 20, 8);
		@Config.LangKey("simplecobblegen.config.tier4")
		public final ProcessParameterTier	tier4	= new ProcessParameterTier(64, 3, 10, 64);
	}

	
	/**
	 * Container for the Process parameter of a single tier.
	 */
	public static class ProcessParameterTier {
		/**
		 * The max amount of items per slot.
		 */
		@Config.LangKey("simplecobblegen.config.slotLimit")
		@Config.RangeInt(min = 1, max = 64)
		public int	slotLimit;
		/**
		 * The max amount of items per slot.
		 */
		@Config.LangKey("simplecobblegen.config.slotNumber")
		@Config.RangeInt(min = 1, max = 10)
		public int	slotNumber;
		/**
		 * The duration of a Block creation cycle.
		 */
		@Config.LangKey("simplecobblegen.config.processTime")
		@Config.RangeInt(min = 1, max = 60)
		public int	processTime;
		/**
		 * The amount of Blocks created per cycle.
		 */
		@Config.LangKey("simplecobblegen.config.productCount")
		@Config.RangeInt(min = 1, max = 64)
		public int	productCount;

		/**
		 * Constructor for the Process parameter Container.
		 * @param pSlotLimit The max amount of items per slot.
		 * @param pProcessTime The duration of a Block creation cycle.
		 * @param pProductCount The amount of Blocks created per cycle.
		 */
		public ProcessParameterTier(final int pSlotLimit, final int pSlotNumber, final int pProcessTime, final int pProductCount) {
			this.slotLimit = pSlotLimit;
			this.slotNumber = pSlotNumber;
			this.processTime = pProcessTime;
			this.productCount = pProductCount;
		}
	}

	/**
	 * Container for the Generator variant switches of all tiers.
	 */
	public static class Variants {
		@Config.LangKey("simplecobblegen.config.tier1")
		public final VariantTier	tier1	= new VariantTier(true, false, false);
		@Config.LangKey("simplecobblegen.config.tier2")
		public final VariantTier	tier2	= new VariantTier(true, true, true);
		@Config.LangKey("simplecobblegen.config.tier3")
		public final VariantTier	tier3	= new VariantTier(true, true, true);
		@Config.LangKey("simplecobblegen.config.tier4")
		public final VariantTier	tier4	= new VariantTier(true, true, true);
	}

	/**
	 * Container for tthe Generator variant switches of a single tier.
	 */
	public static class VariantTier {
		/**
		 * The switch for the cobblestone generator variant.
		 */
		@Config.LangKey("simplecobblegen.config.generalVariant")
		public boolean	generalVariant;
		/**
		 * The switch for the stone generator variant.
		 */
		@Config.LangKey("simplecobblegen.config.stoneVariant")
		public boolean	stoneVariant;
		/**
		 * The switch for the push generator variant.
		 */
		@Config.LangKey("simplecobblegen.config.pushVariant")
		public boolean	pushVariant;

		/**
		 * Constructor for the variants switches Container.
		 * @param pGeneralVariant Switch for the cobblestone variant.
		 * @param pStoneVariant Switch for the stone variant.
		 * @param pPushVariant Switch for the push variant.
		 */
		public VariantTier(final boolean pGeneralVariant, final boolean pStoneVariant, final boolean pPushVariant) {
			this.generalVariant = pGeneralVariant;
			this.stoneVariant = pStoneVariant;
			this.pushVariant = pPushVariant;
		}
	}
	
	/**
	 * Handler for the changed Configuration event.
	 */
	@Mod.EventBusSubscriber()
	private static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(SimpleCobblestoneGenerator.MODID)) {
				ConfigManager.load(SimpleCobblestoneGenerator.MODID, Config.Type.INSTANCE);
				ConfigClient.sync();
			}
		}
	}
}
