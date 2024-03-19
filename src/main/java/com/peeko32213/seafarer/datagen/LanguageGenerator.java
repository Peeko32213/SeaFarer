package com.peeko32213.seafarer.datagen;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFCreativeTabs;
import com.peeko32213.seafarer.core.registry.SFEntities;
import com.peeko32213.seafarer.core.registry.SFItems;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.LanguageProvider;
import org.slf4j.Logger;

import java.util.function.Supplier;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, SeaFarer.MODID, "en_us");
    }
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    protected void addTranslations(){

        addTabName(SFCreativeTabs.TAB.get(), "Seafarer");

        addBlock(SFBlocks.BLUE_SEAGLASS_BLOCK, "Blue Sea Glass Block");
        addBlock(SFBlocks.BLUE_SEAGLASS_BRICKS, "Blue Sea Glass Bricks");
        addBlock(SFBlocks.BLUE_SEAGLASS_PEBBLED, "Pebbled Blue Sea Glass");
        addBlock(SFBlocks.BLUE_SEAGLASS_PEBBLES, "Blue Sea Glass");
        addBlock(SFBlocks.BLUE_SEAGLASS_TILES, "Blue Sea Glass Tiles");
        addBlock(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS, "Blue Sea Glass Tile Stairs");
        addBlock(SFBlocks.BLUE_SEAGLASS_TILES_SLAB, "Blue Sea Glass Tile Slabs");
        addBlock(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB, "Blue Sea Glass Brick Slabs");
        addBlock(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS, "Blue Sea Glass Brick Stairs");

        addBlock(SFBlocks.BROWN_SEAGLASS_BLOCK, "Brown Sea Glass Block");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS, "Brown Sea Glass Bricks");
        addBlock(SFBlocks.BROWN_SEAGLASS_PEBBLED, "Pebbled Brown Sea Glass");
        addBlock(SFBlocks.BROWN_SEAGLASS_PEBBLES, "Brown Sea Glass");
        addBlock(SFBlocks.BROWN_SEAGLASS_TILES, "Brown Sea Glass Tiles");
        addBlock(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS, "Brown Sea Glass Tile Stairs");
        addBlock(SFBlocks.BROWN_SEAGLASS_TILES_SLAB, "Brown Sea Glass Tile Slabs");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB, "Brown Sea Glass Brick Slabs");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS, "Brown Sea Glass Brick Stairs");

        addBlock(SFBlocks.GREEN_SEAGLASS_BLOCK, "Green Sea Glass Block");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS, "Green Sea Glass Bricks");
        addBlock(SFBlocks.GREEN_SEAGLASS_PEBBLED, "Pebbled Green Sea Glass");
        addBlock(SFBlocks.GREEN_SEAGLASS_PEBBLES, "Green Sea Glass");
        addBlock(SFBlocks.GREEN_SEAGLASS_TILES, "Green Sea Glass Tiles");
        addBlock(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS, "Green Sea Glass Tile Stairs");
        addBlock(SFBlocks.GREEN_SEAGLASS_TILES_SLAB, "Green Sea Glass Tile Slabs");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB, "Green Sea Glass Brick Slabs");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS, "Green Sea Glass Brick Stairs");

        addBlock(SFBlocks.ORANGE_SEAGLASS_BLOCK, "Orange Sea Glass Block");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS, "Orange Sea Glass Bricks");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLED, "Pebbled Orange Sea Glass");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLES, "Orange Sea Glass");
        addBlock(SFBlocks.ORANGE_SEAGLASS_TILES, "Orange Sea Glass Tiles");
        addBlock(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS, "Orange Sea Glass Tile Stairs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB, "Orange Sea Glass Tile Slabs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB, "Orange Sea Glass Brick Slabs");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS, "Orange Sea Glass Brick Stairs");

        addBlock(SFBlocks.PURPLE_SEAGLASS_BLOCK, "Purple Sea Glass Block");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS, "Purple Sea Glass Bricks");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLED, "Pebbled Purple Sea Glass");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLES, "Purple Sea Glass");
        addBlock(SFBlocks.PURPLE_SEAGLASS_TILES, "Purple Sea Glass Tiles");
        addBlock(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS, "Purple Sea Glass Tile Stairs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB, "Purple Sea Glass Tile Slabs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB, "Purple Sea Glass Brick Slabs");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS, "Purple Sea Glass Brick Stairs");

        addBlock(SFBlocks.RED_SEAGLASS_BLOCK, "Red Sea Glass Block");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS, "Red Sea Glass Bricks");
        addBlock(SFBlocks.RED_SEAGLASS_PEBBLED, "Pebbled Red Sea Glass");
        addBlock(SFBlocks.RED_SEAGLASS_PEBBLES, "Red Sea Glass");
        addBlock(SFBlocks.RED_SEAGLASS_TILES, "Red Sea Glass Tiles");
        addBlock(SFBlocks.RED_SEAGLASS_TILES_STAIRS, "Red Sea Glass Tile Stairs");
        addBlock(SFBlocks.RED_SEAGLASS_TILES_SLAB, "Red Sea Glass Tile Slabs");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS_SLAB, "Red Sea Glass Brick Slabs");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS, "Red Sea Glass Brick Stairs");

        addBlock(SFBlocks.YELLOW_SEAGLASS_BLOCK, "Yellow Sea Glass Block");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS, "Yellow Sea Glass Bricks");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLED, "Pebbled Yellow Sea Glass");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLES, "Yellow Sea Glass");
        addBlock(SFBlocks.YELLOW_SEAGLASS_TILES, "Yellow Sea Glass Tiles");
        addBlock(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS, "Yellow Sea Glass Tile Stairs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB, "Yellow Sea Glass Tile Slabs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB, "Yellow Sea Glass Brick Slabs");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS, "Yellow Sea Glass Brick Stairs");

        addBlock(SFBlocks.WHITE_SEAGLASS_BLOCK, "White Sea Glass Block");
        addBlock(SFBlocks.WHITE_SEAGLASS_BRICKS, "White Sea Glass Bricks");
        addBlock(SFBlocks.WHITE_SEAGLASS_PEBBLED, "Pebbled White Sea Glass");
        addBlock(SFBlocks.WHITE_SEAGLASS_TILES, "White Sea Glass Tiles");
        addBlock(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS, "White Sea Glass Tile Stairs");
        addBlock(SFBlocks.WHITE_SEAGLASS_TILES_SLAB, "White Sea Glass Tile Slabs");
        addBlock(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB, "White Sea Glass Brick Slabs");
        addBlock(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS, "White Sea Glass Brick Stairs");

        addBlock(SFBlocks.FISHING_NET, "Fishing Net");

        addBlock(SFBlocks.STARFISH_BLUE, "Blue Starfish");
        addBlock(SFBlocks.STARFISH_GREEN, "Green Starfish");
        addBlock(SFBlocks.STARFISH_PINK, "Pink Starfish");
        addBlock(SFBlocks.STARFISH_PURPLE, "Purple Starfish");
        addBlock(SFBlocks.STARFISH_RED, "Red Starfish");
        addBlock(SFBlocks.STARFISH_YELLOW, "Yellow Starfish");

        addBlock(SFBlocks.DEAD_STARFISH_BLUE, "Dead Blue Starfish");
        addBlock(SFBlocks.DEAD_STARFISH_GREEN, "Dead Green Starfish");
        addBlock(SFBlocks.DEAD_STARFISH_PINK, "Dead Pink Starfish");
        addBlock(SFBlocks.DEAD_STARFISH_PURPLE, "Dead Purple Starfish");
        addBlock(SFBlocks.DEAD_STARFISH_RED, "Dead Red Starfish");
        addBlock(SFBlocks.DEAD_STARFISH_YELLOW, "Dead Yellow Starfish");

        addEntityType(SFEntities.SUNFISH, "Sunfish");
        addItem(SFItems.SUNFISH_SPAWN_EGG, "Sunfish Spawn Egg");

        addEntityType(SFEntities.CRAB, "Crab");
        addItem(SFItems.CRAB_SPAWN_EGG, "Crab Spawn Egg");

        addEntityType(SFEntities.HORSESHOE_CRAB, "Horseshoe Crab");
        addItem(SFItems.HORSESHOE_CRAB_SPAWN_EGG, "Horseshoe Crab Spawn Egg");

        addEntityType(SFEntities.MARINE_IGUANA, "Marine Iguana");
        addItem(SFItems.MARINE_IGUANA_SPAWN_EGG, "Marine Iguana Spawn Egg");

        addBlock(SFBlocks.SHELL_BLOCK_PILLAR, "Shell Pillar");

        addBlock(SFBlocks.SHELL_BLOCK_MOSAIC, "Shell Mosaic");
        addBlock(SFBlocks.SHELL_BLOCK_MOSAIC_STAIRS, "Shell Mosaic Stair");
        addBlock(SFBlocks.SHELL_BLOCK_MOSAIC_SLAB, "Shell Mosaic Slab");

        addBlock(SFBlocks.SHELL_BLOCK_SHINGLES, "Shell Shingles");
        addBlock(SFBlocks.SHELL_BLOCK_SHINGLES_STAIRS, "Shell Shingles Stair");
        addBlock(SFBlocks.SHELL_BLOCK_SHINGLES_SLAB, "Shell Shingles Slab");

        addBlock(SFBlocks.SHELL_BLOCK_CLAMS, "Shell Clams");
        addBlock(SFBlocks.SHELL_BLOCK_CLAMS_STAIRS, "Shell Clams Stair");
        addBlock(SFBlocks.SHELL_BLOCK_CLAMS_SLAB, "Shell Clams Slab");

        addBlock(SFBlocks.SHELL_BLOCK_SPIRAL, "Shell Spiral");
        addBlock(SFBlocks.SHELL_BLOCK_SPIRAL_STAIRS, "Shell Spiral Stair");
        addBlock(SFBlocks.SHELL_BLOCK_SPIRAL_SLAB, "Shell Spiral Slab");

        addBlock(SFBlocks.ALGAE_BLOCK, "Algae Block");
        addBlock(SFBlocks.ALGAE_CARPET, "Algae Carpet");
        addBlock(SFBlocks.ALGAE_PLANT, "Algae Growth");

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
}
