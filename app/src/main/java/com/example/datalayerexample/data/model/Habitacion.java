package com.example.datalayerexample.data.model;

import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.UUID;

public class Habitacion extends Alojamiento {
    private Integer camasIndividuales;
    private Integer camasMatrimoniales;
    private Boolean tieneEstacionamiento;
    private Hotel hotel;

    public Habitacion(final String titulo, final String descripcion, final Integer capacidad,
        final Double precioBase, final Integer camasIndividuales, final Integer camasMatrimoniales,
        final Boolean tieneEstacionamiento, final Hotel hotel) {
        this(null, titulo, descripcion, capacidad, precioBase, camasIndividuales, camasMatrimoniales,
            tieneEstacionamiento, hotel);
    }

    public Habitacion(final UUID id, final String titulo, final String descripcion, final Integer capacidad,
        final Double precioBase, final Integer camasIndividuales, final Integer camasMatrimoniales,
        final Boolean tieneEstacionamiento, final Hotel hotel) {
        super(id, titulo, descripcion, capacidad, precioBase);
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotel = hotel;
    }

    public Integer getCamasIndividuales() {
        return camasIndividuales;
    }

    public void setCamasIndividuales(final Integer camasIndividuales) {
        this.camasIndividuales = camasIndividuales;
    }

    public Integer getCamasMatrimoniales() {
        return camasMatrimoniales;
    }

    public void setCamasMatrimoniales(final Integer camasMatrimoniales) {
        this.camasMatrimoniales = camasMatrimoniales;
    }

    public Boolean getTieneEstacionamiento() {
        return tieneEstacionamiento;
    }

    public void setTieneEstacionamiento(final Boolean tieneEstacionamiento) {
        this.tieneEstacionamiento = tieneEstacionamiento;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(final Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Habitacion)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Habitacion that = (Habitacion) o;
        return Objects.equals(camasIndividuales, that.camasIndividuales) && Objects.equals(
            camasMatrimoniales, that.camasMatrimoniales) && Objects.equals(tieneEstacionamiento,
            that.tieneEstacionamiento) && Objects.equals(hotel, that.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), camasIndividuales, camasMatrimoniales, tieneEstacionamiento, hotel);
    }

    @NonNull
    @Override
    public String toString() {
        return "Habitacion{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", capacidad=" + capacidad +
               ", precioBase=" + precioBase +
               ", camasIndividuales=" + camasIndividuales +
               ", camasMatrimoniales=" + camasMatrimoniales +
               ", tieneEstacionamiento=" + tieneEstacionamiento +
               ", hotel=" + hotel +
               '}';
    }
}
