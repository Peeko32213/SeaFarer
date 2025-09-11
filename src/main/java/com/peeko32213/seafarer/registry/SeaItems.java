package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.items.*;
import com.peeko32213.seafarer.registry.enums.*;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SeaItems {

    public static List<RegistryObject<? extends Item>> AUTO_TRANSLATE = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Seafarer.MOD_ID);

    public static final RegistryObject<Item> SEA_GLASS_PEBBLES = registerItem("sea_glass_pebbles", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEgg("horseshoe_crab", SeaEntities.HORSESHOE_CRAB , 0x251a13, 0x473d2c);
    public static final RegistryObject<Item> MANTA_RAY_SPAWN_EGG = registerSpawnEgg("manta_ray", SeaEntities.MANTA_RAY , 0x070708, 0xedf5f5);
//    public static final RegistryObject<Item> MARINE_IGUANA_SPAWN_EGG = registerSpawnEgg("marine_iguana", SeafarerEntities.MARINE_IGUANA , 0xb43324, 0x4fdecb);
    public static final RegistryObject<Item> SHORE_CRAB_SPAWN_EGG = registerSpawnEgg("shore_crab", SeaEntities.SHORE_CRAB, 0xf3901f, 0x92fedb);
    public static final RegistryObject<Item> SUNFISH_SPAWN_EGG = registerSpawnEgg("sunfish", SeaEntities.SUNFISH , 0x628398, 0x33436b);

    public static final RegistryObject<Item> RAW_SHORE_CRAB_LEG = registerItemNoLang("shore_crab_leg", () -> new Item(new Item.Properties().food(SeaFoodValues.RAW_SHORE_CRAB)));
    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = registerItemNoLang("horseshoe_crab", () -> new Item(new Item.Properties().food(SeaFoodValues.RAW_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> RAW_MARINE_IGUANA_TAIL = registerItemNoLang("marine_iguana_tail", () -> new Item(new Item.Properties().food(SeaFoodValues.RAW_MARINE_IGUANA)));

    public static final RegistryObject<Item> COOKED_SHORE_CRAB_LEG = registerItem("cooked_shore_crab_leg", () -> new Item(new Item.Properties().food(SeaFoodValues.COOKED_SHORE_CRAB)));
    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = registerItem("cooked_horseshoe_crab", () -> new Item(new Item.Properties().food(SeaFoodValues.COOKED_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> COOKED_MARINE_IGUANA_TAIL = registerItem("cooked_marine_iguana_tail", () -> new Item(new Item.Properties().food(SeaFoodValues.COOKED_MARINE_IGUANA)));
    public static final RegistryObject<Item> DRIED_STARFISH = registerItem("dried_starfish", () -> new Item(new Item.Properties().food(SeaFoodValues.COOKED_STARFISH)));

    public static final RegistryObject<Item> SOY_SAUCE = registerItem("soy_sauce", () -> new SeaDrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(SeaFoodValues.SOY_SAUCE), false, false));
    public static final RegistryObject<Item> SEA_SALT = registerItem("sea_salt", () -> new Item(new Item.Properties().food(SeaFoodValues.SALT)));

    public static final RegistryObject<Item> SHORE_CRAB_BUCKET = registerItemNoLang("shore_crab_bucket", () -> new SeaMobBucketItem(SeaEntities.SHORE_CRAB, () -> Fluids.WATER, false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HORSESHOE_CRAB_BUCKET = registerItemNoLang("horseshoe_crab_bucket", () -> new SeaMobBucketItem(SeaEntities.HORSESHOE_CRAB, () -> Fluids.WATER, false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> AMBER_CORAL_FAN = ITEMS.register("amber_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.AMBER_CORAL_FAN.get(), SeaBlocks.AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_AMBER_CORAL_FAN = ITEMS.register("dead_amber_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.DEAD_AMBER_CORAL_FAN.get(), SeaBlocks.DEAD_AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> CERULEAN_CORAL_FAN = ITEMS.register("cerulean_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.CERULEAN_CORAL_FAN.get(), SeaBlocks.CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_CERULEAN_CORAL_FAN = ITEMS.register("dead_cerulean_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.DEAD_CERULEAN_CORAL_FAN.get(), SeaBlocks.DEAD_CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> MAROON_CORAL_FAN = ITEMS.register("maroon_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.MAROON_CORAL_FAN.get(), SeaBlocks.MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_MAROON_CORAL_FAN = ITEMS.register("dead_maroon_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.DEAD_MAROON_CORAL_FAN.get(), SeaBlocks.DEAD_MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> OLIVE_CORAL_FAN = ITEMS.register("olive_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.OLIVE_CORAL_FAN.get(), SeaBlocks.OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_OLIVE_CORAL_FAN = ITEMS.register("dead_olive_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.DEAD_OLIVE_CORAL_FAN.get(), SeaBlocks.DEAD_OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> TURQUOISE_CORAL_FAN = ITEMS.register("turquoise_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.TURQUOISE_CORAL_FAN.get(), SeaBlocks.TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_TURQUOISE_CORAL_FAN = ITEMS.register("dead_turquoise_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.DEAD_TURQUOISE_CORAL_FAN.get(), SeaBlocks.DEAD_TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> VERDANT_CORAL_FAN = ITEMS.register("verdant_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.VERDANT_CORAL_FAN.get(), SeaBlocks.VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_VERDANT_CORAL_FAN = ITEMS.register("dead_verdant_coral_fan", () -> new StandingAndWallBlockItem(SeaBlocks.DEAD_VERDANT_CORAL_FAN.get(), SeaBlocks.DEAD_VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    public static final RegistryObject<Item> SEA_URCHIN = registerItem("sea_urchin", () -> new ItemNameBlockItem(SeaBlocks.SEA_URCHIN.get(), new Item.Properties().food(SeaFoodValues.SALTED_COD)) {
        @Override
        public void registerBlocks(Map<Block, Item> blockItemMap, Item item) {
            super.registerBlocks(blockItemMap, item);
            blockItemMap.put(SeaBlocks.SEA_URCHIN.get(), item);
        }
        @Override
        public void removeFromBlockToItemMap(Map<Block, Item> blockItemMap, Item item) {
            super.removeFromBlockToItemMap(blockItemMap, item);
            blockItemMap.remove(SeaBlocks.SEA_URCHIN.get());
        }
    });

    public static RegistryObject<Item> registerSpawnEgg(String name, RegistryObject type, int baseColor, int spotColor) {
        return registerItem(name + "_spawn_egg", () -> new ForgeSpawnEggItem(type, baseColor, spotColor, new Item.Properties()));
    }

    public static <I extends Item> RegistryObject<I> registerItemNoLang(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = ITEMS.register(name, supplier);
        return item;
    }

    public static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = ITEMS.register(name, supplier);
        AUTO_TRANSLATE.add(item);
        return item;
    }
}
