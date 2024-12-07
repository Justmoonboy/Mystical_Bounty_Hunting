package net.justmoonboy.mystical_bounty_hunting.datagen;


import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.justmoonboy.mystical_bounty_hunting.item.ModItems;
import net.justmoonboy.mystical_bounty_hunting.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MysticalBountyHunting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.WAND_ITEMS)
                .add(ModItems.EARTHWAND.get())
                .add(ModItems.AIRWAND.get())
                .add(ModItems.FIREWAND.get())
                .add(ModItems.WATERWAND.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.CELLESTIUM_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.CELLESTIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.CELLESTIUM_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.CELLESTIUM_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.CELLESTIUM_HOE.get());

    }
}