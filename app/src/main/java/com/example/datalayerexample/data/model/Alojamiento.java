package com.example.datalayerexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.UUID;

public class Alojamiento implements Parcelable {
    protected UUID id;
    protected String titulo;
    protected String descripcion;
    protected Integer capacidad;
    protected Double precioBase;

    protected Alojamiento(final String titulo, final String descripcion, final Integer capacidad,
        final Double precioBase) {
        this(null, titulo, descripcion, capacidad, precioBase);
    }

    protected Alojamiento(final UUID id, final String titulo, final String descripcion, final Integer capacidad,
        final Double precioBase) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
    }

    protected Alojamiento(final Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0) {
            capacidad = null;
        } else {
            capacidad = in.readInt();
        }
        if (in.readByte() == 0) {
            precioBase = null;
        } else {
            precioBase = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
        if (capacidad == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(capacidad);
        }
        if (precioBase == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(precioBase);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Alojamiento> CREATOR = new Creator<Alojamiento>() {
        @Override
        public Alojamiento createFromParcel(final Parcel in) {
            return new Alojamiento(in);
        }

        @Override
        public Alojamiento[] newArray(final int size) {
            return new Alojamiento[size];
        }
    };

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(final Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(final Double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Alojamiento)) {
            return false;
        }
        final Alojamiento that = (Alojamiento) o;
        return Objects.equals(id, that.id) && Objects.equals(titulo, that.titulo)
               && Objects.equals(descripcion, that.descripcion) && Objects.equals(capacidad,
            that.capacidad) && Objects.equals(precioBase, that.precioBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descripcion, capacidad, precioBase);
    }

    @NonNull
    @Override
    public String toString() {
        return "Alojamiento{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", capacidad=" + capacidad +
               ", precioBase=" + precioBase +
               '}';
    }
}
