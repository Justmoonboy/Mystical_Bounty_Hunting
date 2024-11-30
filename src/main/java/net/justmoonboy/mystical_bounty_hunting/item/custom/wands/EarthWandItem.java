package net.justmoonboy.mystical_bounty_hunting.item.custom.wands;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class EarthWandItem extends Item {
    private static final int COOLDOWN = 20;
    private static final Map<Block, Block> EARTH_WAND_MAP =
            Map.of(
                    Blocks.STONE, Blocks.AIR,
                    Blocks.GRASS_BLOCK, Blocks.AIR,
                    Blocks.DIRT, Blocks.AIR,
                    Blocks.DEEPSLATE, Blocks.AIR
            );

    public EarthWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(EARTH_WAND_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), EARTH_WAND_MAP.get(clickedBlock).defaultBlockState());
            }

        }

        return super.useOn(context);
    }
}