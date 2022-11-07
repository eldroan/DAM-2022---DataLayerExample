package com.example.datalayerexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Ignore;

public class Ubicacion implements Parcelable {

    private Double lat;
    private Double lng;
    private String calle;
    private String numero;
    private Ciudad ciudad;

    public Ubicacion() {

    }

    @Ignore
    public Ubicacion(final double lat, final double lng, final String calle, final String numero, final Ciudad ciudad) {
        this.lat = lat;
        this.lng = lng;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(final Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setLat(final Double lat) {
        this.lat = lat;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public void setCalle(final String calle) {
        this.calle = calle;
    }

    public void setLng(final Double lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(calle);
        dest.writeString(numero);
        dest.writeParcelable(ciudad, flags);
    }

    public void readFromParcel(final Parcel source) {
        lat = source.readDouble();
        lng = source.readDouble();
        calle = source.readString();
        numero = source.readString();
        ciudad = source.readParcelable(Ciudad.class.getClassLoader());
    }

    protected Ubicacion(final Parcel in) {
        lat = in.readDouble();
        lng = in.readDouble();
        calle = in.readString();
        numero = in.readString();
        ciudad = in.readParcelable(Ciudad.class.getClassLoader());
    }

    public static final Creator<Ubicacion> CREATOR = new Creator<Ubicacion>() {
        @Override
        public Ubicacion createFromParcel(final Parcel source) {
            return new Ubicacion(source);
        }

        @Override
        public Ubicacion[] newArray(final int size) {
            return new Ubicacion[size];
        }
    };
}
