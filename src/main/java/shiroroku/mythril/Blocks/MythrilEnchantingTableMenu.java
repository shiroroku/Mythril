package shiroroku.mythril.Blocks;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import shiroroku.mythril.Registries.BlockRegistry;

public class MythrilEnchantingTableMenu extends EnchantmentMenu {

    private final ContainerLevelAccess access;

    public MythrilEnchantingTableMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(pContainerId, pPlayerInventory, pAccess);
        access = pAccess;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegistry.mythril_enchanting_table.get());
    }
}
