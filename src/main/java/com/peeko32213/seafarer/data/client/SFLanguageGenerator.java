package com.peeko32213.seafarer.data.client;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFCreativeTabs;
import com.peeko32213.seafarer.core.registry.SFEntities;
import com.peeko32213.seafarer.core.registry.SFItems;
import com.peeko32213.seafarer.core.registry.util.SFTextUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
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

        addBlock(SFBlocks.BLUE_SEAGLASS_BLOCK, "Blue Sea Glass Block");
        addBlock(SFBlocks.BLUE_SEAGLASS_BRICKS, "Blue Sea Glass Bricks");
        addBlock(SFBlocks.BLUE_SEAGLASS_PEBBLED, "Pebbled Blue Sea Glass");
        addBlock(SFBlocks.BLUE_SEAGLASS_PEBBLES, "Blue Sea Glass");
        addBlock(SFBlocks.BLUE_SEAGLASS_TILES, "Blue Sea Glass Tiles");
        addBlock(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS, "Blue Sea Glass Tile Stairs");
        addBlock(SFBlocks.BLUE_SEAGLASS_TILES_SLAB, "Blue Sea Glass Tile Slabs");
        addBlock(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB, "Blue Sea Glass Brick Slabs");
        addBlock(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS, "Blue Sea Glass Brick Stairs");
        addBlock(SFBlocks.BLUE_SEAGLASS_PANE, "Blue Sea Glass Pane");

        addBlock(SFBlocks.BROWN_SEAGLASS_BLOCK, "Brown Sea Glass Block");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS, "Brown Sea Glass Bricks");
        addBlock(SFBlocks.BROWN_SEAGLASS_PEBBLED, "Pebbled Brown Sea Glass");
        addBlock(SFBlocks.BROWN_SEAGLASS_PEBBLES, "Brown Sea Glass");
        addBlock(SFBlocks.BROWN_SEAGLASS_TILES, "Brown Sea Glass Tiles");
        addBlock(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS, "Brown Sea Glass Tile Stairs");
        addBlock(SFBlocks.BROWN_SEAGLASS_TILES_SLAB, "Brown Sea Glass Tile Slabs");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB, "Brown Sea Glass Brick Slabs");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS, "Brown Sea Glass Brick Stairs");
        addBlock(SFBlocks.BROWN_SEAGLASS_PANE, "Brown Sea Glass Pane");

        addBlock(SFBlocks.GREEN_SEAGLASS_BLOCK, "Green Sea Glass Block");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS, "Green Sea Glass Bricks");
        addBlock(SFBlocks.GREEN_SEAGLASS_PEBBLED, "Pebbled Green Sea Glass");
        addBlock(SFBlocks.GREEN_SEAGLASS_PEBBLES, "Green Sea Glass");
        addBlock(SFBlocks.GREEN_SEAGLASS_TILES, "Green Sea Glass Tiles");
        addBlock(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS, "Green Sea Glass Tile Stairs");
        addBlock(SFBlocks.GREEN_SEAGLASS_TILES_SLAB, "Green Sea Glass Tile Slabs");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB, "Green Sea Glass Brick Slabs");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS, "Green Sea Glass Brick Stairs");
        addBlock(SFBlocks.GREEN_SEAGLASS_PANE, "Green Sea Glass Pane");

        addBlock(SFBlocks.ORANGE_SEAGLASS_BLOCK, "Orange Sea Glass Block");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS, "Orange Sea Glass Bricks");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLED, "Pebbled Orange Sea Glass");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLES, "Orange Sea Glass");
        addBlock(SFBlocks.ORANGE_SEAGLASS_TILES, "Orange Sea Glass Tiles");
        addBlock(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS, "Orange Sea Glass Tile Stairs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB, "Orange Sea Glass Tile Slabs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB, "Orange Sea Glass Brick Slabs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS, "Orange Sea Glass Brick Stairs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PANE, "Orange Sea Glass Pane");

        addBlock(SFBlocks.PURPLE_SEAGLASS_BLOCK, "Purple Sea Glass Block");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS, "Purple Sea Glass Bricks");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLED, "Pebbled Purple Sea Glass");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLES, "Purple Sea Glass");
        addBlock(SFBlocks.PURPLE_SEAGLASS_TILES, "Purple Sea Glass Tiles");
        addBlock(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS, "Purple Sea Glass Tile Stairs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB, "Purple Sea Glass Tile Slabs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB, "Purple Sea Glass Brick Slabs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS, "Purple Sea Glass Brick Stairs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PANE, "Purple Sea Glass Pane");

        addBlock(SFBlocks.RED_SEAGLASS_BLOCK, "Red Sea Glass Block");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS, "Red Sea Glass Bricks");
        addBlock(SFBlocks.RED_SEAGLASS_PEBBLED, "Pebbled Red Sea Glass");
        addBlock(SFBlocks.RED_SEAGLASS_PEBBLES, "Red Sea Glass");
        addBlock(SFBlocks.RED_SEAGLASS_TILES, "Red Sea Glass Tiles");
        addBlock(SFBlocks.RED_SEAGLASS_TILES_STAIRS, "Red Sea Glass Tile Stairs");
        addBlock(SFBlocks.RED_SEAGLASS_TILES_SLAB, "Red Sea Glass Tile Slabs");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS_SLAB, "Red Sea Glass Brick Slabs");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS, "Red Sea Glass Brick Stairs");
        addBlock(SFBlocks.RED_SEAGLASS_PANE, "Red Sea Glass Pane");

        addBlock(SFBlocks.YELLOW_SEAGLASS_BLOCK, "Yellow Sea Glass Block");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS, "Yellow Sea Glass Bricks");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLED, "Pebbled Yellow Sea Glass");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLES, "Yellow Sea Glass");
        addBlock(SFBlocks.YELLOW_SEAGLASS_TILES, "Yellow Sea Glass Tiles");
        addBlock(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS, "Yellow Sea Glass Tile Stairs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB, "Yellow Sea Glass Tile Slabs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB, "Yellow Sea Glass Brick Slabs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS, "Yellow Sea Glass Brick Stairs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PANE, "Yellow Sea Glass Pane");

        addBlock(SFBlocks.WHITE_SEAGLASS_BLOCK, "White Sea Glass Block");
        addBlock(SFBlocks.WHITE_SEAGLASS_BRICKS, "White Sea Glass Bricks");
        addBlock(SFBlocks.WHITE_SEAGLASS_PEBBLED, "Pebbled White Sea Glass");
        addBlock(SFBlocks.WHITE_SEAGLASS_PEBBLES, "White Sea Glass");
        addBlock(SFBlocks.WHITE_SEAGLASS_TILES, "White Sea Glass Tiles");
        addBlock(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS, "White Sea Glass Tile Stairs");
        addBlock(SFBlocks.WHITE_SEAGLASS_TILES_SLAB, "White Sea Glass Tile Slabs");
        addBlock(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB, "White Sea Glass Brick Slabs");
        addBlock(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS, "White Sea Glass Brick Stairs");
        addBlock(SFBlocks.WHITE_SEAGLASS_PANE, "White Sea Glass Pane");

        addBlock(SFBlocks.PINK_SEAGLASS_BLOCK, "Pink Sea Glass Block");
        addBlock(SFBlocks.PINK_SEAGLASS_BRICKS, "Pink Sea Glass Bricks");
        addBlock(SFBlocks.PINK_SEAGLASS_PEBBLED, "Pebbled Pink Sea Glass");
        addBlock(SFBlocks.PINK_SEAGLASS_PEBBLES, "Pink Sea Glass");
        addBlock(SFBlocks.PINK_SEAGLASS_TILES, "Pink Sea Glass Tiles");
        addBlock(SFBlocks.PINK_SEAGLASS_TILES_STAIRS, "Pink Sea Glass Tile Stairs");
        addBlock(SFBlocks.PINK_SEAGLASS_TILES_SLAB, "Pink Sea Glass Tile Slabs");
        addBlock(SFBlocks.PINK_SEAGLASS_BRICKS_SLAB, "Pink Sea Glass Brick Slabs");
        addBlock(SFBlocks.PINK_SEAGLASS_BRICKS_STAIRS, "Pink Sea Glass Brick Stairs");
        addBlock(SFBlocks.PINK_SEAGLASS_PANE, "Pink Sea Glass Pane");

        addBlock(SFBlocks.LIME_SEAGLASS_BLOCK, "Lime Sea Glass Block");
        addBlock(SFBlocks.LIME_SEAGLASS_BRICKS, "Lime Sea Glass Bricks");
        addBlock(SFBlocks.LIME_SEAGLASS_PEBBLED, "Pebbled Lime Sea Glass");
        addBlock(SFBlocks.LIME_SEAGLASS_PEBBLES, "Lime Sea Glass");
        addBlock(SFBlocks.LIME_SEAGLASS_TILES, "Lime Sea Glass Tiles");
        addBlock(SFBlocks.LIME_SEAGLASS_TILES_STAIRS, "Lime Sea Glass Tile Stairs");
        addBlock(SFBlocks.LIME_SEAGLASS_TILES_SLAB, "Lime Sea Glass Tile Slabs");
        addBlock(SFBlocks.LIME_SEAGLASS_BRICKS_SLAB, "Lime Sea Glass Brick Slabs");
        addBlock(SFBlocks.LIME_SEAGLASS_BRICKS_STAIRS, "Lime Sea Glass Brick Stairs");
        addBlock(SFBlocks.LIME_SEAGLASS_PANE, "Lime Sea Glass Pane");

        addBlock(SFBlocks.ALGAE_COBBLESTONE, "Algal Cobblestone");
        addBlock(SFBlocks.ALGAE_COBBLESTONE_SLAB, "Algal Cobblestone Slabs");
        addBlock(SFBlocks.ALGAE_COBBLESTONE_STAIRS, "Algal Cobblestone Stairs");

        addBlock(SFBlocks.FISHING_NET, "Fishing Net");

        addBlock(SFBlocks.STARFISH_COMMON_ORANGE, "Starfish");
        addBlock(SFBlocks.STARFISH_RED, "Starfish");
        addBlock(SFBlocks.STARFISH_PINK, "Starfish");
        addBlock(SFBlocks.STARFISH_CHOCOLATE_CHIP, "Starfish");

        addBlock(SFBlocks.STARFISH_BIG_BLUE, "Big Starfish");
        addBlock(SFBlocks.STARFISH_BIG_PURPLE_OCHRE, "Big Starfish");
        addBlock(SFBlocks.STARFISH_BIG_ROYAL, "Big Starfish");
        addBlock(SFBlocks.STARFISH_BIG_OCHRE, "Big Starfish");

        addItem(SFItems.COOKED_STARFISH, "Cooked Starfish");

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

        addBlock(SFBlocks.PLANK_BLOCK, "Plank Path");

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
        addItem(SFItems.RAW_SHORE_CRAB, "Raw Crab Leg");
        addItem(SFItems.COOKED_SHORE_CRAB, "Cooked Crab Leg");

        addEntityType(SFEntities.HORSESHOE_CRAB, "Horseshoe Crab");
        addItem(SFItems.HORSESHOE_CRAB_SPAWN_EGG, "Horseshoe Crab Spawn Egg");
        addItem(SFItems.HORSESHOE_CRAB_BUCKET, "Bucket of Horseshoe Crab");
        addItem(SFItems.RAW_HORSESHOE_CRAB, "Raw Horseshoe Crab");
        addItem(SFItems.COOKED_HORSESHOE_CRAB, "Cooked Horseshoe Crab");

        addEntityType(SFEntities.MARINE_IGUANA, "Marine Iguana");
        addItem(SFItems.MARINE_IGUANA_SPAWN_EGG, "Marine Iguana Spawn Egg");
        addItem(SFItems.RAW_MARINE_IGUANA, "Raw Marine Iguana");
        addItem(SFItems.COOKED_MARINE_IGUANA, "Cooked Marine Iguana");

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

        addEntityType(SFEntities.COPPERBAND_BUTTERFLY, "Copperband Butterfly Fish");
        addItem(SFItems.COPPERBAND_BUTTERFLY_SPAWN_EGG, "Copperband Butterfly Fish Spawn Egg");

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

        addBlock(SFBlocks.ALGAE_BLOCK, "Algae Block");
        addBlock(SFBlocks.ALGAE_CARPET, "Algae Carpet");
        addBlock(SFBlocks.ALGAE_PLANT, "Algae Growth");

        addItem(SFItems.CAN, "Can");
        addItem(SFItems.MESSAGE_IN_A_BOTTLE, "Message in A Bottle");
        addItem(SFItems.OLD_BOARD, "Old Boards");
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

        addBlock(SFBlocks.SEAGLASS_BOTTLE_BUST_BLUE, "Blue Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_BUST_BROWN, "Brown Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_PIPE_PINK, "Pink Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_PIPE_YELLOW, "Yellow Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_CURVY_LIME, "Lime Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_CURVY_ORANGE, "Orange Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_FISHBOWL_PURPLE, "Purple Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_FISHBOWL_WHITE, "White Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_THIN_GREEN, "Green Sea Glass Bottle");
        addBlock(SFBlocks.SEAGLASS_BOTTLE_THIN_RED, "Red Sea Glass Bottle");

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

        add("seafarer.starfish_common_orange", "Common Orange");
        add("seafarer.starfish_pink", "Pink");
        add("seafarer.starfish_red", "Red");
        add("seafarer.starfish_chocolate_chip", "Chocolate Chip");
        add("seafarer.starfish_big_blue", "Blue");
        add("seafarer.starfish_big_purple_ochre", "Purple Ochre");
        add("seafarer.starfish_big_ochre", "Ochre");
        add("seafarer.starfish_big_royal", "Big Royal");
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

    protected void forBlock(Supplier<? extends Block> block) {
        addBlock(block, SFTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }
}
