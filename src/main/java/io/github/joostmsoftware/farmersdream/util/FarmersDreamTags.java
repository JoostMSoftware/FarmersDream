package io.github.joostmsoftware.farmersdream.util;

import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.joostmsoftware.farmersdream.FarmersDream.MOD_ID;

public class FarmersDreamTags {

    public static final TagKey<Fluid> BIO_FLUID = TagKey.of(Registry.FLUID_KEY, new Identifier(MOD_ID, "bio_fluid"));
    public static final TagKey<Fluid> COMMON_BIO_FLUID = TagKey.of(Registry.FLUID_KEY, new Identifier("c:bio_fluid"));

    public static void registerTags() {

    }
}
