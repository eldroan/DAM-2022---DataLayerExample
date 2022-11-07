package com.example.datalayerexample.data.datasource.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity
public class AlojamientoEntity {
    public static final String TIPO_DEPARTAMENTO = "departamento";
    public static final String TIPO_HABITACION = "habitacion";
    @PrimaryKey
    @NonNull
    protected UUID id;
    protected String titulo;
    protected String tipo;
    protected String descripcion;
    protected Integer capacidad;

    @ColumnInfo(name = "precio_base")
    protected Double precioBase;

    public AlojamientoEntity(@NonNull final UUID id, final String titulo, final String tipo, final String descripcion,
        final Integer capacidad,
        final Double precioBase) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
    }

    @Ignore
    public AlojamientoEntity(final String titulo, final String tipo, final String descripcion, final Integer capacidad,
        final Double precioBase) {
        id = UUID.randomUUID();
        this.titulo = titulo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
    }

    @NonNull
    public UUID getId() {
        return id;
    }

    public void setId(@NonNull final UUID id) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }
}
