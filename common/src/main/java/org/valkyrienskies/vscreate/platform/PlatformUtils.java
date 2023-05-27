package org.valkyrienskies.vscreate.platform;

import com.simibubi.create.foundation.tileEntity.SmartTileEntity;
import com.simibubi.create.foundation.tileEntity.behaviour.BehaviourType;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.valkyrienskies.vscreate.util.fluid.VSCFluidTankBehaviour;

public class PlatformUtils {

    @ExpectPlatform
    public static double getReachDistance(Player player) {
        throw new AssertionError();
    }
    @ExpectPlatform
    public static Packet<?> createExtraDataSpawnPacket(Entity entity) {
        throw new AssertionError();
    }
    @ExpectPlatform
    public static void setAboveGroundTicks(ServerPlayer player, int ticks) {
        throw new AssertionError();
    }
    @ExpectPlatform
    public static VSCFluidTankBehaviour cwFluidTank(BehaviourType<VSCFluidTankBehaviour> type, SmartTileEntity te, int tanks, long tankCapacity, boolean enforceVariety) {throw new AssertionError();}
    @ExpectPlatform
    public static boolean isModLoaded(String modId) {throw new AssertionError();}
}
