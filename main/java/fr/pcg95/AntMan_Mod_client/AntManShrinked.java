package fr.pcg95.AntMan_Mod_client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class AntManShrinked extends ModelBase {
//Code généré auto par Techne Model
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public AntManShrinked()
  {
	  textureWidth = 64;
	    textureHeight = 64;
	      head = new ModelRenderer(this, 0, -1);
	      head.addBox(-4F, -8F, -4F, 8, 8, 8);
	      head.setRotationPoint(0F, 0F, 0F);
	      head.setTextureSize(64, 64);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      body = new ModelRenderer(this, 16, 15);
	      body.addBox(-4F, 0F, -2F, 8, 12, 4);
	      body.setRotationPoint(0F, 0F, 0F);
	      body.setTextureSize(64, 64);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      rightarm = new ModelRenderer(this, 40, 15);
	      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
	      rightarm.setRotationPoint(-5F, 2F, 0F);
	      rightarm.setTextureSize(64, 64);
	      rightarm.mirror = true;
	      setRotation(rightarm, 0F, 0F, 0F);
	      leftarm = new ModelRenderer(this, 40, 15);
	      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
	      leftarm.setRotationPoint(5F, 2F, 0F);
	      leftarm.setTextureSize(64, 64);
	      leftarm.mirror = true;
	      setRotation(leftarm, 0F, 0F, 0F);
	      rightleg = new ModelRenderer(this, 0, 15);
	      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
	      rightleg.setRotationPoint(-2F, 12F, 0F);
	      rightleg.setTextureSize(64, 64);
	      rightleg.mirror = true;
	      setRotation(rightleg, 0F, 0F, 0F);
	      leftleg = new ModelRenderer(this, 0, 15);
	      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
	      leftleg.setRotationPoint(2F, 12F, 0F);
	      leftleg.setTextureSize(64, 64);
	      leftleg.mirror = true;
	      setRotation(leftleg, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    head.render(f5);
	    body.render(f5);
	    rightarm.render(f5);
	    leftarm.render(f5);
	    rightleg.render(f5);
	    leftleg.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
  
  
  //Animation de l'entité(la galèrance), tiré de net.minecraft.client.model.ModelBiped.class(avec quelques modifs)
  public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
  {
      this.head.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
      this.head.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
      this.rightarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 2.0F * p_78087_2_ * 0.5F;
      this.leftarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
      this.rightarm.rotateAngleZ = 0.0F;
      this.leftarm.rotateAngleZ = 0.0F;
      this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
      this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
      this.rightleg.rotateAngleY = 0.0F;
      this.leftleg.rotateAngleY = 0.0F;

      if (this.isRiding)
      {
          this.rightarm.rotateAngleX += -((float)Math.PI / 5F);
          this.leftarm.rotateAngleX += -((float)Math.PI / 5F);
          this.rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.rightleg.rotateAngleY = ((float)Math.PI / 10F);
          this.leftleg.rotateAngleY = -((float)Math.PI / 10F);
      }

      this.rightarm.rotateAngleY = 0.0F;
      this.leftarm.rotateAngleY = 0.0F;
      float f6;
      float f7;

      if (this.onGround > -9990.0F)
      {
          f6 = this.onGround;
          this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
          this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
          this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
          this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
          this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
          this.rightarm.rotateAngleY += this.body.rotateAngleY;
          this.leftarm.rotateAngleY += this.body.rotateAngleY;
          this.leftarm.rotateAngleX += this.body.rotateAngleY;
          f6 = 1.0F - this.onGround;
          f6 *= f6;
          f6 *= f6;
          f6 = 1.0F - f6;
          f7 = MathHelper.sin(f6 * (float)Math.PI);
          float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
          this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
          this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
          this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
      }


          this.body.rotateAngleX = 0.0F;
          this.rightleg.rotationPointZ = 0.1F;
          this.leftleg.rotationPointZ = 0.1F;
          this.rightleg.rotationPointY = 12.0F;
          this.leftleg.rotationPointY = 12.0F;
          this.head.rotationPointY = 0.0F;

      this.rightarm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      this.leftarm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      this.rightarm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
      this.leftarm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
  }

}
