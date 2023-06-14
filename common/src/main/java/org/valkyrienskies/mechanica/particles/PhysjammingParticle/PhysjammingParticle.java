package org.valkyrienskies.mechanica.particles.PhysjammingParticle;


import com.mojang.serialization.Codec;
import com.simibubi.create.content.contraptions.particle.ICustomParticleData;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class PhysjammingParticle extends SimpleAnimatedParticle {
    public PhysjammingParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                               SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, spriteSet, 0);

        this.friction = 0.8F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 1F;
        this.lifetime = 200;
        //this.setSpriteFromAge(spriteSet);
        setSprite(sprites.get(1, 1));
        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;

        this.alpha = 0.5f;

    }

    @Override
    public void tick() {
        //super.tick();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        //fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }


    public static class Factory implements ParticleProvider<PhysjammingParticleData> {
        private final SpriteSet sprites;

        public Factory(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }



        public Particle createParticle(PhysjammingParticleData type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new PhysjammingParticle(level, x, y, z, this.sprites, xSpeed, ySpeed, zSpeed);
        }
    }



}
