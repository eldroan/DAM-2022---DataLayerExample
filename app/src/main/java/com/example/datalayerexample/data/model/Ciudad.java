package com.example.datalayerexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.Ignore;

public class Ciudad implements Parcelable {
    private Integer id;
    private String nombre;
    private String abreviatura;

    public Ciudad() {
    }

    @Ignore
    public Ciudad(final Integer id, final String nombre, final String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(final String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public void setId(@NonNull final Integer id) {
        this.id = id;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(id);
        dest.writeString(nombre);
        dest.writeString(abreviatura);
    }

    public void readFromParcel(final Parcel source) {
        id = (Integer) source.readValue(Integer.class.getClassLoader());
        nombre = source.readString();
        abreviatura = source.readString();
    }

    protected Ciudad(final Parcel in) {
        id = (Integer) in.readValue(Integer.class.getClassLoader());
        nombre = in.readString();
        abreviatura = in.readString();
    }

    public static final Creator<Ciudad> CREATOR = new Creator<Ciudad>() {
        @Override
        public Ciudad createFromParcel(final Parcel source) {
            return new Ciudad(source);
        }

        @Override
        public Ciudad[] newArray(final int size) {
            return new Ciudad[size];
        }
    };
}
