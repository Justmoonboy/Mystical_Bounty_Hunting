package net.justmoonboy.mystical_bounty_hunting.item.custom.wands;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class FireWandItem extends Item implements ProjectileItem {
    private static final int COOLDOWN = 10;
    public FireWandItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        return null;
    }

    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        RandomSource randomsource = level.getRandom();
        double d0 = randomsource.triangle((double)direction.getStepX(), 0.11485000000000001);
        double d1 = randomsource.triangle((double)direction.getStepY(), 0.11485000000000001);
        double d2 = randomsource.triangle((double)direction.getStepZ(), 0.11485000000000001);
        Vec3 vec3 = new Vec3(d0, d1, d2);
        SmallFireball smallfireball = new SmallFireball(level, pos.x(), pos.y(), pos.z(), vec3.normalize());
        smallfireball.setItem(stack);
        return smallfireball;
    }

    public void shoot(Projectile projectile, double x, double y, double z, float velocity, float inaccuracy) {
    }

    public ProjectileItem.DispenseConfig createDispenseConfig() {
        return DispenseConfig.builder().positionFunction((p_338834_, p_338717_) -> {
            return DispenserBlock.getDispensePosition(p_338834_, 1.0, Vec3.ZERO);
        }).uncertainty(6.6666665F).power(1.0F).overrideDispenseEvent(1018).build();
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_FIRECHARGE_ACTIONS.contains(itemAbility);
    }
}
