package org.valkyrienskies.vscreate.particles.PhysjammingParticle;


import com.simibubi.create.content.curiosities.bell.CustomRotationParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;

public class PhysjammingParticle extends SimpleAnimatedParticle {

    public PhysjammingParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites, float gravity) {
        super(level, x, y, z, sprites, gravity);
    }
}
