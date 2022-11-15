package com.example.datalayerexample.data.datasource.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.datasource.FavoritoDataSource;
import com.example.datalayerexample.data.datasource.shared_preferences.mapper.FavoritoMapper;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Favorito;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class FavoritoSharedPreferencesDataSource implements FavoritoDataSource {
    private static final String SHARED_PREFERENCES_NAME = "SHARED_PREFERENCES_NAME";
    private static final String FAVORITOS = "favoritos";
    private final SharedPreferences sharedPreferences;
    private final UUID currentUserId;

    public FavoritoSharedPreferencesDataSource(final Context context, final UUID currentUserId) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        this.currentUserId = currentUserId;
    }

    @Override
    public void agregar(final Alojamiento alojamiento, final OnResult<Void> callback) {
        final String favoritoString = sharedPreferences.getString(FAVORITOS, null);
        final ArrayList<Favorito> favoritos =
            favoritoString == null ? new ArrayList<>() : FavoritoMapper.fromSharedPreference(favoritoString);
        final boolean existe = existeFavorito(alojamiento, favoritos) != null;
        if (!existe) {
            favoritos.add(new Favorito(alojamiento.getId(), currentUserId));
            sharedPreferences.edit().putString(FAVORITOS, FavoritoMapper.toSharedPreference(favoritos)).apply();
        }
        callback.onSuccess(null);
    }

    @Override
    public void quitar(final Alojamiento alojamiento, final OnResult<Void> callback) {
        final String favoritoString = sharedPreferences.getString(FAVORITOS, null);
        final ArrayList<Favorito> favoritos =
            favoritoString == null ? new ArrayList<>() : FavoritoMapper.fromSharedPreference(favoritoString);
        final Favorito favorito = existeFavorito(alojamiento, favoritos);
        if (favorito != null) {
            favoritos.remove(favorito);
            sharedPreferences.edit().putString(FAVORITOS, FavoritoMapper.toSharedPreference(favoritos)).apply();
        }
        callback.onSuccess(null);
    }

    @Override
    public void recuperar(final OnResult<List<Favorito>> callback) {
        final String favoritoString = sharedPreferences.getString(FAVORITOS, null);
        final ArrayList<Favorito> favoritos =
            favoritoString == null ? new ArrayList<>() : FavoritoMapper.fromSharedPreference(favoritoString);
        callback.onSuccess(favoritos);
    }

    @Override
    public void existe(final Alojamiento alojamiento, final OnResult<Boolean> callback) {
        final String favoritoString = sharedPreferences.getString(FAVORITOS, null);
        final ArrayList<Favorito> favoritos =
            favoritoString == null ? new ArrayList<>() : FavoritoMapper.fromSharedPreference(favoritoString);
        final Favorito favorito = existeFavorito(alojamiento, favoritos);
        callback.onSuccess(favorito != null);
    }

    private Favorito existeFavorito(final Alojamiento alojamiento, final List<Favorito> favoritos) {
        Favorito encontrado = null;
        final Iterator<Favorito> iterator = favoritos.iterator();
        Favorito current;
        while (encontrado == null && iterator.hasNext()) {
            current = iterator.next();
            if (current.getAlojamientoId().equals(alojamiento.getId())) {
                encontrado = current;
            }
        }
        return encontrado;
    }
}
