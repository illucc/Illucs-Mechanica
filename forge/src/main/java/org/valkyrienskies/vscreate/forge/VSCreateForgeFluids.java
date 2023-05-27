package org.valkyrienskies.vscreate.forge;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.valkyrienskies.vscreate.VSCreateMod;

public class VSCreateForgeFluids {

    private static FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> standardFluid(String name, NonNullBiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> factory) {
        return VSCreateMod.REGISTRATE
                .fluid(name, VSCreateMod.asResource("fluid/" + name + "_still"), VSCreateMod.asResource("fluid/" + name + "_flow"), factory)
                .removeTag(FluidTags.WATER);
    }

    private static FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> frostingFluid(String name, NonNullBiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> factory) {
        return VSCreateMod.REGISTRATE
                .fluid(name, VSCreateMod.asResource("fluid/frosting_still"), VSCreateMod.asResource("fluid/frosting_flow"), factory)
                .removeTag(FluidTags.WATER);
    }

    public static void register() {}

    private static class NoColorFluidAttributes extends FluidAttributes {

        protected NoColorFluidAttributes(Builder builder, Fluid fluid) {
            super(builder, fluid);
        }

        @Override
        public int getColor(BlockAndTintGetter level, BlockPos pos) {
            return 0x00ffffff;
        }
    }
}
