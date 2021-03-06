package fr.pcg95.AntMan_Mod_client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.pcg95.AntMan_Mod.common.EntityAntManShrinked;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;

public class RenderAntoinette extends RenderLiving {
	
	public final ResourceLocation texture = new ResourceLocation("antmanmod", "textures/text_antoinette.png"); 
	public RenderAntoinette(ModelBase model, float shadow)
	{
		super(model, 0.1F*shadow);
	}
	
	//Fonction appellée automatiquement par Forge pour retrieve la texture de l'entité
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.getAntManModMobTexture((EntityAntoinette)living);
	}
	
	private ResourceLocation getAntManModMobTexture(EntityAntoinette AntMan)
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
		preRenderCallbackAntoinette((EntityAntoinette) entity, f);
	}

	protected void preRenderCallbackAntoinette(EntityAntoinette entity, float f)
	{
		//Resize du modèle de l'entité par un facteur 0.1
		GL11.glScalef(0.1F, 0.1F, 0.1F);
		//GL11.glScalef(5F, 5F, 5F);
	}
}
