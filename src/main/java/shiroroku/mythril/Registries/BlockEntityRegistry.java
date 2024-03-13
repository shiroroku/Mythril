package shiroroku.mythril.Registries;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import shiroroku.mythril.Blocks.MythrilEnchantingTableEntity;
import shiroroku.mythril.Mythril;

public class BlockEntityRegistry {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Mythril.MODID);

    public static final RegistryObject<BlockEntityType<MythrilEnchantingTableEntity>> mythril_enchanting_table = BLOCK_ENTITIES.register("mythril_enchanting_table", () -> BlockEntityType.Builder.of(MythrilEnchantingTableEntity::new, BlockRegistry.mythril_enchanting_table.get()).build(null));
}
