package fr.pcg95.AntMan_Mod_client;

import fr.pcg95.AntMan_Mod.common.EntityAntManShrinked;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderAntManShrinked extends RenderLiving {
	
	public final ResourceLocation texture = new ResourceLocation("antmanmod", "textures/text_an.png"); 
	public RenderAntManShrinked(ModelBase model, float shadow)
	{
		super(model, shadow);
	}
	
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

}