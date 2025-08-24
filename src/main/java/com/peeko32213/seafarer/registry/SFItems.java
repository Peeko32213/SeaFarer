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

public class SFItems {

    public static List<RegistryObject<? extends Item>> AUTO_TRANSLATE = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Seafarer.MOD_ID);

    public static final RegistryObject<Item> SHORE_CRAB_SPAWN_EGG = registerSpawnEgg("shore_crab", SFEntities.SHORE_CRAB, 0xf3901f, 0x92fedb);
    public static final RegistryObject<Item> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEgg("horseshoe_crab", SFEntities.HORSESHOE_CRAB , 0x251a13, 0x473d2c);
    public static final RegistryObject<Item> MANTA_RAY_SPAWN_EGG = registerSpawnEgg("manta_ray", SFEntities.MANTA_RAY , 0x070708, 0xedf5f5);
//    public static final RegistryObject<Item> MARINE_IGUANA_SPAWN_EGG = registerSpawnEgg("marine_iguana", SeafarerEntities.MARINE_IGUANA , 0xb43324, 0x4fdecb);
    public static final RegistryObject<Item> PARROTFISH_SPAWN_EGG = registerSpawnEgg("parrotfish", SFEntities.PARROTFISH , 0x2ac9e5, 0xfbb1ea);
    public static final RegistryObject<Item> SUNFISH_SPAWN_EGG = registerSpawnEgg("sunfish", SFEntities.SUNFISH , 0x628398, 0x33436b);

    public static final RegistryObject<Item> RAW_SHORE_CRAB_LEG = registerItemNoLang("shore_crab_leg", () -> new Item(new Item.Properties().food(SFFoodValues.RAW_SHORE_CRAB)));
    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = registerItemNoLang("horseshoe_crab", () -> new Item(new Item.Properties().food(SFFoodValues.RAW_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> RAW_MARINE_IGUANA_TAIL = registerItemNoLang("marine_iguana_tail", () -> new Item(new Item.Properties().food(SFFoodValues.RAW_MARINE_IGUANA)));

    public static final RegistryObject<Item> COOKED_SHORE_CRAB_LEG = registerItem("cooked_shore_crab_leg", () -> new Item(new Item.Properties().food(SFFoodValues.COOKED_SHORE_CRAB)));
    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = registerItem("cooked_horseshoe_crab", () -> new Item(new Item.Properties().food(SFFoodValues.COOKED_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> COOKED_MARINE_IGUANA_TAIL = registerItem("cooked_marine_iguana_tail", () -> new Item(new Item.Properties().food(SFFoodValues.COOKED_MARINE_IGUANA)));
    public static final RegistryObject<Item> COOKED_STARFISH = registerItem("cooked_starfish", () -> new Item(new Item.Properties().food(SFFoodValues.COOKED_STARFISH)));

    public static final RegistryObject<Item> OLD_BOOT = registerItem("old_boot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_CAN = registerItem("metal_can", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MESSAGE_IN_A_BOTTLE = registerItem("message_in_a_bottle", () -> new MessageInABottleItem(StructureTags.ON_TREASURE_MAPS, "filled_map.buried_treasure", MapDecoration.Type.RED_X,new Item.Properties()));
    public static final RegistryObject<Item> SOY_SAUCE = registerItem("soy_sauce", () -> new SFDrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(SFFoodValues.SOY_SAUCE), false, false));
    public static final RegistryObject<Item> SEA_SALT = registerItem("sea_salt", () -> new Item(new Item.Properties().food(SFFoodValues.SALT)));
    public static final RegistryObject<Item> SALTED_COD = registerItem("salted_cod", () -> new Item(new Item.Properties().food(SFFoodValues.SALTED_COD)));
    public static final RegistryObject<Item> SALTED_SALMON = registerItem("salted_salmon", () -> new Item(new Item.Properties().food(SFFoodValues.SALTED_SALMON)));
    public static final RegistryObject<Item> SALTED_TROPICAL_FISH = registerItem("salted_tropical_fish", () -> new Item(new Item.Properties().food(SFFoodValues.SALTED_TROPICAL_FISH)));
    public static final RegistryObject<Item> SALTED_STARFISH = registerItem("salted_starfish", () -> new Item(new Item.Properties().food(SFFoodValues.SALTED_STARFISH)));

    public static final RegistryObject<Item> SHORE_CRAB_BUCKET = registerItemNoLang("shore_crab_bucket", () -> new SFMobBucketItem(SFEntities.SHORE_CRAB, () -> Fluids.WATER, false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HORSESHOE_CRAB_BUCKET = registerItemNoLang("horseshoe_crab_bucket", () -> new SFMobBucketItem(SFEntities.HORSESHOE_CRAB, () -> Fluids.WATER, false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CLAM_SHOVEL = registerItem("clam_shovel", () -> new ShovelItem(SFTiers.SHELL,  1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> HORN_PICKAXE = registerItem("horn_pickaxe", () -> new PickaxeItem(SFTiers.SHELL,  1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SPIKY_SWORD = registerItem("spiky_sword", () -> new SwordItem(SFTiers.SHELL,  3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SPIRAL_HOE = registerItem("spiral_hoe", () -> new HoeItem(SFTiers.SHELL,  0, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SWIRL_AXE = registerItem("swirl_axe", () -> new AxeItem(SFTiers.SHELL,  6.0F, -3.2F, new Item.Properties()));

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

    public static final RegistryObject<Item> SEA_GRAPES = registerItem("sea_grapes", () -> new ItemNameBlockItem(SFBlocks.SEA_GRAPES_CROP.get(), new Item.Properties().food(SFFoodValues.SALTED_COD)));
    public static final RegistryObject<Item> WAKAME = registerItem("wakame", () -> new ItemNameBlockItem(SFBlocks.WAKAME.get(), new Item.Properties().food(SFFoodValues.SALTED_COD)));
    public static final RegistryObject<Item> SEA_URCHIN = registerItem("sea_urchin", () -> new ItemNameBlockItem(SFBlocks.SEA_URCHIN.get(), new Item.Properties().food(SFFoodValues.SALTED_COD)) {
        @Override
        public void registerBlocks(Map<Block, Item> blockItemMap, Item item) {
            super.registerBlocks(blockItemMap, item);
            blockItemMap.put(SFBlocks.SEA_URCHIN.get(), item);
        }
        @Override
        public void removeFromBlockToItemMap(Map<Block, Item> blockItemMap, Item item) {
            super.removeFromBlockToItemMap(blockItemMap, item);
            blockItemMap.remove(SFBlocks.SEA_URCHIN.get());
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
