package kx.simplecobblegen.config;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import kx.simplecobblegen.network.ConfigPacket;
import kx.simplecobblegen.network.NetworkWrapper;

/**
 * Handler for Configuration related Events.
 */
@Mod.EventBusSubscriber()
public class ConfigEventHandler {
	/**
	 * Event subscriber to send the Configuration-Data to the logical client.
	 * @param event {@linkplain PlayerEvent.PlayerLoggedInEvent}
	 */
	@SubscribeEvent
	public static void onPlayerLoggedInEvent(final PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.player.world.isRemote && event.player instanceof EntityPlayerMP) {
			NetworkWrapper.network.sendTo(	new ConfigPacket(ConfigHandler.parameter.tier1, ConfigHandler.parameter.tier2, ConfigHandler.parameter.tier3, ConfigHandler.parameter.tier4),
											(EntityPlayerMP) event.player);
		}
	}
}