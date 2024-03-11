package shiroroku.mythril.DataGen;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import shiroroku.mythril.Mythril;
import shiroroku.mythril.Registries.BlockRegistry;

public class DataGenBlocksTags extends TagsProvider<Block> {

    public static final TagKey<Block> MYTHRIL_ORE = BlockTags.create(new ResourceLocation(Mythril.MODID, "mythril_ore"));

    @SuppressWarnings("deprecation")
    protected DataGenBlocksTags(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pGenerator, Registry.BLOCK, Mythril.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegistry.mythril_ore_deepslate.get(), BlockRegistry.mythril_ore.get(), BlockRegistry.mythril_block.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(BlockRegistry.mythril_ore_deepslate.get(), BlockRegistry.mythril_ore.get(), BlockRegistry.mythril_block.get());
        this.tag(MYTHRIL_ORE).add(BlockRegistry.mythril_ore_deepslate.get(), BlockRegistry.mythril_ore.get());
        this.tag(Tags.Blocks.ORES).addTag(MYTHRIL_ORE);
    }
}
