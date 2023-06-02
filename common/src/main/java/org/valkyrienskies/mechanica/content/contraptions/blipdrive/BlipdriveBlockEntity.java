package org.valkyrienskies.mechanica.content.contraptions.blipdrive;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class BlipdriveBlockEntity extends KineticTileEntity {


    float charge;
    public BlipdriveBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }


    public static void warp(Vec3 position) {
        //ShipTeleportData newData = new ShipTeleportData(newPos = position.toJOML());
        //VSCore.teleportShip(world, ship, newData);
    }
}
