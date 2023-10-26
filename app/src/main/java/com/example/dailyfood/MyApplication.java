package com.example.dailyfood;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    private List<Receta> recetas = new ArrayList<>();

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void addReceta(Receta receta) {
        recetas.add(receta);
    }
}