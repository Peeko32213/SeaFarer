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

    public static final RegistryObject<EntityType<Sardine>> SARDINE = ENTITY_TYPES.register("sardine",
            () -> EntityType.Builder.of(Sardine::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.3F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "sardine").toString()));

    public static final RegistryObject<EntityType<Flounder>> FLOUNDER = ENTITY_TYPES.register("flounder",
            () -> EntityType.Builder.of(Flounder::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.2F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "flounder").toString()));

    public static final RegistryObject<EntityType<Scallop>> SCALLOP = ENTITY_TYPES.register("scallop",
            () -> EntityType.Builder.of(Scallop::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.3F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "scallop").toString()));

    public static final RegistryObject<EntityType<MahiMahi>> MAHI_MAHI = ENTITY_TYPES.register("mahi_mahi",
            () -> EntityType.Builder.of(MahiMahi::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.3F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "mahi_mahi").toString()));

    public static final RegistryObject<EntityType<Shark>> SHARK = ENTITY_TYPES.register("shark",
            () -> EntityType.Builder.of(Shark::new, MobCategory.WATER_AMBIENT).sized(1.0F, 1.0F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "shark").toString()));

    public static final RegistryObject<EntityType<SeaCucumber>> SEA_CUCMBER = ENTITY_TYPES.register("sea_cucumber",
            () -> EntityType.Builder.of(SeaCucumber::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "sea_cucumber").toString()));

    public static final RegistryObject<EntityType<ManOWar>> MAN_O_WAR = ENTITY_TYPES.register("man_o_war",
            () -> EntityType.Builder.of(ManOWar::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "man_o_war").toString()));

    public static final RegistryObject<EntityType<Sailfish>> SAILFISH = ENTITY_TYPES.register("sailfish",
            () -> EntityType.Builder.of(Sailfish::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "sailfish").toString()));

    public static final RegistryObject<EntityType<ThresherShark>> THRESHER_SHARK = ENTITY_TYPES.register("thresher_shark",
            () -> EntityType.Builder.of(ThresherShark::new, MobCategory.WATER_AMBIENT).sized(1.5F, 1.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "thresher_shark").toString()));

    public static final RegistryObject<EntityType<Tuna>> TUNA = ENTITY_TYPES.register("tuna",
            () -> EntityType.Builder.of(Tuna::new, MobCategory.WATER_AMBIENT).sized(1.5F, 1.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "tuna").toString()));

    public static final RegistryObject<EntityType<BowheadWhale>> BOWHEAD_WHALE = ENTITY_TYPES.register("bowhead_whale",
            () -> EntityType.Builder.of(BowheadWhale::new, MobCategory.WATER_AMBIENT).sized(5.0F, 5.0F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "bowhead_whale").toString()));

    public static final RegistryObject<EntityType<LeafySeaDragon>> LEAFY_SEA_DRAGON = ENTITY_TYPES.register("leafy_sea_dragon",
            () -> EntityType.Builder.of(LeafySeaDragon::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "leafy_sea_dragon").toString()));

    public static final RegistryObject<EntityType<WhaleShark>> WHALE_SHARK = ENTITY_TYPES.register("whale_shark",
            () -> EntityType.Builder.of(WhaleShark::new, MobCategory.WATER_AMBIENT).sized(5.0F, 5.0F)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "whale_shark").toString()));
}
