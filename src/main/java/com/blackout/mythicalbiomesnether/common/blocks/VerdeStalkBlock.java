package com.blackout.mythicalbiomesnether.common.blocks;

import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class VerdeStalkBlock extends BambooBlock {

    public VerdeStalkBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(LEAVES, BambooLeaves.NONE).setValue(STAGE, 0));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateDOWN = ctx.getLevel().getBlockState(ctx.getClickedPos().below());
            if (blockStateDOWN.getBlock() == MBNBlocks.VERDE_NYLIUM.get()) {
                Block blockDOWN = blockStateDOWN.getBlock();
                if (blockDOWN == MBNBlocks.VERDE_SAPLING.get()) {
                    return this.defaultBlockState().setValue(AGE, 0);
                } else if (blockDOWN == this) {
                    int getPropertyAge = blockStateDOWN.getValue(AGE) > 0 ? 1 : 0;
                    return this.defaultBlockState().setValue(AGE, getPropertyAge);
                } else {
                    return MBNBlocks.VERDE_SAPLING.get().defaultBlockState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.canSurvive(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        } else if (state.getValue(STAGE) == 0) {
            int i = this.getHeightBelowUpToMax(worldIn, pos) + 1;
            if (i < 16 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) <= 12)) {
                this.growBamboo(state, worldIn, pos, rand, i);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
            }

        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, IWorld world, BlockPos pos, BlockPos posFrom) {
        if (!state.canSurvive(world, pos)) {
            world.getBlockTicks().scheduleTick(pos, this, 1);
        }

        if (direction == Direction.UP && state2.getBlock() == this && state2.getValue(AGE) > state.getValue(AGE)) {
            world.setBlock(pos, state.cycle(AGE), 2);
        }

        return super.updateShape(state, direction, state2, world, pos, posFrom);
    }

    @Override
    protected void growBamboo(BlockState state, World world, BlockPos pos, Random rand, int i) {
        BlockState stateDOWN = world.getBlockState(pos.below());
        BlockPos posDOWN2 = pos.below(2);
        BlockState blockStateDOWN2 = world.getBlockState(posDOWN2);
        BambooLeaves bambooLeavesNONE = BambooLeaves.NONE;
        if (i >= 1) {
            if (stateDOWN.getBlock() == this && stateDOWN.getValue(LEAVES) != BambooLeaves.NONE) {
                if (stateDOWN.getBlock() == this && stateDOWN.getValue(LEAVES) != BambooLeaves.NONE) {
                    bambooLeavesNONE = BambooLeaves.LARGE;
                    if (blockStateDOWN2.getBlock() == this) {
                        world.setBlock(pos.below(), stateDOWN.setValue(LEAVES, BambooLeaves.SMALL), 3);
                        world.setBlock(posDOWN2, blockStateDOWN2.setValue(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                bambooLeavesNONE = BambooLeaves.SMALL;
            }
        }

        int j = state.getValue(AGE) != 1 && blockStateDOWN2.getBlock() != this ? 0 : 1;
        int k = (i < 11 || rand.nextFloat() >= 0.25F) && i != 15 ? 0 : 1;
        world.setBlock(pos.above(), this.defaultBlockState().setValue(AGE, j).setValue(LEAVES, bambooLeavesNONE).setValue(STAGE, k), 3);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getBlock() == MBNBlocks.VERDE_NYLIUM.get() || worldIn.getBlockState(pos.below()).getBlock() == MBNBlocks.VERDE_STALK_BLOCK.get();
    }

}
