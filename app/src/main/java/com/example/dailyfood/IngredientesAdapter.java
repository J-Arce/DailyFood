package com.example.dailyfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IngredientesAdapter extends RecyclerView.Adapter<IngredientesAdapter.IngredientViewHolder> {

    private ArrayList<String> ingredientesList;

    public IngredientesAdapter(ArrayList<String> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ingredientes, parent, false);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        String ingrediente = ingredientesList.get(position);
        holder.bind(ingrediente);
    }

    @Override
    public int getItemCount() {
        return ingredientesList.size();
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewIngrediente;

        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIngrediente = itemView.findViewById(R.id.textViewIngrediente);
        }

        public void bind(String ingrediente) {
            textViewIngrediente.setText(ingrediente);
        }
    }
}
