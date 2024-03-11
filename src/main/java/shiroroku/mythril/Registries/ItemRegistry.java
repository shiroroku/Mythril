package shiroroku.mythril.Registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import shiroroku.mythril.Mythril;

import java.util.function.Supplier;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mythril.MODID);
    public static final DeferredRegister<Item> ITEMS_HANDHELD = DeferredRegister.create(ForgeRegistries.ITEMS, Mythril.MODID);

    public static final RegistryObject<Item> mythril_ingot = ITEMS.register("mythril_ingot", basicItem());
    public static final RegistryObject<Item> mythril_nugget = ITEMS.register("mythril_nugget", basicItem());
    public static final RegistryObject<Item> raw_mythril = ITEMS.register("raw_mythril", basicItem());

    public static Item.Properties defaultProp() {
        return new Item.Properties().tab(Mythril.CREATIVETAB);
    }

    private static Supplier<Item> basicItem() {
        return basicItem(defaultProp());
    }

    private static Supplier<Item> basicItem(Item.Properties properties) {
        return () -> new Item(properties);
    }
}
