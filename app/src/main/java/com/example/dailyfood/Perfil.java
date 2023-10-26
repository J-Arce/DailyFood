package com.example.dailyfood;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        Button preparacionesMeGustanButton = view.findViewById(R.id.preparacionesMeGustan);
        Button misRecetasButton = view.findViewById(R.id.misRecetas);
        TextView cerrarSesionTextView = view.findViewById(R.id.cerrarSesion);

        preparacionesMeGustanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea una instancia del fragmento "RecetasFavoritas"
                RecetasFavoritas recetasFavoritasFragment = new RecetasFavoritas();

                // Realiza una transacción de fragmentos para mostrar "RecetasFavoritas"
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor, recetasFavoritasFragment)
                        .addToBackStack(null) // Opcional, para permitir la navegación hacia atrás
                        .commit();
            }
        });

        misRecetasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea una instancia del fragmento "MisRecetas"
                MisRecetas misRecetasFragment = new MisRecetas();

                // Realiza una transacción de fragmentos para mostrar "MisRecetas"
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor, misRecetasFragment)
                        .addToBackStack(null) // Opcional, para permitir la navegación hacia atrás
                        .commit();
            }
        });

        cerrarSesionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar al MainActivity y cargar el fragmento "Iniciar"
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.cargarFragmentoIniciar();
            }
        });

        return view;
    }
}