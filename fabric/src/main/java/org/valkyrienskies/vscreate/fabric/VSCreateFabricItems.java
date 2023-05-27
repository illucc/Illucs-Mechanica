package org.valkyrienskies.vscreate.fabric;

import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import org.valkyrienskies.vscreate.VSCreateMod;

import static com.simibubi.create.content.AllSections.MATERIALS;
import static org.valkyrienskies.vscreate.VSCreateMod.REGISTRATE;

public class VSCreateFabricItems {

    static {
        REGISTRATE.creativeModeTab(() -> VSCreateMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(MATERIALS);
    }

    static {
        REGISTRATE.startSection(AllSections.KINETICS);
    }

    static {
        REGISTRATE.startSection(AllSections.CURIOSITIES);
    }


    //Shortcuts

    private static ItemEntry<Item> ingredient(String name) {
        return REGISTRATE.item(name, Item::new)
                .register();
    }

    public static void register() {
    }
}
