package org.valkyrienskies.vscreate.forge;

import com.simibubi.create.content.AllSections;
import org.valkyrienskies.vscreate.VSCreateMod;

import static org.valkyrienskies.vscreate.VSCreateMod.REGISTRATE;

public class VSCreateForgeItems {
    static {
        REGISTRATE.creativeModeTab(() -> VSCreateMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(AllSections.CURIOSITIES);
    }

    public static void register() {
    }
}
