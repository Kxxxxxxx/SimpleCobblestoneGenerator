package kx.simplecobblegen.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import kx.simplecobblegen.SimpleCobblestoneGenerator;
import kx.simplecobblegen.network.ConfigPacket.ConfigPacketHandler;

/**
 * Class to hold the {@link SimpleNetworkWrapper} instance and to take care of the {@link IMessage} and {@link IMessageHandler} registration.
 */
public class NetworkWrapper {
	/**
	 * This mod's {@link SimpleNetworkWrapper} instance.
	 */
	public static final SimpleNetworkWrapper	network		= NetworkRegistry.INSTANCE.newSimpleChannel(SimpleCobblestoneGenerator.MODID);
	private static int							uniqueID	= 0;

	/**
	 * Register this mod's Messages (extends {@link IMessage}) and MessageHandler (extends {@link IMessageHandler}).
	 */
	public static void registerMessages() {
		NetworkWrapper.network.registerMessage(ConfigPacketHandler.class, ConfigPacket.class, NetworkWrapper.uniqueID++, Side.CLIENT);
	}
}