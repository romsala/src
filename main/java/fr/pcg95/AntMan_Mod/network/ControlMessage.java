package fr.pcg95.AntMan_Mod.network;

/**
 * Created by Romain3 on 27/07/2015.
 */
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.BitSet;;

public class ControlMessage implements  IMessage{
    private final BitSet bits = new BitSet(Byte.SIZE);
    private int previous;

    public BitSet getFlags()
    {
        return bits;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        fromInteger(buf.readUnsignedByte());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeByte(toInteger());
    }

    public void fromInteger(int value)
    {
        bits.clear();
        for (int i = 0; value != 0; i++) {
            if ((value & (1 << i)) != 0) {
                bits.set(i);
            }
            value >>>= 1;
        }
    }
    public int toInteger()
    {
        int value = 0;
        for (int i = 0; i < bits.length(); i++) {
            value += bits.get(i) ? (1 << i) : 0;
        }
        return value;
    }
    public boolean hasChanged()
    {
        int current = toInteger();
        boolean changed = previous != current;
        previous = current;
        return changed;
    }
}
