package com.blackout.mythicalbiomesnether.core.world;

import com.blackout.mythicalbiomesnether.common.world.feature.ObsidianBlobFeature;
import com.blackout.mythicalbiomesnether.common.world.feature.config.HangingColumnWithBaseConfig;
import com.blackout.mythicalbiomesnether.common.world.feature.config.MBNMushroomConfig;
import com.blackout.mythicalbiomesnether.common.world.feature.config.SimpleBlockProviderConfig;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.ConfigurablePillar;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.HangingColumnWithBase;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.*;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.util.MBNAbstractMushroomFeature;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.verdeforest.VerdeStalk;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GlowstoneBlobFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.ArrayList;
import java.util.List;

import static com.blackout.mythicalbiomesnether.core.world.util.WorldGenRegistrationHelper.createFeature;


public class MBNFeatures {

    public static List<Feature<?>> features = new ArrayList<>();

    /********************************************************************Nether Features********************************************************************/

    public static final Feature<HangingColumnWithBaseConfig> HANGING_FEATURE = createFeature("hanging_feature", new HangingColumnWithBase(HangingColumnWithBaseConfig.CODEC.stable()));

    public static final Feature<NoFeatureConfig> OBSIDIAN_BLOB = createFeature("obsidian_blob", new ObsidianBlobFeature(NoFeatureConfig.CODEC));

    //Verde
    public static final Feature<ProbabilityConfig> VERDE_STALK_BLOCK = createFeature("verde_stalk", new VerdeStalk(ProbabilityConfig.CODEC.stable()));

    public static final MBNAbstractMushroomFeature<MBNMushroomConfig> VERDE_FUNGUS_BUSH1 = createFeature("verde_fungus_bush1", new VerdeFungusBush1(MBNMushroomConfig.CODEC.stable()));

    public static final MBNAbstractMushroomFeature<MBNMushroomConfig> VERDE_FUNGUS_TREE1 = createFeature("verde_fungus_tree1", new VerdeFungusTree1(MBNMushroomConfig.CODEC.stable()));
    public static final MBNAbstractMushroomFeature<MBNMushroomConfig> VERDE_FUNGUS_TREE2 = createFeature("verde_fungus_tree2", new VerdeFungusTree2(MBNMushroomConfig.CODEC.stable()));
    public static final MBNAbstractMushroomFeature<MBNMushroomConfig> VERDE_FUNGUS_TREE3 = createFeature("verde_fungus_tree3", new VerdeFungusTree3(MBNMushroomConfig.CODEC.stable()));
    public static final MBNAbstractMushroomFeature<MBNMushroomConfig> VERDE_FUNGUS_TREE4 = createFeature("verde_fungus_tree4", new VerdeFungusTree4(MBNMushroomConfig.CODEC.stable()));

    public static void init() {
    }
}


