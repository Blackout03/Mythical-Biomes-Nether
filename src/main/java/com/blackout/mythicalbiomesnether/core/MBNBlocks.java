package com.blackout.mythicalbiomesnether.core;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.blackout.mythicalbiomesnether.common.MBNCreativeTab;
import com.blackout.mythicalbiomesnether.common.blocks.*;
import com.blackout.mythicalbiomesnether.common.world.feature.nether.mushrooms.util.MBNMushroomToHugeMushroom;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class MBNBlocks {
    public static List<Block> blocksList = new ArrayList<>();
    public static List<Block> flowerPotBlocks = new ArrayList<>();
    public static List<ResourceLocation> flowerIDs = new ArrayList<>();

    public static final Block VERDE_PLANKS = createPlanks("verde_planks");
    public static final Block VERDE_BOOKSHELF = createBookshelf("verde_bookshelf");
    public static final Block VERDE_DOOR = createDoor("verde_door");
    public static final Block VERDE_PRESSURE_PLATE = createWoodPressurePlate("verde_pressure_plate");
    public static final Block VERDE_BUTTON = createWoodButton("verde_button");
    public static final Block VERDE_TRAPDOOR = createTrapDoor("verde_trapdoor");
    public static final Block VERDE_CRAFTING_TABLE = createCraftingTable("verde_crafting_table");
    public static final Block VERDE_FENCE_GATE = createFenceGate("verde_fence_gate");
    public static final Block VERDE_SLAB = createWoodSlab("verde_slab");
    public static final Block VERDE_STAIRS = createWoodStairs("verde_stairs");
    public static final Block VERDE_FENCE = createFence("verde_fence");

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MythicalBiomesNether.MOD_ID);
    public static final DeferredRegister<Item> ITEM_BLOCKS = DeferredRegister.create(ForgeRegistries.ITEMS, MythicalBiomesNether.MOD_ID);

//    public static final DeferredRegister<Block> MINECRAFT_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
//    public static final DeferredRegister<Item> MINECRAFT_ITEM_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

//    public static final RegistryObject<Block> SAND = registerMinecraftBlock("sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
//    public static final RegistryObject<Block> RED_SAND = registerMinecraftBlock("red_sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);

    public static final RegistryObject<Block> HANGING_VERDE_ROOTS = registerBlock("hanging_verde_roots", () -> new HangingVerdeRootsBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.WEEPING_VINES).strength(0.2f).randomTicks().noCollission()), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> HANGING_VERDE_ROOTS_PLANT = registerBlock("hanging_verde_roots_plant", () -> new HangingVerdeRootsPlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.WEEPING_VINES).strength(0.2f).randomTicks().noCollission()), MBNCreativeTab.creativeTab, false);
    public static final RegistryObject<Block> VERDE_ROOTS = registerBlock("verde_roots", () -> new VerdePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.ROOTS).strength(0.0f).noCollission().noOcclusion()), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_SPROUT = registerBlock("verde_sprout", () -> new VerdePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.ROOTS).strength(0.0f).noCollission().noOcclusion()), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_SAPLING = registerBlock("verde_sapling", () -> new VerdeSaplingBlock(AbstractBlock.Properties.of(Material.BAMBOO_SAPLING).sound(SoundType.BAMBOO_SAPLING).strength(0.0f).noCollission().noOcclusion().randomTicks()), MBNCreativeTab.creativeTab, false);
    public static final RegistryObject<Block> VERDE_STALK_BLOCK = registerBlock("verde_stalk_block", () -> new VerdeStalkBlock(AbstractBlock.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(0.2f).noOcclusion().randomTicks()), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_SCAFFOLDING = registerBlock("verde_scaffolding", () -> new MBNScaffoldingBlock(AbstractBlock.Properties.of(Material.DECORATION, MaterialColor.COLOR_LIGHT_GREEN).sound(SoundType.SCAFFOLDING).strength(0.0f, 0.0f).dynamicShape()), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> LIGHT_BLUE_SHROOMLIGHT = registerBlock("light_blue_shroomlight", () -> new Block(AbstractBlock.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_BLUE).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((p_235439_0_) -> 10)), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_NYLIUM = registerBlock("verde_nylium", () -> new NyliumBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.NYLIUM).strength(0.4F).randomTicks().harvestLevel(0).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_WART_BLOCK = registerBlock("verde_wart_block", () -> new Block(AbstractBlock.Properties.of(Material.GRASS).sound(SoundType.WART_BLOCK).strength(1.0F).harvestTool(ToolType.HOE)), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_STEM = registerBlock("verde_stem", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).sound(SoundType.STEM).strength(2.0f)), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_HYPHAE = registerBlock("verde_hyphae", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).sound(SoundType.STEM).strength(2.0f)), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> VERDE_FUNGUS = registerBlock("verde_fungus", () -> new VerdeFungusBlock(AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks(), new MBNMushroomToHugeMushroom.VerdeFungus(), true), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> POTTED_VERDE_FUNGUS = registerBlock("potted_verde_fungus", () -> new FlowerPotBlock(MBNBlocks.VERDE_FUNGUS.get(), AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()), MBNCreativeTab.creativeTab, false);
    public static final RegistryObject<Block> STRIPPED_VERDE_STEM = registerBlock("stripped_verde_stem", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).sound(SoundType.STEM).strength(2.0f)), MBNCreativeTab.creativeTab);
    public static final RegistryObject<Block> STRIPPED_VERDE_HYPHAE = registerBlock("stripped_verde_hyphae", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).sound(SoundType.STEM).strength(2.0f)), MBNCreativeTab.creativeTab);

    public static void createPottedBlock(Block blockForPot, String id) {
        Block createBlock = new FlowerPotBlock(blockForPot, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion());
//        Registry.register(Registry.BLOCK, new ResourceLocation(NetherMythicalBiomes.MOD_ID, "potted_" + id), createBlock);
        createBlock.setRegistryName(new ResourceLocation(MythicalBiomesNether.MOD_ID, "potted_" + id)); //Forge
        flowerPotBlocks.add(createBlock);
//        blocksList.add(createBlock);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup) {
        return registerBlock(name, supplier, itemGroup, true);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
        return registerBlock(name, supplier, itemGroup, 64, generateItem);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, int stackSize, boolean generateItem) {
        RegistryObject<B> block = MBNBlocks.BLOCKS.register(name, supplier);
        if (generateItem)ITEM_BLOCKS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).stacksTo(stackSize)));
        return block;
    }

//    public static <B extends Block> RegistryObject<B> registerMinecraftBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
//        RegistryObject<B> block = MBNBlocks.MINECRAFT_BLOCK_OVERRIDES.register(name, supplier);
//        if (generateItem)MINECRAFT_ITEM_BLOCK_OVERRIDES.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
//        return block;
//    }

    static Block createFence(String id) {
        Block createBlock = new FenceBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createFenceGate(String id) {
        Block createBlock = new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createWoodSlab(String id) {
        Block createBlock = new SlabBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.PICKAXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createWoodPressurePlate(String id) {
        Block createBlock = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).noCollission().strength(0.5F).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createWoodStairs(String id) {
        Block createBlock = new StairsBlock(Registry.BLOCK.get(new ResourceLocation(MythicalBiomesNether.MOD_ID, id.replace("_stairs", "planks"))).defaultBlockState(), AbstractBlock.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createTrapDoor(String id) {
        Block createBlock = new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion().harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createCraftingTable(String id) {
        Block createBlock = new MBNCraftingTableBlock(AbstractBlock.Properties.copy(Blocks.CRAFTING_TABLE).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createWoodButton(String id) {
        Block createBlock = new WoodButtonBlock(AbstractBlock.Properties.of(Material.DECORATION).sound(SoundType.WOOD).noCollission().strength(0.5F).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createBookshelf(String id) {
        Block createBlock = new BookshelfBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createDoor(String id) {
        Block createBlock = new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion().harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createPlanks(String id) {
        Block createBlock = new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).harvestTool(ToolType.AXE));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createBlock(Block block, String id) {
        block.setRegistryName(new ResourceLocation(MythicalBiomesNether.MOD_ID, id));
        blocksList.add(block);
        return block;
    }

    public static void init() {

    }
}
