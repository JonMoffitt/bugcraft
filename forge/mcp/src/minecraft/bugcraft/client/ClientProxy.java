package bugcraft.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import bugcraft.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		// Here's where the good stuff happens
		ClientRegistry.bindTileEntitySpecialRenderer(bugcraft.tileentity.microscope.class, new bugcraft.renderer.microscope());
	}
}
