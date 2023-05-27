package org.valkyrienskies.vscreate.platform.forge;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import org.valkyrienskies.vscreate.VSCreateMod;
import org.valkyrienskies.vscreate.platform.api.network.*;

import java.util.function.Function;

public class PacketChannelImpl implements PacketChannel {
    private final SimpleChannel channel = NetworkRegistry.newSimpleChannel(
            VSCreateMod.NETWORK_CHANNEL,
            () -> VSCreateMod.NETWORK_VERSION_STR,
            VSCreateMod.NETWORK_VERSION_STR::equals,
            VSCreateMod.NETWORK_VERSION_STR::equals
    );

    private int id = 0;

    @Override
    public <T extends VSCPacket> void registerPacket(Class<T> clazz, Function<FriendlyByteBuf, T> decode) {
        channel.registerMessage(id++, clazz, VSCPacket::write, decode, (packet, ctx) -> {
            if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ((C2SVSCPacket) packet).handle(serverContext(ctx.get()));
            } else {
                ((S2CCWPacket) packet).handle(clientContext(ctx.get()));
            }
        });
    }

    private ClientNetworkContext clientContext(NetworkEvent.Context ctx) {
        return new ClientNetworkContext() {
            @Override
            public void enqueueWork(Runnable runnable) {
                ctx.enqueueWork(runnable);
            }

            @Override
            public void setPacketHandled(boolean value) {
                ctx.setPacketHandled(value);
            }
        };
    }

    private ServerNetworkContext serverContext(NetworkEvent.Context ctx) {
        return new ServerNetworkContext() {
            @Override
            public ServerPlayer getSender() {
                return ctx.getSender();
            }

            @Override
            public void enqueueWork(Runnable runnable) {
                ctx.enqueueWork(runnable);
            }

            @Override
            public void setPacketHandled(boolean value) {
                ctx.setPacketHandled(value);
            }
        };
    }

    @Override
    public void sendToNear(Level world, BlockPos pos, int range, S2CCWPacket message) {
        channel.send(
                PacketDistributor.NEAR.with(
                        PacketDistributor.TargetPoint.p(pos.getX(), pos.getY(), pos.getZ(), range, world.dimension())
                ),
                message
        );
    }

    @Override
    public void sendToServer(C2SVSCPacket packet) {
        channel.send(PacketDistributor.SERVER.noArg(), packet);
    }

    @Override
    public void sendToClientsTracking(S2CCWPacket packet, Entity entity) {
        channel.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), packet);
    }

    @Override
    public void sendToClientsTrackingAndSelf(S2CCWPacket packet, ServerPlayer player) {
        channel.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player), packet);
    }
}
