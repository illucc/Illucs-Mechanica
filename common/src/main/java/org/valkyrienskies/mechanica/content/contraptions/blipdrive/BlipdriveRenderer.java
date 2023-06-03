package org.valkyrienskies.mechanica.content.contraptions.blipdrive;


import com.simibubi.create.AllBlockPartials;
import com.simibubi.create.content.contraptions.base.DirectionalKineticBlock;
import com.simibubi.create.content.contraptions.base.DirectionalKineticBlock.*;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.base.KineticTileEntityRenderer;
import com.simibubi.create.content.contraptions.components.structureMovement.bearing.BearingBlock;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.world.level.block.state.BlockState;


public class BlipdriveRenderer extends KineticTileEntityRenderer {

    public BlipdriveRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(KineticTileEntity te, BlockState state) {
        return CachedBufferer.partialFacing(AllBlockPartials.SHAFT_HALF, state, state
                .getValue(DirectionalKineticBlock.FACING)
                .getOpposite());
    }

}