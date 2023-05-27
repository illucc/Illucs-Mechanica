package org.valkyrienskies.vscreate.forge;

import com.simibubi.create.content.AllSections;
import net.minecraft.world.item.ItemStack;
import org.valkyrienskies.vscreate.VSCreateBlocks;

import java.util.EnumSet;

public class VSCreateGroup extends VSCreateGroupBase {

    public VSCreateGroup() {
        super("base");
    }

    @Override
    protected EnumSet<AllSections> getSections() {
        return EnumSet.complementOf(EnumSet.of(AllSections.PALETTES));
    }

    @Override
    public ItemStack makeIcon() {
        return VSCreateBlocks.PROPELLOR_BEARING.asStack();
    }
}
