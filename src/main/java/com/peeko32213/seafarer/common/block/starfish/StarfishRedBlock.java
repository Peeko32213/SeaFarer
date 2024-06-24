package com.peeko32213.seafarer.common.block.starfish;

import com.peeko32213.seafarer.common.block.SFWallBlock;
import com.peeko32213.seafarer.common.block.SFWetFloorLayerBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StarfishRedBlock extends SFWetFloorLayerBlock {

    public StarfishRedBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        components.add(Component.translatable("seafarer.starfish_red").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }

}
