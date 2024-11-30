package net.justmoonboy.mystical_bounty_hunting.item.custom.wands;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;;

public class FireWandItem extends Item implements ProjectileItem {


    private static final int COOLDOWN = 10;  // Optional: Cooldown for using the wand.


    public FireWandItem(Properties properties) {
        super(properties);
    }

    private void playSound(Level level, Position position) {
        level.playSound(null, position.x(), position.y(), position.z(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }


    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) {
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }

        Vec3 lookDirection = player.getViewVector(1.0F).normalize();

        Vec3 spawnPosition = player.position().add(lookDirection.x * 1.5, lookDirection.y + 1.5, lookDirection.z * 1.5);
        SmallFireball smallFireball = new SmallFireball(level, lookDirection.x, lookDirection.y, lookDirection.z, lookDirection);

        smallFireball.setPos(spawnPosition.x, spawnPosition.y, spawnPosition.z);

        level.addFreshEntity(smallFireball);


        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), false);
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {

        return null;
    }
}