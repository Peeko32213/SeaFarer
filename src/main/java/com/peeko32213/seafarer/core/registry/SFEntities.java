package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SeaFarer.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SFEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            SeaFarer.MODID);

    public static final RegistryObject<EntityType<EntitySunfish>> SUNFISH = ENTITIES.register("sunfish",
            () -> EntityType.Builder.of(EntitySunfish::new, MobCategory.WATER_CREATURE).sized(2.5F, 1.75F)
                    .build(new ResourceLocation(SeaFarer.MODID, "sunfish").toString()));

    public static final RegistryObject<EntityType<EntityCrab>> CRAB = ENTITIES.register("crab",
            () -> EntityType.Builder.of(EntityCrab::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "crab").toString()));

    public static final RegistryObject<EntityType<EntityHorseshoeCrab>> HORSESHOE_CRAB = ENTITIES.register("horseshoe_crab",
            () -> EntityType.Builder.of(EntityHorseshoeCrab::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "horseshoe_crab").toString()));

    public static final RegistryObject<EntityType<EntityMarineIguana>> MARINE_IGUANA = ENTITIES.register("marine_iguana",
            () -> EntityType.Builder.of(EntityMarineIguana::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "marine_iguana").toString()));

    public static final RegistryObject<EntityType<EntityGardenEel>> GARDEN_EEL = ENTITIES.register("garden_eel",
            () -> EntityType.Builder.of(EntityGardenEel::new, MobCategory.WATER_AMBIENT).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "garden_eel").toString()));

    public static final RegistryObject<EntityType<EntityMandarinGoby>> MANDARIN_GOBY = ENTITIES.register("mandarin_goby",
            () -> EntityType.Builder.of(EntityMandarinGoby::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "mandarin_goby").toString()));

    public static final RegistryObject<EntityType<EntitySexyShrimp>> SEXY_SHRIMP = ENTITIES.register("sexy_shrimp",
            () -> EntityType.Builder.of(EntitySexyShrimp::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "sexy_shrimp").toString()));

    public static final RegistryObject<EntityType<EntityFrogfish>> FROG_FISH = ENTITIES.register("frogfish",
            () -> EntityType.Builder.of(EntityFrogfish::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "frogfish").toString()));

    public static final RegistryObject<EntityType<EntityBlueTang>> BLUE_TANG = ENTITIES.register("blue_tang",
            () -> EntityType.Builder.of(EntityBlueTang::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "blue_tang").toString()));

    public static final RegistryObject<EntityType<EntityCopperbandButterfly>> COPPERBAND_BUTTERFLY = ENTITIES.register("copperband_butterfly",
            () -> EntityType.Builder.of(EntityCopperbandButterfly::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "copperband_butterfly").toString()));

    public static final RegistryObject<EntityType<EntityMantisShrimp>> MANTIS_SHRIMP = ENTITIES.register("mantis_shrimp",
            () -> EntityType.Builder.of(EntityMantisShrimp::new, MobCategory.WATER_CREATURE).sized(1.0F, 0.8F)
                    .build(new ResourceLocation(SeaFarer.MODID, "mantis_shrimp").toString()));
}
