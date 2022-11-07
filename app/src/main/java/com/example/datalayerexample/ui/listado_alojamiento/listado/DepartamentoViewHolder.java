package com.example.datalayerexample.ui.listado_alojamiento.listado;

import androidx.annotation.NonNull;
import com.example.datalayerexample.data.model.Departamento;
import com.example.datalayerexample.databinding.ItemDepartamentoViewBinding;
import com.google.android.material.snackbar.Snackbar;

public class DepartamentoViewHolder extends AlojamientoViewHolder<Departamento> {
    public static final int TYPE = 1;
    private final ItemDepartamentoViewBinding binding;

    public DepartamentoViewHolder(@NonNull final ItemDepartamentoViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void bind(final Departamento departamento) {
        binding.title.setText(departamento.getTitulo());
        binding.descripcion.setText(departamento.getDescripcion());
        binding.container.setOnClickListener(
            view -> Snackbar.make(view, "Apretaste la row con titulo " + departamento.getTitulo(), Snackbar.LENGTH_LONG)
                .show()
        );
    }
}
