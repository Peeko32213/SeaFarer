package com.peeko32213.seafarer.worldgen.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.registry.SeaStructurePieces;
import com.peeko32213.seafarer.registry.SeaStructureTypes;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

public class VolcanoStructure extends Structure {

    public static final Codec<VolcanoStructure> CODEC = RecordCodecBuilder.create(instance -> instance.group(VolcanoStructure.settingsCodec(instance),
            IntProvider.NON_NEGATIVE_CODEC.fieldOf("height").forGetter(arg -> arg.height),
            Codec.INT.fieldOf("base_y").forGetter(arg -> arg.baseY),
            Codec.BOOL.fieldOf("thin_if_tall").forGetter(arg -> arg.thinIfTall)
    ).apply(instance, VolcanoStructure::new));

    public final IntProvider height;
    public final int baseY;
    public final boolean thinIfTall;

    public VolcanoStructure(StructureSettings settings, IntProvider height, int baseY, boolean thinIfTall) {
        super(settings);
        this.height = height;
        this.baseY = baseY;
        this.thinIfTall = thinIfTall;
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        int x = context.chunkPos().getMiddleBlockX();
        int z = context.chunkPos().getMiddleBlockZ();
        int y = context.chunkGenerator().getBaseHeight(x, z, Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor(), context.randomState());

        return Optional.of(new GenerationStub(new BlockPos(x + 8, y, z), builder -> this.addPieces(builder, context)));
    }

    private void addPieces(StructurePiecesBuilder collector, GenerationContext context) {
        collector.addPiece(new VolcanoStructurePiece(context.random(), context.chunkPos().getMiddleBlockX(), context.chunkPos().getMiddleBlockZ(), height, baseY, thinIfTall));
    }

    @Override
    public StructureType<?> type() {
        return SeaStructureTypes.VOLCANO.get();
    }
}