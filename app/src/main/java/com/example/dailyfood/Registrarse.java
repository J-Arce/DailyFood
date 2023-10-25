package com.example.dailyfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log; // Importa Log
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registrarse extends Fragment {

    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;

    private EditText email;
    private EditText password;
    private Button btnRegistrarse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrarse, container, false);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        email = view.findViewById(R.id.textEmailRegistrarse);
        password = view.findViewById(R.id.textCrearPassword);
        btnRegistrarse = view.findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();

                if (emailUser.isEmpty() || passUser.isEmpty()){
                    Toast.makeText(getActivity(), "Complete los datos", Toast.LENGTH_SHORT).show();
                } else {
                    registrarUsuario(emailUser, passUser);
                }
            }
        });

        return view;
    }

    private void registrarUsuario(String emailUser, String passUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = mAuth.getCurrentUser().getUid();
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", id);
                    map.put("email", emailUser);
                    map.put("password", passUser);

                    mFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Intent intent = new Intent(getActivity(), Principal.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("FirebaseError", "Error al guardar en Firestore: " + e.getMessage()); // Registra el error en Log
                            Toast.makeText(getActivity(), "Error al guardar en Firestore", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Log.d("FirebaseError", "Error al registrar en Firebase: " + task.getException().getMessage()); // Registra el error en Log
                    Toast.makeText(getActivity(), "Error al registrar en Firebase", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

