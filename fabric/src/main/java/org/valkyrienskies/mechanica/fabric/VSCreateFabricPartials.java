package org.valkyrienskies.mechanica.fabric;

import com.jozufozu.flywheel.core.PartialModel;
import org.valkyrienskies.mechanica.MechanicaMod;


public class VSCreateFabricPartials {

    // Platform specific partials

    private static PartialModel block(String path) {
        return new PartialModel(MechanicaMod.asResource("block/" + path));
    }

    private static PartialModel entity(String path) {
        return new PartialModel(MechanicaMod.asResource("entity/" + path));
    }

    public static void init() {
        // init static fields
    }
}
