package shiroroku.mythril.Registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import shiroroku.mythril.Blocks.MythrilEnchantingTable;
import shiroroku.mythril.Mythril;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mythril.MODID);
    public static final DeferredRegister<Block> BLOCKS_GEN = DeferredRegister.create(ForgeRegistries.BLOCKS, Mythril.MODID);

    public static final RegistryObject<Block> mythril_block = regBlockItem(BLOCKS_GEN, "mythril_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> mythril_ore = regBlockItem(BLOCKS_GEN, "mythril_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> mythril_ore_deepslate = regBlockItem(BLOCKS_GEN, "mythril_ore_deepslate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> mythril_enchanting_table = regBlockItem(BLOCKS, "mythril_enchanting_table", () -> new MythrilEnchantingTable(BlockBehaviour.Properties.copy(Blocks.ENCHANTING_TABLE)));

    private static <I extends Block> RegistryObject<I> regBlockItem(DeferredRegister<Block> registry, final String id, final Supplier<? extends I> supplier) {
        RegistryObject<I> createdBlock = registry.register(id, supplier);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(createdBlock.get(), ItemRegistry.defaultProp()));
        return createdBlock;
    }

}
