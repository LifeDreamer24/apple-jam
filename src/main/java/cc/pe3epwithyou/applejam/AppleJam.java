package cc.pe3epwithyou.applejam;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.KeyMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppleJam implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("apple-jam");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Apple Jam");
        ScreenEvents.BEFORE_INIT.register((_, screen, _, _) ->
            ScreenEvents.remove(screen).register((_) -> onScreenClose())
        );
        LOGGER.info("Apple Jam initialized :)");
    }

    void onScreenClose() {
        if (isMac()) {
            KeyMapping.setAll();
        }
    }

    private boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }
}
