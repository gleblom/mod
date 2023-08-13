package net.gleb.testmod.world.entity.client;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.world.entity.ModEntityType;
import net.gleb.testmod.world.entity.stand.StandEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntityType.STAND_ENTITY.get(), StandEntity.createMobAttributes().build());
    }
}
