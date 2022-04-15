package mc.art.gunpowder.entity.arrow;

import mc.art.gunpowder.entity.ModEntityType;
import mc.art.gunpowder.listener.ItemListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ExplodeArrowEntity extends AbstractArrow {

    public ExplodeArrowEntity(EntityType<? extends ExplodeArrowEntity> p_36858_, Level p_36859_) {
        super(p_36858_, p_36859_);
    }

    public ExplodeArrowEntity(Level p_36861_, double p_36862_, double p_36863_, double p_36864_) {
        super(ModEntityType.EXPLODE_ARROW_ENTITY.get(), p_36862_, p_36863_, p_36864_, p_36861_);
    }

    public ExplodeArrowEntity(Level p_36866_, LivingEntity p_36867_) {
        super(ModEntityType.EXPLODE_ARROW_ENTITY.get(), p_36867_, p_36866_);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemListener.EXPLODE_ARROW_ITEM.get());
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(!this.level.isClientSide) {
            this.level.explode((Entity) null, this.getX(), this.getY(), this.getZ(), 4.0F, true,  Explosion.BlockInteraction.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if(hitResult.getType() != HitResult.Type.MISS) {
            level.explode(this, getX(), getY(), getZ(), 4, true, Explosion.BlockInteraction.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }

}
