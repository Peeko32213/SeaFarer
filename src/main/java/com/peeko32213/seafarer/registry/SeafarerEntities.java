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

    public static final RegistryObject<EntityType<Barreleye>> BARRELEYE = ENTITY_TYPES.register(
            "barreleye", () ->
            EntityType.Builder.of(Barreleye::new, MobCategory.WATER_AMBIENT)
                    .sized(0.8F, 0.8F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "barreleye").toString())
    );

//    public static final RegistryObject<EntityType<SunfishEntity>> SUNFISH = ENTITY_TYPE.register("sunfish",
//            () -> EntityType.Builder.of(SunfishEntity::new, MobCategory.WATER_CREATURE).sized(1.5F, 2.0F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "sunfish").toString()));
//
//    public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITY_TYPE.register("crab",
//            () -> EntityType.Builder.of(CrabEntity::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "crab").toString()));
//
//    public static final RegistryObject<EntityType<HorseshoeCrabEntity>> HORSESHOE_CRAB = ENTITY_TYPE.register("horseshoe_crab",
//            () -> EntityType.Builder.of(HorseshoeCrabEntity::new, MobCategory.CREATURE).sized(0.7F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "horseshoe_crab").toString()));
//
//    public static final RegistryObject<EntityType<MarineIguanaEntity>> MARINE_IGUANA = ENTITY_TYPE.register("marine_iguana",
//            () -> EntityType.Builder.of(MarineIguanaEntity::new, MobCategory.CREATURE).sized(1F, 0.75F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "marine_iguana").toString()));
//
//    public static final RegistryObject<EntityType<GardenEelEntity>> GARDEN_EEL = ENTITY_TYPE.register("garden_eel",
//            () -> EntityType.Builder.of(GardenEelEntity::new, MobCategory.WATER_AMBIENT).sized(0.7F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "garden_eel").toString()));
//
//    public static final RegistryObject<EntityType<MandarinGobyEntity>> MANDARIN_GOBY = ENTITY_TYPE.register("mandarin_goby",
//            () -> EntityType.Builder.of(MandarinGobyEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "mandarin_goby").toString()));
//
//    public static final RegistryObject<EntityType<SexyShrimpEntity>> SEXY_SHRIMP = ENTITY_TYPE.register("sexy_shrimp",
//            () -> EntityType.Builder.of(SexyShrimpEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "sexy_shrimp").toString()));
//
//    public static final RegistryObject<EntityType<FrogfishEntity>> FROG_FISH = ENTITY_TYPE.register("frogfish",
//            () -> EntityType.Builder.of(FrogfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "frogfish").toString()));
//
//    public static final RegistryObject<EntityType<BlueTang>> BLUE_TANG = ENTITY_TYPE.register("blue_tang",
//            () -> EntityType.Builder.of(BlueTang::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "blue_tang").toString()));
//
//    public static final RegistryObject<EntityType<CopperbandButterflyfishEntity>> COPPERBAND_BUTTERFLY = ENTITY_TYPE.register("copperband_butterflyfish",
//            () -> EntityType.Builder.of(CopperbandButterflyfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "copperband_butterflyfish").toString()));
//
//    public static final RegistryObject<EntityType<MantisShrimpEntity>> MANTIS_SHRIMP = ENTITY_TYPE.register("mantis_shrimp",
//            () -> EntityType.Builder.of(MantisShrimpEntity::new, MobCategory.WATER_CREATURE).sized(1.0F, 0.8F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "mantis_shrimp").toString()));
//
//    public static final RegistryObject<EntityType<MantaRayEntity>> MANTA_RAY = ENTITY_TYPE.register("manta_ray",
//            () -> EntityType.Builder.of(MantaRayEntity::new, MobCategory.WATER_CREATURE).sized(2.5F, 1.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "manta_ray").toString()));
//
//    public static final RegistryObject<EntityType<ParrotfishEntity>> PARROTFISH = ENTITY_TYPE.register("parrotfish",
//            () -> EntityType.Builder.of(ParrotfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.75F, 0.75F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "parrotfish").toString()));
//
//    public static final RegistryObject<EntityType<FilefishEntity>> FILEFISH = ENTITY_TYPE.register("filefish",
//            () -> EntityType.Builder.of(FilefishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.3F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "filefish").toString()));
//
//    public static final RegistryObject<EntityType<LeafyScorpionFishEntity>> LEAFY_SCORPIONFISH = ENTITY_TYPE.register("leafy_scorpionfish",
//            () -> EntityType.Builder.of(LeafyScorpionFishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "leafy_scorpionfish").toString()));
//
//    public static final RegistryObject<EntityType<ZebraSharkEntity>> ZEBRA_SHARK = ENTITY_TYPE.register("zebra_shark",
//            () -> EntityType.Builder.of(ZebraSharkEntity::new, MobCategory.WATER_CREATURE).sized(2.0F, 1.35F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "zebra_shark").toString()));
//
//    public static final RegistryObject<EntityType<Chimaera>> CHIMAERA = ENTITY_TYPE.register("chimaera",
//            () -> EntityType.Builder.of(Chimaera::new, MobCategory.WATER_AMBIENT).sized(1.25F, 1.0F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "chimaera").toString()));
//
//    public static final RegistryObject<EntityType<SpiderCrabEntity>> SPIDER_CRAB = ENTITY_TYPE.register("spider_crab",
//            () -> EntityType.Builder.of(SpiderCrabEntity::new, MobCategory.WATER_AMBIENT).sized(3.0F, 2.0F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "spider_crab").toString()));
//
//    public static final RegistryObject<EntityType<SquirrelfishEntity>> SQUIRRELFISH = ENTITY_TYPE.register("squirrelfish",
//            () -> EntityType.Builder.of(SquirrelfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "squirrelfish").toString()));

}
