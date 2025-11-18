package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios.
 * Cumple con estándares de calidad y Checkstyle.
 */
public class UserRegistrationService {

    /** Longitud mínima de la contraseña. */
    private static final int MIN_PWD_LEN = 8;

    /** Almacena el último mensaje de error. */
    private String lastErrorMessage = "";

    /** Lista de usuarios registrados. */
    private final List<String> users = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public UserRegistrationService() {
        // Lógica innecesaria eliminada
    }

    /**
     * Registra un nuevo usuario validando sus datos.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @param email Correo electrónico.
     * @return true si el registro fue exitoso.
     */
    public boolean registerUser(final String username,
                                final String password,
                                final String email) {

        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El usuario está vacío.";
            return false;
        }

        if (password == null || password.length() < MIN_PWD_LEN) {
            lastErrorMessage = "Password inválido.";
            return false;
        }

        if (email == null || !email.contains("@") || !email.contains(".")) {
            lastErrorMessage = "Correo inválido.";
            return false;
        }

        try {
            saveUser(username);
        } catch (IllegalArgumentException e) {
            lastErrorMessage = e.getMessage();
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Simula guardar usuario.
     *
     * @param username Usuario a guardar.
     */
    private void saveUser(final String username) {
        if ("error".equals(username)) {
            throw new IllegalArgumentException("Usuario no permitido.");
        }
        users.add(username);
    }

    /**
     * Cuenta caracteres.
     *
     * @param text Texto a analizar.
     * @return Longitud o -1 si es nulo.
     */
    public int countCharacters(final String text) {
        if (text == null) {
            return -1;
        }
        return text.length();
    }

    /**
     * Obtiene el último error.
     *
     * @return Mensaje de error.
     */
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
