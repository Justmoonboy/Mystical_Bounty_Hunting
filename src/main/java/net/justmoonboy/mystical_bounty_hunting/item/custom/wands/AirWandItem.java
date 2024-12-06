package net.justmoonboy.mystical_bounty_hunting.item.custom.wands;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AirWandItem extends Item implements ProjectileItem {
    private static final int COOLDOWN = 10;


    public AirWandItem(Item.Properties p_326377_) {
        super(p_326377_);
    }

    public InteractionResultHolder<ItemStack> use(Level p_326306_, Player p_326042_, InteractionHand p_326470_) {
        if (!p_326306_.isClientSide()) {
            WindCharge windCharge = new WindCharge(p_326042_, p_326306_, p_326042_.position().x(), p_326042_.getEyePosition().y(), p_326042_.position().z());
            windCharge.shootFromRotation(p_326042_, p_326042_.getXRot(), p_326042_.getYRot(), 0.0F, 1.5F, 1.0F);
            p_326306_.addFreshEntity(windCharge);
        }

        p_326306_.playSound((Player)null, p_326042_.getX(), p_326042_.getY(), p_326042_.getZ(), SoundEvents.WIND_CHARGE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (p_326306_.getRandom().nextFloat() * 0.4F + 0.8F));
        ItemStack itemstack = p_326042_.getItemInHand(p_326470_);
        p_326042_.getCooldowns().addCooldown(this, 10);
        p_326042_.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, p_326306_.isClientSide());
    }

    public Projectile asProjectile(Level p_338589_, Position p_338670_, ItemStack p_338308_, Direction p_338206_) {
        RandomSource randomsource = p_338589_.getRandom();
        double d0 = randomsource.triangle((double)p_338206_.getStepX(), 0.11485000000000001);
        double d1 = randomsource.triangle((double)p_338206_.getStepY(), 0.11485000000000001);
        double d2 = randomsource.triangle((double)p_338206_.getStepZ(), 0.11485000000000001);
        Vec3 vec3 = new Vec3(d0, d1, d2);
        WindCharge windcharge = new WindCharge(p_338589_, p_338670_.x(), p_338670_.y(), p_338670_.z(), vec3);
        windcharge.setDeltaMovement(vec3);
        return windcharge;
    }

    public void shoot(Projectile p_338260_, double p_338763_, double p_338177_, double p_338349_, float p_338273_, float p_338257_) {
    }

    public ProjectileItem.DispenseConfig createDispenseConfig() {
        return DispenseConfig.builder().positionFunction((p_338288_, p_338801_) -> {
            return DispenserBlock.getDispensePosition(p_338288_, 1.0, Vec3.ZERO);
        }).uncertainty(6.6666665F).power(1.0F).overrideDispenseEvent(1051).build();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.mysticalbountyhunting.air_wand.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.mysticalbountyhunting.air_wand"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}