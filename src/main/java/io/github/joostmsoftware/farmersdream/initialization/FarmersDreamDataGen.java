package io.github.joostmsoftware.farmersdream.initialization;

import io.github.joostmsoftware.farmersdream.block.custom.CornCropBlock;
import io.github.joostmsoftware.farmersdream.block.custom.GranolaCropBlock;
import io.github.joostmsoftware.farmersdream.block.custom.PineappleCropBlock;
import io.github.joostmsoftware.farmersdream.fluid.FarmersDreamFluids;
import io.github.joostmsoftware.farmersdream.util.FarmersDreamTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static io.github.joostmsoftware.farmersdream.block.FarmersDreamBlocks.*;
import static io.github.joostmsoftware.farmersdream.item.FarmersDreamItems.*;

public class FarmersDreamDataGen implements DataGeneratorEntrypoint {

    private static class FarmersDreamModelGenerator extends FabricModelProvider {

        public FarmersDreamModelGenerator(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateBlockStateModels(@NotNull BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerCrop(PINEAPPLE_CROP, PineappleCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
            blockStateModelGenerator.registerCrop(CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
            blockStateModelGenerator.registerCrop(GRANOLA_CROP, GranolaCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
            blockStateModelGenerator.registerSimpleState(FarmersDreamFluids.BIO_FUEL_BLOCK);
            blockStateModelGenerator.registerItemModel(FarmersDreamFluids.BIO_FUEL_BLOCK);
        }

        @Override
        public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(PINEAPPLE, Models.GENERATED);
            itemModelGenerator.register(CORN, Models.GENERATED);
            itemModelGenerator.register(GRANOLA, Models.GENERATED);
            itemModelGenerator.register(FarmersDreamFluids.BIO_FUEL_BUCKET, Models.GENERATED);
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
            addDrop(GRANOLA_CROP, cropDrops(GRANOLA_CROP, GRANOLA, GRANOLA_SEEDS, BlockStatePropertyLootCondition.builder(GRANOLA_CROP).properties(StatePredicate.Builder.create().exactMatch(PineappleCropBlock.AGE, 7))));

            excludeFromStrictValidation(FarmersDreamFluids.BIO_FUEL_BLOCK);
        }
    }

    private static class FarmersDreamFluidTagProvider extends FabricTagProvider.FluidTagProvider {

        public FarmersDreamFluidTagProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {
            getOrCreateTagBuilder(FarmersDreamTags.BIO_FLUID).add(FarmersDreamFluids.STILL_BIO_FLUID);
            getOrCreateTagBuilder(FarmersDreamTags.COMMON_BIO_FLUID).add(FarmersDreamFluids.STILL_BIO_FLUID);
        }
    }

    private static class FarmersDreamItemTagProvider extends FabricTagProvider.ItemTagProvider {

        public FarmersDreamItemTagProvider(FabricDataGenerator dataGenerator, @Nullable BlockTagProvider blockTagProvider) {
            super(dataGenerator, blockTagProvider);
        }

        @Override
        protected void generateTags() {
            getOrCreateTagBuilder(FarmersDreamTags.COMMON_CORN_CROP).add(CORN);
            getOrCreateTagBuilder(FarmersDreamTags.COMMON_GRANOLA_CROP).add(GRANOLA);
            getOrCreateTagBuilder(FarmersDreamTags.COMMON_PINEAPPLE_CROP).add(PINEAPPLE);
        }
    }

    private static class FarmersDreamBlockTagProvider extends FabricTagProvider.BlockTagProvider {

        public FarmersDreamBlockTagProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {

        }
    }

    @Override
    public void onInitializeDataGenerator(@NotNull FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(FarmersDreamLootTableProvider::new);
        fabricDataGenerator.addProvider(FarmersDreamModelGenerator::new);
        fabricDataGenerator.addProvider(FarmersDreamFluidTagProvider::new);
        FarmersDreamBlockTagProvider blockTagProvider = fabricDataGenerator.addProvider(FarmersDreamBlockTagProvider::new);
        fabricDataGenerator.addProvider(new FarmersDreamItemTagProvider(fabricDataGenerator, blockTagProvider));

    }
}
