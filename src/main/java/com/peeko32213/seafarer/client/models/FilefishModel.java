package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.CopperbandButterflyFishAnimations;
import com.peeko32213.seafarer.client.animations.FilefishAnimations;
import com.peeko32213.seafarer.entities.CopperbandButterflyfish;
import com.peeko32213.seafarer.entities.Filefish;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class FilefishModel<T extends Filefish> extends HierarchicalModel<T> {
	private final ModelPart Root;
	private final ModelPart TopThing1;
	private final ModelPart BottomThing1;
	private final ModelPart TopFin;
	private final ModelPart BottomFin;
	private final ModelPart Tail;
	private final ModelPart FinRoot1;
	private final ModelPart Fin1;
	private final ModelPart FinRoot2;
	private final ModelPart Fin2;

	public FilefishModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.TopThing1 = this.Root.getChild("TopThing1");
		this.BottomThing1 = this.Root.getChild("BottomThing1");
		this.TopFin = this.Root.getChild("TopFin");
		this.BottomFin = this.Root.getChild("BottomFin");
		this.Tail = this.Root.getChild("Tail");
		this.FinRoot1 = this.Root.getChild("FinRoot1");
		this.Fin1 = this.FinRoot1.getChild("Fin1");
		this.FinRoot2 = this.Root.getChild("FinRoot2");
		this.Fin2 = this.FinRoot2.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -1.0F));

		PartDefinition TopThing1 = Root.addOrReplaceChild("TopThing1", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -3.0F, -3.0F));

		PartDefinition BottomThing1 = Root.addOrReplaceChild("BottomThing1", CubeListBuilder.create().texOffs(4, 15).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, -3.0F));

		PartDefinition TopFin = Root.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(10, 10).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition BottomFin = Root.addOrReplaceChild("BottomFin", CubeListBuilder.create().texOffs(14, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Tail = Root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(14, 5).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition FinRoot1 = Root.addOrReplaceChild("FinRoot1", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition Fin1 = FinRoot1.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(12, 14).addBox(0.025F, -2.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinRoot2 = Root.addOrReplaceChild("FinRoot2", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition Fin2 = FinRoot2.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(12, 14).mirror().addBox(-0.025F, -2.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Filefish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.animateWalk(FilefishAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);

		this.Root.xRot = headPitch * (Mth.DEG_TO_RAD);
		this.Root.zRot = netHeadYaw * ((Mth.DEG_TO_RAD) / 2);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Root;
	}
}