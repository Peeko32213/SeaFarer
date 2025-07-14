package com.peeko32213.seafarer.client.models.unimplemented;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.client.animations.unimplemented.ChimaeraAnimations;
import com.peeko32213.seafarer.entities.misc.unimplemented.Chimaera;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ChimaeraModel<T extends Chimaera> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart swim_control;
	private final ModelPart Body;
	private final ModelPart Mouth;
	private final ModelPart FinBase1;
	private final ModelPart Fin1;
	private final ModelPart FinBase2;
	private final ModelPart Fin2;
	private final ModelPart TailBase;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart TailMid;
	private final ModelPart TailBack;
	private final ModelPart Tail;

	public ChimaeraModel(ModelPart root) {
		this.root = root.getChild("root");
		this.swim_control = this.root.getChild("swim_control");
		this.Body = this.swim_control.getChild("Body");
		this.Mouth = this.Body.getChild("Mouth");
		this.FinBase1 = this.Body.getChild("FinBase1");
		this.Fin1 = this.FinBase1.getChild("Fin1");
		this.FinBase2 = this.Body.getChild("FinBase2");
		this.Fin2 = this.FinBase2.getChild("Fin2");
		this.TailBase = this.Body.getChild("TailBase");
		this.BackFin1 = this.TailBase.getChild("BackFin1");
		this.BackFin2 = this.TailBase.getChild("BackFin2");
		this.TailMid = this.TailBase.getChild("TailMid");
		this.TailBack = this.TailMid.getChild("TailBack");
		this.Tail = this.TailBack.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition swim_control = root.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = swim_control.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -7.0F, -10.0F, 11.0F, 11.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(28, 24).addBox(-2.5F, 2.0F, -20.0F, 5.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(16, 55).addBox(-2.5F, -6.0F, -20.0F, 5.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 51).addBox(-2.5F, -6.0F, -18.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(60, 19).addBox(-2.5F, -6.0F, -15.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(58, 54).addBox(-0.5F, -14.0F, -1.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(60, 39).addBox(-0.5F, -9.0F, 2.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 1.0F));

		PartDefinition Mouth = Body.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(56, 46).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -7.0F));

		PartDefinition FinBase1 = Body.addOrReplaceChild("FinBase1", CubeListBuilder.create().texOffs(20, 42).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 3.0F, -4.0F));

		PartDefinition Fin1 = FinBase1.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(60, 9).addBox(7.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(9.0F, 0.0F, -1.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(28, 36).addBox(0.0F, 0.0F, -1.0F, 7.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition FinBase2 = Body.addOrReplaceChild("FinBase2", CubeListBuilder.create().texOffs(20, 42).mirror().addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 3.0F, -4.0F));

		PartDefinition Fin2 = FinBase2.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(60, 9).mirror().addBox(-9.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 55).mirror().addBox(-11.0F, 0.0F, -1.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 36).mirror().addBox(-7.0F, 0.0F, -1.0F, 7.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition TailBase = Body.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(46, 55).addBox(-1.5F, -10.0F, 3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 46).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.0F));

		PartDefinition BackFin1 = TailBase.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(30, 62).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 14).addBox(1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.0F, 3.0F));

		PartDefinition BackFin2 = TailBase.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(30, 62).mirror().addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(60, 14).mirror().addBox(-3.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -1.0F, 3.0F));

		PartDefinition TailMid = TailBase.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(38, 46).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 9).addBox(-1.5F, 3.0F, 3.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 62).addBox(-0.5F, 0.0F, 6.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 53).addBox(-0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 6.0F));

		PartDefinition TailBack = TailMid.addOrReplaceChild("TailBack", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(58, 23).addBox(-1.5F, -6.0F, 3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 6.0F));

		PartDefinition Tail = TailBack.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(60, 32).addBox(-0.5F, 3.0F, 0.05F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(3, 27).addBox(-0.5F, -2.0F, 0.05F, 1.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-0.5F, -2.0F, 10.05F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(6, 62).addBox(-0.5F, 0.0F, 17.05F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Chimaera entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ChimaeraAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);

		this.swim_control.xRot = headPitch * (Mth.DEG_TO_RAD);
		this.swim_control.zRot = netHeadYaw * ((Mth.DEG_TO_RAD) / 2);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}