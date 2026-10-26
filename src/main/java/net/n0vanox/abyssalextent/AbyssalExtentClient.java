package net.n0vanox.abyssalextent;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.n0vanox.abyssalextent.entity.ModEntities;
import net.n0vanox.abyssalextent.entity.client.AnglerfishModel;
import net.n0vanox.abyssalextent.entity.client.AnglerfishRenderer;
import net.n0vanox.abyssalextent.entity.client.ModModelLayerLocations;

public class AbyssalExtentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //ClientTickEvents.END_CLIENT_TICK.register(AbyssalExtentClient::onEndTick);

        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.ANGLERFISH, AnglerfishModel::createBodyLayer);
        EntityRenderers.register(ModEntities.ANGLERFISH, AnglerfishRenderer::new);
    }

    public static void onEndTick() {

    }
}
