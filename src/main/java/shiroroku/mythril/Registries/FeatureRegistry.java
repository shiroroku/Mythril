package shiroroku.mythril.Registries;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import shiroroku.mythril.Mythril;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class FeatureRegistry {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Mythril.MODID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Mythril.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> mythril_ore_target_list = () -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.mythril_ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.mythril_ore_deepslate.get().defaultBlockState()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> mythril_ore_configured = CONFIGURED_FEATURES.register("mythril_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(mythril_ore_target_list.get(), 8)));
    public static final RegistryObject<PlacedFeature> mythril_ore_placed = PLACED_FEATURES.register("mythril_ore",
            () -> new PlacedFeature(mythril_ore_configured.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-46), VerticalAnchor.absolute(46)))));

    /**
     * From OrePlacements.java
     */
    private static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier2) {
        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }
}
