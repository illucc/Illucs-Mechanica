package org.valkyrienskies.mechanica.particles.Blipding;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;

import com.simibubi.create.content.curiosities.bell.BasicParticleData;
import com.simibubi.create.content.curiosities.bell.CustomRotationParticle;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import org.valkyrienskies.mechanica.MechanicaParticles;

public class BlipdingParticle extends CustomRotationParticle {

    private final SpriteSet animatedSprite;

    protected int startTicks;
    protected int endTicks;
    protected int numLoops;

    protected int firstStartFrame = 0;
    protected int startFrames = 1;

    protected int firstLoopFrame = 0;
    protected int loopFrames = 1;

    protected int firstEndFrame = 0;
    protected int endFrames = 1;

    protected AnimationStage animationStage;

    protected int totalFrames = 1;
    protected int ticksPerFrame = 60;

    protected boolean isPerimeter = false;
    protected boolean isExpandingPerimeter = false;
    protected boolean isVisible = true;
    protected int perimeterFrames = 8;

    public BlipdingParticle(ClientLevel worldIn, double x, double y, double z, double vx, double vy, double vz,
                        SpriteSet spriteSet, ParticleOptions data) {
        super(worldIn, x, y, z, spriteSet, 0);
        this.animatedSprite = spriteSet;
        this.quadSize = 1f;
        this.setSize(this.quadSize, this.quadSize);

        //this.loopLength = loopFrames + (int) (this.random.nextFloat() * 5f - 4f);
        //this.startTicks = startFrames + (int) (this.random.nextFloat() * 5f - 4f);
        //this.endTicks = endFrames + (int) (this.random.nextFloat() * 5f - 4f);
        //this.numLoops = (int) (1f + this.random.nextFloat() * 2f);

        this.loopLength = 60;
        this.startTicks = 20;
        this.endTicks = 20;
        this.numLoops = 20;

        this.setFrame(0);

        this.animationStage = !isPerimeter ? new StartAnimation(this) : new PerimeterAnimation(this);
        //if (isPerimeter) {
        //    yo = y -= .5f - 1 / 128f;
        //    totalFrames = perimeterFrames;
        //    isVisible = false;
        //}
    }

    @Override
    public void tick() {
        animationStage.tick();
        animationStage = animationStage.getNext();

        BlockPos pos = new BlockPos(x, y, z);
        if (animationStage == null)
            remove();
        isVisible = true;
        if (!isPerimeter)
            remove();
    }

    @Override
    public void render(VertexConsumer builder, Camera camera, float partialTicks) {
        if (!isVisible)
            return;
        super.render(builder, camera, partialTicks);
    }

    public void setFrame(int frame) {
        if (frame >= 0 && frame < totalFrames)
            setSprite(animatedSprite.get(frame, totalFrames));
    }

    @Override
    public Quaternion getCustomRotation(Camera camera, float partialTicks) {
        //if (isPerimeter)
            //return Vector3f.XP.rotationDegrees(90);
        return new Quaternion(0, -camera.getYRot(), 0, true);
    }

    public static class Data extends BasicParticleData<BlipdingParticle> {
        @Override
        public IBasicParticleFactory<BlipdingParticle> getBasicFactory() {
            return (worldIn, x, y, z, vx, vy, vz, spriteSet) -> new BlipdingParticle(worldIn, x, y, z, vx, vy, vz,
                    spriteSet, this);
        }

        @Override
        public ParticleType<?> getType() {
            return MechanicaParticles.BLIPDING.get();
        }
    }


    public static abstract class AnimationStage {

        protected final BlipdingParticle particle;

        protected int ticks;
        protected int animAge;

        public AnimationStage(BlipdingParticle particle) {
            this.particle = particle;
        }

        public void tick() {
            ticks++;

            if (ticks % particle.ticksPerFrame == 0)
                animAge++;
        }

        public float getAnimAge() {
            return (float) animAge;
        }

        public abstract AnimationStage getNext();
    }

    public static class StartAnimation extends AnimationStage {

        public StartAnimation(BlipdingParticle particle) {
            super(particle);
        }

        @Override
        public void tick() {
            super.tick();

            //particle.setFrame(
            //        particle.firstStartFrame + (int) (getAnimAge() / (float) particle.startTicks * particle.startFrames));
        }

        @Override
        public AnimationStage getNext() {
            if (animAge < particle.startTicks)
                return this;
            else
                return new LoopAnimation(particle);
        }
    }

    public static class LoopAnimation extends AnimationStage {

        int loops;

        public LoopAnimation(BlipdingParticle particle) {
            super(particle);
        }

        @Override
        public void tick() {
            super.tick();

            int loopTick = getLoopTick();

            if (loopTick == 0)
                loops++;

            //particle.setFrame(particle.firstLoopFrame + loopTick);// (int) (((float) loopTick / (float)
            // particle.loopLength) * particle.loopFrames));

        }

        private int getLoopTick() {
            return animAge % particle.loopFrames;
        }

        @Override
        public AnimationStage getNext() {
            if (loops <= particle.numLoops)
                return this;
            else
                return new EndAnimation(particle);
        }
    }

    public static class EndAnimation extends AnimationStage {

        public EndAnimation(BlipdingParticle particle) {
            super(particle);
        }

        @Override
        public void tick() {
            super.tick();

            //particle.setFrame(
            //        particle.firstEndFrame + (int) ((getAnimAge() / (float) particle.endTicks) * particle.endFrames));

        }

        @Override
        public AnimationStage getNext() {
            if (animAge < particle.endTicks)
                return this;
            else
                return null;
        }
    }

    public static class PerimeterAnimation extends AnimationStage {

        public PerimeterAnimation(BlipdingParticle particle) {
            super(particle);
        }

        @Override
        public void tick() {
            super.tick();
            //particle.setFrame((int) getAnimAge() % particle.perimeterFrames);
        }

        @Override
        public AnimationStage getNext() {
            if (animAge < 30)
                return this;
            else
                return null;
            /*if (animAge < (particle.isExpandingPerimeter ? 8
                    : particle.startTicks + particle.endTicks + particle.numLoops * particle.loopLength))
                return this;
            else
                return null;*/
        }
    }
}