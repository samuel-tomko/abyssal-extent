package net.n0vanox.abyssalextent.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.entity.custom.AnglerfishEntity;

public class AnglerfishRenderer extends MobRenderer<AnglerfishEntity, AnglerfishRenderState, AnglerfishModel> {
    public AnglerfishRenderer(EntityRendererProvider.Context context) {
        super(context, new AnglerfishModel(context.bakeLayer(ModModelLayerLocations.ANGLERFISH)), 0.25f);
    }

    @Override
    public Identifier getTextureLocation(AnglerfishRenderState state) {
        return Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, "textures/entity/anglerfish/anglerfish.png");
    }

    @Override
    public AnglerfishRenderState createRenderState() {
        return new AnglerfishRenderState();
    }

    @Override
    public void extractRenderState(AnglerfishEntity entity, AnglerfishRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
