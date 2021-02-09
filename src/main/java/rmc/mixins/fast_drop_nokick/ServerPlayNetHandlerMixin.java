package rmc.mixins.fast_drop_nokick;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.network.play.ServerPlayNetHandler;

/**
 * Developed by RMC Team, 2021
 */
@Mixin(value = ServerPlayNetHandler.class)
public abstract class ServerPlayNetHandlerMixin {

    @Inject(method = "Lnet/minecraft/network/play/ServerPlayNetHandler;processPlayerDigging(Lnet/minecraft/network/play/client/CPlayerDiggingPacket;)V",
            at = @At(value = "INVOKE",
                     target = "Lnet/minecraft/network/play/ServerPlayNetHandler;disconnect(Ljava/lang/String;)V"))
    private void injectProcessPlayerDigging(CallbackInfo mixin) {
        mixin.cancel();
    }

}