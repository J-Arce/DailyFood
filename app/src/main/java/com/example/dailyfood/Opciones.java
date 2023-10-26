package com.example.dailyfood;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.example.dailyfood.IngresarAlimento;
import com.example.dailyfood.CrearReceta;

public class Opciones extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opciones, container, false);

        // Buscar los botones por su ID
        Button btnIngresarAlimento = view.findViewById(R.id.btnIngresarAlimento);
        Button btnCrearReceta = view.findViewById(R.id.btnCrearReceta);

        // Agregar un OnClickListener al botón "Ingresar Alimento"
        btnIngresarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer clic en el botón, cargar el fragmento "IngresarAlimento"
                IngresarAlimento ingresarAlimentoFragment = new IngresarAlimento();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Etiquetar el fragmento "IngresarAlimento"
                transaction.replace(R.id.contenedor, ingresarAlimentoFragment, "fragment_ingresar_alimento");

                transaction.addToBackStack(null); // Agregar al historial de retroceso
                transaction.commit();
            }
        });

        // Agregar un OnClickListener al botón "Crear Receta"
        btnCrearReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer clic en el botón, cargar el fragmento "CrearReceta"
                CrearReceta crearRecetaFragment = new CrearReceta();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, crearRecetaFragment);
                transaction.addToBackStack(null); // Agregar al historial de retroceso
                transaction.commit();
            }
        });

        return view;
    }
}