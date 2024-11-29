package dev.xkmc.l2harvester.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public interface HarvestableBlock {

	@Nullable
	HarvestResult getHarvestResult(Level level, BlockState state, BlockPos pos);

}
