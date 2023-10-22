package com.example.dailyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Para hacer que la vista cargue con un fragmento */
        Iniciar i = new Iniciar();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorInicio,i).commit();

        TabLayout tl = (TabLayout) findViewById(R.id.tabLayoutInicio);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch (position){
                    case 0:
                        Iniciar i = new Iniciar();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorInicio,i).commit();
                        break;
                    case 1:
                        Registrarse r = new Registrarse();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorInicio,r).commit();
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
    public void login(View v) {
        Intent i = new Intent(this, Principal.class);
        startActivity(i);
    }
}