package fr.pcg95.AntMan_Mod.common;

import java.awt.Color;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.pcg95.AntMan_Mod.proxy.AntMan_CommonProxy;


@Mod(modid = "antmanmod", name = "Ant-Man Mod", version = "1.0.0")

public class AntManMod {
	@Instance("antmanmod")
	public static AntManMod instance;
	
	@SidedProxy(clientSide = "fr.pcg95.AntMan_Mod.proxy.AntMan_ClientProxy", serverSide = "fr.pcg95.AntMan_Mod.proxy.AntMan_CommonProxy")//Définition des classes Serveur et Client(Common= Serveur+Client)
	public static AntMan_CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new fr.pcg95.AntMan_Mod.common.EventHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		EntityRegistry.registerGlobalEntityID(EntityAntManShrinked.class, "AntManShrinked", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 0, 0).getRGB(), new Color(0, 0, 0).getRGB());//Enregistre l'entité dans minecraft en lui trouvant un ID et avec un oeuf rouge et noir
		EntityRegistry.registerModEntity(EntityAntManShrinked.class, "AntManShrinked", 420, this.instance, 40, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityAntoinette.class, "Antoinette", EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 255, 0).getRGB(), new Color(0, 0, 0).getRGB());//Enregistre l'entité dans minecraft en lui trouvant un ID et avec un oeuf vert et noir
		EntityRegistry.registerModEntity(EntityAntoinette.class, "Antoinette", 421, this.instance, 40, 1, true);
		proxy.registerRender();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

