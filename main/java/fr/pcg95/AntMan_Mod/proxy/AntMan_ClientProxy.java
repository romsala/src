package fr.pcg95.AntMan_Mod.proxy;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.pcg95.AntMan_Mod.common.EntityAntManShrinked;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;
import fr.pcg95.AntMan_Mod_client.*;
public class AntMan_ClientProxy extends AntMan_CommonProxy {



	@Override
	public void registerRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityAntManShrinked.class, new RenderAntManShrinked(new AntManShrinked(), 0.5F));//Lance le rendu de l'entité AntManShrinked
        RenderingRegistry.registerEntityRenderingHandler(EntityAntoinette.class, new RenderAntoinette(new Antoinette(), 0.5F));//Lance le rendu de l'entité Antoinette
	}






    public AntMan_ClientProxy()

    {

        FMLCommonHandler.instance().bus().register(this);


    }


}
