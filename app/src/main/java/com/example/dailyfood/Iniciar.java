package com.example.dailyfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Iniciar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Iniciar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Iniciar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment iniciar.
     */
    // TODO: Rename and change types and number of parameters
    public static Iniciar newInstance(String param1, String param2) {
        Iniciar fragment = new Iniciar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //public void iniciarSesion(View v){
        /*
        EditText email = requireActivity().findViewById(R.id.inputEmail);
        String inputEmail = email.getText().toString();
        EditText contrasenia = requireActivity().findViewById(R.id.inputPassword);
        String inputPassword = contrasenia.getText().toString();
        if(email.equals("abc") && contrasenia.equals("123")){
            //ejecutar funcion para cambiar de activity
        }else{
            Toast.makeText(this,"Error en las credenciales",Toast.LENGTH_SHORT).show();
        }
        */
    //    Intent i = new Intent((), Principal.class);
    //    startActivity(i);
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar, container, false);
    }
}