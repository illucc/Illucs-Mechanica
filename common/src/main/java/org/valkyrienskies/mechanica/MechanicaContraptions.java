package org.valkyrienskies.mechanica;

import com.simibubi.create.content.contraptions.components.structureMovement.ContraptionType;
import org.valkyrienskies.mechanica.content.contraptions.propellor.PropellorContraption;

public class MechanicaContraptions {
    public static final ContraptionType
            PROPELLOR = ContraptionType.register(MechanicaMod.asResource("propellor").toString(), PropellorContraption::new);

    public static void init() {
    }

}
