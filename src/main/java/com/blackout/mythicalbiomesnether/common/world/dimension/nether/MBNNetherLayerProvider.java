package com.blackout.mythicalbiomesnether.common.world.dimension.nether;


import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.blackout.mythicalbiomesnether.common.world.dimension.DatapackLayer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.LongFunction;

public class MBNNetherLayerProvider {
    public static DatapackLayer stackLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> netherLayer = new MBNNetherMasterLayer(biomeRegistry).run(randomProvider.apply(485868686L));

        for (int netherBiomeSize = 0; netherBiomeSize <= MythicalBiomesNether.worldConfig().netherBiomeSize; netherBiomeSize++) {
            netherLayer = ZoomLayer.NORMAL.run(randomProvider.apply(28585L + netherBiomeSize), netherLayer);
        }
        netherLayer = ZoomLayer.FUZZY.run(randomProvider.apply(958687L), netherLayer);
        netherLayer = ZoomLayer.NORMAL.run(randomProvider.apply(19375756L), netherLayer);

        return new DatapackLayer(netherLayer);
    }
}
