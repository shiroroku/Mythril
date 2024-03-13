package shiroroku.mythril.DataGen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import shiroroku.mythril.Mythril;
import shiroroku.mythril.Registries.BlockRegistry;

import java.util.function.Supplier;

public class DataGenBlocks extends BlockStateProvider {

    public DataGenBlocks(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Mythril.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockRegistry.BLOCKS.getEntries().stream().map(Supplier::get).forEach(this::simpleBlockItem);
        BlockRegistry.BLOCKS_GEN.getEntries().stream().map(Supplier::get).forEach((block) -> {
            simpleBlock(block);
            simpleBlockItem(block);
        });
    }

    private void simpleBlockItem(Block parent) {
        ResourceLocation location = ForgeRegistries.BLOCKS.getKey(parent);
        itemModels().getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile(modLoc("block/" + location.getPath())));
    }
}
