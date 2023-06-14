package org.valkyrienskies.mechanica.content.contraptions.blipdrive

import com.simibubi.create.content.contraptions.base.KineticTileEntity
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.Vec3
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.world.ServerShipWorld
import org.valkyrienskies.core.api.world.ShipWorld
import org.valkyrienskies.core.apigame.ShipTeleportData
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl
import org.valkyrienskies.core.impl.util.x
import org.valkyrienskies.core.impl.util.y
import org.valkyrienskies.core.impl.util.z
import org.valkyrienskies.mod.common.getShipManagingPos
import org.valkyrienskies.mod.common.shipObjectWorld
import org.valkyrienskies.mod.common.toWorldCoordinates
import org.valkyrienskies.mod.common.util.toJOML
import org.valkyrienskies.mod.common.vsCore
import kotlin.math.cos
import kotlin.math.sin

class BlipdriveBlockEntity(type: BlockEntityType<*>?, pos: BlockPos?, state: BlockState?) : KineticTileEntity(type, pos, state) {
    var charge = 0f
    var tickCount = 0
    override fun tick() {
        super.tick()


        if (charge <= 19){
            val targetSpeed = getSpeed()
            if (targetSpeed >= 64){
                tickCount++
                //println(tickCount)
                if (tickCount >= 20) {
                    tickCount = 0
                    charge++
                    //println(charge)
                    if (charge == 20f) {
                        level?.playSound(
                                null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                                blockPos, // The position of where the sound will come from
                                SoundEvents.NOTE_BLOCK_PLING, // The sound that will play, in this case, the sound the anvil plays when it lands.
                                SoundSource.BLOCKS, // This determines which of the volume sliders affect this sound
                                11f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                                2f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                        );

                    } else {
                        level?.playSound(
                                null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                                blockPos, // The position of where the sound will come from
                                SoundEvents.WOODEN_BUTTON_CLICK_ON, // The sound that will play, in this case, the sound the anvil plays when it lands.
                                SoundSource.BLOCKS, // This determines which of the volume sliders affect this sound
                                11f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                                (charge+10)/30 // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                        );

                    }



                }
            }
        }
    }

    fun warp() {
        if (!level?.isClientSide!!) {
            (level as ServerLevel)
            val shipWorld = (level as ServerLevel).shipObjectWorld

            val positon = Vec3(blockPos.x.toDouble(), blockPos.y.toDouble(), blockPos.z.toDouble())
            val shiop = level.getShipManagingPos(blockPos.x.toDouble(), blockPos.y.toDouble(), blockPos.z.toDouble())

            if (shiop != null) {
                val power = 250
                val positioner = shiop.toWorldCoordinates(Vec3(shiop.transform.positionInShip.x + power * cos(shiop.transform.shipToWorldRotation.y() * (Math.PI * 2) / 360.0), shiop.transform.positionInShip.y + 10.00, shiop.transform.positionInShip.z + power * sin(shiop.transform.shipToWorldRotation.y() * (Math.PI * 2) / 360.0))) //Vec3(1.00, 1.00, 1.00)
                val rotationer = shiop.transform.shipToWorldRotation
                val tpdata: ShipTeleportData = ShipTeleportDataImpl(newPos = positioner.toJOML(), newRot = rotationer)

                println(shiop.transform.shipToWorldRotation.y())
                println(positioner)

                (level as ServerLevel).playSound(
                        null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                        blockPos, // The position of where the sound will come from
                        SoundEvents.BEACON_POWER_SELECT, // The sound that will play, in this case, the sound the anvil plays when it lands.
                        SoundSource.BLOCKS, // This determines which of the volume sliders affect this sound
                        10f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                        0.3f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                );


                vsCore.teleportShip((shipWorld as ServerShipWorld), (shiop as ServerShip), tpdata)
            }
            //ShipTeleportData newData = new ShipTeleportData(newPos = position.toJOML());
            //VSCore.teleportShip(world, ship, newData);
        }

    }

    companion object {

    }
}
