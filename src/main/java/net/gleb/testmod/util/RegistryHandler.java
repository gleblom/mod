package net.gleb.testmod.util;

import net.gleb.testmod.TestMod;
import net.gleb.testmod.item.ModItems;
import net.gleb.testmod.item.custom.StandArrowItem;
import net.gleb.testmod.world.entity.ModEntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);
    public static void init(){
        ModItems.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Item> STAND_ARROW = ITEMS.register("stand_arrow",
            () -> new StandArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC),1));

}
