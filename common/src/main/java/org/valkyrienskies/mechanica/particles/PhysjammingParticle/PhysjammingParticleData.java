package org.valkyrienskies.mechanica.particles.PhysjammingParticle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.content.contraptions.particle.ICustomParticleDataWithSprite;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import org.valkyrienskies.mechanica.MechanicaParticles;

import java.util.Locale;

import static net.minecraft.core.particles.BlockParticleOption.DESERIALIZER;

public class PhysjammingParticleData implements ParticleOptions, ICustomParticleDataWithSprite<PhysjammingParticleData> {

    public static final Codec<PhysjammingParticleData> CODEC = RecordCodecBuilder.create(i ->
            i.group(
                            Codec.INT.fieldOf("x").forGetter(p -> p.posX),
                            Codec.INT.fieldOf("y").forGetter(p -> p.posY),
                            Codec.INT.fieldOf("z").forGetter(p -> p.posZ))
                    .apply(i, PhysjammingParticleData::new));

    public static final ParticleOptions.Deserializer<PhysjammingParticleData> DESERIALIZER = new ParticleOptions.Deserializer<PhysjammingParticleData>() {
        public PhysjammingParticleData fromCommand(ParticleType<PhysjammingParticleData> particleTypeIn, StringReader reader)
                throws CommandSyntaxException {
            reader.expect(' ');
            int x = reader.readInt();
            reader.expect(' ');
            int y = reader.readInt();
            reader.expect(' ');
            int z = reader.readInt();
            return new PhysjammingParticleData(x, y, z);
        }

        public PhysjammingParticleData fromNetwork(ParticleType<PhysjammingParticleData> particleTypeIn, FriendlyByteBuf buffer) {
            return new PhysjammingParticleData(buffer.readInt(), buffer.readInt(), buffer.readInt());
        }
    };

    final int posX;
    final int posY;
    final int posZ;

    public PhysjammingParticleData(Vec3i pos) {
        this(pos.getX(), pos.getY(), pos.getZ());
    }

    public PhysjammingParticleData(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public PhysjammingParticleData() {
        this(0, 0, 0);
    }

    @Override
    public ParticleType<?> getType() {
        return MechanicaParticles.JAMMING.get();
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buffer) {
        buffer.writeInt(posX);
        buffer.writeInt(posY);
        buffer.writeInt(posZ);
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %d %d %d", MechanicaParticles.JAMMING.parameter(), posX, posY, posZ);
    }

    @Override
    public Deserializer<PhysjammingParticleData> getDeserializer() {
        return DESERIALIZER;
    }

    @Override
    public Codec<PhysjammingParticleData> getCodec(ParticleType<PhysjammingParticleData> type) {
        return CODEC;
    }

    @Override
    public ParticleEngine.SpriteParticleRegistration<PhysjammingParticleData> getMetaFactory() {
        return PhysjammingParticle.Factory::new;
    }

}