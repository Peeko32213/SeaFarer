package com.peeko32213.seafarer.data;


import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaItems;
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

public class SeaItemModelProvider extends ItemModelProvider {
    public SeaItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){

        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof SpawnEggItem && ForgeRegistries.ITEMS.getKey(item).getNamespace().equals(Seafarer.MOD_ID)) {
                this.getBuilder(ForgeRegistries.ITEMS.getKey(item).getPath()).parent(getExistingFile(new ResourceLocation("item/template_spawn_egg")));
            }
        }

        this.item(SeaItems.SEA_GLASS_PEBBLES);

        this.item(SeaItems.RAW_CRAB_LEG);
        this.item(SeaItems.COOKED_CRAB_LEG);
        this.item(SeaItems.RAW_HORSESHOE_CRAB);
        this.item(SeaItems.COOKED_HORSESHOE_CRAB);
        this.item(SeaItems.DRIED_STARFISH);
        this.item(SeaItems.SEA_URCHIN);
        this.item(SeaItems.SOY_SAUCE);

        this.item(SeaItems.SHORE_CRAB_BUCKET);
        this.item(SeaItems.HORSESHOE_CRAB_BUCKET);

        this.item(SeaItems.SEA_SALT);
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
