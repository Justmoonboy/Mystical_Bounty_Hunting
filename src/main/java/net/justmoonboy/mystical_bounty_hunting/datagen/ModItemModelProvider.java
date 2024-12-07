package net.justmoonboy.mystical_bounty_hunting.datagen;

import net.justmoonboy.mystical_bounty_hunting.MysticalBountyHunting;
import net.justmoonboy.mystical_bounty_hunting.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MysticalBountyHunting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CELLESTIUM_INGOT.get());
        basicItem(ModItems.RAW_CELLESTIUM.get());
        basicItem(ModItems.CELLESTIUM_NUGGET.get());

        basicItem(ModItems.SCRUMPY.get());
        basicItem(ModItems.APPLEJUICE.get());
        basicItem(ModItems.GLOWBULB.get());

        handheldItem(ModItems.AIRWAND.get());
        handheldItem(ModItems.EARTHWAND.get());
        handheldItem(ModItems.FIREWAND.get());
        handheldItem(ModItems.WATERWAND.get());
        handheldItem(ModItems.CELLESTIUM_SWORD.get());
        handheldItem(ModItems.CELLESTIUM_PICKAXE.get());
        handheldItem(ModItems.CELLESTIUM_AXE.get());
        handheldItem(ModItems.CELLESTIUM_SHOVEL.get());
        handheldItem(ModItems.CELLESTIUM_HOE.get());
    }
}
