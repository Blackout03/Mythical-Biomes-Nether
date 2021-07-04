package com.blackout.mythicalbiomesnether.common.blocks;

        import com.blackout.mythicalbiomesnether.core.MBNBlocks;
        import net.minecraft.block.AbstractTopPlantBlock;
        import net.minecraft.block.Block;
        import net.minecraft.block.BlockState;
        import net.minecraft.block.PlantBlockHelper;
        import net.minecraft.entity.Entity;
        import net.minecraft.util.Direction;
        import net.minecraft.util.math.BlockPos;
        import net.minecraft.util.math.shapes.VoxelShape;
        import net.minecraft.util.math.vector.Vector3d;
        import net.minecraft.world.World;

        import java.util.Random;

public class HangingVerdeRootsBlock extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public HangingVerdeRootsBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    /**
     * Used to determine how much to grow the plant when using bonemeal. Kelp always returns 1, where as the nether vines
     * return a random value at least 1.
     */
    protected int getBlocksToGrowWhenBonemealed(Random rand) {
        return PlantBlockHelper.getBlocksToGrowWhenBonemealed(rand);
    }

    protected Block getBodyBlock() {
        return MBNBlocks.HANGING_VERDE_ROOTS_PLANT.get();
    }

    protected boolean canGrowInto(BlockState state) {
        return PlantBlockHelper.isValidGrowthState(state);
    }

    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.makeStuckInBlock(state, new Vector3d(0.8F, 0.75D, 0.8F));
    }
}
