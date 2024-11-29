package dev.xkmc.l2harvester.compat;

import com.simibubi.create.content.contraptions.behaviour.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import dev.xkmc.l2harvester.api.HarvestableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HarvesterController {

	public static boolean visitNewPosition(MovementBehaviour self, MovementContext context, BlockPos pos) {
		Level level = context.world;
		if (level.isClientSide) return false;
		BlockState state = level.getBlockState(pos);
		if (!(state.getBlock() instanceof HarvestableBlock block)) return false;
		var ans = block.getHarvestResult(level, state, pos);
		if (ans == null) return true;
		for (var e : ans.drops())
			self.dropItem(context, e);
		ans.updateState(level, pos);
		return true;
	}

}
