package com.blackout.mythicalbiomesnether.core.world;

import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.ArrayList;
import java.util.List;

public class MBNSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static void init() {
    }

    public static class Configs {
        public static final SurfaceBuilderConfig VERDETORRIDS = new SurfaceBuilderConfig(MBNBlocks.VERDE_NYLIUM.get().defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
    }
}
