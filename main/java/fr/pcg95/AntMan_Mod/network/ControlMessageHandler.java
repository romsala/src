package fr.pcg95.AntMan_Mod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.Runnable;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * Created by Romain3 on 27/07/2015.
 */
public class ControlMessageHandler implements IMessageHandler<ControlMessage, IMessage> {
    private static final Logger L = LogManager.getLogger();

    @Override
    public IMessage onMessage(final ControlMessage message, MessageContext ctx) {
        if (ctx.side != Side.SERVER) {
            L.warn("DragonControlMessage received on wrong side:" + ctx.side);
            return null;
        }
        final EntityPlayerMP sendingPlayer = ctx.getServerHandler().playerEntity;
        if (sendingPlayer == null) {
            L.warn("EntityPlayerMP was null when DragonControlMessage was received");
            return null;
        }

        processMessage(message, sendingPlayer);

        return null;
    }

    void processMessage(ControlMessage message, EntityPlayerMP sendingPlayer)
    {
        if (sendingPlayer.ridingEntity instanceof EntityAntoinette) {
                //System.out.println(message.getFlags().toString());

            EntityAntoinette antoinette = (EntityAntoinette)sendingPlayer.ridingEntity;
            antoinette.setControlFlags(message.getFlags());
            if(message.getFlags().toString().contains("{0, 1}"))
            {
                antoinette.motionY += 0.04F;
            }
            if(message.getFlags().toString().contains("{1}"))
            {
                antoinette.motionY -= 0.04F;
            }
        }
    }

}
