package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.MahiMahi;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class MahiMahiModel<T extends MahiMahi> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart fin_1;
	private final ModelPart fin_2;
	private final ModelPart mouth;
	private final ModelPart back_body;
	private final ModelPart tail_body;
	private final ModelPart tail;

	public MahiMahiModel(ModelPart root) {
		this.root = root.getChild("root");
		this.fin_1 = this.root.getChild("fin_1");
		this.fin_2 = this.root.getChild("fin_2");
		this.mouth = this.root.getChild("mouth");
		this.back_body = this.root.getChild("back_body");
		this.tail_body = this.back_body.getChild("tail_body");
		this.tail = this.tail_body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(1.05F, -10.0F, -6.0F, 7.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(4.55F, -14.0F, -5.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(4.55F, 0.0F, 2.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.55F, 24.0F, 0.0F));

		PartDefinition fin_1 = root.addOrReplaceChild("fin_1", CubeListBuilder.create().texOffs(38, 20).addBox(0.1F, 0.0F, -1.0F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -2.0F, 0.0F));

		PartDefinition fin_2 = root.addOrReplaceChild("fin_2", CubeListBuilder.create().texOffs(38, 20).mirror().addBox(-0.1F, 0.0F, -1.0F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.1F, -2.0F, 0.0F));

		PartDefinition mouth = root.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(6, 46).mirror().addBox(-4.0F, 2.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(36, 13).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 43).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 46).addBox(2.0F, 2.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.55F, -1.95F, -5.0F));

		PartDefinition back_body = root.addOrReplaceChild("back_body", CubeListBuilder.create().texOffs(0, 35).addBox(-1.45F, -2.0F, 0.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(20, 21).addBox(0.05F, -7.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(20, 35).addBox(0.05F, 2.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -5.0F, 5.0F));

		PartDefinition tail_body = back_body.addOrReplaceChild("tail_body", CubeListBuilder.create().texOffs(38, 35).addBox(-0.95F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition tail = tail_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 0).addBox(0.05F, -3.0F, 0.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(MahiMahi entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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