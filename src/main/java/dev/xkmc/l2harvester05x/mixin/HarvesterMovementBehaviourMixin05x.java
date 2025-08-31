package dev.xkmc.l2harvester05x.mixin;

import com.simibubi.create.content.contraptions.behaviour.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import dev.xkmc.l2harvester.compat.HarvesterController;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour", remap = false)
public class HarvesterMovementBehaviourMixin05x {

	@Inject(method = "visitNewPosition", at = @At("HEAD"), cancellable = true)
	public void l2harvester$visitNewPosition(MovementContext context, BlockPos pos, CallbackInfo ci) {
		MovementBehaviour behavior = (MovementBehaviour) this;
		if (HarvesterController.visitNewPosition(stack -> behavior.dropItem(context, stack), context.world, pos)) {
			ci.cancel();
		}
	}

}
