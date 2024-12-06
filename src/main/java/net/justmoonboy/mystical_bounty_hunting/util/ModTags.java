package net.justmoonboy.mystical_bounty_hunting.util;


import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Blocks {

    }

    public static class Items {
        public static final TagKey<Item> WAND_ITEMS = createTag("wand_items");

        private static TagKey<Item>  createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MysticalBountyHunting.MOD_ID,name));
        }
    }
}