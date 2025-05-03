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

    public static final RegistryObject<EntityType<SunfishEntity>> SUNFISH = ENTITIES.register("sunfish",
            () -> EntityType.Builder.of(SunfishEntity::new, MobCategory.WATER_CREATURE).sized(1.5F, 2.0F)
                    .build(new ResourceLocation(SeaFarer.MODID, "sunfish").toString()));

    public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITIES.register("crab",
            () -> EntityType.Builder.of(CrabEntity::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "crab").toString()));

    public static final RegistryObject<EntityType<HorseshoeCrabEntity>> HORSESHOE_CRAB = ENTITIES.register("horseshoe_crab",
            () -> EntityType.Builder.of(HorseshoeCrabEntity::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "horseshoe_crab").toString()));

    public static final RegistryObject<EntityType<MarineIguanaEntity>> MARINE_IGUANA = ENTITIES.register("marine_iguana",
            () -> EntityType.Builder.of(MarineIguanaEntity::new, MobCategory.CREATURE).sized(1F, 0.75F)
                    .build(new ResourceLocation(SeaFarer.MODID, "marine_iguana").toString()));

    public static final RegistryObject<EntityType<GardenEelEntity>> GARDEN_EEL = ENTITIES.register("garden_eel",
            () -> EntityType.Builder.of(GardenEelEntity::new, MobCategory.WATER_AMBIENT).sized(0.7F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "garden_eel").toString()));

    public static final RegistryObject<EntityType<MandarinGobyEntity>> MANDARIN_GOBY = ENTITIES.register("mandarin_goby",
            () -> EntityType.Builder.of(MandarinGobyEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "mandarin_goby").toString()));

    public static final RegistryObject<EntityType<SexyShrimpEntity>> SEXY_SHRIMP = ENTITIES.register("sexy_shrimp",
            () -> EntityType.Builder.of(SexyShrimpEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "sexy_shrimp").toString()));

    public static final RegistryObject<EntityType<FrogfishEntity>> FROG_FISH = ENTITIES.register("frogfish",
            () -> EntityType.Builder.of(FrogfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "frogfish").toString()));

    public static final RegistryObject<EntityType<BlueTangEntity>> BLUE_TANG = ENTITIES.register("blue_tang",
            () -> EntityType.Builder.of(BlueTangEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "blue_tang").toString()));

    public static final RegistryObject<EntityType<CopperbandButterflyfishEntity>> COPPERBAND_BUTTERFLY = ENTITIES.register("copperband_butterflyfish",
            () -> EntityType.Builder.of(CopperbandButterflyfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "copperband_butterflyfish").toString()));

    public static final RegistryObject<EntityType<MantisShrimpEntity>> MANTIS_SHRIMP = ENTITIES.register("mantis_shrimp",
            () -> EntityType.Builder.of(MantisShrimpEntity::new, MobCategory.WATER_CREATURE).sized(1.0F, 0.8F)
                    .build(new ResourceLocation(SeaFarer.MODID, "mantis_shrimp").toString()));

    public static final RegistryObject<EntityType<MantaRayEntity>> MANTA_RAY = ENTITIES.register("manta_ray",
            () -> EntityType.Builder.of(MantaRayEntity::new, MobCategory.WATER_CREATURE).sized(2.5F, 1.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "manta_ray").toString()));

    public static final RegistryObject<EntityType<ParrotfishEntity>> PARROTFISH = ENTITIES.register("parrotfish",
            () -> EntityType.Builder.of(ParrotfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.75F, 0.75F)
                    .build(new ResourceLocation(SeaFarer.MODID, "parrotfish").toString()));

    public static final RegistryObject<EntityType<FilefishEntity>> FILEFISH = ENTITIES.register("filefish",
            () -> EntityType.Builder.of(FilefishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.3F)
                    .build(new ResourceLocation(SeaFarer.MODID, "filefish").toString()));

    public static final RegistryObject<EntityType<LeafyScorpionFishEntity>> LEAFY_SCORPIONFISH = ENTITIES.register("leafy_scorpionfish",
            () -> EntityType.Builder.of(LeafyScorpionFishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "leafy_scorpionfish").toString()));

    public static final RegistryObject<EntityType<ZebraSharkEntity>> ZEBRA_SHARK = ENTITIES.register("zebra_shark",
            () -> EntityType.Builder.of(ZebraSharkEntity::new, MobCategory.WATER_CREATURE).sized(2.0F, 1.35F)
                    .build(new ResourceLocation(SeaFarer.MODID, "zebra_shark").toString()));

    public static final RegistryObject<EntityType<ChimaeraEntity>> CHIMAERA = ENTITIES.register("chimaera",
            () -> EntityType.Builder.of(ChimaeraEntity::new, MobCategory.WATER_AMBIENT).sized(1.25F, 1.0F)
                    .build(new ResourceLocation(SeaFarer.MODID, "chimaera").toString()));

    public static final RegistryObject<EntityType<SpiderCrabEntity>> SPIDER_CRAB = ENTITIES.register("spider_crab",
            () -> EntityType.Builder.of(SpiderCrabEntity::new, MobCategory.WATER_AMBIENT).sized(3.0F, 2.0F)
                    .build(new ResourceLocation(SeaFarer.MODID, "spider_crab").toString()));

    public static final RegistryObject<EntityType<BarreleyeEntity>> BARRELEYE = ENTITIES.register("barreleye",
            () -> EntityType.Builder.of(BarreleyeEntity::new, MobCategory.WATER_AMBIENT).sized(0.8F, 0.8F)
                    .build(new ResourceLocation(SeaFarer.MODID, "barreleye").toString()));

    public static final RegistryObject<EntityType<SquirrelfishEntity>> SQUIRRELFISH = ENTITIES.register("squirrelfish",
            () -> EntityType.Builder.of(SquirrelfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(SeaFarer.MODID, "squirrelfish").toString()));

}
