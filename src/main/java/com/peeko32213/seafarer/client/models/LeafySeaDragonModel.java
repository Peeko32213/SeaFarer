package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.peeko32213.seafarer.entities.Flounder;
import com.peeko32213.seafarer.entities.HorseshoeCrab;
import com.peeko32213.seafarer.entities.LeafySeaDragon;
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
public class LeafySeaDragonModel<T extends LeafySeaDragon> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart tail;
	private final ModelPart tail_part_1;
	private final ModelPart tail_fin_1;
	private final ModelPart tail_fin_2;
	private final ModelPart back_tail_fin_1;
	private final ModelPart back_tail_fin_2;
	private final ModelPart tail_part_2;
	private final ModelPart tail_part_3;
	private final ModelPart tail_leaf_core;
	private final ModelPart tail_leaf_1;
	private final ModelPart tail_leaf_2;
	private final ModelPart body;
	private final ModelPart back_fin_1;
	private final ModelPart back_fin_2;
	private final ModelPart back_body_fin_1;
	private final ModelPart back_body_fin_2;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart face_leaf_1;
	private final ModelPart face_leaf_2;
	private final ModelPart snout_leaf_1;
	private final ModelPart snout_leaf_2;
	private final ModelPart front_fin_1;
	private final ModelPart front_fin_2;

	public LeafySeaDragonModel(ModelPart root) {
		this.root = root.getChild("root");
		this.tail = this.root.getChild("tail");
		this.tail_part_1 = this.tail.getChild("tail_part_1");
		this.tail_fin_1 = this.tail_part_1.getChild("tail_fin_1");
		this.tail_fin_2 = this.tail_part_1.getChild("tail_fin_2");
		this.back_tail_fin_1 = this.tail_part_1.getChild("back_tail_fin_1");
		this.back_tail_fin_2 = this.tail_part_1.getChild("back_tail_fin_2");
		this.tail_part_2 = this.tail_part_1.getChild("tail_part_2");
		this.tail_part_3 = this.tail_part_2.getChild("tail_part_3");
		this.tail_leaf_core = this.tail_part_3.getChild("tail_leaf_core");
		this.tail_leaf_1 = this.tail_leaf_core.getChild("tail_leaf_1");
		this.tail_leaf_2 = this.tail_leaf_core.getChild("tail_leaf_2");
		this.body = this.root.getChild("body");
		this.back_fin_1 = this.body.getChild("back_fin_1");
		this.back_fin_2 = this.body.getChild("back_fin_2");
		this.back_body_fin_1 = this.body.getChild("back_body_fin_1");
		this.back_body_fin_2 = this.body.getChild("back_body_fin_2");
		this.neck = this.body.getChild("neck");
		this.head = this.neck.getChild("head");
		this.face_leaf_1 = this.head.getChild("face_leaf_1");
		this.face_leaf_2 = this.head.getChild("face_leaf_2");
		this.snout_leaf_1 = this.head.getChild("snout_leaf_1");
		this.snout_leaf_2 = this.head.getChild("snout_leaf_2");
		this.front_fin_1 = this.body.getChild("front_fin_1");
		this.front_fin_2 = this.body.getChild("front_fin_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 13.0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(52, 0).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition tail_part_1 = tail.addOrReplaceChild("tail_part_1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.01F))
		.texOffs(52, 55).addBox(0.05F, -8.0F, 4.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tail_fin_1 = tail_part_1.addOrReplaceChild("tail_fin_1", CubeListBuilder.create().texOffs(0, 36).addBox(0.0F, -14.0F, -1.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, -3.0F, 1.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition tail_fin_2 = tail_part_1.addOrReplaceChild("tail_fin_2", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(0.0F, -14.0F, -1.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.55F, -3.0F, 1.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition back_tail_fin_1 = tail_part_1.addOrReplaceChild("back_tail_fin_1", CubeListBuilder.create().texOffs(0, 36).addBox(0.0F, -14.0F, -1.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, -3.0F, 11.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition back_tail_fin_2 = tail_part_1.addOrReplaceChild("back_tail_fin_2", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(0.0F, -14.0F, -1.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.55F, -3.0F, 11.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition tail_part_2 = tail_part_1.addOrReplaceChild("tail_part_2", CubeListBuilder.create().texOffs(36, 55).addBox(0.05F, -2.0F, 2.0F, 0.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(18, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 13.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition tail_part_3 = tail_part_2.addOrReplaceChild("tail_part_3", CubeListBuilder.create().texOffs(60, 22).addBox(-0.5F, -2.0F, -5.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -1.0F));

		PartDefinition tail_leaf_core = tail_part_3.addOrReplaceChild("tail_leaf_core", CubeListBuilder.create().texOffs(64, 0).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -4.5F));

		PartDefinition tail_leaf_1 = tail_leaf_core.addOrReplaceChild("tail_leaf_1", CubeListBuilder.create().texOffs(72, 0).addBox(0.0F, -4.0F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tail_leaf_2 = tail_leaf_core.addOrReplaceChild("tail_leaf_2", CubeListBuilder.create().texOffs(72, 0).mirror().addBox(0.0F, -4.0F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -13.0F));

		PartDefinition back_fin_1 = body.addOrReplaceChild("back_fin_1", CubeListBuilder.create().texOffs(32, 32).addBox(0.0F, -14.0F, -2.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.05F, -4.0F, -1.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition back_fin_2 = body.addOrReplaceChild("back_fin_2", CubeListBuilder.create().texOffs(32, 32).mirror().addBox(0.0F, -14.0F, -2.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.05F, -4.0F, -1.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition back_body_fin_1 = body.addOrReplaceChild("back_body_fin_1", CubeListBuilder.create().texOffs(18, 55).addBox(0.0F, 0.0F, -2.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.05F, 0.0F, 5.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition back_body_fin_2 = body.addOrReplaceChild("back_body_fin_2", CubeListBuilder.create().texOffs(18, 55).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.05F, 0.0F, 5.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 61).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -5.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 12).mirror().addBox(-1.0F, -4.0F, -5.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 85).mirror().addBox(-0.75F, -7.0F, -5.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(34, 12).addBox(1.5F, -4.0F, -5.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 85).addBox(1.25F, -7.0F, -5.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 18).addBox(-0.75F, -2.0F, -16.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(60, 14).addBox(-0.75F, -3.0F, -4.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(46, 14).addBox(-1.25F, -3.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 36).addBox(0.25F, -6.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, -5.0F, 0.0F));

		PartDefinition face_leaf_1 = head.addOrReplaceChild("face_leaf_1", CubeListBuilder.create().texOffs(10, 59).addBox(0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -1.0F, -4.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition face_leaf_2 = head.addOrReplaceChild("face_leaf_2", CubeListBuilder.create().texOffs(10, 59).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, -1.0F, -4.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition snout_leaf_1 = head.addOrReplaceChild("snout_leaf_1", CubeListBuilder.create().texOffs(34, 0).addBox(0.25F, 0.0F, -4.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -12.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition snout_leaf_2 = head.addOrReplaceChild("snout_leaf_2", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-0.25F, 0.0F, -4.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition front_fin_1 = body.addOrReplaceChild("front_fin_1", CubeListBuilder.create().texOffs(50, 32).addBox(0.05F, 0.0F, -2.0F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -4.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition front_fin_2 = body.addOrReplaceChild("front_fin_2", CubeListBuilder.create().texOffs(50, 32).mirror().addBox(-0.05F, 0.0F, -2.0F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(LeafySeaDragon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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