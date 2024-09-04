package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(SFTags.BEACH_PLANT_BLOCKS)
                .addTag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.PURPLE_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.PINK_SPRINKLED_SAND.get())
                .add(SFBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_SPRINKLED_SAND.get())
                .add(SFBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SFBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SFBlocks.MIXED_SHELLY_SAND.get())
        ;

        tag(SFTags.SHELLS)
                .add(SFBlocks.CLAM_SHELL.get())
                .add(SFBlocks.SWIRL_SHELL.get())
                .add(SFBlocks.HORN_SHELL.get())
                .add(SFBlocks.PYRAMID_SHELL.get())
                .add(SFBlocks.SPIKY_SHELL.get())
        ;

        tag(SFTags.STARFISH)
                .add(SFBlocks.STARFISH_BIG_ROYAL.get())
                .add(SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get())
                .add(SFBlocks.STARFISH_BIG_BLUE.get())
                .add(SFBlocks.STARFISH_BIG_OCHRE.get())
                .add(SFBlocks.STARFISH_RED.get())
                .add(SFBlocks.STARFISH_PINK.get())
                .add(SFBlocks.STARFISH_COMMON_ORANGE.get())
                .add(SFBlocks.STARFISH_CHOCOLATE_CHIP.get())
        ;

        tag(BlockTags.BEE_GROWABLES)
                .add(SFBlocks.COASTAL_WILDFLOWER.get())
                .add(SFBlocks.COASTAL_LAVENDER.get())
                .add(SFBlocks.SEA_HOLLY.get())
                .add(SFBlocks.SEA_THRIFT.get())
        ;

        tag(SFTags.SPRINKLED_SAND)
                .add(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SFBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SFBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SFBlocks.GRAVELY_SAND.get())
                .add(SFBlocks.PINK_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_SPRINKLED_SAND.get())
                .add(SFBlocks.MIXED_SHELLY_SAND.get())

        ;

    }


    @Override
    public String getName() {
        return SeaFarer.MODID + " Block Tags";
    }
}
