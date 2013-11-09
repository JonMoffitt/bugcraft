package bugcraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import bugcraft.item.net;
import bugcraft.item.butterfly;
import bugcraft.item.butterflySlide;
import bugcraft.block.microscope;

@Mod(modid="BugCraft", name="Bug Craft", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public class mod {

		private static int startEntityId = 300;
	
		public static Item net;
		public static Item butterfly;
		public static Item butterflySlide;
		
		public static Block microscope;
		
		public static int getUniqueEntityId() {
			while (EntityList.getStringFromID(startEntityId) != null) {
				startEntityId++;
			}
			return startEntityId;
		}
		
		public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
			int id = getUniqueEntityId();
			EntityList.IDtoClassMapping.put(id, entity);
			EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
			
		}
		
        // The instance of your mod that Forge uses.
        @Instance(value = "BugCraft")
        public static mod instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="bugcraft.client.ClientProxy", serverSide="bugcraft.CommonProxy")
        public static CommonProxy proxy;
        
        
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2*/////////////////////////////////////////////////////////////////89
        public void preInit(FMLPreInitializationEvent event) {
                net = new net(5002);
                butterfly = new butterfly(5003);
                butterflySlide = new butterflySlide(5004);
                
                microscope = new microscope(502, Material.iron);
                
                proxy.registerRenderers();
                GameRegistry.registerTileEntity(bugcraft.tileentity.microscope.class, "MicroscopeTile");
                
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
                     
                LanguageRegistry.addName(net, "Net");
                LanguageRegistry.addName(butterfly, "Caught Butterfly");
                LanguageRegistry.addName(butterflySlide, "Butterfly Slide");
                
                GameRegistry.registerBlock(microscope, "microscope");
                
                GameRegistry.addShapedRecipe(new ItemStack(mod.net), "  x", " xy", "xyy", 'x', new ItemStack(Item.stick), 'y', new ItemStack(Item.silk));
                GameRegistry.addShapedRecipe(new ItemStack(mod.butterflySlide), "x  ", "y  ", "x  ", 'x', new ItemStack(Block.thinGlass), 'y', new ItemStack(mod.butterfly));
                GameRegistry.addShapedRecipe(new ItemStack(mod.butterflySlide), " x ", " y ", " x ", 'x', new ItemStack(Block.thinGlass), 'y', new ItemStack(mod.butterfly));
                GameRegistry.addShapedRecipe(new ItemStack(mod.butterflySlide), "  x", "  y", "  x", 'x', new ItemStack(Block.thinGlass), 'y', new ItemStack(mod.butterfly));
                
                //EntityRegistry.registerGlobalEntityID(Butterfly.class, "butterfly", 1);
                EntityRegistry.registerModEntity(bugcraft.entity.butterfly.class, "butterfly", 1, this, 80, 3, true);
                
                int id = EntityRegistry.findGlobalUniqueEntityId();
                registerEntityEgg(bugcraft.entity.butterfly.class, 0xffffaaa, 0x0000000);
                EntityRegistry.addSpawn(bugcraft.entity.butterfly.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.plains);
                RenderingRegistry.registerEntityRenderingHandler(bugcraft.entity.butterfly.class, new bugcraft.renderer.butterfly(new bugcraft.model.butterfly(), .3F));
                
                
                proxy.registerRenderers();
        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}