package fr.pcg95.AntMan_Mod.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ichun.client.keybind.KeyEvent;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.Event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.entity.Entity;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;
import net.minecraft.util.MathHelper;


/**
 * Created by Romain3 on 27/07/2015.
 */
public class EventHandler {

//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
//    public void onKeyBindEvent(KeyEvent event) {
//        System.out.println("leeeeeeeeeeeeeeel");
//        Minecraft mc = Minecraft.getMinecraft();
//        if (event.keyBind.isPressed()) {
//            if ( (event.keyBind.keyIndex == mc.gameSettings.keyBindAttack.getKeyCode())&& event.keyBind.isMinecraftBind()) {
//                System.out.println("leeeeeeeeeeeeeeel");
//
//            }
//        }
//    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc.thePlayer.ridingEntity  instanceof  EntityAntoinette)
        {
            Entity antoinette = mc.thePlayer.ridingEntity ;
            if(mc.gameSettings.keyBindSprint.isPressed()){
                AntoinetteDown(antoinette) ;
                SendChatMessage("Down");
            }
            if(mc.gameSettings.keyBindJump.isPressed()) {
                AntoinetteUp(antoinette);
                SendChatMessage("Up");
            }
        }
    }

    private void SendChatMessage(String msg)

    {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(msg));
    }

    private void AntoinetteUp(Entity antoinette)
    {
        Entity player = antoinette.riddenByEntity;
        float f2 = MathHelper.sin(antoinette.rotationYaw * (float) Math.PI / 180.0F);
        antoinette.motionY += player.motionY *f2*0.5;
    }

    private void AntoinetteDown(Entity antoinette)
    {
        Entity player = antoinette.riddenByEntity;
        antoinette.motionY -= player.motionY;
    }



}
