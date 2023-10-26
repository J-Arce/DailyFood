package com.example.dailyfood;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;

public class Registrarse extends Fragment {

    private EditText emailEditText;
    private EditText contraseniaEditText;
    private Button registrarButton;

    public Registrarse() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrarse, container, false);

        emailEditText = view.findViewById(R.id.editTextEmail);
        contraseniaEditText = view.findViewById(R.id.editTextContrasenia);
        registrarButton = view.findViewById(R.id.buttonRegistrar);

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el correo electrónico y la contraseña ingresados por el usuario
                String email = emailEditText.getText().toString();
                String contrasenia = contraseniaEditText.getText().toString();

                // Verificar que el correo electrónico y la contraseña no estén vacíos
                if (!email.isEmpty() && !contrasenia.isEmpty()) {
                    // Registrar al usuario utilizando el método en MainActivity
                    ((MainActivity) requireActivity()).registrarUsuario(email, contrasenia);

                    // Puedes mostrar un mensaje de registro exitoso o realizar alguna otra acción aquí
                } else {
                    // Mostrar un mensaje de error si el correo electrónico o la contraseña están vacíos
                    Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}


