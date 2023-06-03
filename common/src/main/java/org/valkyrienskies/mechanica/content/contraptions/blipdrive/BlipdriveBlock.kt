package org.valkyrienskies.mechanica.content.contraptions.blipdrive

import com.simibubi.create.content.contraptions.base.DirectionalKineticBlock
import com.simibubi.create.foundation.block.ITE
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.Vec3
import org.valkyrienskies.core.apigame.ShipTeleportData
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl
import org.valkyrienskies.core.impl.util.x
import org.valkyrienskies.core.impl.util.y
import org.valkyrienskies.core.impl.util.z
import org.valkyrienskies.mechanica.MechanicaBlockEntities
import org.valkyrienskies.mechanica.content.contraptions.propellor.PropellorBearingBlockEntity
import org.valkyrienskies.mod.common.getShipManagingPos
import org.valkyrienskies.mod.common.shipObjectWorld
import org.valkyrienskies.mod.common.toWorldCoordinates
import org.valkyrienskies.mod.common.util.toJOML
import java.util.function.Consumer
import kotlin.math.cos
import kotlin.math.sin


class BlipdriveBlock(properties: Properties?) : DirectionalKineticBlock(properties), ITE<BlipdriveBlockEntity> {

    //bain dang moent


    //god forgive me
    override fun use(state: BlockState?, worldIn: Level, pos: BlockPos, player: Player, handIn: InteractionHand?,
                     hit: BlockHitResult?): InteractionResult? {
        if (!player.mayBuild()) return InteractionResult.FAIL
        if (player.isShiftKeyDown) return InteractionResult.FAIL
        if (player.getItemInHand(handIn)
                        .isEmpty) {
            if (!worldIn.isClientSide) {
                withTileEntityDo(worldIn, pos, Consumer<BlipdriveBlockEntity> { te: BlipdriveBlockEntity ->
                    if (te.charge >= 20) {
                        te.warp()
                        te.charge = 0f
                    }
                })


                /*// warp moment
                println("blippin")
                worldIn as ServerLevel
                val shipWorld = worldIn.shipObjectWorld

                val positon = Vec3(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
                val shiop = worldIn.getShipManagingPos(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
                println(positon)
                if (shiop != null) {
                    val power = 250
                    val positioner = shiop.toWorldCoordinates(Vec3(shiop.transform.positionInShip.x + power * cos(shiop.transform.shipToWorldRotation.y() * (Math.PI * 2) / 360.0), shiop.transform.positionInShip.y + 10.00, shiop.transform.positionInShip.z + power * sin(shiop.transform.shipToWorldRotation.y() * (Math.PI * 2) / 360.0))) //Vec3(1.00, 1.00, 1.00)
                    val rotationer =  shiop.transform.shipToWorldRotation
                    val tpdata: ShipTeleportData = ShipTeleportDataImpl(newPos = positioner.toJOML(), newRot = rotationer)


                    worldIn.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            pos, // The position of where the sound will come from
                            SoundEvents.BEACON_POWER_SELECT, // The sound that will play, in this case, the sound the anvil plays when it lands.
                            SoundSource.BLOCKS, // This determines which of the volume sliders affect this sound
                            10f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                            0.3f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                    );

                    worldIn.addParticle(ParticleTypes.HEART, positioner.x, positioner.y, positioner.z, 0.00, 0.00, 0.00)
                    println(shiop.transform.shipToWorldRotation.y())
                    println(positioner)
                    shipWorld.teleportShip(shiop, tpdata)
                } else{
                    worldIn.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            pos, // The position of where the sound will come from
                            SoundEvents.BEACON_DEACTIVATE, // The sound that will play, in this case, the sound the anvil plays when it lands.
                            SoundSource.BLOCKS, // This determines which of the volume sliders affect this sound
                            5f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                            1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                    );

                }
                //val shiop = shipWorld.allShips.first()
                */
            }
            return InteractionResult.SUCCESS
            }
        return InteractionResult.PASS
    }



    override fun hasShaftTowards(world: LevelReader?, pos: BlockPos?, state: BlockState, face: Direction): Boolean {
        return face == state.getValue(FACING).opposite
    }
    override fun getRotationAxis(state: BlockState?): Direction.Axis {
        if (state != null) {
            return state.getValue(FACING).axis
        }
        return Direction.NORTH.axis
    }

    override fun getTileEntityClass(): Class<BlipdriveBlockEntity> {
        return BlipdriveBlockEntity::class.java

        //TODO("Not yet implemented")
    }

    override fun getTileEntityType(): BlockEntityType<out BlipdriveBlockEntity> {
        return MechanicaBlockEntities.BLIPDRIVE.get();


        //TODO("Not yet implemented")
    }

}
