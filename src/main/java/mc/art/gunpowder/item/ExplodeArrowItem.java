package mc.art.gunpowder.item;

import mc.art.gunpowder.entity.arrow.ExplodeArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplodeArrowItem extends Item {

    public ExplodeArrowItem(Item.Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
        ExplodeArrowEntity explodeArrowEntity = new ExplodeArrowEntity(p_40513_, p_40515_);
        return explodeArrowEntity;
    }

}
