package org.valkyrienskies.vscreate.fabric;

import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.valkyrienskies.vscreate.*;
import org.valkyrienskies.vscreate.fabric.integration.cc_restiched.VSCreateFabricPeripheralProviders;
import org.valkyrienskies.vscreate.platform.fabric.FallbackFabricTransfer;
import org.valkyrienskies.mod.fabric.common.ValkyrienSkiesModFabric;

public class VSCreateModFabric implements ModInitializer {

    public static void init() {
        VSCreateParticles.init();

        VSCreateFabricParticles.init();
        VSCreateFabricSounds.init();
        FallbackFabricTransfer.init();

        //ClockworkCommonEvents.register();
    }

    public static void gatherData(FabricDataGenerator gen, ExistingFileHelper helper) {
        gen.addProvider(VSCreateFabricSounds.provider(gen));
    }

    @Override
    public void onInitialize() {
        // force VS2 to load before eureka
        new ValkyrienSkiesModFabric().onInitialize();

        VSCreateBlocks.register();
        VSCreateFabricBlocks.register();

        // TODO common items
        VSCreateItems.register();
        VSCreateFabricItems.register();

        VSCreateBlockEntities.register();
        VSCreateFabricBlockEntities.register();

        // TODO common entities
        VSCreateEntities.register();
        VSCreateFabricEntities.register();

        VSCreateFluids.register();
        VSCreateFabricFluids.register();

        VSCreateSounds.register();
        VSCreateFabricSounds.prepare();

        VSCreateMod.REGISTRATE.register();

        VSCreateMod.init();
        VSCreateModFabric.init();

        if (FabricLoader.getInstance().isModLoaded("computercraft"))
            VSCreateFabricPeripheralProviders.register();
    }

    @Environment(EnvType.CLIENT)
    public static class Client implements ClientModInitializer {
        @Override
        public void onInitializeClient() {
            VSCreateMod.initClient();

            VSCreatePartials.init();
            VSCreateFabricPartials.init();

            VSCreateParticles.initClient();
            VSCreateFabricParticles.initClient();

            registerClientEvents();
            registerClientEvents();
            ShaderLoader.init();
        }

        public static void registerClientEvents() {
        }

        public static void registerInputEvents() {
        }
    }

    public static class ModMenu implements ModMenuApi {
    }
}
