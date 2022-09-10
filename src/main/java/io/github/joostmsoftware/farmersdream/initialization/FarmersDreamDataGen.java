package io.github.joostmsoftware.farmersdream.initialization;

import io.github.joostmsoftware.farmersdream.block.custom.CornCropBlock;
import io.github.joostmsoftware.farmersdream.block.custom.PineappleCropBlock;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

import static io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks.CORN_CROP;
import static io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks.PINEAPPLE_CROP;
import static io.github.joostmsoftware.farmersdream.item.FarmersDreamItems.*;

public class FarmersDreamDataGen implements DataGeneratorEntrypoint {

    private static class FarmersDreamModelGenerator extends FabricModelProvider {

        public FarmersDreamModelGenerator(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerCrop(PINEAPPLE_CROP, PineappleCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
            blockStateModelGenerator.registerCrop(CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(PINEAPPLE, Models.GENERATED);
            itemModelGenerator.register(CORN, Models.GENERATED);
        }
    }

    private static class FarmersDreamLootTableProvider extends FabricBlockLootTableProvider {

        protected FarmersDreamLootTableProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateBlockLootTables() {
            addDrop(PINEAPPLE_CROP, cropDrops(PINEAPPLE_CROP, PINEAPPLE, PINEAPPLE_SEEDS, BlockStatePropertyLootCondition.builder(PINEAPPLE_CROP).properties(StatePredicate.Builder.create().exactMatch(PineappleCropBlock.AGE, 6))));
            addDrop(CORN_CROP, cropDrops(CORN_CROP, CORN, CORN_SEEDS, BlockStatePropertyLootCondition.builder(CORN_CROP).properties(StatePredicate.Builder.create().exactMatch(PineappleCropBlock.AGE, 6))));
        }
    }

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(FarmersDreamModelGenerator::new);
        fabricDataGenerator.addProvider(FarmersDreamLootTableProvider::new);
    }
}
