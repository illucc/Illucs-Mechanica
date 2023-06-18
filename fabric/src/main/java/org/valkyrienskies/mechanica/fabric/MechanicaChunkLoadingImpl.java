package org.valkyrienskies.mechanica.fabric;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkStatus;
//import net.minecraft.world.level.chunk.ChunkStatus;
//import net.minecraft.world.server.ServerWorld;


public class MechanicaChunkLoadingImpl {
    public static void loadChunk(ServerLevel serverLevel, ChunkPos chunkPos) {
        System.out.println("we groovin");
        serverLevel.setChunkForced(chunkPos.x, chunkPos.z, true);

        //serverLevel.getChunk(chunkPos.x, chunkPos.z, ChunkStatus.FULL, true);
        //I fucking uhhhhhh I forgor
        //MechanicaChunkManager manager = world.getDataStorage().computeIfAbsent(MechanicaChunkManager::load, MechanicaChunkManager::new, VSCreateModFabric.MANAGER_ID);

    }
}
