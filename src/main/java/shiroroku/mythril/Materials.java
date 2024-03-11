package shiroroku.mythril;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import shiroroku.mythril.Registries.ItemRegistry;

import java.util.function.Supplier;

public class Materials {

    public static final ForgeTier MYTHRIL = new ForgeTier(2, 800, 7.0F, 2.5F, 20, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemRegistry.mythril_ingot.get()));
    public static final ArmorMaterial MYTHRIL_ARMOR = armorBuilder("mythril", 25, new int[]{3, 5, 7, 3}, 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.of(ItemRegistry.mythril_ingot.get()));

    private static final int[] ARMOR_BASE_DURABILITIES = new int[]{13, 15, 16, 11};

    private static ArmorMaterial armorBuilder(String pName, int pDurabilityMultiplier, int[] pSlotProtections, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        return new ArmorMaterial() {
            @Override
            public int getDurabilityForSlot(EquipmentSlot pSlot) {
                return ARMOR_BASE_DURABILITIES[pSlot.getIndex()] * pDurabilityMultiplier;
            }

            @Override
            public int getDefenseForSlot(EquipmentSlot pSlot) {
                return pSlotProtections[pSlot.getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return pEnchantmentValue;
            }

            @Override
            public SoundEvent getEquipSound() {
                return pSound;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return pRepairIngredient.get();
            }

            @Override
            public String getName() {
                return Mythril.MODID + ":" + pName;
            }

            @Override
            public float getToughness() {
                return pToughness;
            }

            @Override
            public float getKnockbackResistance() {
                return pKnockbackResistance;
            }
        };
    }
}
