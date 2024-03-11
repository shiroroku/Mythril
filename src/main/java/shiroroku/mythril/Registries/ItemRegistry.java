package shiroroku.mythril.Registries;

import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> mythril_axe = ITEMS_HANDHELD.register("mythril_axe", () -> new AxeItem(Mythril.MYTHRIL, 6.0F, -3.1F, defaultProp()));
    public static final RegistryObject<Item> mythril_hoe = ITEMS_HANDHELD.register("mythril_hoe", () -> new HoeItem(Mythril.MYTHRIL, -2, -1.0F, defaultProp()));
    public static final RegistryObject<Item> mythril_pickaxe = ITEMS_HANDHELD.register("mythril_pickaxe", () -> new PickaxeItem(Mythril.MYTHRIL, 1, -2.8F, defaultProp()));
    public static final RegistryObject<Item> mythril_shovel = ITEMS_HANDHELD.register("mythril_shovel", () -> new ShovelItem(Mythril.MYTHRIL, 1.5F, -3.0F, defaultProp()));
    public static final RegistryObject<Item> mythril_sword = ITEMS_HANDHELD.register("mythril_sword", () -> new SwordItem(Mythril.MYTHRIL, 3, -2.4F, defaultProp()));

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
