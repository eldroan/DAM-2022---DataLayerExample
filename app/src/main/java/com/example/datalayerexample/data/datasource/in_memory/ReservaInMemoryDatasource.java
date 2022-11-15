package com.example.datalayerexample.data.datasource.in_memory;

import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.datasource.ReservaDataSource;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("UseOfObsoleteDateTimeApi")
public class ReservaInMemoryDatasource implements ReservaDataSource {
    private final UUID currentUserId;
    private static final Map<UUID, Reserva> RESERVAS = new HashMap<>();

    public ReservaInMemoryDatasource(final UUID currentUserId) {
        this.currentUserId = currentUserId;
    }

    @Override
    public void reservar(final Alojamiento alojamiento, final Date fechaIngreso, final Date fechaSalida,
        final OnResult<Void> callback) {
        if (RESERVAS.containsKey(alojamiento.getId())) {
            callback.onError(new Exception("Alguien ya reservo este alojamiento :c"));
        } else {
            RESERVAS.put(alojamiento.getId(),
                new Reserva(alojamiento.getId(), currentUserId, fechaIngreso, fechaSalida));
            callback.onSuccess(null);
        }
    }

    @Override
    public void anular(final Alojamiento alojamiento, final OnResult<Void> callback) {
        if (!RESERVAS.containsKey(alojamiento.getId())) {
            callback.onError(new Exception("Este departamento no esta reservado"));
        } else {
            RESERVAS.remove(alojamiento.getId());
            callback.onSuccess(null);
        }
    }

    @Override
    public void recuperar(final OnResult<List<Reserva>> callback) {
        callback.onSuccess(new ArrayList<>(RESERVAS.values()));
    }

    @Override
    public void existe(final Alojamiento alojamiento, final OnResult<Boolean> callback) {
        callback.onSuccess(RESERVAS.containsKey(alojamiento.getId()));
    }
}
