package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.item.ItemModFishBucket;
import com.peeko32213.seafarer.common.item.SFModFood;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
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

    public static final RegistryObject<Item> RAW_SHORE_CRAB = ITEMS.register("shore_crab_leg",
            () -> new Item(new Item.Properties().food(SFModFood.RAW_SHORE_CRAB)));

    public static final RegistryObject<Item> COOKED_SHORE_CRAB = ITEMS.register("cooked_shore_crab_leg",
            () -> new Item(new Item.Properties().food(SFModFood.COOKED_SHORE_CRAB)));


    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = ITEMS.register("raw_horseshoe_crab",
            () -> new Item(new Item.Properties().food(SFModFood.RAW_HORSESHOE_CRAB)));

    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = ITEMS.register("cooked_horseshoe_crab",
            () -> new Item(new Item.Properties().food(SFModFood.COOKED_HORSESHOE_CRAB)));

    public static final RegistryObject<Item> OLD_BOARD = ITEMS.register("old_board",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OLD_BOOT = ITEMS.register("old_boot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CAN = ITEMS.register("can",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MESSAGE_IN_A_BOTTLE = ITEMS.register("message_in_a_bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHORE_CRAB_BUCKET = ITEMS.register("shore_crab_bucket",
            () -> new ItemModFishBucket(SFEntities.CRAB, () -> Fluids.EMPTY, Items.BUCKET, false,
                    new Item.Properties().stacksTo(1)));

    private static RegistryObject<ForgeSpawnEggItem> registerSpawnEggs(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        return ITEMS.register(name, () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor,new Item.Properties()));
    }

}
