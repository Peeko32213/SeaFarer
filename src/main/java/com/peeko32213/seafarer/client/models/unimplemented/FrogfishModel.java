package com.peeko32213.seafarer.client.models.unimplemented;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.peeko32213.seafarer.client.animations.unimplemented.FrogfishAnimations;
import com.peeko32213.seafarer.entities.misc.unimplemented.Frogfish;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FrogfishModel<T extends Frogfish> extends HierarchicalModel<T> {
	private final ModelPart Frogfish;
	private final ModelPart FootBase1;
	private final ModelPart Foot1;
	private final ModelPart Toes1;
	private final ModelPart FootBase2;
	private final ModelPart Foot2;
	private final ModelPart Toes2;
	private final ModelPart Body;
	private final ModelPart Mouth;
	private final ModelPart Lure;
	private final ModelPart Tail;

	public FrogfishModel(ModelPart root) {
		this.Frogfish = root.getChild("Frogfish");
		this.FootBase1 = this.Frogfish.getChild("FootBase1");
		this.Foot1 = this.FootBase1.getChild("Foot1");
		this.Toes1 = this.Foot1.getChild("Toes1");
		this.FootBase2 = this.Frogfish.getChild("FootBase2");
		this.Foot2 = this.FootBase2.getChild("Foot2");
		this.Toes2 = this.Foot2.getChild("Toes2");
		this.Body = this.Frogfish.getChild("Body");
		this.Mouth = this.Body.getChild("Mouth");
		this.Lure = this.Body.getChild("Lure");
		this.Tail = this.Body.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Frogfish = partdefinition.addOrReplaceChild("Frogfish", CubeListBuilder.create(), PartPose.offset(-2.0F, 22.0F, 0.0F));

		PartDefinition FootBase1 = Frogfish.addOrReplaceChild("FootBase1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.25F, -1.0F, 2.0F, 0.0F, 0.6545F, 0.0F));

		PartDefinition Foot1 = FootBase1.addOrReplaceChild("Foot1", CubeListBuilder.create().texOffs(-1, 22).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Toes1 = Foot1.addOrReplaceChild("Toes1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 4.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(0.0F, 4.0F, -1.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 13).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition FootBase2 = Frogfish.addOrReplaceChild("FootBase2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, -1.0F, 2.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition Foot2 = FootBase2.addOrReplaceChild("Foot2", CubeListBuilder.create().texOffs(-1, 22).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Toes2 = Foot2.addOrReplaceChild("Toes2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 4.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 2).mirror().addBox(-2.0F, 4.0F, -1.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(10, 13).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Body = Frogfish.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(0.0F, -8.0F, -1.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(15, 2).addBox(0.0F, -1.0F, 5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 0).addBox(1.0F, 0.0F, 1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 0).mirror().addBox(-1.0F, 0.0F, 1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Mouth = Body.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition Lure = Body.addOrReplaceChild("Lure", CubeListBuilder.create().texOffs(14, 13).addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -1.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 6.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Frogfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.animateWalk(FrogfishAnimations.WALK, limbSwing, limbSwingAmount, 4, 8);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Frogfish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.Frogfish;
	}
}