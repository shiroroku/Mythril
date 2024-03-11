package shiroroku.mythril.Registries;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import shiroroku.mythril.Materials;
import shiroroku.mythril.Mythril;

import java.util.function.Supplier;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mythril.MODID);
    public static final DeferredRegister<Item> ITEMS_GEN = DeferredRegister.create(ForgeRegistries.ITEMS, Mythril.MODID);
    public static final DeferredRegister<Item> ITEMS_GEN_HANDHELD = DeferredRegister.create(ForgeRegistries.ITEMS, Mythril.MODID);

    public static final RegistryObject<Item> mythril_ingot = ITEMS_GEN.register("mythril_ingot", basicItem());
    public static final RegistryObject<Item> mythril_nugget = ITEMS_GEN.register("mythril_nugget", basicItem());
    public static final RegistryObject<Item> raw_mythril = ITEMS_GEN.register("raw_mythril", basicItem());

    public static final RegistryObject<Item> mythril_axe = ITEMS_GEN_HANDHELD.register("mythril_axe", () -> new AxeItem(Materials.MYTHRIL, 6.0F, -3.1F, defaultProp()));
    public static final RegistryObject<Item> mythril_hoe = ITEMS_GEN_HANDHELD.register("mythril_hoe", () -> new HoeItem(Materials.MYTHRIL, -2, -1.0F, defaultProp()));
    public static final RegistryObject<Item> mythril_pickaxe = ITEMS_GEN_HANDHELD.register("mythril_pickaxe", () -> new PickaxeItem(Materials.MYTHRIL, 1, -2.8F, defaultProp()));
    public static final RegistryObject<Item> mythril_shovel = ITEMS_GEN_HANDHELD.register("mythril_shovel", () -> new ShovelItem(Materials.MYTHRIL, 1.5F, -3.0F, defaultProp()));
    public static final RegistryObject<Item> mythril_sword = ITEMS_GEN_HANDHELD.register("mythril_sword", () -> new SwordItem(Materials.MYTHRIL, 3, -2.4F, defaultProp()));

    public static final RegistryObject<Item> mythril_boots = ITEMS_GEN.register("mythril_boots", () -> new ArmorItem(Materials.MYTHRIL_ARMOR, EquipmentSlot.FEET, defaultProp()));
    public static final RegistryObject<Item> mythril_chestplate = ITEMS_GEN.register("mythril_chestplate", () -> new ArmorItem(Materials.MYTHRIL_ARMOR, EquipmentSlot.CHEST, defaultProp()));
    public static final RegistryObject<Item> mythril_helmet = ITEMS_GEN.register("mythril_helmet", () -> new ArmorItem(Materials.MYTHRIL_ARMOR, EquipmentSlot.HEAD, defaultProp()));
    public static final RegistryObject<Item> mythril_leggings = ITEMS_GEN.register("mythril_leggings", () -> new ArmorItem(Materials.MYTHRIL_ARMOR, EquipmentSlot.LEGS, defaultProp()));

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
