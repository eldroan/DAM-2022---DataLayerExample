package com.example.datalayerexample.data.datasource.room;

import android.content.Context;
import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.datasource.AlojamientoDataSource;
import com.example.datalayerexample.data.datasource.room.dao.AlojamientoDAO;
import com.example.datalayerexample.data.datasource.room.dao.DepartamentoDAO;
import com.example.datalayerexample.data.datasource.room.dao.HabitacionDAO;
import com.example.datalayerexample.data.datasource.room.database.AppDataBase;
import com.example.datalayerexample.data.datasource.room.entities.AlojamientoEntity;
import com.example.datalayerexample.data.datasource.room.entities.DepartamentoEntity;
import com.example.datalayerexample.data.datasource.room.entities.HabitacionEntity;
import com.example.datalayerexample.data.datasource.room.mapper.AlojamientoMapper;
import com.example.datalayerexample.data.datasource.room.mapper.DepartamentoMapper;
import com.example.datalayerexample.data.datasource.room.mapper.HabitacionMapper;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Departamento;
import com.example.datalayerexample.data.model.Habitacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlojamientoRoomDataSource implements AlojamientoDataSource {
    private final AlojamientoDAO alojamientoDAO;
    private final HabitacionDAO habitacionDAO;
    private final DepartamentoDAO departamentoDAO;

    public AlojamientoRoomDataSource(final Context context) {
        this(AppDataBase.getInstance(context));
    }

    public AlojamientoRoomDataSource(final AppDataBase db) {
        alojamientoDAO = db.alojamientoDAO();
        habitacionDAO = db.habitacionDAO();
        departamentoDAO = db.departamentoDAO();
    }

    @Override
    public void guardarHabitacion(final Habitacion habitacion, final OnResult<Habitacion> callback) {
        try {
            final AlojamientoEntity ae = AlojamientoMapper.toEntity(habitacion);
            alojamientoDAO.insertar(ae);
            final HabitacionEntity he = HabitacionMapper.toEntity(habitacion, ae.getId());
            habitacionDAO.insertar(he);
            habitacion.setId(he.getId());
            callback.onSuccess(habitacion);
        } catch (final Exception e) {
            callback.onError(e);
        }
    }

    @Override
    public void guardarDepartamento(final Departamento departamento, final OnResult<Departamento> callback) {
        try {
            final AlojamientoEntity ae = AlojamientoMapper.toEntity(departamento);
            alojamientoDAO.insertar(ae);
            final DepartamentoEntity de = DepartamentoMapper.toEntity(departamento, ae.getId());
            departamentoDAO.insertar(de);
            departamento.setId(de.getId());
            callback.onSuccess(departamento);
        } catch (final Exception e) {
            callback.onError(e);
        }
    }

    @Override
    public void recuperarHabitaciones(final OnResult<List<Habitacion>> callback) {
        try {
            final HabitacionEntity[] heCollection = habitacionDAO.recuperarHabitaciones();
            final List<Habitacion> habitaciones = new ArrayList<>();
            AlojamientoEntity ae;
            for (final HabitacionEntity he : heCollection) {
                ae = alojamientoDAO.recuperarAlojamientos(he.getAlojamientoId());
                habitaciones.add(HabitacionMapper.fromEntity(he, ae));
            }
            callback.onSuccess(habitaciones);
        } catch (final Exception e) {
            callback.onError(e);
        }
    }

    @Override
    public void recuperarDepartamentos(final OnResult<List<Departamento>> callback) {
        try {
            final DepartamentoEntity[] deCollection = departamentoDAO.recuperarDepartamentos();
            final List<Departamento> departamentos = new ArrayList<>();
            AlojamientoEntity ae;
            for (final DepartamentoEntity de : deCollection) {
                ae = alojamientoDAO.recuperarAlojamientos(de.getAlojamientoId());
                departamentos.add(DepartamentoMapper.fromEntity(de, ae));
            }
            callback.onSuccess(departamentos);
        } catch (final Exception e) {
            callback.onError(e);
        }
    }

    @Override
    public void recuperarAlojaientos(final OnResult<List<Alojamiento>> callback) {
        try {
            final AlojamientoEntity[] aeCollection = alojamientoDAO.recuperarAlojamientos();
            final List<Alojamiento> alojamientos = new ArrayList<>();
            DepartamentoEntity de;
            HabitacionEntity he;
            for (final AlojamientoEntity ae : aeCollection) {
                if (Objects.equals(ae.getTipo(), AlojamientoEntity.TIPO_DEPARTAMENTO)) {
                    de = departamentoDAO.recuperarDepartamentoConAlojamiento(ae.getId());
                    alojamientos.add(DepartamentoMapper.fromEntity(de, ae));
                } else {
                    he = habitacionDAO.recuperarHabitacionConAlojamiento(ae.getId());
                    alojamientos.add(HabitacionMapper.fromEntity(he, ae));
                }
            }
            callback.onSuccess(alojamientos);
        } catch (final Exception e) {
            callback.onError(e);
        }
    }
}
