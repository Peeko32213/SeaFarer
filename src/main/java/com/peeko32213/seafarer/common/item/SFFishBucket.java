package com.peeko32213.seafarer.common.item;

import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.function.Supplier;

public class SFFishBucket extends MobBucketItem {

	public SFFishBucket(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid,
						boolean hasTooltip, Properties builder) {
		super(entityType, fluid, () -> SoundEvents.BUCKET_EMPTY_FISH, builder);
	}

}