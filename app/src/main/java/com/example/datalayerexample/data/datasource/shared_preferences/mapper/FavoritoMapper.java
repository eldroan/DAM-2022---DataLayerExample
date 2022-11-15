package com.example.datalayerexample.data.datasource.shared_preferences.mapper;

import com.example.datalayerexample.data.model.Favorito;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class FavoritoMapper {
    private FavoritoMapper() {
    }

    public static String toSharedPreference(final List<Favorito> favoritos) {
        final Gson gson = new Gson();
        return gson.toJson(favoritos);
    }

    public static ArrayList<Favorito> fromSharedPreference(final String favoritos) {
        final Gson gson = new Gson();
        final Type favoritoType = new TypeToken<ArrayList<Favorito>>() {
        }.getType();
        return gson.fromJson(favoritos, favoritoType);
    }
}
