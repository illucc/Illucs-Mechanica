package org.valkyrienskies.mechanica.fabric;

import com.simibubi.create.content.AllSections;
import org.valkyrienskies.mechanica.MechanicaMod;


import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class VSCreateFabricBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> MechanicaMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(AllSections.KINETICS);
    }

    public static void register() {
    }
}
