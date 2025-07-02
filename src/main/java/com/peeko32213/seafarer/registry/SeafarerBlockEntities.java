package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.blocks.entity.SFNetBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Seafarer.MOD_ID);


    public static final RegistryObject<BlockEntityType<SFNetBlockEntity>> NET_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("net_block_entity", () ->
                    BlockEntityType.Builder.of(SFNetBlockEntity::new,
                            SeafarerBlocks.FISHING_NET.get()).build(null));
}
