package com.peeko32213.seafarer.registry;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.loot.modifier.AddItemModifier;
import com.peeko32213.seafarer.loot.modifier.AddLootTableModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SeaFarer.MODID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE = LOOT_MODIFIERS.register("add_loot_table", AddLootTableModifier.CODEC);

}