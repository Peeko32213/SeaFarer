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

        addBlock(SFBlocks.BROWN_SEAGLASS_BLOCK, "Brown Sea Glass Block");
        addBlock(SFBlocks.BROWN_SEAGLASS_BRICKS, "Brown Sea Glass Bricks");
        addBlock(SFBlocks.BROWN_SEAGLASS_PEBBLED, "Pebbled Brown Sea Glass");
        addBlock(SFBlocks.BROWN_SEAGLASS_PEBBLES, "Brown Sea Glass");

        addBlock(SFBlocks.GREEN_SEAGLASS_BLOCK, "Green Sea Glass Block");
        addBlock(SFBlocks.GREEN_SEAGLASS_BRICKS, "Green Sea Glass Bricks");
        addBlock(SFBlocks.GREEN_SEAGLASS_PEBBLED, "Pebbled Green Sea Glass");
        addBlock(SFBlocks.GREEN_SEAGLASS_PEBBLES, "Green Sea Glass");

        addBlock(SFBlocks.ORANGE_SEAGLASS_BLOCK, "Orange Sea Glass Block");
        addBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS, "Orange Sea Glass Bricks");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLED, "Pebbled Orange Sea Glass");
        addBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLES, "Orange Sea Glass");

        addBlock(SFBlocks.PURPLE_SEAGLASS_BLOCK, "Purple Sea Glass Block");
        addBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS, "Purple Sea Glass Bricks");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLED, "Pebbled Purple Sea Glass");
        addBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLES, "Purple Sea Glass");

        addBlock(SFBlocks.RED_SEAGLASS_BLOCK, "Red Sea Glass Block");
        addBlock(SFBlocks.RED_SEAGLASS_BRICKS, "Red Sea Glass Bricks");
        addBlock(SFBlocks.RED_SEAGLASS_PEBBLED, "Pebbled Red Sea Glass");
        addBlock(SFBlocks.RED_SEAGLASS_PEBBLES, "Red Sea Glass");


        addBlock(SFBlocks.YELLOW_SEAGLASS_BLOCK, "Red Sea Glass Block");
        addBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS, "Red Sea Glass Bricks");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLED, "Pebbled Red Sea Glass");
        addBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLES, "Red Sea Glass");

        addBlock(SFBlocks.FISHING_NET, "Fishing Net");

        addBlock(SFBlocks.STARFISH_BLUE, "Blue Starfish");
        addBlock(SFBlocks.STARFISH_GREEN, "Green Starfish");
        addBlock(SFBlocks.STARFISH_PINK, "Pink Starfish");
        addBlock(SFBlocks.STARFISH_PURPLE, "Purple Starfish");
        addBlock(SFBlocks.STARFISH_RED, "Red Starfish");
        addBlock(SFBlocks.STARFISH_YELLOW, "Yellow Starfish");

        addEntityType(SFEntities.SUNFISH, "Sunfish");
        addItem(SFItems.SUNFISH_SPAWN_EGG, "Sunfish Spawn Egg");

        addEntityType(SFEntities.CRAB, "Crab");
        addItem(SFItems.CRAB_SPAWN_EGG, "Crab Spawn Egg");

        addEntityType(SFEntities.HORSESHOE_CRAB, "Horseshoe Crab");
        addItem(SFItems.HORSESHOE_CRAB_SPAWN_EGG, "Horseshoe Crab Spawn Egg");

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
