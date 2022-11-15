package com.example.datalayerexample.data.model;

import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.UUID;

public class Favorito {
    private final UUID alojamientoId;
    private final UUID usuarioId;

    public Favorito(final UUID alojamientoId, final UUID usuarioId) {
        this.alojamientoId = alojamientoId;
        this.usuarioId = usuarioId;
    }

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Favorito)) {
            return false;
        }
        final Favorito favorito = (Favorito) o;
        return Objects.equals(alojamientoId, favorito.alojamientoId) && Objects.equals(usuarioId,
            favorito.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alojamientoId, usuarioId);
    }

    @NonNull
    @Override
    public String toString() {
        return "Favorito{" +
               "alojamientoId=" + alojamientoId +
               ", usuarioId=" + usuarioId +
               '}';
    }
}
