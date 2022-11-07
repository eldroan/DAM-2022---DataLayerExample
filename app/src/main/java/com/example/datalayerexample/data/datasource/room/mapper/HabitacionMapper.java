package com.example.datalayerexample.data.datasource.room.mapper;

import com.example.datalayerexample.data.datasource.room.entities.AlojamientoEntity;
import com.example.datalayerexample.data.datasource.room.entities.HabitacionEntity;
import com.example.datalayerexample.data.model.Habitacion;
import java.util.UUID;

public class HabitacionMapper {

    private HabitacionMapper() {
    }

    public static HabitacionEntity toEntity(final Habitacion habitacion, final UUID alojamientoId) {
        return new HabitacionEntity(
            habitacion.getId() == null? UUID.randomUUID(): habitacion.getId(),
            habitacion.getCamasIndividuales(),
            habitacion.getCamasMatrimoniales(),
            habitacion.getTieneEstacionamiento(),
            alojamientoId
        );
    }

    public static Habitacion fromEntity(HabitacionEntity habitacion, AlojamientoEntity alojamiento) {
        return new Habitacion(
            habitacion.getId(),
            alojamiento.getTitulo(),
            alojamiento.getDescripcion(),
            alojamiento.getCapacidad(),
            alojamiento.getPrecioBase(),
            habitacion.getCamasIndividuales(),
            habitacion.getCamasMatrimoniales(),
            habitacion.getTieneEstacionamiento(),
            null // TODO: Agregar hotel
        );
    }
}
