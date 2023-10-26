package com.example.dailyfood;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CredencialUsuario> listaCredenciales = new ArrayList<>();
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayoutInicio);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedorInicio, new Iniciar())
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment fragment = null;

                if (position == 0) {
                    fragment = new Iniciar();
                } else if (position == 1) {
                    fragment = new Registrarse();
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedorInicio, fragment)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void registrarUsuario(String email, String contrasenia) {
        CredencialUsuario nuevaCredencial = new CredencialUsuario(email, contrasenia);
        listaCredenciales.add(nuevaCredencial);

        // Registrado exitosamente
        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
    }

    public void cargarFragmentoIniciar() {
        Iniciar iniciarFragment = new Iniciar();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, iniciarFragment)
                .addToBackStack(null)
                .commit();
    }


    public boolean iniciarSesion(String emailIngresado, String contraseniaIngresada) {
        for (CredencialUsuario credencial : listaCredenciales) {
            if (credencial.getEmail().equals(emailIngresado) && credencial.getContrasenia().equals(contraseniaIngresada)) {
                return true; // Inicio de sesión exitoso
            }
        }
        return false; // Credenciales incorrectas
    }
}