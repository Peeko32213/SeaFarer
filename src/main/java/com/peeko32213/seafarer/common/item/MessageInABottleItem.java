package com.peeko32213.seafarer.common.item;

import com.peeko32213.seafarer.common.util.AsyncLocator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

public class MessageInABottleItem extends Item {
    public static final Logger LOGGER = LogManager.getLogger();
    private final TagKey<Structure> destination;
    private final String displayName;
    private final MapDecoration.Type destinationType;
    public MessageInABottleItem(TagKey<Structure> destination, String displayName, MapDecoration.Type destinationType, Properties pProperties) {
        super(pProperties);
        this.destination = destination;
        this.displayName = displayName;
        this.destinationType = destinationType;

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (level instanceof ServerLevel serverlevel) {
            boolean findUnexplored = false;
            var async = AsyncLocator.locate(serverlevel,
                    destination, pPlayer.blockPosition(), 50, findUnexplored);
            async.thenOnServerThread(pair -> {
                BlockPos blockpos = pair;
                if (blockpos == null) {
                    pPlayer.displayClientMessage(Component.translatable("seafarer.message.structure_not_found"), false);
                } else {
                    ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                    MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                    MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", this.destinationType);
                    itemstack.setHoverName(Component.translatable(this.displayName));
                    ItemStack itemstack2 = ItemUtils.createFilledResult(stack, pPlayer, itemstack);
                    ItemStack bottleStack = Items.GLASS_BOTTLE.getDefaultInstance();
                    findEmptySlotAndPlaceItem(pPlayer, bottleStack);
                    pPlayer.getCooldowns().addCooldown(this, 100);
                }
            });
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.fail(stack);
    }

    private void findEmptySlotAndPlaceItem(Player player, ItemStack stack) {
        player.getInventory().add(stack);
    }
}
