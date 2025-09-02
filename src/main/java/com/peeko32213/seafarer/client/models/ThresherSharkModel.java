package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.ThresherShark;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ThresherSharkModel<T extends ThresherShark> extends HierarchicalModel<T>  {

	private final ModelPart Body;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart BackBody;
	private final ModelPart TailBone;
	private final ModelPart TailBase;
	private final ModelPart TailMid;
	private final ModelPart TailBack;

	public ThresherSharkModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.BackFin1 = this.Body.getChild("BackFin1");
		this.BackFin2 = this.Body.getChild("BackFin2");
		this.BackBody = this.Body.getChild("BackBody");
		this.TailBone = this.BackBody.getChild("TailBone");
		this.TailBase = this.TailBone.getChild("TailBase");
		this.TailMid = this.TailBase.getChild("TailMid");
		this.TailBack = this.TailMid.getChild("TailBack");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -17.0F, -1.0F, 15.0F, 17.0F, 16.0F, new CubeDeformation(0.01F))
		.texOffs(46, 66).addBox(-3.5F, -8.0F, -8.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 67).addBox(-0.5F, -25.0F, 13.0F, 1.0F, 17.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 109).addBox(-3.5F, -1.5F, -8.25F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(62, 25).addBox(0.0F, 0.0F, 5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(0.0F, 0.0F, -1.0F, 28.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(62, 25).mirror().addBox(-3.0F, 0.0F, 5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 33).mirror().addBox(-28.0F, 0.0F, -1.0F, 28.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, -1.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(62, 29).addBox(0.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 37).addBox(0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.0F, 14.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(62, 29).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 37).mirror().addBox(-1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, -1.0F, 14.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(74, 25).addBox(-0.5F, -4.0F, 5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 67).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 15.0F));

		PartDefinition TailBone = BackBody.addOrReplaceChild("TailBone", CubeListBuilder.create(), PartPose.offset(0.5F, -1.0F, 7.0F));

		PartDefinition TailBase = TailBone.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(62, 0).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 5.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(38, 67).addBox(-0.5F, 2.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition TailMid = TailBase.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(0, 40).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 20.0F));

		PartDefinition TailBack = TailMid.addOrReplaceChild("TailBack", CubeListBuilder.create().texOffs(46, 40).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 5.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(68, 32).addBox(-0.5F, 2.0F, 18.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 22.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(ThresherShark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.Body;
	}
}