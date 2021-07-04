package com.blackout.mythicalbiomesnether.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.blackout.mythicalbiomesnether.common.world.dimension.DatapackLayer;
import com.blackout.mythicalbiomesnether.config.NetherConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;
import java.util.stream.Collectors;

public class MBNNetherBiomeSource extends BiomeProvider {
    public static final Codec<MBNNetherBiomeSource> MBNNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(MBNNetherBiomeSource::new)));

    private static final List<String> NETHER_BIOME_IDS = Arrays.asList(NetherConfig.BLACKLIST_NETHER.get().trim().replace(" ", "").split(","));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

    public MBNNetherBiomeSource(Registry<Biome> registry, long seed) {
        super(createNetherBiomeList(registry).stream().map(registry::get).collect(Collectors.toList()));
        this.seed = seed;
        biomeRegistry = registry;
        NETHER_BIOMES = createNetherBiomeList(registry);
        this.biomeLayer = MBNNetherLayerProvider.stackLayers(this.biomeRegistry, seed);
    }


    public static List<ResourceLocation> createNetherBiomeList(Registry<Biome> biomeRegistry) {
        List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.entrySet()) {
            if (biomeEntry.getValue().getBiomeCategory() == Biome.Category.NETHER) {
                ResourceLocation locationKey = biomeEntry.getKey().location();

                if (NetherConfig.IS_BLACKLIST_NETHER.get()) {
                    //Avoid duping entries
                    if (!NETHER_BIOMES.contains(locationKey) && !NETHER_BIOME_IDS.contains(locationKey.toString())) {
                        NETHER_BIOMES.add(locationKey);
                    }
                } else {
                    for (String id : NETHER_BIOME_IDS) {
                        if (id.equals(locationKey.toString())) {
                            NETHER_BIOMES.add(locationKey);
                        }
                    }
                }
            }
        }
        NETHER_BIOMES.removeIf(Objects::isNull);
        NETHER_BIOMES.sort(Comparator.comparing(ResourceLocation::toString));
        return NETHER_BIOMES;
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return MBNNETHERCODEC;
    }

    @Override
    public BiomeProvider withSeed(long seed) {
        return new MBNNetherBiomeSource(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return biomeLayer.sampleNether(biomeRegistry, x, z);
    }

}
