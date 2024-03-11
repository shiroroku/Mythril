package shiroroku.mythril.DataGen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import shiroroku.mythril.Mythril;

@Mod.EventBusSubscriber(modid = Mythril.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeClient(), new DataGenBlocks(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new DataGenItems(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new DataGenItemsTags(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new DataGenBlocksTags(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new DataGenBlocksLoot(generator));
    }
}
