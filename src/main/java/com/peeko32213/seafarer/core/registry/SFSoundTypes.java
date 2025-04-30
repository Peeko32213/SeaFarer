package com.peeko32213.seafarer.core.registry;

import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;

public class SFSoundTypes {
    public static final SoundType SEAGLASS = new ForgeSoundType(1.0F, 1.0F, () -> SFSounds.SEAGLASS_BREAK.get(), () -> SFSounds.SEAGLASS_STEP.get(), () -> SFSounds.SEAGLASS_PLACE.get(), () -> SFSounds.SEAGLASS_BREAK.get(), () -> SFSounds.SEAGLASS_STEP.get());
}
