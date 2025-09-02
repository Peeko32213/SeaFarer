package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.Sardine;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class SardineModel<T extends Sardine> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart mouth;
	private final ModelPart tail_body;
	private final ModelPart tail;
	private final ModelPart fin_1;
	private final ModelPart fin_2;

	public SardineModel(ModelPart root) {
		this.root = root.getChild("root");
		this.mouth = this.root.getChild("mouth");
		this.tail_body = this.root.getChild("tail_body");
		this.tail = this.tail_body.getChild("tail");
		this.fin_1 = this.root.getChild("fin_1");
		this.fin_2 = this.root.getChild("fin_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(16, 3).addBox(1.0F, 2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.5F, 0.0F, -2.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(16, 6).addBox(0.5F, 2.0F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 3).mirror().addBox(0.0F, 2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 14).addBox(0.5F, -2.0F, 2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-1.0F, -2.0F, -1.975F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 22.0F, -2.0F));

		PartDefinition mouth = root.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(6, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.0F, -2.0F));

		PartDefinition tail_body = root.addOrReplaceChild("tail_body", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.5F, 4.0F));

		PartDefinition tail = tail_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition fin_1 = root.addOrReplaceChild("fin_1", CubeListBuilder.create().texOffs(12, 8).addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, 1.0F));

		PartDefinition fin_2 = root.addOrReplaceChild("fin_2", CubeListBuilder.create().texOffs(12, 8).mirror().addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.5F, 1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Sardine entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}