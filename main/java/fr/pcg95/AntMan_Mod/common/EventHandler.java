package fr.pcg95.AntMan_Mod.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.pcg95.AntMan_Mod.network.ControlMessage;
import ichun.client.keybind.KeyEvent;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.Event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.entity.Entity;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.BitSet;


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

    private final ControlMessage cm = new ControlMessage();
//    @SubscribeEvent
//    public void onKeyInput(InputEvent.KeyInputEvent event) {
//        Minecraft mc = Minecraft.getMinecraft();
//        if(mc.thePlayer.ridingEntity  instanceof  EntityAntoinette)
//        {
//            Entity antoinette = mc.thePlayer.ridingEntity ;
//            if(mc.gameSettings.keyBindSprint.isPressed()){
//                SendChatMessage("Down");
//            }
//            if(mc.gameSettings.keyBindJump.isPressed()) {
//                SendChatMessage("Up");
//            }
//        }
//    }

    private void SendChatMessage(String msg)

    {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(msg));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent evt) {
        Minecraft mc = Minecraft.getMinecraft();
        BitSet flags = cm.getFlags();
        mc.thePlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 3));
        mc.thePlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 1));
        mc.thePlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 100, 1));
        mc.thePlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 1));
        mc.thePlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 2));
        mc.thePlayer.fallDistance = 0.0F;
        if(mc.thePlayer.ridingEntity  instanceof EntityAntoinette) {
//        if(!mc.gameSettings.keyBindJump.isPressed() && !mc.gameSettings.keyBindSprint.isPressed())
//        {
//            flags.set(0);
//        }
            if (mc.gameSettings.keyBindJump.getIsKeyPressed()) {
                flags.clear();
                flags.set(2);
                flags.set(0);
                //mc.thePlayer.addChatComponentMessage(new ChatComponentText(flags.toString()));
            } else if (mc.gameSettings.keyBindSprint.getIsKeyPressed()) {
                flags.clear();
                flags.set(2);
               // mc.thePlayer.addChatComponentMessage(new ChatComponentText(flags.toString()));
            } else {
                flags.clear();
//                flags.set(0);
            }
//        flags.set(0, mc.gameSettings.keyBindJump.isPressed());
//        flags.set(1, mc.gameSettings.keyBindSprint.isPressed());
            if (!flags.toString().contains("{}")) {
                AntManMod.network.sendToServer(cm);
                Spleep(500);
            }


        }
    }

    public void Spleep(int millis)
    {
        int i = 0;
        while(i<millis)
        {
            i += 1;
        }
    }


}
