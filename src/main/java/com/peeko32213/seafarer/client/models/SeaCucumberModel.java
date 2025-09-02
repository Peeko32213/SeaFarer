package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.SeaCucumber;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class SeaCucumberModel<T extends SeaCucumber> extends HierarchicalModel<T>  {

	private final ModelPart root;

	public SeaCucumberModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 22).addBox(-6.0F, -5.0F, 0.0F, 5.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -6.0F, -1.0F, 7.0F, 7.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(38, 35).addBox(-2.0F, -7.0F, 0.0F, 0.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(38, 22).addBox(0.0F, -4.0F, 0.0F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(38, 22).mirror().addBox(-8.0F, -4.0F, 0.0F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(38, 35).mirror().addBox(-5.0F, -7.0F, 0.0F, 0.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 23.0F, -6.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(SeaCucumber entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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