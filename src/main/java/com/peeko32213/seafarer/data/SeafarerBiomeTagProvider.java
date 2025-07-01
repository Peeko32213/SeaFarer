package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.registry.tags.SeafarerTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SeafarerBiomeTagProvider extends net.minecraft.data.tags.BiomeTagsProvider {
    public SeafarerBiomeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pPro, ExistingFileHelper existingFileHelper) {
        super(pOutput,pPro , SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.addTags();
    }

    protected void addTags() {
        tag(SeafarerTags.IS_CRAB_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        tag(SeafarerTags.IS_HORSECRAB_BIOME).add(Biomes.BEACH);
        tag(SeafarerTags.IS_MARINE_IGUANA_BIOME).add(Biomes.STONY_SHORE);
        tag(SeafarerTags.IS_SUNFISH_BIOME).add(Biomes.OCEAN).add(Biomes.LUKEWARM_OCEAN).add(Biomes.COLD_OCEAN);

        tag(SeafarerTags.IS_BEACH_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        tag(SeafarerTags.IS_SANDY_BEACH_BIOME).add(Biomes.BEACH);
        tag(SeafarerTags.IS_ALGAE_BOULDER_BIOME).add(Biomes.BEACH).add(Biomes.LUKEWARM_OCEAN);

    }
}
