package fr.pcg95.AntMan_Mod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
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
//        final WorldServer playerWorldServer = sendingPlayer.getServerForPlayer();
//        final Minecraft mc = Minecraft.getMinecraft();
//        playerWorldServer.addScheduledTask(new Runnable() {
//            public void run() {
//                processMessage(message, sendingPlayer);
//            }
//        });
        processMessage(message, sendingPlayer);

        return null;
    }

    void processMessage(ControlMessage message, EntityPlayerMP sendingPlayer)
    {
        if (sendingPlayer.ridingEntity instanceof EntityAntoinette) {
            EntityAntoinette antoinette = (EntityAntoinette)sendingPlayer.ridingEntity;
            antoinette.setControlFlags(message.getFlags());
        }
    }

}
