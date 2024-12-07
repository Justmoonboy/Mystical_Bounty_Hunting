package net.justmoonboy.mystical_bounty_hunting.item;

import net.justmoonboy.mystical_bounty_hunting.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CELLESTIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CELLESTIUM_TOOL,
            3064, 10f, 4f, 28, () -> Ingredient.of(ModItems.CELLESTIUM_INGOT));

}
