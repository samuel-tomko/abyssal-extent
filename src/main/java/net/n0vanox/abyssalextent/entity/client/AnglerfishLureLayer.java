package net.n0vanox.abyssalextent.entity.client;

import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.n0vanox.abyssalextent.AbyssalExtent;

public class AnglerfishLureLayer extends EyesLayer<AnglerfishRenderState, AnglerfishModel> {
    private static final RenderType GLOW = RenderTypes.eyes(
            Identifier.fromNamespaceAndPath(AbyssalExtent.MOD_ID, "textures/entity/anglerfish/anglerfish_e.png"));

    public AnglerfishLureLayer(RenderLayerParent<AnglerfishRenderState, AnglerfishModel> parent) {
        super(parent);
    }

    @Override
    public RenderType renderType() {
        return GLOW;
    }
}