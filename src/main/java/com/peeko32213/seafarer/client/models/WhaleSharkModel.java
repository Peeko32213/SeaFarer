package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.peeko32213.seafarer.entities.LeafySeaDragon;
import com.peeko32213.seafarer.entities.WhaleShark;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class WhaleSharkModel<T extends WhaleShark> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart tail_body;
	private final ModelPart tail;
	private final ModelPart tail_bone;
	private final ModelPart fin_1;
	private final ModelPart fin_2;
	private final ModelPart back_fin_1;
	private final ModelPart back_fin_2;
	private final ModelPart head;

	public WhaleSharkModel(ModelPart root) {
		this.root = root.getChild("root");
		this.tail_body = this.root.getChild("tail_body");
		this.tail = this.tail_body.getChild("tail");
		this.tail_bone = this.tail.getChild("tail_bone");
		this.fin_1 = this.root.getChild("fin_1");
		this.fin_2 = this.root.getChild("fin_2");
		this.back_fin_1 = this.root.getChild("back_fin_1");
		this.back_fin_2 = this.root.getChild("back_fin_2");
		this.head = this.root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 151).addBox(-20.0F, -17.0F, -16.0F, 42.0F, 28.0F, 50.0F, new CubeDeformation(0.0F))
		.texOffs(184, 206).addBox(0.0F, -30.0F, 24.0F, 2.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 13.0F, 15.0F));

		PartDefinition tail_body = root.addOrReplaceChild("tail_body", CubeListBuilder.create().texOffs(184, 151).addBox(-7.0F, -4.0F, -1.0F, 15.0F, 14.0F, 41.0F, new CubeDeformation(0.0F))
		.texOffs(220, 13).addBox(-1.0F, -11.0F, 13.0F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(220, 27).addBox(-1.0F, 10.0F, 13.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 34.0F));

		PartDefinition tail = tail_body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 3.0F, 35.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tail_bone = tail.addOrReplaceChild("tail_bone", CubeListBuilder.create().texOffs(206, 80).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 12.0F, 39.0F, new CubeDeformation(0.0F))
		.texOffs(216, 206).addBox(-0.5F, 12.0F, 0.0F, 2.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin_1 = root.addOrReplaceChild("fin_1", CubeListBuilder.create().texOffs(206, 131).addBox(0.0F, 0.0F, -3.0F, 24.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, 9.0F, -1.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition fin_2 = root.addOrReplaceChild("fin_2", CubeListBuilder.create().texOffs(206, 131).mirror().addBox(-24.0F, 0.0F, -3.0F, 24.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-20.0F, 9.0F, -1.0F, 0.0F, 0.0F, -0.8727F));

		PartDefinition back_fin_1 = root.addOrReplaceChild("back_fin_1", CubeListBuilder.create().texOffs(220, 0).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, 11.0F, 23.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition back_fin_2 = root.addOrReplaceChild("back_fin_2", CubeListBuilder.create().texOffs(220, 0).mirror().addBox(-1.0F, 0.0F, -4.0F, 2.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, 11.0F, 23.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -6.0F, -62.0F, 48.0F, 18.0F, 62.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(-23.0F, -4.0F, -59.0F, 46.0F, 14.0F, 57.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -16.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(WhaleShark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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