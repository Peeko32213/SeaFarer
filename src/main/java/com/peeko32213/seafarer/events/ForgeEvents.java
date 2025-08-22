package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.utils.AsyncLocator;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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

    public static HitResult calculateHitResult(LivingEntity entity) {
        return ProjectileUtil.getHitResultOnViewVector(entity, (entity1) -> !entity1.isSpectator() && entity1.isPickable(), MAX_BRUSH_DISTANCE);
    }
}
