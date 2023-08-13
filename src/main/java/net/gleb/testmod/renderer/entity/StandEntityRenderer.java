package net.gleb.testmod.renderer.entity;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.world.entity.stand.StandEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class StandEntityRenderer extends MobRenderer<StandEntity, StandEntityModel<StandEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TestMod.MOD_ID, "textures/entity/stand/stand.png");
    public StandEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new StandEntityModel<>(context.bakeLayer(StandEntityModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(StandEntity p_114482_) {
        return TEXTURE;
    }
}
