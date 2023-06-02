package org.valkyrienskies.vscreate.content.contraptions.blipdrive

import com.mojang.math.Quaternion
import com.simibubi.create.content.contraptions.components.structureMovement.bearing.BearingBlock
import net.minecraft.commands.arguments.EntityArgument
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.Vec3
import org.valkyrienskies.core.api.world.ServerShipWorld
import org.valkyrienskies.core.apigame.ShipTeleportData
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl
import org.valkyrienskies.mod.common.util.toJOML
import org.valkyrienskies.mod.common.vsCore
import net.minecraft.server.MinecraftServer
import net.minecraft.server.level.ServerLevel
import org.joml.Vector3d
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.Ship
import org.valkyrienskies.core.impl.api.LoadedServerShipInternal
import org.valkyrienskies.core.impl.game.ships.ShipData
import org.valkyrienskies.core.impl.util.x
import org.valkyrienskies.mod.common.allShips
import org.valkyrienskies.mod.common.shipObjectWorld
import org.valkyrienskies.mod.common.shipWorldNullable
import org.valkyrienskies.mod.common.util.settings
import org.valkyrienskies.mod.common.util.toJOMLD

class BlipdriveBlock(properties: Properties?) : BearingBlock(properties) {

    //bain dang moent

    override fun hasShaftTowards(world: LevelReader, pos: BlockPos, state: BlockState, face: Direction): Boolean {
        return face == state.getValue(FACING).opposite
    }

    override fun getRotationAxis(state: BlockState): Direction.Axis {
        return state.getValue(FACING).axis
    }


    //god forgive me
    override fun use(state: BlockState?, worldIn: Level, pos: BlockPos?, player: Player, handIn: InteractionHand?,
                     hit: BlockHitResult?): InteractionResult? {
        if (!player.mayBuild()) return InteractionResult.FAIL
        if (player.isShiftKeyDown) return InteractionResult.FAIL
        if (player.getItemInHand(handIn)
                        .isEmpty) {
            if (!worldIn.isClientSide) {


                // warp moment
                println("blippin")
                worldIn as ServerLevel
                val shipWorld = worldIn.shipObjectWorld
                val shiop = shipWorld.allShips.first()
                val positioner = Vec3(1.00, 1.00, 1.00)
                val tpdata: ShipTeleportData = ShipTeleportDataImpl(newPos = positioner.toJOML()) //newVel = positioner.toJOML()

                //h triode said something in the #dev chat, check that out
                //yep he'll change something in the code, guess I gotta wait, but blipdrive moment is fast approaching
                shipWorld.teleportShip(shiop, tpdata)//tpdata)

                //shipWorld.deleteShip(shiop)
                //shiop.
            }
            return InteractionResult.SUCCESS
            }
        return InteractionResult.PASS
    }

}
