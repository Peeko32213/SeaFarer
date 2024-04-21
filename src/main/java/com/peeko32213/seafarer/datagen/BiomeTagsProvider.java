package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class BiomeTagsProvider extends net.minecraft.data.tags.BiomeTagsProvider {
    public BiomeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pPro, ExistingFileHelper existingFileHelper) {
        super(pOutput,pPro , SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.addTags();
    }

    protected void addTags() {
        //tag(UPTags.IS_PETRIFIED_WOOD_FOREST_BIOME).add(Biomes.BADLANDS).add(Biomes.WOODED_BADLANDS).add(Biomes.ERODED_BADLANDS).add(Biomes.DESERT);
        tag(SFTags.IS_CRAB_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        tag(SFTags.IS_HORSECRAB_BIOME).add(Biomes.BEACH);
        tag(SFTags.IS_MARINE_IGUANA_BIOME).add(Biomes.STONY_SHORE);
        tag(SFTags.IS_SUNFISH_BIOME).add(Biomes.OCEAN).add(Biomes.LUKEWARM_OCEAN).add(Biomes.COLD_OCEAN);

    }
}
