package com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms;

import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import com.mojang.serialization.Codec;
import com.blackout.mythicalbiomesnether.common.world.feature.config.MBNMushroomConfig;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.util.MBNAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class VerdeFungusTree1 extends MBNAbstractMushroomFeature<MBNMushroomConfig> {

    public VerdeFungusTree1(Codec<MBNMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, MBNMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        int randTreeHeight = 14 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), MBNBlocks.VERDE_NYLIUM.get())) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));

                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 4, 1));

                if ((Math.random() >= 0.3)) {
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(0, 4, 2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(0, 3, 2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(0, 2, 2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(0, 1, 2));
                    this.hangingVerdeRoots(worldIn, mainmutable.set(pos).move(0, 0, 2));
                }

                if ((Math.random() >= 0.3)) {
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(-1, 4, -2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(-1, 3, -2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(-1, 2, -2));
                    this.hangingVerdeRoots(worldIn, mainmutable.set(pos).move(-1, 1, -2));
                }

                if ((Math.random() >= 0.3)) {
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(1, 4, 2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(1, 3, 2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(1, 2, 2));
                    this.hangingVerdeRoots(worldIn, mainmutable.set(pos).move(1, 1, 2));
                }

                if ((Math.random() >= 0.3)) {
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(1, 4, -2));
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(1, 3, -2));
                    this.hangingVerdeRoots(worldIn, mainmutable.set(pos).move(1, 2, -2));
                }

                if ((Math.random() >= 0.3)) {
                    this.hangingVerdeRootsPlant(worldIn, mainmutable.set(pos).move(0, 4, -2));
                    this.hangingVerdeRoots(worldIn, mainmutable.set(pos).move(0, 3, -2));
                }
            }
        }
        return true;
    }

    private void hangingVerdeRoots(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, MBNBlocks.HANGING_VERDE_ROOTS.get().defaultBlockState());
        }
    }

    //Leaves Placement
    private void hangingVerdeRootsPlant(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, MBNBlocks.HANGING_VERDE_ROOTS_PLANT.get().defaultBlockState());
        }
    }
}
