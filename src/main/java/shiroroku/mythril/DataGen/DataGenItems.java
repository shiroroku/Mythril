package shiroroku.mythril.DataGen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import shiroroku.mythril.Mythril;
import shiroroku.mythril.Registries.ItemRegistry;

import java.util.Objects;
import java.util.function.Supplier;

public class DataGenItems extends ItemModelProvider {

    public DataGenItems(DataGenerator output, ExistingFileHelper existingFileHelper) {
        super(output, Mythril.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemRegistry.ITEMS_GEN.getEntries().stream().map(Supplier::get).forEach(this::basicItem);
        ItemRegistry.ITEMS_GEN_HANDHELD.getEntries().stream().map(Supplier::get).forEach(this::basicItemHandheld);
    }

    private void basicItemHandheld(Item item) {
        ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        getBuilder(location.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath()));
    }
}
