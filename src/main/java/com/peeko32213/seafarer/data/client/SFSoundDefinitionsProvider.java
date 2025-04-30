package com.peeko32213.seafarer.data.client;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class SFSoundDefinitionsProvider extends SoundDefinitionsProvider {

    public SFSoundDefinitionsProvider(PackOutput packOutput, ExistingFileHelper helper) {
        super(packOutput, SeaFarer.MODID, helper);
    }

    @Override
    public void registerSounds() {
        this.addBasicSound(SFSounds.SEAGLASS_PLACE,
                sound(SeaFarer.modPrefix("block/sea_glass_place_0"))
        );
        this.addBasicSound(SFSounds.SEAGLASS_BREAK,
                sound(SeaFarer.modPrefix("block/sea_glass_break_0"))
        );
        this.addBasicSound(SFSounds.SEAGLASS_STEP,
                sound(SeaFarer.modPrefix("block/sea_glass_step_0")),
                sound(SeaFarer.modPrefix("block/sea_glass_step_1"))
        );
    }

    private void addBasicSound(Supplier<SoundEvent> soundEvent, String subtitle, SoundDefinition.Sound... sounds) {
        this.add(soundEvent.get(), SoundDefinition.definition().subtitle("subtitles." + subtitle).with(sounds));
    }

    private void addBasicSound(Supplier<SoundEvent> soundEvent, SoundDefinition.Sound... sounds){
        this.addBasicSound(soundEvent, soundEvent.get().getLocation().getPath(), sounds);
    }

    private void addMusicDiscSound(Supplier<SoundEvent> soundEvent, String name) {
        this.add(soundEvent.get(), SoundDefinition.definition().with(sound(SeaFarer.modPrefix("records/" + name)).stream()));
    }
}
