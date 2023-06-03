package org.valkyrienskies.mechanica;

import com.jozufozu.flywheel.core.PartialModel;


public class MechanicaPartials {
//    public static final PartialModel
//
//    ;

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
