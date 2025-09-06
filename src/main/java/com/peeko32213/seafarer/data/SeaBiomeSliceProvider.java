package com.peeko32213.seafarer.data;

import com.mojang.datafixers.util.Pair;
import com.peeko32213.seafarer.Seafarer;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSlice;
import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import com.teamabnormals.blueprint.core.util.BiomeUtil.*;
import net.minecraft.SharedConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeaBiomeSliceProvider {

    public static final ResourceKey<ModdedBiomeSlice> WARM_REEF = createKey("warm_reef");
    public static final ResourceKey<ModdedBiomeSlice> FLOWERING_BEACH = createKey("flowering_beach");
    public static final ResourceKey<ModdedBiomeSlice> GRASSY_BEACH = createKey("grassy_beach");
    public static final ResourceKey<ModdedBiomeSlice> GLASS_BEACH = createKey("glass_beach");

    public static final ResourceKey<ModdedBiomeSlice> CORAL_BEACH = createKey("coral_beach");
    public static final ResourceKey<Biome> CORAL_BEACH_AREA = SeaBiomeProvider.createKey("coral_beach_area");

    public static void bootstrap(BootstapContext<ModdedBiomeSlice> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> entries = new ArrayList<>();
        new SeafarerBiomeBuilder().addBiomes(entries::add);

        context.register(WARM_REEF, new ModdedBiomeSlice(40,
                new OverlayModdedBiomeProvider(List.of(
                        Pair.of(HolderSet.direct(Stream.of(Biomes.WARM_OCEAN).map(biomes::getOrThrow)
                                .collect(Collectors.toList())), new FixedBiomeSource(Holder.direct(biomes.getOrThrow(SeaBiomeProvider.WARM_REEF)).get()))
                )), LevelStem.OVERWORLD)
        );

        context.register(FLOWERING_BEACH, new ModdedBiomeSlice(8,
                new OverlayModdedBiomeProvider(List.of(
                        Pair.of(HolderSet.direct(Stream.of(Biomes.BEACH).map(biomes::getOrThrow)
                                .collect(Collectors.toList())), new FixedBiomeSource(Holder.direct(biomes.getOrThrow(SeaBiomeProvider.FLOWERING_BEACH)).get()))
                )), LevelStem.OVERWORLD)
        );

        context.register(GRASSY_BEACH, new ModdedBiomeSlice(15,
                new OverlayModdedBiomeProvider(List.of(
                        Pair.of(HolderSet.direct(Stream.of(Biomes.BEACH).map(biomes::getOrThrow)
                                .collect(Collectors.toList())), new FixedBiomeSource(Holder.direct(biomes.getOrThrow(SeaBiomeProvider.GRASSY_BEACH)).get()))
                )), LevelStem.OVERWORLD)
        );

        context.register(GLASS_BEACH, new ModdedBiomeSlice(3,
                new OverlayModdedBiomeProvider(List.of(
                        Pair.of(HolderSet.direct(Stream.of(Biomes.BEACH).map(biomes::getOrThrow)
                                .collect(Collectors.toList())), new FixedBiomeSource(Holder.direct(biomes.getOrThrow(SeaBiomeProvider.GLASS_BEACH)).get()))
                )), LevelStem.OVERWORLD)
        );

        context.register(CORAL_BEACH, new ModdedBiomeSlice(25, MultiNoiseModdedBiomeProvider.builder().biomes(entries::forEach)
                .area(CORAL_BEACH_AREA, SeaBiomeProvider.CORAL_BEACH)
                .build(), LevelStem.OVERWORLD)
        );
    }

    private static ResourceKey<ModdedBiomeSlice> createKey(String name) {
        return ResourceKey.create(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    // Modified version of OverworldBiomeBuilder to simplify slice
    @SuppressWarnings("unchecked")
    private static final class SeafarerBiomeBuilder {

        private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
        private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
        private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
        private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
        private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
        private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
        private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
        private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
        private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
        private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
        private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
        private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
        private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
        private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
        private final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER;
        private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][] {
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}
        };
        private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][] {
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}
        };
        private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][] {
                {VANILLA, null, VANILLA, null, null},
                {null, null, null, null, VANILLA},
                {VANILLA, null, null, VANILLA, null},
                {null, null, VANILLA, VANILLA, VANILLA},
                {null, null, null, null, null}
        };
        private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][] {
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}
        };
        private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][] {
                {VANILLA, null, null, null, null},
                {VANILLA, null, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, null},
                {null, null, null, null, null},
                {VANILLA, VANILLA, null, null, null}
        };
        private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][] {
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {null, null, null, null, null},
                {null, null, null, null, null}
        };

        public List<Climate.ParameterPoint> spawnTarget() {
            Climate.Parameter climate$parameter = Climate.Parameter.point(0.0F);
            float f = 0.16F;
            return List.of(new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, climate$parameter, Climate.Parameter.span(-1.0F, -0.16F), 0L), new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, climate$parameter, Climate.Parameter.span(0.16F, 1.0F), 0L));
        }

        private void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187176_) {
            if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
                this.addDebugBiomes(p_187176_);
            } else {
                this.addOffCoastBiomes(p_187176_);
                this.addInlandBiomes(p_187176_);
                this.addUndergroundBiomes(p_187176_);
            }
        }

        private void addDebugBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_256276_) {
            HolderLookup.Provider holderlookup$provider = VanillaRegistries.createLookup();
            HolderGetter<DensityFunction> holdergetter = holderlookup$provider.lookupOrThrow(Registries.DENSITY_FUNCTION);
            DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate = new DensityFunctions.Spline.Coordinate(holdergetter.getOrThrow(NoiseRouterData.CONTINENTS));
            DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate1 = new DensityFunctions.Spline.Coordinate(holdergetter.getOrThrow(NoiseRouterData.EROSION));
            DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate2 = new DensityFunctions.Spline.Coordinate(holdergetter.getOrThrow(NoiseRouterData.RIDGES_FOLDED));
            p_256276_.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.01F), VANILLA));
            CubicSpline<?, ?> cubicspline = TerrainProvider.buildErosionOffsetSpline(densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate2, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, -0.03F, false, false, ToFloatFunction.IDENTITY);
            if (cubicspline instanceof CubicSpline.Multipoint<?, ?> multipoint) {
                for(float f : multipoint.locations()) {
                    p_256276_.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f), Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), VANILLA));
                }
            }

            CubicSpline<?, ?> cubicspline1 = TerrainProvider.overworldOffset(densityfunctions$spline$coordinate, densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate2, false);
            if (cubicspline1 instanceof CubicSpline.Multipoint<?, ?> multipoint1) {
                for(float f1 : multipoint1.locations()) {
                    p_256276_.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f1), this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), VANILLA));
                }
            }

        }

        private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187196_) {
            this.addSurfaceBiome(p_187196_, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter climate$parameter = this.temperatures[i];
                this.addSurfaceBiome(p_187196_, climate$parameter, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][i]);
                this.addSurfaceBiome(p_187196_, climate$parameter, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][i]);
            }

        }

        private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187216_) {
            this.addMidSlice(p_187216_, Climate.Parameter.span(-1.0F, -0.93333334F));
            this.addHighSlice(p_187216_, Climate.Parameter.span(-0.93333334F, -0.7666667F));
            this.addPeaks(p_187216_, Climate.Parameter.span(-0.7666667F, -0.56666666F));
            this.addHighSlice(p_187216_, Climate.Parameter.span(-0.56666666F, -0.4F));
            this.addMidSlice(p_187216_, Climate.Parameter.span(-0.4F, -0.26666668F));
            this.addLowSlice(p_187216_, Climate.Parameter.span(-0.26666668F, -0.05F));
            this.addValleys(p_187216_, Climate.Parameter.span(-0.05F, 0.05F));
            this.addLowSlice(p_187216_, Climate.Parameter.span(0.05F, 0.26666668F));
            this.addMidSlice(p_187216_, Climate.Parameter.span(0.26666668F, 0.4F));
            this.addHighSlice(p_187216_, Climate.Parameter.span(0.4F, 0.56666666F));
            this.addPeaks(p_187216_, Climate.Parameter.span(0.56666666F, 0.7666667F));
            this.addHighSlice(p_187216_, Climate.Parameter.span(0.7666667F, 0.93333334F));
            this.addMidSlice(p_187216_, Climate.Parameter.span(0.93333334F, 1.0F));
        }

        private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biome, Climate.Parameter parameter) {
            for (int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter temperature = this.temperatures[i];

                for (int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter humidity = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                    ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, parameter, resourcekey4);
                    ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, parameter);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey2);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(biome, temperature, humidity, this.midInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey1);
                    this.addSurfaceBiome(biome, temperature, humidity, this.farInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey5);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey4);
                    this.addSurfaceBiome(biome, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, resourcekey);
                }
            }

        }

        private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187198_, Climate.Parameter p_187199_) {
            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter climate$parameter = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187199_);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187199_);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187199_);
                    ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, p_187199_);
                    ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, p_187199_);
                    ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, p_187199_, resourcekey);
                    ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, p_187199_);
                    ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, p_187199_);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187199_, 0.0F, resourcekey);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[0], p_187199_, 0.0F, resourcekey6);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], p_187199_, 0.0F, resourcekey7);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[1], p_187199_, 0.0F, resourcekey2);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], p_187199_, 0.0F, resourcekey6);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187199_, 0.0F, resourcekey);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], p_187199_, 0.0F, resourcekey3);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], p_187199_, 0.0F, resourcekey1);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], p_187199_, 0.0F, resourcekey3);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187199_, 0.0F, resourcekey);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], p_187199_, 0.0F, resourcekey5);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187199_, 0.0F, resourcekey4);
                    this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], p_187199_, 0.0F, resourcekey);
                }
            }

        }

        private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter climate$parameter = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
                    ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
                    ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
                    ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, weirdness);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey8);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[1], weirdness, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey1);
                    if (weirdness.max() < 0L) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[4], weirdness, 0.0F, resourcekey5);
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    } else {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    }

                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey7);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey3);
                    if (weirdness.max() < 0L) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey5);
                    } else {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey);
                    }

                    if (i == 0) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
                    }
                }
            }

        }

        private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter climate$parameter = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
                    ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
                    ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
                    ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, weirdness);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), weirdness, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey3);
                    if (i == 0) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
                    }
                }
            }

        }

        private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter climate$parameter = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
                }
            }

        }

        private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187227_) {
            this.addUndergroundBiome(p_187227_, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
            this.addUndergroundBiome(p_187227_, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
            this.addBottomBiome(p_187227_, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, VANILLA);
        }

        private ResourceKey<Biome> pickMiddleBiome(int p_187164_, int p_187165_, Climate.Parameter p_187166_) {
            if (p_187166_.max() < 0L) {
                return this.MIDDLE_BIOMES[p_187164_][p_187165_];
            } else {
                ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[p_187164_][p_187165_];
                return resourcekey == null ? this.MIDDLE_BIOMES[p_187164_][p_187165_] : resourcekey;
            }
        }

        private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int p_187192_, int p_187193_, Climate.Parameter p_187194_) {
            return p_187192_ == 4 ? this.pickBadlandsBiome(p_187193_, p_187194_) : this.pickMiddleBiome(p_187192_, p_187193_, p_187194_);
        }

        private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int p_187212_, int p_187213_, Climate.Parameter p_187214_) {
            return p_187212_ == 0 ? this.pickSlopeBiome(p_187212_, p_187213_, p_187214_) : this.pickMiddleBiomeOrBadlandsIfHot(p_187212_, p_187213_, p_187214_);
        }

        private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int p_201991_, int p_201992_, Climate.Parameter p_201993_, ResourceKey<Biome> p_201994_) {
            return p_201991_ > 1 && p_201992_ < 4 && p_201993_.max() >= 0L ? VANILLA : p_201994_;
        }

        private ResourceKey<Biome> pickShatteredCoastBiome(int p_187223_, int p_187224_, Climate.Parameter p_187225_) {
            ResourceKey<Biome> resourcekey = p_187225_.max() >= 0L ? this.pickMiddleBiome(p_187223_, p_187224_, p_187225_) : this.pickBeachBiome(p_187223_, p_187224_);
            return this.maybePickWindsweptSavannaBiome(p_187223_, p_187224_, p_187225_, resourcekey);
        }

        private ResourceKey<Biome> pickBeachBiome(int temperature, int humidity) {
            if (temperature == 0) {
                return VANILLA;
            } else if (temperature == 3) {
                return CORAL_BEACH_AREA;
            } else {
                return VANILLA;
            }
        }

        private ResourceKey<Biome> pickBadlandsBiome(int p_187173_, Climate.Parameter p_187174_) {
            if (p_187173_ < 2) {
                return VANILLA;
            } else {
                return VANILLA;
            }
        }

        private ResourceKey<Biome> pickPlateauBiome(int p_187234_, int p_187235_, Climate.Parameter p_187236_) {
            if (p_187236_.max() >= 0L) {
                ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[p_187234_][p_187235_];
                if (resourcekey != null) {
                    return resourcekey;
                }
            }

            return this.PLATEAU_BIOMES[p_187234_][p_187235_];
        }

        private ResourceKey<Biome> pickPeakBiome(int p_187241_, int p_187242_, Climate.Parameter p_187243_) {
            if (p_187241_ <= 2) {
                return VANILLA;
            } else {
                return p_187241_ == 3 ? VANILLA : this.pickBadlandsBiome(p_187242_, p_187243_);
            }
        }

        private ResourceKey<Biome> pickSlopeBiome(int p_187245_, int p_187246_, Climate.Parameter p_187247_) {
            if (p_187245_ >= 3) {
                return this.pickPlateauBiome(p_187245_, p_187246_, p_187247_);
            } else {
                return VANILLA;
            }
        }

        private ResourceKey<Biome> pickShatteredBiome(int p_202002_, int p_202003_, Climate.Parameter p_202004_) {
            ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[p_202002_][p_202003_];
            return resourcekey == null ? this.pickMiddleBiome(p_202002_, p_202003_, p_202004_) : resourcekey;
        }

        private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187181_, Climate.Parameter p_187182_, Climate.Parameter p_187183_, Climate.Parameter p_187184_, Climate.Parameter p_187185_, Climate.Parameter p_187186_, float p_187187_, ResourceKey<Biome> p_187188_) {
            p_187181_.accept(Pair.of(Climate.parameters(p_187182_, p_187183_, p_187184_, p_187185_, Climate.Parameter.point(0.0F), p_187186_, p_187187_), p_187188_));
            p_187181_.accept(Pair.of(Climate.parameters(p_187182_, p_187183_, p_187184_, p_187185_, Climate.Parameter.point(1.0F), p_187186_, p_187187_), p_187188_));
        }

        private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187201_, Climate.Parameter p_187202_, Climate.Parameter p_187203_, Climate.Parameter p_187204_, Climate.Parameter p_187205_, Climate.Parameter p_187206_, float p_187207_, ResourceKey<Biome> p_187208_) {
            p_187201_.accept(Pair.of(Climate.parameters(p_187202_, p_187203_, p_187204_, p_187205_, Climate.Parameter.span(0.2F, 0.9F), p_187206_, p_187207_), p_187208_));
        }

        private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_220669_, Climate.Parameter p_220670_, Climate.Parameter p_220671_, Climate.Parameter p_220672_, Climate.Parameter p_220673_, Climate.Parameter p_220674_, float p_220675_, ResourceKey<Biome> p_220676_) {
            p_220669_.accept(Pair.of(Climate.parameters(p_220670_, p_220671_, p_220672_, p_220673_, Climate.Parameter.point(1.1F), p_220674_, p_220675_), p_220676_));
        }

        public static boolean isDeepDarkRegion(DensityFunction p_252040_, DensityFunction p_250447_, DensityFunction.FunctionContext p_249270_) {
            return p_252040_.compute(p_249270_) < (double)-0.225F && p_250447_.compute(p_249270_) > (double)0.9F;
        }

        public static String getDebugStringForPeaksAndValleys(double p_187156_) {
            if (p_187156_ < (double)NoiseRouterData.peaksAndValleys(0.05F)) {
                return "Valley";
            } else if (p_187156_ < (double)NoiseRouterData.peaksAndValleys(0.26666668F)) {
                return "Low";
            } else if (p_187156_ < (double)NoiseRouterData.peaksAndValleys(0.4F)) {
                return "Mid";
            } else {
                return p_187156_ < (double)NoiseRouterData.peaksAndValleys(0.56666666F) ? "High" : "Peak";
            }
        }

        public String getDebugStringForContinentalness(double p_187190_) {
            double d0 = (double)Climate.quantizeCoord((float)p_187190_);
            if (d0 < (double)this.mushroomFieldsContinentalness.max()) {
                return "Mushroom fields";
            } else if (d0 < (double)this.deepOceanContinentalness.max()) {
                return "Deep ocean";
            } else if (d0 < (double)this.oceanContinentalness.max()) {
                return "Ocean";
            } else if (d0 < (double)this.coastContinentalness.max()) {
                return "Coast";
            } else if (d0 < (double)this.nearInlandContinentalness.max()) {
                return "Near inland";
            } else {
                return d0 < (double)this.midInlandContinentalness.max() ? "Mid inland" : "Far inland";
            }
        }

        public String getDebugStringForErosion(double p_187210_) {
            return getDebugStringForNoiseValue(p_187210_, this.erosions);
        }

        public String getDebugStringForTemperature(double p_187221_) {
            return getDebugStringForNoiseValue(p_187221_, this.temperatures);
        }

        public String getDebugStringForHumidity(double p_187232_) {
            return getDebugStringForNoiseValue(p_187232_, this.humidities);
        }

        private static String getDebugStringForNoiseValue(double p_187158_, Climate.Parameter[] p_187159_) {
            double d0 = (double)Climate.quantizeCoord((float)p_187158_);

            for(int i = 0; i < p_187159_.length; ++i) {
                if (d0 < (double)p_187159_[i].max()) {
                    return "" + i;
                }
            }

            return "?";
        }

        @VisibleForDebug
        public Climate.Parameter[] getTemperatureThresholds() {
            return this.temperatures;
        }

        @VisibleForDebug
        public Climate.Parameter[] getHumidityThresholds() {
            return this.humidities;
        }

        @VisibleForDebug
        public Climate.Parameter[] getErosionThresholds() {
            return this.erosions;
        }

        @VisibleForDebug
        public Climate.Parameter[] getContinentalnessThresholds() {
            return new Climate.Parameter[]{this.mushroomFieldsContinentalness, this.deepOceanContinentalness, this.oceanContinentalness, this.coastContinentalness, this.nearInlandContinentalness, this.midInlandContinentalness, this.farInlandContinentalness};
        }

        @VisibleForDebug
        public Climate.Parameter[] getPeaksAndValleysThresholds() {
            return new Climate.Parameter[]{Climate.Parameter.span(-2.0F, NoiseRouterData.peaksAndValleys(0.05F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.05F), NoiseRouterData.peaksAndValleys(0.26666668F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.26666668F), NoiseRouterData.peaksAndValleys(0.4F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.4F), NoiseRouterData.peaksAndValleys(0.56666666F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.56666666F), 2.0F)};
        }

        @VisibleForDebug
        public Climate.Parameter[] getWeirdnessThresholds() {
            return new Climate.Parameter[]{Climate.Parameter.span(-2.0F, 0.0F), Climate.Parameter.span(0.0F, 2.0F)};
        }
    }
}
