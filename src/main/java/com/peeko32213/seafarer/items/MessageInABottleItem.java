package com.peeko32213.seafarer.items;

import com.peeko32213.seafarer.utils.AsyncLocator;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
            if(!pPlayer.isCreative()) {
                ItemStack bottleStack = Items.GLASS_BOTTLE.getDefaultInstance();
                ItemStack itemstack2 = ItemUtils.createFilledResult(stack, pPlayer, bottleStack);
            }
            serverlevel.playSound(null, pPlayer.blockPosition(), SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS, 1, 1);
            boolean findUnexplored = false;
            pPlayer.getCooldowns().addCooldown(this, 4800);
            var async = AsyncLocator.locate(serverlevel, destination, pPlayer.blockPosition(), 50, findUnexplored);
            async.thenOnServerThread(pair -> {
                BlockPos blockpos = pair;
                if (blockpos == null) {
                    pPlayer.displayClientMessage(Component.translatable("seafarer.message.structure_not_found"), false);
                    serverlevel.playSound(null, pPlayer.blockPosition(), SoundEvents.WAXED_SIGN_INTERACT_FAIL, SoundSource.PLAYERS, 1, 1);
                } else {
                    ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                    MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                    MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", this.destinationType);
                    itemstack.setHoverName(Component.translatable(this.displayName));
                    findEmptySlotAndPlaceItem(pPlayer, itemstack);
                    serverlevel.playSound(null, pPlayer.blockPosition(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1, 1);
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
