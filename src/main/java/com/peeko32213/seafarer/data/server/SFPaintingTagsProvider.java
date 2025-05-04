package com.peeko32213.seafarer.data.server;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFPaintings;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SFPaintingTagsProvider extends PaintingVariantTagsProvider {

    public SFPaintingTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, SeaFarer.MODID, helper);
    }

    @Override
    protected void addTags(@NotNull Provider provider) {
        TagAppender<PaintingVariant> appender = this.tag(PaintingVariantTags.PLACEABLE);
        for (RegistryObject<PaintingVariant> variant : SFPaintings.PAINTING_VARIANTS.getEntries()) {
            appender.add(variant.getKey());
        }
    }
}
