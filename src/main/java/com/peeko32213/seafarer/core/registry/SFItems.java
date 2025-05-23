package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.item.MessageInABottleItem;
import com.peeko32213.seafarer.common.item.SFDrinkableItem;
import com.peeko32213.seafarer.common.item.SFFishBucket;
import com.peeko32213.seafarer.common.item.SFFood;
import net.minecraft.core.Direction;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SFItems {

    public static List<RegistryObject<? extends Item>> AUTO_TRANSLATE = new ArrayList<>();

    public static Item.Properties drinkItem() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SeaFarer.MODID);

    public static final RegistryObject<ForgeSpawnEggItem> BARRELEYE_SPAWN_EGG = registerSpawnEggs("barreleye_spawn_egg", SFEntities.BARRELEYE , 0x293530, 0x58904a);
    public static final RegistryObject<ForgeSpawnEggItem> BLUE_TANG_SPAWN_EGG = registerSpawnEggs("blue_tang_spawn_egg", SFEntities.BLUE_TANG , 0x3688bf, 0x0d0b39);
    public static final RegistryObject<ForgeSpawnEggItem> CHIMAERA_SPAWN_EGG = registerSpawnEggs("chimaera_shark_spawn_egg", SFEntities.CHIMAERA , 0x2e2e3a, 0x7b7d86);
    public static final RegistryObject<ForgeSpawnEggItem> COPPERBAND_BUTTERFLY_SPAWN_EGG = registerSpawnEggs("copperband_butterfly_spawn_egg", SFEntities.COPPERBAND_BUTTERFLY , 0xb15d24, 0xeae1d8);
    public static final RegistryObject<ForgeSpawnEggItem> CRAB_SPAWN_EGG = registerSpawnEggs("crab_spawn_egg", SFEntities.CRAB , 0xed5515, 0xffdf4f);
    public static final RegistryObject<ForgeSpawnEggItem> FILEFISH_SPAWN_EGG = registerSpawnEggs("filefish_spawn_egg", SFEntities.FILEFISH , 0x20a8c9, 0xfeec46);
    public static final RegistryObject<ForgeSpawnEggItem> FROG_FISH_SPAWN_EGG = registerSpawnEggs("frog_fish_spawn_egg", SFEntities.FROG_FISH , 0xd8bebe, 0xbf3535);
    public static final RegistryObject<ForgeSpawnEggItem> GARDEN_EEL_SPAWN_EGG = registerSpawnEggs("garden_eel_spawn_egg", SFEntities.GARDEN_EEL , 0xdcdccc, 0x1c1604);
    public static final RegistryObject<ForgeSpawnEggItem> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEggs("horseshoe_crab_spawn_egg", SFEntities.HORSESHOE_CRAB , 0x2d2219, 0x473d2c);
    public static final RegistryObject<ForgeSpawnEggItem> LEAFY_SCORPIONFISH_SPAWN_EGG = registerSpawnEggs("leafy_scorpionfish_spawn_egg", SFEntities.LEAFY_SCORPIONFISH , 0xa6801e, 0xb2e44d);
    public static final RegistryObject<ForgeSpawnEggItem> MANDARIN_GOBY_SPAWN_EGG = registerSpawnEggs("mandarin_goby_spawn_egg", SFEntities.MANDARIN_GOBY , 0x07186f, 0xee7c1e);
    public static final RegistryObject<ForgeSpawnEggItem> MANTA_RAY_SPAWN_EGG = registerSpawnEggs("manta_ray_spawn_egg", SFEntities.MANTA_RAY , 0x070708, 0xedf5f5);
    public static final RegistryObject<ForgeSpawnEggItem> MANTIS_SHRIMP_SPAWN_EGG = registerSpawnEggs("mantis_shrimp_spawn_egg", SFEntities.MANTIS_SHRIMP , 0x176416, 0xcb3a52);
    public static final RegistryObject<ForgeSpawnEggItem> MARINE_IGUANA_SPAWN_EGG = registerSpawnEggs("marine_iguana_spawn_egg", SFEntities.MARINE_IGUANA , 0xb43324, 0x4fdecb);
    public static final RegistryObject<ForgeSpawnEggItem> PARROTFISH_SPAWN_EGG = registerSpawnEggs("parrotfish_spawn_egg", SFEntities.PARROTFISH , 0x2ac9e5, 0xfbb1ea);
    public static final RegistryObject<ForgeSpawnEggItem> SEXY_SHRIMP_SPAWN_EGG = registerSpawnEggs("sexy_shrimp_spawn_egg", SFEntities.SEXY_SHRIMP , 0x380604, 0xf6eef5);
    public static final RegistryObject<ForgeSpawnEggItem> SPIDER_CRAB_SPAWN_EGG = registerSpawnEggs("spider_crab_spawn_egg", SFEntities.SPIDER_CRAB , 0xd5a4a4, 0x6e0c0c);
    public static final RegistryObject<ForgeSpawnEggItem> SQUIRRELFISH_SPAWN_EGG = registerSpawnEggs("squirrelfish_spawn_egg", SFEntities.SQUIRRELFISH , 0x9e1a13, 0xe4b416);
    public static final RegistryObject<ForgeSpawnEggItem> SUNFISH_SPAWN_EGG = registerSpawnEggs("sunfish_spawn_egg", SFEntities.SUNFISH , 0x628398, 0x33436b);
    public static final RegistryObject<ForgeSpawnEggItem> ZEBRA_SHARK_SPAWN_EGG = registerSpawnEggs("zebra_shark_spawn_egg", SFEntities.ZEBRA_SHARK , 0xe1e3c0, 0xab9558);

    public static final RegistryObject<Item> RAW_SHORE_CRAB = item("shore_crab_leg", () -> new Item(new Item.Properties().food(SFFood.RAW_SHORE_CRAB)));
    public static final RegistryObject<Item> COOKED_SHORE_CRAB = translatedItem("cooked_shore_crab_leg", () -> new Item(new Item.Properties().food(SFFood.COOKED_SHORE_CRAB)));
    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = item("horseshoe_crab", () -> new Item(new Item.Properties().food(SFFood.RAW_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = translatedItem("cooked_horseshoe_crab", () -> new Item(new Item.Properties().food(SFFood.COOKED_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> RAW_MARINE_IGUANA = item("marine_iguana_tail", () -> new Item(new Item.Properties().food(SFFood.RAW_MARINE_IGUANA)));
    public static final RegistryObject<Item> COOKED_MARINE_IGUANA = translatedItem("cooked_marine_iguana_tail", () -> new Item(new Item.Properties().food(SFFood.COOKED_MARINE_IGUANA)));
    public static final RegistryObject<Item> COOKED_STARFISH = translatedItem("cooked_starfish", () -> new Item(new Item.Properties().food(SFFood.COOKED_STARFISH)));
    public static final RegistryObject<Item> RAW_SQUIRRELFISH = item("squirrelfish", () -> new Item(new Item.Properties().food(SFFood.RAW_SQUIRRELFISH)));
    public static final RegistryObject<Item> COOKED_SQUIRRELFISH = translatedItem("cooked_squirrelfish", () -> new Item(new Item.Properties().food(SFFood.COOKED_SQUIRRELFISH)));
    public static final RegistryObject<Item> RAW_BLUE_TANG = item("blue_tang", () -> new Item(new Item.Properties().food(SFFood.RAW_BLUE_TANG)));
    public static final RegistryObject<Item> COOKED_BLUE_TANG = translatedItem("cooked_blue_tang", () -> new Item(new Item.Properties().food(SFFood.COOKED_BLUE_TANG)));
    public static final RegistryObject<Item> RAW_COPPERBAND_BUTTERFLYFISH = item("copperband_butterflyfish", () -> new Item(new Item.Properties().food(SFFood.RAW_COPPERBAND_BUTTERFLYFISH)));
    public static final RegistryObject<Item> COOKED_COPPERBAND_BUTTERFLYFISH = translatedItem("cooked_copperband_butterflyfish", () -> new Item(new Item.Properties().food(SFFood.COOKED_COPPERBAND_BUTTERFLYFISH)));
    public static final RegistryObject<Item> RAW_FROGFISH = item("frogfish", () -> new Item(new Item.Properties().food(SFFood.RAW_FROGFISH)));
    public static final RegistryObject<Item> COOKED_FROGFISH = translatedItem("cooked_frogfish", () -> new Item(new Item.Properties().food(SFFood.COOKED_FROGFISH)));
    public static final RegistryObject<Item> RAW_GARDEN_EEL = item("garden_eel", () -> new Item(new Item.Properties().food(SFFood.RAW_GARDEN_EEL)));
    public static final RegistryObject<Item> COOKED_GARDEN_EEL = translatedItem("cooked_garden_eel", () -> new Item(new Item.Properties().food(SFFood.COOKED_GARDEN_EEL)));
    public static final RegistryObject<Item> RAW_MANDARINFISH = item("mandarinfish", () -> new Item(new Item.Properties().food(SFFood.RAW_MANDARINFISH)));
    public static final RegistryObject<Item> COOKED_MANDARINFISH = translatedItem("cooked_mandarinfish", () -> new Item(new Item.Properties().food(SFFood.COOKED_MANDARINFISH)));
    public static final RegistryObject<Item> RAW_SEXY_SHRIMP = item("sexy_shrimp", () -> new Item(new Item.Properties().food(SFFood.RAW_SEXY_SHRIMP)));
    public static final RegistryObject<Item> COOKED_SEXY_SHRIMP = translatedItem("cooked_sexy_shrimp", () -> new Item(new Item.Properties().food(SFFood.COOKED_SEXY_SHRIMP)));

    public static final RegistryObject<Item> OLD_BOOT = ITEMS.register("old_boot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAN = ITEMS.register("can", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MESSAGE_IN_A_BOTTLE = ITEMS.register("message_in_a_bottle", () -> new MessageInABottleItem(StructureTags.ON_TREASURE_MAPS, "seafarer.message_in_bottle", MapDecoration.Type.MONUMENT,new Item.Properties()));
    public static final RegistryObject<Item> SOY_SAUCE = ITEMS.register("soy_sauce", () -> new SFDrinkableItem(drinkItem().stacksTo(16).food(SFFood.SOY_SAUCE), false, false));
    public static final RegistryObject<Item> SALT = ITEMS.register("sea_salt", () -> new Item(new Item.Properties().food(SFFood.SALT)));
    public static final RegistryObject<Item> SALTED_COD = ITEMS.register("salted_cod", () -> new Item(new Item.Properties().food(SFFood.SALTED_COD)));
    public static final RegistryObject<Item> SALTED_SALMON = ITEMS.register("salted_salmon", () -> new Item(new Item.Properties().food(SFFood.SALTED_SALMON)));
    public static final RegistryObject<Item> SALTED_TROPICAL_FISH = ITEMS.register("salted_tropical_fish", () -> new Item(new Item.Properties().food(SFFood.SALTED_TROPICAL_FISH)));
    public static final RegistryObject<Item> SALTED_STARFISH = ITEMS.register("salted_starfish", () -> new Item(new Item.Properties().food(SFFood.SALTED_STARFISH)));
    public static final RegistryObject<Item> SHORE_CRAB_BUCKET = ITEMS.register("shore_crab_bucket", () -> new SFFishBucket(SFEntities.CRAB, () -> Fluids.FLOWING_WATER, false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HORSESHOE_CRAB_BUCKET = ITEMS.register("horseshoe_crab_bucket", () -> new SFFishBucket(SFEntities.HORSESHOE_CRAB, () -> Fluids.FLOWING_WATER, false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CLAM_SHOVEL = ITEMS.register("clam_shovel", () -> new ShovelItem(SFTiers.SHELL,  1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> HORN_PICKAXE = ITEMS.register("horn_pickaxe", () -> new PickaxeItem(SFTiers.SHELL,  1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SPIKY_SWORD = ITEMS.register("spiky_sword", () -> new SwordItem(SFTiers.SHELL,  3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SPIRAL_HOE = ITEMS.register("spiral_hoe", () -> new HoeItem(SFTiers.SHELL,  0, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SWIRL_AXE = ITEMS.register("swirl_axe", () -> new AxeItem(SFTiers.SHELL,  6.0F, -3.2F, new Item.Properties()));

    public static final RegistryObject<Item> AMBER_CORAL_FAN = ITEMS.register("amber_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.AMBER_CORAL_FAN.get(), SFBlocks.AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_AMBER_CORAL_FAN = ITEMS.register("dead_amber_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.DEAD_AMBER_CORAL_FAN.get(), SFBlocks.DEAD_AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> CERULEAN_CORAL_FAN = ITEMS.register("cerulean_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.CERULEAN_CORAL_FAN.get(), SFBlocks.CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_CERULEAN_CORAL_FAN = ITEMS.register("dead_cerulean_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.DEAD_CERULEAN_CORAL_FAN.get(), SFBlocks.DEAD_CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> MAROON_CORAL_FAN = ITEMS.register("maroon_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.MAROON_CORAL_FAN.get(), SFBlocks.MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_MAROON_CORAL_FAN = ITEMS.register("dead_maroon_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.DEAD_MAROON_CORAL_FAN.get(), SFBlocks.DEAD_MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> OLIVE_CORAL_FAN = ITEMS.register("olive_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.OLIVE_CORAL_FAN.get(), SFBlocks.OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_OLIVE_CORAL_FAN = ITEMS.register("dead_olive_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.DEAD_OLIVE_CORAL_FAN.get(), SFBlocks.DEAD_OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> TURQUOISE_CORAL_FAN = ITEMS.register("turquoise_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.TURQUOISE_CORAL_FAN.get(), SFBlocks.TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_TURQUOISE_CORAL_FAN = ITEMS.register("dead_turquoise_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.DEAD_TURQUOISE_CORAL_FAN.get(), SFBlocks.DEAD_TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> VERDANT_CORAL_FAN = ITEMS.register("verdant_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.VERDANT_CORAL_FAN.get(), SFBlocks.VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_VERDANT_CORAL_FAN = ITEMS.register("dead_verdant_coral_fan", () -> new StandingAndWallBlockItem(SFBlocks.DEAD_VERDANT_CORAL_FAN.get(), SFBlocks.DEAD_VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    public static final RegistryObject<Item> SEA_GRAPES = ITEMS.register("sea_grapes", () -> new ItemNameBlockItem(SFBlocks.SEA_GRAPES_CROP.get(), new Item.Properties().food(SFFood.SALTED_COD)));
    public static final RegistryObject<Item> WAKAME = ITEMS.register("wakame", () -> new ItemNameBlockItem(SFBlocks.WAKAME.get(), new Item.Properties().food(SFFood.SALTED_COD)));
    public static final RegistryObject<Item> SEA_URCHIN = ITEMS.register("sea_urchin", () -> new ItemNameBlockItem(SFBlocks.SEA_URCHIN.get(), new Item.Properties().food(SFFood.SALTED_COD)));

    private static RegistryObject<ForgeSpawnEggItem> registerSpawnEggs(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        return ITEMS.register(name, () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor,new Item.Properties()));
    }

    public static <I extends Item> RegistryObject<I> item(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = ITEMS.register(name, supplier);
        return item;
    }

    public static <I extends Item> RegistryObject<I> translatedItem(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = ITEMS.register(name, supplier);
        AUTO_TRANSLATE.add(item);
        return item;
    }
}
