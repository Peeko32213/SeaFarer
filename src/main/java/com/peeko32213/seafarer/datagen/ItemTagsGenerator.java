package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTagsGenerator extends ItemTagsProvider {
    public ItemTagsGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                             CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.copy(SFTags.STARFISH, SFTags.STARFISH_ITEM);
    }



    @Override
    public String getName() { return SeaFarer.MODID + " Item Tags";}
}
