package com.blackout.mythicalbiomesnether.config.json;

import com.blackout.mythicalbiomesnether.MythicalBiomesNether;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.blackout.mythicalbiomesnether.common.world.biome.MBNBiome;
import com.blackout.mythicalbiomesnether.common.world.biome.MBNSubBiome;
import com.blackout.mythicalbiomesnether.config.json.biomedata.BiomeDataListHolder;
import com.blackout.mythicalbiomesnether.config.json.subbiomedata.SubBiomeDataListHolder;
import com.blackout.mythicalbiomesnether.config.json.subbiomedata.SubBiomeDataListHolderSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class MBNJsonConfigHandler {
    //TODO: Handle per world load and allow datapack values.
    public static void handleOverWorldConfig(Path path) {
        File dir = new File(path.toString());
        if (!dir.exists())
            dir.mkdirs();

        try {
            handleMBNSubBiomesJSONConfig(path.resolve(MythicalBiomesNether.MOD_ID + "-sub-biomes.json"));
        } catch (IllegalStateException e) {
            throw new IllegalStateException("nmb-sub-biomes.json failed to load. To quickly fix this error, delete this file and let it reset.");
        }

        try {
            handleMBNBiomesJSONConfig(path.resolve(MythicalBiomesNether.MOD_ID + "-biomes.json"));
        } catch (IllegalStateException e) {
            throw new IllegalStateException("nmb-biomes.json failed to load. To quickly fix this error, delete this file and let it reset.");
        }

        BiomeDataListHolder.fillBiomeLists();
        SubBiomeDataListHolder.fillBiomeLists();
    }

    public static void handleMBNBiomesJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new com.blackout.mythicalbiomesnether.config.json.biomedata.BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            BiomeDataListHolder.createDefaults();
            createMBNBiomesJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            BiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, BiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                MBNBiome.biomeData = biomeDataListHolder.getBiomeData();
            else
                MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "-biomes.json could not be read");

        } catch (IOException e) {
            MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "-biomes.json could not be read");
        }
    }

    public static void createMBNBiomesJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new com.blackout.mythicalbiomesnether.config.json.biomedata.BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new BiomeDataListHolder(MBNBiome.biomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "-biomes.json could not be created");
        }
    }


    public static void handleMBNSubBiomesJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubBiomeDataListHolder.class, new SubBiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            SubBiomeDataListHolder.createDefaults();
            createMBNSubBiomesJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            SubBiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, SubBiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                MBNSubBiome.subBiomeData = biomeDataListHolder.getSubBiomeData();
            else
                MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "-sub-biomes.json could not be read");

        } catch (IOException e) {
            MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "-sub-biomes.json could not be read");
        }
    }

    public static void createMBNSubBiomesJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubBiomeDataListHolder.class, new SubBiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new SubBiomeDataListHolder(MBNSubBiome.subBiomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
            MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "-sub-biomes.json could not be created");
        }
    }


    public static void createReadMe(Path path) {
        final File README_FILE = new File(String.valueOf(path));
        String text = "If you need help understanding what the nmb-biomes or nmb-sub-biomes configs allow you to do, please watch this video: https://youtu.be/iq0q09O7ZYo\n\nIf you need help with datapacking, please watch this: https://youtu.be/TF_p8OeB-hc";
        if (!README_FILE.exists()) {
            try {
                Files.write(path, text.getBytes());
            } catch (IOException e) {
                MythicalBiomesNether.LOGGER.error(MythicalBiomesNether.MOD_ID + "'s README.txt could not be created");
            }
        }
    }
}