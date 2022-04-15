package mc.art.gunpowder.entity.creeper;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class SuperCreeperSwellGoal extends Goal {
    private final SuperCreeperEntity superCreeperEntity;
    @Nullable
    private LivingEntity target;

    public SuperCreeperSwellGoal(SuperCreeperEntity superCreeperEntity) {
        this.superCreeperEntity = superCreeperEntity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.superCreeperEntity.getTarget();
        return this.superCreeperEntity.getSwellDir() > 0 || livingentity != null && this.superCreeperEntity.distanceToSqr(livingentity) < 9.0D;
    }

    public void start() {
        this.superCreeperEntity.getNavigation().stop();
        this.target = this.superCreeperEntity.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.superCreeperEntity.setSwellDir(-1);
        } else if (this.superCreeperEntity.distanceToSqr(this.target) > 49.0D) {
            this.superCreeperEntity.setSwellDir(-1);
        } else if (!this.superCreeperEntity.getSensing().hasLineOfSight(this.target)) {
            this.superCreeperEntity.setSwellDir(-1);
        } else {
            this.superCreeperEntity.setSwellDir(1);
        }
    }
}
