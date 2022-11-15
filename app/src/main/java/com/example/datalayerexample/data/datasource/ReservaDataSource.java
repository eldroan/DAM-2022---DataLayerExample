package com.example.datalayerexample.data.datasource;

import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Reserva;
import java.util.Date;
import java.util.List;

@SuppressWarnings("UseOfObsoleteDateTimeApi")
public interface ReservaDataSource {
    void reservar(
        final Alojamiento alojamiento,
        final Date fechaIngreso,
        final Date fechaSalida,
        final OnResult<Void> callback
    );

    void anular(
        final Alojamiento alojamiento,
        final OnResult<Void> callback
    );

    void recuperar(
        final OnResult<List<Reserva>> callback
    );

    void existe(
        final Alojamiento alojamiento,
        final OnResult<Boolean> callback
    );
}
