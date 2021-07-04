package com.blackout.mythicalbiomesnether.common.world.biome;

import com.blackout.mythicalbiomesnether.config.json.subbiomedata.SubBiomeData;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class MBNSubBiome {
    public static final List<MBNSubBiome> MBN_SUB_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<SubBiomeData> subBiomeData = new ArrayList<>();


    public MBNSubBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        MBN_SUB_BIOMES.add(this);
    }

    public MBNSubBiome(Biome.Builder builder) {
        this.biome = builder.build();
        MBN_SUB_BIOMES.add(this);
    }

    public MBNSubBiome(Biome biome) {
        this.biome = biome;
        MBN_SUB_BIOMES.add(this);
    }

    public Biome getBeach() {
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.BEACH);
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER);
    }

    public BiomeDictionary.Type[] getBiomeDictionary() {
        return new BiomeDictionary.Type[]{BiomeDictionary.Type.OVERWORLD};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }
}
