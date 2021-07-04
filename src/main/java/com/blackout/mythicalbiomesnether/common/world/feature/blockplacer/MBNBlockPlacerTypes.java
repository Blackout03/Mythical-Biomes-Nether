package com.blackout.mythicalbiomesnether.common.world.feature.blockplacer;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;

import java.util.ArrayList;
import java.util.List;

public class MBNBlockPlacerTypes {

    public static List<BlockPlacerType<?>> types = new ArrayList<>();

    public static final BlockPlacerType<DoubleBlockPlacer> DOUBLE_BLOCK = createBlockPlacer("simple_block_placer", new BlockPlacerType<>(DoubleBlockPlacer.CODEC));


    private static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacer(String id, BlockPlacerType<P> type) {
//        Registry.register(Registry.BLOCK_PLACER_TYPE, new ResourceLocation(BYG.MOD_ID, id), type);
        type.setRegistryName(new ResourceLocation(MythicalBiomesNether.MOD_ID, id));
        types.add(type);
        return type;
    }

    public static void init() {
    }
}
