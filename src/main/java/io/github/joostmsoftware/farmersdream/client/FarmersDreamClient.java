package io.github.joostmsoftware.farmersdream.client;

import io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FarmersDreamClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FarmersDreamBlocks.PINEAPPLE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FarmersDreamBlocks.CORN_CROP, RenderLayer.getCutout());
    }
}
