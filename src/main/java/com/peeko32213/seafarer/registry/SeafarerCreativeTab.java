package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerCreativeTab {

    public static final DeferredRegister<CreativeModeTab> DEF_REG = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Seafarer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = DEF_REG.register(Seafarer.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Seafarer.MOD_ID))
            .icon(() -> new ItemStack(SeafarerBlocks.SWIRL_SHELL.get()))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((enabledFeatures, output) -> {

                    for (RegistryObject<Item> item : SeafarerItems.ITEMS.getEntries()) {
                        SeafarerItems.ITEMS.getEntries().forEach(spawnEgg -> {
                            if ((spawnEgg.get() instanceof ForgeSpawnEggItem)) {
                                output.accept(spawnEgg.get());
                            }
                    });

                    // food
                    output.accept(SeafarerItems.RAW_CRAB_LEG.get());
                    output.accept(SeafarerItems.COOKED_CRAB_LEG.get());
                    output.accept(SeafarerItems.RAW_HORSESHOE_CRAB.get());
                    output.accept(SeafarerItems.COOKED_HORSESHOE_CRAB.get());
                    output.accept(SeafarerItems.RAW_MARINE_IGUANA_TAIL.get());
                    output.accept(SeafarerItems.COOKED_MARINE_IGUANA_TAIL.get());
                    output.accept(SeafarerItems.RAW_FROGFISH.get());
                    output.accept(SeafarerItems.COOKED_FROGFISH.get());
                    output.accept(SeafarerItems.RAW_BLUE_TANG.get());
                    output.accept(SeafarerItems.COOKED_BLUE_TANG.get());
                    output.accept(SeafarerItems.RAW_COPPERBAND_BUTTERFLYFISH.get());
                    output.accept(SeafarerItems.COOKED_COPPERBAND_BUTTERFLYFISH.get());
                    output.accept(SeafarerItems.RAW_GARDEN_EEL.get());
                    output.accept(SeafarerItems.COOKED_GARDEN_EEL.get());
                    output.accept(SeafarerItems.RAW_SEXY_SHRIMP.get());
                    output.accept(SeafarerItems.COOKED_SEXY_SHRIMP.get());
                    output.accept(SeafarerItems.RAW_MANDARINFISH.get());
                    output.accept(SeafarerItems.COOKED_MANDARINFISH.get());
                    output.accept(SeafarerItems.RAW_SQUIRRELFISH.get());
                    output.accept(SeafarerItems.COOKED_SQUIRRELFISH.get());
                    output.accept(SeafarerItems.COOKED_MARINE_IGUANA_TAIL.get());
                    output.accept(SeafarerBlocks.COMMON_ORANGE_STARFISH.get());
                    output.accept(SeafarerBlocks.PINK_STARFISH.get());
                    output.accept(SeafarerBlocks.RED_STARFISH.get());
                    output.accept(SeafarerBlocks.CHOCOLATE_CHIP_STARFISH.get());
                    output.accept(SeafarerBlocks.BLUE_STARFISH.get());
                    output.accept(SeafarerBlocks.PURPLE_OCHRE_STARFISH.get());
                    output.accept(SeafarerBlocks.ROYAL_STARFISH.get());
                    output.accept(SeafarerBlocks.OCHRE_STARFISH.get());
                    output.accept(SeafarerItems.COOKED_STARFISH.get());
                    output.accept(SeafarerItems.SEA_GRAPES.get());
                    output.accept(SeafarerItems.WAKAME.get());
                    output.accept(SeafarerItems.SEA_URCHIN.get());
                    output.accept(SeafarerItems.SOY_SAUCE.get());
                    output.accept(SeafarerItems.SEA_SALT.get());
                    output.accept(SeafarerItems.SALTED_COD.get());
                    output.accept(SeafarerItems.SALTED_SALMON.get());
                    output.accept(SeafarerItems.SALTED_TROPICAL_FISH.get());
                    output.accept(SeafarerItems.SALTED_STARFISH.get());

                    // junk
                    output.accept(SeafarerBlocks.FLOATSOME.get());
                    output.accept(SeafarerBlocks.FISHING_NET.get());
                    output.accept(SeafarerBlocks.OLD_BOARDS.get());
                    output.accept(SeafarerItems.OLD_BOOT.get());
                    output.accept(SeafarerItems.METAL_CAN.get());
                    output.accept(SeafarerItems.MESSAGE_IN_A_BOTTLE.get());

                    // buckets
//                    output.accept(SeafarerItems.CRAB_BUCKET.get());
//                    output.accept(SeafarerItems.HORSESHOE_CRAB_BUCKET.get());
//                    output.accept(SeafarerItems.SQUIRRELFISH_BUCKET.get());

                    // shells
                    output.accept(SeafarerBlocks.SPIKY_SHELL.get());
                    output.accept(SeafarerBlocks.CLAM_SHELL.get());
                    output.accept(SeafarerBlocks.HORN_SHELL.get());
                    output.accept(SeafarerBlocks.SWIRL_SHELL.get());
                    output.accept(SeafarerBlocks.SPIRAL_SHELL.get());
                    output.accept(SeafarerBlocks.PYRAMID_SHELL.get());
                    output.accept(SeafarerItems.SPIKY_SWORD.get());
                    output.accept(SeafarerItems.CLAM_SHOVEL.get());
                    output.accept(SeafarerItems.HORN_PICKAXE.get());
                    output.accept(SeafarerItems.SWIRL_AXE.get());
                    output.accept(SeafarerItems.SPIRAL_HOE.get());
                    output.accept(SeafarerBlocks.BEACHGRASS.get());
                    output.accept(SeafarerBlocks.BEACHGRASS_FAN.get());
                    output.accept(SeafarerBlocks.SEA_THRIFT.get());
                    output.accept(SeafarerBlocks.SEA_HOLLY.get());
                    output.accept(SeafarerBlocks.COASTAL_LAVENDER.get());
                    output.accept(SeafarerBlocks.COASTAL_WILDFLOWER.get());
                    output.accept(SeafarerBlocks.ALGAE_BLOCK.get());
                    output.accept(SeafarerBlocks.ALGAE_CARPET.get());
                    output.accept(SeafarerBlocks.ALGAE_PLANT.get());
                    output.accept(SeafarerBlocks.BLACK_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeafarerBlocks.WHITE_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeafarerBlocks.RED_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeafarerBlocks.YELLOW_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeafarerBlocks.BLUE_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeafarerBlocks.RED_ZOA.get());
                    output.accept(SeafarerBlocks.ORANGE_ZOA.get());
                    output.accept(SeafarerBlocks.CYAN_ZOA.get());
                    output.accept(SeafarerBlocks.PURPLE_ZOA.get());
                    output.accept(SeafarerBlocks.ANTLER_GORGONIAN.get());
                    output.accept(SeafarerBlocks.TOWERING_GORGONIAN.get());
                    output.accept(SeafarerBlocks.GHOUL_CORAL.get());
                    output.accept(SeafarerBlocks.PALE_SPONGE.get());
                    output.accept(SeafarerBlocks.TUBE_WORMS.get());

                    // corals
                    output.accept(SeafarerBlocks.AMBER_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.AMBER_CORAL.get());
                    output.accept(SeafarerBlocks.AMBER_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.CERULEAN_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.CERULEAN_CORAL.get());
                    output.accept(SeafarerBlocks.CERULEAN_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.MAROON_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.MAROON_CORAL.get());
                    output.accept(SeafarerBlocks.MAROON_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.OLIVE_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.OLIVE_CORAL.get());
                    output.accept(SeafarerBlocks.OLIVE_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.TURQUOISE_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.TURQUOISE_CORAL.get());
                    output.accept(SeafarerBlocks.TURQUOISE_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.VERDANT_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.VERDANT_CORAL.get());
                    output.accept(SeafarerBlocks.VERDANT_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.DEAD_AMBER_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.DEAD_AMBER_CORAL.get());
                    output.accept(SeafarerBlocks.DEAD_AMBER_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.DEAD_CERULEAN_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.DEAD_CERULEAN_CORAL.get());
                    output.accept(SeafarerBlocks.DEAD_CERULEAN_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.DEAD_MAROON_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.DEAD_MAROON_CORAL.get());
                    output.accept(SeafarerBlocks.DEAD_MAROON_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.DEAD_OLIVE_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.DEAD_OLIVE_CORAL.get());
                    output.accept(SeafarerBlocks.DEAD_OLIVE_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.DEAD_TURQUOISE_CORAL.get());
                    output.accept(SeafarerBlocks.DEAD_TURQUOISE_CORAL_FAN.get());
                    output.accept(SeafarerBlocks.DEAD_VERDANT_CORAL_BLOCK.get());
                    output.accept(SeafarerBlocks.DEAD_VERDANT_CORAL.get());
                    output.accept(SeafarerBlocks.DEAD_VERDANT_CORAL_FAN.get());

                    // sand
                    output.accept(SeafarerBlocks.GRAVELY_SAND.get());
                    output.accept(SeafarerBlocks.ROCKY_SAND.get());
                    output.accept(SeafarerBlocks.MIXED_SHELLY_SAND.get());
                    output.accept(SeafarerBlocks.JUMBLED_SHELLY_SAND.get());
                    output.accept(SeafarerBlocks.SCATTERED_SHELLY_SAND.get());
                    output.accept(SeafarerBlocks.RED_SPRINKLED_SAND.get());
                    output.accept(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get());
                    output.accept(SeafarerBlocks.BLUE_SPRINKLED_SAND.get());
                    output.accept(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get());
                    output.accept(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get());
                    output.accept(SeafarerBlocks.PINK_SPRINKLED_SAND.get());
                    output.accept(SeafarerBlocks.CORAL_SAND.get());
                    output.accept(SeafarerBlocks.CORALINE_SANDSTONE.get());
                    output.accept(SeafarerBlocks.CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SeafarerBlocks.CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SeafarerBlocks.CHISELED_CORALINE_SANDSTONE.get());
                    output.accept(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE.get());
                    output.accept(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SeafarerBlocks.CUT_CORALINE_SANDSTONE.get());
                    output.accept(SeafarerBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SeafarerBlocks.CUT_CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SeafarerBlocks.SALT_BLOCK.get());

                    // shell blocks
                    output.accept(SeafarerBlocks.SPIKY_SHELL_BRICKS.get());
                    output.accept(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS.get());
                    output.accept(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get());
                    output.accept(SeafarerBlocks.SPIKY_SHELL_PILLAR.get());
                    output.accept(SeafarerBlocks.CLAM_SHELL_BRICKS.get());
                    output.accept(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS.get());
                    output.accept(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get());
                    output.accept(SeafarerBlocks.CLAM_SHELL_PILLAR.get());
                    output.accept(SeafarerBlocks.HORN_SHELL_BRICKS.get());
                    output.accept(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS.get());
                    output.accept(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get());
                    output.accept(SeafarerBlocks.HORN_SHELL_PILLAR.get());
                    output.accept(SeafarerBlocks.SWIRL_SHELL_BRICKS.get());
                    output.accept(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS.get());
                    output.accept(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get());
                    output.accept(SeafarerBlocks.SWIRL_SHELL_PILLAR.get());
                    output.accept(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get());
                    output.accept(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get());
                    output.accept(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get());
                    output.accept(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get());
                    output.accept(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get());
                    output.accept(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get());
                    output.accept(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get());
                    output.accept(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get());
                    output.accept(SeafarerBlocks.ALGAE_COBBLESTONE.get());
                    output.accept(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get());
                    output.accept(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get());

                    // sea glass
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.PEARLY_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.UMBER_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.UMBER_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.SCARLET_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.AMBER_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.AMBER_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.CITRINE_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.AZURE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.AZURE_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.LILAC_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.LILAC_SEA_GLASS_BOTTLE.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeafarerBlocks.ROSE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_PANE.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_TILES.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_LAMP.get());
                    output.accept(SeafarerBlocks.ROSE_SEA_GLASS_BOTTLE.get());

                    // Unsorted stuff
                    if (!(item.get() instanceof ForgeSpawnEggItem)) {
                        output.accept(item.get());
                    }
                }
            })
            .build());
}
