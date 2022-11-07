package com.example.datalayerexample.data.datasource.room.mapper;

import com.example.datalayerexample.data.datasource.room.entities.AlojamientoEntity;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Habitacion;

public abstract class AlojamientoMapper {
    private AlojamientoMapper() {
    }

    public static AlojamientoEntity toEntity(final Alojamiento alojamiento) {
        return new AlojamientoEntity(
            alojamiento.getTitulo(),
            alojamiento instanceof Habitacion ? AlojamientoEntity.TIPO_HABITACION : AlojamientoEntity.TIPO_DEPARTAMENTO,
            alojamiento.getDescripcion(),
            alojamiento.getCapacidad(),
            alojamiento.getPrecioBase()
        );
    }
}
