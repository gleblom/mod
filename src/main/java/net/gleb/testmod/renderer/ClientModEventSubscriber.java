package net.gleb.testmod.renderer;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.renderer.entity.StandArrowRenderer;
import net.gleb.testmod.world.entity.ModEntityType;
import net.gleb.testmod.world.entity.stand.StandEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientModEventSubscriber {
    public ClientModEventSubscriber(){

    }
    @SubscribeEvent
    public static void registerArrowModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }
    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityType.STAND_ARROW.get(), StandArrowRenderer::new);
    }
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntityType.STAND.get(), StandEntity.createMobAttributes().build());
    }
}
