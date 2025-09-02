package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.client.animations.MantaRayAnimations;
import com.peeko32213.seafarer.entities.ManOWar;
import com.peeko32213.seafarer.entities.Parrotfish;
import com.peeko32213.seafarer.entities.Sailfish;
import com.peeko32213.seafarer.entities.Sardine;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SailfishModel<T extends Sailfish> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart fin_1;
	private final ModelPart fin_2;
	private final ModelPart lower_fin_1;
	private final ModelPart lower_fin_2;
	private final ModelPart top_fin;
	private final ModelPart tail_body;
	private final ModelPart tail;

	public SailfishModel(ModelPart root) {
		this.root = root.getChild("root");
		this.fin_1 = this.root.getChild("fin_1");
		this.fin_2 = this.root.getChild("fin_2");
		this.lower_fin_1 = this.root.getChild("lower_fin_1");
		this.lower_fin_2 = this.root.getChild("lower_fin_2");
		this.top_fin = this.root.getChild("top_fin");
		this.tail_body = this.root.getChild("tail_body");
		this.tail = this.tail_body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(48, 24).addBox(-5.0F, -9.0F, -1.0F, 6.0F, 9.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-2.5F, -4.0F, -24.0F, 1.0F, 1.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(70, 66).addBox(-2.5F, -1.0F, -5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(42, 24).addBox(-2.5F, -3.0F, -2.025F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 45).addBox(-2.0F, -2.0F, 9.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 24.0F, 0.0F));

		PartDefinition fin_1 = root.addOrReplaceChild("fin_1", CubeListBuilder.create().texOffs(28, 59).addBox(0.1F, 0.0F, -1.0F, 0.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, 1.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition fin_2 = root.addOrReplaceChild("fin_2", CubeListBuilder.create().texOffs(28, 59).mirror().addBox(-0.1F, 0.0F, -1.0F, 0.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -1.0F, 1.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition lower_fin_1 = root.addOrReplaceChild("lower_fin_1", CubeListBuilder.create().texOffs(42, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, 0.0F, 1.0F));

		PartDefinition lower_fin_2 = root.addOrReplaceChild("lower_fin_2", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.1F, 0.0F, 1.0F));

		PartDefinition top_fin = root.addOrReplaceChild("top_fin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -10.0F, -9.0F, 0.0F, 14.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -9.0F, 7.0F));

		PartDefinition tail_body = root.addOrReplaceChild("tail_body", CubeListBuilder.create().texOffs(0, 59).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(70, 55).addBox(0.0F, -3.5F, 4.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.5F, 11.0F));

		PartDefinition tail = tail_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(48, 45).addBox(0.0F, -8.0F, 0.0F, 0.0F, 15.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Sailfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(MantaRayAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}