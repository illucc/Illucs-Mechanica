package org.valkyrienskies.mechanica.util.builder;


import com.simibubi.create.content.contraptions.base.RotatedPillarKineticBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.valkyrienskies.mechanica.MechanicaMod;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;


public class BuilderTransformersVSCreate {


    private static <B extends RotatedPillarKineticBlock, P> BlockBuilder<B, P> encasedBase(BlockBuilder<B, P> b,
                                                                                           Supplier<ItemLike> drop) {
        return b.initialProperties(SharedProperties::stone)
                .properties(BlockBehaviour.Properties::noOcclusion)
                .transform(BlockStressDefaults.setNoImpact())
                .loot((p, lb) -> p.dropOther(lb, drop.get()));
    }

    public static <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> infuser() {
        ResourceLocation baseBlockModelLocation = MechanicaMod.asResource("block/physics_infuser/block");
        ResourceLocation baseItemModelLocation = MechanicaMod.asResource("block/physics_infuser/item");
        ResourceLocation liquidTextureLocation = MechanicaMod.asResource("block/physics_infuser/liquid");
        ResourceLocation coreTextureLocation = MechanicaMod.asResource("block/physics_infuser/core");

        return b -> b.initialProperties(SharedProperties::stone)
                .properties(p -> p.noOcclusion())
                .blockstate((c, p) -> p.directionalBlock(c.get(), p.models()
                        .withExistingParent(c.getName(), baseBlockModelLocation)
                        .texture("0", baseBlockModelLocation)
                        .texture("1", coreTextureLocation)
                        .texture("2", liquidTextureLocation)))
                .item()
                .model((c, p) -> p.withExistingParent(c.getName(), baseItemModelLocation)
                        .texture("0", baseBlockModelLocation)
                        .texture("1", coreTextureLocation)
                        .texture("2", liquidTextureLocation))
                .build();
    }

    public static <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> flapbearing() {
        ResourceLocation baseBlockModelLocation = MechanicaMod.asResource("block/flap_bearing/block");
        ResourceLocation baseItemModelLocation = MechanicaMod.asResource("block/bearing/item");
        ResourceLocation topTextureLocation = MechanicaMod.asResource("block/flap_bearing/top");
        ResourceLocation baseTextureLocation = MechanicaMod.asResource("block/flap_bearing");
        return b -> b.initialProperties(SharedProperties::stone)
                .properties(p -> p.noOcclusion())
                .blockstate((c, p) -> p.directionalBlock(c.get(), p.models()
                        .withExistingParent(c.getName(), baseBlockModelLocation)
                        .texture("0", baseBlockModelLocation)
                        .texture("1", topTextureLocation)
                        .texture("2", baseTextureLocation)))
                .item()
                .model((c, p) -> p.withExistingParent(c.getName(), baseItemModelLocation)
                        .texture("0", baseBlockModelLocation)
                        .texture("1", topTextureLocation)
                        .texture("2", baseTextureLocation))
                .build();
    }

}
