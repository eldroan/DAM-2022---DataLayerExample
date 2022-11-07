package com.example.datalayerexample.ui.listado_alojamiento.listado;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.datalayerexample.data.model.Alojamiento;

public abstract class AlojamientoViewHolder<T extends Alojamiento> extends RecyclerView.ViewHolder {

    public AlojamientoViewHolder(@NonNull final View itemView) {
        super(itemView);
    }

    public abstract void bind(final T alojamiento);
}
