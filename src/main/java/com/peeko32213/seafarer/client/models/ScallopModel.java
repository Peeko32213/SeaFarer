package com.peeko32213.seafarer.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.entities.Scallop;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ScallopModel<T extends Scallop> extends HierarchicalModel<T>  {

	private final ModelPart root;
	private final ModelPart top_shell;
	private final ModelPart bottom_shell;

	public ScallopModel(ModelPart root) {
		this.root = root.getChild("root");
		this.top_shell = this.root.getChild("top_shell");
		this.bottom_shell = this.root.getChild("bottom_shell");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 19).addBox(-3.0F, -1.75F, -4.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 2.0F));

		PartDefinition top_shell = root.addOrReplaceChild("top_shell", CubeListBuilder.create().texOffs(24, 19).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -1.75F, -8.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.01F))
		.texOffs(25, 22).addBox(-1.0F, -0.75F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, 3.0F));

		PartDefinition bottom_shell = root.addOrReplaceChild("bottom_shell", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Scallop entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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