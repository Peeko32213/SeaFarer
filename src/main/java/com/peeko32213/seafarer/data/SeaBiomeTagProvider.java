package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.tags.SeaBiomeTags;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
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
        this.tag(SeaBiomeTags.WARM_OCEANS).add(Biomes.WARM_OCEAN).add(SeaBiomes.WARM_REEF);

        this.tag(SeaBiomeTags.HAS_VOLCANOES).add(SeaBiomes.VOLCANIC_ISLAND);
    }
}
