package io.github.joostmsoftware.farmersdream.util;

import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FarmersDreamTags {

    public static final TagKey<Fluid> BIO_FUEL_FLUID = TagKey.of(Registry.FLUID_KEY, new Identifier("farmersdream:bio_fluid"));

    public static void registerTags() {

    }
}
