package shiroroku.mythril;

import com.mojang.logging.LogUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import shiroroku.mythril.Registries.ItemRegistry;

@Mod(Mythril.MODID)
public class Mythril {

    public static final String MODID = "mythril";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ForgeTier MYTHRIL = new ForgeTier(2, 800, 7.0F, 2.5F, 20, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemRegistry.mythril_ingot.get()));

    public static final CreativeModeTab CREATIVETAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.mythril_ingot.get());
        }
    };

    public Mythril() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(bus);
        ItemRegistry.ITEMS_HANDHELD.register(bus);
    }

}
