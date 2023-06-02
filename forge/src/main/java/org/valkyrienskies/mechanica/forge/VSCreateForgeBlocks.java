package org.valkyrienskies.mechanica.forge;

import com.simibubi.create.content.AllSections;
import org.valkyrienskies.mechanica.MechanicaMod;
//import org.valkyrienskies.clockwork.forge.content.contraptions.combustion_engine.ForgeCombustionEngineBlock;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class VSCreateForgeBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> MechanicaMod.BASE_CREATIVE_TAB);
    }

    //////// Propellor Bearing ////////

    static {
        REGISTRATE.startSection(AllSections.KINETICS);
    }

//    public static final BlockEntry<ForgeCombustionEngineBlock> COMBUSTION_ENGINE =
//            REGISTRATE.block("combustion_engine", ForgeCombustionEngineBlock::new)
//                    .initialProperties(SharedProperties::copperMetal)
//                    .properties(p -> p.color(MaterialColor.COLOR_ORANGE))
//                    .transform(pickaxeOnly())
//                    .blockstate((c, p) -> p.horizontalFaceBlock(c.get(), AssetLookup.partialBaseModel(c, p)))
//                    .item()
//                    .transform(customItemModel())
//                    .register();

    public static void register() {
    }
}
