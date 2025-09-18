package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.tags.SeaEntityTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeaEntityTagProvider extends EntityTypeTagsProvider {

    public SeaEntityTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, Seafarer.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {

        this.tag(SeaEntityTags.COLLIDES_WITH_FISHING_NETS).add(
                EntityType.AXOLOTL,
                EntityType.FROG
        );
    }

    @Override
    public String getName() {
        return Seafarer.MOD_ID + " Entity type tags provider";
    }
}
