package com.blackout.mythicalbiomesnether.common.blocks;

import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class VerdeSaplingBlock extends BambooSaplingBlock {
    public VerdeSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getBlock() == MBNBlocks.VERDE_NYLIUM.get();
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (facing == Direction.UP && facingState.getBlock() == MBNBlocks.VERDE_STALK_BLOCK.get()) {
                worldIn.setBlock(currentPos, MBNBlocks.VERDE_STALK_BLOCK.get().defaultBlockState(), 2);
            }

            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) <= 12) {
            this.growBamboo(worldIn, pos);
        }

    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(MBNBlocks.VERDE_STALK_BLOCK.get().asItem());
    }

    protected void growBamboo(World world, BlockPos pos) {
        world.setBlock(pos.above(), MBNBlocks.VERDE_STALK_BLOCK.get().defaultBlockState().setValue(BambooBlock.LEAVES, BambooLeaves.SMALL), 3);
    }
}
