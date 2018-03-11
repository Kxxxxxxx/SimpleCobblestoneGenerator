package kx.simplecobblegen.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kx.simplecobblegen.SimpleCobblestoneGenerator;

public final class Log {
	private static final Logger LOGGER = LogManager.getLogger(SimpleCobblestoneGenerator.MODID);

	/**
	 * Wrapper for {@link Logger#debug(String)} that integrates {@link String#format} 
	 * @param str A format String
	 * @param elements Arguments
	 * @see String#format(String, Object...)
	 */
	public static void debug(final String str, final Object... elements) {
		if (Log.LOGGER.isDebugEnabled()) {
			Log.LOGGER.debug(String.format(str, elements));
		}
	}

	/**
	 * Wrapper for {@link Logger#error(String)} that integrates {@link String#format} 
	 * @param str A format String
	 * @param elements Arguments
	 * @see String#format(String, Object...)
	 */
	public static void error(final String str, final Object... elements) {
		Log.LOGGER.error(String.format(str, elements));
	}

	/**
	 * Wrapper for {@link Logger#info(String)} that integrates {@link String#format} 
	 * @param str A format String
	 * @param elements Arguments
	 * @see String#format(String, Object...)
	 */
	public static void info(final String str, final Object... elements) {
		if (Log.LOGGER.isInfoEnabled()) {
			Log.LOGGER.info(String.format(str, elements));
		}
	}

	/**
	 * Wrapper for {@link Logger#warn(String)} that integrates {@link String#format} 
	 * @param str A format String
	 * @param elements Arguments
	 * @see String#format(String, Object...)
	 */
	public static void warn(final String str, final Object... elements) {
		Log.LOGGER.warn(String.format(str, elements));
	}
}
