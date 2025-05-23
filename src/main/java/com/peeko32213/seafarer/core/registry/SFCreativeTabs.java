package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SFCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> DEF_REG = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SeaFarer.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = DEF_REG.register(SeaFarer.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + SeaFarer.MODID))
            .icon(() -> new ItemStack(SFBlocks.SWIRL_SHELL.get()))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((enabledFeatures, output) -> {
                for(RegistryObject<Item> item : SFItems.ITEMS.getEntries()){
                    // Spawn eggs
                    SFItems.ITEMS.getEntries().forEach(spawnEgg -> {
                        if ((spawnEgg.get() instanceof ForgeSpawnEggItem)) {
                            output.accept(spawnEgg.get());
                        }
                    });

                    // food
                    output.accept(SFItems.RAW_SHORE_CRAB.get());
                    output.accept(SFItems.COOKED_SHORE_CRAB.get());
                    output.accept(SFItems.RAW_HORSESHOE_CRAB.get());
                    output.accept(SFItems.COOKED_HORSESHOE_CRAB.get());
                    output.accept(SFItems.RAW_MARINE_IGUANA.get());
                    output.accept(SFItems.COOKED_MARINE_IGUANA.get());
                    output.accept(SFItems.RAW_FROGFISH.get());
                    output.accept(SFItems.COOKED_FROGFISH.get());
                    output.accept(SFItems.RAW_BLUE_TANG.get());
                    output.accept(SFItems.COOKED_BLUE_TANG.get());
                    output.accept(SFItems.RAW_COPPERBAND_BUTTERFLYFISH.get());
                    output.accept(SFItems.COOKED_COPPERBAND_BUTTERFLYFISH.get());
                    output.accept(SFItems.RAW_GARDEN_EEL.get());
                    output.accept(SFItems.COOKED_GARDEN_EEL.get());
                    output.accept(SFItems.RAW_SEXY_SHRIMP.get());
                    output.accept(SFItems.COOKED_SEXY_SHRIMP.get());
                    output.accept(SFItems.RAW_MANDARINFISH.get());
                    output.accept(SFItems.COOKED_MANDARINFISH.get());
                    output.accept(SFItems.RAW_SQUIRRELFISH.get());
                    output.accept(SFItems.COOKED_SQUIRRELFISH.get());
                    output.accept(SFItems.COOKED_MARINE_IGUANA.get());
                    output.accept(SFBlocks.COMMON_ORANGE_STARFISH.get());
                    output.accept(SFBlocks.PINK_STARFISH.get());
                    output.accept(SFBlocks.RED_STARFISH.get());
                    output.accept(SFBlocks.CHOCOLATE_CHIP_STARFISH.get());
                    output.accept(SFBlocks.BLUE_STARFISH.get());
                    output.accept(SFBlocks.PURPLE_OCHRE_STARFISH.get());
                    output.accept(SFBlocks.ROYAL_STARFISH.get());
                    output.accept(SFBlocks.OCHRE_STARFISH.get());
                    output.accept(SFItems.COOKED_STARFISH.get());
                    output.accept(SFItems.SEA_GRAPES.get());
                    output.accept(SFItems.WAKAME.get());
                    output.accept(SFItems.SEA_URCHIN.get());
                    output.accept(SFItems.SOY_SAUCE.get());
                    output.accept(SFItems.SALT.get());
                    output.accept(SFItems.SALTED_COD.get());
                    output.accept(SFItems.SALTED_SALMON.get());
                    output.accept(SFItems.SALTED_TROPICAL_FISH.get());
                    output.accept(SFItems.SALTED_STARFISH.get());

                    // junk
                    output.accept(SFBlocks.FLOATSOME.get());
                    output.accept(SFBlocks.FISHING_NET.get());
                    output.accept(SFBlocks.OLD_BOARDS.get());
                    output.accept(SFItems.OLD_BOOT.get());
                    output.accept(SFItems.CAN.get());
                    output.accept(SFItems.MESSAGE_IN_A_BOTTLE.get());

                    // buckets
                    output.accept(SFItems.SHORE_CRAB_BUCKET.get());
                    output.accept(SFItems.HORSESHOE_CRAB_BUCKET.get());

                    // shells
                    output.accept(SFBlocks.SPIKY_SHELL.get());
                    output.accept(SFBlocks.CLAM_SHELL.get());
                    output.accept(SFBlocks.HORN_SHELL.get());
                    output.accept(SFBlocks.SWIRL_SHELL.get());
                    output.accept(SFBlocks.SPIRAL_SHELL.get());
                    output.accept(SFBlocks.PYRAMID_SHELL.get());
                    output.accept(SFItems.SPIKY_SWORD.get());
                    output.accept(SFItems.CLAM_SHOVEL.get());
                    output.accept(SFItems.HORN_PICKAXE.get());
                    output.accept(SFItems.SWIRL_AXE.get());
                    output.accept(SFItems.SPIRAL_HOE.get());
                    output.accept(SFBlocks.BEACHGRASS.get());
                    output.accept(SFBlocks.BEACHGRASS_FAN.get());
                    output.accept(SFBlocks.SEA_THRIFT.get());
                    output.accept(SFBlocks.SEA_HOLLY.get());
                    output.accept(SFBlocks.COASTAL_LAVENDER.get());
                    output.accept(SFBlocks.COASTAL_WILDFLOWER.get());
                    output.accept(SFBlocks.ALGAE_BLOCK.get());
                    output.accept(SFBlocks.ALGAE_CARPET.get());
                    output.accept(SFBlocks.ALGAE_PLANT.get());
                    output.accept(SFBlocks.BLACK_CHRISTMAS_TREE_WORM.get());
                    output.accept(SFBlocks.WHITE_CHRISTMAS_TREE_WORM.get());
                    output.accept(SFBlocks.RED_CHRISTMAS_TREE_WORM.get());
                    output.accept(SFBlocks.YELLOW_CHRISTMAS_TREE_WORM.get());
                    output.accept(SFBlocks.BLUE_CHRISTMAS_TREE_WORM.get());
                    output.accept(SFBlocks.RED_ZOA.get());
                    output.accept(SFBlocks.ORANGE_ZOA.get());
                    output.accept(SFBlocks.CYAN_ZOA.get());
                    output.accept(SFBlocks.PURPLE_ZOA.get());
                    output.accept(SFBlocks.ANTLER_GORGONIAN.get());
                    output.accept(SFBlocks.TOWERING_GORGONIAN.get());
                    output.accept(SFBlocks.GHOUL_CORAL.get());
                    output.accept(SFBlocks.PALE_SPONGE.get());
                    output.accept(SFBlocks.TUBE_WORMS.get());

                    // corals
                    output.accept(SFBlocks.AMBER_CORAL_BLOCK.get());
                    output.accept(SFBlocks.AMBER_CORAL.get());
                    output.accept(SFBlocks.AMBER_CORAL_FAN.get());
                    output.accept(SFBlocks.CERULEAN_CORAL_BLOCK.get());
                    output.accept(SFBlocks.CERULEAN_CORAL.get());
                    output.accept(SFBlocks.CERULEAN_CORAL_FAN.get());
                    output.accept(SFBlocks.MAROON_CORAL_BLOCK.get());
                    output.accept(SFBlocks.MAROON_CORAL.get());
                    output.accept(SFBlocks.MAROON_CORAL_FAN.get());
                    output.accept(SFBlocks.OLIVE_CORAL_BLOCK.get());
                    output.accept(SFBlocks.OLIVE_CORAL.get());
                    output.accept(SFBlocks.OLIVE_CORAL_FAN.get());
                    output.accept(SFBlocks.TURQUOISE_CORAL_BLOCK.get());
                    output.accept(SFBlocks.TURQUOISE_CORAL.get());
                    output.accept(SFBlocks.TURQUOISE_CORAL_FAN.get());
                    output.accept(SFBlocks.VERDANT_CORAL_BLOCK.get());
                    output.accept(SFBlocks.VERDANT_CORAL.get());
                    output.accept(SFBlocks.VERDANT_CORAL_FAN.get());
                    output.accept(SFBlocks.DEAD_AMBER_CORAL_BLOCK.get());
                    output.accept(SFBlocks.DEAD_AMBER_CORAL.get());
                    output.accept(SFBlocks.DEAD_AMBER_CORAL_FAN.get());
                    output.accept(SFBlocks.DEAD_CERULEAN_CORAL_BLOCK.get());
                    output.accept(SFBlocks.DEAD_CERULEAN_CORAL.get());
                    output.accept(SFBlocks.DEAD_CERULEAN_CORAL_FAN.get());
                    output.accept(SFBlocks.DEAD_MAROON_CORAL_BLOCK.get());
                    output.accept(SFBlocks.DEAD_MAROON_CORAL.get());
                    output.accept(SFBlocks.DEAD_MAROON_CORAL_FAN.get());
                    output.accept(SFBlocks.DEAD_OLIVE_CORAL_BLOCK.get());
                    output.accept(SFBlocks.DEAD_OLIVE_CORAL.get());
                    output.accept(SFBlocks.DEAD_OLIVE_CORAL_FAN.get());
                    output.accept(SFBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get());
                    output.accept(SFBlocks.DEAD_TURQUOISE_CORAL.get());
                    output.accept(SFBlocks.DEAD_TURQUOISE_CORAL_FAN.get());
                    output.accept(SFBlocks.DEAD_VERDANT_CORAL_BLOCK.get());
                    output.accept(SFBlocks.DEAD_VERDANT_CORAL.get());
                    output.accept(SFBlocks.DEAD_VERDANT_CORAL_FAN.get());

                    // sand
                    output.accept(SFBlocks.GRAVELY_SAND.get());
                    output.accept(SFBlocks.ROCKY_SAND.get());
                    output.accept(SFBlocks.MIXED_SHELLY_SAND.get());
                    output.accept(SFBlocks.JUMBLED_SHELLY_SAND.get());
                    output.accept(SFBlocks.SCATTERED_SHELLY_SAND.get());
                    output.accept(SFBlocks.RED_SPRINKLED_SAND.get());
                    output.accept(SFBlocks.RED_MIXED_SPRINKLED_SAND.get());
                    output.accept(SFBlocks.BLUE_SPRINKLED_SAND.get());
                    output.accept(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get());
                    output.accept(SFBlocks.PURPLE_SPRINKLED_SAND.get());
                    output.accept(SFBlocks.PINK_SPRINKLED_SAND.get());
                    output.accept(SFBlocks.CORAL_SAND.get());
                    output.accept(SFBlocks.CORALINE_SANDSTONE.get());
                    output.accept(SFBlocks.CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SFBlocks.CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SFBlocks.CHISELED_CORALINE_SANDSTONE.get());
                    output.accept(SFBlocks.SMOOTH_CORALINE_SANDSTONE.get());
                    output.accept(SFBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SFBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SFBlocks.CUT_CORALINE_SANDSTONE.get());
                    output.accept(SFBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get());
                    output.accept(SFBlocks.CUT_CORALINE_SANDSTONE_SLAB.get());
                    output.accept(SFBlocks.SALT_BLOCK.get());

                    // shell blocks
                    output.accept(SFBlocks.SPIKY_SHELL_BRICKS.get());
                    output.accept(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS.get());
                    output.accept(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get());
                    output.accept(SFBlocks.SPIKY_SHELL_PILLAR.get());
                    output.accept(SFBlocks.CLAM_SHELL_BRICKS.get());
                    output.accept(SFBlocks.CLAM_SHELL_BRICKS_STAIRS.get());
                    output.accept(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get());
                    output.accept(SFBlocks.CLAM_SHELL_PILLAR.get());
                    output.accept(SFBlocks.HORN_SHELL_BRICKS.get());
                    output.accept(SFBlocks.HORN_SHELL_BRICKS_STAIRS.get());
                    output.accept(SFBlocks.HORN_SHELL_BRICKS_SLAB.get());
                    output.accept(SFBlocks.HORN_SHELL_PILLAR.get());
                    output.accept(SFBlocks.SWIRL_SHELL_BRICKS.get());
                    output.accept(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS.get());
                    output.accept(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get());
                    output.accept(SFBlocks.SWIRL_SHELL_PILLAR.get());
                    output.accept(SFBlocks.SPIRAL_SHELL_BRICKS.get());
                    output.accept(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get());
                    output.accept(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get());
                    output.accept(SFBlocks.SPIRAL_SHELL_PILLAR.get());
                    output.accept(SFBlocks.PYRAMID_SHELL_BRICKS.get());
                    output.accept(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get());
                    output.accept(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get());
                    output.accept(SFBlocks.PYRAMID_SHELL_PILLAR.get());
                    output.accept(SFBlocks.ALGAE_COBBLESTONE.get());
                    output.accept(SFBlocks.ALGAE_COBBLESTONE_STAIRS.get());
                    output.accept(SFBlocks.ALGAE_COBBLESTONE_SLAB.get());

                    // sea glass
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.PEARLY_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.UMBER_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.UMBER_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.SCARLET_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.AMBER_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.AMBER_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.CITRINE_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.AZURE_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.AZURE_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.LILAC_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.LILAC_SEA_GLASS_BOTTLE.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_PEBBLES.get());
                    output.accept(SFBlocks.ROSE_PEBBLED_SEA_GLASS.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_PANE.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_BRICKS.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_TILES.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_TILE_SLAB.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_LAMP.get());
                    output.accept(SFBlocks.ROSE_SEA_GLASS_BOTTLE.get());

                    // Unsorted stuff
                    if (!(item.get() instanceof ForgeSpawnEggItem)) {
                        output.accept(item.get());
                    }
                }
            })
            .build());
}
