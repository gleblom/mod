package net.gleb.testmod.world.entity;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.world.entity.projectile.StandArrow;
import net.gleb.testmod.world.entity.stand.StandEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TestMod.MOD_ID);
    public static  final RegistryObject<EntityType<StandArrow>> STAND_ARROW = ENTITY_TYPES.register("stand_arrow",
            () -> EntityType.Builder.<StandArrow>of(StandArrow::new, MobCategory.MISC).sized(0.5F,
                    05F).clientTrackingRange(4).updateInterval(20).build(new
                    ResourceLocation(TestMod.MOD_ID, "stand_arrow").toString()));
    public static  final RegistryObject<EntityType<StandEntity>> STAND = ENTITY_TYPES.register("stand",
            () -> EntityType.Builder.of(StandEntity::new, MobCategory.CREATURE).sized(0.5F,
                    05F).clientTrackingRange(4).updateInterval(20).build(new
                    ResourceLocation(TestMod.MOD_ID, "stand_arrow").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
