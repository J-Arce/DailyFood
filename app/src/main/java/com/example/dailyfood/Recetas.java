package com.example.dailyfood;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Recetas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);

        Button miSeleccionButton = view.findViewById(R.id.miSeleccion);
        Button masPopularButton = view.findViewById(R.id.masPopular);

        miSeleccionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MiSeleccion miSeleccionFragment = new MiSeleccion();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor, miSeleccionFragment)
                        .addToBackStack(null) // Agregar al historial de retroceso para volver una vista atras en vez de al login
                        .commit();
            }
        });

        masPopularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MasPopular masPopularFragment = new MasPopular();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor, masPopularFragment)
                        .addToBackStack(null) // Agregar al historial de retroceso
                        .commit();
            }
        });

        return view;
    }
}