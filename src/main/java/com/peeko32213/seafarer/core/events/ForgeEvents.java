package com.peeko32213.seafarer.core.events;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.block.entity.SFNetBlockEntity;
import com.peeko32213.seafarer.common.util.AsyncLocator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(modid = SeaFarer.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    private static final double MAX_BRUSH_DISTANCE = Math.sqrt(ServerGamePacketListenerImpl.MAX_INTERACTION_DISTANCE) - 1.0D;
    @SubscribeEvent
    public static void serverAboutToStart(final ServerAboutToStartEvent event) {
        AsyncLocator.handleServerAboutToStartEvent();
    }

    @SubscribeEvent
    public static void onServerStopping(final ServerStoppingEvent event) {
        AsyncLocator.handleServerStoppingEvent();
    }

    @SubscribeEvent
    public static void brushBlockOrEntity(LivingEntityUseItemEvent.Tick event) {
        if (event.getItem().is(Items.BRUSH)) {
            int duration = event.getDuration();
            ItemStack stack = event.getItem();
            LivingEntity entity = event.getEntity();
            Level level = event.getEntity().level();
            if (duration >= 0 && entity instanceof Player player) {
                HitResult hitresult = calculateHitResult(player);
                if (hitresult instanceof BlockHitResult blockhitresult) {
                    if (hitresult.getType() == HitResult.Type.BLOCK) {
                        int i = stack.getUseDuration() - duration + 1;
                        boolean flag = i % 10 == 5;
                        if (flag) {
                            BlockPos blockpos = blockhitresult.getBlockPos();
                            BrushingEvent.Block brushingEvent = new BrushingEvent.Block(level, stack, player, blockhitresult, blockpos);
                            MinecraftForge.EVENT_BUS.post(brushingEvent);
                            //if (!brushingEvent.isCanceled()) {
                            //    BlockState blockstate = level.getBlockState(blockpos);
                            //    addCustomBlockBrushHandling(level, stack, blockstate, player, blockhitresult, blockpos);
                            //}
                        }
                    }
                }

                if (hitresult instanceof EntityHitResult entityHitResult) {
                    if (hitresult.getType() == HitResult.Type.ENTITY) {
                        int i = stack.getUseDuration() - duration + 1;
                        boolean flag = i % 10 == 5;
                        if (flag) {
                            net.minecraft.world.entity.Entity targetEntity = entityHitResult.getEntity();
                            BlockPos pos = targetEntity.blockPosition();
                            BrushingEvent.Entity brushingEvent = new BrushingEvent.Entity(level, stack, player, entityHitResult, targetEntity, pos);
                            MinecraftForge.EVENT_BUS.post(brushingEvent);
                            //if (!brushingEvent.isCanceled()) {
                            //    addCustomEntityBrushHandling(level, stack, player, entityHitResult, pos);
                            //}
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void brushSaltFromBlock(BrushingEvent.Block event) {
        spawnParticles(null, event.getLevel(), event.getBlockHitResult(), event.getBlockState(), event.getVec(), event.getArm());
        Block block = event.getBlockState().getBlock();
        Level level = event.getLevel();
        BlockPos blockpos = event.getPos();
        Player player = event.getPlayer();
        BlockHitResult result = event.getBlockHitResult();
        SoundEvent soundevent = event.getSoundEvent();
        ItemStack stack = event.getItem();

        event.getLevel().playSound(event.getPlayer(), event.getPos(), soundevent, SoundSource.BLOCKS);
        if (!level.isClientSide()) {
            BlockEntity blockentity = level.getBlockEntity(blockpos);
            if (blockentity instanceof SFNetBlockEntity) {
                SFNetBlockEntity netBlockEntity = (SFNetBlockEntity) blockentity;
                boolean flag1 = netBlockEntity.brush(level.getGameTime(), player, result.getDirection());
                if (flag1) {
                    EquipmentSlot equipmentslot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                    stack.hurtAndBreak(1, player, (p_279044_) -> {
                        p_279044_.broadcastBreakEvent(equipmentslot);
                    });
                }
            }
        }

    }


    private static void spawnEntityParticles(@Nullable ParticleOptions options, Level level, EntityHitResult hitResult, Vec3 vec, HumanoidArm arm) {
        double d0 = 3.0D;
        int i = arm == HumanoidArm.RIGHT ? 1 : -1;
        int j = level.getRandom().nextInt(7, 12);
        ParticleOptions blockparticleoption = options == null ? ParticleTypes.BUBBLE : options;
        Direction direction = hitResult.getEntity().getDirection();
        ForgeEvents.DustParticlesDelta brushitem$dustparticlesdelta = ForgeEvents.DustParticlesDelta.fromDirection(vec, direction);
        Vec3 vec3 = hitResult.getLocation();

        for(int k = 0; k < j; ++k) {
            level.addParticle(blockparticleoption, vec3.x - (double)(direction == Direction.WEST ? 1.0E-6F : 0.0F), vec3.y, vec3.z - (double)(direction == Direction.NORTH ? 1.0E-6F : 0.0F), brushitem$dustparticlesdelta.xd() * (double)i * 3.0D * level.getRandom().nextDouble(), 0.0D, brushitem$dustparticlesdelta.zd() * (double)i * 3.0D * level.getRandom().nextDouble());
        }

    }


    private static void spawnParticles(@Nullable ParticleOptions options, Level level, BlockHitResult hitResult, BlockState state, Vec3 vec, HumanoidArm arm) {
        double d0 = 3.0D;
        int i = arm == HumanoidArm.RIGHT ? 1 : -1;
        int j = level.getRandom().nextInt(7, 12);
        ParticleOptions blockparticleoption = options == null ? new BlockParticleOption(ParticleTypes.BLOCK, state) : options;
        Direction direction = hitResult.getDirection();
        ForgeEvents.DustParticlesDelta brushitem$dustparticlesdelta = ForgeEvents.DustParticlesDelta.fromDirection(vec, direction);
        Vec3 vec3 = hitResult.getLocation();

        for(int k = 0; k < j; ++k) {
            level.addParticle(blockparticleoption, vec3.x - (double)(direction == Direction.WEST ? 1.0E-6F : 0.0F), vec3.y, vec3.z - (double)(direction == Direction.NORTH ? 1.0E-6F : 0.0F), brushitem$dustparticlesdelta.xd() * (double)i * 3.0D * level.getRandom().nextDouble(), 0.0D, brushitem$dustparticlesdelta.zd() * (double)i * 3.0D * level.getRandom().nextDouble());
        }

    }




    private static HitResult calculateHitResult(LivingEntity entity) {
        return ProjectileUtil.getHitResultOnViewVector(entity, (p_281111_) -> {
            return !p_281111_.isSpectator() && p_281111_.isPickable();
        }, MAX_BRUSH_DISTANCE);
    }



    record DustParticlesDelta(double xd, double yd, double zd) {
        private static final double ALONG_SIDE_DELTA = 1.0D;
        private static final double OUT_FROM_SIDE_DELTA = 0.1D;

        public static ForgeEvents.DustParticlesDelta fromDirection(Vec3 p_273421_, Direction p_272987_) {
            double d0 = 0.0D;
            ForgeEvents.DustParticlesDelta brushitem$dustparticlesdelta;
            switch (p_272987_) {
                case DOWN:
                case UP:
                    brushitem$dustparticlesdelta = new ForgeEvents.DustParticlesDelta(p_273421_.z(), 0.0D, -p_273421_.x());
                    break;
                case NORTH:
                    brushitem$dustparticlesdelta = new ForgeEvents.DustParticlesDelta(1.0D, 0.0D, -0.1D);
                    break;
                case SOUTH:
                    brushitem$dustparticlesdelta = new ForgeEvents.DustParticlesDelta(-1.0D, 0.0D, 0.1D);
                    break;
                case WEST:
                    brushitem$dustparticlesdelta = new ForgeEvents.DustParticlesDelta(-0.1D, 0.0D, -1.0D);
                    break;
                case EAST:
                    brushitem$dustparticlesdelta = new ForgeEvents.DustParticlesDelta(0.1D, 0.0D, 1.0D);
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return brushitem$dustparticlesdelta;
        }
    }
}
