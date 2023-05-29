package org.valkyrienskies.vscreate.content.contraptions.physJammer

import com.simibubi.create.content.contraptions.components.structureMovement.bearing.BearingBlock
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class PhysJammerBlock(properties: Properties?) : BearingBlock(properties) {
    override fun hasShaftTowards(world: LevelReader, pos: BlockPos, state: BlockState, face: Direction): Boolean {
        return face == state.getValue(FACING).opposite
    }

    override fun getRotationAxis(state: BlockState): Direction.Axis {
        return state.getValue(FACING).axis
    }

    override fun use(state: BlockState?, worldIn: Level, pos: BlockPos?, player: Player, handIn: InteractionHand?,
                     hit: BlockHitResult?): InteractionResult? {
        if (!player.mayBuild()) return InteractionResult.FAIL
        if (player.isShiftKeyDown) return InteractionResult.FAIL
        if (player.getItemInHand(handIn)
                        .isEmpty) {
            if (!worldIn.isClientSide) {
                // jammer moment
                println("Imagine we jammed out")
            }
            return InteractionResult.SUCCESS
        }
        return InteractionResult.PASS
    }

}
