package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.items.*;
import com.peeko32213.seafarer.registry.enums.*;
import net.minecraft.core.Direction;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SeafarerItems {

    public static List<RegistryObject<? extends Item>> AUTO_TRANSLATE = new ArrayList<>();

    public static Item.Properties drinkItem() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Seafarer.MOD_ID);

    public static final RegistryObject<Item> BARRELEYE_SPAWN_EGG = registerSpawnEggItem("barreleye", SeafarerEntities.BARRELEYE , 0x293530, 0x58904a);
    public static final RegistryObject<Item> CRAB_SPAWN_EGG = registerSpawnEggItem("crab", SeafarerEntities.CRAB , 0xed5515, 0xffdf4f);
   public static final RegistryObject<Item> GARDEN_EEL_SPAWN_EGG = registerSpawnEggItem("garden_eel", SeafarerEntities.GARDEN_EEL , 0xdcdccc, 0x1c1604);
    public static final RegistryObject<Item> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEggItem("horseshoe_crab", SeafarerEntities.HORSESHOE_CRAB , 0x2d2219, 0x473d2c);
    public static final RegistryObject<Item> MANDARINFISH_SPAWN_EGG = registerSpawnEggItem("mandarinfish", SeafarerEntities.MANDARIN_GOBY , 0x07186f, 0xee7c1e);
    public static final RegistryObject<Item> MANTA_RAY_SPAWN_EGG = registerSpawnEggItem("manta_ray", SeafarerEntities.MANTA_RAY , 0x070708, 0xedf5f5);
//    public static final RegistryObject<Item> MANTIS_SHRIMP_SPAWN_EGG = registerSpawnEggItem("mantis_shrimp", SeafarerEntities.MANTIS_SHRIMP , 0x176416, 0xcb3a52);
//    public static final RegistryObject<Item> MARINE_IGUANA_SPAWN_EGG = registerSpawnEggItem("marine_iguana", SeafarerEntities.MARINE_IGUANA , 0xb43324, 0x4fdecb);
//    public static final RegistryObject<Item> PARROTFISH_SPAWN_EGG = registerSpawnEggItem("parrotfish", SeafarerEntities.PARROTFISH , 0x2ac9e5, 0xfbb1ea);
//    public static final RegistryObject<Item> SEXY_SHRIMP_SPAWN_EGG = registerSpawnEggItem("sexy_shrimp", SeafarerEntities.SEXY_SHRIMP , 0x380604, 0xf6eef5);
//    public static final RegistryObject<Item> SPIDER_CRAB_SPAWN_EGG = registerSpawnEggItem("spider_crab", SeafarerEntities.SPIDER_CRAB , 0xd5a4a4, 0x6e0c0c);
//    public static final RegistryObject<Item> SQUIRRELFISH_SPAWN_EGG = registerSpawnEggItem("squirrelfish", SeafarerEntities.SQUIRRELFISH , 0x9e1a13, 0xe4b416);
//    public static final RegistryObject<Item> SUNFISH_SPAWN_EGG = registerSpawnEggItem("sunfish", SeafarerEntities.SUNFISH , 0x628398, 0x33436b);
//    public static final RegistryObject<Item> ZEBRA_SHARK_SPAWN_EGG = registerSpawnEggItem("zebra_shark", SeafarerEntities.ZEBRA_SHARK , 0xe1e3c0, 0xab9558);

    public static final RegistryObject<Item> RAW_CRAB_LEG = registerItemNoLang("crab_leg", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_SHORE_CRAB)));
    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = registerItemNoLang("horseshoe_crab", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> RAW_MARINE_IGUANA_TAIL = registerItemNoLang("marine_iguana_tail", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_MARINE_IGUANA)));
    public static final RegistryObject<Item> RAW_SQUIRRELFISH = registerItemNoLang("squirrelfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_SQUIRRELFISH)));
    public static final RegistryObject<Item> RAW_BLUE_TANG = registerItemNoLang("blue_tang", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_BLUE_TANG)));
    public static final RegistryObject<Item> RAW_COPPERBAND_BUTTERFLYFISH = registerItemNoLang("copperband_butterflyfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_COPPERBAND_BUTTERFLYFISH)));
    public static final RegistryObject<Item> RAW_FROGFISH = registerItemNoLang("frogfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_FROGFISH)));
    public static final RegistryObject<Item> RAW_GARDEN_EEL = registerItemNoLang("garden_eel", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_GARDEN_EEL)));
    public static final RegistryObject<Item> RAW_MANDARINFISH = registerItemNoLang("mandarinfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_MANDARINFISH)));
    public static final RegistryObject<Item> RAW_SEXY_SHRIMP = registerItemNoLang("sexy_shrimp", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_SEXY_SHRIMP)));

    public static final RegistryObject<Item> COOKED_CRAB_LEG = registerItem("cooked_crab_leg", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_SHORE_CRAB)));
    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = registerItem("cooked_horseshoe_crab", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> COOKED_MARINE_IGUANA_TAIL = registerItem("cooked_marine_iguana_tail", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_MARINE_IGUANA)));
    public static final RegistryObject<Item> COOKED_STARFISH = registerItem("cooked_starfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_STARFISH)));
    public static final RegistryObject<Item> COOKED_SQUIRRELFISH = registerItem("cooked_squirrelfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_SQUIRRELFISH)));
    public static final RegistryObject<Item> COOKED_BLUE_TANG = registerItem("cooked_blue_tang", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_BLUE_TANG)));
    public static final RegistryObject<Item> COOKED_COPPERBAND_BUTTERFLYFISH = registerItem("cooked_copperband_butterflyfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_COPPERBAND_BUTTERFLYFISH)));
    public static final RegistryObject<Item> COOKED_FROGFISH = registerItem("cooked_frogfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_FROGFISH)));
    public static final RegistryObject<Item> COOKED_GARDEN_EEL = registerItem("cooked_garden_eel", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_GARDEN_EEL)));
    public static final RegistryObject<Item> COOKED_MANDARINFISH = registerItem("cooked_mandarinfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_MANDARINFISH)));
    public static final RegistryObject<Item> COOKED_SEXY_SHRIMP = registerItem("cooked_sexy_shrimp", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_SEXY_SHRIMP)));

    public static final RegistryObject<Item> OLD_BOOT = registerItem("old_boot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_CAN = registerItem("metal_can", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MESSAGE_IN_A_BOTTLE = registerItem("message_in_a_bottle", () -> new MessageInABottleItem(StructureTags.ON_TREASURE_MAPS, "seafarer.message_in_bottle", MapDecoration.Type.MONUMENT,new Item.Properties()));
    public static final RegistryObject<Item> SOY_SAUCE = registerItem("soy_sauce", () -> new SeafarerDrinkableItem(drinkItem().stacksTo(16).food(SeafarerFoodValues.SOY_SAUCE), false, false));
    public static final RegistryObject<Item> SEA_SALT = registerItem("sea_salt", () -> new Item(new Item.Properties().food(SeafarerFoodValues.SALT)));
    public static final RegistryObject<Item> SALTED_COD = registerItem("salted_cod", () -> new Item(new Item.Properties().food(SeafarerFoodValues.SALTED_COD)));
    public static final RegistryObject<Item> SALTED_SALMON = registerItem("salted_salmon", () -> new Item(new Item.Properties().food(SeafarerFoodValues.SALTED_SALMON)));
    public static final RegistryObject<Item> SALTED_TROPICAL_FISH = registerItem("salted_tropical_fish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.SALTED_TROPICAL_FISH)));
    public static final RegistryObject<Item> SALTED_STARFISH = registerItem("salted_starfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.SALTED_STARFISH)));

//    public static final RegistryObject<Item> CRAB_BUCKET = registerItemNoLang("crab_bucket", () -> new SeafarerFishBucket(SeafarerEntities.CRAB, () -> Fluids.FLOWING_WATER, false, new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<Item> HORSESHOE_CRAB_BUCKET = registerItemNoLang("horseshoe_crab_bucket", () -> new SeafarerFishBucket(SeafarerEntities.HORSESHOE_CRAB, () -> Fluids.FLOWING_WATER, false, new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<Item> SQUIRRELFISH_BUCKET = registerItemNoLang("squirrelfish_bucket", () -> new SeafarerFishBucket(SeafarerEntities.SQUIRRELFISH, () -> Fluids.FLOWING_WATER, false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CLAM_SHOVEL = registerItem("clam_shovel", () -> new ShovelItem(SeafarerTiers.SHELL,  1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> HORN_PICKAXE = registerItem("horn_pickaxe", () -> new PickaxeItem(SeafarerTiers.SHELL,  1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SPIKY_SWORD = registerItem("spiky_sword", () -> new SwordItem(SeafarerTiers.SHELL,  3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SPIRAL_HOE = registerItem("spiral_hoe", () -> new HoeItem(SeafarerTiers.SHELL,  0, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SWIRL_AXE = registerItem("swirl_axe", () -> new AxeItem(SeafarerTiers.SHELL,  6.0F, -3.2F, new Item.Properties()));

    public static final RegistryObject<Item> AMBER_CORAL_FAN = ITEMS.register("amber_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.AMBER_CORAL_FAN.get(), SeafarerBlocks.AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_AMBER_CORAL_FAN = ITEMS.register("dead_amber_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_AMBER_CORAL_FAN.get(), SeafarerBlocks.DEAD_AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> CERULEAN_CORAL_FAN = ITEMS.register("cerulean_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.CERULEAN_CORAL_FAN.get(), SeafarerBlocks.CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_CERULEAN_CORAL_FAN = ITEMS.register("dead_cerulean_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_CERULEAN_CORAL_FAN.get(), SeafarerBlocks.DEAD_CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> MAROON_CORAL_FAN = ITEMS.register("maroon_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.MAROON_CORAL_FAN.get(), SeafarerBlocks.MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_MAROON_CORAL_FAN = ITEMS.register("dead_maroon_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_MAROON_CORAL_FAN.get(), SeafarerBlocks.DEAD_MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> OLIVE_CORAL_FAN = ITEMS.register("olive_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.OLIVE_CORAL_FAN.get(), SeafarerBlocks.OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_OLIVE_CORAL_FAN = ITEMS.register("dead_olive_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_OLIVE_CORAL_FAN.get(), SeafarerBlocks.DEAD_OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> TURQUOISE_CORAL_FAN = ITEMS.register("turquoise_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.TURQUOISE_CORAL_FAN.get(), SeafarerBlocks.TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_TURQUOISE_CORAL_FAN = ITEMS.register("dead_turquoise_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_TURQUOISE_CORAL_FAN.get(), SeafarerBlocks.DEAD_TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> VERDANT_CORAL_FAN = ITEMS.register("verdant_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.VERDANT_CORAL_FAN.get(), SeafarerBlocks.VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_VERDANT_CORAL_FAN = ITEMS.register("dead_verdant_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_VERDANT_CORAL_FAN.get(), SeafarerBlocks.DEAD_VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    public static final RegistryObject<Item> SEA_GRAPES = registerItem("sea_grapes", () -> new ItemNameBlockItem(SeafarerBlocks.SEA_GRAPES_CROP.get(), new Item.Properties().food(SeafarerFoodValues.SALTED_COD)));
    public static final RegistryObject<Item> WAKAME = registerItem("wakame", () -> new ItemNameBlockItem(SeafarerBlocks.WAKAME.get(), new Item.Properties().food(SeafarerFoodValues.SALTED_COD)));
    public static final RegistryObject<Item> SEA_URCHIN = registerItem("sea_urchin", () -> new ItemNameBlockItem(SeafarerBlocks.SEA_URCHIN.get(), new Item.Properties().food(SeafarerFoodValues.SALTED_COD)) {
        @Override
        public void registerBlocks(Map<Block, Item> blockItemMap, Item item) {
            super.registerBlocks(blockItemMap, item);
            blockItemMap.put(SeafarerBlocks.SEA_URCHIN.get(), item);
        }
        @Override
        public void removeFromBlockToItemMap(Map<Block, Item> blockItemMap, Item item) {
            super.removeFromBlockToItemMap(blockItemMap, item);
            blockItemMap.remove(SeafarerBlocks.SEA_URCHIN.get());
        }
    });

    public static RegistryObject<Item> registerSpawnEggItem(String name, RegistryObject type, int baseColor, int spotColor) {
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
