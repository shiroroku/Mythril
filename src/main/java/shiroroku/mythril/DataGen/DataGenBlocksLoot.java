package shiroroku.mythril.DataGen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import shiroroku.mythril.Registries.BlockRegistry;
import shiroroku.mythril.Registries.ItemRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DataGenBlocksLoot extends LootTableProvider {

    public DataGenBlocksLoot(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((location, lootTable) -> LootTables.validate(validationtracker, location, lootTable));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return List.of(Pair.of(Blocks::new, LootContextParamSets.BLOCK));
    }

    private static class Blocks extends BlockLoot {

        @Override
        protected void addTables() {
            dropSelf(BlockRegistry.mythril_block.get());
            dropSelf(BlockRegistry.mythril_enchanting_table.get());
            this.add(BlockRegistry.mythril_ore.get(), (block) -> createOreDrop(block, ItemRegistry.raw_mythril.get()));
            this.add(BlockRegistry.mythril_ore_deepslate.get(), (block) -> createOreDrop(block, ItemRegistry.raw_mythril.get()));
            // ! dont forget to add to function below too <3
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            List<Block> gen = new ArrayList<>();
            gen.add(BlockRegistry.mythril_block.get());
            gen.add(BlockRegistry.mythril_enchanting_table.get());
            gen.add(BlockRegistry.mythril_ore.get());
            gen.add(BlockRegistry.mythril_ore_deepslate.get());
            return gen;
        }
    }
}
