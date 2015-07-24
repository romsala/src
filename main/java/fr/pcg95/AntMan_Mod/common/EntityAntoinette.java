package fr.pcg95.AntMan_Mod.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


import net.minecraft.entity.passive.EntityHorse;

public class EntityAntoinette extends EntityMob {
	

	public EntityAntoinette(World world) {
		super(world);
		this.setSize(0.5F,0.5F);
		// TODO Auto-generated constructor stub
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100D);//Set Hp a 100
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0);//Ne peut pas attaquer lol
		
	}
	
	public boolean interact(EntityPlayer entityplayer)
	  {
	    if (riddenByEntity == null || riddenByEntity == entityplayer)
	    {
	      entityplayer.mountEntity(this);
	      return true;
	    }
	    else
	    {
	    	return false;
	    }
	  }
	
	@Override
	protected void attackEntity(Entity entity, float f)
    {
        
    }
	
	//Fonction venant de la classe Horse permettant au cheval et a son rider de se deplacer avec le touches et l orientation de la souris
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase )
        {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;

            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote)
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
            }


            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

            if (f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
        }
    }
	 

}
