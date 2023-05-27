package org.valkyrienskies.vscreate.platform;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.tterrag.registrate.util.entry.EntityEntry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CreativeModeTab;
import org.valkyrienskies.vscreate.platform.api.network.PacketChannel;

import java.util.function.BiConsumer;

public class SharedValues {

    @ExpectPlatform
    public static CreativeModeTab creativeTab() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static PacketChannel getPacketChannel() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static BiConsumer<VSCItem, CustomRenderedItemModelRenderer<?>> customRenderedRegisterer() {
        throw new AssertionError();
    }
}
