package com.blackout.mythicalbiomesnether.config.json.subbiomedata;

import com.blackout.mythicalbiomesnether.common.world.biome.MBNBiome;
import com.blackout.mythicalbiomesnether.common.world.biome.MBNSubBiome;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraftforge.common.BiomeDictionary;

import java.util.*;

@SuppressWarnings("deprecation")
public class SubBiomeDataListHolder {

    List<SubBiomeData> subBiomeData;


    public SubBiomeDataListHolder(List<SubBiomeData> subBiomeData) {
        this.subBiomeData = subBiomeData;
    }

    public List<SubBiomeData> getSubBiomeData() {
        return subBiomeData;
    }

    public static void createDefaults() {
        for (MBNSubBiome nmbSubBiome : MBNSubBiome.MBN_SUB_BIOMES) {
            List<BiomeDictionary.Type> typeList = Arrays.asList(nmbSubBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            MBNSubBiome.subBiomeData.add(new SubBiomeData(nmbSubBiome.getBiome(), typeList.toArray(new BiomeDictionary.Type[0]), nmbSubBiome.getEdge(), nmbSubBiome.getBeach(), nmbSubBiome.getRiver()));
        }


        //Sort entries alphabetically
        MBNSubBiome.subBiomeData.sort(Comparator.comparing(data -> WorldGenRegistries.BIOME.getKey(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (SubBiomeData biomeData : MBNSubBiome.subBiomeData) {
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
