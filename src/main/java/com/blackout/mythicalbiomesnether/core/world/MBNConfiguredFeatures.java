package com.blackout.mythicalbiomesnether.core.world;

import com.google.common.collect.ImmutableList;
import com.blackout.mythicalbiomesnether.common.world.feature.blockplacer.DoubleBlockPlacer;
import com.blackout.mythicalbiomesnether.common.world.feature.config.*;
import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

import static com.blackout.mythicalbiomesnether.core.world.util.WorldGenRegistrationHelper.createConfiguredFeature;

public class MBNConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> OBSIDIAN_EXTRA = createConfiguredFeature("obsidian_extra", MBNFeatures.OBSIDIAN_BLOB.configured(IFeatureConfig.NONE).decorated(Placement.GLOWSTONE.configured(new FeatureSpreadConfig(10))).count(2));
    public static final ConfiguredFeature<?, ?> OBSIDIAN = createConfiguredFeature("obsidian", MBNFeatures.OBSIDIAN_BLOB.configured(IFeatureConfig.NONE).range(128).squared().count(12));

    /***********************************************************Configured Features***********************************************************/

    public static final ConfiguredFeature<?, ?> VERDE_ROOTS = createConfiguredFeature("verde_root", Feature.SIMPLE_BLOCK.configured(new BlockWithContextConfig(MBNBlocks.VERDE_ROOTS.get().defaultBlockState(), ImmutableList.of(MBNBlocks.VERDE_NYLIUM.get().defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), MBNBlocks.VERDE_NYLIUM.get().defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> VERDE_SPROUT = createConfiguredFeature("verde_sprout", Feature.SIMPLE_BLOCK.configured(new BlockWithContextConfig(MBNBlocks.VERDE_SPROUT.get().defaultBlockState(), ImmutableList.of(MBNBlocks.VERDE_NYLIUM.get().defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), MBNBlocks.VERDE_NYLIUM.get().defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> VERDE_FUNGUS = createConfiguredFeature("verde_fungus", Feature.SIMPLE_BLOCK.configured(new BlockWithContextConfig(MBNBlocks.VERDE_FUNGUS.get().defaultBlockState(), ImmutableList.of(MBNBlocks.VERDE_NYLIUM.get().defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), MBNBlocks.VERDE_NYLIUM.get().defaultBlockState()))));

    /***********************************************************Configured & Decorated Features***********************************************************/

    public static final ConfiguredFeature<?, ?> VERDE_STALK_BLOCK = createConfiguredFeature("verde_stalk", MBNFeatures.VERDE_STALK_BLOCK.configured(new ProbabilityConfig(0.9F)).decorated(MBNDecorators.UNDERGROUND_COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));

    /***********************************************************Configured Random Selector Features***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_VERDE_PLANT = createConfiguredFeature("verde_plants", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
            VERDE_SPROUT.weighted(0.5F),
            VERDE_ROOTS.weighted(0.46F)),
            VERDE_FUNGUS)).decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> HANGING_VERDE_ROOTS = createConfiguredFeature("hanging_verde_roots", MBNFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.NETHERRACK).setBlock(MBNBlocks.HANGING_VERDE_ROOTS_PLANT.get().defaultBlockState()).setEndBlock(MBNBlocks.HANGING_VERDE_ROOTS.get().defaultBlockState()).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, MBNBlocks.VERDE_WART_BLOCK.get())).build()).range(64).squared().count(50));

    public static final ConfiguredFeature<MBNMushroomConfig, ?> VERDE_FUNGUS_BUSH1 = createConfiguredFeature("verde_fungus_bush1", MBNFeatures.VERDE_FUNGUS_BUSH1.configured(new MBNMushroomConfig.Builder().setStemBlock(MBNBlocks.VERDE_STEM.get()).setMushroomBlock(MBNBlocks.VERDE_WART_BLOCK.get()).setMinHeight(5).setMaxHeight(9).build()));

    /***********************************************************Configured Tree Features********************************************************/

    //Nether Mushrooms
    public static final ConfiguredFeature<MBNMushroomConfig, ?> VERDE_FUNGUS_TREE1 = createConfiguredFeature("verde_fungus_tree1", MBNFeatures.VERDE_FUNGUS_TREE1.configured(new MBNMushroomConfig.Builder().setStemBlock(MBNBlocks.VERDE_STEM.get()).setMushroomBlock(MBNBlocks.VERDE_WART_BLOCK.get()).setMinHeight(5).setMaxHeight(9).build()));
    public static final ConfiguredFeature<MBNMushroomConfig, ?> VERDE_FUNGUS_TREE2 = createConfiguredFeature("verde_fungus_tree2", MBNFeatures.VERDE_FUNGUS_TREE2.configured(new MBNMushroomConfig.Builder().setStemBlock(MBNBlocks.VERDE_STEM.get()).setMushroomBlock(MBNBlocks.VERDE_WART_BLOCK.get()).setMinHeight(5).setMaxHeight(9).build()));
    public static final ConfiguredFeature<MBNMushroomConfig, ?> VERDE_FUNGUS_TREE3 = createConfiguredFeature("verde_fungus_tree3", MBNFeatures.VERDE_FUNGUS_TREE3.configured(new MBNMushroomConfig.Builder().setStemBlock(MBNBlocks.VERDE_STEM.get()).setMushroomBlock(MBNBlocks.VERDE_WART_BLOCK.get()).setMinHeight(5).setMaxHeight(9).build()));
    public static final ConfiguredFeature<MBNMushroomConfig, ?> VERDE_FUNGUS_TREE4 = createConfiguredFeature("verde_fungus_tree4", MBNFeatures.VERDE_FUNGUS_TREE4.configured(new MBNMushroomConfig.Builder().setStemBlock(MBNBlocks.VERDE_STEM.get()).setMushroomBlock(MBNBlocks.VERDE_WART_BLOCK.get()).setMinHeight(5).setMaxHeight(9).build()));

    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_VERDE_FUNGUS = createConfiguredFeature("verde_fungi_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
            VERDE_FUNGUS_BUSH1.weighted(0.12F),
            VERDE_FUNGUS_TREE1.weighted(0.22F),
            VERDE_FUNGUS_TREE2.weighted(0.22F),
            VERDE_FUNGUS_TREE3.weighted(0.22F)),
            VERDE_FUNGUS_TREE4)).decorated(MBNDecorators.UNDERGROUND_COUNT_EXTRA.configured(
            new AtSurfaceWithExtraConfig(6, 0.4F, 2))));

    //Initialize these later so our blocks don't throw NPEs initializing other configured features in this class.
    public static class SpreadableBlockConfigs {
        public static final BlockClusterFeatureConfig VERDE_CONFIG = new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(MBNBlocks.VERDE_ROOTS.get().defaultBlockState(), 50).add(MBNBlocks.VERDE_SPROUT.get().defaultBlockState(), 50).add(MBNBlocks.VERDE_FUNGUS.get().defaultBlockState(), 11), new DoubleBlockPlacer()).build();
    }
}
