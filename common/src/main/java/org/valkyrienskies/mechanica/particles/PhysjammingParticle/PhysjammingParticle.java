package org.valkyrienskies.mechanica.particles.PhysjammingParticle;


import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;

public class PhysjammingParticle extends SimpleAnimatedParticle {

    public PhysjammingParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites, float gravity) {
        super(level, x, y, z, sprites, gravity);
    }
}
