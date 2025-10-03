package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.worldgen.structure.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerStructurePieces {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECES = DeferredRegister.create(Registries.STRUCTURE_PIECE, Seafarer.MOD_ID);

    public static final RegistryObject<StructurePieceType> VOLCANO = STRUCTURE_PIECES.register("volcano", () -> VolcanoStructurePiece::new);
}
