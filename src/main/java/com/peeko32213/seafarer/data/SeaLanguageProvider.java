package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.SeafarerTab;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.*;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

public class SeaLanguageProvider extends LanguageProvider {

    public SeaLanguageProvider(PackOutput output) {
        super(output, Seafarer.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations(){
        addTabName(SeafarerTab.TAB.get(), "Seafarer");

        // Blocks
        SeaBlocks.AUTO_TRANSLATE.forEach(this::forBlock);

        // Items
        SeaItems.AUTO_TRANSLATE.forEach(this::forItem);

        // Paintings
        SeaPaintings.PAINTING_TRANSLATIONS.forEach(this::painting);

        // Raw food
        addItem(SeaItems.RAW_HORSESHOE_CRAB, "Raw Horseshoe Crab");
        addItem(SeaItems.RAW_SHORE_CRAB_LEG, "Raw Shore Crab Leg");
        addItem(SeaItems.RAW_MARINE_IGUANA_TAIL, "Raw Marine Iguana Tail");

        addItem(SeaItems.SHORE_CRAB_BUCKET, "Bucket of Shore Crab");
        addItem(SeaItems.HORSESHOE_CRAB_BUCKET, "Bucket of Horseshoe Crab");

        add("seafarer.message_in_a_bottle", "Message in a bottle");
        add("seafarer.message.structure_not_found", "Structure was not found!");
        add("seafarer.message.structure_search_failed", "Structure was not found!");

        add("biome.seafarer.warm_reef", "Warm Reef");
        add("biome.seafarer.flowering_beach", "Flowering Beach");
        add("biome.seafarer.kelp_forest", "Kelp Forest");
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
        add("painting." + Seafarer.MOD_ID + "." + name + ".title",  SeaTextUtils.createTranslation(name));
        add("painting." + Seafarer.MOD_ID + "." + name + ".author",  author);
    }

    protected void forBlock(Supplier<? extends Block> block) {
        addBlock(block, SeaTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forItem(Supplier<? extends Item> item) {
        addItem(item, SeaTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }
}
