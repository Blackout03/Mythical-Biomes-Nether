package com.blackout.mythicalbiomesnether.common.world.dimension.nether;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class MBNNetherMasterLayer implements IAreaTransformer0 {
    private final Registry<Biome> biomeRegistry;

    public MBNNetherMasterLayer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public int applyPixel(INoiseRandom rand, int x, int y) {
        return getRandomNetherBiomes(this.biomeRegistry, rand);
    }

    public static int getRandomNetherBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return biomeRegistry.getId(biomeRegistry.getOptional(MBNNetherBiomeSource.NETHER_BIOMES.get(rand.nextRandom(MBNNetherBiomeSource.NETHER_BIOMES.size()))).orElseThrow(RuntimeException::new));
    }
}
