package com.example.dailyfood;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.dailyfood.R;
import java.util.ArrayList;

public class IngresarAlimento extends Fragment {

    private Button btnGuardarIngresarAlimento;
    private EditText editTextProteinas;
    private EditText editTextCarbohidratos;
    private EditText editTextGrasas;
    private EditText editTextBebidas;
    private EditText editTextFrutas;
    private EditText editTextVerduras;

    private ArrayList<String> listaProteinas = new ArrayList<>();
    private ArrayList<String> listaCarbohidratos = new ArrayList<>();
    private ArrayList<String> listaGrasas = new ArrayList<>();
    private ArrayList<String> listaBebidas = new ArrayList<>();
    private ArrayList<String> listaFrutas = new ArrayList<>();
    private ArrayList<String> listaVerduras = new ArrayList<>();

    // variable para guardar la lista de ingredientes
    private ArrayList<String> listaIngredientes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingresar_alimento, container, false);

        btnGuardarIngresarAlimento = view.findViewById(R.id.btnGuardarIngresarAlimento);
        editTextProteinas = view.findViewById(R.id.editTextProteinas);
        editTextCarbohidratos = view.findViewById(R.id.editTextCarbohidratos);
        editTextGrasas = view.findViewById(R.id.editTextGrasas);
        editTextBebidas = view.findViewById(R.id.editTextBebidas);
        editTextFrutas = view.findViewById(R.id.editTextFrutas);
        editTextVerduras = view.findViewById(R.id.editTextVerduras);

        btnGuardarIngresarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los EditText
                String valorProteinas = editTextProteinas.getText().toString().toLowerCase();
                String valorCarbohidratos = editTextCarbohidratos.getText().toString().toLowerCase();
                String valorGrasas = editTextGrasas.getText().toString().toLowerCase();
                String valorBebidas = editTextBebidas.getText().toString().toLowerCase();
                String valorFrutas = editTextFrutas.getText().toString().toLowerCase();
                String valorVerduras = editTextVerduras.getText().toString().toLowerCase();

                // verificar si los editext están vacíos antes de agregar a las listas y si el valor ya está en esa lista
                if (!valorProteinas.isEmpty() && !listaProteinas.contains(valorProteinas)) {
                    listaProteinas.add(valorProteinas);
                    listaIngredientes.add(valorProteinas);
                }
                if (!valorCarbohidratos.isEmpty() && !listaCarbohidratos.contains(valorCarbohidratos)) {
                    listaCarbohidratos.add(valorCarbohidratos);
                    listaIngredientes.add(valorCarbohidratos);
                }
                if (!valorGrasas.isEmpty() && !listaGrasas.contains(valorGrasas)) {
                    listaGrasas.add(valorGrasas);
                    listaIngredientes.add(valorGrasas);
                }
                if (!valorBebidas.isEmpty() && !listaBebidas.contains(valorBebidas)) {
                    listaBebidas.add(valorBebidas);
                    listaIngredientes.add(valorBebidas);
                }
                if (!valorFrutas.isEmpty() && !listaFrutas.contains(valorFrutas)) {
                    listaFrutas.add(valorFrutas);
                    listaIngredientes.add(valorFrutas);
                }
                if (!valorVerduras.isEmpty() && !listaVerduras.contains(valorVerduras)) {
                    listaVerduras.add(valorVerduras);
                    listaIngredientes.add(valorVerduras);
                }

                // Limpia los EditText después de guardar los valores
                editTextProteinas.setText("");
                editTextCarbohidratos.setText("");
                editTextGrasas.setText("");
                editTextBebidas.setText("");
                editTextFrutas.setText("");
                editTextVerduras.setText("");

                mostrarListas();
            }
        });

        return view;
    }

    private void mostrarListas() {
        StringBuilder listas = new StringBuilder("Alimentos ingresados:\n");

        listas.append("Proteínas: ").append(listaProteinas.toString()).append("\n");
        listas.append("Carbohidratos: ").append(listaCarbohidratos.toString()).append("\n");
        listas.append("Grasas: ").append(listaGrasas.toString()).append("\n");
        listas.append("Bebidas: ").append(listaBebidas.toString()).append("\n");
        listas.append("Frutas: ").append(listaFrutas.toString()).append("\n");
        listas.append("Verduras: ").append(listaVerduras.toString());

        // Muestra los alimentos ingresados a las listas
        Toast.makeText(getActivity(), listas.toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(), listaIngredientes.toString(), Toast.LENGTH_LONG).show();
    }

    public ArrayList<String> getListaIngredientes() {
        return listaIngredientes;
    }
}