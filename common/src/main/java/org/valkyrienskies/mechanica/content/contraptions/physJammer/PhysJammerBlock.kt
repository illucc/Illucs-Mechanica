package org.valkyrienskies.mechanica.content.contraptions.physJammer

import com.simibubi.create.content.contraptions.components.structureMovement.bearing.BearingBlock
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import org.valkyrienskies.core.impl.game.ships.ShipData
import org.valkyrienskies.mod.common.getShipManagingPos

class PhysJammerBlock(properties: Properties?) : BearingBlock(properties) {
    override fun hasShaftTowards(world: LevelReader, pos: BlockPos, state: BlockState, face: Direction): Boolean {
        return face == state.getValue(FACING).opposite
    }

    override fun getRotationAxis(state: BlockState): Direction.Axis {
        return state.getValue(FACING).axis
    }

    override fun use(state: BlockState?, worldIn: Level, pos: BlockPos, player: Player, handIn: InteractionHand?,
                     hit: BlockHitResult?): InteractionResult? {
        if (!player.mayBuild()) return InteractionResult.FAIL
        if (player.isShiftKeyDown) return InteractionResult.FAIL
        if (player.getItemInHand(handIn)
                        .isEmpty) {
            worldIn.addParticle(ParticleTypes.FLASH, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), 0.00, 0.00, 0.00)
            if (!worldIn.isClientSide) {
                val shiop = worldIn.getShipManagingPos(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
                if (shiop != null) {
                    worldIn.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            pos, // The position of where the sound will come from
                            SoundEvents.TOTEM_USE, // The sound that will play, in this case, the sound the anvil plays when it lands.
                            SoundSource.BLOCKS, // This determines which of the volume sliders affect this sound
                            10f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                            0.3f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                    )

                    (shiop as ShipData).isStatic = !(shiop as ShipData).isStatic

                }


                // jammer moment
                println("Imagine we jammed out")
            }
            return InteractionResult.SUCCESS
        }
        return InteractionResult.PASS
    }

}
