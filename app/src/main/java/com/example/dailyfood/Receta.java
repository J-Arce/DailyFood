package com.example.dailyfood;

import java.util.List;

public class Receta {
    private String nombreReceta;
    private List<String> ingredientes; // Cambiar el tipo a List<String>
    private String preparacion;

    public Receta(String nombreReceta, List<String> ingredientes, String preparacion) {
        this.nombreReceta = nombreReceta;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public List<String> getIngredientes() {
        return ingredientes; // Devolver la lista de ingredientes
    }

    public String getPreparacion() {
        return preparacion;
    }
}

