package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.tags.SFTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class SFItemTagProvider extends ItemTagsProvider {

    public SFItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, p_275322_, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.copy(SFTags.STARFISH, SFTags.STARFISH_ITEM);
    }

    @Override
    public String getName() { return Seafarer.MOD_ID + " Item Tags";}
}
