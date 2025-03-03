package com.uraneptus.sullysmod.client.renderer.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.client.model.TortoiseShellModel;
import com.uraneptus.sullysmod.common.entities.TortoiseShell;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TortoiseShellRenderer <E extends TortoiseShell> extends EntityRenderer<E> {
    public static final ResourceLocation TEXTURE = SullysMod.modPrefix("textures/entity/tortoise/tortoise.png");
    protected final TortoiseShellModel<E> model;

    public TortoiseShellRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.75F;
        this.model = new TortoiseShellModel<>(context.bakeLayer(TortoiseShellModel.LAYER_LOCATION));
    }

    @Override
    public void render(E pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, -1.0F, 0.0D);

        float spinTime = pEntity.tickCount + pPartialTicks;
        if (pEntity.spinTicks > 0) {
            pMatrixStack.mulPose(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), spinTime * 0.56F, false));
        }

        float hurtTime = (float)pEntity.getHurtTime() - pPartialTicks;
        float damage = pEntity.getDamage() - pPartialTicks;
        if (damage < 0.0F) {
            damage = 0.0F;
        }
        if (hurtTime > 0.0F) {
            pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.sin(hurtTime) * hurtTime * damage / 96.0F * (float)pEntity.getHurtDir()));
        }

        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(E pEntity) {
        return TEXTURE;
    }
}
