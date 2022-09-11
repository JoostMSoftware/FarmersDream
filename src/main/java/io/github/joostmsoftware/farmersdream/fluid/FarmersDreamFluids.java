package io.github.joostmsoftware.farmersdream.fluid;

import io.github.joostmsoftware.farmersdream.FarmersDream;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.joostmsoftware.farmersdream.FarmersDream.MOD_ID;

public class FarmersDreamFluids {

    public static FlowableFluid STILL_BIO_FLUID;
    public static FlowableFluid FLOWING_BIO_FLUID;
    public static Block BIO_FUEL_BLOCK;
    public static Item BIO_FUEL_BUCKET;

    public static void register() {
        STILL_BIO_FLUID = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "bio_fluid"), new BioFuelFluid.Still());
        FLOWING_BIO_FLUID = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_bio_fluid"), new BioFuelFluid.Flowing());

        BIO_FUEL_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bio_fluid_block"), new FluidBlock(STILL_BIO_FLUID, FabricBlockSettings.copyOf(Blocks.WATER)));
        BIO_FUEL_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bio_fluid_bucket"), new BucketItem(STILL_BIO_FLUID, new FabricItemSettings().group(FarmersDream.GROUP).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
