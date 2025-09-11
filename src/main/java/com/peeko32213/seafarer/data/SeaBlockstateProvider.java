package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static com.peeko32213.seafarer.registry.SeaBlocks.*;
import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class SeaBlockstateProvider extends BlockStateProvider {

    public SeaBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Seafarer.MOD_ID, exFileHelper);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(Seafarer.MOD_ID, "block/" + path);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    public void simpleBlockItem(Block block, ModelFile model) {
        itemModels().getBuilder(key(block).getPath()).parent(model);
    }

    @Override
    protected void registerStatesAndModels() {
        this.cubeAllBlock(ALGAE_BLOCK);

        // Azure Sea glass
        this.cubeAllBlock(LIGHT_BLUE_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(LIGHT_BLUE_SEA_GLASS, "translucent");

        this.cubeAllBlock(LIGHT_BLUE_SEA_GLASS_BRICKS);
        this.slab(LIGHT_BLUE_GLASS_BRICK_SLAB, this.blockTexture(LIGHT_BLUE_SEA_GLASS_BRICKS.get()));
        this.stairs(LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(LIGHT_BLUE_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(LIGHT_BLUE_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) LIGHT_BLUE_SEA_GLASS_PANE.get(), this.blockTexture(LIGHT_BLUE_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/light_blue_sea_glass_pane_top"), "translucent");

        // Rose Sea glass
        this.cubeAllBlock(PINK_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(PINK_SEA_GLASS, "translucent");

        this.cubeAllBlock(PINK_SEA_GLASS_BRICKS);
        this.slab(PINK_SEA_GLASS_BRICK_SLAB, this.blockTexture(PINK_SEA_GLASS_BRICKS.get()));
        this.stairs(PINK_SEA_GLASS_BRICK_STAIRS, this.blockTexture(PINK_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(PINK_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) PINK_SEA_GLASS_PANE.get(), this.blockTexture(PINK_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/pink_sea_glass_pane_top"), "translucent");

        // Lilac Sea glass
        this.cubeAllBlock(MAGENTA_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(MAGENTA_SEA_GLASS, "translucent");

        this.cubeAllBlock(MAGENTA_SEA_GLASS_BRICKS);
        this.slab(MAGENTA_SEA_GLASS_BRICK_SLAB, this.blockTexture(MAGENTA_SEA_GLASS_BRICKS.get()));
        this.stairs(MAGENTA_SEA_GLASS_BRICK_STAIRS, this.blockTexture(MAGENTA_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(MAGENTA_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) MAGENTA_SEA_GLASS_PANE.get(), this.blockTexture(MAGENTA_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/magenta_sea_glass_pane_top"), "translucent");

        // Seafoam Sea glass
        this.cubeAllBlock(GREEN_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(GREEN_SEA_GLASS, "translucent");

        this.cubeAllBlock(GREEN_SEA_GLASS_BRICKS);
        this.slab(GREEN_SEA_GLASS_BRICK_SLAB, this.blockTexture(GREEN_SEA_GLASS_BRICKS.get()));
        this.stairs(GREEN_SEA_GLASS_BRICK_STAIRS, this.blockTexture(GREEN_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(GREEN_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) GREEN_SEA_GLASS_PANE.get(), this.blockTexture(GREEN_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/green_sea_glass_pane_top"), "translucent");

        // Chartreuse Sea glass
        this.cubeAllBlock(LIME_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(LIME_SEA_GLASS, "translucent");

        this.cubeAllBlock(LIME_SEA_GLASS_BRICKS);
        this.slab(LIME_SEA_GLASS_BRICK_SLAB, this.blockTexture(LIME_SEA_GLASS_BRICKS.get()));
        this.stairs(LIME_SEA_GLASS_BRICK_STAIRS, this.blockTexture(LIME_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(LIME_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) LIME_SEA_GLASS_PANE.get(), this.blockTexture(LIME_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/lime_sea_glass_pane_top"), "translucent");

        // Citrine Sea glass
        this.cubeAllBlock(YELLOW_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(YELLOW_SEA_GLASS, "translucent");

        this.cubeAllBlock(YELLOW_SEA_GLASS_BRICKS);
        this.slab(YELLOW_SEA_GLASS_BRICK_SLAB, this.blockTexture(YELLOW_SEA_GLASS_BRICKS.get()));
        this.stairs(YELLOW_SEA_GLASS_BRICK_STAIRS, this.blockTexture(YELLOW_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(YELLOW_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) YELLOW_SEA_GLASS_PANE.get(), this.blockTexture(YELLOW_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/yellow_sea_glass_pane_top"), "translucent");

        // Amber Sea glass
        this.cubeAllBlock(ORANGE_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(ORANGE_SEA_GLASS, "translucent");

        this.cubeAllBlock(ORANGE_SEA_GLASS_BRICKS);
        this.slab(ORANGE_SEA_GLASS_BRICK_SLAB, this.blockTexture(ORANGE_SEA_GLASS_BRICKS.get()));
        this.stairs(ORANGE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(ORANGE_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(ORANGE_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) ORANGE_SEA_GLASS_PANE.get(), this.blockTexture(ORANGE_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/orange_sea_glass_pane_top"), "translucent");

        // scarlet sea glass
        this.cubeAllBlock(RED_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(RED_SEA_GLASS, "translucent");

        this.cubeAllBlock(RED_SEA_GLASS_BRICKS);
        this.slab(RED_SEA_GLASS_BRICK_SLAB, this.blockTexture(RED_SEA_GLASS_BRICKS.get()));
        this.stairs(RED_SEA_GLASS_BRICK_STAIRS, this.blockTexture(RED_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(RED_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) RED_SEA_GLASS_PANE.get(), this.blockTexture(RED_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/red_sea_glass_pane_top"), "translucent");

        // umber sea glass
        this.cubeAllBlock(BLACK_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(BLACK_SEA_GLASS, "translucent");

        this.cubeAllBlock(BLACK_SEA_GLASS_BRICKS);
        this.slab(BLACK_SEA_GLASS_BRICK_SLAB, this.blockTexture(BLACK_SEA_GLASS_BRICKS.get()));
        this.stairs(BLACK_SEA_GLASS_BRICK_STAIRS, this.blockTexture(BLACK_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(BLACK_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) BLACK_SEA_GLASS_PANE.get(), this.blockTexture(BLACK_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/black_sea_glass_pane_top"), "translucent");

        // pearly sea glass
        this.cubeAllBlock(WHITE_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(WHITE_SEA_GLASS, "translucent");

        this.cubeAllBlock(WHITE_SEA_GLASS_BRICKS);
        this.slab(WHITE_SEA_GLASS_BRICK_SLAB, this.blockTexture(WHITE_SEA_GLASS_BRICKS.get()));
        this.stairs(WHITE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(WHITE_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(WHITE_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) WHITE_SEA_GLASS_PANE.get(), this.blockTexture(WHITE_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/white_sea_glass_pane_top"), "translucent");

        this.cubeAllBlock(LIGHT_GRAY_PEBBLED_SEA_GLASS);
        this.cubeAllBlockWithRenderType(LIGHT_GRAY_SEA_GLASS, "translucent");

        this.cubeAllBlock(LIGHT_GRAY_SEA_GLASS_BRICKS);
        this.slab(LIGHT_GRAY_SEA_GLASS_BRICK_SLAB, this.blockTexture(LIGHT_GRAY_SEA_GLASS_BRICKS.get()));
        this.stairs(LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS, this.blockTexture(LIGHT_GRAY_SEA_GLASS_BRICKS.get()));

        this.directionalBlock(LIGHT_GRAY_SEA_GLASS_LAMP);
        this.paneBlockWithRenderType((IronBarsBlock) LIGHT_GRAY_SEA_GLASS_PANE.get(), this.blockTexture(LIGHT_GRAY_SEA_GLASS.get()), new ResourceLocation(Seafarer.MOD_ID, "block/light_gray_sea_glass_pane_top"), "translucent");


        // shell blocks
        this.cubeAllBlock(CLAM_SHELL_BRICKS);
        this.stairs(CLAM_SHELL_BRICK_STAIRS, this.blockTexture(CLAM_SHELL_BRICKS.get()));
        this.slab(CLAM_SHELL_BRICK_SLAB, this.blockTexture(CLAM_SHELL_BRICKS.get()));
        this.pillar(CLAM_SHELL_PILLAR);

        this.cubeAllBlock(HORN_SHELL_BRICKS);
        this.stairs(HORN_SHELL_BRICK_STAIRS, this.blockTexture(HORN_SHELL_BRICKS.get()));
        this.slab(HORN_SHELL_BRICK_SLAB, this.blockTexture(HORN_SHELL_BRICKS.get()));
        this.pillar(HORN_SHELL_PILLAR);

        this.cubeAllBlock(SPIKY_SHELL_BRICKS);
        this.stairs(SPIKY_SHELL_BRICK_STAIRS, this.blockTexture(SPIKY_SHELL_BRICKS.get()));
        this.slab(SPIKY_SHELL_BRICK_SLAB, this.blockTexture(SPIKY_SHELL_BRICKS.get()));
        this.pillar(SPIKY_SHELL_PILLAR);

        this.cubeAllBlock(SPIRAL_SHELL_BRICKS);
        this.stairs(SPIRAL_SHELL_BRICK_STAIRS, this.blockTexture(SPIRAL_SHELL_BRICKS.get()));
        this.slab(SPIRAL_SHELL_BRICK_SLAB, this.blockTexture(SPIRAL_SHELL_BRICKS.get()));
        this.pillar(SPIRAL_SHELL_PILLAR);

        this.cubeAllBlock(SWIRL_SHELL_BRICKS);
        this.stairs(SWIRL_SHELL_BRICK_STAIRS, this.blockTexture(SWIRL_SHELL_BRICKS.get()));
        this.slab(SWIRL_SHELL_BRICK_SLAB, this.blockTexture(SWIRL_SHELL_BRICKS.get()));
        this.pillar(SWIRL_SHELL_PILLAR);

        this.cubeAllBlock(PYRAMID_SHELL_BRICKS);
        this.stairs(PYRAMID_SHELL_BRICK_STAIRS, this.blockTexture(PYRAMID_SHELL_BRICKS.get()));
        this.slab(PYRAMID_SHELL_BRICK_SLAB, this.blockTexture(PYRAMID_SHELL_BRICKS.get()));
        this.pillar(PYRAMID_SHELL_PILLAR);

        this.cubeAllBlock(SALT_BLOCK);

        this.pottedPlant(SEA_THRIFT, POTTED_SEA_THRIFT);
        this.pottedPlant(COASTAL_LAVENDER, POTTED_COASTAL_LAVENDER);
        this.pottedPlant(COASTAL_WILDFLOWER, POTTED_COASTAL_WILDFLOWER);
        this.pottedPlant(SEA_HOLLY, POTTED_SEA_HOLLY);

        // corals
        this.cubeAllBlock(AMBER_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_AMBER_CORAL_BLOCK);
        this.simpleCross(DEAD_AMBER_CORAL);
        this.simpleCross(AMBER_CORAL);
        this.coralFan(DEAD_AMBER_CORAL_FAN, DEAD_AMBER_CORAL_WALL_FAN);
        this.coralFan(AMBER_CORAL_FAN, AMBER_CORAL_WALL_FAN);

        this.cubeAllBlock(CERULEAN_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_CERULEAN_CORAL_BLOCK);
        this.simpleCross(DEAD_CERULEAN_CORAL);
        this.simpleCross(CERULEAN_CORAL);
        this.coralFan(DEAD_CERULEAN_CORAL_FAN, DEAD_CERULEAN_CORAL_WALL_FAN);
        this.coralFan(CERULEAN_CORAL_FAN, CERULEAN_CORAL_WALL_FAN);

        this.cubeAllBlock(MAROON_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_MAROON_CORAL_BLOCK);
        this.simpleCross(DEAD_MAROON_CORAL);
        this.simpleCross(MAROON_CORAL);
        this.coralFan(DEAD_MAROON_CORAL_FAN, DEAD_MAROON_CORAL_WALL_FAN);
        this.coralFan(MAROON_CORAL_FAN, MAROON_CORAL_WALL_FAN);

        this.cubeAllBlock(OLIVE_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_OLIVE_CORAL_BLOCK);
        this.simpleCross(DEAD_OLIVE_CORAL);
        this.simpleCross(OLIVE_CORAL);
        this.coralFan(DEAD_OLIVE_CORAL_FAN, DEAD_OLIVE_CORAL_WALL_FAN);
        this.coralFan(OLIVE_CORAL_FAN, OLIVE_CORAL_WALL_FAN);

        this.cubeAllBlock(TURQUOISE_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_TURQUOISE_CORAL_BLOCK);
        this.simpleCross(DEAD_TURQUOISE_CORAL);
        this.simpleCross(TURQUOISE_CORAL);
        this.coralFan(DEAD_TURQUOISE_CORAL_FAN, DEAD_TURQUOISE_CORAL_WALL_FAN);
        this.coralFan(TURQUOISE_CORAL_FAN, TURQUOISE_CORAL_WALL_FAN);

        this.cubeAllBlock(VERDANT_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_VERDANT_CORAL_BLOCK);
        this.simpleCross(DEAD_VERDANT_CORAL);
        this.simpleCross(VERDANT_CORAL);
        this.coralFan(DEAD_VERDANT_CORAL_FAN, DEAD_VERDANT_CORAL_WALL_FAN);
        this.coralFan(VERDANT_CORAL_FAN, VERDANT_CORAL_WALL_FAN);

        this.cubeAllBlock(CORALINE_SAND);

        this.cubeAllBlock(SMOOTH_CORALINE_SANDSTONE);
        this.stairs(SMOOTH_CORALINE_SANDSTONE_STAIRS, this.blockTexture(SMOOTH_CORALINE_SANDSTONE.get()));
        this.slab(SMOOTH_CORALINE_SANDSTONE_SLAB, this.blockTexture(SMOOTH_CORALINE_SANDSTONE.get()));

        this.simpleBlockItem(SeaBlocks.CUT_CORALINE_SANDSTONE.get(), existingModel((getName(SeaBlocks.CUT_CORALINE_SANDSTONE.get()))));
        this.simpleBlockItem(SeaBlocks.CHISELED_CORALINE_SANDSTONE.get(), existingModel((getName(SeaBlocks.CHISELED_CORALINE_SANDSTONE.get()))));
        this.simpleBlockItem(SeaBlocks.SMOOTH_CORALINE_SANDSTONE.get(), existingModel((getName(SeaBlocks.SMOOTH_CORALINE_SANDSTONE.get()))));
        this.simpleBlockItem(SeaBlocks.CORALINE_SANDSTONE.get(), existingModel((getName(SeaBlocks.CORALINE_SANDSTONE.get()))));
        this.simpleBlockItem(SeaBlocks.CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SeaBlocks.CORALINE_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeaBlocks.CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SeaBlocks.CORALINE_SANDSTONE_STAIRS.get()))));
        this.simpleBlockItem(SeaBlocks.CUT_CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SeaBlocks.CUT_CORALINE_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeaBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SeaBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get()))));

        this.cubeAllBlock(ASHEN_SAND);

        this.simpleBlockItem(SeaBlocks.ASHEN_SANDSTONE.get(), existingModel((getName(SeaBlocks.ASHEN_SANDSTONE.get()))));
        this.simpleBlockItem(SeaBlocks.ASHEN_SANDSTONE_SLAB.get(), existingModel((getName(SeaBlocks.ASHEN_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeaBlocks.ASHEN_SANDSTONE_STAIRS.get(), existingModel((getName(SeaBlocks.ASHEN_SANDSTONE_STAIRS.get()))));
    }

    private void createPottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pottedPlant, String renderType){
        ConfiguredModel cFfile = new ConfiguredModel(pottedPlant(name(pottedPlant.get()), blockTexture(plant.get()), renderType));
        getVariantBuilder(pottedPlant.get()).partialState().setModels(cFfile);
    }

    public ModelFile pottedPlant(String name, ResourceLocation plant, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/flower_pot_cross", "plant", plant, renderType);
    }

    private ModelFile singleTexture(String name, String parent, String textureKey, ResourceLocation texture, String renderType) {
        return singleTexture(name, mcLoc(parent), textureKey, texture, renderType);
    }

    public ModelFile singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture, String renderType) {
        return models().withExistingParent(name, parent)
                .texture(textureKey, texture).renderType(renderType);
    }

    private BlockModelBuilder generated(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("item/" + name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private String getName(Block block) {
        return key(block).toString().replace(Seafarer.MOD_ID + ":", "");
    }

    public void block(Block block) {
        this.simpleBlock(block);
        this.blockItem(block);
    }

    public void block(RegistryObject<Block> block) {
        this.block(block.get());
    }

    public void blockItem(Block block) {
        this.simpleBlockItem(block, new ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
    }

    public void blockItem(RegistryObject<Block> block) {
        this.blockItem(block.get());
    }

    public void directionalBlock(RegistryObject<Block> block, ResourceLocation sideTexture, ResourceLocation bottomTexture, ResourceLocation topTexture) {
        this.directionalBlock(block.get(), models().cubeBottomTop(name(block.get()), sideTexture, bottomTexture, topTexture));
        this.blockItem(block);
    }

    public void directionalBlock(RegistryObject<Block> block) {
        ResourceLocation blockTexture = blockTexture(block.get());
        this.directionalBlock(block, suffix(blockTexture, "_side"), suffix(blockTexture, "_top"), suffix(blockTexture, "_bottom"));
    }

    public static ResourceLocation suffix(ResourceLocation resourceLocation, String suffix) {
        return new ResourceLocation(resourceLocation.getNamespace(), resourceLocation.getPath() + suffix);
    }

    @Override
    public String getName() {
        return "Block States: " + Seafarer.MOD_ID;
    }

    // updated

    // item
    private void itemModel(RegistryObject<Block> block) {
        this.itemModels().withExistingParent(getItemName(block.get()), this.blockTexture(block.get()));
    }

    private void generatedItem(ItemLike item, TextureFolder folder) {
        String name = getItemName(item);
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc(folder.format(name)));
    }

    // block
    private void cubeAllBlock(RegistryObject<Block> block) {
        this.simpleBlock(block.get());
        this.itemModel(block);
    }

    private void cubeAllBlockWithRenderType(RegistryObject<Block> block, String renderType) {
        this.simpleBlock(block.get(), models().getBuilder(name(block.get())).parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/cube_all"))).renderType(renderType).texture("all", blockTexture(block.get())));
        this.itemModel(block);
    }

    private void stairs(RegistryObject<Block> stairs, ResourceLocation texture) {
        this.stairsBlock((StairBlock) stairs.get(), texture);
        this.itemModel(stairs);
    }

    private void slab(RegistryObject<Block> slab, ResourceLocation texture) {
        this.slabBlock((SlabBlock) slab.get(), texture, texture);
        this.itemModel(slab);
    }

    private void wall(RegistryObject<Block> wall, ResourceLocation texture) {
        this.wallBlock((WallBlock) wall.get(), texture);
        this.itemModels().wallInventory(getItemName(wall.get()), texture);
    }

    private void pillar(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + getItemName(pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    public void pillarWithBottom(RegistryObject<Block> pillar) {
        ResourceLocation blockTexture = this.blockTexture(pillar.get());
        this.directionalBlock(pillar, suffix(blockTexture, "_side"), suffix(blockTexture, "_bottom"), suffix(blockTexture, "_top"));
        this.itemModel(pillar);
    }

    private void pillarNoTop(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + getItemName(pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    private void pane(RegistryObject<Block> pane, ResourceLocation texture) {
        this.paneBlockWithRenderType((IronBarsBlock) pane.get(), texture, this.modLoc("block/" + getItemName(pane.get()) + "_top"), "transparent");
        this.itemModel(pane);
    }

    private void wood(RegistryObject<Block> log, ResourceLocation texture) {
        this.axisBlock((RotatedPillarBlock) log.get(), texture, texture);
        this.itemModel(log);
    }

    private void fence(RegistryObject<Block> fence, ResourceLocation texture) {
        this.fenceBlock((FenceBlock) fence.get(), texture);
        this.itemModels().fenceInventory(getItemName(fence.get()), texture);
    }

    private void fenceGate(RegistryObject<Block> gate, ResourceLocation texture) {
        this.fenceGateBlock((FenceGateBlock) gate.get(), texture);
        this.itemModel(gate);
    }

    private void trapdoor(RegistryObject<Block> trapdoor) {
        this.trapdoorBlock((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true);
        this.itemModels().withExistingParent(getItemName(trapdoor.get()), this.modLoc("block/" + getItemName(trapdoor.get()) + "_bottom"));
    }

    private void trapdoorCutout(RegistryObject<Block> trapdoor) {
        this.trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true, "cutout");
        this.itemModels().withExistingParent(getItemName(trapdoor.get()), this.modLoc("block/" + getItemName(trapdoor.get()) + "_bottom"));
    }

    private void door(RegistryObject<Block> door) {
        String name = getItemName(door.get());
        this.doorBlock((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"));
        this.generatedItem(door.get(), TextureFolder.ITEM);
    }

    private void doorCutout(RegistryObject<Block> door) {
        String name = getItemName(door.get());
        this.doorBlockWithRenderType((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"), "cutout");
        this.generatedItem(door.get(), TextureFolder.ITEM);
    }

    private void button(RegistryObject<Block> button, ResourceLocation texture) {
        this.buttonBlock((ButtonBlock) button.get(), texture);
        this.itemModels().buttonInventory(getItemName(button.get()), texture);
    }

    private void pressurePlate(RegistryObject<Block> pressurePlate, ResourceLocation texture) {
        this.pressurePlateBlock((PressurePlateBlock) pressurePlate.get(), texture);
        this.itemModel(pressurePlate);
    }

    private void leaves(RegistryObject<Block> leaves) {
        this.simpleBlock(leaves.get(), this.models().withExistingParent(getItemName(leaves.get()), "block/leaves").texture("all", this.blockTexture(leaves.get())));
        this.itemModel(leaves);
    }

    private void simpleCross(RegistryObject<Block> block) {
        this.simpleBlock(block.get(), this.models().cross(getItemName(block.get()), this.blockTexture(block.get())).renderType("cutout"));
        this.generatedItem(block.get(), TextureFolder.BLOCK);
    }

    private void tallPlant(RegistryObject<Block> flower) {
        String name = getItemName(flower.get());
        Function<String, ModelFile> model = s -> this.models().cross(name + "_" + s, this.modLoc("block/" + name + "_" + s)).renderType("cutout");

        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + name + "_top"));
        this.getVariantBuilder(flower.get()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(model.apply("top"))).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(model.apply("bottom")));
    }

    private void pot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(pot.get()), "block/flower_pot_cross").texture("plant", texture).renderType("cutout");
        this.simpleBlock(pot.get(), model);
    }

    private void pottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.pot(pot, this.blockTexture(plant.get()));
        this.simpleCross(plant);
        this.generatedItem(plant.get(), TextureFolder.BLOCK);
    }

    private void coralFan(RegistryObject<Block> coralFan, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(coralFan.get()), "block/coral_fan").texture("fan", texture).renderType("cutout");
        this.simpleBlock(coralFan.get(), model);
    }

    private void coralWallFan(RegistryObject<Block> coralFan, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(coralFan.get()), "block/coral_wall_fan").texture("fan", texture).renderType("cutout");
        this.horizontalBlock(coralFan.get(), model);
    }

    private void coralFan(RegistryObject<Block> coralFan, RegistryObject<Block> coralWallFan) {
        this.coralFan(coralFan, this.blockTexture(coralFan.get()));
        this.coralWallFan(coralWallFan, this.blockTexture(coralFan.get()));
        this.generatedItem(coralFan.get(), TextureFolder.BLOCK);
    }

    // utils
    private static String getItemName(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
    }

    private static String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private enum TextureFolder {
        ITEM, BLOCK;
        public String format(String itemName) {
            return this.name().toLowerCase() + '/' + itemName;
        }
    }
}
