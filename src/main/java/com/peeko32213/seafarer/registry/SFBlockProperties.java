package com.peeko32213.seafarer.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class SFBlockProperties {

    public static BlockBehaviour.Properties seaGlass(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.AMETHYST).noOcclusion().isValidSpawn(SFBlockProperties::neverEntity).isRedstoneConductor(SFBlockProperties::never).isSuffocating(SFBlockProperties::never).isViewBlocking(SFBlockProperties::never);
    }

    public static BlockBehaviour.Properties seaGlassSolid(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.4F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST);
    }

    public static BlockBehaviour.Properties seaGlassLamp(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.4F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(state -> 15);
    }

    public static BlockBehaviour.Properties seaGlassPebbles(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.3F).requiresCorrectToolForDrops().noCollission().noOcclusion().sound(SoundType.AMETHYST).pushReaction(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties seaGlassBottle(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.4F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.AMETHYST).pushReaction(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties starfish(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).strength(0.4F).sound(SoundType.CORAL_BLOCK).instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    public static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    public static boolean neverEntity(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return false;
    }
}
