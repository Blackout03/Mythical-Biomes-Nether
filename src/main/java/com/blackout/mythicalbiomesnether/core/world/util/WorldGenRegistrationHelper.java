package com.blackout.mythicalbiomesnether.core.world.util;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.blackout.mythicalbiomesnether.core.world.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class WorldGenRegistrationHelper {

    public static <SBC extends ISurfaceBuilderConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (Registry.SURFACE_BUILDER.keySet().contains(nmbID))
            throw new IllegalStateException("Surface Builder ID: \"" + nmbID.toString() + "\" already exists in the Surface Builder registry!");

//        Registry.register(Registry.SURFACE_BUILDER, nmbID, surfaceBuilder);
        surfaceBuilder.setRegistryName(nmbID); //Forge
        MBNSurfaceBuilders.surfaceBuilders.add(surfaceBuilder);
        return surfaceBuilder;
    }

    public static <SC extends ISurfaceBuilderConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (WorldGenRegistries.CONFIGURED_SURFACE_BUILDER.keySet().contains(nmbID))
            throw new IllegalStateException("Configured Surface Builder ID: \"" + nmbID.toString() + "\" already exists in the Configured Surface Builder registry!");

        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, nmbID, configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends IFeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (Registry.FEATURE.keySet().contains(nmbID))
            throw new IllegalStateException("Feature ID: \"" + nmbID.toString() + "\" already exists in the Features registry!");

//        Registry.register(Registry.FEATURE, nmbID, feature);
        feature.setRegistryName(nmbID); //Forge
        MBNFeatures.features.add(feature);
        return feature;
    }

    public static <C extends IFeatureConfig, CSF extends StructureFeature<C, ?>> CSF createConfiguredStructureFeature(String id, CSF configuredStructureFeature) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE.keySet().contains(nmbID))
            throw new IllegalStateException("Configured Structure Feature ID: \"" + nmbID.toString() + "\" already exists in the Configured Structure Features registry!");

        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, nmbID, configuredStructureFeature);
        return configuredStructureFeature;
    }


    public static IStructurePieceType createStructurePiece(String id, IStructurePieceType piece) {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(MythicalBiomesNether.MOD_ID, id), piece);
        return piece;
    }

    public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (WorldGenRegistries.CONFIGURED_FEATURE.keySet().contains(nmbID))
            throw new IllegalStateException("Configured Feature ID: \"" + nmbID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, nmbID, configuredFeature);
        return configuredFeature;
    }

    public static <DC extends IPlacementConfig, D extends Placement<DC>> D createDecorator(String id, D decorator) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (Registry.DECORATOR.keySet().contains(nmbID))
            throw new IllegalStateException("Decorator ID: \"" + nmbID.toString() + "\" already exists in the Decorator registry!");

//        Registry.register(Registry.DECORATOR, nmbID, decorator);
        decorator.setRegistryName(nmbID); //Forge
        MBNDecorators.decorators.add(decorator);
        return decorator;
    }

    static Set<Integer> integerList = new HashSet<>();

    public static Biome createBiome(String id, Biome biome, int numericalID) {
        ResourceLocation nmbID = new ResourceLocation(MythicalBiomesNether.MOD_ID, id);
        if (WorldGenRegistries.BIOME.keySet().contains(nmbID))
            throw new IllegalStateException("Biome ID: \"" + nmbID.toString() + "\" already exists in the Biome registry!");

//        Registry.register(WorldGenRegistries.BIOME, nmbID, biome);
        biome.setRegistryName(nmbID); //Forge

        if (integerList.contains(numericalID))
            MythicalBiomesNether.LOGGER.warn("Duplicate Biome Numerical ID: " + numericalID + " at nmb:" + id);

        integerList.add(numericalID);
        return biome;
    }
}