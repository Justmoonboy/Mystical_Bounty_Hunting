package net.justmoonboy.mystical_bounty_hunting.item;

import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.justmoonboy.mystical_bounty_hunting.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MysticalBountyHunting.MOD_ID);

    public static final Supplier<CreativeModeTab> CELLESTIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register("cellestium_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CELLESTIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.mysticalbountyhunting.mysticalbountyhunting"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CELLESTIUM_INGOT);
                        output.accept(ModItems.RAW_CELLESTIUM);
                        output.accept(ModBlocks.CELLESTIUM_BLOCK);
                        output.accept(ModBlocks.CELLESTIUM_ORE);
                    }).build());


    public static void  register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}