package net.justmoonboy.mystical_bounty_hunting.util;


import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CELLESTIUM_TOOL = createTag("needs_cellestium_tool");
        public static final TagKey<Block> INCORRECT_FOR_CELLESTIUM_TOOL = createTag("incorrect_for_cellestium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MysticalBountyHunting.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> WAND_ITEMS = createTag("wand_items");

        private static TagKey<Item>  createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MysticalBountyHunting.MOD_ID,name));
        }
    }
}