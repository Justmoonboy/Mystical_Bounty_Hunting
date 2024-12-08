package net.justmoonboy.mystical_bounty_hunting.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties extends ModItems {
    public static final FoodProperties GLOWBULB = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400), 1).build();

    public static final FoodProperties SCRUMPY = new FoodProperties.Builder().nutrition(5).saturationModifier(2f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1000, 5), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 7), 1).build();

    public static final FoodProperties APPLEJUICE = new FoodProperties.Builder().nutrition(5).saturationModifier(2f).build();
}