package com.blackout.mythicalbiomesnether.common.world.biome;

import com.blackout.mythicalbiomesnether.core.world.MBNConfiguredFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;

public class MBNDefaultBiomeFeatures {
    public static void addVerdeVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MBNConfiguredFeatures.HANGING_VERDE_ROOTS);
        gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MBNConfiguredFeatures.RANDOM_VERDE_FUNGUS);
        gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MBNConfiguredFeatures.VERDE_STALK_BLOCK);
        gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MBNConfiguredFeatures.RANDOM_VERDE_PLANT);
    }
}
