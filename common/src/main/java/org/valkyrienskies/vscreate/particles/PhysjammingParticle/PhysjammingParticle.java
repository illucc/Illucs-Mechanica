package org.valkyrienskies.vscreate.particles.PhysjammingParticle;
import com.mojang.serialization.Codec;
import com.simibubi.create.content.contraptions.particle.ICustomParticleData;
import com.simibubi.create.content.contraptions.particle.ICustomParticleDataWithSprite;
import com.simibubi.create.content.curiosities.bell.CustomRotationParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.FriendlyByteBuf;

import java.util.Random;

public class PhysjammingParticle extends TextureSheetParticle {

    public PhysjammingParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                               SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.8F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 0.85F;
        this.lifetime = 20;
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }


    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider() {
            this.sprites = new SpriteSet() {
                @Override
                public TextureAtlasSprite get(int age, int lifetime) {
                    return null;
                }

                @Override
                public TextureAtlasSprite get(Random random) {
                    return null;
                }
            };
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new PhysjammingParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}