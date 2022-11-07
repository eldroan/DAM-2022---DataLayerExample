package com.example.datalayerexample.data.datasource.room.mapper;

import android.util.Log;
import com.example.datalayerexample.data.datasource.room.entities.AlojamientoEntity;
import com.example.datalayerexample.data.datasource.room.entities.DepartamentoEntity;
import com.example.datalayerexample.data.model.Departamento;
import java.util.UUID;

public final class DepartamentoMapper {
    private DepartamentoMapper() {
    }

    public static DepartamentoEntity toEntity(final Departamento departamento, final UUID alojamientoId) {
        return new DepartamentoEntity(
            departamento.getId() == null ? UUID.randomUUID() : departamento.getId(),
            departamento.getTieneWifi(),
            departamento.getCostoLimpieza(),
            departamento.getCantidadHabitaciones(),
            alojamientoId
        );
    }

    public static Departamento fromEntity(DepartamentoEntity departamento, AlojamientoEntity alojamiento) {
        if(departamento.getId()==null){
            Log.d("asd","asd");
        }
        return new Departamento(
            departamento.getId(),
            alojamiento.getTitulo(),
            alojamiento.getDescripcion(),
            alojamiento.getCapacidad(),
            alojamiento.getPrecioBase(),
            departamento.getTieneWifi(),
            departamento.getCostoLimpieza(),
            departamento.getCantidadHabitaciones(),
            null // TODO: Agregar ubicaciones
        );
    }
}
