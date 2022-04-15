package mc.art.gunpowder.item;

import mc.art.gunpowder.entity.detonator.Lvl2DetonatorEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Lvl2DetonatorItem extends Item {
    public Lvl2DetonatorItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.getCooldowns().addCooldown(this, 20);
        if (!level.isClientSide) {
            Lvl2DetonatorEntity lvl2DetonatorEntity = new Lvl2DetonatorEntity(level, player);
            lvl2DetonatorEntity.setItem(itemstack);
            lvl2DetonatorEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(lvl2DetonatorEntity);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
