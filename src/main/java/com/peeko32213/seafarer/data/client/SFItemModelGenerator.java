package com.peeko32213.seafarer.data.client;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFItemModelGenerator extends ItemModelProvider {
    public SFItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels(){

        for (Item i : BuiltInRegistries.ITEM) {
            if (i instanceof SpawnEggItem && ForgeRegistries.ITEMS.getKey(i).getNamespace().equals(SeaFarer.MODID)) {
                getBuilder(ForgeRegistries.ITEMS.getKey(i).getPath())
                        .parent(getExistingFile(new ResourceLocation("item/template_spawn_egg")));
            }
        }

        // Food
        item(SFItems.RAW_SHORE_CRAB);
        item(SFItems.COOKED_SHORE_CRAB);
        item(SFItems.RAW_HORSESHOE_CRAB);
        item(SFItems.COOKED_HORSESHOE_CRAB);
        item(SFItems.RAW_MARINE_IGUANA);
        item(SFItems.COOKED_MARINE_IGUANA);
        item(SFItems.RAW_FROGFISH);
        item(SFItems.COOKED_FROGFISH);
        item(SFItems.RAW_BLUE_TANG);
        item(SFItems.COOKED_BLUE_TANG);
        item(SFItems.RAW_MANDARINFISH);
        item(SFItems.COOKED_MANDARINFISH);
        item(SFItems.RAW_SQUIRRELFISH);
        item(SFItems.COOKED_SQUIRRELFISH);
        item(SFItems.RAW_COPPERBAND_BUTTERFLYFISH);
        item(SFItems.COOKED_COPPERBAND_BUTTERFLYFISH);
        item(SFItems.RAW_GARDEN_EEL);
        item(SFItems.COOKED_GARDEN_EEL);
        item(SFItems.RAW_SEXY_SHRIMP);
        item(SFItems.COOKED_SEXY_SHRIMP);
        item(SFItems.COOKED_STARFISH);
        item(SFItems.SALTED_COD);
        item(SFItems.SALTED_SALMON);
        item(SFItems.SALTED_TROPICAL_FISH);
        item(SFItems.SALTED_STARFISH);
        item(SFItems.SEA_GRAPES);
        item(SFItems.WAKAME);
        item(SFItems.SEA_URCHIN);
        item(SFItems.SOY_SAUCE);

        // Junk
        item(SFItems.MESSAGE_IN_A_BOTTLE);
        item(SFItems.OLD_BOOT);
        item(SFItems.CAN);

        // Misc
        item(SFItems.SALT);

    }

    private void toBlock(RegistryObject<Block> b) {
        toBlockModel(b, b.getId().getPath());
    }

    private void toBlockModel(RegistryObject<Block> b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void toBlockModel(RegistryObject<Block> b, ResourceLocation model) {
        withExistingParent(b.getId().getPath(), model);
    }

    private ItemModelBuilder item(RegistryObject<Item> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    public static ResourceLocation prefix(String name){
        return new ResourceLocation(SeaFarer.MODID, name);
    }
    public static ResourceLocation key(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
