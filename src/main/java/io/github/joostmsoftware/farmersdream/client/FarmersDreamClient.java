package io.github.joostmsoftware.farmersdream.client;

import io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks;
import io.github.joostmsoftware.farmersdream.fluid.FarmersDreamFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class FarmersDreamClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FarmersDreamBlocks.PINEAPPLE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FarmersDreamBlocks.CORN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FarmersDreamBlocks.GRANOLA_CROP, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(FarmersDreamFluids.STILL_BIO_FLUID, FarmersDreamFluids.FLOWING_BIO_FLUID,
                new SimpleFluidRenderHandler(
                    new Identifier("minecraft:block/water_still"),
                    new Identifier("minecraft:block/water_flow"),
                0xFF4D3D19
                )
        );

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), FarmersDreamFluids.STILL_BIO_FLUID, FarmersDreamFluids.FLOWING_BIO_FLUID);
    }
}
