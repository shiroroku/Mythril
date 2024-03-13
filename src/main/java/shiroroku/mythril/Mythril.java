package shiroroku.mythril;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import shiroroku.mythril.Registries.BlockEntityRegistry;
import shiroroku.mythril.Registries.BlockRegistry;
import shiroroku.mythril.Registries.FeatureRegistry;
import shiroroku.mythril.Registries.ItemRegistry;

@Mod(Mythril.MODID)
public class Mythril {

    public static final String MODID = "mythril";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab CREATIVETAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.mythril_ingot.get());
        }
    };

    public Mythril() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(bus);
        BlockRegistry.BLOCKS_GEN.register(bus);
        ItemRegistry.ITEMS.register(bus);
        ItemRegistry.ITEMS_GEN.register(bus);
        ItemRegistry.ITEMS_GEN_HANDHELD.register(bus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
        FeatureRegistry.CONFIGURED_FEATURES.register(bus);
        FeatureRegistry.PLACED_FEATURES.register(bus);
    }

}
