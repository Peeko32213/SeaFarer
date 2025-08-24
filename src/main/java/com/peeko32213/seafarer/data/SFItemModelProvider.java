package com.peeko32213.seafarer.data;


import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SFItems;
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

public class SFItemModelProvider extends ItemModelProvider {
    public SFItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){

        for (Item i : BuiltInRegistries.ITEM) {
            if (i instanceof SpawnEggItem && ForgeRegistries.ITEMS.getKey(i).getNamespace().equals(Seafarer.MOD_ID)) {
                getBuilder(ForgeRegistries.ITEMS.getKey(i).getPath())
                        .parent(getExistingFile(new ResourceLocation("item/template_spawn_egg")));
            }
        }

        item(SFItems.RAW_SHORE_CRAB_LEG);
        item(SFItems.COOKED_SHORE_CRAB_LEG);
        item(SFItems.RAW_HORSESHOE_CRAB);
        item(SFItems.COOKED_HORSESHOE_CRAB);
        item(SFItems.RAW_MARINE_IGUANA_TAIL);
        item(SFItems.COOKED_MARINE_IGUANA_TAIL);
        item(SFItems.COOKED_STARFISH);
        item(SFItems.SALTED_COD);
        item(SFItems.SALTED_SALMON);
        item(SFItems.SALTED_TROPICAL_FISH);
        item(SFItems.SALTED_STARFISH);
        item(SFItems.SEA_GRAPES);
        item(SFItems.WAKAME);
        item(SFItems.SEA_URCHIN);
        item(SFItems.SOY_SAUCE);

        item(SFItems.SHORE_CRAB_BUCKET);
        item(SFItems.HORSESHOE_CRAB_BUCKET);
//        item(SeafarerItems.SQUIRRELFISH_BUCKET);

        item(SFItems.MESSAGE_IN_A_BOTTLE);
        item(SFItems.OLD_BOOT);
        item(SFItems.METAL_CAN);

        item(SFItems.SEA_SALT);
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
        return new ResourceLocation(Seafarer.MOD_ID, name);
    }
    public static ResourceLocation key(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
