package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.Tuna;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class TunaModel<T extends Tuna> extends HierarchicalModel<T>  {

	private final ModelPart root;
	private final ModelPart tail_body;
	private final ModelPart tail;
	private final ModelPart fin_1;
	private final ModelPart fin_2;
	private final ModelPart lower_fin_1;
	private final ModelPart lower_fin_2;

	public TunaModel(ModelPart root) {
		this.root = root.getChild("root");
		this.tail_body = this.root.getChild("tail_body");
		this.tail = this.tail_body.getChild("tail");
		this.fin_1 = this.root.getChild("fin_1");
		this.fin_2 = this.root.getChild("fin_2");
		this.lower_fin_1 = this.root.getChild("lower_fin_1");
		this.lower_fin_2 = this.root.getChild("lower_fin_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -18.0F, -18.0F, 15.0F, 18.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 50).addBox(0.0F, -24.0F, 4.0F, 0.0F, 6.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(92, 71).addBox(0.0F, -24.0F, -7.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(40, 50).addBox(0.0F, 0.0F, 5.0F, 0.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tail_body = root.addOrReplaceChild("tail_body", CubeListBuilder.create().texOffs(80, 50).addBox(0.0F, -3.0F, -1.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(58, 76).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 14.0F));

		PartDefinition tail = tail_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 76).addBox(0.0F, -10.0F, 0.0F, 0.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 13.0F));

		PartDefinition fin_1 = root.addOrReplaceChild("fin_1", CubeListBuilder.create().texOffs(24, 76).addBox(-0.175F, -2.0F, -1.0F, 0.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.75F, -8.0F, -6.0F, 0.3054F, 0.3491F, 0.0F));

		PartDefinition fin_2 = root.addOrReplaceChild("fin_2", CubeListBuilder.create().texOffs(24, 76).mirror().addBox(0.175F, -2.0F, -1.0F, 0.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.75F, -8.0F, -6.0F, 0.3054F, -0.3491F, 0.0F));

		PartDefinition lower_fin_1 = root.addOrReplaceChild("lower_fin_1", CubeListBuilder.create().texOffs(92, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -4.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition lower_fin_2 = root.addOrReplaceChild("lower_fin_2", CubeListBuilder.create().texOffs(92, 86).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.5236F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Tuna entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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