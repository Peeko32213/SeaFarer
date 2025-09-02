package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.ManOWar;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ManOWarModel<T extends ManOWar> extends HierarchicalModel<T>  {
	private final ModelPart man_o_war;
	private final ModelPart base;
	private final ModelPart small_arms;
	private final ModelPart front_arm_cluster_1;
	private final ModelPart front_arm_1;
	private final ModelPart front_arm_2;
	private final ModelPart back_arm_cluster_1;
	private final ModelPart back_arm_1;
	private final ModelPart back_arm_2;
	private final ModelPart back_arm_cluster_2;
	private final ModelPart back_arm_3;
	private final ModelPart back_arm_4;
	private final ModelPart front_arm_cluster_2;
	private final ModelPart front_arm_3;
	private final ModelPart front_arm_4;
	private final ModelPart right_arm_cluster_1;
	private final ModelPart right_arm_1;
	private final ModelPart right_arm_2;
	private final ModelPart right_arm_cluster_2;
	private final ModelPart right_arm_3;
	private final ModelPart right_arm_4;
	private final ModelPart left_arm_cluster_1;
	private final ModelPart left_arm_1;
	private final ModelPart left_arm_2;
	private final ModelPart left_arm_cluster_2;
	private final ModelPart left_arm_3;
	private final ModelPart left_arm_4;
	private final ModelPart large_arms;
	private final ModelPart big_arms_1;
	private final ModelPart big_arm_1;
	private final ModelPart big_arm_3;
	private final ModelPart big_arm_2;
	private final ModelPart big_arms_2;
	private final ModelPart big_arm_4;
	private final ModelPart big_arm_5;
	private final ModelPart big_arm_6;

	public ManOWarModel(ModelPart root) {
		this.man_o_war = root.getChild("man_o_war");
		this.base = this.man_o_war.getChild("base");
		this.small_arms = this.base.getChild("small_arms");
		this.front_arm_cluster_1 = this.small_arms.getChild("front_arm_cluster_1");
		this.front_arm_1 = this.front_arm_cluster_1.getChild("front_arm_1");
		this.front_arm_2 = this.front_arm_cluster_1.getChild("front_arm_2");
		this.back_arm_cluster_1 = this.small_arms.getChild("back_arm_cluster_1");
		this.back_arm_1 = this.back_arm_cluster_1.getChild("back_arm_1");
		this.back_arm_2 = this.back_arm_cluster_1.getChild("back_arm_2");
		this.back_arm_cluster_2 = this.small_arms.getChild("back_arm_cluster_2");
		this.back_arm_3 = this.back_arm_cluster_2.getChild("back_arm_3");
		this.back_arm_4 = this.back_arm_cluster_2.getChild("back_arm_4");
		this.front_arm_cluster_2 = this.small_arms.getChild("front_arm_cluster_2");
		this.front_arm_3 = this.front_arm_cluster_2.getChild("front_arm_3");
		this.front_arm_4 = this.front_arm_cluster_2.getChild("front_arm_4");
		this.right_arm_cluster_1 = this.small_arms.getChild("right_arm_cluster_1");
		this.right_arm_1 = this.right_arm_cluster_1.getChild("right_arm_1");
		this.right_arm_2 = this.right_arm_cluster_1.getChild("right_arm_2");
		this.right_arm_cluster_2 = this.small_arms.getChild("right_arm_cluster_2");
		this.right_arm_3 = this.right_arm_cluster_2.getChild("right_arm_3");
		this.right_arm_4 = this.right_arm_cluster_2.getChild("right_arm_4");
		this.left_arm_cluster_1 = this.small_arms.getChild("left_arm_cluster_1");
		this.left_arm_1 = this.left_arm_cluster_1.getChild("left_arm_1");
		this.left_arm_2 = this.left_arm_cluster_1.getChild("left_arm_2");
		this.left_arm_cluster_2 = this.small_arms.getChild("left_arm_cluster_2");
		this.left_arm_3 = this.left_arm_cluster_2.getChild("left_arm_3");
		this.left_arm_4 = this.left_arm_cluster_2.getChild("left_arm_4");
		this.large_arms = this.base.getChild("large_arms");
		this.big_arms_1 = this.large_arms.getChild("big_arms_1");
		this.big_arm_1 = this.big_arms_1.getChild("big_arm_1");
		this.big_arm_3 = this.big_arms_1.getChild("big_arm_3");
		this.big_arm_2 = this.big_arms_1.getChild("big_arm_2");
		this.big_arms_2 = this.large_arms.getChild("big_arms_2");
		this.big_arm_4 = this.big_arms_2.getChild("big_arm_4");
		this.big_arm_5 = this.big_arms_2.getChild("big_arm_5");
		this.big_arm_6 = this.big_arms_2.getChild("big_arm_6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition man_o_war = partdefinition.addOrReplaceChild("man_o_war", CubeListBuilder.create().texOffs(32, 25).addBox(-0.5F, -15.0F, -1.0F, 1.0F, 10.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -9.0F, -6.0F, 10.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(75, 31).addBox(0.0F, -20.0F, -1.0F, 0.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -2.0F));

		PartDefinition base = man_o_war.addOrReplaceChild("base", CubeListBuilder.create().texOffs(32, 47).addBox(-8.0F, -4.0F, -6.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(50, 10).addBox(-7.0F, -7.0F, -5.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(50, 0).addBox(-8.0F, -6.0F, -6.0F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 8.0F, 1.0F));

		PartDefinition small_arms = base.addOrReplaceChild("small_arms", CubeListBuilder.create(), PartPose.offset(-3.5F, -2.0F, -1.0F));

		PartDefinition front_arm_cluster_1 = small_arms.addOrReplaceChild("front_arm_cluster_1", CubeListBuilder.create(), PartPose.offset(-3.0F, 2.0F, -5.0F));

		PartDefinition front_arm_1 = front_arm_cluster_1.addOrReplaceChild("front_arm_1", CubeListBuilder.create().texOffs(16, 55).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, 1.0F));

		PartDefinition front_arm_2 = front_arm_cluster_1.addOrReplaceChild("front_arm_2", CubeListBuilder.create().texOffs(12, 55).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.0F, 1.0F));

		PartDefinition back_arm_cluster_1 = small_arms.addOrReplaceChild("back_arm_cluster_1", CubeListBuilder.create(), PartPose.offset(-3.0F, 2.0F, 2.0F));

		PartDefinition back_arm_1 = back_arm_cluster_1.addOrReplaceChild("back_arm_1", CubeListBuilder.create().texOffs(16, 55).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, 1.0F));

		PartDefinition back_arm_2 = back_arm_cluster_1.addOrReplaceChild("back_arm_2", CubeListBuilder.create().texOffs(12, 55).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.0F, 1.0F));

		PartDefinition back_arm_cluster_2 = small_arms.addOrReplaceChild("back_arm_cluster_2", CubeListBuilder.create(), PartPose.offset(3.0F, 2.0F, 2.0F));

		PartDefinition back_arm_3 = back_arm_cluster_2.addOrReplaceChild("back_arm_3", CubeListBuilder.create().texOffs(16, 55).mirror().addBox(-0.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -2.0F, 1.0F));

		PartDefinition back_arm_4 = back_arm_cluster_2.addOrReplaceChild("back_arm_4", CubeListBuilder.create().texOffs(12, 55).mirror().addBox(-1.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, -2.0F, 1.0F));

		PartDefinition front_arm_cluster_2 = small_arms.addOrReplaceChild("front_arm_cluster_2", CubeListBuilder.create(), PartPose.offset(1.0F, 2.0F, -5.0F));

		PartDefinition front_arm_3 = front_arm_cluster_2.addOrReplaceChild("front_arm_3", CubeListBuilder.create().texOffs(16, 55).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, 1.0F));

		PartDefinition front_arm_4 = front_arm_cluster_2.addOrReplaceChild("front_arm_4", CubeListBuilder.create().texOffs(12, 55).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.0F, 1.0F));

		PartDefinition right_arm_cluster_1 = small_arms.addOrReplaceChild("right_arm_cluster_1", CubeListBuilder.create(), PartPose.offset(-3.5F, 0.0F, -2.0F));

		PartDefinition right_arm_1 = right_arm_cluster_1.addOrReplaceChild("right_arm_1", CubeListBuilder.create().texOffs(8, 55).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.5F));

		PartDefinition right_arm_2 = right_arm_cluster_1.addOrReplaceChild("right_arm_2", CubeListBuilder.create().texOffs(4, 55).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition right_arm_cluster_2 = small_arms.addOrReplaceChild("right_arm_cluster_2", CubeListBuilder.create(), PartPose.offset(-3.5F, 0.0F, 2.0F));

		PartDefinition right_arm_3 = right_arm_cluster_2.addOrReplaceChild("right_arm_3", CubeListBuilder.create().texOffs(8, 55).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.5F));

		PartDefinition right_arm_4 = right_arm_cluster_2.addOrReplaceChild("right_arm_4", CubeListBuilder.create().texOffs(4, 55).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition left_arm_cluster_1 = small_arms.addOrReplaceChild("left_arm_cluster_1", CubeListBuilder.create(), PartPose.offset(3.5F, 0.0F, -2.0F));

		PartDefinition left_arm_1 = left_arm_cluster_1.addOrReplaceChild("left_arm_1", CubeListBuilder.create().texOffs(8, 55).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -1.5F));

		PartDefinition left_arm_2 = left_arm_cluster_1.addOrReplaceChild("left_arm_2", CubeListBuilder.create().texOffs(4, 55).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition left_arm_cluster_2 = small_arms.addOrReplaceChild("left_arm_cluster_2", CubeListBuilder.create(), PartPose.offset(3.5F, 0.0F, 2.0F));

		PartDefinition left_arm_3 = left_arm_cluster_2.addOrReplaceChild("left_arm_3", CubeListBuilder.create().texOffs(8, 55).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -1.5F));

		PartDefinition left_arm_4 = left_arm_cluster_2.addOrReplaceChild("left_arm_4", CubeListBuilder.create().texOffs(4, 55).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition large_arms = base.addOrReplaceChild("large_arms", CubeListBuilder.create(), PartPose.offset(-3.5F, -2.0F, -1.0F));

		PartDefinition big_arms_1 = large_arms.addOrReplaceChild("big_arms_1", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 3.0F));

		PartDefinition big_arm_1 = big_arms_1.addOrReplaceChild("big_arm_1", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 42.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -7.0F, -4.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition big_arm_3 = big_arms_1.addOrReplaceChild("big_arm_3", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 42.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition big_arm_2 = big_arms_1.addOrReplaceChild("big_arm_2", CubeListBuilder.create().texOffs(0, 55).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 42.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -7.0F, -4.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition big_arms_2 = large_arms.addOrReplaceChild("big_arms_2", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, -3.0F));

		PartDefinition big_arm_4 = big_arms_2.addOrReplaceChild("big_arm_4", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 42.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -7.0F, 4.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition big_arm_5 = big_arms_2.addOrReplaceChild("big_arm_5", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 42.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition big_arm_6 = big_arms_2.addOrReplaceChild("big_arm_6", CubeListBuilder.create().texOffs(0, 55).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 42.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -7.0F, 4.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(ManOWar entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		man_o_war.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.man_o_war;
	}
}