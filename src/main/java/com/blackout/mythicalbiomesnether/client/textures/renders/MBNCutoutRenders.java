package com.blackout.mythicalbiomesnether.client.textures.renders;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class MBNCutoutRenders {
    public static void renderCutOuts() {
        MythicalBiomesNether.LOGGER.debug("MBN: Rendering Texture Cutouts...");

        //Nether
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_ROOTS.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_SPROUT.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_STALK_BLOCK.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_NYLIUM.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(MBNBlocks.HANGING_VERDE_ROOTS.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(MBNBlocks.HANGING_VERDE_ROOTS_PLANT.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_FUNGUS.get(), RenderType.cutoutMipped());

        //Doors
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_DOOR, RenderType.cutoutMipped());

        //Trapdoors
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_TRAPDOOR, RenderType.cutoutMipped());

        //Other renders
        RenderTypeLookup.setRenderLayer(MBNBlocks.VERDE_SCAFFOLDING.get(), RenderType.cutoutMipped());

        for (Block potBlock : MBNBlocks.flowerPotBlocks)
            RenderTypeLookup.setRenderLayer(potBlock, RenderType.cutoutMipped());

        MythicalBiomesNether.LOGGER.debug("MBN: Texture Cutouts Rendered!");
    }
}
