package fr.pcg95.AntMan_Mod.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Created by Romain3 on 29/07/2015.
 */
public class LivingEventHandler {

    @SubscribeEvent
    public void onEntityHurt(LivingHurtEvent event)
    {
        if(event.entityLiving instanceof EntityAntoinette)
        {
            if(event.isCancelable())
                event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerFall(LivingFallEvent event)
    {
        if(event.entityLiving instanceof EntityPlayerMP)
        {
            if(event.isCancelable())
                event.setCanceled(true);
        }
    }

}
