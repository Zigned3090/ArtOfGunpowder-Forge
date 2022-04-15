package mc.art.gunpowder.entity.render;

import mc.art.gunpowder.entity.arrow.ExplodeArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import static mc.art.gunpowder.ModMain.MODID;

public class RenderExplodeArrowEntity extends ArrowRenderer<ExplodeArrowEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/entity/projectile/explode_arrow.png");

    public RenderExplodeArrowEntity(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplodeArrowEntity explodeArrowEntity) {
        return TEXTURE;
    }
}
