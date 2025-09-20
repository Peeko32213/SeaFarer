package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.SeafarerTab;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.*;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
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
        translateCreativeTab(SeafarerTab.SEAFARER_TAB.get(), "Seafarer");

        SeaBlocks.BLOCK_TRANSLATIONS.forEach(this::forBlocks);
        SeaItems.ITEM_TRANSLATIONS.forEach(this::forItems);
        SeaPaintings.PAINTING_TRANSLATIONS.forEach(this::translatePainting);

        // Raw food
        this.addItem(SeaItems.RAW_HORSESHOE_CRAB, "Raw Horseshoe Crab");
        this.addItem(SeaItems.RAW_SHORE_CRAB_LEG, "Raw Shore Crab Leg");

        this.addItem(SeaItems.SHORE_CRAB_BUCKET, "Bucket of Shore Crab");
        this.addItem(SeaItems.HORSESHOE_CRAB_BUCKET, "Bucket of Horseshoe Crab");

        this.translateBiome(SeaBiomes.WARM_REEF);
        this.translateBiome(SeaBiomes.FLOWERING_BEACH);
        this.translateBiome(SeaBiomes.VOLCANIC_ISLAND);
        this.translateBiome(SeaBiomes.GLASS_BEACH);
        this.translateBiome(SeaBiomes.KELP_FOREST);
        this.translateBiome(SeaBiomes.TROPICAL_RIVER);
        this.translateBiome(SeaBiomes.GRASSY_BEACH);

        this.translateSound(SeaSoundEvents.FISH_IDLE, "Fish gurgles");
        this.translateSound(SeaSoundEvents.FISH_DEATH, "Fish dies");
        this.translateSound(SeaSoundEvents.FISH_HURT, "Fish hurts");
        this.translateSound(SeaSoundEvents.FISH_FLOP, "Fish flops");
        this.translateSound(SeaSoundEvents.FISH_JUMP, "Fish jumps");
    }

    @Override
    public String getName() {
        return  Seafarer.MOD_ID + " Languages: en_us";
    }

    public void translateSound(Supplier<? extends SoundEvent> key, String name){
        add(Seafarer.MOD_ID + ".sound.subtitle." + key.get().getLocation().getPath(), name);
    }

    public void translateCreativeTab(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void translateEnchantmentWithDescription(String description, Enchantment enchantment){
        add(enchantment.getDescriptionId() + ".desc", description);
    }

    private void translateBiome(ResourceKey<Biome> biome) {
        String name = biome.location().getPath();
        this.add("biome." + Seafarer.MOD_ID + "." + name, SeaTextUtils.createTranslation(name));
    }

    public void translatePotion(Supplier<? extends Potion> key, String name, String regName) {
        add("registerItemNoLang.minecraft.potion.effect." + regName, name);
        add("registerItemNoLang.minecraft.splash_potion.effect." + regName, "Splash " + name);
        add("registerItemNoLang.minecraft.lingering_potion.effect." + regName, "Lingering " + name);
    }

    protected void translatePainting(String name, String author) {
        add("painting." + Seafarer.MOD_ID + "." + name + ".title",  SeaTextUtils.createTranslation(name));
        add("painting." + Seafarer.MOD_ID + "." + name + ".author",  author);
    }

    protected void forBlocks(Supplier<? extends Block> block) {
        addBlock(block, SeaTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forItems(Supplier<? extends Item> item) {
        addItem(item, SeaTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }
}
