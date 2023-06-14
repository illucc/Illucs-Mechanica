package org.valkyrienskies.mechanica.content.contraptions.doodad

import com.simibubi.create.content.contraptions.base.KineticTileEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class DoodadBlockEntity(type: BlockEntityType<*>?, pos: BlockPos?, state: BlockState?) : KineticTileEntity(type, pos, state){
    override fun tick() {
        super.tick()



    }

    companion object {

    }
}