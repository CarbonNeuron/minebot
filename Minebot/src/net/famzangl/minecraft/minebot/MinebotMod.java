package net.famzangl.minecraft.minebot;

import net.famzangl.minecraft.minebot.ai.AIController;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "minebot-mod", name = "Minebot", version = "0.3.0")
public class MinebotMod {
	@Instance(value = "minebot-mod")
	public static MinebotMod instance;
	
	// Note: 6364136223846793005L * 0xc097ef87329e28a5l = 1
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new PlayerUpdateHandler());
		final AIController controller = new AIController();
		controller.initialize();
	}

	public static String getVersion() {
		return MinebotMod.class.getAnnotation(Mod.class).version();
	}
}
