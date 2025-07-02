package com.peeko32213.seafarer.data;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.*;
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

public class SeafarerLanguageProvider extends LanguageProvider {
    public SeafarerLanguageProvider(PackOutput output) {
        super(output, Seafarer.MOD_ID, "en_us");
    }
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    protected void addTranslations(){

        addTabName(SeafarerCreativeTab.TAB.get(), "Seafarer");

        // Blocks
        SeafarerBlocks.AUTO_TRANSLATE.forEach(this::forBlock);

        // Items
        SeafarerItems.AUTO_TRANSLATE.forEach(this::forItem);

        // Paintings
        SeafarerPaintings.PAINTING_TRANSLATIONS.forEach(this::painting);

        // Raw food
        addItem(SeafarerItems.RAW_FROGFISH, "Raw Frogfish");
        addItem(SeafarerItems.RAW_BLUE_TANG, "Raw Blue Tang");
        addItem(SeafarerItems.RAW_COPPERBAND_BUTTERFLYFISH, "Raw Copperband Butterflyfish");
        addItem(SeafarerItems.RAW_SQUIRRELFISH, "Raw Squirrelfish");
        addItem(SeafarerItems.RAW_MANDARINFISH, "Raw Mandarinfish");
        addItem(SeafarerItems.RAW_SEXY_SHRIMP, "Raw Sexy Shrimp");
        addItem(SeafarerItems.RAW_GARDEN_EEL, "Raw Garden Eel");
        addItem(SeafarerItems.RAW_HORSESHOE_CRAB, "Raw Horseshoe Crab");
        addItem(SeafarerItems.RAW_CRAB_LEG, "Raw Crab Leg");
        addItem(SeafarerItems.RAW_MARINE_IGUANA_TAIL, "Raw Marine Iguana Tail");

//        addItem(SeafarerItems.CRAB_BUCKET, "Bucket of Crab");
//        addItem(SeafarerItems.HORSESHOE_CRAB_BUCKET, "Bucket of Horseshoe Crab");
//        addItem(SeafarerItems.SQUIRRELFISH_BUCKET, "Bucket of Squirrelfish");

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
        return  Seafarer.MOD_ID + " Languages: en_us";
    }

    public void addBETranslatable(String beName,String name){
        add(Seafarer.MOD_ID + ".blockentity." + beName, name);
    }

    public void addSound(Supplier<? extends SoundEvent> key, String name){
        add(Seafarer.MOD_ID + ".sound.subtitle." + key.get().getLocation().getPath(), name);
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
        add("registerItemNoLang.minecraft.potion.effect." + regName, name);
        add("registerItemNoLang.minecraft.splash_potion.effect." + regName, "Splash " + name);
        add("registerItemNoLang.minecraft.lingering_potion.effect." + regName, "Lingering " + name);
    }

    protected void painting(String name, String author) {
        add("painting." + Seafarer.MOD_ID + "." + name + ".title",  SeafarerTextUtils.createTranslation(name));
        add("painting." + Seafarer.MOD_ID + "." + name + ".author",  author);
    }

    protected void forBlock(Supplier<? extends Block> block) {
        addBlock(block, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forItem(Supplier<? extends Item> item) {
        addItem(item, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }
}
