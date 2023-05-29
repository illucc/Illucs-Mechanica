package org.valkyrienskies.vscreate.content.contraptions.blipdrive;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.valkyrienskies.vscreate.content.contraptions.propellor.stream.PropStream;
import org.valkyrienskies.vscreate.platform.api.Propellor;
import org.valkyrienskies.core.apigame.VSCore;
import org.valkyrienskies.core.apigame.VSCoreCommands;
import org.valkyrienskies.core.apigame.ShipTeleportData;
import org.valkyrienskies.mod.common.command.VSCommands;
import org.valkyrienskies.core.impl.game.VSCoreCommandsImpl;
import org.valkyrienskies.core.apigame.world.ServerShipWorldCore;


import java.util.ArrayList;

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
