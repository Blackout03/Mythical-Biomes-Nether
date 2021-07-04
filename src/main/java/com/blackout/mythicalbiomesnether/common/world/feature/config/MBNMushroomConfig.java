package com.blackout.mythicalbiomesnether.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class MBNMushroomConfig implements IFeatureConfig {

    public static final Codec<MBNMushroomConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        }), BlockStateProvider.CODEC.fieldOf("mushroom_provider").forGetter((config) -> {
            return config.mushroomProvider;
        }), BlockStateProvider.CODEC.fieldOf("mushroom2_provider").forGetter((config) -> {
            return config.mushroomProvider;
        }), BlockStateProvider.CODEC.fieldOf("mushroom3_provider").forGetter((config) -> {
            return config.mushroomProvider;
        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
            return config.minHeight;
        }), Codec.INT.fieldOf("max_height").orElse(1).forGetter((config) -> {
            return config.maxPossibleHeight;
        })).apply(codecRecorder, MBNMushroomConfig::new);
    });


    private final BlockStateProvider stemProvider;
    private final BlockStateProvider mushroomProvider;
    private final BlockStateProvider mushroom2Provider;
    private final BlockStateProvider mushroom3Provider;
    private final int minHeight;
    private final int maxPossibleHeight;

    private boolean forcedPlacement = false;


    MBNMushroomConfig(BlockStateProvider stemProvider, BlockStateProvider mushroomProvider, BlockStateProvider mushroom2Provider, BlockStateProvider mushroom3Provider, int minHeight, int maxPossibleHeight) {
        this.stemProvider = stemProvider;
        this.mushroomProvider = mushroomProvider;
        this.mushroom2Provider = mushroom2Provider;
        this.mushroom3Provider = mushroom3Provider;
        this.minHeight = minHeight;
        this.maxPossibleHeight = maxPossibleHeight;
    }

    /**
     * Used to generate giant flowers from flowers.
     */
    public void forcePlacement() {
        forcedPlacement = true;
    }


    public BlockStateProvider getStemProvider() {
        return this.stemProvider;
    }

    public BlockStateProvider getMushroomProvider() {
        return this.mushroomProvider;
    }

    public BlockStateProvider getMushroom2Provider() {
        return this.mushroom2Provider;
    }

    public BlockStateProvider getMushroom3Provider() {
        return this.mushroom3Provider;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxPossibleHeight - minHeight;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue;
    }

    public boolean isPlacementForced() {
        return forcedPlacement;
    }


    public static class Builder {
        private BlockStateProvider stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState());
        private BlockStateProvider mushroomProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());
        private BlockStateProvider mushroom2Provider = this.mushroomProvider;
        private BlockStateProvider mushroom3Provider = this.mushroomProvider;
        private int minHeight = 15;
        private int maxPossibleHeight = 1;

        public Builder setStemBlock(Block block) {
            if (block != null)
                stemProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setStemBlock(BlockState state) {
            if (state != null)
                stemProvider = new SimpleBlockStateProvider(state);
            else
                stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState());

            return this;
        }

        public Builder setMushroomBlock(Block block) {
            if (block != null)
                mushroomProvider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                mushroomProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setMushroomBlock(BlockState state) {
            if (state != null)
                mushroomProvider = new SimpleBlockStateProvider(state);
            else
                mushroomProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setMushroomBlock(WeightedBlockStateProvider statesList) {
            if (statesList != null)
                mushroomProvider = statesList;
            else
                mushroomProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState());

            return this;
        }

        public Builder setMushroom2Block(Block block) {
            if (block != null)
                mushroom2Provider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                mushroom2Provider = this.mushroomProvider;

            return this;
        }

        public Builder setMushroom2Block(BlockState state) {
            if (state != null)
                mushroom2Provider = new SimpleBlockStateProvider(state);
            else
                mushroom2Provider = this.mushroomProvider;

            return this;
        }

        public Builder setMushroom3Block(Block block) {
            if (block != null)
                mushroom3Provider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                mushroom3Provider = this.mushroomProvider;

            return this;
        }

        public Builder setMushroom3Block(BlockState state) {
            if (state != null)
                mushroom3Provider = new SimpleBlockStateProvider(state);
            else
                mushroom3Provider = this.mushroomProvider;

            return this;
        }

        public Builder setPollenBlock(Block block) {
            if (block != null)
                mushroom3Provider = new SimpleBlockStateProvider(block.defaultBlockState());
            else
                mushroom3Provider = this.mushroomProvider;
            return this;
        }

        public Builder setPollenBlock(BlockState state) {
            if (state != null)
                mushroom3Provider = new SimpleBlockStateProvider(state);
            else
                mushroom3Provider = this.mushroomProvider;
            return this;
        }

        public Builder setMinHeight(int minHeight) {
            this.minHeight = minHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight != 0)
                this.maxPossibleHeight = maxPossibleHeight + 1;
            else
                this.maxPossibleHeight = 1;
            return this;
        }

        public Builder copy(MBNMushroomConfig config) {
            this.maxPossibleHeight = config.maxPossibleHeight;
            this.minHeight = config.minHeight;
            this.stemProvider = config.stemProvider;
            this.mushroomProvider = config.mushroomProvider;
            this.mushroom2Provider = config.mushroom2Provider;
            this.mushroom3Provider = config.mushroom3Provider;
            return this;
        }

        public MBNMushroomConfig build() {
            return new MBNMushroomConfig(this.stemProvider, this.mushroomProvider, this.mushroom2Provider, this.mushroom3Provider, this.minHeight, this.maxPossibleHeight);
        }
    }
}
