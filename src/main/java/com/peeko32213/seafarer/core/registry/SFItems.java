package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SFItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            SeaFarer.MODID);

    public static final RegistryObject<ForgeSpawnEggItem> SUNFISH_SPAWN_EGG = registerSpawnEggs("sunfish_spawn_egg",
            SFEntities.SUNFISH , 0x628398, 0x33436b);

    public static final RegistryObject<ForgeSpawnEggItem> CRAB_SPAWN_EGG = registerSpawnEggs("crab_spawn_egg",
            SFEntities.CRAB , 0xed5515, 0xffdf4f);

    public static final RegistryObject<ForgeSpawnEggItem> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEggs("horseshoe_crab_spawn_egg",
            SFEntities.HORSESHOE_CRAB , 0x2d2219, 0x473d2c);

    public static final RegistryObject<ForgeSpawnEggItem> MARINE_IGUANA_SPAWN_EGG = registerSpawnEggs("marine_iguana_spawn_egg",
            SFEntities.MARINE_IGUANA , 0xb43324, 0x4fdecb);

    private static RegistryObject<ForgeSpawnEggItem> registerSpawnEggs(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        return ITEMS.register(name, () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor,new Item.Properties()));
    }

}
