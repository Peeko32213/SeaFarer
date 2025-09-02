package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.Flounder;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class FlounderModel<T extends Flounder> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart top_fin;
	private final ModelPart bottom_fin;
	private final ModelPart body;
	private final ModelPart tail;

	public FlounderModel(ModelPart root) {
		this.root = root.getChild("root");
		this.top_fin = this.root.getChild("top_fin");
		this.bottom_fin = this.root.getChild("bottom_fin");
		this.body = this.root.getChild("body");
		this.tail = this.root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(26, 22).addBox(3.5F, -1.25F, -3.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 23).addBox(3.5F, -0.5F, -3.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition top_fin = root.addOrReplaceChild("top_fin", CubeListBuilder.create().texOffs(14, 22).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.025F, -1.0F));

		PartDefinition bottom_fin = root.addOrReplaceChild("bottom_fin", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.05F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(22, 26).addBox(-1.0F, -2.0F, -4.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -1.0F, -5.0F, 7.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(12, 26).addBox(0.0F, -1.0F, -7.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-6.0F, 0.0F, -2.0F, 11.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.0F, 0.0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Flounder entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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