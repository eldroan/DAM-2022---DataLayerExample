package com.example.datalayerexample.data.model;

import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("UseOfObsoleteDateTimeApi")
public class Reserva {
    private final UUID alojamientoId;
    private final UUID usuarioId;
    private final Date fechaEntrada;
    private final Date fechaSalida;

    public Reserva(final UUID alojamientoId, final UUID usuarioId, final Date fechaEntrada,
        final Date fechaSalida) {
        this.alojamientoId = alojamientoId;
        this.usuarioId = usuarioId;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reserva)) {
            return false;
        }
        final Reserva reserva = (Reserva) o;
        return Objects.equals(alojamientoId, reserva.alojamientoId) && Objects.equals(usuarioId,
            reserva.usuarioId) && Objects.equals(fechaEntrada, reserva.fechaEntrada) && Objects.equals(
            fechaSalida, reserva.fechaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alojamientoId, usuarioId, fechaEntrada, fechaSalida);
    }

    @NonNull
    @Override
    public String toString() {
        return "Reserva{" +
               "alojamientoId=" + alojamientoId +
               ", usuarioId=" + usuarioId +
               ", fechaEntrada=" + fechaEntrada +
               ", fechaSalida=" + fechaSalida +
               '}';
    }
}
