package shiroroku.mythril.Blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;

import static net.minecraft.client.renderer.blockentity.EnchantTableRenderer.BOOK_LOCATION;

public class MythrilEnchantingTableRenderer implements BlockEntityRenderer<MythrilEnchantingTableEntity> {

    private final BookModel bookModel;

    public MythrilEnchantingTableRenderer(BlockEntityRendererProvider.Context pContext) {
        this.bookModel = new BookModel(pContext.bakeLayer(ModelLayers.BOOK));
    }

    public void render(MythrilEnchantingTableEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();
        pPoseStack.translate(0.5D, 0.75D, 0.5D);
        float time = (float) pBlockEntity.time + pPartialTick;
        pPoseStack.translate(0.0D, (double) (0.1F + Mth.sin(time * 0.1F) * 0.01F), 0.0D);

        float f1;
        for (f1 = pBlockEntity.rot - pBlockEntity.oRot; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F)) {
        }

        while (f1 < -(float) Math.PI) {
            f1 += ((float) Math.PI * 2F);
        }

        float f2 = pBlockEntity.oRot + f1 * pPartialTick;
        pPoseStack.mulPose(Vector3f.YP.rotation(-f2));
        pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(80.0F));
        float flipLerp = Mth.lerp(pPartialTick, pBlockEntity.oFlip, pBlockEntity.flip);
        float pageFlipR = Mth.frac(flipLerp + 0.25F) * 1.6F - 0.3F;
        float pageFlipL = Mth.frac(flipLerp + 0.75F) * 1.6F - 0.3F;
        float openAmt = Mth.lerp(pPartialTick, pBlockEntity.oOpen, pBlockEntity.open);
        this.bookModel.setupAnim(time, Mth.clamp(pageFlipR, 0.0F, 1.0F), Mth.clamp(pageFlipL, 0.0F, 1.0F), openAmt);
        this.bookModel.render(pPoseStack, BOOK_LOCATION.buffer(pBufferSource, RenderType::entitySolid), pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
    }
}
