package fr.pcg95.AntMan_Mod.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityAntManShrinked extends EntityMob {

	public EntityAntManShrinked(World world) 
	{
		super(world);
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0D);
		
	}


} 
