package io.github.joostmsoftware.farmersdream.block;

import io.github.joostmsoftware.farmersdream.block.custom.CornCropBlock;
import io.github.joostmsoftware.farmersdream.block.custom.GranolaCropBlock;
import io.github.joostmsoftware.farmersdream.block.custom.PineappleCropBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.joostmsoftware.farmersdream.FarmersDream.MOD_ID;

public class FarmersDreamBlocks {

    public static final Block CORN_CROP = registerCrop("corn_crop", new CornCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block GRANOLA_CROP = registerCrop("granola_crop", new GranolaCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block PINEAPPLE_CROP = registerCrop("pineapple_crop", new PineappleCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    private static Block registerCrop(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static void register(){

    }
}
