package com.example.datalayerexample.ui.listado_alojamiento.listado;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.datalayerexample.data.model.Alojamiento;
import com.example.datalayerexample.data.model.Departamento;
import com.example.datalayerexample.databinding.ItemDepartamentoViewBinding;
import com.example.datalayerexample.databinding.ItemHabitacionViewBinding;
import java.util.List;

public class AlojamientoAdapter extends RecyclerView.Adapter<AlojamientoViewHolder<? extends Alojamiento>> {
    final List<Alojamiento> alojamientoCollection;

    public AlojamientoAdapter(final List<Alojamiento> alojamientoCollection) {
        this.alojamientoCollection = alojamientoCollection;
    }

    @NonNull
    @Override
    public AlojamientoViewHolder<? extends Alojamiento> onCreateViewHolder(@NonNull final ViewGroup parent,
        final int viewType) {
        switch (viewType) {
        case DepartamentoViewHolder.TYPE:
            final ItemDepartamentoViewBinding departamentoBinding =
                ItemDepartamentoViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new DepartamentoViewHolder(departamentoBinding);
        case HabitacionViewHolder.TYPE:
            final ItemHabitacionViewBinding habitacionBinding =
                ItemHabitacionViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new HabitacionViewHolder(habitacionBinding);
        default:
            throw new RuntimeException("No se encontro el viewtype " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final AlojamientoViewHolder holder, final int position) {
        //noinspection unchecked
        holder.bind(alojamientoCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return alojamientoCollection.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return alojamientoCollection.get(position) instanceof Departamento ? DepartamentoViewHolder.TYPE
            : HabitacionViewHolder.TYPE;
    }
}
