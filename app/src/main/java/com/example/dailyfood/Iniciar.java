package com.example.dailyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Iniciar extends Fragment {

    private EditText emailEditText;
    private EditText contraseniaEditText;
    private Button iniciarSesionButton;

    public Iniciar() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_iniciar, container, false);

        emailEditText = view.findViewById(R.id.editTextEmailIniciar); // Asegúrate de que el ID sea correcto
        contraseniaEditText = view.findViewById(R.id.editTextContraseniaIniciar); // Asegúrate de que el ID sea correcto
        iniciarSesionButton = view.findViewById(R.id.btnIniciarSesion); // Asegúrate de que el ID sea correcto

        iniciarSesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el correo electrónico y la contraseña ingresados por el usuario
                String emailIngresado = emailEditText.getText().toString();
                String contraseniaIngresada = contraseniaEditText.getText().toString();

                // Verificar el inicio de sesión utilizando el método en MainActivity
                if (((MainActivity) requireActivity()).iniciarSesion(emailIngresado, contraseniaIngresada)) {
                    // Inicio de sesión exitoso, navegar a ActivityPrincipal
                    Intent intent = new Intent(getActivity(), Principal.class);
                    startActivity(intent);
                } else {
                    // Muestra un mensaje de error
                    Toast.makeText(requireContext(), "Error en las credenciales", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
