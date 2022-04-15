package mc.art.gunpowder.entity.detonator;

import io.netty.buffer.Unpooled;
import mc.art.gunpowder.entity.ModEntityType;
import mc.art.gunpowder.listener.ItemListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class Lvl2DetonatorEntity extends ThrowableItemProjectile {
    private double damage;

    public Lvl2DetonatorEntity(EntityType<?> p_37473_, Level p_37474_) {
        super((EntityType<? extends Lvl2DetonatorEntity>)p_37473_, p_37474_);
        this.damage=8.0D;
    }

    public Lvl2DetonatorEntity(Level p_37481_, LivingEntity p_37482_) {
        super(ModEntityType.LVL_2_DETONATOR_ENTITY.get(), p_37482_, p_37481_);
    }

    public Lvl2DetonatorEntity(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
        super(ModEntityType.LVL_2_DETONATOR_ENTITY.get(), p_37477_, p_37478_, p_37479_, p_37476_);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemListener.DETONATOR_ITEM.get();
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        FriendlyByteBuf pack = new FriendlyByteBuf(Unpooled.buffer());
        pack.writeDouble(getX());
        pack.writeDouble(getY());
        pack.writeDouble(getZ());
        pack.writeInt(getId());
        pack.writeUUID(getUUID());

        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(!this.level.isClientSide) {
            this.level.explode((Entity) null, this.getX(), this.getY(), this.getZ(), 7.0F, true, Explosion.BlockInteraction.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if(hitResult.getType() != HitResult.Type.MISS) {
            level.explode(this, getX(), getY(), getZ(),7.0F, true, Explosion.BlockInteraction.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }

}
