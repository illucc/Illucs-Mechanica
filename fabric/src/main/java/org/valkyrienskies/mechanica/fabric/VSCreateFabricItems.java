package org.valkyrienskies.mechanica.fabric;

import com.simibubi.create.content.AllSections;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import org.valkyrienskies.mechanica.MechanicaMod;

import static com.simibubi.create.content.AllSections.MATERIALS;
import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class VSCreateFabricItems {

    static {
        REGISTRATE.creativeModeTab(() -> MechanicaMod.BASE_CREATIVE_TAB);
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
