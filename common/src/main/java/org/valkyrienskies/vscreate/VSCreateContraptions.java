package org.valkyrienskies.vscreate;

import com.simibubi.create.content.contraptions.components.structureMovement.ContraptionType;
import org.valkyrienskies.vscreate.content.contraptions.propellor.PropellorContraption;

public class VSCreateContraptions {
    public static final ContraptionType
            PROPELLOR = ContraptionType.register(VSCreateMod.asResource("propellor").toString(), PropellorContraption::new);

    public static void init() {
    }

}
