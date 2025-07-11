package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.MandarinGobyAnimations;
import com.peeko32213.seafarer.entities.MandarinGoby;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class MandarinGobyModel<T extends MandarinGoby> extends HierarchicalModel<T> {
	private final ModelPart Body;
	private final ModelPart BigFin1Root;
	private final ModelPart BigFin1;
	private final ModelPart BigFin2Root;
	private final ModelPart BigFin2;
	private final ModelPart SmallFin1Root;
	private final ModelPart SmallFin1;
	private final ModelPart SmallFin2Root;
	private final ModelPart SmallFin2;
	private final ModelPart MidTail;
	private final ModelPart Tail;
	private final ModelPart Eyes;

	public MandarinGobyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BigFin1Root = this.Body.getChild("BigFin1Root");
		this.BigFin1 = this.BigFin1Root.getChild("BigFin1");
		this.BigFin2Root = this.Body.getChild("BigFin2Root");
		this.BigFin2 = this.BigFin2Root.getChild("BigFin2");
		this.SmallFin1Root = this.Body.getChild("SmallFin1Root");
		this.SmallFin1 = this.SmallFin1Root.getChild("SmallFin1");
		this.SmallFin2Root = this.Body.getChild("SmallFin2Root");
		this.SmallFin2 = this.SmallFin2Root.getChild("SmallFin2");
		this.MidTail = this.Body.getChild("MidTail");
		this.Tail = this.MidTail.getChild("Tail");
		this.Eyes = this.Body.getChild("Eyes");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.55F, -2.0F, -2.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-1.05F, 1.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 8).addBox(-0.05F, -4.0F, 5.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 23).addBox(-0.05F, -6.0F, 2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 20).addBox(-0.05F, 2.0F, 5.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.05F, 19.0F, -3.0F));

		PartDefinition BigFin1Root = Body.addOrReplaceChild("BigFin1Root", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 2.0F));

		PartDefinition BigFin1 = BigFin1Root.addOrReplaceChild("BigFin1", CubeListBuilder.create().texOffs(0, 23).addBox(0.7F, -1.0F, -1.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.6981F, 0.7854F, 0.0F));

		PartDefinition BigFin2Root = Body.addOrReplaceChild("BigFin2Root", CubeListBuilder.create(), PartPose.offset(-3.1F, 0.0F, 2.0F));

		PartDefinition BigFin2 = BigFin2Root.addOrReplaceChild("BigFin2", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-0.7F, -1.0F, -1.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.6981F, -0.7854F, 0.0F));

		PartDefinition SmallFin1Root = Body.addOrReplaceChild("SmallFin1Root", CubeListBuilder.create(), PartPose.offset(2.5F, 3.0F, 2.0F));

		PartDefinition SmallFin1 = SmallFin1Root.addOrReplaceChild("SmallFin1", CubeListBuilder.create().texOffs(22, 23).addBox(0.0F, -1.0F, -1.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3795F, 0.3013F, -0.931F));

		PartDefinition SmallFin2Root = Body.addOrReplaceChild("SmallFin2Root", CubeListBuilder.create(), PartPose.offset(-2.6F, 3.0F, 2.0F));

		PartDefinition SmallFin2 = SmallFin2Root.addOrReplaceChild("SmallFin2", CubeListBuilder.create().texOffs(22, 23).mirror().addBox(0.0F, -1.0F, -1.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3795F, -0.3013F, 0.931F));

		PartDefinition MidTail = Body.addOrReplaceChild("MidTail", CubeListBuilder.create().texOffs(30, 4).addBox(-1.05F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition Tail = MidTail.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(26, 13).addBox(-0.05F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition Eyes = Body.addOrReplaceChild("Eyes", CubeListBuilder.create().texOffs(0, 13).addBox(-4.05F, -3.0F, -3.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(MandarinGoby entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.animateWalk(MandarinGobyAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Body;
	}
}