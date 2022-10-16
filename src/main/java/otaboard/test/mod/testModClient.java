package otaboard.test.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import otaboard.test.mod.screens.testFurnaceScreen;

@Environment(EnvType.CLIENT)
public class testModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(testMod.ALLOY_FURNACE_SCREEN_HANDLER, alloyFurnaceScreen::new);
        HandledScreens.register(testMod.TEST_FURNACE_SCREEN_HANDLER, testFurnaceScreen::new);
    }
}