package io.github.joostmsoftware.farmersdream.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

import static io.github.joostmsoftware.farmersdream.item.FarmersDreamItems.GRANOLA_SEEDS;

public class GranolaCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age", 0, 7);

    public GranolaCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return GRANOLA_SEEDS;
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
