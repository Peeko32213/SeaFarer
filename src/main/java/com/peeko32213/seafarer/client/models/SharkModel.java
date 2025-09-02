package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.Shark;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class SharkModel<T extends Shark> extends HierarchicalModel<T> {

	private final ModelPart Shark;
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Tail;
	private final ModelPart TopTail;
	private final ModelPart BottomTail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Head;

	public SharkModel(ModelPart root) {
		this.Shark = root.getChild("Shark");
		this.Body = this.Shark.getChild("Body");
		this.BackBody = this.Body.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
		this.TopTail = this.Tail.getChild("TopTail");
		this.BottomTail = this.Tail.getChild("BottomTail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.BackFin1 = this.Body.getChild("BackFin1");
		this.BackFin2 = this.Body.getChild("BackFin2");
		this.Head = this.Body.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Shark = partdefinition.addOrReplaceChild("Shark", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 1.0F));

		PartDefinition Body = Shark.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -18.0F, 4.0F, 1.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -8.0F, -9.0F, 13.0F, 15.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 33).addBox(-5.0F, -1.0F, 0.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-1.0F, -3.0F, 4.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 0).addBox(-1.0F, 7.0F, 4.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 9.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 9.5F));

		PartDefinition TopTail = Tail.addOrReplaceChild("TopTail", CubeListBuilder.create().texOffs(0, 51).addBox(-1.0F, -18.0F, 0.0F, 1.0F, 18.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition BottomTail = Tail.addOrReplaceChild("BottomTail", CubeListBuilder.create().texOffs(12, 51).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(44, 11).addBox(0.0F, 0.0F, 0.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, -5.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(44, 11).mirror().addBox(-12.0F, 0.0F, 0.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 2.0F, -5.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(28, 33).addBox(-1.0F, 0.0F, -1.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(28, 33).mirror().addBox(-4.0F, 0.0F, -1.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 5.0F, 8.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 33).addBox(-5.0F, -2.0F, -10.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-5.0F, 4.0F, -10.25F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -3.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Shark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Shark.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.Shark;
	}
}