package fr.pcg95.AntMan_Mod.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityAntManShrinked extends EntityMob {

	public EntityAntManShrinked(World world) 
	{
		super(world);
		this.setSize(0.1F,0.2F);//Resize de la hitbox: this.setSize(GL11.glScalefactor, 2*GL11.glScalefactor)
		//this.setSize(5F,10F);
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);//Set Hp a 20
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0D);//Ne peut pas attaquer lol
		
	}
	
	@Override
	protected void attackEntity(Entity entity, float f)
    {
        
    }

	


} 
