package org.valkyrienskies.vscreate;

import com.simibubi.create.content.contraptions.particle.AirFlowParticleData;
import com.simibubi.create.content.contraptions.particle.ICustomParticleData;
import com.simibubi.create.foundation.utility.Lang;
import com.tterrag.registrate.fabric.RegistryObject;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.BuiltinRegistries;
import org.valkyrienskies.vscreate.particles.PhysjammingParticle.PhysjammingParticle;
import org.valkyrienskies.vscreate.platform.api.DeferredRegister;

import java.util.function.Supplier;


// hahahhahahhahahahhahhahahahha brian damage


public enum VSCreateParticles {

    PROP_STREAM(AirFlowParticleData::new);
    private final ParticleEntry<?> entry;

    <D extends ParticleOptions> VSCreateParticles(Supplier<? extends ICustomParticleData<D>> typeFactory) {
        String name = Lang.asId(name());
        entry = new ParticleEntry<>(name, typeFactory);

    }


// fucking
    public static void init() {
        //please for the love of god if you have a way to add particles, give it to me
        //final RegistryObject<ParticleType> PHYSJAMMER = ParticleEntry.REGISTER.register("physjammer_particles", () -> new SimpleParticleType(true));
        ParticleEntry.REGISTER.registerAll();
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ParticleEngine particles = Minecraft.getInstance().particleEngine;
        for (VSCreateParticles particle : values())
            particle.entry.registerFactory(particles);
    }

    public ParticleType<?> get() {
        return entry.object;
    }

    public String parameter() {
        return entry.name;
    }

    private static class ParticleEntry<D extends ParticleOptions> {
        private static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(Registry.PARTICLE_TYPE, VSCreateMod.MOD_ID);

        private final String name;
        private final Supplier<? extends ICustomParticleData<D>> typeFactory;
        private final ParticleType<D> object;

        public ParticleEntry(String name, Supplier<? extends ICustomParticleData<D>> typeFactory) {
            this.name = name;
            this.typeFactory = typeFactory;

            object = this.typeFactory.get().createType();
            REGISTER.register(name, () -> object);
        }

        @Environment(EnvType.CLIENT)
        public void registerFactory(ParticleEngine particles) {
            typeFactory.get()
                    .register(object, particles);
        }

    }

}
