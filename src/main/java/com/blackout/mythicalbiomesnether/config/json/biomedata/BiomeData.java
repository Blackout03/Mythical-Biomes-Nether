package com.blackout.mythicalbiomesnether.config.json.biomedata;

import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BiomeData {

    private final Biome biome;
    private final WeightedList<Biome> biomeWeightedList;
    private final Biome edgeBiome;
    private final Biome beachBiome;
    private final Biome riverBiome;
    private final int biomeWeight;
    @Nullable
    private final BiomeManager.BiomeType biomeType;
    private final BiomeDictionary.Type[] dictionaryType;

    public BiomeData(Biome biome, int biomeWeight, @Nullable BiomeManager.BiomeType biomeType, BiomeDictionary.Type[] dictionary, WeightedList<Biome> biomeWeightedList, Biome edgeBiome, Biome beachBiome, Biome river) {
        this.biome = biome;
        this.biomeWeight = biomeWeight;
        this.biomeType = biomeType;
        this.dictionaryType = dictionary;
        this.biomeWeightedList = biomeWeightedList;
        this.edgeBiome = edgeBiome;
        this.beachBiome = beachBiome;
        this.riverBiome = river;
    }

    public Biome getBiome() {
        return biome;
    }

    public WeightedList<Biome> getBiomeWeightedList() {
        return biomeWeightedList;
    }

    public Biome getEdgeBiome() {
        return edgeBiome;
    }

    public Biome getBeachBiome() {
        return beachBiome;
    }

    public Biome getRiverBiome() {
        return riverBiome;
    }

    public int getBiomeWeight() {
        return biomeWeight;
    }

    /**
     * @return Should only ever return null if this the dictionary type contains ocean.
     * A null value represents the middle climate value as oceans consist of the following 5 climates: FROZEN, COOL, MEDIUM/TEMPERATE, LUKEWARM, WARM.
     * <p>
     * Land Overworld biomes contain only 4 climate regions which are all qualifying values in {@link BiomeManager.BiomeType}.
     */
    @Nullable
    public BiomeManager.BiomeType getBiomeType() {
        if (!Arrays.stream(this.dictionaryType).collect(Collectors.toList()).contains(BiomeDictionary.Type.OCEAN) && biomeType == null) {
            throw new UnsupportedOperationException("The biome climate was null in a non ocean biome, this should NEVER happen!");
        }
        return biomeType;
    }

    public BiomeDictionary.Type[] getDictionaryTypes() {
        return dictionaryType;
    }
}
