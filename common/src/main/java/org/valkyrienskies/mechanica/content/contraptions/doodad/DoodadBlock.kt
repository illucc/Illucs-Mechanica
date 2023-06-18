package org.valkyrienskies.mechanica.content.contraptions.doodad

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import org.valkyrienskies.mechanica.MechanicaChunkLoading.loadChunk

class DoodadBlock (properties: Properties?) : Block(properties){
    override fun use(state: BlockState?, worldIn: Level, pos: BlockPos, player: Player, handIn: InteractionHand?,
                     hit: BlockHitResult?): InteractionResult? {
        if (!player.mayBuild()) return InteractionResult.FAIL
        if (player.isShiftKeyDown) return InteractionResult.FAIL
        if (player.getItemInHand(handIn).isEmpty) {
            if (!worldIn.isClientSide) {
                // jammer moment
                println("doodad moment?")
                loadChunk(worldIn as ServerLevel, worldIn.getChunkAt(pos).pos)
                println(worldIn.forcedChunks.size)
                return InteractionResult.SUCCESS
            }

        }
        return InteractionResult.PASS
    }
}
