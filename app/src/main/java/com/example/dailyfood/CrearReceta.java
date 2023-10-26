package com.example.dailyfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class CrearReceta extends Fragment {

    private EditText editTextNombreReceta;
    private EditText editTextCampo2;
    private EditText editTextPreparacion;
    private Button btnGuardarCrearReceta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crear_receta, container, false);

        editTextNombreReceta = view.findViewById(R.id.editTextNombreReceta);
        editTextCampo2 = view.findViewById(R.id.editTextCampo2);
        editTextPreparacion = view.findViewById(R.id.editTextPreparacion);
        btnGuardarCrearReceta = view.findViewById(R.id.btnGuardarCrearReceta);

        btnGuardarCrearReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los EditText
                String nombreReceta = editTextNombreReceta.getText().toString();
                String campo2 = editTextCampo2.getText().toString(); // Opcional
                String preparacion = editTextPreparacion.getText().toString();

                // Crear un objeto Receta
                Receta receta = new Receta(nombreReceta, campo2, preparacion);

                // Mostrar los atributos del objeto
                /*String objeto = "Nombre de la receta: " + receta.getNombreReceta() + "\n" +
                        "Campo 2: " + receta.getCampo2() + "\n" +
                        "Preparación: " + receta.getPreparacion();

                Toast.makeText(getContext(), objeto, Toast.LENGTH_LONG).show();*/
                Toast.makeText(getContext(), "Receta creada exitosamente", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}

