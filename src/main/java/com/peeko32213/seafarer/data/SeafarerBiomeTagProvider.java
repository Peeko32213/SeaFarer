package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.tags.SeafarerBiomeTags;
import com.peeko32213.seafarer.registry.worldgen.SeafarerBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SeafarerBiomeTagProvider extends BiomeTagsProvider {

    public SeafarerBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Seafarer.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.addTags();
    }

    protected void addTags() {
        this.tag(SeafarerBiomeTags.WARM_OCEANS).add(Biomes.WARM_OCEAN).add(SeafarerBiomes.WARM_REEF);

        this.tag(SeafarerBiomeTags.HAS_VOLCANOES).add(SeafarerBiomes.VOLCANIC_ISLAND);

        this.tag(BiomeTags.IS_OVERWORLD).add(
                SeafarerBiomes.VOLCANIC_ISLAND,
                SeafarerBiomes.WARM_REEF,
                SeafarerBiomes.FLOWERING_BEACH,
                SeafarerBiomes.GLASS_BEACH,
                SeafarerBiomes.GRASSY_BEACH
        );
    }
}
