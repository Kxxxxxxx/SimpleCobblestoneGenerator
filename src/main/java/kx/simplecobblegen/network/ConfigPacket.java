package kx.simplecobblegen.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import kx.simplecobblegen.config.ConfigClient;
import kx.simplecobblegen.config.ConfigHandler.ProcessParameterTier;

import io.netty.buffer.ByteBuf;

/**
 * Implementation of {@link IMessage} for Configuration-Data transport.
 */
public class ConfigPacket implements IMessage {

	private final ProcessParameterTier	tier1;
	private final ProcessParameterTier	tier2;
	private final ProcessParameterTier	tier3;
	private final ProcessParameterTier	tier4;

	// A default constructor is always required
	/**
	 * Default constructor. Initializes all fields with {@code 0}.
	 */
	public ConfigPacket() {
		this.tier1 = new ProcessParameterTier(0, 0, 0, 0);
		this.tier2 = new ProcessParameterTier(0, 0, 0, 0);
		this.tier3 = new ProcessParameterTier(0, 0, 0, 0);
		this.tier4 = new ProcessParameterTier(0, 0, 0, 0);
	}

	/**
	 * Constructor that assigns values to it's private fields.
	 * @param pTier1 {@link ProcessParameterTier}
	 * @param pTier2 {@link ProcessParameterTier}
	 * @param pTier3 {@link ProcessParameterTier}
	 * @param pTier4 {@link ProcessParameterTier}
	 */
	public ConfigPacket(final ProcessParameterTier pTier1, final ProcessParameterTier pTier2, final ProcessParameterTier pTier3, final ProcessParameterTier pTier4) {
		this.tier1 = pTier1;
		this.tier2 = pTier2;
		this.tier3 = pTier3;
		this.tier4 = pTier4;
	}
	
	/**
	 * Reads from {@link ByteBuf} and assigns it's values to {@link ConfigPacket}'s private fields.
	 * @param buf {@link ByteBuf}
	 */
	@Override
	public void fromBytes(final ByteBuf buf) {
		fromBytes(buf, this.tier1);
		fromBytes(buf, this.tier2);
		fromBytes(buf, this.tier3);
		fromBytes(buf, this.tier4);
	}

	/**
	 * Helper method that reads from {@link ByteBuf} and actually assigns values to the passed {@link ProcessParameterTier}.
	 * @param buf {@link ByteBuf}
	 * @param pTier {@link ProcessParameterTier}
	 */
	private void fromBytes(final ByteBuf buf, final ProcessParameterTier pTier) {
		pTier.slotLimit = buf.readByte();
		pTier.slotNumber = buf.readByte();
		pTier.processTime = buf.readByte();
		pTier.productCount = buf.readByte();
	}
	
	/**
	 * Writes the values of {@link ConfigPacket}'s private fields to {@link ByteBuf}.
	 * @param buf {@link ByteBuf}
	 */
	@Override
	public void toBytes(final ByteBuf buf) {
		toBytes(buf, this.tier1);
		toBytes(buf, this.tier2);
		toBytes(buf, this.tier3);
		toBytes(buf, this.tier4);
	}

	/**
	 * Helper method that actually writes to {@link ByteBuf} from the passed {@link ProcessParameterTier}.
	 * @param buf {@link ByteBuf}
	 * @param pTier {@link ProcessParameterTier}
	 */
	 private void toBytes(final ByteBuf buf, final ProcessParameterTier pTier) {
		 buf.writeByte((byte) pTier.slotLimit);
		 buf.writeByte((byte) pTier.slotNumber);
		buf.writeByte((byte) pTier.processTime);
		buf.writeByte((byte) pTier.productCount);
	}
	
	/**
	 * Implementation of {@link IMessageHandler} for {@link ConfigPacket}.
	 */
	public static class ConfigPacketHandler implements IMessageHandler<ConfigPacket, IMessage> {
		// Do note that the default constructor is required, but implicitly defined in this case
		@Override
		public IMessage onMessage(final ConfigPacket message, final MessageContext ctx) {
			if (ctx.side != Side.CLIENT) {
				return null;
			}
			ConfigClient.tier1 = message.tier1;
			ConfigClient.tier2 = message.tier2;
			ConfigClient.tier3 = message.tier3;
			ConfigClient.tier4 = message.tier4;
			return null;
		}
	}
}