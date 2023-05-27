package org.valkyrienskies.vscreate.fabric;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import org.valkyrienskies.vscreate.VSCreateMod;

public class VSCreateFabricFluids {

    public static FluidBuilder<SimpleFlowableFluid.Flowing, CreateRegistrate> frostingFluid(String name) {
        return VSCreateMod.REGISTRATE.fluid(name, VSCreateMod.asResource("fluid/" + name + "_still"), VSCreateMod.asResource("fluid/" + name + "_flow"));
    }
    public static void register() {}

//    public static FluidBuilder<SimpleFlowableFluid.Flowing, CreateRegistrate> frostingFluid(String name) {
//        return ClockWorkMod.REGISTRATE.fluid(name, Create.asResource("fluid/frosting_still"), Create.asResource("fluid/frosting_flow"));
//    }

}
