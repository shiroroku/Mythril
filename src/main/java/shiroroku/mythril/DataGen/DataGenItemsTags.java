package shiroroku.mythril.DataGen;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import shiroroku.mythril.Mythril;
import shiroroku.mythril.Registries.BlockRegistry;
import shiroroku.mythril.Registries.ItemRegistry;

public class DataGenItemsTags extends TagsProvider<Item> {

    public static final TagKey<Item> MYTHRIL_ORE = ItemTags.create(new ResourceLocation(Mythril.MODID, "mythril_ore"));

    @SuppressWarnings("deprecation")
    protected DataGenItemsTags(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pGenerator, Registry.ITEM, Mythril.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(MYTHRIL_ORE).add(BlockRegistry.mythril_ore.get().asItem(), BlockRegistry.mythril_ore_deepslate.get().asItem());
        this.tag(Tags.Items.TOOLS_SWORDS).add(ItemRegistry.mythril_sword.get());
        this.tag(Tags.Items.TOOLS_PICKAXES).add(ItemRegistry.mythril_pickaxe.get());
        this.tag(Tags.Items.TOOLS_AXES).add(ItemRegistry.mythril_axe.get());
        this.tag(Tags.Items.TOOLS_HOES).add(ItemRegistry.mythril_hoe.get());
        this.tag(Tags.Items.TOOLS_SHOVELS).add(ItemRegistry.mythril_shovel.get());
        this.tag(Tags.Items.NUGGETS).add(ItemRegistry.mythril_nugget.get());
        this.tag(Tags.Items.INGOTS).add(ItemRegistry.mythril_ingot.get());
        this.tag(Tags.Items.RAW_MATERIALS).add(ItemRegistry.raw_mythril.get());
    }
}
