package com.peeko32213.seafarer.data;

import com.mojang.datafixers.util.Pair;
import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.HashMap;
import java.util.Map;

public class SeafarerTextUtils {
    public static Map<String, String> TRANSLATABLES = new HashMap<>();

    public static MutableComponent addTranslatable(String translatable, String translation) {
        TRANSLATABLES.put(translatable, translation);
        return Component.translatable(translatable);
    }

    public static MutableComponent addUPTranslatable(String translatable, String translation) {
        return addTranslatable(SeaFarer.MODID + "." + translatable, translation);
    }

    public static Pair<Component, Component> addAdvancementTranslatables(String path, String titleTranslation, String descTranslation) {
        var title = addTranslatable(path + ".title", titleTranslation);
        var desc = addTranslatable(path + ".description", descTranslation);
        return Pair.of(title, desc);
    }

    public static String createTranslation(String path) {
        final StringBuilder builder = new StringBuilder();

        for (String part : path.split("_")) {
            if (!builder.isEmpty()) {
                builder.append(" ");
            }
            builder.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return builder.toString();
    }
}
