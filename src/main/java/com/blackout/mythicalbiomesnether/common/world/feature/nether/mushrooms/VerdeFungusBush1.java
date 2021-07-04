package com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms;

import com.blackout.mythicalbiomesnether.common.world.feature.config.MBNMushroomConfig;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.util.MBNAbstractMushroomFeature;
import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class VerdeFungusBush1 extends MBNAbstractMushroomFeature<MBNMushroomConfig> {

    public VerdeFungusBush1(Codec<MBNMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, MBNMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), MBNBlocks.VERDE_NYLIUM.get())) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, 0, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, 0, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, 1));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, -1));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -0));
                }

                if ((Math.random() >= 0.3)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -0));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 2));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 2, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 2, 0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, 1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 2, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, 2));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 2, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, -0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -2));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 2, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 2, -0));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, -1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 2, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-0, 1, -2));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 2, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 2));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 2));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, 1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -2));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -1));
                }

                if ((Math.random() >= 0.6)) {
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -2));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, -1));
                    placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                }
            }
        }
        return true;
    }
}
