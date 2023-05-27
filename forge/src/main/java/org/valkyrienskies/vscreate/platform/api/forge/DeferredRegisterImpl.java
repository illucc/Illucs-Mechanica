package org.valkyrienskies.vscreate.platform.api.forge;

import net.minecraft.core.Registry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DeferredRegisterImpl<T> implements org.valkyrienskies.vscreate.platform.api.DeferredRegister<T> {

    private final DeferredRegister<T> froge;

    private DeferredRegisterImpl(Registry<T> registry, String modId) {
        froge = DeferredRegister.create(registry.key(), modId);
    }

    public static <T> org.valkyrienskies.vscreate.platform.api.DeferredRegister<T> create(Registry<T> registry, String mod_id) {
        return new DeferredRegisterImpl<T>(registry, mod_id);
    }

    @Override
    public void register(String id, Supplier<T> value) {
        froge.register(id, value);
    }

    @Override
    public void registerAll() {
        froge.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
