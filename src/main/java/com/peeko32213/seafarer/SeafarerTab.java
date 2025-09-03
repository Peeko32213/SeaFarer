package com.peeko32213.seafarer;

import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Seafarer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register(Seafarer.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Seafarer.MOD_ID))
            .icon(() -> new ItemStack(SeaBlocks.SWIRL_SHELL.get()))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((enabledFeatures, output) -> {

                    for (RegistryObject<Item> item : SeaItems.ITEMS.getEntries()) {
                        SeaItems.ITEMS.getEntries().forEach(spawnEgg -> {
                            if ((spawnEgg.get() instanceof ForgeSpawnEggItem)) {
                                output.accept(spawnEgg.get());
                            }
                    });

                    // food
                    output.accept(SeaItems.RAW_SHORE_CRAB_LEG.get());
                    output.accept(SeaItems.COOKED_SHORE_CRAB_LEG.get());
                    output.accept(SeaItems.RAW_HORSESHOE_CRAB.get());
                    output.accept(SeaItems.COOKED_HORSESHOE_CRAB.get());
                    output.accept(SeaItems.RAW_MARINE_IGUANA_TAIL.get());
                    output.accept(SeaItems.COOKED_MARINE_IGUANA_TAIL.get());
                    output.accept(SeaBlocks.COMMON_ORANGE_STARFISH.get());
                    output.accept(SeaBlocks.PINK_STARFISH.get());
                    output.accept(SeaBlocks.RED_STARFISH.get());
                    output.accept(SeaBlocks.CHOCOLATE_CHIP_STARFISH.get());
                    output.accept(SeaBlocks.BLUE_STARFISH.get());
                    output.accept(SeaBlocks.PURPLE_OCHRE_STARFISH.get());
                    output.accept(SeaBlocks.ROYAL_STARFISH.get());
                    output.accept(SeaBlocks.OCHRE_STARFISH.get());
                    output.accept(SeaItems.COOKED_STARFISH.get());
                    output.accept(SeaItems.SEA_GRAPES.get());
                    output.accept(SeaItems.WAKAME.get());
                    output.accept(SeaItems.SEA_URCHIN.get());
                    output.accept(SeaItems.SOY_SAUCE.get());
                    output.accept(SeaItems.SEA_SALT.get());
                    output.accept(SeaItems.SALTED_COD.get());
                    output.accept(SeaItems.SALTED_SALMON.get());
                    output.accept(SeaItems.SALTED_TROPICAL_FISH.get());
                    output.accept(SeaItems.SALTED_STARFISH.get());

                    // junk
                    output.accept(SeaBlocks.FLOATSOME.get());
                    output.accept(SeaBlocks.FISHING_NET.get());
                    output.accept(SeaBlocks.OLD_BOARDS.get());
                    output.accept(SeaItems.OLD_BOOT.get());
                    output.accept(SeaItems.METAL_CAN.get());
                    output.accept(SeaItems.MESSAGE_IN_A_BOTTLE.get());

                    // buckets
                    output.accept(SeaItems.HORSESHOE_CRAB_BUCKET.get());
                    output.accept(SeaItems.SHORE_CRAB_BUCKET.get());
//                    output.accept(SeafarerItems.SQUIRRELFISH_BUCKET.get());

                    // shells
                    output.accept(SeaBlocks.SPIKY_SHELL.get());
                    output.accept(SeaBlocks.CLAM_SHELL.get());
                    output.accept(SeaBlocks.HORN_SHELL.get());
                    output.accept(SeaBlocks.SWIRL_SHELL.get());
                    output.accept(SeaBlocks.SPIRAL_SHELL.get());
                    output.accept(SeaBlocks.PYRAMID_SHELL.get());
                    output.accept(SeaItems.SPIKY_SWORD.get());
                    output.accept(SeaItems.CLAM_SHOVEL.get());
                    output.accept(SeaItems.HORN_PICKAXE.get());
                    output.accept(SeaItems.SWIRL_AXE.get());
                    output.accept(SeaItems.SPIRAL_HOE.get());
                    output.accept(SeaBlocks.BEACHGRASS.get());
                    output.accept(SeaBlocks.BEACHGRASS_FAN.get());
                    output.accept(SeaBlocks.SEA_THRIFT.get());
                    output.accept(SeaBlocks.SEA_HOLLY.get());
                    output.accept(SeaBlocks.COASTAL_LAVENDER.get());
                    output.accept(SeaBlocks.COASTAL_WILDFLOWER.get());
                    output.accept(SeaBlocks.ALGAE_BLOCK.get());
                    output.accept(SeaBlocks.ALGAE_CARPET.get());
                    output.accept(SeaBlocks.ALGAE_PLANT.get());
                    output.accept(SeaBlocks.BLACK_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeaBlocks.WHITE_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeaBlocks.RED_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeaBlocks.YELLOW_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeaBlocks.BLUE_CHRISTMAS_TREE_WORM.get());
                    output.accept(SeaBlocks.RED_ZOA.get());
                    output.accept(SeaBlocks.ORANGE_ZOA.get());
                    output.accept(SeaBlocks.CYAN_ZOA.get());
                    output.accept(SeaBlocks.PURPLE_ZOA.get());
                    output.accept(SeaBlocks.ANTLER_GORGONIAN.get());
                    output.accept(SeaBlocks.TOWERING_GORGONIAN.get());

                    // corals
                    output.accept(SeaBlocks.AMBER_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.AMBER_CORAL.get());
                    output.accept(SeaBlocks.AMBER_CORAL_FAN.get());
                    output.accept(SeaBlocks.CERULEAN_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.CERULEAN_CORAL.get());
                    output.accept(SeaBlocks.CERULEAN_CORAL_FAN.get());
                    output.accept(SeaBlocks.MAROON_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.MAROON_CORAL.get());
                    output.accept(SeaBlocks.MAROON_CORAL_FAN.get());
                    output.accept(SeaBlocks.OLIVE_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.OLIVE_CORAL.get());
                    output.accept(SeaBlocks.OLIVE_CORAL_FAN.get());
                    output.accept(SeaBlocks.TURQUOISE_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.TURQUOISE_CORAL.get());
                    output.accept(SeaBlocks.TURQUOISE_CORAL_FAN.get());
                    output.accept(SeaBlocks.VERDANT_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.VERDANT_CORAL.get());
                    output.accept(SeaBlocks.VERDANT_CORAL_FAN.get());
                    output.accept(SeaBlocks.DEAD_AMBER_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.DEAD_AMBER_CORAL.get());
                    output.accept(SeaBlocks.DEAD_AMBER_CORAL_FAN.get());
                    output.accept(SeaBlocks.DEAD_CERULEAN_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.DEAD_CERULEAN_CORAL.get());
                    output.accept(SeaBlocks.DEAD_CERULEAN_CORAL_FAN.get());
                    output.accept(SeaBlocks.DEAD_MAROON_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.DEAD_MAROON_CORAL.get());
                    output.accept(SeaBlocks.DEAD_MAROON_CORAL_FAN.get());
                    output.accept(SeaBlocks.DEAD_OLIVE_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.DEAD_OLIVE_CORAL.get());
                    output.accept(SeaBlocks.DEAD_OLIVE_CORAL_FAN.get());
                    output.accept(SeaBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.DEAD_TURQUOISE_CORAL.get());
                    output.accept(SeaBlocks.DEAD_TURQUOISE_CORAL_FAN.get());
                    output.accept(SeaBlocks.DEAD_VERDANT_CORAL_BLOCK.get());
                    output.accept(SeaBlocks.DEAD_VERDANT_CORAL.get());
                    output.accept(SeaBlocks.DEAD_VERDANT_CORAL_FAN.get());

                    // sand
                    output.accept(SeaBlocks.GRAVELLY_SAND.get());
                    output.accept(SeaBlocks.SHELLY_SAND.get());
                    output.accept(SeaBlocks.SPRINKLED_SAND.get());
                    output.accept(SeaBlocks.STARRY_SAND.get());
                    output.accept(SeaBlocks.CORAL_SAND.get());
                    output.accept(SeaBlocks.CORALINE_SANDSTONE.get());
                    output.accept(SeaBlocks.CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SeaBlocks.CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SeaBlocks.CHISELED_CORALINE_SANDSTONE.get());
                    output.accept(SeaBlocks.SMOOTH_CORALINE_SANDSTONE.get());
                    output.accept(SeaBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SeaBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SeaBlocks.CUT_CORALINE_SANDSTONE.get());
                    output.accept(SeaBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SeaBlocks.CUT_CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SeaBlocks.SALT_BLOCK.get());

                    // shell blocks
                    output.accept(SeaBlocks.SPIKY_SHELL_BRICKS.get());
                    output.accept(SeaBlocks.SPIKY_SHELL_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.SPIKY_SHELL_BRICK_SLAB.get());
                    output.accept(SeaBlocks.SPIKY_SHELL_PILLAR.get());
                    output.accept(SeaBlocks.CLAM_SHELL_BRICKS.get());
                    output.accept(SeaBlocks.CLAM_SHELL_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.CLAM_SHELL_BRICK_SLAB.get());
                    output.accept(SeaBlocks.CLAM_SHELL_PILLAR.get());
                    output.accept(SeaBlocks.HORN_SHELL_BRICKS.get());
                    output.accept(SeaBlocks.HORN_SHELL_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.HORN_SHELL_BRICK_SLAB.get());
                    output.accept(SeaBlocks.HORN_SHELL_PILLAR.get());
                    output.accept(SeaBlocks.SWIRL_SHELL_BRICKS.get());
                    output.accept(SeaBlocks.SWIRL_SHELL_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.SWIRL_SHELL_BRICK_SLAB.get());
                    output.accept(SeaBlocks.SWIRL_SHELL_PILLAR.get());
                    output.accept(SeaBlocks.SPIRAL_SHELL_BRICKS.get());
                    output.accept(SeaBlocks.SPIRAL_SHELL_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.SPIRAL_SHELL_BRICK_SLAB.get());
                    output.accept(SeaBlocks.SPIRAL_SHELL_PILLAR.get());
                    output.accept(SeaBlocks.PYRAMID_SHELL_BRICKS.get());
                    output.accept(SeaBlocks.PYRAMID_SHELL_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.PYRAMID_SHELL_BRICK_SLAB.get());
                    output.accept(SeaBlocks.PYRAMID_SHELL_PILLAR.get());
                    output.accept(SeaBlocks.ALGAE_COBBLESTONE.get());
                    output.accept(SeaBlocks.ALGAE_COBBLESTONE_STAIRS.get());
                    output.accept(SeaBlocks.ALGAE_COBBLESTONE_SLAB.get());

                    // sea glass
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.PEARLY_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.UMBER_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.UMBER_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.SCARLET_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.AMBER_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.AMBER_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.CITRINE_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.AZURE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.AZURE_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.LILAC_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.LILAC_SEA_GLASS_BOTTLE.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_PEBBLES.get());
                    output.accept(SeaBlocks.ROSE_PEBBLED_SEA_GLASS.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_PANE.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_BRICKS.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_TILES.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_LAMP.get());
                    output.accept(SeaBlocks.ROSE_SEA_GLASS_BOTTLE.get());
                }
            })
            .build());
}
