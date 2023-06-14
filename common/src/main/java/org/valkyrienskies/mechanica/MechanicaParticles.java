package org.valkyrienskies.mechanica;

import com.simibubi.create.content.contraptions.particle.AirFlowParticleData;
import com.simibubi.create.content.contraptions.particle.ICustomParticleData;
import com.simibubi.create.content.curiosities.bell.SoulParticle;
import com.simibubi.create.foundation.utility.Lang;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import org.valkyrienskies.mechanica.particles.Blipding.BlipdingParticle;
import org.valkyrienskies.mechanica.particles.PhysjammingParticle.PhysjammingParticle;
import org.valkyrienskies.mechanica.particles.PhysjammingParticle.PhysjammingParticleData;
import org.valkyrienskies.mechanica.platform.api.DeferredRegister;

import java.util.function.Supplier;


// hahahhahahhahahahhahhahahahha brian damage


// fucking idiot use this: https://github.com/architectury/architectury-api/blob/1.18/testmod-common/src/main/java/dev/architectury/test/particle/TestParticles.java

public enum MechanicaParticles {

    PROP_STREAM(AirFlowParticleData::new),
    JAMMING(SoulParticle.Data::new),
    BLIPDING(BlipdingParticle.Data::new);
    private final ParticleEntry<?> entry;

    <D extends ParticleOptions> MechanicaParticles(Supplier<? extends ICustomParticleData<D>> typeFactory) {
        String name = Lang.asId(name());
        entry = new ParticleEntry<>(name, typeFactory);

    }


// fucking

    public static void init() {
        //please for the love of god if you have a way to add particles, give it to me

        ParticleEntry.REGISTER.registerAll();
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ParticleEngine particles = Minecraft.getInstance().particleEngine;
        for (MechanicaParticles particle : values())
            particle.entry.registerFactory(particles);
    }

    public ParticleType<?> get() {
        return entry.object;
    }

    public String parameter() {
        return entry.name;
    }

    private static class ParticleEntry<D extends ParticleOptions> {
        private static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(Registry.PARTICLE_TYPE, MechanicaMod.MOD_ID);

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
