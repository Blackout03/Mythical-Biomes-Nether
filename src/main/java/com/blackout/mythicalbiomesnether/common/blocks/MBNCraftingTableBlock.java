package com.blackout.mythicalbiomesnether.common.blocks;

import com.blackout.mythicalbiomesnether.client.gui.MBNWorkbenchContainer;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import net.minecraft.block.AbstractBlock.Properties;

public class MBNCraftingTableBlock extends CraftingTableBlock {
    private static final ITextComponent GUI_TITLE = new TranslationTextComponent("container.crafting");

    public MBNCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getMenuProvider(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, entity) -> new MBNWorkbenchContainer(id, inventory, IWorldPosCallable.create(worldIn, pos), this), GUI_TITLE);
    }
}

