package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.tags.SeaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SeaBiomeTagProvider extends net.minecraft.data.tags.BiomeTagsProvider {
    public SeaBiomeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pPro, ExistingFileHelper existingFileHelper) {
        super(pOutput,pPro , Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.addTags();
    }

    protected void addTags() {
        tag(SeaTags.IS_CRAB_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        tag(SeaTags.IS_HORSECRAB_BIOME).add(Biomes.BEACH);
        tag(SeaTags.IS_MARINE_IGUANA_BIOME).add(Biomes.STONY_SHORE);
        tag(SeaTags.IS_SUNFISH_BIOME).add(Biomes.OCEAN).add(Biomes.LUKEWARM_OCEAN).add(Biomes.COLD_OCEAN);

        tag(SeaTags.IS_BEACH_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        tag(SeaTags.IS_SANDY_BEACH_BIOME).add(Biomes.BEACH);
        tag(SeaTags.IS_ALGAE_BOULDER_BIOME).add(Biomes.BEACH).add(Biomes.LUKEWARM_OCEAN);

    }
}
