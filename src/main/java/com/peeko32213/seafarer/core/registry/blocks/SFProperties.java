package com.peeko32213.seafarer.core.registry.blocks;

import com.teamabnormals.blueprint.core.util.PropertyUtil;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SFProperties {

    public static final class Blocks {

        public static BlockBehaviour.Properties seaglass() {
            return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).strength(2.0F, 1.0F).sound(SoundType.AMETHYST);
        }

        public static final BlockBehaviour.Properties SEAGLASS_GLASS = seaglass().noOcclusion().isValidSpawn(PropertyUtil::never).strength(2.0F);

    }
}

