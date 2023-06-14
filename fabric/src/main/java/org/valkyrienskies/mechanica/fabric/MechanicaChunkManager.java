package org.valkyrienskies.mechanica.fabric;

import net.minecraft.world.level.saveddata.SavedData;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.*;


import java.util.Map;

public class MechanicaChunkManager extends SavedData {
    private final HashSet<Map.Entry<UUID, Long>> loadedContraptionChunks;

    public MechanicaChunkManager() {
        this(new HashSet<>());
    }

    private MechanicaChunkManager(HashSet<Map.Entry<UUID, Long>> set) {
        this.loadedContraptionChunks = set;
    }

    public Set<Map.Entry<UUID, Long>> getChunks() {
        return loadedContraptionChunks;
    }

    public static MechanicaChunkManager load(CompoundTag tag) {
        ListTag chunks = tag.getList("ContraptionChunks", Tag.TAG_COMPOUND);
        HashSet<Map.Entry<UUID, Long>> set = new HashSet<>();
        if(chunks != null) {
            chunks.forEach(subTag -> {
                CompoundTag forcedChunk = (CompoundTag)subTag;
                set.add(Map.entry(forcedChunk.getUUID("UUID"), forcedChunk.getLong("ChunkPos")));
            });
        }
        return new MechanicaChunkManager(set);
    }

    public void forceChunk(UUID uuid, ChunkPos chunkPos, boolean forced) {
        long l = chunkPos.toLong();
        if(forced)
            loadedContraptionChunks.add(Map.entry(uuid, l));
        else {
            loadedContraptionChunks.removeIf(entry -> (entry.getKey().equals(uuid) && entry.getValue() == l));
        }
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        ListTag tag = new ListTag();
        loadedContraptionChunks.forEach(entry -> {
            CompoundTag subTag = new CompoundTag();
            subTag.putUUID("UUID", entry.getKey());
            subTag.putLong("ChunkPos", entry.getValue());
            tag.add(subTag);
        });
        compoundTag.put("ContraptionChunks", tag);
        return compoundTag;
    }
}