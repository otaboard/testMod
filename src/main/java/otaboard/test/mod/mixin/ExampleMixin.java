package otaboard.test.mod.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import otaboard.test.mod.testMod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		testMod.LOGGER.info("testmod mixin started");
	}
}
