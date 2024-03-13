package shiroroku.mythril;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import shiroroku.mythril.Blocks.MythrilEnchantingTableRenderer;
import shiroroku.mythril.Registries.BlockEntityRegistry;

@Mod.EventBusSubscriber(modid = Mythril.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventsClient {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> BlockEntityRenderers.register(BlockEntityRegistry.mythril_enchanting_table.get(), MythrilEnchantingTableRenderer::new));
    }
}
