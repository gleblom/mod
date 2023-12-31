package net.gleb.testmod.item;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.item.custom.ModArmorMaterials;
import net.gleb.testmod.item.custom.StandArrowItem;
import net.gleb.testmod.world.entity.ModEntityType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.CreativeModeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> STAND_ARROW = ITEMS.register("stand_arrow",
            () -> new StandArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), 0));
    public static final RegistryObject<Item> STONE_MASK = ITEMS.register("stone_mask",
            () -> new ArmorItem(ModArmorMaterials.STONE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<SpawnEggItem> STAND_EGG = ITEMS.register("stand_egg",
            () -> new ForgeSpawnEggItem(ModEntityType.STAND_ENTITY,0xF0ABD1, 0xAE4C02, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
