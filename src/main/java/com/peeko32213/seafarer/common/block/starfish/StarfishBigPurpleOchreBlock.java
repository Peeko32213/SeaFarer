package com.peeko32213.seafarer.common.block.starfish;

import com.peeko32213.seafarer.common.block.SFWallBlock;
import com.peeko32213.seafarer.common.block.SFWetFloorLayerBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StarfishBigPurpleOchreBlock extends SFWetFloorLayerBlock {

    public StarfishBigPurpleOchreBlock(Properties pProperties) {
        super(pProperties);
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        //pTooltipComponents.clear();
        MutableComponent mutableComponent = Component.translatable("seafarer.starfish_big_purple_ochre").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC);
        MutableComponent mutableComponent2 = Component.literal("");
        pTooltipComponents.add(mutableComponent);
        pTooltipComponents.add(mutableComponent2);
    }

}
