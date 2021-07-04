package com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.util;

import com.blackout.mythicalbiomesnether.common.world.feature.config.MBNMushroomConfig;
import com.blackout.mythicalbiomesnether.core.world.MBNConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class MBNMushroomToHugeMushroom {
    public static class VerdeFungus extends MBNHugeMushroom {
        @Nullable
        public ConfiguredFeature<MBNMushroomConfig, ?> getHugeMushroomFeature(Random random) {
            return (random.nextInt(2) == 0) ? MBNConfiguredFeatures.VERDE_FUNGUS_TREE1 : MBNConfiguredFeatures.VERDE_FUNGUS_TREE2;
        }
    }
}

