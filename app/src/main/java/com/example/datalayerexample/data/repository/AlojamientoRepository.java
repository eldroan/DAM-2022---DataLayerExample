package com.example.datalayerexample.data.repository;

import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.datasource.AlojamientoDataSource;
import com.example.datalayerexample.data.datasource.FavoritoDataSource;
import com.example.datalayerexample.data.datasource.ReservaDataSource;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Departamento;
import com.example.datalayerexample.data.model.Favorito;
import com.example.datalayerexample.data.model.Habitacion;
import com.example.datalayerexample.data.model.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Aca decimos que el repository implementa el ds para de forma
// facil nos exponga todos los metodos pero no es necesario y podría
// no ser lo que buscamos ( ej: exponer menos metodos o componer metodos del o los datasource)
public class AlojamientoRepository {
    final AlojamientoDataSource alojamientoDataSource;
    final FavoritoDataSource favoritoDataSource;
    final ReservaDataSource reservaDataSource;

    public AlojamientoRepository(final AlojamientoDataSource alojamientoDataSource,
        final FavoritoDataSource favoritoDataSource, final ReservaDataSource reservaDataSource) {
        this.alojamientoDataSource = alojamientoDataSource;
        this.favoritoDataSource = favoritoDataSource;
        this.reservaDataSource = reservaDataSource;
    }

    public void guardarHabitacion(final Habitacion habitacion, final OnResult<Habitacion> callback) {
        alojamientoDataSource.guardarHabitacion(habitacion, callback);
    }

    public void guardarDepartamento(final Departamento departamento, final OnResult<Departamento> callback) {
        alojamientoDataSource.guardarDepartamento(departamento, callback);
    }

    public void recuperarHabitaciones(final OnResult<List<Habitacion>> callback) {
        alojamientoDataSource.recuperarHabitaciones(callback);
    }

    public void recuperarDepartamentos(final OnResult<List<Departamento>> callback) {
        alojamientoDataSource.recuperarDepartamentos(callback);
    }

    public void recuperarAlojamientos(final OnResult<List<Alojamiento>> callback) {
        alojamientoDataSource.recuperarAlojaientos(callback);
    }

    public void recuperarFavoritos(final OnResult<List<Alojamiento>> callback) {
        favoritoDataSource.recuperar(new OnResult<List<Favorito>>() {
            @Override
            public void onSuccess(final List<Favorito> favoritos) {
                alojamientoDataSource.recuperarAlojaientos(new OnResult<List<Alojamiento>>() {
                    @Override
                    public void onSuccess(final List<Alojamiento> alojamientos) {
                        final List<Alojamiento> alojamientosFavoritos = new ArrayList<>();
                        // Supongamos que esta implementación no es un asco
                        for (final Alojamiento alojamiento : alojamientos) {
                            for (final Favorito favorito : favoritos) {
                                if (favorito.getAlojamientoId().equals(alojamiento.getId())) {
                                    alojamientosFavoritos.add(alojamiento);
                                    break; // Ah pero al menos no te recorro toda la lista al pepe, ojota.
                                }
                            }
                        }
                        callback.onSuccess(alojamientosFavoritos);
                    }

                    @Override
                    public void onError(final Throwable exception) {
                        callback.onError(exception);
                    }
                });
            }

            @Override
            public void onError(final Throwable exception) {
                callback.onError(exception);
            }
        });
    }

    void agregarFavorito(final Alojamiento alojamiento, final OnResult<Void> callback) {
        favoritoDataSource.agregar(alojamiento, callback);
    }

    void quitarFavorito(final Alojamiento alojamiento, final OnResult<Void> callback) {
        favoritoDataSource.quitar(alojamiento, callback);
    }

    void esFavorito(final Alojamiento alojamiento, final OnResult<Boolean> callback) {
        favoritoDataSource.existe(alojamiento, callback);
    }

    public void recuperarReservas(final OnResult<List<Alojamiento>> callback) {
        reservaDataSource.recuperar(new OnResult<List<Reserva>>() {
            @Override
            public void onSuccess(final List<Reserva> reservas) {
                alojamientoDataSource.recuperarAlojaientos(new OnResult<List<Alojamiento>>() {
                    @Override
                    public void onSuccess(final List<Alojamiento> alojamientos) {
                        final List<Alojamiento> alojamientosFavoritos = new ArrayList<>();
                        // Supongamos que esta implementación no es un asco
                        for (final Alojamiento alojamiento : alojamientos) {
                            for (final Reserva reserva : reservas) {
                                if (reserva.getAlojamientoId().equals(alojamiento.getId())) {
                                    alojamientosFavoritos.add(alojamiento);
                                    break; // Ah pero al menos no te recorro toda la lista al pepe, ojota.
                                }
                            }
                        }
                        callback.onSuccess(alojamientosFavoritos);
                    }

                    @Override
                    public void onError(final Throwable exception) {
                        callback.onError(exception);
                    }
                });
            }

            @Override
            public void onError(final Throwable exception) {
                callback.onError(exception);
            }
        });
    }

    void agregarReserva(final Alojamiento alojamiento, final Date fechaIngreso, final Date fechaSalida,
        final OnResult<Void> callback) {
        reservaDataSource.reservar(alojamiento, fechaIngreso, fechaSalida, callback);
    }

    void quitarReserva(final Alojamiento alojamiento, final OnResult<Void> callback) {
        reservaDataSource.anular(alojamiento, callback);
    }

    void estaReservado(final Alojamiento alojamiento, final OnResult<Boolean> callback) {
        reservaDataSource.existe(alojamiento, callback);
    }
}
