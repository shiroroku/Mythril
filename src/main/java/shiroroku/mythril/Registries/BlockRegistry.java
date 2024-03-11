package shiroroku.mythril.Registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import shiroroku.mythril.Mythril;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mythril.MODID);

    public static final RegistryObject<Block> mythril_block = regBlockItem("mythril_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> mythril_ore = regBlockItem("mythril_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> mythril_ore_deepslate = regBlockItem("mythril_ore_deepslate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    private static <I extends Block> RegistryObject<I> regBlockItem(final String id, final Supplier<? extends I> supplier) {
        RegistryObject<I> createdBlock = BlockRegistry.BLOCKS.register(id, supplier);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(createdBlock.get(), ItemRegistry.defaultProp()));
        return createdBlock;
    }

}
