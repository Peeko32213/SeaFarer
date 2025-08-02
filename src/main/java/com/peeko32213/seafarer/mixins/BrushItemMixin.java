package com.peeko32213.seafarer.mixins;

import com.peeko32213.seafarer.entities.interfaces.Brushable;
import com.peeko32213.seafarer.events.BrushingEvent;
import com.peeko32213.seafarer.events.ForgeEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BrushItem.class)
public class BrushItemMixin extends Item {
    public BrushItemMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pPlayer != null && ForgeEvents.calculateHitResult(pPlayer).getType() == HitResult.Type.ENTITY) {
            pPlayer.startUsingItem(pUsedHand);
        }
        return InteractionResult.CONSUME;
    }

    @Inject(method = "onUseTick", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/phys/BlockHitResult;getBlockPos()Lnet/minecraft/core/BlockPos;"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void seafarer$injectBlockBrushEvent(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration, CallbackInfo ci, Player player, HitResult hitresult, BlockHitResult blockhitresult, int i, boolean flag) {
        BlockPos blockpos = blockhitresult.getBlockPos();
        BrushingEvent.Block brushingEvent = new BrushingEvent.Block(pLevel, pStack, player, blockhitresult, blockpos);
        MinecraftForge.EVENT_BUS.post(brushingEvent);
    }

    @Inject(method = "onUseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;releaseUsingItem()V"), locals = LocalCapture.CAPTURE_FAILEXCEPTION, cancellable = true)
    private void seafarer$injectEntityBrushEventAndBrushable(Level level, LivingEntity pLivingEntity, ItemStack stack, int pRemainingUseDuration, CallbackInfo ci) {
        if (pLivingEntity instanceof Player player) {
            HitResult hitresult = ForgeEvents.calculateHitResult(player);
            if (hitresult instanceof EntityHitResult entityHitResult) {
                if (hitresult.getType() == HitResult.Type.ENTITY) {
                    net.minecraft.world.entity.Entity targetEntity = entityHitResult.getEntity();
                    if (targetEntity instanceof Brushable brushable) {
                        brushable.startBrusing();
                        int i = stack.getUseDuration() - pRemainingUseDuration + 1;
                        boolean flag = i % 10 == 5;
                        if (flag) {
                            BlockPos pos = targetEntity.blockPosition();

                            BrushingEvent.Entity brushingEvent = new BrushingEvent.Entity(level, stack, player, entityHitResult, targetEntity, pos);
                            MinecraftForge.EVENT_BUS.post(brushingEvent);
                            if (!brushingEvent.isCanceled()) {
                                if (brushable.isBrushable(player, stack, level, pos)) {
                                    if (brushable.brushSound() != null) {
                                        level.playSound(null, pos, brushable.brushSound(), player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS);
                                    }
                                    java.util.List<ItemStack> drops = brushable.brush(level.getGameTime(), player, entityHitResult.getEntity().getDirection(), stack, targetEntity.level(), pos,
                                            net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE, stack));
                                    java.util.Random rand = new java.util.Random();
                                    drops.forEach(d -> {
                                        net.minecraft.world.entity.item.ItemEntity ent = targetEntity.spawnAtLocation(d, 1.0F);
                                        ent.setDeltaMovement(ent.getDeltaMovement().add((double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double) (rand.nextFloat() * 0.05F), (double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
                                    });
                                    stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.getUsedItemHand()));
                                    brushable.endBrushing();
                                }
                            }
                        }
                    }
                }
                ci.cancel();
            }
        }
    }
}
