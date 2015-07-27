package fr.pcg95.AntMan_Mod_client;

import fr.pcg95.AntMan_Mod.common.EntityAntManShrinked;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class RenderAntManShrinked extends RenderLiving {
	
	public final ResourceLocation texture = new ResourceLocation("antmanmod", "textures/text_an.png"); 
	public RenderAntManShrinked(ModelBase model, float shadow)
	{
		super(model, 0.1F*shadow);
	}
	
	//Fonction appellée automatiquement par Forge pour retrieve la texture de l'entité
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.getAntManModMobTexture((EntityAntManShrinked)living);
	}
	
	private ResourceLocation getAntManModMobTexture(EntityAntManShrinked AntMan)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	
	
	//Fonction appellée automatiquement par Forge pour finaliser le rendu d'une entité
	@Override
    protected void preRenderCallback(EntityLivingBase entity, float f)
    {
		preRenderCallbackAntMan((EntityAntManShrinked) entity, f);
    }
  
    protected void preRenderCallbackAntMan(EntityAntManShrinked entity, float f)
    {
        //Resize du modèle de l'entité par un facteur 0.1
        //GL11.glScalef(0.1F, 0.1F, 0.1F);
    	GL11.glScalef(5F, 5F, 5F);
    }

}