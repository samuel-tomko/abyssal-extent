package net.n0vanox.abyssalextent.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class AnglerfishModel extends EntityModel<AnglerfishRenderState> {
    private final ModelPart tail;
    private final ModelPart lure;
    private final ModelPart main;

    private final KeyframeAnimation idlingAnimation;
    private final KeyframeAnimation swimmingAnimation;

    public AnglerfishModel(ModelPart root) {
        super(root);
        this.tail = root.getChild("tail");
        this.lure = root.getChild("lure");
        this.main = root.getChild("main");

        this.idlingAnimation = AnglerfishAnimations.IDLE.bake(root);
        this.swimmingAnimation = AnglerfishAnimations.SWIM.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 6).addBox(0.0F, -2.0F, 0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 23.0F, 1.0F));

        PartDefinition lure = partdefinition.addOrReplaceChild("lure", CubeListBuilder.create(), PartPose.offset(0.5F, 21.5F, -2.0F));

        PartDefinition lurebulb_r1 = lure.addOrReplaceChild("lurebulb_r1", CubeListBuilder.create().texOffs(2, 9).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -0.5F, 0.8727F, 0.0F, 0.0F));

        PartDefinition lure_r1 = lure.addOrReplaceChild("lure_r1", CubeListBuilder.create().texOffs(0, 9).addBox(1.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, 0.5F, 0.8727F, 0.0F, 0.0F));

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(4, 6).addBox(0.5F, -4.0F, -1.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(AnglerfishRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.swimmingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }
}
