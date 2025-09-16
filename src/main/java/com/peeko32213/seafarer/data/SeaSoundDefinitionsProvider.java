package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaSoundEvents;
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
        this.sound(SeaSoundEvents.FISH_HURT,
                sound("entity/fish/hurt1"),
                sound("entity/fish/hurt2"),
                sound("entity/fish/hurt3"),
                sound("entity/fish/hurt4")
        );
        this.sound(SeaSoundEvents.FISH_DEATH,
                sound("entity/fish/hurt1"),
                sound("entity/fish/hurt2"),
                sound("entity/fish/hurt3"),
                sound("entity/fish/hurt4")
        );
        this.sound(SeaSoundEvents.FISH_FLOP,
                sound("entity/fish/flop1").volume(0.3F),
                sound("entity/fish/flop2").volume(0.3F),
                sound("entity/fish/flop3").volume(0.3F),
                sound("entity/fish/flop4").volume(0.3F)
        );
        this.sound(SeaSoundEvents.FISH_JUMP,
                sound("mob/dolphin/jump1").volume(0.75F),
                sound("mob/dolphin/jump2").volume(0.75F),
                sound("mob/dolphin/jump3").volume(0.75F)
        );
    }

    private void soundDefinition(Supplier<SoundEvent> soundEvent, String subtitle, SoundDefinition.Sound... sounds) {
        this.add(soundEvent.get(), SoundDefinition.definition().subtitle("subtitles.rainbowreef." + subtitle).with(sounds));
    }

    private void sound(Supplier<SoundEvent> soundEvent, SoundDefinition.Sound... sounds){
        this.soundDefinition(soundEvent, soundEvent.get().getLocation().getPath(), sounds);
    }
}
