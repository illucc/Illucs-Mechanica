package org.valkyrienskies.mechanica;


import com.tterrag.registrate.util.entry.BlockEntityEntry;
import org.valkyrienskies.mechanica.content.contraptions.blipdrive.BlipdriveBlockEntity;
import org.valkyrienskies.mechanica.content.contraptions.propellor.PropellorBearingBlockEntity;
import org.valkyrienskies.mechanica.content.contraptions.propellor.PropellorBearingRenderer;

import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class MechanicaBlockEntities {

    // Kinetics
    public static final BlockEntityEntry<PropellorBearingBlockEntity> PROPELLOR_BEARING = REGISTRATE
            .tileEntity("propellor_bearing", PropellorBearingBlockEntity::new)
//            .instance(() -> BearingInstance::new)
            .validBlocks(MechanicaBlocks.PROPELLOR_BEARING)
            .renderer(() -> PropellorBearingRenderer::new)
            .register();

    public static final BlockEntityEntry<BlipdriveBlockEntity> BLIPDRIVE = REGISTRATE
            .tileEntity("blipdrive", BlipdriveBlockEntity::new)
//            .instance(() -> BearingInstance::new)
            .validBlocks(MechanicaBlocks.BLIPDRIVE)
            //.renderer(() -> PropellorBearingRenderer::new)
            .register();

    public static void register() {
    }
}
