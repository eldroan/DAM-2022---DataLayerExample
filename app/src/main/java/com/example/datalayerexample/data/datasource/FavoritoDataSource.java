package com.example.datalayerexample.data.datasource;

import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Favorito;
import java.util.List;

public interface FavoritoDataSource {
    void agregar(
        final Alojamiento alojamiento,
        final OnResult<Void> callback
    );

    void quitar(
        final Alojamiento alojamiento,
        final OnResult<Void> callback
    );

    void recuperar(
        final OnResult<List<Favorito>> callback
    );

    void existe(
        final Alojamiento alojamiento,
        final OnResult<Boolean> callback
    );
}
