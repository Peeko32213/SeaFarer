package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeaParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Seafarer.MOD_ID);

    public static final RegistryObject<SimpleParticleType> VOLCANIC_SMOKE = PARTICLE_TYPES.register("volcanic_smoke", () -> new SimpleParticleType(false));

}
