package org.valkyrienskies.vscreate;


import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.ShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.ShaftRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import org.valkyrienskies.vscreate.content.contraptions.propellor.PropellorBearingBlockEntity;
import org.valkyrienskies.vscreate.content.contraptions.propellor.PropellorBearingRenderer;

import static org.valkyrienskies.vscreate.VSCreateMod.REGISTRATE;

public class VSCreateBlockEntities {

    // Kinetics
    public static final BlockEntityEntry<PropellorBearingBlockEntity> PROPELLOR_BEARING = REGISTRATE
            .tileEntity("propellor_bearing", PropellorBearingBlockEntity::new)
//            .instance(() -> BearingInstance::new)
            .validBlocks(VSCreateBlocks.PROPELLOR_BEARING)
            .renderer(() -> PropellorBearingRenderer::new)
            .register();

    public static void register() {
    }
}
