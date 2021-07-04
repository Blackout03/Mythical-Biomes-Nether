package com.blackout.mythicalbiomesnether.core.world;

import com.blackout.mythicalbiomesnether.common.world.biome.*;
import com.blackout.mythicalbiomesnether.common.world.biome.nether.VerdeForest;
import com.blackout.mythicalbiomesnether.config.json.biomedata.BiomeData;
import com.blackout.mythicalbiomesnether.config.json.subbiomedata.SubBiomeData;
import com.blackout.mythicalbiomesnether.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class MBNBiomes {
    public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

    /************Nether Biomes************/
    public static Biome VERDE_TORRIDS = WorldGenRegistrationHelper.createBiome("verde_forest", new VerdeForest().getBiome(), 142);
    
    public static void init() {
    }

    public static final IdentityHashMap<BiomeManager.BiomeType, WeightedList<ResourceLocation>> TRACKED_OCEANS = new IdentityHashMap<>();

    @SuppressWarnings("ConstantConditions")
    public static void addBiomeEntries() {
        for (BiomeData biomeData : MBNBiome.biomeData) {
            List<BiomeDictionary.Type> dictionaryList = Arrays.stream(biomeData.getDictionaryTypes()).collect(Collectors.toList());
            ResourceLocation key = WorldGenRegistries.BIOME.getKey(biomeData.getBiome());

//            if (!dictionaryList.contains(OCEAN)) {
            if (biomeData.getBiomeWeight() > 0) {
                BiomeManager.addBiome(biomeData.getBiomeType(), new BiomeManager.BiomeEntry(RegistryKey.create(Registry.BIOME_REGISTRY, key), biomeData.getBiomeWeight()));
            }
//            } else {
//                TRACKED_OCEANS.computeIfAbsent(biomeData.getBiomeType(), (biomeType) -> new WeightedList<>()).add(key, biomeData.getBiomeWeight());
//            }
        }
    }

    public static void fillBiomeDictionary() {
        for (BiomeData nmbBiome : MBNBiome.biomeData) {
            BiomeDictionary.addTypes(RegistryKey.create(Registry.BIOME_REGISTRY, WorldGenRegistries.BIOME.getKey(nmbBiome.getBiome())), nmbBiome.getDictionaryTypes());
        }
        for (SubBiomeData nmbSubBiome : MBNSubBiome.subBiomeData) {
            BiomeDictionary.addTypes(RegistryKey.create(Registry.BIOME_REGISTRY, WorldGenRegistries.BIOME.getKey(nmbSubBiome.getBiome())), nmbSubBiome.getDictionaryTypes());
        }

        for (MBNNetherBiome nmbNetherBiome : MBNNetherBiome.MBN_NETHER_BIOMES)
            BiomeDictionary.addTypes(nmbNetherBiome.getKey(), nmbNetherBiome.getBiomeDictionary());
    }


    public static class PreserveBiomeOrder {
        private final Biome biome;
        private final int orderPosition;

        public PreserveBiomeOrder(Biome biome, int orderPosition) {
            this.biome = biome;
            this.orderPosition = orderPosition;
        }

        public Biome getBiome() {
            return biome;
        }

        public int getOrderPosition() {
            return orderPosition;
        }
    }
}
