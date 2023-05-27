package org.valkyrienskies.vscreate.fabric;

import com.simibubi.create.content.AllSections;
import org.valkyrienskies.vscreate.VSCreateMod;


import static org.valkyrienskies.vscreate.VSCreateMod.REGISTRATE;

public class VSCreateFabricBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> VSCreateMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(AllSections.KINETICS);
    }

    public static void register() {
    }
}
