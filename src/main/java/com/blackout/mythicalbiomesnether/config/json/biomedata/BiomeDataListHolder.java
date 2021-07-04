package com.blackout.mythicalbiomesnether.config.json.biomedata;

import com.blackout.mythicalbiomesnether.common.world.biome.MBNBiome;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("deprecation")
public class BiomeDataListHolder {

    List<BiomeData> biomeData;


    public BiomeDataListHolder(List<BiomeData> biomeData) {
        this.biomeData = biomeData;
    }

    public List<BiomeData> getBiomeData() {
        return biomeData;
    }

    public static void createDefaults() {
        for (MBNBiome nmbBiome : MBNBiome.MBN_BIOMES) {
            List<BiomeDictionary.Type> typeList = Arrays.asList(nmbBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            MBNBiome.biomeData.add(new BiomeData(nmbBiome.getBiome(), nmbBiome.getWeight(), nmbBiome.getBiomeType(), typeList.toArray(new BiomeDictionary.Type[0]), nmbBiome.getHills(), nmbBiome.getEdge(), nmbBiome.getBeach(), nmbBiome.getRiver()));
        }

        //Sort entries alphabetically
        MBNBiome.biomeData.sort(Comparator.comparing(data -> WorldGenRegistries.BIOME.getKey(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (BiomeData biomeData : MBNBiome.biomeData) {
            WeightedList<Biome> biomeWeightedList = biomeData.getBiomeWeightedList();
            if (biomeWeightedList != null) {
                biomeWeightedList.entries.removeIf(biomeEntry -> biomeEntry.weight <= 0);
                MBNBiome.BIOME_TO_HILLS_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeWeightedList);
            }
            if (biomeData.getBeachBiome() != null)
                MBNBiome.BIOME_TO_BEACH_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getBeachBiome());
            if (biomeData.getEdgeBiome() != null)
                MBNBiome.BIOME_TO_EDGE_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getEdgeBiome());
            if (biomeData.getRiverBiome() != null)
                MBNBiome.BIOME_TO_RIVER_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getRiverBiome());
        }

        MBNBiome.BIOME_TO_EDGE_LIST.remove(-1);
        MBNBiome.BIOME_TO_BEACH_LIST.remove(-1);
        MBNBiome.BIOME_TO_RIVER_LIST.remove(-1);
    }
}
