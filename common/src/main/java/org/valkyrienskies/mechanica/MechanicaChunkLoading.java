package org.valkyrienskies.mechanica;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;

public class MechanicaChunkLoading {
    @ExpectPlatform
    public static void loadChunk(ServerLevel serverLevel, ChunkPos chunkPos) {
        throw new AssertionError();
    }
}
