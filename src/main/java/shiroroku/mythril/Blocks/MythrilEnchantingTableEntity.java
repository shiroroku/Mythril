package shiroroku.mythril.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import shiroroku.mythril.Registries.BlockEntityRegistry;
import shiroroku.mythril.Registries.BlockRegistry;

public class MythrilEnchantingTableEntity extends BlockEntity {

    public int time;
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    public float rot;
    public float oRot;
    public float tRot;
    private static final RandomSource render_random = RandomSource.create();

    public MythrilEnchantingTableEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.mythril_enchanting_table.get(), pPos, pBlockState);
    }

    public static void HandleEnchantmentLevelSet(EnchantmentLevelSetEvent event) {
        // it is affected by bookshelves but shhhh, its not intended. ill fix someday
        if (event.getLevel().getBlockState(event.getPos()).is(BlockRegistry.mythril_enchanting_table.get())) {
            if (event.getEnchantLevel() <= 0) {
                event.setEnchantLevel(1);
            }
            if (event.getEnchantRow() == 2) {
                event.setEnchantLevel(0);
            } else {
                event.setEnchantLevel(Math.min(event.getEnchantLevel() * 2, 12));
            }
        }
    }

    public static void bookAnimationTick(Level pLevel, BlockPos pPos, BlockState pState, MythrilEnchantingTableEntity pBlockEntity) {
        pBlockEntity.oOpen = pBlockEntity.open;
        pBlockEntity.oRot = pBlockEntity.rot;
        Player player = pLevel.getNearestPlayer((double) pPos.getX() + 0.5D, (double) pPos.getY() + 0.5D, (double) pPos.getZ() + 0.5D, 3.0D, false);
        if (player != null) {
            double d0 = player.getX() - ((double) pPos.getX() + 0.5D);
            double d1 = player.getZ() - ((double) pPos.getZ() + 0.5D);
            pBlockEntity.tRot = (float) Mth.atan2(d1, d0);
            pBlockEntity.open += 0.1F;
            if (pBlockEntity.open < 0.5F || render_random.nextInt(40) == 0) {
                float f1 = pBlockEntity.flipT;

                do {
                    pBlockEntity.flipT += (float) (render_random.nextInt(4) - render_random.nextInt(4));
                } while (f1 == pBlockEntity.flipT);
            }
        } else {
            pBlockEntity.tRot += 0.02F;
            pBlockEntity.open -= 0.1F;
        }

        while (pBlockEntity.rot >= (float) Math.PI) {
            pBlockEntity.rot -= ((float) Math.PI * 2F);
        }

        while (pBlockEntity.rot < -(float) Math.PI) {
            pBlockEntity.rot += ((float) Math.PI * 2F);
        }

        while (pBlockEntity.tRot >= (float) Math.PI) {
            pBlockEntity.tRot -= ((float) Math.PI * 2F);
        }

        while (pBlockEntity.tRot < -(float) Math.PI) {
            pBlockEntity.tRot += ((float) Math.PI * 2F);
        }

        float f2;
        for (f2 = pBlockEntity.tRot - pBlockEntity.rot; f2 >= (float) Math.PI; f2 -= ((float) Math.PI * 2F)) {
        }

        while (f2 < -(float) Math.PI) {
            f2 += ((float) Math.PI * 2F);
        }

        pBlockEntity.rot += f2 * 0.4F;
        pBlockEntity.open = Mth.clamp(pBlockEntity.open, 0.0F, 1.0F);
        ++pBlockEntity.time;
        pBlockEntity.oFlip = pBlockEntity.flip;
        float f = (pBlockEntity.flipT - pBlockEntity.flip) * 0.4F;
        f = Mth.clamp(f, -0.2F, 0.2F);
        pBlockEntity.flipA += (f - pBlockEntity.flipA) * 0.9F;
        pBlockEntity.flip += pBlockEntity.flipA;
    }
}
