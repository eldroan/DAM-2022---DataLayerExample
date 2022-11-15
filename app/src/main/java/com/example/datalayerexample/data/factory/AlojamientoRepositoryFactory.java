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
        // Este currentUserId en una app con login nos traería información del usuario actual
        final UUID currentUserId = UserRepository.currentUserId();
        return new AlojamientoRepository(
            new AlojamientoRoomDataSource(context),
            // Aca uso una implementación con shared preferences para no hacer una de room o retrofit
            new FavoritoSharedPreferencesDataSource(context, currentUserId),
            // Aca uso una implementación en memoria no hacer una de room o retrofit
            new ReservaInMemoryDatasource(currentUserId)
        );
    }
}
