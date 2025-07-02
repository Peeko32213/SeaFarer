package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeafarerEntities;
import com.peeko32213.seafarer.registry.tags.SeafarerTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeafarerEntityTagProvider extends EntityTypeTagsProvider {


    public SeafarerEntityTagProvider(PackOutput p_256095_, CompletableFuture<HolderLookup.Provider> p_256572_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_256095_, p_256572_, Seafarer.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        tag(SeafarerTags.FROGFISH_TARGETS)
//                .add(SeafarerEntities.SEXY_SHRIMP.get())
//                .add(SeafarerEntities.GARDEN_EEL.get())
//                .add(SeafarerEntities.CRAB.get())
                .add(EntityType.COD)
                .add(EntityType.SALMON)
                .add(EntityType.TROPICAL_FISH)
        ;

//        tag(SeafarerTags.MANTIS_SHRIMP_TARGETS)
//                .add(SeafarerEntities.SEXY_SHRIMP.get())
//                .add(SeafarerEntities.CRAB.get())
//                ;
    }

    @Override
    public String getName() {
        return Seafarer.MOD_ID + " Entity type tags provider";
    }
}
