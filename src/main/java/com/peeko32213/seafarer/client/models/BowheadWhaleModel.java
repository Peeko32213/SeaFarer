package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.entities.BowheadWhale;
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
public class BowheadWhaleModel<T extends BowheadWhale> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart jaws;
	private final ModelPart upper_jaws;
	private final ModelPart lower_jaws;
	private final ModelPart fin_1;
	private final ModelPart fin_2;
	private final ModelPart tail_body;
	private final ModelPart tail;

	public BowheadWhaleModel(ModelPart root) {
		this.root = root.getChild("root");
		this.jaws = this.root.getChild("jaws");
		this.upper_jaws = this.jaws.getChild("upper_jaws");
		this.lower_jaws = this.jaws.getChild("lower_jaws");
		this.fin_1 = this.root.getChild("fin_1");
		this.fin_2 = this.root.getChild("fin_2");
		this.tail_body = this.root.getChild("tail_body");
		this.tail = this.tail_body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -54.0F, -30.0F, 55.0F, 54.0F, 60.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 29.0F));

		PartDefinition jaws = root.addOrReplaceChild("jaws", CubeListBuilder.create(), PartPose.offset(0.0F, -21.0F, -31.125F));

		PartDefinition upper_jaws = jaws.addOrReplaceChild("upper_jaws", CubeListBuilder.create().texOffs(0, 114).addBox(-23.0F, 3.0F, -63.0F, 45.0F, 30.0F, 61.0F, new CubeDeformation(0.0F))
		.texOffs(0, 205).addBox(-26.0F, -3.0F, -65.875F, 51.0F, 6.0F, 64.0F, new CubeDeformation(0.0F))
		.texOffs(230, 94).addBox(-4.0F, -8.0F, -21.875F, 7.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, 3.0F));

		PartDefinition lower_jaws = jaws.addOrReplaceChild("lower_jaws", CubeListBuilder.create().texOffs(230, 230).addBox(23.0F, -22.0F, -54.875F, 2.0F, 19.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(212, 114).addBox(-26.0F, -3.0F, -35.875F, 51.0F, 24.0F, 35.0F, new CubeDeformation(0.0F))
		.texOffs(230, 0).addBox(-28.0F, -3.0F, -65.875F, 55.0F, 24.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(230, 230).mirror().addBox(-26.0F, -22.0F, -54.875F, 2.0F, 19.0F, 42.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition fin_1 = root.addOrReplaceChild("fin_1", CubeListBuilder.create().texOffs(0, 275).addBox(0.0F, -1.0F, -10.0F, 25.0F, 5.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(27.0F, -8.0F, -20.0F));

		PartDefinition fin_2 = root.addOrReplaceChild("fin_2", CubeListBuilder.create().texOffs(0, 275).mirror().addBox(-25.0F, -1.0F, -10.0F, 25.0F, 5.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-27.0F, -8.0F, -20.0F));

		PartDefinition tail_body = root.addOrReplaceChild("tail_body", CubeListBuilder.create().texOffs(230, 173).addBox(-13.0F, -11.0F, 0.0F, 23.0F, 22.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 30.0F));

		PartDefinition tail = tail_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(230, 54).addBox(-24.0F, -2.0F, -3.0F, 45.0F, 5.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 19.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(BowheadWhale entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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