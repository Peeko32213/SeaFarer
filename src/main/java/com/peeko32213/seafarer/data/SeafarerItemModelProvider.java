package com.peeko32213.seafarer.data;


import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeafarerItems;
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

public class SeafarerItemModelProvider extends ItemModelProvider {
    public SeafarerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
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

        item(SeafarerItems.RAW_SHORE_CRAB_LEG);
        item(SeafarerItems.COOKED_SHORE_CRAB_LEG);
        item(SeafarerItems.RAW_HORSESHOE_CRAB);
        item(SeafarerItems.COOKED_HORSESHOE_CRAB);
        item(SeafarerItems.RAW_MARINE_IGUANA_TAIL);
        item(SeafarerItems.COOKED_MARINE_IGUANA_TAIL);
        item(SeafarerItems.COOKED_STARFISH);
        item(SeafarerItems.SALTED_COD);
        item(SeafarerItems.SALTED_SALMON);
        item(SeafarerItems.SALTED_TROPICAL_FISH);
        item(SeafarerItems.SALTED_STARFISH);
        item(SeafarerItems.SEA_GRAPES);
        item(SeafarerItems.WAKAME);
        item(SeafarerItems.SEA_URCHIN);
        item(SeafarerItems.SOY_SAUCE);

        item(SeafarerItems.SHORE_CRAB_BUCKET);
        item(SeafarerItems.HORSESHOE_CRAB_BUCKET);
//        item(SeafarerItems.SQUIRRELFISH_BUCKET);

        item(SeafarerItems.MESSAGE_IN_A_BOTTLE);
        item(SeafarerItems.OLD_BOOT);
        item(SeafarerItems.METAL_CAN);

        item(SeafarerItems.SEA_SALT);
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
