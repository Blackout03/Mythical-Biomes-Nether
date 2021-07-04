package com.blackout.mythicalbiomesnether.core;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.blackout.mythicalbiomesnether.common.MBNCreativeTab;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class MBNItems {

    public static List<Item> itemsList = new ArrayList<>();

    //Verde Woodtype
    public static final Item VERDE_PLANKS = createItem(new BlockItem(MBNBlocks.VERDE_PLANKS, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_PLANKS));
    public static final Item VERDE_BOOKSHELF = createItem(new BlockItem(MBNBlocks.VERDE_BOOKSHELF, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_BOOKSHELF));
    public static final Item VERDE_CRAFTING_TABLE = createItem(new BlockItem(MBNBlocks.VERDE_CRAFTING_TABLE, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_CRAFTING_TABLE));
    public static final Item VERDE_STAIRS = createItem(new BlockItem(MBNBlocks.VERDE_STAIRS, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_STAIRS));
    public static final Item VERDE_SLAB = createItem(new BlockItem(MBNBlocks.VERDE_SLAB, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_SLAB));
    public static final Item VERDE_FENCE = createItem(new BlockItem(MBNBlocks.VERDE_FENCE, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_FENCE));
    public static final Item VERDE_FENCE_GATE = createItem(new BlockItem(MBNBlocks.VERDE_FENCE_GATE, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_FENCE_GATE));
    public static final Item VERDE_DOOR = createItem(new TallBlockItem(MBNBlocks.VERDE_DOOR, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_DOOR));
    public static final Item VERDE_TRAPDOOR = createItem(new BlockItem(MBNBlocks.VERDE_TRAPDOOR, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_TRAPDOOR));
    public static final Item VERDE_PRESSURE_PLATE = createItem(new BlockItem(MBNBlocks.VERDE_PRESSURE_PLATE, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_PRESSURE_PLATE));
    public static final Item VERDE_BUTTON = createItem(new BlockItem(MBNBlocks.VERDE_BUTTON, new Item.Properties().tab(MBNCreativeTab.creativeTab)), Registry.BLOCK.getKey(MBNBlocks.VERDE_BUTTON));

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
//            Registry.register(Registry.ITEM, id, item);
            item.setRegistryName(id); //Forge
            itemsList.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
//        Registry.register(Registry.ITEM, new ResourceLocation(MBN.MOD_ID, id), item);
        item.setRegistryName(new ResourceLocation(MythicalBiomesNether.MOD_ID, id)); //Forge
        itemsList.add(item);
        return item;
    }

    public static void init() {
    }
}
