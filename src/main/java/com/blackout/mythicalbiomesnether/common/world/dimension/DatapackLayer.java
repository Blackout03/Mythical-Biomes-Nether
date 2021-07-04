package com.blackout.mythicalbiomesnether.common.world.dimension;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;

public class DatapackLayer {

    private final LazyArea lazyArea;

    public DatapackLayer(IAreaFactory<LazyArea> lazyAreaFactoryIn) {
        this.lazyArea = lazyAreaFactoryIn.make();
    }

    static int stopLoggerSpamNether = 0;

    public Biome sampleNether(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.get(x, z);
        Biome biome = registry.byId(biomeID);
        if (biome == null) {
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw Util.pauseInIde(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamNether <= 50) {
                    MythicalBiomesNether.LOGGER.warn("MBN's Nether Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamNether++;
                }
                return registry.get(BiomeRegistry.byId(8));
            }
        } else {
            return biome;
        }
    }
}
