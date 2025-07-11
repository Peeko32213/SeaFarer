package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.client.animations.CopperbandButterflyFishAnimations;
import com.peeko32213.seafarer.entities.CopperbandButterflyfish;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class CopperbandButterflyFishModel<T extends CopperbandButterflyfish> extends HierarchicalModel<T> {
	private final ModelPart Body;
	private final ModelPart FinRoot1;
	private final ModelPart Fin1;
	private final ModelPart FinRoot2;
	private final ModelPart Fin2;
	private final ModelPart TailMid;
	private final ModelPart Tail;
	private final ModelPart TopFin;
	private final ModelPart BottomFin;

	public CopperbandButterflyFishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.FinRoot1 = this.Body.getChild("FinRoot1");
		this.Fin1 = this.FinRoot1.getChild("Fin1");
		this.FinRoot2 = this.Body.getChild("FinRoot2");
		this.Fin2 = this.FinRoot2.getChild("Fin2");
		this.TailMid = this.Body.getChild("TailMid");
		this.Tail = this.TailMid.getChild("Tail");
		this.TopFin = this.Body.getChild("TopFin");
		this.BottomFin = this.Body.getChild("BottomFin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -8.0F, -4.0F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(18, 17).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 9).addBox(1.0F, 2.0F, -3.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 9).addBox(-1.0F, 2.0F, -3.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 19.0F, 0.0F));

		PartDefinition FinRoot1 = Body.addOrReplaceChild("FinRoot1", CubeListBuilder.create(), PartPose.offset(1.5F, -2.0F, 0.0F));

		PartDefinition Fin1 = FinRoot1.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(26, 23).addBox(0.025F, -1.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinRoot2 = Body.addOrReplaceChild("FinRoot2", CubeListBuilder.create(), PartPose.offset(-0.5F, -2.0F, 0.0F));

		PartDefinition Fin2 = FinRoot2.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(26, 23).mirror().addBox(-0.025F, -1.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition TailMid = Body.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(26, 14).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 3.0F));

		PartDefinition Tail = TailMid.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(20, 9).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition TopFin = Body.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -5.0F, -6.0F, 0.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 2.0F));

		PartDefinition BottomFin = Body.addOrReplaceChild("BottomFin", CubeListBuilder.create().texOffs(18, 23).addBox(0.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(CopperbandButterflyfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.animateWalk(CopperbandButterflyFishAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);

		this.Body.xRot = headPitch * (Mth.DEG_TO_RAD);
		this.Body.zRot = netHeadYaw * ((Mth.DEG_TO_RAD) / 2);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Body;
	}
}