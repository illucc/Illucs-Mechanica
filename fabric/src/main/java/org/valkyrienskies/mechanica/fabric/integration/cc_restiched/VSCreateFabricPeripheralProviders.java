package org.valkyrienskies.mechanica.fabric.integration.cc_restiched;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mechanica.content.contraptions.propellor.PropellorBearingBlockEntity;
import org.valkyrienskies.mechanica.integration.cc.*;

public class VSCreateFabricPeripheralProviders {
    public static void register() {
        ComputerCraftAPI.registerPeripheralProvider(new ClockworkPeripheralProvider());
    }

    public static class ClockworkPeripheralProvider implements IPeripheralProvider {
        @NotNull
        @Override
        public IPeripheral getPeripheral(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull Direction direction) {
            BlockEntity be = level.getBlockEntity(blockPos);
            if (be instanceof PropellorBearingBlockEntity propellor)
                return new PropellorBearingPeripheral(propellor);
            return null;
        }
    }
}
