package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.entities.*;
import com.peeko32213.seafarer.entities.misc.unimplemented.*;
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
//
    public static final RegistryObject<EntityType<GardenEel>> GARDEN_EEL = ENTITY_TYPES.register(
            "garden_eel", () ->
                EntityType.Builder.of(GardenEel::new, MobCategory.WATER_AMBIENT)
                        .sized(0.7F, 0.5F)
                   .build(new ResourceLocation(Seafarer.MOD_ID, "garden_eel").toString()));

    public static final RegistryObject<EntityType<MandarinGoby>> MANDARIN_GOBY = ENTITY_TYPES.register(
            "mandarin_goby", () ->
                    EntityType.Builder.of(MandarinGoby::new, MobCategory.WATER_AMBIENT)
                            .sized(0.5F, 0.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "mandarin_goby").toString()));

//    public static final RegistryObject<EntityType<SexyShrimpEntity>> SEXY_SHRIMP = ENTITY_TYPE.register("sexy_shrimp",
//            () -> EntityType.Builder.of(SexyShrimpEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "sexy_shrimp").toString()));
//
//   public static final RegistryObject<EntityType<Frogfish>> FROG_FISH = ENTITY_TYPES.register(
//          "frogfish", () ->
//               EntityType.Builder.of(Frogfish::new, MobCategory.WATER_AMBIENT)
//                     .sized(0.5F, 0.5F)
//                 .build(new ResourceLocation(Seafarer.MOD_ID, "frogfish").toString()));

//
//    public static final RegistryObject<EntityType<MantisShrimpEntity>> MANTIS_SHRIMP = ENTITY_TYPE.register("mantis_shrimp",
//            () -> EntityType.Builder.of(MantisShrimpEntity::new, MobCategory.WATER_CREATURE).sized(1.0F, 0.8F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "mantis_shrimp").toString()));
//
    public static final RegistryObject<EntityType<MantaRay>> MANTA_RAY = ENTITY_TYPES.register(
            "manta_ray", () ->
                EntityType.Builder.of(MantaRay::new, MobCategory.WATER_CREATURE)
                        .sized(2.5F, 1.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "manta_ray").toString()));
//
//    public static final RegistryObject<EntityType<ParrotfishEntity>> PARROTFISH = ENTITY_TYPE.register("parrotfish",
//            () -> EntityType.Builder.of(ParrotfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.75F, 0.75F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "parrotfish").toString()));
//
//    public static final RegistryObject<EntityType<Filefish>> FILEFISH = ENTITY_TYPES.register(
//            "filefish", () ->
 //               EntityType.Builder.of(Filefish::new, MobCategory.WATER_AMBIENT)
   //                     .sized(0.3F, 0.3F)
  //                  .build(new ResourceLocation(Seafarer.MOD_ID, "filefish").toString()));
//
//    public static final RegistryObject<EntityType<LeafyScorpionfish>> LEAFY_SCORPIONFISH = ENTITY_TYPES.register(
//            "leafy_scorpionfish", () ->
//                EntityType.Builder.of(LeafyScorpionfish::new, MobCategory.WATER_AMBIENT)
//                        .sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "leafy_scorpionfish").toString()));
//
//    public static final RegistryObject<EntityType<ZebraSharkEntity>> ZEBRA_SHARK = ENTITY_TYPE.register("zebra_shark",
//            () -> EntityType.Builder.of(ZebraSharkEntity::new, MobCategory.WATER_CREATURE).sized(2.0F, 1.35F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "zebra_shark").toString()));
//
//  public static final RegistryObject<EntityType<Chimaera>> CHIMAERA = ENTITY_TYPES.register(
//          "chimaera", () ->
//             EntityType.Builder.of(Chimaera::new, MobCategory.WATER_AMBIENT)
//                     .sized(1.25F, 1.0F)
//                 .build(new ResourceLocation(Seafarer.MOD_ID, "chimaera").toString()));
//
//    public static final RegistryObject<EntityType<SpiderCrabEntity>> SPIDER_CRAB = ENTITY_TYPE.register("spider_crab",
//            () -> EntityType.Builder.of(SpiderCrabEntity::new, MobCategory.WATER_AMBIENT).sized(3.0F, 2.0F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "spider_crab").toString()));
//
//    public static final RegistryObject<EntityType<SquirrelfishEntity>> SQUIRRELFISH = ENTITY_TYPE.register("squirrelfish",
//            () -> EntityType.Builder.of(SquirrelfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
//                    .build(new ResourceLocation(Seafarer.MOD_ID, "squirrelfish").toString()));

}
