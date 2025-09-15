package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.tags.SeaBiomeTags;
import com.peeko32213.seafarer.registry.tags.SeaTags;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SeaBiomeTagProvider extends BiomeTagsProvider {

    public SeaBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Seafarer.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.addTags();
    }

    protected void addTags() {
        this.tag(SeaTags.IS_CRAB_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        this.tag(SeaTags.IS_HORSECRAB_BIOME).add(Biomes.BEACH);
        this.tag(SeaTags.IS_SUNFISH_BIOME).add(Biomes.OCEAN).add(Biomes.LUKEWARM_OCEAN).add(Biomes.COLD_OCEAN).add(TagEntry.element(new ResourceLocation(Seafarer.MOD_ID, "warm_reef")));

        this.tag(SeaTags.IS_BEACH_BIOME).add(Biomes.BEACH).add(Biomes.STONY_SHORE);
        this.tag(SeaTags.IS_SANDY_BEACH_BIOME).add(Biomes.BEACH);
        this.tag(SeaTags.IS_ALGAE_BOULDER_BIOME).add(Biomes.BEACH).add(Biomes.LUKEWARM_OCEAN);

        this.tag(SeaBiomeTags.WARM_OCEANS).add(Biomes.WARM_OCEAN).add(TagEntry.element(new ResourceLocation(Seafarer.MOD_ID, "warm_reef")));

        this.tag(SeaBiomeTags.HAS_VOLCANOES).add(SeaBiomes.VOLCANIC_ISLAND);
    }
}
