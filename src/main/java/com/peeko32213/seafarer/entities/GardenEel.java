package com.peeko32213.seafarer.entities;

import com.peeko32213.seafarer.entities.base.EnhancedWaterAnimal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.List;

public class GardenEel extends EnhancedWaterAnimal {

    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(GardenEel.class, EntityDataSerializers.INT);

    public static String getVariantName(int variant) {
        return switch (variant) {
            case 1 -> "orange";
            default -> "black";
        };
    }

    private static final EntityDataAccessor<Boolean> RETREATED = SynchedEntityData.defineId(GardenEel.class, EntityDataSerializers.BOOLEAN);
    public float prevRetreatProgress;
    public float retreatProgress;
    private int hideInShellTimer = 0;
    public GardenEel(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RETREATED, false);
        this.entityData.define(VARIANT, 0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant());

    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(compound.getInt("Variant"));
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, Integer.valueOf(variant));
    }

    public boolean hasRetreated() {
        return this.entityData.get(RETREATED);
    }

    public void setRetreated(boolean b) {
        this.entityData.set(RETREATED, Boolean.valueOf(b));
    }

    public void tick() {
        super.tick();
        prevRetreatProgress = retreatProgress;
        final boolean retreated = this.hasRetreated();


        if (retreated) {
            if (retreatProgress < 5F)
                retreatProgress++;
        } else {
            if (retreatProgress > 0F)
                retreatProgress--;
        }

        if (!this.level().isClientSide) {
             {
                List<Player> list = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(0, 0.15F, 0));
                for (Player player : list) {
                    if ((!player.onGround()) && player.getY() > this.getEyeY()) {
                        if (!hasRetreated()) {
                            this.hideInShellTimer += 40 + random.nextInt(40);
                        }
                    }
                }
            }
            this.setRetreated(hideInShellTimer > 0);
        }
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        float variantChange = this.getRandom().nextFloat();

        if(variantChange <= 0.5F){
            this.setVariant(1);
        } else{
            this.setVariant(0);
        }
        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
}
