package net.justmoonboy.mystical_bounty_hunting.item;

import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.justmoonboy.mystical_bounty_hunting.item.custom.AppleJuiceItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.ScrumpyItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.AirWandItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.EarthWandItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.FireWandItem;
import net.justmoonboy.mystical_bounty_hunting.item.custom.wands.WaterWandItem;
import net.minecraft.world.item.*;
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
    public static final DeferredItem<Item> SPECIAL_STICK = ITEMS.register("special_stick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MYSTICAL_FABRIC = ITEMS.register("mystical_fabric",
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

    public static final DeferredItem<SwordItem> CELLESTIUM_SWORD = ITEMS.register("cellestium_sword",
            () -> new SwordItem(ModToolTiers.CELLESTIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CELLESTIUM, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> CELLESTIUM_PICKAXE = ITEMS.register("cellestium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CELLESTIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CELLESTIUM, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> CELLESTIUM_SHOVEL = ITEMS.register("cellestium_shovel",
            () -> new ShovelItem(ModToolTiers.CELLESTIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CELLESTIUM, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> CELLESTIUM_AXE = ITEMS.register("cellestium_axe",
            () -> new AxeItem(ModToolTiers.CELLESTIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CELLESTIUM, 6f, -3.2f))));
    public static final DeferredItem<HoeItem> CELLESTIUM_HOE = ITEMS.register("cellestium_hoe",
            () -> new HoeItem(ModToolTiers.CELLESTIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CELLESTIUM, 0f, -3.0f))));

    public static final DeferredItem<ArmorItem> CELLESTIUM_HELMET = ITEMS.register("cellestium_helmet",
            () -> new ArmorItem(ModArmorMaterials.CELLESTIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(38))));
    public static final DeferredItem<ArmorItem> CELLESTIUM_CHESTPLATE = ITEMS.register("cellestium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CELLESTIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(38))));
    public static final DeferredItem<ArmorItem> CELLESTIUM_LEGGINGS = ITEMS.register("cellestium_leggings",
            () -> new ArmorItem(ModArmorMaterials.CELLESTIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(38))));
    public static final DeferredItem<ArmorItem> CELLESTIUM_BOOTS = ITEMS.register("cellestium_boots",
            () -> new ArmorItem(ModArmorMaterials.CELLESTIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(38))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
