package com.peeko32213.seafarer.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class SeafarerFishBucket extends MobBucketItem {

	public SeafarerFishBucket(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid,
							  boolean hasTooltip, Properties builder) {
		super(entityType, fluid, () -> SoundEvents.BUCKET_EMPTY_FISH, builder);
	}

}