package com.example.dailyfood;

public class CredencialUsuario {
    private String email;
    private String contrasenia;

    public CredencialUsuario(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
