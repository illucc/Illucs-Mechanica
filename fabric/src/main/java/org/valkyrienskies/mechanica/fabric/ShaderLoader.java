package org.valkyrienskies.mechanica.fabric;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import org.valkyrienskies.mechanica.MechanicaMod;

public class ShaderLoader {

    public static void init() {
        final ResourceManagerHelper manager = ResourceManagerHelper.get(PackType.CLIENT_RESOURCES);
        manager.registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return MechanicaMod.asResource("shaders");
            }

            @Override
            public void onResourceManagerReload(ResourceManager resourceManager) {
            }
        });
    }

}
