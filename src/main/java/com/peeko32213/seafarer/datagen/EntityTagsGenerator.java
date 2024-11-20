package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFEntities;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EntityTagsGenerator extends EntityTypeTagsProvider {


    public EntityTagsGenerator(PackOutput p_256095_, CompletableFuture<HolderLookup.Provider> p_256572_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_256095_, p_256572_, SeaFarer.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider pProvider) {

        /**Example**/
        //tag(UPTags.ANURO_TARGETS).add(UPEntities.BABY_BRACHI.get());

        tag(SFTags.FROGFISH_TARGETS)
                .add(SFEntities.SEXY_SHRIMP.get())
                .add(SFEntities.GARDEN_EEL.get())
                .add(SFEntities.CRAB.get())
                .add(EntityType.COD)
                .add(EntityType.SALMON)
                .add(EntityType.TROPICAL_FISH);
    }

    @Override
    public String getName() {
        return SeaFarer.MODID + " Entity type tags provider";
    }
}