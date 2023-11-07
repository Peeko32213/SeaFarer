package com.peeko32213.seafarer.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class EntityHorseshoeCrab extends Animal implements GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation HORSESHOE_CRAB_WALK = RawAnimation.begin().thenLoop("animation.horseshoecrab.walk");
    private static final RawAnimation HORSESHOE_CRAB_IDLE = RawAnimation.begin().thenLoop("animation.horseshoecrab.idle");
    private static final RawAnimation HORSESHOE_CRAB_BURROW = RawAnimation.begin().thenLoop("animation.horseshoecrab.burrow");
    private static final RawAnimation HORSESHOE_CRAB_BURROW_IDLE = RawAnimation.begin().thenLoop("animation.horseshoecrab.idle_burrow");

    private static final EntityDataAccessor<Boolean> BURROWED = SynchedEntityData.defineId(EntityHorseshoeCrab.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DISTURBED = SynchedEntityData.defineId(EntityHorseshoeCrab.class, EntityDataSerializers.BOOLEAN);
    public float burrowProgress;
    public float prevBurrowProgress;
    private int burrowCooldown = 0;

    public EntityHorseshoeCrab(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.13D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 10.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 5.5D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new BurrowGoal(EntityHorseshoeCrab.this));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public boolean isBurrowed() {
        return this.entityData.get(BURROWED);
    }

    public void setBurrowed(boolean burrowed) {
        this.entityData.set(BURROWED, Boolean.valueOf(burrowed));
    }

    public boolean isDisturbed() {
        return this.entityData.get(DISTURBED);
    }

    public void setDisturbed(boolean burrowed) {
        this.entityData.set(DISTURBED, Boolean.valueOf(burrowed));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BURROWED, false);
        this.entityData.define(DISTURBED, false);
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("isBurrowed", this.isBurrowed());
        pCompound.putBoolean("isDisturbed", this.isDisturbed());
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setBurrowed(pCompound.getBoolean("isBurrowed"));
        this.setDisturbed(pCompound.getBoolean("isDisturbed"));
    }


    public void tick() {
        super.tick();
        prevBurrowProgress = burrowProgress;

        if (this.isBurrowed()) {
            if (burrowProgress < 5F)
                burrowProgress++;
        } else {
            if (burrowProgress > 0F)
                burrowProgress--;
        }

        if (this.burrowCooldown > 0) {
            this.burrowCooldown--;
        }
    }

    public boolean hurt(DamageSource source, float amount) {
        boolean prev = super.hurt(source, amount);
        if (prev && source.getDirectEntity() instanceof LivingEntity) {
            this.setBurrowed(false);
        }
        return prev;
    }

    public boolean isSleeping() {
        return this.isBurrowed();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        InteractionResult type = super.mobInteract(player, hand);
        if (item instanceof ShovelItem && (this.isBurrowed() || !this.isDisturbed()) && !this.level().isClientSide) {
            this.ambientSoundTime = 1000;
            if (!player.isCreative()) {
                itemstack.hurt(1, this.getRandom(), player instanceof ServerPlayer ? (ServerPlayer) player : null);
            }
            this.setBurrowed(false);
            this.setDisturbed(true);
            this.burrowCooldown += 150 + random.nextInt(120);
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.SAND_BREAK, this.getSoundVolume(), this.getVoicePitch());
            return InteractionResult.SUCCESS;
        }
        return type;
    }

    public void travel(Vec3 travelVector) {
        if (this.isBurrowed() && this.level().isDay() && !this.level().isNight()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            travelVector = Vec3.ZERO;
            super.travel(travelVector);
            return;
        }
        if (this.isEffectiveAi() && this.isInWater() && !this.level().isNight()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null && !this.level().isNight()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }

    }

    private class BurrowGoal extends Goal {
        private BlockPos sand = null;
        private int burrowedTime = 0;
        private final Level level;

        public BurrowGoal(PathfinderMob pMob) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            this.level = pMob.level();
        }

        @Override
        public boolean canUse() {
            if (!EntityHorseshoeCrab.this.isBurrowed() && EntityHorseshoeCrab.this.burrowCooldown == 0 && this.level.isDay()) {
                this.burrowedTime = 0;
                sand = findSand();
                return sand != null;
            }
            return false;
        }



        @Override
        public boolean canContinueToUse() {
            this.level.isNight();
            return false;
        }

        public BlockPos findSand() {
            BlockPos blockpos = null;

            for (BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(EntityHorseshoeCrab.this.getX() - 4.0D), Mth.floor(EntityHorseshoeCrab.this.getY() - 1.0D), Mth.floor(EntityHorseshoeCrab.this.getZ() - 4.0D), Mth.floor(EntityHorseshoeCrab.this.getX() + 4.0D), EntityHorseshoeCrab.this.getBlockY(), Mth.floor(EntityHorseshoeCrab.this.getZ() + 4.0D))) {
                if (EntityHorseshoeCrab.this.level().getBlockState(blockpos1).is(BlockTags.SAND)) {
                    blockpos = blockpos1;
                    break;
                }
            }
            return blockpos;
        }

        public void tick() {
            if (EntityHorseshoeCrab.this.isBurrowed() && this.level.isDay()) {
                burrowedTime++;
                if (!EntityHorseshoeCrab.this.getBlockStateOn().is(BlockTags.SAND)) {
                    EntityHorseshoeCrab.this.setBurrowed(false);
                }
            } else if (sand != null && this.level.isDay()) {
                EntityHorseshoeCrab.this.getNavigation().moveTo(sand.getX() + 0.5F, sand.getY() + 1F, sand.getZ() + 0.5F, 1F);
                if (EntityHorseshoeCrab.this.getBlockStateOn().is(BlockTags.SAND)) {
                    EntityHorseshoeCrab.this.setBurrowed(true);
                    EntityHorseshoeCrab.this.getNavigation().stop();
                    sand = null;
                } else if (this.level.isNight()) {
                    burrowedTime--;
                    EntityHorseshoeCrab.this.setBurrowed(false);
                }
            }
        }

        public void stop() {
            if (this.level.isNight()) {
                EntityHorseshoeCrab.this.setBurrowed(false);
                EntityHorseshoeCrab.this.burrowCooldown = 120 + random.nextInt(1200);
                this.sand = null;
            }
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    public void aiStep() {
        super.aiStep();
    }

    protected <E extends EntityHorseshoeCrab> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F && !this.isBurrowed())) {
            event.setAndContinue(HORSESHOE_CRAB_WALK);
            return PlayState.CONTINUE;
        }
        if (!this.isBurrowed()) {
            event.setAndContinue(HORSESHOE_CRAB_IDLE);
        }
        return PlayState.CONTINUE;
    }



    protected <E extends EntityHorseshoeCrab> PlayState digController(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (this.burrowCooldown > 0) {
            event.setAndContinue(HORSESHOE_CRAB_BURROW);
        }
        if (this.isBurrowed() && this.level().isDay()){
            event.setAndContinue(HORSESHOE_CRAB_BURROW_IDLE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
        controllers.add(new AnimationController<>(this, "Dig", 5, this::digController));
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
