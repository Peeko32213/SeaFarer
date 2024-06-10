package com.peeko32213.seafarer.common.entity.goal;

import com.peeko32213.seafarer.common.entity.misc.AbstractSleepingAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public class NocturnalSleepingGoal extends Goal {

    public AbstractSleepingAnimal entity;

    public NocturnalSleepingGoal(AbstractSleepingAnimal sleeper) {
        super();
        this.entity = sleeper;
    }

    @Override
    public boolean canUse() {
        Level world = entity.level();
        for(Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
            if (!player.isShiftKeyDown()) return false;
        }
        return (world.getDayTime() % 24000 >= 0 && world.getDayTime() % 24000 <= 12000 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava());
    }

    @Override
    public boolean canContinueToUse() {
        Level world = entity.level();
        for(Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
            if (player.isShiftKeyDown()) {
                if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || !super.canContinueToUse() || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
                    stop();
                    return false;
                } else return true;
            } else {
                stop();
                return false;
            }
        }
        if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || !super.canContinueToUse() || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
            stop();
            return false;
        } else return true;
    }

    @Override
    public void start() {
        entity.setAsleep(true);
        entity.xxa = 0.0F;
        entity.yya = 0.0F;
        entity.zza = 0.0F;
        entity.getNavigation().stop();;
    }

    public void tick() {
        super.tick();
        Level world = entity.level();
        for(Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
            if (!player.isShiftKeyDown()) {
                stop();
            }
        }
        if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
            stop();
        }
    }

    @Override
    public void stop() {
        entity.setAwakeTicks(100);
        entity.setAsleep(false);
    }



}
