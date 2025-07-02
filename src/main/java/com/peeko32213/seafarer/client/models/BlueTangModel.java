package com.peeko32213.seafarer.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.BlueTang;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class BlueTangModel<T extends BlueTang> extends HierarchicalModel<T> {

	private final ModelPart Root;
	private final ModelPart swim_control;
	private final ModelPart Body;
	private final ModelPart FinBone1;
	private final ModelPart Fin1;
	private final ModelPart FinBone2;
	private final ModelPart Fin2;
	private final ModelPart TailMid;
	private final ModelPart Tail;

	public BlueTangModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.swim_control = this.Root.getChild("swim_control");
		this.Body = this.swim_control.getChild("Body");
		this.FinBone1 = this.Body.getChild("FinBone1");
		this.Fin1 = this.FinBone1.getChild("Fin1");
		this.FinBone2 = this.Body.getChild("FinBone2");
		this.Fin2 = this.FinBone2.getChild("Fin2");
		this.TailMid = this.Body.getChild("TailMid");
		this.Tail = this.TailMid.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -1.0F));

		PartDefinition swim_control = Root.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = swim_control.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -5.0F, -3.0F, 0.0F, 11.0F, 8.0F, new CubeDeformation(0.001F))
		.texOffs(0, 0).addBox(-1.5F, -3.0F, -5.0F, 3.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinBone1 = Body.addOrReplaceChild("FinBone1", CubeListBuilder.create(), PartPose.offset(1.5F, 1.0F, -3.0F));

		PartDefinition Fin1 = FinBone1.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(22, 0).addBox(0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinBone2 = Body.addOrReplaceChild("FinBone2", CubeListBuilder.create(), PartPose.offset(-1.5F, 1.0F, -3.0F));

		PartDefinition Fin2 = FinBone2.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailMid = Body.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(14, 22).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 3.0F));

		PartDefinition Tail = TailMid.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(14, 15).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(BlueTang entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Root;
	}
}