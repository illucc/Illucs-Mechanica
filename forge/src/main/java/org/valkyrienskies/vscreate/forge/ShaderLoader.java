package org.valkyrienskies.vscreate.forge;

import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.vscreate.VSCreateMod;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ShaderLoader {

    public static void init(IEventBus bus) {
        bus.addListener(ShaderLoader::registerReloadListener);
    }

    private static void registerReloadListener(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new PreparableReloadListener() {
            @Override
            public @NotNull CompletableFuture<Void> reload(
                    @NotNull PreparationBarrier preparationBarrier,
                    @NotNull ResourceManager resourceManager,
                    @NotNull ProfilerFiller preparationsProfiler,
                    @NotNull ProfilerFiller reloadProfiler,
                    @NotNull Executor backgroundExecutor,
                    @NotNull Executor gameExecutor) {
                return CompletableFuture.completedFuture(null).thenCompose(preparationBarrier::wait).thenAccept((i -> {
                }));
            }

            @Override
            public @NotNull String getName() {
                return VSCreateMod.asResource("shaders").toString();
            }
        });
    }

}
