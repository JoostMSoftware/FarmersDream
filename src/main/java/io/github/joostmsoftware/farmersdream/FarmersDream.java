package io.github.joostmsoftware.farmersdream;

import io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks;
import io.github.joostmsoftware.farmersdream.item.FarmersDreamItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FarmersDream implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Farmers Dream");

	public static final String MOD_ID = "farmersdream";
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"), ()-> new ItemStack(Items.WHEAT_SEEDS));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		FarmersDreamItems.register();
		FarmersDreamBlocks.register();

		LOGGER.info("Hello Fabric world!");
	}
}
