package com.peeko32213.seafarer.client.models.unimplemented;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.client.animations.unimplemented.BarreleyeAnimations;
import com.peeko32213.seafarer.entities.misc.unimplemented.Barreleye;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class BarreleyeModel<T extends Barreleye> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart swim_control;
	private final ModelPart Body;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart TailMid;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BottomFin1;
	private final ModelPart BottomFin2;

	public BarreleyeModel(ModelPart root) {
		this.root = root.getChild("root");
		this.swim_control = this.root.getChild("swim_control");
		this.Body = this.swim_control.getChild("Body");
		this.Eye1 = this.Body.getChild("Eye1");
		this.Eye2 = this.Body.getChild("Eye2");
		this.TailMid = this.Body.getChild("TailMid");
		this.Tail = this.TailMid.getChild("Tail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.BottomFin1 = this.Body.getChild("BottomFin1");
		this.BottomFin2 = this.Body.getChild("BottomFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition swim_control = root.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Body = swim_control.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, 0.0F, -6.0F, 13.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 35).addBox(-6.5F, -10.0F, 3.0F, 13.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(14, 49).addBox(-1.5F, 0.0F, -8.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(48, 29).addBox(0.0F, -13.0F, 4.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.025F))
				.texOffs(0, 16).addBox(-6.5F, -10.0F, -6.0F, 13.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -2.0F));

		PartDefinition Eye1 = Body.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(48, 41).addBox(-1.5F, -6.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 0.0F, -1.0F));

		PartDefinition Eye2 = Body.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(48, 41).mirror().addBox(-1.5F, -6.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 0.0F, -1.0F));

		PartDefinition TailMid = Body.addOrReplaceChild("TailMid", CubeListBuilder.create().texOffs(34, 48).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 49).addBox(-0.5F, -3.0F, 1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, -4.0F, 7.0F));

		PartDefinition Tail = TailMid.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(44, 16).addBox(0.0F, -3.0F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(34, 35).addBox(0.05F, -2.0F, -2.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.025F)), PartPose.offset(7.0F, 1.0F, 4.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(34, 35).mirror().addBox(-0.05F, -2.0F, -2.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(-7.0F, 1.0F, 4.0F));

		PartDefinition BottomFin1 = Body.addOrReplaceChild("BottomFin1", CubeListBuilder.create().texOffs(6, 49).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.025F)), PartPose.offset(5.0F, 2.75F, 2.0F));

		PartDefinition BottomFin2 = Body.addOrReplaceChild("BottomFin2", CubeListBuilder.create().texOffs(6, 49).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(-5.0F, 2.75F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Barreleye entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(BarreleyeAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);
		this.animate(entity.idleAnimationState, BarreleyeAnimations.IDLE, ageInTicks);

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