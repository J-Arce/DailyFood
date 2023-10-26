package com.example.dailyfood;

public class Ingrediente {
    private String nombre;
    private boolean marcado;

    public Ingrediente(String nombre, boolean marcado) {
        this.nombre = nombre;
        this.marcado = marcado;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
}