package io.github.joostmsoftware.farmersdream.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.joostmsoftware.farmersdream.FarmersDream.GROUP;
import static io.github.joostmsoftware.farmersdream.FarmersDream.MOD_ID;
import static io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks.*;

public class FarmersDreamItems {
    public static final Item CORN_SEEDS = registerItem("corn_seeds", new AliasedBlockItem(CORN_CROP, new FabricItemSettings().group(GROUP)));
    public static final Item CORN = registerItem("corn", new Item(new FabricItemSettings().group(GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f).build())));
    public static final Item GRANOLA_SEEDS = registerItem("granola_seeds", new AliasedBlockItem(GRANOLA_CROP, new FabricItemSettings().group(GROUP)));
    public static final Item GRANOLA = registerItem("granola", new Item(new FabricItemSettings().group(GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f).build())));


    public static final Item PINEAPPLE_SEEDS = registerItem("pineapple_seeds", new AliasedBlockItem(PINEAPPLE_CROP, new FabricItemSettings().group(GROUP)));
    public static final Item PINEAPPLE = registerItem("pineapple", new Item(new FabricItemSettings().group(GROUP).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.6f).build())));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }

    public static void register() {

    }
}
