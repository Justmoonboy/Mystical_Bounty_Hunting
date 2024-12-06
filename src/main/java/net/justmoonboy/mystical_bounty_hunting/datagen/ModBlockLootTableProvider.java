package net.justmoonboy.mystical_bounty_hunting.datagen;

import net.justmoonboy.mystical_bounty_hunting.block.ModBlocks;
import net.justmoonboy.mystical_bounty_hunting.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CELLESTIUM_BLOCK.get());
        dropSelf(ModBlocks.BOUNTY_BOARD.get());

        add(ModBlocks.CELLESTIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CELLESTIUM_ORE.get(), ModItems.RAW_CELLESTIUM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
