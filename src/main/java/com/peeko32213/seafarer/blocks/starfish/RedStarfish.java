package com.peeko32213.seafarer.blocks.starfish;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedStarfish extends StarfishBlock {

    public RedStarfish(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        components.add(Component.translatable("seafarer.red_starfish").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
    }

}
