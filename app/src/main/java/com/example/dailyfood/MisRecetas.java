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

        MyApplication myApp = (MyApplication) getActivity().getApplication();
        List<Receta> recetas = myApp.getRecetas();

        if (!recetas.isEmpty()) {
            Receta primeraReceta = recetas.get(0);

            // Mostrar nombre de receta
            TextView textViewNombreReceta = view.findViewById(R.id.textViewNombreReceta);
            textViewNombreReceta.setText(primeraReceta.getNombreReceta());

            // Mostrar ingredientes
            TextView textViewIngredientes = view.findViewById(R.id.textViewIngredientes);
            List<String> ingredientes = primeraReceta.getIngredientes();
            textViewIngredientes.setText(TextUtils.join("\n", ingredientes));

            // Mostrar preparación
            TextView textViewPreparacion = view.findViewById(R.id.textViewPreparacion);
            String preparacion = primeraReceta.getPreparacion();
            textViewPreparacion.setText(preparacion);

        }

        return view;
    }
}
