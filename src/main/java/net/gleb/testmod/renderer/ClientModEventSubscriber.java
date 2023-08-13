package net.gleb.testmod.renderer;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.renderer.entity.StandArrowRenderer;
import net.gleb.testmod.renderer.entity.StandEntityModel;
import net.gleb.testmod.renderer.entity.StandEntityRenderer;
import net.gleb.testmod.world.entity.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientModEventSubscriber {
    public ClientModEventSubscriber(){

    }
    @SubscribeEvent
    public static void registerArrowModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(StandEntityModel.LAYER_LOCATION, StandEntityModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityType.STAND_ARROW.get(), StandArrowRenderer::new);
        event.registerEntityRenderer(ModEntityType.STAND_ENTITY.get(), StandEntityRenderer::new);
    }
}
