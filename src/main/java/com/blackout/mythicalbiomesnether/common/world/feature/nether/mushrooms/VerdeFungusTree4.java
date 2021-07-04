package com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms;

import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import com.mojang.serialization.Codec;
import com.blackout.mythicalbiomesnether.common.world.feature.config.MBNMushroomConfig;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.util.MBNAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class VerdeFungusTree4 extends MBNAbstractMushroomFeature<MBNMushroomConfig> {

    public VerdeFungusTree4(Codec<MBNMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, MBNMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        int randTreeHeight = 9 + rand.nextInt(5);
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
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 9, 0));

                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 1));

                if ((Math.random() >= 0.5)) {
                    this.shroomLight(worldIn, mainmutable.set(pos).move(0, 6, 1));
                    this.shroomLight(worldIn, mainmutable.set(pos).move(-1, 6, 0));
                } else if ((Math.random() >= 0.45)) {
                    this.shroomLight(worldIn, mainmutable.set(pos).move(0, 6, 1));
                    this.shroomLight(worldIn, mainmutable.set(pos).move(0, 5, 1));
                    this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 6, 1));
                } else {
                    this.shroomLight(worldIn, mainmutable.set(pos).move(0, 6, 3));
                    this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 7, 0));
                }

                if ((Math.random() >= 0.45)) {
                    this.shroomLight(worldIn, mainmutable.set(pos).move(-1, 8, 0));
                } else if ((Math.random() >= 0.5)) {
                    this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 8, 0));
                    this.shroomLight(worldIn, mainmutable.set(pos).move(1, 9, 2));
                } else {
                    this.shroomLight(worldIn, mainmutable.set(pos).move(-3, 8, 0));
                    this.shroomLight(worldIn, mainmutable.set(pos).move(2, 11, -1));
                }
            }
        }
        return true;
    }
    private void shroomLight(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, MBNBlocks.LIGHT_BLUE_SHROOMLIGHT.get().defaultBlockState());
        }
    }
}