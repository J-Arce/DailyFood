package com.example.dailyfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

public class MisIngredientes extends Fragment {

    private ArrayList<Ingrediente> listaIngredientes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mis_ingredientes, container, false);

        // Obtener las listas de ingredientes desde el fragmento IngresarAlimento
        IngresarAlimento ingresarAlimento = (IngresarAlimento) getParentFragmentManager().findFragmentByTag("fragment_ingresar_alimento");

        if (ingresarAlimento != null) {
            listaIngredientes = new ArrayList<>();
            ArrayList<String> nombresIngredientes = ingresarAlimento.getListaIngredientes();

            // Inicializa la lista de ingredientes con todos los ingredientes no marcados
            for (String nombreIngrediente : nombresIngredientes) {
                listaIngredientes.add(new Ingrediente(nombreIngrediente, false));
            }
        } else {
            Toast.makeText(getActivity(), "No se encontró el fragmento ingresar alimento".toString(), Toast.LENGTH_LONG).show();
        }

        RecyclerView recyclerViewIngredientes = view.findViewById(R.id.recyclerViewIngredientes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerViewIngredientes.setLayoutManager(layoutManager);

        IngredientesAdapter ingredientesAdapter = new IngredientesAdapter(listaIngredientes);
        recyclerViewIngredientes.setAdapter(ingredientesAdapter);

        return view;
    }
}

