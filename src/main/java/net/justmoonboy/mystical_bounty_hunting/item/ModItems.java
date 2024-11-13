package net.justmoonboy.mystical_bounty_hunting.item;

import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MysticalBountyHunting.MOD_ID);


    public static final DeferredItem<Item> CELLESTIUM_INGOT = ITEMS.register("cellestium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_CELLESTIUM = ITEMS.register("raw_cellestium",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
