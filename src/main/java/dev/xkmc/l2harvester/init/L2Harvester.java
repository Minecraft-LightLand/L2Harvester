package dev.xkmc.l2harvester.init;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@Mod(L2Harvester.MODID)
@EventBusSubscriber(modid = L2Harvester.MODID, bus = EventBusSubscriber.Bus.MOD)
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
