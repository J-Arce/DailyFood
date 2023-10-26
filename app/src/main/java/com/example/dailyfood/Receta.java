package com.example.dailyfood;

public class Receta {
    private String nombreReceta;
    private String campo2;
    private String preparacion;

    public Receta(String nombreReceta, String campo2, String preparacion) {
        this.nombreReceta = nombreReceta;
        this.campo2 = campo2;
        this.preparacion = preparacion;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public String getCampo2() {
        return campo2;
    }

    public String getPreparacion() {
        return preparacion;
    }
}
