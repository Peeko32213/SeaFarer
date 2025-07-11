package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.CrabAnimations;
import com.peeko32213.seafarer.entities.Crab;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CrabModel<T extends Crab> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Body_B;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Claw1;
	private final ModelPart Claw1_B;
	private final ModelPart Claw2;
	private final ModelPart Claw2_B;
	private final ModelPart BigLeg1;
	private final ModelPart BigLeg2;
	private final ModelPart BigLeg3;
	private final ModelPart BigLeg4;
	private final ModelPart SmallLeg1;
	private final ModelPart SmallLeg2;
	private final ModelPart SmallLeg3;
	private final ModelPart SmallLeg4;

	public CrabModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Body_B = this.Body.getChild("Body_B");
		this.Eye1 = this.Body_B.getChild("Eye1");
		this.Eye2 = this.Body_B.getChild("Eye2");
		this.Claw1 = this.Body_B.getChild("Claw1");
		this.Claw1_B = this.Claw1.getChild("Claw1_B");
		this.Claw2 = this.Body_B.getChild("Claw2");
		this.Claw2_B = this.Claw2.getChild("Claw2_B");
		this.BigLeg1 = this.root.getChild("BigLeg1");
		this.BigLeg2 = this.root.getChild("BigLeg2");
		this.BigLeg3 = this.root.getChild("BigLeg3");
		this.BigLeg4 = this.root.getChild("BigLeg4");
		this.SmallLeg1 = this.root.getChild("SmallLeg1");
		this.SmallLeg2 = this.root.getChild("SmallLeg2");
		this.SmallLeg3 = this.root.getChild("SmallLeg3");
		this.SmallLeg4 = this.root.getChild("SmallLeg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition Body_B = Body.addOrReplaceChild("Body_B", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -4.0F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Eye1 = Body_B.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.525F, -0.525F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(3.5F, -1.475F, -3.475F));

		PartDefinition Eye2 = Body_B.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.525F, -0.525F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(-3.5F, -1.475F, -3.475F));

		PartDefinition Claw1 = Body_B.addOrReplaceChild("Claw1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, 2.0F, -4.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Claw1_B = Claw1.addOrReplaceChild("Claw1_B", CubeListBuilder.create().texOffs(9, 15).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.001F))
		.texOffs(17, 17).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 17).addBox(1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Claw2 = Body_B.addOrReplaceChild("Claw2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, 2.0F, -4.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition Claw2_B = Claw2.addOrReplaceChild("Claw2_B", CubeListBuilder.create().texOffs(9, 15).mirror().addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(17, 17).mirror().addBox(0.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(17, 17).mirror().addBox(-2.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BigLeg1 = root.addOrReplaceChild("BigLeg1", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, -2.0F));

		PartDefinition BigLeg1_r1 = BigLeg1.addOrReplaceChild("BigLeg1_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.5672F, 0.0F));

		PartDefinition BigLeg2 = root.addOrReplaceChild("BigLeg2", CubeListBuilder.create(), PartPose.offset(-3.0F, -3.0F, -2.0F));

		PartDefinition BigLeg2_r1 = BigLeg2.addOrReplaceChild("BigLeg2_r1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, -0.5672F, 0.0F));

		PartDefinition BigLeg3 = root.addOrReplaceChild("BigLeg3", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, -1.5F));

		PartDefinition BigLeg3_r1 = BigLeg3.addOrReplaceChild("BigLeg3_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, -0.2618F, 0.0F));

		PartDefinition BigLeg4 = root.addOrReplaceChild("BigLeg4", CubeListBuilder.create(), PartPose.offset(-3.0F, -3.0F, -1.5F));

		PartDefinition BigLeg4_r1 = BigLeg4.addOrReplaceChild("BigLeg4_r1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.2618F, 0.0F));

		PartDefinition SmallLeg1 = root.addOrReplaceChild("SmallLeg1", CubeListBuilder.create(), PartPose.offset(3.5F, -3.0F, 0.35F));

		PartDefinition SmallLeg1_r1 = SmallLeg1.addOrReplaceChild("SmallLeg1_r1", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, -0.48F, 0.0F));

		PartDefinition SmallLeg2 = root.addOrReplaceChild("SmallLeg2", CubeListBuilder.create(), PartPose.offset(-3.5F, -3.0F, 0.35F));

		PartDefinition SmallLeg2_r1 = SmallLeg2.addOrReplaceChild("SmallLeg2_r1", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-3.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.48F, 0.0F));

		PartDefinition SmallLeg3 = root.addOrReplaceChild("SmallLeg3", CubeListBuilder.create(), PartPose.offset(3.5F, -3.0F, 2.0F));

		PartDefinition SmallLeg3_r1 = SmallLeg3.addOrReplaceChild("SmallLeg3_r1", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, -0.6109F, 0.1309F));

		PartDefinition SmallLeg4 = root.addOrReplaceChild("SmallLeg4", CubeListBuilder.create(), PartPose.offset(-3.5F, -3.0F, 2.0F));

		PartDefinition SmallLeg4_r1 = SmallLeg4.addOrReplaceChild("SmallLeg4_r1", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-3.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.6109F, -0.1309F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Crab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.animateWalk(CrabAnimations.SPRINT, limbSwing, limbSwingAmount, 4, 8);

		this.Body.xRot = headPitch * (Mth.DEG_TO_RAD);
		this.Body.zRot = netHeadYaw * ((Mth.DEG_TO_RAD) / 2);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}