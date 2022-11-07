package com.example.datalayerexample.data.datasource.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity(
    indices = @Index(value = { "alojamiento_id" }),
    foreignKeys = @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "id", childColumns = "alojamiento_id",
        onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class DepartamentoEntity {
    @PrimaryKey
    @NonNull
    private UUID id;
    private Boolean tieneWifi;
    private Double costoLimpieza;
    private Integer cantidadHabitaciones;
    @ColumnInfo(name = "alojamiento_id")
    private UUID alojamientoId;

    // TODO:
    //  private Integer ubicacionId;

    @Ignore
    public DepartamentoEntity(final Boolean tieneWifi, final Double costoLimpieza,
        final Integer cantidadHabitaciones,
        final UUID alojamientoId) {
        id = UUID.randomUUID();
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.alojamientoId = alojamientoId;
    }

    public DepartamentoEntity(@NonNull final UUID id, final Boolean tieneWifi, final Double costoLimpieza,
        final Integer cantidadHabitaciones,
        final UUID alojamientoId) {
        this.id = id;
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.alojamientoId = alojamientoId;
    }

    @NonNull
    public UUID getId() {
        return id;
    }

    public void setId(@NonNull final UUID id) {
        this.id = id;
    }

    public Boolean getTieneWifi() {
        return tieneWifi;
    }

    public void setTieneWifi(final Boolean tieneWifi) {
        this.tieneWifi = tieneWifi;
    }

    public Double getCostoLimpieza() {
        return costoLimpieza;
    }

    public void setCostoLimpieza(final Double costoLimpieza) {
        this.costoLimpieza = costoLimpieza;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(final Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(final UUID alojamientoId) {
        this.alojamientoId = alojamientoId;
    }
}
