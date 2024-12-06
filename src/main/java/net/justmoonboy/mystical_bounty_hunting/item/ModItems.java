package net.justmoonboy.mystical_bounty_hunting.item;

import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.justmoonboy.mystical_bounty_hunting.item.custom.AppleJuiceItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.ScrumpyItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.AirWandItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.EarthWandItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.FireWandItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.WaterWandItem;
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
    public static final DeferredItem<Item> CELLESTIUM_NUGGET = ITEMS.register("cellestium_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> AIRWAND = ITEMS.register("air_wand",
            () -> new AirWandItem(new Item.Properties()));
    public static final DeferredItem<Item> EARTHWAND = ITEMS.register("earth_wand",
            () -> new EarthWandItem(new Item.Properties()));
    public static final DeferredItem<Item> FIREWAND = ITEMS.register("fire_wand",
            () -> new FireWandItem(new Item.Properties()));
    public static final DeferredItem<Item> WATERWAND = ITEMS.register("water_wand",
            () -> new WaterWandItem(new Item.Properties()));


    public static final DeferredItem<Item> GLOWBULB = ITEMS.register("glow_bulb",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GLOWBULB)));
    public static final DeferredItem<Item> SCRUMPY = ITEMS.register("scrumpy",
            () -> new ScrumpyItem(new Item.Properties().food(ModFoodProperties.SCRUMPY)));
    public static final DeferredItem<Item> APPLEJUICE = ITEMS.register("apple_juice",
            () -> new AppleJuiceItem(new Item.Properties().food(ModFoodProperties.APPLEJUICE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
