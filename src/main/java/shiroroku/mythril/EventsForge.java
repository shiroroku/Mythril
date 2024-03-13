package shiroroku.mythril;

import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import shiroroku.mythril.Blocks.MythrilEnchantingTableEntity;

@Mod.EventBusSubscriber(modid = Mythril.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventsForge {

    @SubscribeEvent
    public static void onEnchantmentLevelSet(EnchantmentLevelSetEvent event){
        MythrilEnchantingTableEntity.HandleEnchantmentLevelSet(event);
    }
}
