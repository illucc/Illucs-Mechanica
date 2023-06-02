package org.valkyrienskies.mechanica;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.valkyrienskies.mechanica.platform.SharedValues;
import org.valkyrienskies.mechanica.platform.api.network.C2SVSCPacket;
import org.valkyrienskies.mechanica.platform.api.network.VSCPacket;
import org.valkyrienskies.mechanica.platform.api.network.S2CCWPacket;

import java.util.function.Function;

public enum VSCreatePackets {

    // Client to Server
    ;

    <T extends VSCPacket> VSCreatePackets(Class<T> type, Function<FriendlyByteBuf, T> factory) {
        SharedValues.getPacketChannel().registerPacket(type, factory);
    }

    // Force the class to load
    public static void init() {
    }

    public static void sendToNear(Level world, BlockPos pos, int range, S2CCWPacket message) {
        SharedValues.getPacketChannel().sendToNear(world, pos, range, message);
    }

    public static void sendToServer(C2SVSCPacket packet) {
        SharedValues.getPacketChannel().sendToServer(packet);
    }

    public static void sendToClientsTracking(S2CCWPacket packet, Entity entity) {
        SharedValues.getPacketChannel().sendToClientsTracking(packet, entity);
    }

    public static void sendToClientsTrackingAndSelf(S2CCWPacket packet, ServerPlayer player) {
        SharedValues.getPacketChannel().sendToClientsTrackingAndSelf(packet, player);
    }
}