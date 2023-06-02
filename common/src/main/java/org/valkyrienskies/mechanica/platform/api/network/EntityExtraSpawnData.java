package org.valkyrienskies.mechanica.platform.api.network;

import net.minecraft.network.FriendlyByteBuf;

public interface EntityExtraSpawnData {

    void writeSpawnData(FriendlyByteBuf arg);

    void readSpawnData(FriendlyByteBuf arg);

}
