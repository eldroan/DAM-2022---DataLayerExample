package com.example.datalayerexample.ui.listado_alojamiento;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.datalayerexample.data.factory.AlojamientoRepositoryFactory;
import com.example.datalayerexample.data.repository.AlojamientoRepository;

public class ListadoAlojamientoViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;

    public ListadoAlojamientoViewModelFactory(final Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListadoAlojamientoViewModel.class)) {
            final AlojamientoRepository repo = AlojamientoRepositoryFactory.create(context);
            //noinspection unchecked
            return (T) new ListadoAlojamientoViewModel(repo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
