package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.entities.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeafarerEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Seafarer.MOD_ID);


    public static final RegistryObject<EntityType<Sunfish>> SUNFISH = ENTITY_TYPES.register("sunfish",
            () -> EntityType.Builder.of(Sunfish::new, MobCategory.WATER_CREATURE).sized(1.5F, 2.0F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "sunfish").toString()));

    public static final RegistryObject<EntityType<Crab>> CRAB = ENTITY_TYPES.register(
            "crab", () ->
                EntityType.Builder.of(Crab::new, MobCategory.CREATURE)
                        .sized(0.7F, 0.5F)
                   .build(new ResourceLocation(Seafarer.MOD_ID, "crab").toString()));
//
    public static final RegistryObject<EntityType<HorseshoeCrab>> HORSESHOE_CRAB = ENTITY_TYPES.register(
            "horseshoe_crab", () ->
                EntityType.Builder.of(HorseshoeCrab::new, MobCategory.CREATURE)
                        .sized(0.7F, 0.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "horseshoe_crab").toString()));
//
//    public static final RegistryObject<EntityType<MarineIguanaEntity>> MARINE_IGUANA = ENTITY_TYPE.register("marine_iguana",
//            () -> EntityType.Builder.of(MarineIguanaEntity::new, MobCategory.CREATURE).sized(1F, 0.75F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "marine_iguana").toString()));

    public static final RegistryObject<EntityType<MantaRay>> MANTA_RAY = ENTITY_TYPES.register(
            "manta_ray", () ->
                EntityType.Builder.of(MantaRay::new, MobCategory.WATER_CREATURE)
                        .sized(2.5F, 1.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "manta_ray").toString()));

    public static final RegistryObject<EntityType<Parrotfish>> PARROTFISH = ENTITY_TYPES.register("parrotfish",
            () -> EntityType.Builder.of(Parrotfish::new, MobCategory.WATER_AMBIENT).sized(0.75F, 0.75F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "parrotfish").toString()));



}
