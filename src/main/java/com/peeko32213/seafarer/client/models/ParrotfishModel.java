package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.MantaRayAnimations;
import com.peeko32213.seafarer.entities.MantaRay;
import com.peeko32213.seafarer.entities.Parrotfish;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
public class ParrotfishModel<T extends Parrotfish>  extends HierarchicalModel<T> {
	private final ModelPart Root;
	private final ModelPart TailMid;
	private final ModelPart Tail;
	private final ModelPart FinBone1;
	private final ModelPart Fin1;
	private final ModelPart FineBone2;
	private final ModelPart Fin2;
	private final ModelPart BottomFin1;
	private final ModelPart BottomFin2;
	private final ModelPart Head;

	public ParrotfishModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.TailMid = this.Root.getChild("TailMid");
		this.Tail = this.TailMid.getChild("Tail");
		this.FinBone1 = this.Root.getChild("FinBone1");
		this.Fin1 = this.FinBone1.getChild("Fin1");
		this.FineBone2 = this.Root.getChild("FineBone2");
		this.Fin2 = this.FineBone2.getChild("Fin2");
		this.BottomFin1 = this.Root.getChild("BottomFin1");
		this.BottomFin2 = this.Root.getChild("BottomFin2");
		this.Head = this.Root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -6.0F, 5.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(0.0F, 5.0F, -2.0F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(0.0F, -7.0F, -2.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition TailMid = Root.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(30, 32).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition Tail = TailMid.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(20, 32).addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition FinBone1 = Root.addOrReplaceChild("FinBone1", CubeListBuilder.create(), PartPose.offset(2.5F, 2.0F, -5.0F));

		PartDefinition Fin1 = FinBone1.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(32, 11).addBox(0.05F, -1.0F, -0.5F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FineBone2 = Root.addOrReplaceChild("FineBone2", CubeListBuilder.create(), PartPose.offset(-2.5F, 2.0F, -5.0F));

		PartDefinition Fin2 = FineBone2.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(32, 11).mirror().addBox(-0.05F, -1.0F, -0.5F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BottomFin1 = Root.addOrReplaceChild("BottomFin1", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 5.0F, -4.0F));

		PartDefinition BottomFin2 = Root.addOrReplaceChild("BottomFin2", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 5.0F, -4.0F));

		PartDefinition Head = Root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 21).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Parrotfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(MantaRayAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Root;
	}
}