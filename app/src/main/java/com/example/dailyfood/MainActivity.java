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

        // Configura un oyente para manejar los cambios en las pestañas
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Obtiene la posición de la pestaña seleccionada
                int position = tab.getPosition();
                Fragment fragment = null;

                // Crea el fragmento correspondiente según la posición
                if (position == 0) {
                    fragment = new Iniciar();
                } else if (position == 1) {
                    fragment = new Registrarse();
                }

                // Reemplaza el fragmento actual en el contenedor
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedorInicio, fragment)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // No es necesario implementar esta parte
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // No es necesario implementar esta parte
            }
        });
    }

    public void registrarUsuario(String email, String contrasenia) {
        CredencialUsuario nuevaCredencial = new CredencialUsuario(email, contrasenia);
        listaCredenciales.add(nuevaCredencial);

        // Mostrar un mensaje Toast para indicar que el usuario se ha registrado exitosamente
        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
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