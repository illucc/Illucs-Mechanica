package org.valkyrienskies.vscreate.util.builder;

import com.simibubi.create.CreateClient;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.utility.RegisteredObjects;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.valkyrienskies.vscreate.platform.VSCItem;
import org.valkyrienskies.vscreate.platform.Dist;
import org.valkyrienskies.vscreate.platform.SharedValues;

import java.util.function.Supplier;

public class VSCreateRegistrate {

    public static <T extends VSCItem, P> NonNullUnaryOperator<ItemBuilder<T, P>> customRenderedItem(
            Supplier<Supplier<CustomRenderedItemModelRenderer<?>>> supplier) {
        return b -> {
            Dist.onClient(() -> customRenderedItem(b, supplier));
            return b;
        };
    }

    @Environment(EnvType.CLIENT)
    private static <T extends VSCItem, P> void customRenderedItem(ItemBuilder<T, P> b,
                                                                  Supplier<Supplier<CustomRenderedItemModelRenderer<?>>> supplier) {
        b.onRegister(new CustomRendererRegistrationHelper(supplier));
    }

    @Environment(EnvType.CLIENT)
    private static void registerCustomRenderedItem(VSCItem entry, CustomRenderedItemModelRenderer<?> renderer) {
        CreateClient.MODEL_SWAPPER.getCustomRenderedItems()
                .register(RegisteredObjects.getKeyOrThrow(entry), renderer::createModel);
    }

    @Environment(EnvType.CLIENT)
    private record CustomRendererRegistrationHelper(
            Supplier<Supplier<CustomRenderedItemModelRenderer<?>>> supplier) implements NonNullConsumer<VSCItem> {
        @Override
        public void accept(VSCItem entry) {
            CustomRenderedItemModelRenderer<?> renderer = supplier.get().get();
            SharedValues.customRenderedRegisterer().accept(entry, renderer);
            registerCustomRenderedItem(entry, renderer);
        }
    }
}
