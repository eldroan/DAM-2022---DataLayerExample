package com.example.datalayerexample.data;

/**
 * Interfaz genérica para respuestas asíncronas.
 * Asegurarse de volver al ui thread antes de tocar las vistas.
 * */
public interface OnResult<T> {
    void onSuccess(final T result);

    void onError(final Throwable exception);
}
