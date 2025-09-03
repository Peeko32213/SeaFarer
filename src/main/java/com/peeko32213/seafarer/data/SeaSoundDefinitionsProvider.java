package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class SeaSoundDefinitionsProvider extends SoundDefinitionsProvider {

    public SeaSoundDefinitionsProvider(PackOutput packOutput, ExistingFileHelper helper) {
        super(packOutput, Seafarer.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
    }

    private void addBasicSound(Supplier<SoundEvent> soundEvent, String subtitle, SoundDefinition.Sound... sounds) {
        this.add(soundEvent.get(), SoundDefinition.definition().subtitle("subtitles." + subtitle).with(sounds));
    }

    private void addBasicSound(Supplier<SoundEvent> soundEvent, SoundDefinition.Sound... sounds){
        this.addBasicSound(soundEvent, soundEvent.get().getLocation().getPath(), sounds);
    }

    private void addMusicDiscSound(Supplier<SoundEvent> soundEvent, String name) {
        this.add(soundEvent.get(), SoundDefinition.definition().with(sound(Seafarer.modPrefix("records/" + name)).stream()));
    }
}
