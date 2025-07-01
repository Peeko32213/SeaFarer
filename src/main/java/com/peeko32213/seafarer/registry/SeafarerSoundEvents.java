package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SeaFarer.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeafarerSoundEvents {
    public static final DeferredRegister<SoundEvent> DEF_REG = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SeaFarer.MODID);

    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return DEF_REG.register(soundName, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SeaFarer.MODID, soundName)));
    }
}
