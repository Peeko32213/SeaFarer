package com.peeko32213.seafarer.client.models.unimplemented;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.unimplemented.LeafyScorpionFishAnimations;
import com.peeko32213.seafarer.entities.misc.unimplemented.LeafyScorpionfish;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class LeafyScorpionFishModel<T extends LeafyScorpionfish> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart Root;
	private final ModelPart BodyRoot;
	private final ModelPart Body;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart TopFin;
	private final ModelPart TopFinPart1;
	private final ModelPart TailMid;
	private final ModelPart Tail;
	private final ModelPart Mouth;
	private final ModelPart FootBase1;
	private final ModelPart Foot1;
	private final ModelPart Toes1;
	private final ModelPart FootBase2;
	private final ModelPart Foot2;
	private final ModelPart Toes2;

	public LeafyScorpionFishModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.BodyRoot = this.Root.getChild("BodyRoot");
		this.Body = this.BodyRoot.getChild("Body");
		this.Eye1 = this.Body.getChild("Eye1");
		this.Eye2 = this.Body.getChild("Eye2");
		this.TopFin = this.Body.getChild("TopFin");
		this.TopFinPart1 = this.TopFin.getChild("TopFinPart1");
		this.TailMid = this.Body.getChild("TailMid");
		this.Tail = this.TailMid.getChild("Tail");
		this.Mouth = this.Body.getChild("Mouth");
		this.FootBase1 = this.Root.getChild("FootBase1");
		this.Foot1 = this.FootBase1.getChild("Foot1");
		this.Toes1 = this.Foot1.getChild("Toes1");
		this.FootBase2 = this.Root.getChild("FootBase2");
		this.Foot2 = this.FootBase2.getChild("Foot2");
		this.Toes2 = this.Foot2.getChild("Toes2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.5F, 22.475F, -2.0F));

		PartDefinition BodyRoot = Root.addOrReplaceChild("BodyRoot", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, -0.5F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Body = BodyRoot.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 18).addBox(0.0F, -1.0F, 1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Eye1 = Body.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(26, 12).addBox(1.0F, -4.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -3.0F, -2.5F));

		PartDefinition Eye2 = Body.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(26, 12).mirror().addBox(-1.0F, -4.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -3.0F, -2.5F));

		PartDefinition TopFin = Body.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -8.0F, -4.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 1.0F));

		PartDefinition TopFinPart1 = TopFin.addOrReplaceChild("TopFinPart1", CubeListBuilder.create().texOffs(20, 18).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition TailMid = Body.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(28, 17).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 4.0F));

		PartDefinition Tail = TailMid.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(10, 27).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition Mouth = Body.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(22, 6).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition FootBase1 = Root.addOrReplaceChild("FootBase1", CubeListBuilder.create().texOffs(18, 27).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, 1.0F, 0.0F, 0.6545F, 0.0F));

		PartDefinition Foot1 = FootBase1.addOrReplaceChild("Foot1", CubeListBuilder.create().texOffs(26, 27).addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition Toes1 = Foot1.addOrReplaceChild("Toes1", CubeListBuilder.create().texOffs(10, 13).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition FootBase2 = Root.addOrReplaceChild("FootBase2", CubeListBuilder.create().texOffs(18, 27).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.5F, 1.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition Foot2 = FootBase2.addOrReplaceChild("Foot2", CubeListBuilder.create().texOffs(26, 27).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition Toes2 = Foot2.addOrReplaceChild("Toes2", CubeListBuilder.create().texOffs(10, 13).mirror().addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(LeafyScorpionfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.animateWalk(LeafyScorpionFishAnimations.WALK, limbSwing, limbSwingAmount, 4, 8);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Root;
	}
}