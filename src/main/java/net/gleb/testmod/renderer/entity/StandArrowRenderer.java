package net.gleb.testmod.renderer.entity;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.world.entity.projectile.StandArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StandArrowRenderer extends ArrowRenderer<StandArrow> {
    public StandArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(StandArrow standArrow) {
        return new ResourceLocation(
                TestMod.MOD_ID,
                "textures/entity/projectiles/stand_arrow.png");
    }
}
