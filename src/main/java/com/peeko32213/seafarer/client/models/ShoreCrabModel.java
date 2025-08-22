package com.peeko32213.seafarer.client.models;

import com.peeko32213.seafarer.client.animations.ShoreCrabAnimations;
import com.peeko32213.seafarer.entities.ShoreCrab;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ShoreCrabModel extends HierarchicalModel<ShoreCrab> {

	private final ModelPart root;
	private final ModelPart body_main;
	private final ModelPart body;
	private final ModelPart eye1;
	private final ModelPart eye2;
	private final ModelPart claw1;
	private final ModelPart claw1_b;
	private final ModelPart claw2;
	private final ModelPart claw2_b;
	private final ModelPart big_leg1;
	private final ModelPart big_leg2;
	private final ModelPart big_leg3;
	private final ModelPart big_leg4;
	private final ModelPart small_leg1;
	private final ModelPart small_leg2;
	private final ModelPart small_leg3;
	private final ModelPart small_leg4;

	public ShoreCrabModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body_main = this.root.getChild("body_main");
		this.body = this.body_main.getChild("body");
		this.eye1 = this.body.getChild("eye1");
		this.eye2 = this.body.getChild("eye2");
		this.claw1 = this.body.getChild("claw1");
		this.claw1_b = this.claw1.getChild("claw1_b");
		this.claw2 = this.body.getChild("claw2");
		this.claw2_b = this.claw2.getChild("claw2_b");
		this.big_leg1 = this.root.getChild("big_leg1");
		this.big_leg2 = this.root.getChild("big_leg2");
		this.big_leg3 = this.root.getChild("big_leg3");
		this.big_leg4 = this.root.getChild("big_leg4");
		this.small_leg1 = this.root.getChild("small_leg1");
		this.small_leg2 = this.root.getChild("small_leg2");
		this.small_leg3 = this.root.getChild("small_leg3");
		this.small_leg4 = this.root.getChild("small_leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body_main = root.addOrReplaceChild("body_main", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition body = body_main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -4.0F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition eye1 = body.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, -1.475F, -3.475F));

		PartDefinition eye2 = body.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -1.475F, -3.475F));

		PartDefinition claw1 = body.addOrReplaceChild("claw1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, 2.0F, -4.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition claw1_b = claw1.addOrReplaceChild("claw1_b", CubeListBuilder.create().texOffs(9, 15).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.025F))
				.texOffs(17, 17).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 17).addBox(1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition claw2 = body.addOrReplaceChild("claw2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, 2.0F, -4.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition claw2_b = claw2.addOrReplaceChild("claw2_b", CubeListBuilder.create().texOffs(9, 15).mirror().addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false)
				.texOffs(17, 17).mirror().addBox(0.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(17, 17).mirror().addBox(-2.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition big_leg1 = root.addOrReplaceChild("big_leg1", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, -2.0F));

		PartDefinition BigLeg1_r1 = big_leg1.addOrReplaceChild("BigLeg1_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.5672F, 0.0F));

		PartDefinition big_leg2 = root.addOrReplaceChild("big_leg2", CubeListBuilder.create(), PartPose.offset(-3.0F, -3.0F, -2.0F));

		PartDefinition BigLeg2_r1 = big_leg2.addOrReplaceChild("BigLeg2_r1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, -0.5672F, 0.0F));

		PartDefinition big_leg3 = root.addOrReplaceChild("big_leg3", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, -1.5F));

		PartDefinition BigLeg3_r1 = big_leg3.addOrReplaceChild("BigLeg3_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, -0.2618F, 0.0F));

		PartDefinition big_leg4 = root.addOrReplaceChild("big_leg4", CubeListBuilder.create(), PartPose.offset(-3.0F, -3.0F, -1.5F));

		PartDefinition BigLeg4_r1 = big_leg4.addOrReplaceChild("BigLeg4_r1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.2618F, 0.0F));

		PartDefinition small_leg1 = root.addOrReplaceChild("small_leg1", CubeListBuilder.create(), PartPose.offset(3.5F, -3.0F, 0.35F));

		PartDefinition SmallLeg1_r1 = small_leg1.addOrReplaceChild("SmallLeg1_r1", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, -0.48F, 0.0F));

		PartDefinition small_leg2 = root.addOrReplaceChild("small_leg2", CubeListBuilder.create(), PartPose.offset(-3.5F, -3.0F, 0.35F));

		PartDefinition SmallLeg2_r1 = small_leg2.addOrReplaceChild("SmallLeg2_r1", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-3.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.48F, 0.0F));

		PartDefinition small_leg3 = root.addOrReplaceChild("small_leg3", CubeListBuilder.create(), PartPose.offset(3.5F, -3.0F, 2.0F));

		PartDefinition SmallLeg3_r1 = small_leg3.addOrReplaceChild("SmallLeg3_r1", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, -0.6109F, 0.1309F));

		PartDefinition small_leg4 = root.addOrReplaceChild("small_leg4", CubeListBuilder.create(), PartPose.offset(-3.5F, -3.0F, 2.0F));

		PartDefinition SmallLeg4_r1 = small_leg4.addOrReplaceChild("SmallLeg4_r1", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-3.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.6109F, -0.1309F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(ShoreCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ShoreCrabAnimations.WALK, limbSwing, limbSwingAmount, 4, 8);

		this.body.xRot = headPitch * (Mth.DEG_TO_RAD) / 4;
		this.body.zRot = netHeadYaw * (Mth.DEG_TO_RAD) / 4;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}