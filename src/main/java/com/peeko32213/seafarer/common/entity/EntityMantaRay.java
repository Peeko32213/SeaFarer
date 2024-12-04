package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.misc.goal.MantaJumpGoal;
import com.peeko32213.seafarer.common.entity.misc.navigator.AquaticJumperNavigation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityMantaRay extends WaterAnimal implements GeoAnimatable {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation MANTA_SWIM = RawAnimation.begin().thenLoop("animation.manta_ray.swim");
    private static final RawAnimation MANTA_BEACHED = RawAnimation.begin().thenLoop("animation.manta_ray.beached");

    public EntityMantaRay(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.moveControl = new SmoothSwimmingMoveControl(this, 50, 1, 0.02F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 4);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.8D, 1));
        this.goalSelector.addGoal(5, new MantaJumpGoal(this, 10));
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }


    public void tick() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(0,0,0);
            this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4F, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.setOnGround(false);
            this.hasImpulse = true;
            this.playSound(SoundEvents.COD_FLOP, this.getSoundVolume(), this.getVoicePitch());
            //use this stuff for fish flopping
        }
        super.tick();
    }

    protected <E extends EntityMantaRay> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (isInWater()) {
            event.setAndContinue(MANTA_SWIM);
            event.getController().setAnimationSpeed(1.0F);
        }
        else {
            event.setAndContinue(MANTA_BEACHED);
            event.getController().setAnimationSpeed(1.0F);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object o) {
        return tickCount;
    }

}
