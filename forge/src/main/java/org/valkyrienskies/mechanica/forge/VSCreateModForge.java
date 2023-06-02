package org.valkyrienskies.mechanica.forge;

import com.simibubi.create.AllParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import org.valkyrienskies.mechanica.*;
import org.valkyrienskies.mechanica.forge.integration.cc_tweaked.VSCreateForgePeripheralProviders;

import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

@Mod(MechanicaMod.MOD_ID)
public class VSCreateModForge {
    boolean happendClientSetup = false;

    public VSCreateModForge() {
        // Submit our event bus to let architectury register our content on the right time
//        MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();
//        MOD_BUS.addListener(this::clientSetup);
//        REGISTRATE.registerEventListeners(MOD_BUS);
//        MOD_BUS.addListener(this::onModelRegistry);
//        MOD_BUS.addListener(this::clientSetup);
//        MOD_BUS.addListener(this::entityRenderers);
        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        IEventBus modEventBus = FMLJavaModLoadingContext.get()
                .getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::onModelRegistry);
        REGISTRATE.registerEventListeners(modEventBus);

        MechanicaBlocks.register();
        VSCreateForgeBlocks.register();

        // ForgeClockWorkTags.init();

        VSCreateItems.register();
        VSCreateForgeItems.register();

        MechanicaBlockEntities.register();
        VSCreateForgeBlockEntities.register();

        MechanicaFluids.register();
        VSCreateForgeFluids.register();

        MechanicaEntities.register();
        VSCreateForgeEntities.register();

        VSCreateForgeParticles.init(modEventBus);

        VSCreateSounds.register();
        // TODO forge sounds

        MechanicaMod.init();
        VSCreatePackets.init();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            FMLJavaModLoadingContext.get()
                    .getModEventBus().addListener(VSCreateForgeParticles::register);

            // In create itself they do it FMLClientSetupEvent this does not work (what a scam)
            // It prob gets staticly loaded earlier and well yhea...
            VSCreatePartials.init();
            modEventBus.addListener(AllParticleTypes::registerFactories);
            // TODO forge partials

            ShaderLoader.init(modEventBus);
        });

        if (FMLLoader.getLoadingModList().getModFileById("computercraft") != null)
            VSCreateForgePeripheralProviders.register();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MechanicaMod.MOD_ID, path);
    }

    void clientSetup(final FMLClientSetupEvent event) {
        if (happendClientSetup) return;
        happendClientSetup = true;
    }

    void entityRenderers(final EntityRenderersEvent.RegisterRenderers event) {

    }

    void onModelRegistry(final ModelRegistryEvent event) {

    }
}
