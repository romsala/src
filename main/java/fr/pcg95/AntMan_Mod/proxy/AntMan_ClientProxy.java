package fr.pcg95.AntMan_Mod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import fr.pcg95.AntMan_Mod.common.EntityAntManShrinked;
import fr.pcg95.AntMan_Mod.common.EntityAntoinette;
import fr.pcg95.AntMan_Mod_client.AntManShrinked;
import fr.pcg95.AntMan_Mod_client.Antoinette;
import fr.pcg95.AntMan_Mod_client.RenderAntManShrinked;
import fr.pcg95.AntMan_Mod_client.RenderAntoinette;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import ichun.client.keybind.KeyEvent;
import net.minecraft.client.Minecraft;

public class AntMan_ClientProxy extends AntMan_CommonProxy {
    private static final int[] keyValues = {Keyboard.KEY_P};
	@Override
	public void registerRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityAntManShrinked.class, new RenderAntManShrinked(new AntManShrinked(), 0.5F));//Lance le rendu de l'entité AntManShrinked
		RenderingRegistry.registerEntityRenderingHandler(EntityAntoinette.class, new RenderAntoinette(new Antoinette(), 0.5F));//Lance le rendu de l'entité Antoinette
	}


        public void onKeyBindEvent(KeyEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (event.keyBind.isPressed()) {
            if ( (event.keyBind.keyIndex == mc.gameSettings.keyBindJump.getKeyCode())) {
                mc.thePlayer.addChatComponentMessage(new ChatComponentText("lol, it works"));

            }
        }
    }

    private static KeyBinding keyBindTest;



    public AntMan_ClientProxy()

    {

        FMLCommonHandler.instance().bus().register(this);

        keyBindTest = new KeyBinding("modtest.key", Keyboard.KEY_T, "key.categories.gameplay");

        ClientRegistry.registerKeyBinding(keyBindTest);

    }


    @SubscribeEvent

    public void onEvent(KeyInputEvent event)

    {

        if(keyBindTest.isPressed())

        {

            keyTestTyped();

        }

    }



    private void keyTestTyped()

    {

    }

}
