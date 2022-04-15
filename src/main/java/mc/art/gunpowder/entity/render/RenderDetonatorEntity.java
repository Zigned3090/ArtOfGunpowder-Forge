package mc.art.gunpowder.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import mc.art.gunpowder.ModMain;
import mc.art.gunpowder.entity.detonator.DetonatorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;

public class RenderDetonatorEntity extends EntityRenderer<DetonatorEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(ModMain.MODID ,"textures/entity/projectile/detonator.png");
	private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.25F;
	private final ItemRenderer itemRenderer;
	   private final float scale;
	   private final boolean fullBright;
	   
    public RenderDetonatorEntity(EntityRendererProvider.Context manager) {
        super(manager);
        this.itemRenderer=manager.getItemRenderer();
        this.scale=1.0F;
        this.fullBright=false;

     }
    

    private static final RenderType field_229044_e_ = RenderType.entityCutoutNoCull(TEXTURE);

    public boolean shouldRender(DetonatorEntity p_114491_, Frustum p_114492_, double p_114493_, double p_114494_, double p_114495_) {
        if (!p_114491_.shouldRender(p_114493_, p_114494_, p_114495_)) {
            return false;
        } else if (p_114491_.noCulling) {
            return true;
        } else {
            AABB aabb = p_114491_.getBoundingBoxForCulling().inflate(0.5D);
            if (aabb.hasNaN() || aabb.getSize() == 0.0D) {
                aabb = new AABB(p_114491_.getX() - 2.0D, p_114491_.getY() - 2.0D, p_114491_.getZ() - 2.0D, p_114491_.getX() + 2.0D, p_114491_.getY() + 2.0D, p_114491_.getZ() + 2.0D);
            }

            return p_114492_.isVisible(aabb);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(DetonatorEntity p_110775_1_) {
        return TEXTURE;
    }

    public void render(DetonatorEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (entityIn.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entityIn) < 12.25D)) {
           poseStackIn.pushPose();
           poseStackIn.scale(this.scale, this.scale, this.scale);
           poseStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
           poseStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F));
           this.itemRenderer.renderStatic(entityIn.getItem(), ItemTransforms.TransformType.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY, poseStackIn, bufferIn, entityIn.getId());
           poseStackIn.popPose();
           super.render(entityIn, entityYaw, partialTicks, poseStackIn, bufferIn, packedLightIn);

        }
     }

    private static void vertexRender(VertexConsumer p_229045_0_, Matrix4f p_229045_1_, Matrix3f p_229045_2_, int p_229045_3_, float p_229045_4_, int p_229045_5_, int p_229045_6_, int p_229045_7_) {
        p_229045_0_.vertex(p_229045_1_, p_229045_4_ - 0.5F, (float)p_229045_5_ - 0.25F, 0.0F).color(255, 255, 255, 255).overlayCoords(OverlayTexture.NO_OVERLAY).normal(p_229045_2_, 0.0F, 1.0F, 0.0F).endVertex();
    }

}