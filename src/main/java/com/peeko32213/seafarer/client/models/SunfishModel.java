package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.SunfishAnimations;
import com.peeko32213.seafarer.entities.Sunfish;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SunfishModel<T extends Sunfish> extends HierarchicalModel<T> {
	private final ModelPart Body;
	private final ModelPart Rotation;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart TopFin;
	private final ModelPart BottomFin;

	public SunfishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Rotation = this.Body.getChild("Rotation");
		this.Tail = this.Rotation.getChild("Tail");
		this.Fin1 = this.Rotation.getChild("Fin1");
		this.Fin2 = this.Rotation.getChild("Fin2");
		this.TopFin = this.Rotation.getChild("TopFin");
		this.BottomFin = this.Rotation.getChild("BottomFin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Rotation = Body.addOrReplaceChild("Rotation", CubeListBuilder.create().texOffs(51, 22).addBox(-4.5F, -17.0F, -18.0F, 9.0F, 9.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(-4.5F, -8.0F, -16.0F, 9.0F, 2.0F, 31.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -6.0F, -18.0F, 9.0F, 22.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail = Rotation.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 47).addBox(0.0F, -16.0F, 0.0F, 0.0F, 31.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 15.0F));

		PartDefinition Fin1 = Rotation.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -5.0F, -4.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 48).addBox(-0.3686F, -1.2282F, -1.249F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.7418F, 0.0F));

		PartDefinition Fin2 = Rotation.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5F, -5.0F, -4.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(0.3686F, -1.2282F, -1.249F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, -0.7418F, 0.0F));

		PartDefinition TopFin = Rotation.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(51, 0).addBox(-1.0F, -20.0F, -6.0F, 2.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 9.0F));

		PartDefinition BottomFin = Rotation.addOrReplaceChild("BottomFin", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 9.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Sunfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(SunfishAnimations.SWIM_1, limbSwing, limbSwingAmount, 4, 8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Body;
	}
}