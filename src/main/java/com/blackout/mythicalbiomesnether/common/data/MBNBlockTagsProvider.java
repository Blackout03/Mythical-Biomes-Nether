package com.blackout.mythicalbiomesnether.common.data;

import java.nio.file.Path;

import com.blackout.mythicalbiomesnether.core.MBNBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class MBNBlockTagsProvider extends TagsProvider<Block> {
    @Deprecated
    public MBNBlockTagsProvider(DataGenerator p_i48256_1_) {
        super(p_i48256_1_, Registry.BLOCK);
    }
    public MBNBlockTagsProvider(DataGenerator p_i48256_1_, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(p_i48256_1_, Registry.BLOCK, modId, existingFileHelper);
    }

    protected void addTags() {
        this.tag(BlockTags.MUSHROOM_GROW_BLOCK).add(MBNBlocks.VERDE_NYLIUM.get());
    }

    protected Path getPath(ResourceLocation p_200431_1_) {
        return this.generator.getOutputFolder().resolve("data/" + p_200431_1_.getNamespace() + "/tags/blocks/" + p_200431_1_.getPath() + ".json");
    }

    public String getName() {
        return "Block Tags";
    }
}
