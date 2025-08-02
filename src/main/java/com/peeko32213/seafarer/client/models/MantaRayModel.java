package com.peeko32213.seafarer.client.models;

import com.peeko32213.seafarer.client.animations.MantaRayAnimations;
import com.peeko32213.seafarer.entities.MantaRay;
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
public class MantaRayModel<T extends MantaRay> extends HierarchicalModel<T> {

	private final ModelPart swim_control;
	private final ModelPart Body;
	private final ModelPart Wing1;
	private final ModelPart WingTip1;
	private final ModelPart Wing2;
	private final ModelPart WingTip2;
	private final ModelPart Thingy1;
	private final ModelPart Thingy2;
	private final ModelPart Tail;

	public MantaRayModel(ModelPart root) {
		this.swim_control = root.getChild("swim_control");
		this.Body = this.swim_control.getChild("Body");
		this.Wing1 = this.Body.getChild("Wing1");
		this.WingTip1 = this.Wing1.getChild("WingTip1");
		this.Wing2 = this.Body.getChild("Wing2");
		this.WingTip2 = this.Wing2.getChild("WingTip2");
		this.Thingy1 = this.Body.getChild("Thingy1");
		this.Thingy2 = this.Body.getChild("Thingy2");
		this.Tail = this.Body.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition swim_control = partdefinition.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, -1.0F));

		PartDefinition Body = swim_control.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(173, 0).addBox(-0.5F, -12.0F, 14.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-17.0F, -9.0F, -17.0F, 34.0F, 16.0F, 34.0F, new CubeDeformation(0.0F))
		.texOffs(13, 140).addBox(-15.0F, -8.0F, -13.5F, 30.0F, 14.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Wing1 = Body.addOrReplaceChild("Wing1", CubeListBuilder.create().texOffs(0, 50).addBox(-28.0F, -5.0F, -16.0F, 28.0F, 5.0F, 29.0F, new CubeDeformation(0.01F)), PartPose.offset(-13.925F, -1.0F, 3.15F));

		PartDefinition WingTip1 = Wing1.addOrReplaceChild("WingTip1", CubeListBuilder.create().texOffs(0, 84).addBox(-17.0F, -2.0F, -8.0F, 17.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(-28.0F, -3.0F, -8.0F));

		PartDefinition Wing2 = Body.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(0, 50).mirror().addBox(0.0F, -5.0F, -16.0F, 28.0F, 5.0F, 29.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(13.925F, -1.0F, 3.15F));

		PartDefinition WingTip2 = Wing2.addOrReplaceChild("WingTip2", CubeListBuilder.create().texOffs(0, 84).mirror().addBox(-1.0F, -2.0F, -8.0F, 17.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(29.0F, -3.0F, -8.0F));

		PartDefinition Thingy1 = Body.addOrReplaceChild("Thingy1", CubeListBuilder.create().texOffs(0, 104).addBox(0.0F, -2.0F, -8.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 104).addBox(0.0F, -2.0F, -8.0F, 0.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 4.0F, -17.0F));

		PartDefinition Thingy2 = Body.addOrReplaceChild("Thingy2", CubeListBuilder.create().texOffs(0, 104).mirror().addBox(-12.0F, -2.0F, -8.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 104).mirror().addBox(0.0F, -2.0F, -8.0F, 0.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 4.0F, -17.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(173, 210).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 17.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(MantaRay entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(MantaRayAnimations.SWIM, limbSwing, limbSwingAmount, 4, 8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Body;
	}
}