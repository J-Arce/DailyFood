package com.example.dailyfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class CrearReceta extends Fragment {

    private EditText editTextNombreReceta;
    private EditText editTextCampo2; // Ahora se usará para ingresar la lista de alimentos
    private EditText editTextPreparacion;
    private Button btnGuardarCrearReceta;
    private List<String> listaAlimentos = new ArrayList<>(); // Lista para almacenar alimentos

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crear_receta, container, false);

        editTextNombreReceta = view.findViewById(R.id.editTextNombreReceta);
        editTextCampo2 = view.findViewById(R.id.editTextIngredientes); // Cambiado el ID
        editTextPreparacion = view.findViewById(R.id.editTextPreparacion);
        btnGuardarCrearReceta = view.findViewById(R.id.btnGuardarCrearReceta);

        btnGuardarCrearReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los EditText
                String nombreReceta = editTextNombreReceta.getText().toString();
                String preparacion = editTextPreparacion.getText().toString();

                // Obtener los ingredientes del EditText (línea por línea)
                String ingredientesText = editTextCampo2.getText().toString();
                String[] ingredientesArray = ingredientesText.split("\n");

                // Crear una lista de ingredientes a partir del array
                List<String> listaAlimentos = new ArrayList<>();
                for (String ingrediente : ingredientesArray) {
                    if (!ingrediente.trim().isEmpty()) {
                        listaAlimentos.add(ingrediente);
                    }
                }

                // Crear un objeto Receta con la lista de alimentos
                Receta receta = new Receta(nombreReceta, listaAlimentos, preparacion);

                MyApplication myApp = (MyApplication) getActivity().getApplication();
                myApp.addReceta(receta);

                // Mostrar los atributos del objeto
                String objeto = "Nombre de la receta: " + receta.getNombreReceta() + "\n" +
                        "Ingredientes: " + receta.getIngredientes().toString() + "\n" +
                        "Preparación: " + receta.getPreparacion();

                Toast.makeText(getContext(), objeto, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
