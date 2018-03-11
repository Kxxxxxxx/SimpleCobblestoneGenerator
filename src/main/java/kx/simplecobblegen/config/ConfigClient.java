package kx.simplecobblegen.config;

import kx.simplecobblegen.config.ConfigHandler.ProcessParameterTier;

/**
 * Container of the process parameter received from the logical server after connecting.
 * These should be used instead of {@link ConfigHandler#parameter}.
 */
public class ConfigClient {
	public static ProcessParameterTier	tier1;
	public static ProcessParameterTier	tier2;
	public static ProcessParameterTier	tier3;
	public static ProcessParameterTier	tier4;
	
	static {
		ConfigClient.sync();
	}

	/**
	 * Helper to get the container of a tier through the Index.
	 * @param pTier Index of the desired tier
	 * @return Returns the process parameter container of the tier specified by pTier.
	 */
	public static ProcessParameterTier getTier(final int pTier) {
		if (pTier == 1) {
			return ConfigClient.tier1;
		}
		else if (pTier == 2) {
			return ConfigClient.tier2;
		}
		else if (pTier == 3) {
			return ConfigClient.tier3;
		}
		else if (pTier == 4) {
			return ConfigClient.tier4;
		}
		else {
			throw new IllegalArgumentException(String.format("There is no Tier %d! Report this to the mod author!", pTier));
		}
	}

	public static void sync() {
		ConfigClient.tier1	= ConfigHandler.parameter.tier1;
		ConfigClient.tier2	= ConfigHandler.parameter.tier2;
		ConfigClient.tier3	= ConfigHandler.parameter.tier3;
		ConfigClient.tier4	= ConfigHandler.parameter.tier4;
	}
}
