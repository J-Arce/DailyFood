package com.example.dailyfood;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.TextView;
import java.util.List;

public class MisRecetas extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mis_recetas, container, false);

        // Accede a la lista de recetas desde la clase de aplicación personalizada
        MyApplication myApp = (MyApplication) getActivity().getApplication();
        List<Receta> recetas = myApp.getRecetas();

        // Supongamos que solo deseas mostrar la primera receta en la lista
        if (!recetas.isEmpty()) {
            Receta primeraReceta = recetas.get(0);

            // Muestra el nombre de la receta
            TextView textViewNombreReceta = view.findViewById(R.id.textViewNombreReceta);
            textViewNombreReceta.setText(primeraReceta.getNombreReceta());

            // Muestra la lista de ingredientes (suponiendo que getIngredientes() devuelve una lista de ingredientes)
            TextView textViewIngredientes = view.findViewById(R.id.textViewIngredientes);
            List<String> ingredientes = primeraReceta.getIngredientes();
            textViewIngredientes.setText(TextUtils.join("\n", ingredientes));

            // Muestra las instrucciones de preparación (suponiendo que getPreparacion() devuelve un String)
            TextView textViewPreparacion = view.findViewById(R.id.textViewPreparacion);
            String preparacion = primeraReceta.getPreparacion();
            textViewPreparacion.setText(preparacion);

        }

        return view;
    }
}
