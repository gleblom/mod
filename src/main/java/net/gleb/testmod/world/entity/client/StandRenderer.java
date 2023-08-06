package net.gleb.testmod.world.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.gleb.testmod.TestMod;
import net.gleb.testmod.world.entity.stand.StandEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class StandRenderer extends GeoEntityRenderer<StandEntity> {
    public StandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StandModel());
        this.shadowRadius = 0.3F;
    }
    public ResourceLocation getTextureLocation(StandEntity standEntity){
        return new ResourceLocation(TestMod.MOD_ID, "textures/entity/star_platinum.png");

    }

    @Override
    public RenderType getRenderType(StandEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        {
            stack.scale(1.0F, 1.0F, 1.0F);
            return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
        }

    }
}
