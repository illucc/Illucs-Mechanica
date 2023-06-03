package org.valkyrienskies.mechanica;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.util.entry.BlockEntry;
import me.alphamode.forgetags.Tags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import org.valkyrienskies.mechanica.content.contraptions.physJammer.PhysJammerBlock;
import org.valkyrienskies.mechanica.content.contraptions.propellor.PropellorBearingBlock;
import org.valkyrienskies.mechanica.content.contraptions.blipdrive.BlipdriveBlock;
import org.valkyrienskies.mechanica.content.contraptions.springer.SpringerBlock;
import net.minecraft.world.level.block.Block;

import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.*;
import static org.valkyrienskies.mechanica.MechanicaMod.REGISTRATE;

public class MechanicaBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> MechanicaMod.BASE_CREATIVE_TAB);
    }

    static {
        REGISTRATE.startSection(AllSections.KINETICS);
    }

    public static final BlockEntry<PropellorBearingBlock> PROPELLOR_BEARING =
            REGISTRATE.block("propellor_bearing", PropellorBearingBlock::new)
                    .transform(axeOrPickaxe())
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(BuilderTransformers.bearing("propellor", "gearbox", false))
                    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
                    .register();
    public static final BlockEntry<BlipdriveBlock> BLIPDRIVE =
            REGISTRATE.block("blipdrive", BlipdriveBlock::new)
                    .initialProperties(SharedProperties::stone)
                    .blockstate(BlockStateGen.directionalBlockProvider(true))
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(axeOrPickaxe())
                    .transform(BlockStressDefaults.setImpact(2.0))
                    .item()
                    .transform(customItemModel())
                    .register();

    public static final BlockEntry<PhysJammerBlock> PHYSJAMMER =
            REGISTRATE.block("physjammer", PhysJammerBlock::new)
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(BuilderTransformers.bearing("physjammer", "gearbox", false))
                    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
                    .register();

    public static final BlockEntry<SpringerBlock> SPRINGER =
            REGISTRATE.block("springer", SpringerBlock::new)
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(BuilderTransformers.bearing("springer", "gearbox", false))
                    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
                    .register();

    public static final BlockEntry<Block> DAMP_GOLD_BLOCK = REGISTRATE.block("damp_gold_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.color(MaterialColor.TERRACOTTA_YELLOW))
            .properties(p -> p.requiresCorrectToolForDrops())
            .transform(pickaxeOnly())
            .blockstate(simpleCubeAll("damp_gold_block"))
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(BlockTags.BEACON_BASE_BLOCKS)
            .transform(tagBlockAndItem("storage_blocks/damp_gold"))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .lang("Block of Damp Gold")
            .register();


    public static void register() {
    }
}
