package com.blackout.mythicalbiomesnether.common.world.dimension.layers;

import com.blackout.mythicalbiomesnether.util.LayerRandomWeightedListUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;

import javax.annotation.Nullable;
import java.util.Map;

public class MBNHillsLayer implements IAreaTransformer2, IDimOffset1Transformer {

    private final Map<ResourceLocation, WeightedList<ResourceLocation>> hillMap;
    private final Registry<Biome> biomeRegistry;
    private final int hillReplacementChance;

    public MBNHillsLayer(Registry<Biome> biomeRegistry, Map<ResourceLocation, WeightedList<ResourceLocation>> hillMap, int hillReplacementChance) {
        this.hillMap = hillMap;
        this.biomeRegistry = biomeRegistry;
        this.hillReplacementChance = hillReplacementChance;
    }


    @SuppressWarnings("ConstantConditions")
    public int applyPixel(INoiseRandom rand, IArea area1, IArea area2, int x, int z) {
        int i = area1.get(this.getParentX(x + 1), this.getParentY(z + 1));

        if (hillMap.size() > 0) {
            if (rand.nextRandom(hillReplacementChance) == 0) {
                int l = i;
                if (hillMap.containsKey(biomeRegistry.getKey(biomeRegistry.byId(i)))) {
                    Biome hill = getHillBiomeValue(hillMap.get(biomeRegistry.getKey(biomeRegistry.byId(i))), rand);
                    if (hill != null) {
                        l = biomeRegistry.getId(hill);
                    }
                }
                return l;
            }
        }
        return i;
    }

    @Nullable
    private Biome getHillBiomeValue(WeightedList<ResourceLocation> biomeHolder, INoiseRandom layerRandom) {
        if (biomeHolder.entries.size() > 0) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(biomeHolder, layerRandom));
        }
        else {
            return null;
        }
    }
}