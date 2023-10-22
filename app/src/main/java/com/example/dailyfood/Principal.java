package com.example.dailyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Llamar al fragmento Home
        Home h = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,h).commit();

        TabLayout tl = (TabLayout) findViewById(R.id.tabLayout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        // Llamar al fragmento Home
                        Home h = new Home();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,h).commit();
                        break;
                    case 1:
                        // Llamar al fragmento Opciones
                        Opciones o = new Opciones();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,o).commit();
                        break;
                    case 2:
                        // Llamar al fragmento Recetas
                        Recetas r = new Recetas();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,r).commit();
                        break;
                    case 3:
                        // Llamar al fragmento Mis Ingredientes
                        MisIngredientes m = new MisIngredientes();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,m).commit();
                        break;
                    case 4:
                        // Llamar al fragmento Perfil
                        Perfil p = new Perfil();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,p).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}