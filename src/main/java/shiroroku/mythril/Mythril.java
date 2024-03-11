package shiroroku.mythril;

import com.mojang.logging.LogUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import shiroroku.mythril.Registries.BlockRegistry;
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
        ItemRegistry.ITEMS.register(bus);
        ItemRegistry.ITEMS_GEN.register(bus);
        ItemRegistry.ITEMS_GEN_HANDHELD.register(bus);
    }

}
