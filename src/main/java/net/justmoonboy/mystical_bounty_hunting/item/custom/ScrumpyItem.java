package net.justmoonboy.mystical_bounty_hunting.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import java.util.List;

public class ScrumpyItem extends Item {
    public static final FoodProperties SCRUMPY = new FoodProperties.Builder().nutrition(5).saturationModifier(2f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1000, 7), 1).build();

    public ScrumpyItem(Properties properties) {
        super(properties);
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.mysticalbountyhunting.scrumpy.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.mysticalbountyhunting.scrumpy"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
