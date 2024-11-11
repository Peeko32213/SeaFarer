package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.goal.BottomWalkerFindWaterGoal;
import com.peeko32213.seafarer.common.entity.goal.BottomWalkerPathfinder;
import com.peeko32213.seafarer.common.entity.goal.BottomWalkingGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
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

public class EntitySexyShrimp extends WaterAnimal implements GeoAnimatable {

    private static final RawAnimation MOVE = RawAnimation.begin().thenLoop("animation.sexy_shrimp.hop");
    private static final RawAnimation DANCE = RawAnimation.begin().thenLoop("animation.sexy_shrimp.dance");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public EntitySexyShrimp(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new BottomWalkerFindWaterGoal(this));
        this.goalSelector.addGoal(5, new BottomWalkingGoal(this, 1.0D, 10, 50));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));

    }

    protected PathNavigation createNavigation(Level worldIn) {
        BottomWalkerPathfinder crab = new BottomWalkerPathfinder(this, worldIn) {
            public boolean isStableDestination(BlockPos pos) {
                return this.level.getBlockState(pos).getFluidState().isEmpty();
            }
        };
        return crab;
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.4D));
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.08D, 0.0D));
        } else {
            super.travel(travelVector);
        }

    }

    protected <E extends EntitySexyShrimp> PlayState controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F)) {
            event.setAndContinue(MOVE);
        } else {
            event.setAndContinue(DANCE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::controller));
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
