package org.valkyrienskies.mechanica;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.simibubi.create.content.AllSections.MATERIALS;
import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class MechanicaItems {



    static {
        REGISTRATE.creativeModeTab(() -> MechanicaMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(MATERIALS);
    }

    private static ItemEntry<Item> ingredient(String name) {
        return REGISTRATE.item(name, Item::new)
                .register();
    }

    public static void register() {
    }
}
