package dev.xkmc.l2harvester.compat;

import dev.xkmc.l2harvester.api.HarvestableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class HarvesterController {

	public static boolean visitNewPosition(Consumer<ItemStack> consumer, Level level, BlockPos pos) {
		if (level.isClientSide) return false;
		BlockState state = level.getBlockState(pos);
		if (!(state.getBlock() instanceof HarvestableBlock block)) return false;
		var ans = block.getHarvestResult(level, state, pos);
		if (ans == null) return true;
		for (var e : ans.drops())
			consumer.accept(e);
		ans.updateState(level, pos);
		return true;
	}

}
