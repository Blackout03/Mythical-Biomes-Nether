package com.blackout.mythicalbiomesnether.common;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.blackout.mythicalbiomesnether.core.MBNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class MBNCreativeTab {
    public static ItemGroup creativeTab = new ItemGroup("mbn") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MBNItems.VERDE_PLANKS);
        }

        @Override
        public boolean hasSearchBar() {
            return false;
        }

        @Override
        public boolean canScroll() {
            return true;
        }

        @Override
        public ResourceLocation getBackgroundImage() {
            return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_items.png");
        }
    };

    public static void init() {
        MythicalBiomesNether.LOGGER.debug("MBN: Item Group Created!");
    }
}
