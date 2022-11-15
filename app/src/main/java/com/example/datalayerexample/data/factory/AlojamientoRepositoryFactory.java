package com.example.datalayerexample.data.factory;

import android.content.Context;
import com.example.datalayerexample.data.datasource.in_memory.ReservaInMemoryDatasource;
import com.example.datalayerexample.data.datasource.room.AlojamientoRoomDataSource;
import com.example.datalayerexample.data.datasource.shared_preferences.FavoritoSharedPreferencesDataSource;
import com.example.datalayerexample.data.repository.AlojamientoRepository;
import com.example.datalayerexample.data.repository.UserRepository;
import java.util.UUID;

public final class AlojamientoRepositoryFactory {
    private AlojamientoRepositoryFactory() {
    }

    public static AlojamientoRepository create(final Context context) {
        final UUID currentUserId = UserRepository.currentUserId();
        return new AlojamientoRepository(
            new AlojamientoRoomDataSource(context),
            new FavoritoSharedPreferencesDataSource(context, currentUserId),
            new ReservaInMemoryDatasource(currentUserId)
        );
    }
}
