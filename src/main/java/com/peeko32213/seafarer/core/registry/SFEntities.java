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

    public static final RegistryObject<EntityType<EntitySquirrelfish>> SQUIRRELFISH = ENTITIES.register("squirrelfish",
            () -> EntityType.Builder.of(EntitySquirrelfish::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.75F)
                    .build(new ResourceLocation(SeaFarer.MODID, "squirrelfish").toString()));
}
