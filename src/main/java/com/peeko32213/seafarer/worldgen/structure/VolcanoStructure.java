package com.peeko32213.seafarer.worldgen.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.registry.SeaStructureTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class VolcanoStructure extends Structure {

    public static final Codec<VolcanoStructure> CODEC = RecordCodecBuilder.create(volcano -> volcano.group(
            settingsCodec(volcano),
            HeightProvider.CODEC.fieldOf("y_level").forGetter(volcanoStructure -> volcanoStructure.y_level),
            IntProvider.CODEC.fieldOf("radius").forGetter(volcanoStructure -> volcanoStructure.radius)
    ).apply(volcano, VolcanoStructure::new));

    private final HeightProvider y_level;
    private final IntProvider radius;

    public VolcanoStructure(StructureSettings settings, HeightProvider y_level, IntProvider radius) {
        super(settings);
        this.y_level = y_level;
        this.radius = radius;
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        WorldgenRandom random = context.random();
        int y_level = this.y_level.sample(random, new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
        int radiusX = this.radius.sample(random);
        int radiusZ = this.radius.sample(random);
        long noiseSeed = random.nextLong();

        BlockPos pos = new BlockPos(chunkPos.getMinBlockX() + 8, y_level, chunkPos.getMinBlockZ() + 8);
        return Optional.of(new GenerationStub(pos, builder -> builder.addPiece(new VolcanoStructurePiece(context.heightAccessor(), pos, radiusX, radiusZ, noiseSeed))));
    }

    @Override
    public StructureType<?> type() {
        return SeaStructureTypes.VOLCANO.get();
    }
}