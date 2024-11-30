package net.justmoonboy.mystical_bounty_hunting.item.custom.wands;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

import java.util.Map;

public class WaterWandItem extends Item {
    private static final int COOLDOWN = 20;
    private static final Map<Block, Block> WATER_WAND_MAP =
            Map.of(
                    Blocks.MUD, Blocks.DIRT,
                    Blocks.PACKED_MUD, Blocks.DIRT,
                    Blocks.ICE, Blocks.PACKED_ICE,
                    Blocks.BLUE_ICE, Blocks.WATER,
                    Blocks.PACKED_ICE, Blocks.BLUE_ICE,
                    Blocks.FROSTED_ICE, Blocks.WATER,
                    Blocks.SNOW_BLOCK, Blocks.WATER,
                    Blocks.SNOW, Blocks.WATER,
                    Blocks.POWDER_SNOW, Blocks.WATER
            );

    public WaterWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(WATER_WAND_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), WATER_WAND_MAP.get(clickedBlock).defaultBlockState());
            }

        }

        return super.useOn(context);
    }
}