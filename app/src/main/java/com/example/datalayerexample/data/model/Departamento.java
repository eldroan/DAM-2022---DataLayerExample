package com.example.datalayerexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.UUID;

public class Departamento extends Alojamiento implements Parcelable {
    private Boolean tieneWifi;
    private Double costoLimpieza;
    private Integer cantidadHabitaciones;
    private Ubicacion ubicacion;
    public Departamento(final String titulo, final String descripcion, final Integer capacidad,
        final Double precioBase, final Boolean tieneWifi, final Double costoLimpieza,
        final Integer cantidadHabitaciones,
        final Ubicacion ubicacion) {
        this(null, titulo, descripcion, capacidad, precioBase, tieneWifi, costoLimpieza, cantidadHabitaciones,
            ubicacion);
    }

    public Departamento(final UUID id, final String titulo, final String descripcion, final Integer capacidad,
        final Double precioBase, final Boolean tieneWifi, final Double costoLimpieza,
        final Integer cantidadHabitaciones,
        final Ubicacion ubicacion) {
        super(id, titulo, descripcion, capacidad, precioBase);
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.ubicacion = ubicacion;
    }

    protected Departamento(final Parcel in) {
        super(in);
        final byte tmpTieneWifi = in.readByte();
        tieneWifi = tmpTieneWifi == 0 ? null : tmpTieneWifi == 1;
        if (in.readByte() == 0) {
            costoLimpieza = null;
        } else {
            costoLimpieza = in.readDouble();
        }
        if (in.readByte() == 0) {
            cantidadHabitaciones = null;
        } else {
            cantidadHabitaciones = in.readInt();
        }
        ubicacion = in.readParcelable(Ubicacion.class.getClassLoader());
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        super.writeToParcel(dest, flags);
        dest.writeByte((byte) (tieneWifi == null ? 0 : tieneWifi ? 1 : 2));
        if (costoLimpieza == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(costoLimpieza);
        }
        if (cantidadHabitaciones == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cantidadHabitaciones);
        }
        dest.writeParcelable(ubicacion, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Departamento> CREATOR = new Creator<Departamento>() {
        @Override
        public Departamento createFromParcel(final Parcel in) {
            return new Departamento(in);
        }

        @Override
        public Departamento[] newArray(final int size) {
            return new Departamento[size];
        }
    };

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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(final Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Departamento)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Departamento that = (Departamento) o;
        return Objects.equals(tieneWifi, that.tieneWifi) && Objects.equals(costoLimpieza,
            that.costoLimpieza) && Objects.equals(cantidadHabitaciones, that.cantidadHabitaciones)
               && Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tieneWifi, costoLimpieza, cantidadHabitaciones, ubicacion);
    }

    @NonNull
    @Override
    public String toString() {
        return "Departamento{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", capacidad=" + capacidad +
               ", precioBase=" + precioBase +
               ", tieneWifi=" + tieneWifi +
               ", costoLimpieza=" + costoLimpieza +
               ", cantidadHabitaciones=" + cantidadHabitaciones +
               ", ubicacion=" + ubicacion +
               '}';
    }
}
