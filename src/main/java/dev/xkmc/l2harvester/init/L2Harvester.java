package dev.xkmc.l2harvester.init;

import com.mojang.logging.LogUtils;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(L2Harvester.MODID)
@Mod.EventBusSubscriber(modid = L2Harvester.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class L2Harvester {

	public static final String MODID = "l2harvester";
	public static final Logger LOGGER = LogUtils.getLogger();

	public L2Harvester() {
	}

	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
	}

}
