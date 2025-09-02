package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.items.*;
import com.peeko32213.seafarer.registry.enums.*;
import net.minecraft.core.Direction;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
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

    public static final RegistryObject<Item> CRAB_SPAWN_EGG = registerSpawnEggItem("crab", SeafarerEntities.CRAB , 0xed5515, 0xffdf4f);
    public static final RegistryObject<Item> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEggItem("horseshoe_crab", SeafarerEntities.HORSESHOE_CRAB , 0x2d2219, 0x473d2c);
    public static final RegistryObject<Item> MANTA_RAY_SPAWN_EGG = registerSpawnEggItem("manta_ray", SeafarerEntities.MANTA_RAY , 0x070708, 0xedf5f5);
    //public static final RegistryObject<Item> MARINE_IGUANA_SPAWN_EGG = registerSpawnEggItem("marine_iguana", SeafarerEntities.MARINE_IGUANA , 0xb43324, 0x4fdecb);
    public static final RegistryObject<Item> PARROTFISH_SPAWN_EGG = registerSpawnEggItem("parrotfish", SeafarerEntities.PARROTFISH , 0x2ac9e5, 0xfbb1ea);
    public static final RegistryObject<Item> SUNFISH_SPAWN_EGG = registerSpawnEggItem("sunfish", SeafarerEntities.SUNFISH , 0x628398, 0x33436b);
    public static final RegistryObject<Item> SARDINE_SPAWN_EGG = registerSpawnEggItem("sardine", SeafarerEntities.SARDINE , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> SCALLOP_SPAWN_EGG = registerSpawnEggItem("scallop", SeafarerEntities.SCALLOP , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> FLOUNDER_SPAWN_EGG = registerSpawnEggItem("flounder", SeafarerEntities.FLOUNDER , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> MAHI_MAHI_SPAWN_EGG = registerSpawnEggItem("mahi_mahi", SeafarerEntities.MAHI_MAHI , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> SHARK_SPAWN_EGG = registerSpawnEggItem("shark", SeafarerEntities.SHARK , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> SEA_CUCUMBER_SPAWN_EGG = registerSpawnEggItem("sea_cucumber", SeafarerEntities.SEA_CUCMBER , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> MAN_O_WAR_SPAWN_EGG = registerSpawnEggItem("man_o_war", SeafarerEntities.MAN_O_WAR , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> THRESHER_SHARK_SPAWN_EGG = registerSpawnEggItem("thresher_shark", SeafarerEntities.THRESHER_SHARK , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> TUNA_SPAWN_EGG = registerSpawnEggItem("tuna", SeafarerEntities.TUNA , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> BOWHEAD_SPAWN_EGG = registerSpawnEggItem("bowhead", SeafarerEntities.BOWHEAD_WHALE , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> SAILFISH_SPAWN_EGG = registerSpawnEggItem("sailfish", SeafarerEntities.SAILFISH , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> LEAFY_SEA_DRAGON_SPAWN_EGG = registerSpawnEggItem("leafy_sea_dragon", SeafarerEntities.LEAFY_SEA_DRAGON , 0xdfe2e3, 0xb014ef);
    public static final RegistryObject<Item> WHALE_SHARK_SPAWN_EGG = registerSpawnEggItem("whale_shark", SeafarerEntities.WHALE_SHARK , 0xdfe2e3, 0xb014ef);

    public static final RegistryObject<Item> RAW_CRAB_LEG = registerItemNoLang("crab_leg", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_SHORE_CRAB)));
    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = registerItemNoLang("horseshoe_crab", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> RAW_MARINE_IGUANA_TAIL = registerItemNoLang("marine_iguana_tail", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_MARINE_IGUANA)));

    public static final RegistryObject<Item> COOKED_CRAB_LEG = registerItem("cooked_crab_leg", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_SHORE_CRAB)));
    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = registerItem("cooked_horseshoe_crab", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> COOKED_MARINE_IGUANA_TAIL = registerItem("cooked_marine_iguana_tail", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_MARINE_IGUANA)));
    public static final RegistryObject<Item> COOKED_STARFISH = registerItem("cooked_starfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_STARFISH)));

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
