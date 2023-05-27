package org.valkyrienskies.vscreate.platform.api.network;

import net.minecraft.server.level.ServerPlayer;

public interface ServerNetworkContext extends NetworkContext {

    ServerPlayer getSender();

}
