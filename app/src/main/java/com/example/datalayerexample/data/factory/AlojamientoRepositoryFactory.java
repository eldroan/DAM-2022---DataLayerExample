package com.example.datalayerexample.data.factory;

import android.content.Context;
import com.example.datalayerexample.data.datasource.room.AlojamientoRoomDataSource;
import com.example.datalayerexample.data.repository.AlojamientoRepository;

public final class AlojamientoRepositoryFactory {
    private AlojamientoRepositoryFactory() {
    }

    public static AlojamientoRepository create(final Context context) {
        return new AlojamientoRepository(new AlojamientoRoomDataSource(context));
    }
}
