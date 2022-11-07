package com.example.datalayerexample.ui.listado_alojamiento;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.datalayerexample.databinding.FragmentListadoAlojamientoBinding;
import com.example.datalayerexample.ui.listado_alojamiento.listado.AlojamientoAdapter;
import com.google.android.material.snackbar.Snackbar;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG;
import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT;

public class ListadoAlojamientoFragment extends Fragment {

    private FragmentListadoAlojamientoBinding binding;
    private ListadoAlojamientoViewModel viewmodel;

    @Override
    public View onCreateView(
        @NonNull final LayoutInflater inflater, final ViewGroup container,
        final Bundle savedInstanceState
    ) {

        binding = FragmentListadoAlojamientoBinding.inflate(inflater, container, false);
        binding.list.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewmodel = new ViewModelProvider(this, new ListadoAlojamientoViewModelFactory(getContext())).get(
            ListadoAlojamientoViewModel.class);
        viewmodel.alojamientoCollection.observe(getViewLifecycleOwner(), alojamientos -> {
            binding.list.setAdapter(new AlojamientoAdapter(alojamientos));
        });
        viewmodel.loading.observe(getViewLifecycleOwner(), loading -> {
            if (loading) {
                Snackbar.make(view, "Cargando...", LENGTH_SHORT).show();
            }
        });
        viewmodel.error.observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Snackbar.make(view, "Algo salio mal: " + error, LENGTH_LONG).show();
                Log.e("ERROR DATA", "Algo salio mal", error);
            }
        });
        binding.buscar.setOnClickListener(v -> {
            /* FIXME: Acá hay un bug que no llegue a revisar del todo. Al crearse la db y llenarse con los valores
            *  default a veces revienta un mapper a hacer getId() con un null pointer exception...
            */
            viewmodel.recuperarAlojamientos();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
