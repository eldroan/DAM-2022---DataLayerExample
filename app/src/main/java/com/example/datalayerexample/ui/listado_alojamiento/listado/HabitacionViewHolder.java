package com.example.datalayerexample.ui.listado_alojamiento.listado;

import androidx.annotation.NonNull;
import com.example.datalayerexample.data.model.Habitacion;
import com.example.datalayerexample.databinding.ItemHabitacionViewBinding;
import com.google.android.material.snackbar.Snackbar;

public class HabitacionViewHolder extends AlojamientoViewHolder<Habitacion> {
    public static final int TYPE = 2;
    private final ItemHabitacionViewBinding binding;

    public HabitacionViewHolder(@NonNull final ItemHabitacionViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void bind(final Habitacion habitacion) {
        binding.title.setText(habitacion.getTitulo());
        binding.descripcion.setText(habitacion.getDescripcion());
        binding.container.setOnClickListener(
            view -> Snackbar.make(view, "Apretaste la row con titulo " + habitacion.getTitulo(), Snackbar.LENGTH_LONG)
                .show()
        );
    }
}
