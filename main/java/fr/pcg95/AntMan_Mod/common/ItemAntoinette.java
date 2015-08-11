package fr.pcg95.AntMan_Mod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Romain3 on 11/08/2015.
 */
public class ItemAntoinette extends Item {

    public ItemAntoinette() {
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
//        if (!world.isRemote) {
//            EntityAntoinette antoinette = new EntityAntoinette(world);
//            world.spawnEntityInWorld(antoinette);
//            antoinette.isRidden = false;
//            antoinette.setPosition(player.posX, player.posY + 5, player.posZ);
//            // player.mountEntity(antoinette);
//        }
//
//        return itemStack;


        if (world.isRemote) {

            return itemStack;
        } else {
            MovingObjectPosition movingobjectposition =
                    this.getMovingObjectPositionFromPlayer(world, player, true);

            if (movingobjectposition == null) {

                return itemStack;
            } else {

                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

                    int i = movingobjectposition.blockX;

                    int j = movingobjectposition.blockY;

                    int k = movingobjectposition.blockZ;
                    EntityAntoinette entity = spawnCreature(world, (
                            double) i, (double) j, (double) k);

//                    if (!player.capabilities.isCreativeMode) {
//                        --itemStack.
//                                stackSize;
//                    }
                    if(player.getEyeHeight() == 0.17F)
                    {
                        player.mountEntity(entity);
                    }
                }

                return itemStack;
            }
        }
    }

    public static EntityAntoinette spawnCreature(World world, double x, double y, double z) {
        EntityAntoinette entity = new EntityAntoinette(world);
        entity.setLocationAndAngles(x, y+1.1F, z, MathHelper.wrapAngleTo180_float(world.
                rand.nextFloat() * 360.0F), 0.0F);
        world.spawnEntityInWorld(entity);

        return entity;
    }
}
