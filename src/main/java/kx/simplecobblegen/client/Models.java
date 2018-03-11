package kx.simplecobblegen.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import kx.simplecobblegen.SimpleCobblestoneGenerator;
import kx.simplecobblegen.init.RegistrationHandler;

/**
 * Class to Handle the Model registration.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = SimpleCobblestoneGenerator.MODID)
public class Models {
	private static final Models INSTANCE = new Models();
	
	/**
	 * Event subscriber to register this mod's models.
	 * @param event The {@link ModelRegistryEvent}
	 */
	@SubscribeEvent
	public static void registerAllModels(final ModelRegistryEvent event) {
		Models.INSTANCE.registerBlockModels();
	}

	/**
	 * Register this mod's {@link Block} models.
	 */
	private void registerBlockModels() {
		for(ItemBlock item:RegistrationHandler.itemList) {
			registerItemModel(item);
		}
	}

	/**
	 * Register a single model for an {@link Item}.
	 * 
	 * Uses the registry name as the domain/path and {@code "inventory"} as the variant.
	 *
	 * @param item The Item
	 */
	private void registerItemModel(final Item item) {
		final ModelResourceLocation MRL = new ModelResourceLocation(item.getRegistryName(), "inventory");
		ModelBakery.registerItemVariants(item, MRL);
		ModelLoader.setCustomModelResourceLocation(item, 0, MRL);
	}
}
