package org.valkyrienskies.vscreate.content.contraptions.physJammer;


import com.simibubi.create.content.contraptions.components.structureMovement.bearing.BearingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.valkyrienskies.vscreate.VSCreateBlockEntities;

public class PhysJammerBlock extends BearingBlock {
    public PhysJammerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }


    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, net.minecraft.core.Direction face) {
        return face == state.getValue(FACING).getOpposite();
    }
    @Override
    public net.minecraft.core.Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }
}
