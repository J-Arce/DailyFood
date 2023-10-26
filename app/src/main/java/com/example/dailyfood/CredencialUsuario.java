package com.example.dailyfood;

public class CredencialUsuario {
    private String email;
    private String contrasenia;

    public CredencialUsuario(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }

    // Getter para el email
    public String getEmail() {
        return email;
    }

    // Setter para el email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter para la contraseña
    public String getContrasenia() {
        return contrasenia;
    }

    // Setter para la contraseña
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
