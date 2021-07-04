package com.blackout.mythicalbiomesnether;


import com.blackout.mythicalbiomesnether.client.textures.renders.MBNCutoutRenders;
import com.blackout.mythicalbiomesnether.common.MBNCreativeTab;
import com.blackout.mythicalbiomesnether.common.world.MBNWorldTypeThatIsntAWorldtype;
import com.blackout.mythicalbiomesnether.common.world.dimension.nether.MBNNetherBiomeSource;
import com.blackout.mythicalbiomesnether.common.world.feature.blockplacer.MBNBlockPlacerTypes;
import com.blackout.mythicalbiomesnether.config.NetherConfig;
import com.blackout.mythicalbiomesnether.config.WorldConfig;
import com.blackout.mythicalbiomesnether.config.json.MBNJsonConfigHandler;
import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import com.blackout.mythicalbiomesnether.core.MBNItems;
import com.blackout.mythicalbiomesnether.core.world.MBNBiomes;
import com.blackout.mythicalbiomesnether.core.world.MBNDecorators;
import com.blackout.mythicalbiomesnether.core.world.MBNFeatures;
import com.blackout.mythicalbiomesnether.core.world.MBNSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

@Mod("mythicalbiomesnether")
public class MythicalBiomesNether {
    public static final String MOD_ID = "mythicalbiomesnether";
    public static boolean isClient = false;
    public static Logger LOGGER = LogManager.getLogger();
    public static String FILE_PATH = "yeet";

    public static final Path CONFIG_PATH = new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve(MOD_ID))).toPath();

    public static WorldConfig worldConfig = null;

    public static WorldConfig worldConfig(boolean refreshConfig) {
        if (worldConfig == null || refreshConfig) {
            worldConfig = new WorldConfig(CONFIG_PATH.resolve("mbn-world.toml"));
        }
        return worldConfig;
    }

    public static WorldConfig worldConfig() {
        return worldConfig(false);
    }

    public MythicalBiomesNether() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        File dir = new File(CONFIG_PATH.toString());
        if (!dir.exists())
            dir.mkdir();
        worldConfig();
        NetherConfig.loadConfig(NetherConfig.COMMON_CONFIG, CONFIG_PATH.resolve(MOD_ID + "-nether.toml"));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

        MBNBlocks.ITEM_BLOCKS.register(eventBus);
        MBNBlocks.BLOCKS.register(eventBus);
//        MBNBlocks.MINECRAFT_ITEM_BLOCK_OVERRIDES.register(eventBus);
//        MBNBlocks.MINECRAFT_BLOCK_OVERRIDES.register(eventBus);

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.debug("MBN: \"Common Setup\" Event Starting...");
        MBNCreativeTab.init();
        MBNJsonConfigHandler.handleOverWorldConfig(CONFIG_PATH);
        event.enqueueWork(() -> {
            Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "mbnnether"), MBNNetherBiomeSource.MBNNETHERCODEC);
            MBNBiomes.addBiomeEntries();
            MBNBiomes.fillBiomeDictionary();
        });

        LOGGER.info("MBN: \"Common Setup\" Event Complete!");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        isClient = true;
        LOGGER.debug("MBN: \"Client Setup\" Event Starting...");
        MBNCutoutRenders.renderCutOuts();
        LOGGER.info("MBN: \"Client Setup\" Event Complete!");
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            LOGGER.debug("MBN: \"Load Complete Event\" Starting...");
//            BYGCompostables.compostablesBYG();
//            BYGHoeables.hoeablesBYG();
//            MBNFlammables.flammablesBYG();
//            BYGStrippables.strippableLogsBYG();
//            BYGCarvableBlocks.addCarverBlocks();
//            BYGPaths.addBYGPaths();
            cleanMemory();
            LOGGER.info("MBN: \"Load Complete\" Event Complete!");
        });
    }

    //Minimize MBN's ram footprint.
    private static void cleanMemory() {
        MythicalBiomesNether.LOGGER.debug("Cleaning memory...");
        MBNBlocks.flowerPotBlocks = null;
        FILE_PATH = null;
        MythicalBiomesNether.LOGGER.debug("Cleaned memory!");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class MBNRegistries {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            MythicalBiomesNether.LOGGER.debug("MBN: Registering blocks...");
            MBNBlocks.init();
            MBNBlocks.blocksList.forEach(block -> event.getRegistry().register(block));
            MBNBlocks.flowerPotBlocks.forEach(block -> event.getRegistry().register(block));
            MythicalBiomesNether.LOGGER.info("MBN: Blocks registered!");
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            MythicalBiomesNether.LOGGER.debug("MBN: Registering items...");
            MBNItems.init();
            MBNItems.itemsList.forEach(item -> event.getRegistry().register(item));
            MythicalBiomesNether.LOGGER.info("MBN: Items registered!");
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BYGWorldGenRegistries {

        @SubscribeEvent
        public static void registerBiomes(RegistryEvent.Register<Biome> event) {
            MythicalBiomesNether.LOGGER.debug("MBN: Registering biomes...");
            MBNBiomes.init();
            MBNBiomes.biomeList.sort(Comparator.comparingInt(MBNBiomes.PreserveBiomeOrder::getOrderPosition));
            MBNBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));

            MythicalBiomesNether.LOGGER.info("MBN: Biomes registered!");
        }

        @SubscribeEvent
        public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
            MythicalBiomesNether.LOGGER.debug("MBN: Registering decorators...");
            MBNDecorators.init();
            MBNDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
            MythicalBiomesNether.LOGGER.info("MBN: Decorators registered!");
        }

        @SubscribeEvent
        public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
            MythicalBiomesNether.LOGGER.debug("MBN: Registering features...");
            MBNFeatures.init();
            MBNFeatures.features.forEach(feature -> event.getRegistry().register(feature));
            MythicalBiomesNether.LOGGER.info("MBN: Features registered!");
        }

        @SubscribeEvent
        public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
            MythicalBiomesNether.LOGGER.debug("MBN: Registering surface builders...");
            MBNSurfaceBuilders.init();
            MBNSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
            MythicalBiomesNether.LOGGER.info("MBN: Surface builders Registered!");
        }


        @SubscribeEvent
        public static void registerBlockPlacerType(RegistryEvent.Register<BlockPlacerType<?>> event) {
            MythicalBiomesNether.LOGGER.debug("BYG: Registering block placer types...");
            MBNBlockPlacerTypes.init();
            MBNBlockPlacerTypes.types.forEach(type -> event.getRegistry().register(type));
            MythicalBiomesNether.LOGGER.info("BYG: Registering block placer types!");
        }

        //Only for terraforged usage and not player's.
        @SubscribeEvent
        public static void registerWorldtype(RegistryEvent.Register<ForgeWorldType> event) {
            event.getRegistry().register(new MBNWorldTypeThatIsntAWorldtype().setRegistryName(new ResourceLocation(MOD_ID, "world")));
        }
    }
}