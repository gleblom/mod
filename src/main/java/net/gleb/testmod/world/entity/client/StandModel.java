package net.gleb.testmod.world.entity.client;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.world.entity.stand.StandEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StandModel extends AnimatedGeoModel<StandEntity> {
    @Override
    public ResourceLocation getModelResource(StandEntity object) {
        return new ResourceLocation(TestMod.MOD_ID, "geo/botarium.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StandEntity object) {
        return new ResourceLocation(TestMod.MOD_ID, "textures/entity/stand/botarium.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StandEntity animatable) {
        return new ResourceLocation(TestMod.MOD_ID, "animations/geo/botarium.animation.json");
    }
}
