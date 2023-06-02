package org.valkyrienskies.mechanica.content.contraptions.springer

import com.simibubi.create.content.contraptions.components.structureMovement.bearing.BearingBlock
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.state.BlockState


class SpringerBlock(properties: Properties?) : BearingBlock(properties) {
    override fun hasShaftTowards(world: LevelReader, pos: BlockPos, state: BlockState, face: Direction): Boolean {
        return face == state.getValue(FACING).opposite
    }

    override fun getRotationAxis(state: BlockState): Direction.Axis {
        return state.getValue(FACING).axis
    }


}
