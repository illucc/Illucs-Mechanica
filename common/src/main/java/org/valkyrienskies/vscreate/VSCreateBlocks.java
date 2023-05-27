package org.valkyrienskies.vscreate;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MaterialColor;
import org.valkyrienskies.vscreate.content.contraptions.propellor.PropellorBearingBlock;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static org.valkyrienskies.vscreate.VSCreateMod.REGISTRATE;

public class VSCreateBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> VSCreateMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(AllSections.KINETICS);
    }

    public static final BlockEntry<PropellorBearingBlock> PROPELLOR_BEARING =
            REGISTRATE.block("propellor_bearing", PropellorBearingBlock::new)
                    .transform(axeOrPickaxe())
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(BuilderTransformers.bearing("propellor", "gearbox", false))
                    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
                    .register();


    public static void register() {
    }
}
