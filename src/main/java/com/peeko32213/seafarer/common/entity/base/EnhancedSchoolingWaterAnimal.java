package com.peeko32213.seafarer.common.entity.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public abstract class EnhancedSchoolingWaterAnimal extends EnhancedWaterAnimal {

    @Nullable
    private EnhancedSchoolingWaterAnimal leader;
    protected int schoolSize = 1;

    public EnhancedSchoolingWaterAnimal(EntityType<? extends EnhancedSchoolingWaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public int getMaxSpawnClusterSize() {
        return this.getMaxSchoolSize();
    }

    public int getMaxSchoolSize() {
        return super.getMaxSpawnClusterSize();
    }

    protected boolean canRandomSwim() {
        return !this.isFollower();
    }

    public boolean isFollower() {
        return this.leader != null && this.leader.isAlive();
    }

    public EnhancedSchoolingWaterAnimal startFollowing(EnhancedSchoolingWaterAnimal entity) {
        this.leader = entity;
        entity.addFollower();
        return entity;
    }

    public void stopFollowing() {
        this.leader.removeFollower();
        this.leader = null;
    }

    private void addFollower() {
        ++this.schoolSize;
    }

    private void removeFollower() {
        --this.schoolSize;
    }

    public boolean canBeFollowed() {
        return this.hasFollowers() && this.schoolSize < this.getMaxSchoolSize();
    }

    public void tick() {
        super.tick();
        if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
            List<? extends EnhancedSchoolingWaterAnimal> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
            if (list.size() <= 1) {
                this.schoolSize = 1;
            }
        }
    }

    public boolean hasFollowers() {
        return this.schoolSize > 1;
    }

    public boolean inRangeOfLeader() {
        return this.distanceToSqr(this.leader) <= 121.0D;
    }

    public void pathToLeader() {
        if (this.isFollower()) {
            this.getNavigation().moveTo(this.leader, 1.0D);
        }
    }

    public void addFollowers(Stream<? extends EnhancedSchoolingWaterAnimal> entity) {
        entity.limit(this.getMaxSchoolSize() - this.schoolSize).filter((entity1) -> entity1 != this).forEach((entity2) -> {
            entity2.startFollowing(this);
        });
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData, tag);
        if (spawnGroupData == null) {
            spawnGroupData = new SchoolSpawnGroupData(this);
        } else {
            this.startFollowing(((SchoolSpawnGroupData)spawnGroupData).leader);
        }
        return spawnGroupData;
    }

    public static class SchoolSpawnGroupData implements SpawnGroupData {
        public final EnhancedSchoolingWaterAnimal leader;
        public SchoolSpawnGroupData(EnhancedSchoolingWaterAnimal entity) {
            this.leader = entity;
        }
    }
}
