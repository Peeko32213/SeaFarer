package com.peeko32213.seafarer.core.registry.world.config;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;

public class SFFeatureForms {


    public static final FeatureForm PATCH_FEATURE_FORM = new PatchFeatureForm();

    public static final BiMap<ResourceLocation, FeatureForm> NAMED_FORMS = HashBiMap.create();
    static {
        NAMED_FORMS.put( ResourceLocation.tryParse("patch_form"), PATCH_FEATURE_FORM);
    }


    public static final Codec<FeatureForm> CODEC = ExtraCodecs.stringResolverCodec(sa -> NAMED_FORMS.inverse().get(sa).toString(), key -> NAMED_FORMS.get(new ResourceLocation(key)));

    public static FeatureForm getFeatureForm(ResourceLocation location) {
        return NAMED_FORMS.getOrDefault(location, PATCH_FEATURE_FORM);
    }

    public static ResourceLocation getFeatureForm(FeatureForm location) {
        return NAMED_FORMS.inverse().get(location);
    }

    public static void putRenderType(ResourceLocation location, FeatureForm featureForm) {
        NAMED_FORMS.put(location, featureForm);
    }
}
