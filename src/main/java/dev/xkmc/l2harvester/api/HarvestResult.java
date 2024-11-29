package dev.xkmc.l2harvester.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.BiConsumer;

public record HarvestResult(BiConsumer<Level, BlockPos> action, List<ItemStack> drops) {

	private static void updateBlock(Level level, BlockPos pos, BlockState state) {
		level.setBlockAndUpdate(pos, state.canSurvive(level, pos) ? state : Blocks.AIR.defaultBlockState());
	}

	public HarvestResult(BlockState state, List<ItemStack> drops) {
		this((level, pos) -> updateBlock(level, pos, state), drops);
	}

	public void updateState(Level level, BlockPos pos) {
		action.accept(level, pos);
	}

}
