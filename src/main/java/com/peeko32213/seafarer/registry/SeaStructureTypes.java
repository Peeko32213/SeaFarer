package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.worldgen.structure.VolcanoStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeaStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Seafarer.MOD_ID);

    public static final RegistryObject<StructureType<VolcanoStructure>> VOLCANO = STRUCTURE_TYPES.register("volcano", () -> () -> VolcanoStructure.CODEC);

}
