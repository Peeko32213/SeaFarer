package com.peeko32213.seafarer.data.client;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFPaintings;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFCreativeTabs;
import com.peeko32213.seafarer.core.registry.SFEntities;
import com.peeko32213.seafarer.core.registry.SFItems;
import com.peeko32213.seafarer.core.registry.util.SFTextUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.Objects;
import java.util.function.Supplier;

public class SFLanguageGenerator extends LanguageProvider {
    public SFLanguageGenerator(PackOutput output) {
        super(output, SeaFarer.MODID, "en_us");
    }
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    protected void addTranslations(){

        addTabName(SFCreativeTabs.TAB.get(), "Seafarer");

        // Blocks
        SFBlocks.AUTO_TRANSLATE.forEach(this::forBlock);

        // Items
        SFItems.AUTO_TRANSLATE.forEach(this::forItem);

        // Paintings
        SFPaintings.PAINTING_TRANSLATIONS.forEach(this::addPainting);

        // Raw food
        addItem(SFItems.RAW_FROGFISH, "Raw Frogfish");
        addItem(SFItems.RAW_BLUE_TANG, "Raw Blue Tang");
        addItem(SFItems.RAW_COPPERBAND_BUTTERFLYFISH, "Raw Copperband Butterflyfish");
        addItem(SFItems.RAW_SQUIRRELFISH, "Raw Squirrelfish");
        addItem(SFItems.RAW_MANDARINFISH, "Raw Mandarinfish");
        addItem(SFItems.RAW_SEXY_SHRIMP, "Raw Sexy Shrimp");
        addItem(SFItems.RAW_GARDEN_EEL, "Raw Garden Eel");
        addItem(SFItems.RAW_HORSESHOE_CRAB, "Raw Horseshoe Crab");
        addItem(SFItems.RAW_SHORE_CRAB, "Raw Crab Leg");
        addItem(SFItems.RAW_MARINE_IGUANA, "Raw Marine Iguana Tail");

        addBlock(SFBlocks.ALGAE_COBBLESTONE, "Algal Cobblestone");
        addBlock(SFBlocks.ALGAE_COBBLESTONE_SLAB, "Algal Cobblestone Slabs");
        addBlock(SFBlocks.ALGAE_COBBLESTONE_STAIRS, "Algal Cobblestone Stairs");

        addBlock(SFBlocks.FISHING_NET, "Fishing Net");

        addBlock(SFBlocks.COMMON_ORANGE_STARFISH, "Starfish");
        addBlock(SFBlocks.RED_STARFISH, "Starfish");
        addBlock(SFBlocks.PINK_STARFISH, "Starfish");
        addBlock(SFBlocks.CHOCOLATE_CHIP_STARFISH, "Starfish");
        addBlock(SFBlocks.BLUE_STARFISH, "Starfish");
        addBlock(SFBlocks.PURPLE_OCHRE_STARFISH, "Starfish");
        addBlock(SFBlocks.ROYAL_STARFISH, "Starfish");
        addBlock(SFBlocks.OCHRE_STARFISH, "Starfish");

        addBlock(SFBlocks.CLAM_SHELL, "Clam Shell");
        addBlock(SFBlocks.HORN_SHELL, "Horn Shell");
        addBlock(SFBlocks.SPIKY_SHELL, "Spiky Shell");
        addBlock(SFBlocks.SPIRAL_SHELL, "Spiral Shell");
        addBlock(SFBlocks.SWIRL_SHELL, "Swirl Shell");
        addBlock(SFBlocks.PYRAMID_SHELL, "Pyramid Shell");

        addBlock(SFBlocks.CLAM_SHELL_BRICKS, "Clam Shell Bricks");
        addBlock(SFBlocks.CLAM_SHELL_BRICKS_SLAB, "Clam Shell Brick Slabs");
        addBlock(SFBlocks.CLAM_SHELL_BRICKS_STAIRS, "Clam Shell Brick Stairs");
        addBlock(SFBlocks.CLAM_SHELL_PILLAR, "Clam Shell Pillar");

        addBlock(SFBlocks.HORN_SHELL_BRICKS, "Horn Shell Bricks");
        addBlock(SFBlocks.HORN_SHELL_BRICKS_SLAB, "Horn Shell Brick Slabs");
        addBlock(SFBlocks.HORN_SHELL_BRICKS_STAIRS, "Horn Shell Brick Stairs");
        addBlock(SFBlocks.HORN_SHELL_PILLAR, "Horn Shell Pillar");

        addBlock(SFBlocks.SPIKY_SHELL_BRICKS, "Spiky Shell Bricks");
        addBlock(SFBlocks.SPIKY_SHELL_BRICKS_SLAB, "Spiky Shell Brick Slabs");
        addBlock(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS, "Spiky Shell Brick Stairs");
        addBlock(SFBlocks.SPIKY_SHELL_PILLAR, "Spiky Shell Pillar");

        addBlock(SFBlocks.SPIRAL_SHELL_BRICKS, "Spiral Shell Bricks");
        addBlock(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB, "Spiral Shell Brick Slabs");
        addBlock(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS, "Spiral Shell Brick Stairs");
        addBlock(SFBlocks.SPIRAL_SHELL_PILLAR, "Spiral Shell Pillar");

        addBlock(SFBlocks.SWIRL_SHELL_BRICKS, "Swirl Shell Bricks");
        addBlock(SFBlocks.SWIRL_SHELL_BRICKS_SLAB, "Swirl Shell Brick Slabs");
        addBlock(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS, "Swirl Shell Brick Stairs");
        addBlock(SFBlocks.SWIRL_SHELL_PILLAR, "Swirl Shell Pillar");

        addBlock(SFBlocks.PYRAMID_SHELL_BRICKS, "Pyramid Shell Bricks");
        addBlock(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB, "Pyramid Shell Brick Slabs");
        addBlock(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS, "Pyramid Shell Brick Stairs");
        addBlock(SFBlocks.PYRAMID_SHELL_PILLAR, "Pyramid Shell Pillar");

        addBlock(SFBlocks.BEACHGRASS, "Beach Grass");
        addBlock(SFBlocks.BEACHGRASS_FAN, "Fanny Beach Grass");
        addBlock(SFBlocks.SEA_HOLLY, "Sea Holly");
        addBlock(SFBlocks.SEA_THRIFT, "Sea Thrift");
        addBlock(SFBlocks.COASTAL_LAVENDER, "Coastal Lavender");
        addBlock(SFBlocks.COASTAL_WILDFLOWER, "Coastal Wildflower");

        addBlock(SFBlocks.SALT_BLOCK, "Block of Salt");

        addBlock(SFBlocks.BLUE_MIXED_SPRINKLED_SAND, "Blue Mixed Sprinkled Sand");
        addBlock(SFBlocks.RED_MIXED_SPRINKLED_SAND, "Red Mixed Sprinkled Sand");
        addBlock(SFBlocks.BLUE_SPRINKLED_SAND, "Blue Sprinkled Sand");
        addBlock(SFBlocks.PINK_SPRINKLED_SAND, "Pink Sprinkled Sand");
        addBlock(SFBlocks.PURPLE_SPRINKLED_SAND, "Purple Sprinkled Sand");
        addBlock(SFBlocks.RED_SPRINKLED_SAND, "Red Sprinkled Sand");
        addBlock(SFBlocks.GRAVELY_SAND, "Gravely Sand");
        addBlock(SFBlocks.ROCKY_SAND, "Rocky Sand");
        addBlock(SFBlocks.JUMBLED_SHELLY_SAND, "Jumbled Shelly Sand");
        addBlock(SFBlocks.MIXED_SHELLY_SAND, "Mixed Shelly Sand");
        addBlock(SFBlocks.SCATTERED_SHELLY_SAND, "Scattered Shelly Sand");
        addBlock(SFBlocks.CORAL_SAND, "Coraline Sand");

        addEntityType(SFEntities.SUNFISH, "Sunfish");
        addItem(SFItems.SUNFISH_SPAWN_EGG, "Sunfish Spawn Egg");

        addEntityType(SFEntities.CRAB, "Crab");
        addItem(SFItems.CRAB_SPAWN_EGG, "Crab Spawn Egg");
        addItem(SFItems.SHORE_CRAB_BUCKET, "Bucket of Crab");

        addEntityType(SFEntities.HORSESHOE_CRAB, "Horseshoe Crab");
        addItem(SFItems.HORSESHOE_CRAB_SPAWN_EGG, "Horseshoe Crab Spawn Egg");
        addItem(SFItems.HORSESHOE_CRAB_BUCKET, "Bucket of Horseshoe Crab");

        addEntityType(SFEntities.MARINE_IGUANA, "Marine Iguana");
        addItem(SFItems.MARINE_IGUANA_SPAWN_EGG, "Marine Iguana Spawn Egg");

        addEntityType(SFEntities.GARDEN_EEL, "Garden Eel");
        addItem(SFItems.GARDEN_EEL_SPAWN_EGG, "Garden Eel Spawn Egg");

        addEntityType(SFEntities.MANDARIN_GOBY, "Mandarin Goby");
        addItem(SFItems.MANDARIN_GOBY_SPAWN_EGG, "Mandarin Goby Spawn Egg");

        addEntityType(SFEntities.SEXY_SHRIMP, "Sexy Shrimp");
        addItem(SFItems.SEXY_SHRIMP_SPAWN_EGG, "Sexy Shrimp Spawn Egg");

        addEntityType(SFEntities.FROG_FISH, "Frog Fish");
        addItem(SFItems.FROG_FISH_SPAWN_EGG, "Frog Fish Spawn Egg");

        addEntityType(SFEntities.BLUE_TANG, "Blue Tang");
        addItem(SFItems.BLUE_TANG_SPAWN_EGG, "Blue Tang Spawn Egg");

        addEntityType(SFEntities.BARRELEYE, "Barreleye");
        addItem(SFItems.BARRELEYE_SPAWN_EGG, "Barreleye Spawn Egg");

        addEntityType(SFEntities.COPPERBAND_BUTTERFLY, "Copperband Butterflyfish");
        addItem(SFItems.COPPERBAND_BUTTERFLY_SPAWN_EGG, "Copperband Butterflyfish Spawn Egg");

        addEntityType(SFEntities.MANTIS_SHRIMP, "Mantis Shrimp");
        addItem(SFItems.MANTIS_SHRIMP_SPAWN_EGG, "Mantis Shrimp Spawn Egg");

        addEntityType(SFEntities.MANTA_RAY, "Manta Ray");
        addItem(SFItems.MANTA_RAY_SPAWN_EGG, "Manta Ray Spawn Egg");

        addEntityType(SFEntities.PARROTFISH, "Parrot Fish");
        addItem(SFItems.PARROTFISH_SPAWN_EGG, "Parrot Fish Spawn Egg");

        addEntityType(SFEntities.FILEFISH, "File Fish");
        addItem(SFItems.FILEFISH_SPAWN_EGG, "File Fish Spawn Egg");

        addEntityType(SFEntities.LEAFY_SCORPIONFISH, "Leafy Scorpion Fish");
        addItem(SFItems.LEAFY_SCORPIONFISH_SPAWN_EGG, "Leafy Scorpion Spawn Egg");

        addEntityType(SFEntities.ZEBRA_SHARK, "Zebra Shark");
        addItem(SFItems.ZEBRA_SHARK_SPAWN_EGG, "Zebra Shark Spawn Egg");

        addEntityType(SFEntities.CHIMAERA, "Chimaera");
        addItem(SFItems.CHIMAERA_SPAWN_EGG, "Chimaera Spawn Egg");

        addEntityType(SFEntities.SPIDER_CRAB, "Spider Crab");
        addItem(SFItems.SPIDER_CRAB_SPAWN_EGG, "Spider Crab Spawn Egg");

        addEntityType(SFEntities.SQUIRRELFISH, "Squirrelfish");
        addItem(SFItems.SQUIRRELFISH_SPAWN_EGG, "Squirrelfish Spawn Egg");

        addBlock(SFBlocks.ALGAE_BLOCK, "Algae Block");
        addBlock(SFBlocks.ALGAE_CARPET, "Algae Carpet");
        addBlock(SFBlocks.ALGAE_PLANT, "Algae Growth");

        addItem(SFItems.CAN, "Can");
        addItem(SFItems.MESSAGE_IN_A_BOTTLE, "Message in A Bottle");
        addItem(SFItems.OLD_BOOT, "Old Boot");

        addItem(SFItems.SOY_SAUCE, "Soy Sauce");

        addItem(SFItems.SALT, "Sea Salt");
        addItem(SFItems.SALTED_COD, "Salted Cod");
        addItem(SFItems.SALTED_SALMON, "Salted Salmon");
        addItem(SFItems.SALTED_TROPICAL_FISH, "Salted Tropical Fish");
        addItem(SFItems.SALTED_STARFISH, "Salted Starfish");

        addItem(SFItems.CLAM_SHOVEL, "Clam Shovel");
        addItem(SFItems.HORN_PICKAXE, "Horn Pickaxe");
        addItem(SFItems.SPIKY_SWORD, "Spiky Sword");
        addItem(SFItems.SPIRAL_HOE, "Spiral Hoe");
        addItem(SFItems.SWIRL_AXE, "Swirl Axe");

        addBlock(SFBlocks.FLOATSOME, "Floatsome");

        addBlock(SFBlocks.DEAD_AMBER_CORAL, "Dead Amber Coral");
        addBlock(SFBlocks.AMBER_CORAL, "Amber Coral");
        addBlock(SFBlocks.DEAD_AMBER_CORAL_BLOCK, "Dead Amber Block");
        addBlock(SFBlocks.AMBER_CORAL_BLOCK, "Amber Coral Block");
        addItem(SFItems.AMBER_CORAL_FAN, "Amber Coral Fan");
        addItem(SFItems.DEAD_AMBER_CORAL_FAN, "Dead Amber Coral Fan");

        addBlock(SFBlocks.DEAD_CERULEAN_CORAL, "Dead Cerulean Coral");
        addBlock(SFBlocks.CERULEAN_CORAL, "Cerulean Coral");
        addBlock(SFBlocks.DEAD_CERULEAN_CORAL_BLOCK, "Dead Cerulean Block");
        addBlock(SFBlocks.CERULEAN_CORAL_BLOCK, "Cerulean Coral Block");
        addItem(SFItems.CERULEAN_CORAL_FAN, "Cerulean Coral Fan");
        addItem(SFItems.DEAD_CERULEAN_CORAL_FAN, "Dead Cerulean Coral Fan");

        addBlock(SFBlocks.DEAD_MAROON_CORAL, "Dead Maroon Coral");
        addBlock(SFBlocks.MAROON_CORAL, "Maroon Coral");
        addBlock(SFBlocks.DEAD_MAROON_CORAL_BLOCK, "Dead Maroon Block");
        addBlock(SFBlocks.MAROON_CORAL_BLOCK, "Maroon Coral Block");
        addItem(SFItems.MAROON_CORAL_FAN, "Maroon Coral Fan");
        addItem(SFItems.DEAD_MAROON_CORAL_FAN, "Dead Maroon Coral Fan");

        addBlock(SFBlocks.DEAD_OLIVE_CORAL, "Dead Olive Coral");
        addBlock(SFBlocks.OLIVE_CORAL, "Olive Coral");
        addBlock(SFBlocks.DEAD_OLIVE_CORAL_BLOCK, "Dead Olive Block");
        addBlock(SFBlocks.OLIVE_CORAL_BLOCK, "Olive Coral Block");
        addItem(SFItems.OLIVE_CORAL_FAN, "Olive Coral Fan");
        addItem(SFItems.DEAD_OLIVE_CORAL_FAN, "Dead Olive Coral Fan");

        addBlock(SFBlocks.DEAD_TURQUOISE_CORAL, "Dead Turquoise Coral");
        addBlock(SFBlocks.TURQUOISE_CORAL, "Turquoise Coral");
        addBlock(SFBlocks.DEAD_TURQUOISE_CORAL_BLOCK, "Dead Turquoise Block");
        addBlock(SFBlocks.TURQUOISE_CORAL_BLOCK, "Turquoise Coral Block");
        addItem(SFItems.TURQUOISE_CORAL_FAN, "Turquoise Coral Fan");
        addItem(SFItems.DEAD_TURQUOISE_CORAL_FAN, "Dead Turquoise Coral Fan");

        addBlock(SFBlocks.DEAD_VERDANT_CORAL, "Dead Verdant Coral");
        addBlock(SFBlocks.VERDANT_CORAL, "Verdant Coral");
        addBlock(SFBlocks.DEAD_VERDANT_CORAL_BLOCK, "Dead Verdant Block");
        addBlock(SFBlocks.VERDANT_CORAL_BLOCK, "Verdant Coral Block");
        addItem(SFItems.VERDANT_CORAL_FAN, "Verdant Coral Fan");
        addItem(SFItems.DEAD_VERDANT_CORAL_FAN, "Dead Verdant Coral Fan");

        addBlock(SFBlocks.CYAN_ZOA, "Cyan Zoanthids");
        addBlock(SFBlocks.ORANGE_ZOA, "Orange Zoanthids");
        addBlock(SFBlocks.RED_ZOA, "Red Zoanthids");
        addBlock(SFBlocks.PURPLE_ZOA, "Purple Zoanthid");

        addBlock(SFBlocks.ANTLER_GORGONIAN, "Antler Gorgonian");
        addBlock(SFBlocks.TOWERING_GORGONIAN, "Towering Gorgonian");

        addBlock(SFBlocks.BLUE_CHRISTMAS_TREE_WORM, "Blue Christmas Tree Worm");
        addBlock(SFBlocks.BLACK_CHRISTMAS_TREE_WORM, "Black Christmas Tree Worm");
        addBlock(SFBlocks.RED_CHRISTMAS_TREE_WORM, "Red Christmas Tree Worm");
        addBlock(SFBlocks.YELLOW_CHRISTMAS_TREE_WORM, "Yellow Christmas Tree Worm");
        addBlock(SFBlocks.WHITE_CHRISTMAS_TREE_WORM, "White Christmas Tree Worm");

        addBlock(SFBlocks.CORALINE_SANDSTONE, "Coraline Sandstone");
        addBlock(SFBlocks.CORALINE_SANDSTONE_SLAB, "Coraline Sandstone Slab");
        addBlock(SFBlocks.CORALINE_SANDSTONE_STAIRS, "Coraline Sandstone Stairs");

        addBlock(SFBlocks.CUT_CORALINE_SANDSTONE, "Cut Coraline Sandstone");
        addBlock(SFBlocks.CUT_CORALINE_SANDSTONE_SLAB, "Cut Coraline Sandstone Slab");
        addBlock(SFBlocks.CUT_CORALINE_SANDSTONE_STAIRS, "Cut Coraline Sandstone Stairs");

        addBlock(SFBlocks.CHISELED_CORALINE_SANDSTONE, "Chiseled Coraline Sandstone");

        addBlock(SFBlocks.SMOOTH_CORALINE_SANDSTONE, "Smooth Coraline Sandstone");
        addBlock(SFBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB, "Smooth Coraline Sandstone Slab");
        addBlock(SFBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS, "Smooth Coraline Sandstone Stairs");

        addItem(SFItems.SEA_GRAPES, "Sea Grapes");
        addBlock(SFBlocks.SEA_GRAPES_CROP, "Sea Grapes Crop");

        addBlock(SFBlocks.WAKAME, "Wakame Block");
        addBlock(SFBlocks.WAKAME_PLANT, "Wakame Plant");
        addItem(SFItems.WAKAME, "Wakame");

        addBlock(SFBlocks.SEA_URCHIN, "Sea Urchin Block");
        addItem(SFItems.SEA_URCHIN, "Sea Urchin");

        addBlock(SFBlocks.GHOUL_CORAL, "Ghoul Coral");
        addBlock(SFBlocks.PALE_SPONGE, "Pale Sponge");
        addBlock(SFBlocks.TUBE_WORMS, "Tube Worms");

        add("seafarer.common_orange_starfish", "Common Orange");
        add("seafarer.pink_starfish", "Pink");
        add("seafarer.red_starfish", "Red");
        add("seafarer.chocolate_chip_starfish", "Chocolate Chip");
        add("seafarer.blue_starfish", "Blue");
        add("seafarer.purple_ochre_starfish", "Purple Ochre");
        add("seafarer.ochre_starfish", "Ochre");
        add("seafarer.royal_starfish", "Royal");

        add("seafarer.message_in_a_bottle", "Message in a bottle");
        add("seafarer.message.structure_not_found", "Structure was not found!");
        add("seafarer.message.structure_search_failed", "Structure was not found!");

    }

    @Override
    public String getName() {
        return  SeaFarer.MODID  + " Languages: en_us";
    }

    public void addBETranslatable(String beName,String name){
        add(SeaFarer.MODID + ".blockentity." + beName, name);
    }

    public void addSound(Supplier<? extends SoundEvent> key, String name){
        add(SeaFarer.MODID + ".sound.subtitle." + key.get().getLocation().getPath(), name);
    }

    public void addTabName(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void add(CreativeModeTab key, String name) {
        add(key.getDisplayName().getString(), name);
    }

    public void addPotion(Supplier<? extends Potion> key, String name, String regName) {
        add(key.get(), name, regName);
    }

    public void addEnchantDescription(String description, Enchantment enchantment){
        add(enchantment.getDescriptionId() + ".desc", description);
    }

    public void add(Potion key, String name, String regName) {
        add("item.minecraft.potion.effect." + regName, name);
        add("item.minecraft.splash_potion.effect." + regName, "Splash " + name);
        add("item.minecraft.lingering_potion.effect." + regName, "Lingering " + name);
    }

    protected void addPainting(String name, String author) {
        add("painting." + SeaFarer.MODID + "." + name + ".title",  SFTextUtils.createTranslation(name));
        add("painting." + SeaFarer.MODID + "." + name + ".author",  author);
    }

    protected void forBlock(Supplier<? extends Block> block) {
        addBlock(block, SFTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forItem(Supplier<? extends Item> item) {
        addItem(item, SFTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }
}
