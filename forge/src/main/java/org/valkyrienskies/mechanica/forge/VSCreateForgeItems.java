package org.valkyrienskies.mechanica.forge;

import com.simibubi.create.content.AllSections;
import org.valkyrienskies.mechanica.MechanicaMod;

import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class VSCreateForgeItems {
    static {
        REGISTRATE.creativeModeTab(() -> MechanicaMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(AllSections.CURIOSITIES);
    }

    public static void register() {
    }
}
