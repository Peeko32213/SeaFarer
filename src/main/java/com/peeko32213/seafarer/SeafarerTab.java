package com.peeko32213.seafarer;

import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Seafarer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SEAFARER_TAB = CREATIVE_TABS.register("seafarer_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SeaBlocks.SWIRL_SHELL.get()))
                    .title(Component.translatable("itemGroup.seafarer"))
                    .displayItems((parameters, output) -> {

                        // horseshoe crab
                        output.accept(SeaItems.HORSESHOE_CRAB_SPAWN_EGG.get());
                        output.accept(SeaItems.HORSESHOE_CRAB_BUCKET.get());
                        output.accept(SeaItems.RAW_HORSESHOE_CRAB.get());
                        output.accept(SeaItems.COOKED_HORSESHOE_CRAB.get());

                        // manta ray
                        output.accept(SeaItems.MANTA_RAY_SPAWN_EGG.get());

                        // shore crab
                        output.accept(SeaItems.SHORE_CRAB_SPAWN_EGG.get());
                        output.accept(SeaItems.SHORE_CRAB_BUCKET.get());
                        output.accept(SeaItems.RAW_SHORE_CRAB_LEG.get());
                        output.accept(SeaItems.COOKED_SHORE_CRAB_LEG.get());

                        // sunfish
                        output.accept(SeaItems.SUNFISH_SPAWN_EGG.get());

                        output.accept(SeaItems.RAW_MARINE_IGUANA_TAIL.get());
                        output.accept(SeaItems.COOKED_MARINE_IGUANA_TAIL.get());
                        output.accept(SeaBlocks.ORANGE_STARFISH.get());
                        output.accept(SeaBlocks.PINK_STARFISH.get());
                        output.accept(SeaBlocks.RED_STARFISH.get());
                        output.accept(SeaBlocks.CHOCOLATE_CHIP_STARFISH.get());
                        output.accept(SeaBlocks.BLUE_STARFISH.get());
                        output.accept(SeaBlocks.PURPLE_OCHRE_STARFISH.get());
                        output.accept(SeaBlocks.ROYAL_STARFISH.get());
                        output.accept(SeaBlocks.OCHRE_STARFISH.get());
                        output.accept(SeaItems.DRIED_STARFISH.get());
                        output.accept(SeaItems.SEA_URCHIN.get());
                        output.accept(SeaItems.SOY_SAUCE.get());
                        output.accept(SeaItems.SEA_SALT.get());
                        output.accept(SeaBlocks.SALT_BLOCK.get());

                        // junk
                        output.accept(SeaBlocks.FISHING_NET.get());

                        output.accept(SeaBlocks.SHORT_BEACHGRASS.get());
                        output.accept(SeaBlocks.BEACHGRASS.get());
                        output.accept(SeaBlocks.TALL_BEACHGRASS.get());
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
                        output.accept(SeaBlocks.ATTUM_GORGONIAN.get());
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

                        // spiky shell blocks
                        output.accept(SeaBlocks.SPIKY_SHELL.get());
                        output.accept(SeaBlocks.SPIKY_SHELL_BRICKS.get());
                        output.accept(SeaBlocks.SPIKY_SHELL_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.SPIKY_SHELL_BRICK_SLAB.get());
                        output.accept(SeaBlocks.SPIKY_SHELL_PILLAR.get());

                        // clam shell blocks
                        output.accept(SeaBlocks.CLAM_SHELL.get());
                        output.accept(SeaBlocks.CLAM_SHELL_BRICKS.get());
                        output.accept(SeaBlocks.CLAM_SHELL_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.CLAM_SHELL_BRICK_SLAB.get());
                        output.accept(SeaBlocks.CLAM_SHELL_PILLAR.get());

                        // horn shell blocks
                        output.accept(SeaBlocks.HORN_SHELL.get());
                        output.accept(SeaBlocks.HORN_SHELL_BRICKS.get());
                        output.accept(SeaBlocks.HORN_SHELL_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.HORN_SHELL_BRICK_SLAB.get());
                        output.accept(SeaBlocks.HORN_SHELL_PILLAR.get());

                        // swirl shell blocks
                        output.accept(SeaBlocks.SWIRL_SHELL.get());
                        output.accept(SeaBlocks.SWIRL_SHELL_BRICKS.get());
                        output.accept(SeaBlocks.SWIRL_SHELL_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.SWIRL_SHELL_BRICK_SLAB.get());
                        output.accept(SeaBlocks.SWIRL_SHELL_PILLAR.get());

                        // spiral shell blocks
                        output.accept(SeaBlocks.SPIRAL_SHELL.get());
                        output.accept(SeaBlocks.SPIRAL_SHELL_BRICKS.get());
                        output.accept(SeaBlocks.SPIRAL_SHELL_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.SPIRAL_SHELL_BRICK_SLAB.get());
                        output.accept(SeaBlocks.SPIRAL_SHELL_PILLAR.get());

                        // pyramid shell blocks
                        output.accept(SeaBlocks.PYRAMID_SHELL.get());
                        output.accept(SeaBlocks.PYRAMID_SHELL_BRICKS.get());
                        output.accept(SeaBlocks.PYRAMID_SHELL_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.PYRAMID_SHELL_BRICK_SLAB.get());
                        output.accept(SeaBlocks.PYRAMID_SHELL_PILLAR.get());

                        // misc sand
                        output.accept(SeaBlocks.SHELLY_SAND.get());
                        output.accept(SeaBlocks.STARRY_SAND.get());
                        output.accept(SeaBlocks.SEA_GLASS_SAND.get());

                        // coraline sand
                        output.accept(SeaBlocks.CORALINE_SAND.get());
                        output.accept(SeaBlocks.SHELLY_CORALINE_SAND.get());
                        output.accept(SeaBlocks.STARRY_CORALINE_SAND.get());
                        output.accept(SeaBlocks.CORALINE_SANDSTONE.get());
                        output.accept(SeaBlocks.CORALINE_SANDSTONE_STAIRS.get());
                        output.accept(SeaBlocks.CORALINE_SANDSTONE_SLAB.get());
                        output.accept(SeaBlocks.CORALINE_SANDSTONE_WALL.get());
                        output.accept(SeaBlocks.CHISELED_CORALINE_SANDSTONE.get());
                        output.accept(SeaBlocks.SMOOTH_CORALINE_SANDSTONE.get());
                        output.accept(SeaBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
                        output.accept(SeaBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get());
                        output.accept(SeaBlocks.CUT_CORALINE_SANDSTONE.get());
                        output.accept(SeaBlocks.CUT_CORALINE_SANDSTONE_SLAB.get());

                        // volcanic sand
                        output.accept(SeaBlocks.VOLCANIC_SAND.get());
//                        output.accept(SeaBlocks.SHELLY_VOLCANIC_SAND.get());
//                        output.accept(SeaBlocks.STARRY_VOLCANIC_SAND.get());
                        output.accept(SeaBlocks.VOLCANIC_SANDSTONE.get());
                        output.accept(SeaBlocks.VOLCANIC_SANDSTONE_STAIRS.get());
                        output.accept(SeaBlocks.VOLCANIC_SANDSTONE_SLAB.get());
                        output.accept(SeaBlocks.VOLCANIC_SANDSTONE_WALL.get());
                        output.accept(SeaBlocks.CHISELED_VOLCANIC_SANDSTONE.get());
                        output.accept(SeaBlocks.SMOOTH_VOLCANIC_SANDSTONE.get());
                        output.accept(SeaBlocks.SMOOTH_VOLCANIC_SANDSTONE_STAIRS.get());
                        output.accept(SeaBlocks.SMOOTH_VOLCANIC_SANDSTONE_SLAB.get());
                        output.accept(SeaBlocks.CUT_VOLCANIC_SANDSTONE.get());
                        output.accept(SeaBlocks.CUT_VOLCANIC_SANDSTONE_SLAB.get());

                        output.accept(SeaItems.SEA_GLASS_PEBBLES.get());

                        // white sea glass
                        output.accept(SeaBlocks.WHITE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.WHITE_SEA_GLASS_BOTTLE.get());

                        // light gray sea glass
                        output.accept(SeaBlocks.LIGHT_GRAY_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_SEA_GLASS.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.LIGHT_GRAY_NETTED_SEA_GLASS_LAMP.get());

                        // gray sea glass
                        output.accept(SeaBlocks.GRAY_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.GRAY_SEA_GLASS.get());
                        output.accept(SeaBlocks.GRAY_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.GRAY_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.GRAY_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.GRAY_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.GRAY_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.GRAY_NETTED_SEA_GLASS_LAMP.get());

                        // black sea glass
                        output.accept(SeaBlocks.BLACK_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.BLACK_SEA_GLASS_BOTTLE.get());

                        output.accept(SeaBlocks.BROWN_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.BROWN_SEA_GLASS.get());
                        output.accept(SeaBlocks.BROWN_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.BROWN_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.BROWN_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.BROWN_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.BROWN_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.BROWN_NETTED_SEA_GLASS_LAMP.get());

                        output.accept(SeaBlocks.RED_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.RED_SEA_GLASS_BOTTLE.get());

                        output.accept(SeaBlocks.ORANGE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.ORANGE_SEA_GLASS_BOTTLE.get());

                        output.accept(SeaBlocks.YELLOW_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.YELLOW_SEA_GLASS_BOTTLE.get());

                        output.accept(SeaBlocks.LIME_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.LIME_SEA_GLASS_BOTTLE.get());

                        output.accept(SeaBlocks.GREEN_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.GREEN_SEA_GLASS_BOTTLE.get());

                        // light blue sea glass
                        output.accept(SeaBlocks.LIGHT_BLUE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_SEA_GLASS.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BOTTLE.get());

                        // cyan sea glass
                        output.accept(SeaBlocks.CYAN_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.CYAN_SEA_GLASS.get());
                        output.accept(SeaBlocks.CYAN_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.CYAN_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.CYAN_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.CYAN_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.CYAN_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.CYAN_NETTED_SEA_GLASS_LAMP.get());

                        // blue sea glass
                        output.accept(SeaBlocks.BLUE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.BLUE_SEA_GLASS.get());
                        output.accept(SeaBlocks.BLUE_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.BLUE_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.BLUE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.BLUE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.BLUE_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.BLUE_NETTED_SEA_GLASS_LAMP.get());

                        // purple sea glass
                        output.accept(SeaBlocks.PURPLE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.PURPLE_SEA_GLASS.get());
                        output.accept(SeaBlocks.PURPLE_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.PURPLE_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.PURPLE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.PURPLE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.PURPLE_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.PURPLE_NETTED_SEA_GLASS_LAMP.get());

                        // magenta sea glass
                        output.accept(SeaBlocks.MAGENTA_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.MAGENTA_SEA_GLASS_BOTTLE.get());

                        output.accept(SeaBlocks.PINK_PEBBLED_SEA_GLASS.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS_PANE.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS_BRICKS.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS_LAMP.get());
                        output.accept(SeaBlocks.PINK_SEA_GLASS_BOTTLE.get());
            }).build());
}
