package com.peeko32213.seafarer.core.registry.blocks;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.block.entity.SFNetBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SeaFarer.MODID);


    public static final RegistryObject<BlockEntityType<SFNetBlockEntity>> NET_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("net_block_entity", () ->
                    BlockEntityType.Builder.of(SFNetBlockEntity::new,
                            SFBlocks.FISHING_NET.get()).build(null));
}
