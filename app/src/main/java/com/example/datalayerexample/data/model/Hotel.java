package com.example.datalayerexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {

    private Integer id;

    private String nombre;
    private Integer categoria;

    com.example.datalayerexample.data.model.Ubicacion ubicacion;

    public Hotel(final Integer id, final String nombre, final Integer categoria,
        final com.example.datalayerexample.data.model.Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public com.example.datalayerexample.data.model.Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(final com.example.datalayerexample.data.model.Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(final Integer categoria) {
        this.categoria = categoria;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(id);
        dest.writeString(nombre);
        dest.writeValue(categoria);
        dest.writeParcelable(ubicacion, flags);
    }

    public void readFromParcel(final Parcel source) {
        id = (Integer) source.readValue(Integer.class.getClassLoader());
        nombre = source.readString();
        categoria = (Integer) source.readValue(Integer.class.getClassLoader());
        ubicacion =
            source.readParcelable(com.example.datalayerexample.data.model.Ubicacion.class.getClassLoader());
    }

    protected Hotel(final Parcel in) {
        id = (Integer) in.readValue(Integer.class.getClassLoader());
        nombre = in.readString();
        categoria = (Integer) in.readValue(Integer.class.getClassLoader());
        ubicacion = in.readParcelable(com.example.datalayerexample.data.model.Ubicacion.class.getClassLoader());
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(final Parcel source) {
            return new Hotel(source);
        }

        @Override
        public Hotel[] newArray(final int size) {
            return new Hotel[size];
        }
    };
}
