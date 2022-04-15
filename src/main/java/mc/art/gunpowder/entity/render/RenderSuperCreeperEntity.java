package mc.art.gunpowder.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import mc.art.gunpowder.entity.creeper.SuperCreeperEntity;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CreeperPowerLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static mc.art.gunpowder.ModMain.MODID;

@OnlyIn(Dist.CLIENT)
public class RenderSuperCreeperEntity extends MobRenderer<SuperCreeperEntity, CreeperModel<SuperCreeperEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/entity/creeper/super_creeper.png");

    public RenderSuperCreeperEntity(EntityRendererProvider.Context manager) {
        super(manager, new CreeperModel<>(manager.bakeLayer(ModelLayers.CREEPER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(SuperCreeperEntity superCreeperEntity) {
        return TEXTURE;
    }

    protected void scale(SuperCreeperEntity superCreeperEntity, PoseStack p_114047_, float p_114048_) {
        float f = superCreeperEntity.getSwelling(p_114048_);
        float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        f *= f;
        f *= f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        p_114047_.scale(f2, f3, f2);
    }

    protected float getWhiteOverlayProgress(SuperCreeperEntity superCreeperEntity, float p_114044_) {
        float f = superCreeperEntity.getSwelling(p_114044_);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
    }

}
